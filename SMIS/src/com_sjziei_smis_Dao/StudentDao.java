package com_sjziei_smis_Dao;
import com_sjziei_smis_entity.Student;
import java.util.List;


public interface StudentDao {
    /**
     *添加学生
     * @param student
     * @return boolean 是否完成此次插入记录成功true失败false
     */
    public boolean addStudents(Student student);

    /**
     * 根据id删除学生
     * @param id
     * @return 是否完成此次删除记录成功true失败false
     */
    public boolean deleteStudentById(int id);

    /**
     * 根据id查询并更新学生信息
     * @param id
     * @param student 需要更新的学生信息
     * @return 是否完成此次更新记录成功true失败false
     */
    public boolean updateStudent(int id, Student student);

    /**
     * 按id查询学生信息
     * @param id
     * @return 查询到的学生信息，返回学生对象，查无此人返回null。
     */
    public Student queryStudentsById(int id);

    /**
     * 查询全部学生信息
     * @return 返回list对象里面放学生信息
     */
    public List<Student> queryALLStudent();
}
