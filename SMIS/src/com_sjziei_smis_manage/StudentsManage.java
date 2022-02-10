package com_sjziei_smis_manage;//学生管理系统

import com_sjziei_smis_Dao.StudentDao;
import com_sjziei_smis_Dao.impl.StudentDaoImpl;
import com_sjziei_smis_entity.Student;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class StudentsManage {
    private Scanner sc = new Scanner(System.in);

    public StudentsManage() {
        this.manage();
    }

    public void manage() {
        while (true) {
            this.getMenu();
            int num = sc.nextInt();
            //Switch匹配数字做什么
            switch (num) {
                case 1:
                    this.addStudents();
                    break;
                case 2:
                    this.updateStudents();
                    break;
                case 3:
                    this.deleteStudentsById();
                    break;
                case 4:
                    this.queryAllStudents();
                    break;
                case 5:
                    this.queryStudentsById();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("只能输入操作数0-5");
            }
        }
    }
    //死循环的菜单
    public boolean getMenu() {
        System.out.println("|----------学生管理信息version1.0----------|");
        System.out.println("|------------------菜单-------------------|");
        System.out.println("|--------------按1:录入学生信息-------------|");
        System.out.println("|--------------按2:按id查询修改学生信息------|");
        System.out.println("|--------------按3:按id删除学生信息--------- |");
        System.out.println("|--------------按4:查询全部学生信息----------|");
        System.out.println("|--------------按5:按id查询学生信息----------|");
        System.out.println("|---------------按0:退出学生管理操作---------|");
        return false;
    }

    //Switch里对应的一系列方法，下列方法都在switch里调用
    public void addStudents(){
        System.out.println("请录入学生信息");
        Student student = new Student();
        System.out.println("姓名:");
        student.setName(sc.next());
        System.out.println("性别");
        student.setSex(sc.next());
        System.out.println("生日:'请按照xxxx-xx-xx格式录入日期'");
        student.setBirthday(Date.valueOf(sc.next()));//匹配字符传为日期类型
        System.out.println("学号");
        student.setCode(sc.next());
        System.out.println("身份证号");
        student.setIDcard(sc.next());
        System.out.println("民族");
        student.setNation(sc.next());
        System.out.println("家庭地址");
        student.setAddress(sc.next());
        System.out.println("联系电话");
        student.setNation(sc.next());
        System.out.println("毕业学校");
        student.setSchool(sc.next());
        //调用StudentDao接口
        StudentDao studentDao = new StudentDaoImpl();
        boolean result = studentDao.addStudents(student);
        if (result){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    public void updateStudents(){   //按照id查(先做查询)，有人改无人不改
        System.out.println("请输入要更新的学生id: ");
        int id = sc.nextInt();
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.queryStudentsById(id);
        if (student == null){
            System.out.println("没有id为" + id + "的学生" );
            return;

        }else{
            System.out.println("姓名:" + student.getName());
            System.out.println("性别:" + student.getSex());
            System.out.println("生日:" + student.getBirthday());
            System.out.println("学号:" + student.getCode());
            System.out.println("身份证号:" + student.getIDcard());
            System.out.println("民族:" + student.getNation());
            System.out.println("家庭地址:" + student.getAddress());
            System.out.println("联系电话:" + student.getTel());
            System.out.println("毕业学校:" + student.getSchool());

            System.out.println("请修改学生信息");
            System.out.println("姓名:");
            student.setName(sc.next());
            System.out.println("性别");
            student.setSex(sc.next());
            System.out.println("生日:'请按照xxxx-xx-xx格式录入日期'");
            student.setBirthday(Date.valueOf(sc.next()));//匹配字符传为日期类型
            System.out.println("学号");
            student.setCode(sc.next());
            System.out.println("身份证号");
            student.setIDcard(sc.next());
            System.out.println("民族");
            student.setNation(sc.next());
            System.out.println("家庭地址");
            student.setAddress(sc.next());
            System.out.println("联系电话");
            student.setNation(sc.next());
            System.out.println("毕业学校");
            student.setSchool(sc.next());
            boolean result = studentDao.addStudents(student);
            if (result){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        }
    }

    public void deleteStudentsById(){
        System.out.println("请输入要删除的学生id: ");
        int id = sc.nextInt();
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.queryStudentsById(id);
        if (student == null) {
            System.out.println("没有id为" + id + "的学生");
            return;
        }
        System.out.println(student);
        System.out.println("确认是否删除y/n");
        String flag = sc.next();
        if (flag.equals("n")){
            System.out.println("没有删除");
            return;
        }
        boolean result = studentDao.deleteStudentById(id);
        if (result){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    public void queryAllStudents(){
        //查找全体学生
        StudentDao studentDao = new StudentDaoImpl();//实例化接口对象向下指向它的实现方法Daoimpl
        List<Student> list = studentDao.queryALLStudent();
        if (list.size() == 0){
            System.out.println("暂时没有学生记录");
            return;//结束方法
        }
        for (Student student : list){
            System.out.println(student);
        }
    }
    public void queryStudentsById(){
        //根据id查询学生信息
        System.out.println("请输入要查询的学生id: ");
        int id = sc.nextInt();
        StudentDao studentDao = new StudentDaoImpl();
        Student student = studentDao.queryStudentsById(id);
        if (student == null){
            System.out.println("没有id为" + id + "的学生" );
            return;

        }else {
            System.out.println("姓名:" + student.getName());
            System.out.println("性别:" + student.getSex());
            System.out.println("生日:" + student.getBirthday());
            System.out.println("学号:" + student.getCode());
            System.out.println("身份证号:" + student.getIDcard());
            System.out.println("民族:" + student.getNation());
            System.out.println("家庭地址:" + student.getAddress());
            System.out.println("联系电话:" + student.getTel());
            System.out.println("毕业学校:" + student.getSchool());

        }
    }
}
