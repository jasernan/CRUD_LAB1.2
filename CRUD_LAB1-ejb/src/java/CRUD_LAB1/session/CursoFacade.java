/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_LAB1.session;

import CRUD_LAB1.entity.Curso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author julia
 */
@Stateless
public class CursoFacade extends AbstractFacade<Curso> implements CursoFacadeLocal {

    @PersistenceContext(unitName = "CRUD_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursoFacade() {
        super(Curso.class);
    }
    
    @Override
    public void addCurso(Curso curso) {
        em.persist(curso);
    }

    @Override
    public void editCurso(Curso curso) {
        em.merge(curso);
    }

    @Override
    public void deleteCurso(int codigoCurso) {
        em.remove(getCurso(codigoCurso));
    }
    
    @Override
    public Curso getCurso(int codigoCurso) {
        return em.find(Curso.class, codigoCurso);
    }
    
    @Override
    public List<Curso> getAllcursos() {
        return em.createNamedQuery("Curso.getAll").getResultList();
    }
}
