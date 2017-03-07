package com.ptteng.dao;

import com.ptteng.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by maweijiang on 2017/3/6.
 */
@Component
public interface StudentDao {

    public List<Student> getAllStudents();

    public Student findStudentById(int id);

    public List<Student> findAllGoodStudent();

    public Student findStudentByPhone(long phone);

    public int deleteStudentById(int id);

    public int addStudent(Student stu);

    public int updateStudent(Student stu);
}
