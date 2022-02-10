package com_sjziei_smis_Dao.impl;

import com_sjziei_smis_DBConnection.DBConnection;
import com_sjziei_smis_Dao.StudentDao;
import com_sjziei_smis_entity.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//接口的实现方法
public class    StudentDaoImpl implements StudentDao {
    private DBConnection dbc;
    private Connection conn;
    private PreparedStatement prst;
    private ResultSet rs;
    @Override
    public boolean addStudents(Student student) {
        //添加学生方法的实现
        dbc = new DBConnection();
        conn = dbc.getConn();
        String aql = "insert into students values(null,?,?,?,?,?,?,?,?,?)";
        try{
            prst = conn.prepareStatement(aql);
            //设置问号
            prst.setString(1,student.getName());
            prst.setString(2, student.getSex());
            prst.setDate(3,student.getBirthday());
            prst.setString(4,student.getCode());
            prst.setString(5,student.getIDcard());
            prst.setString(6, student.getNation());
            prst.setString(7, student.getAddress());
            prst.setString(8, student.getTel());
            prst.setString(9, student.getSchool());
            int result = prst.executeUpdate();
            if (result > 0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (prst != null){
                try {
                    prst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            dbc.close();
        }
        return false;
    }

    @Override
    public boolean deleteStudentById(int id) {
        //删除学生的实现方法
        dbc = new DBConnection();
        conn = dbc.getConn();
        String sql = "delete from students where id = ?";
        try{
            prst = conn.prepareStatement(sql);
            prst.setInt(1,id);
            int result = prst.executeUpdate();
            if (result > 0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (prst != null){
                try {
                    prst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            dbc.close();
        }
        return false;
    }

    @Override
    public boolean updateStudent(int id, Student student) {
        //更新数据
        dbc = new DBConnection();
        conn = dbc.getConn();
        String sql = "update students set name = ?,sex = ?,Birthday = ?," +
                " code = ?,idcard = ?,nation = ?,address = ?,tel = ?,school = ? where Id =?";
        try{
            prst = conn.prepareStatement(sql);
            prst.setString(2,student.getName());
            prst.setString(3, student.getSex());
            prst.setDate(4,student.getBirthday());
            prst.setString(5,student.getCode());
            prst.setString(6,student.getIDcard());
            prst.setString(7, student.getNation());
            prst.setString(8, student.getAddress());
            prst.setString(9, student.getTel());
            prst.setString(10, student.getSchool());
            prst.setInt(10,id);
            int result = prst.executeUpdate();
            if (result > 0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (prst != null){
                try {
                    prst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            dbc.close();
        }
        return false;
    }

    @Override
    public Student queryStudentsById(int id) {
        //查询学生信息
        dbc = new DBConnection();
        conn = dbc.getConn();
        String sql = "select * from students where id=?)";
        Student student = null;//未查到返回空
        try{
            prst = conn.prepareStatement(sql);
            prst.setInt(1,id);
            prst.executeQuery();
            if (rs.next()){
                //实例化Student对象student将每个值查出来
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setBirthday(rs.getDate("Birthday"));
                student.setCode(rs.getString("code"));
                student.setIDcard(rs.getString("idcard"));
                student.setNation(rs.getString("nation"));
                student.setAddress(rs.getString("address"));
                student.setSchool(rs.getString("school"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (prst != null){
                try {
                    prst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            dbc.close();
        }
        return student;
    }

    @Override
    public List<Student> queryALLStudent() {
        dbc = new DBConnection();
        conn = dbc.getConn();
        String sql = "select * from students)";
        Student student = null;//未查到返回空
        List<Student> list = new ArrayList<Student>();
        try{
            prst = conn.prepareStatement(sql);
            prst.executeQuery();
            while (rs.next()){
                //实例化Student对象student将每个值查出来
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setBirthday(rs.getDate("Birthday"));
                student.setCode(rs.getString("code"));
                student.setIDcard(rs.getString("idcard"));
                student.setNation(rs.getString("nation"));
                student.setAddress(rs.getString("address"));
                student.setSchool(rs.getString("school"));
                list.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (prst != null){
                try {
                    prst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            dbc.close();
        }
        return list;
    }

}
