/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_LAB1.session;

import CRUD_LAB1.entity.Curso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author julia
 */
@Local
public interface CursoFacadeLocal {

    void create(Curso curso);

    void edit(Curso curso);

    void remove(Curso curso);

    Curso find(Object id);

    List<Curso> findAll();

    List<Curso> findRange(int[] range);

    int count();
    
    void addCurso(Curso curso);

    void editCurso(Curso curso);

    void deleteCurso(int codigoCurso);
    
    Curso getCurso(int codigoCurso);

    List<Curso> getAllcursos();
}
