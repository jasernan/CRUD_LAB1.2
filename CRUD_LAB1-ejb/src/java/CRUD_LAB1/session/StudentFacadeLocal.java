/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_LAB1.session;

import CRUD_LAB1.entity.Student;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author julia
 */
@Local
public interface StudentFacadeLocal {

    void create(Student student);

    void edit(Student student);

    void remove(Student student);

    Student find(Object id);

    List<Student> findAll();

    List<Student> findRange(int[] range);

    int count();

    void addStudent(Student student);

    void editstudent(Student student);

    void deleteStudent(int studentId);

    Student getStudent(int studentId);

    List<Student> getAllstudents();
    
}
