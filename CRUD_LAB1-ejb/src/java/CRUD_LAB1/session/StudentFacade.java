/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_LAB1.session;

import CRUD_LAB1.entity.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author julia
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> implements StudentFacadeLocal {

    @PersistenceContext(unitName = "CRUD_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    
    
    public StudentFacade() {
        super(Student.class);
    }

    @Override
    public void addStudent(Student student) {
        em.persist(student);
    }

    @Override
    public void editstudent(Student student) {
        em.merge(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        em.remove(getStudent(studentId));
    }

    @Override
    public Student getStudent(int studentId) {
        return em.find(Student.class, studentId);
    }

    @Override
    public List<Student> getAllstudents() {
        return em.createNamedQuery("Student.getAll").getResultList();
    }
    
}
