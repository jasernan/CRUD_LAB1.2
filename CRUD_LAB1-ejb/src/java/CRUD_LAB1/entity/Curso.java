/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_LAB1.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.getAll", query = "SELECT c FROM Curso c"),
   // @NamedQuery(name = "Curso.findByCodigoCurso", query = "SELECT c FROM Curso c WHERE c.codigoCurso = :codigoCurso"),
  //  @NamedQuery(name = "Curso.findByNombreCurso", query = "SELECT c FROM Curso c WHERE c.nombreCurso = :nombreCurso"),
  //  @NamedQuery(name = "Curso.findByNumeroCreditos", query = "SELECT c FROM Curso c WHERE c.numeroCreditos = :numeroCreditos"),
   // @NamedQuery(name = "Curso.findBySemestre", query = "SELECT c FROM Curso c WHERE c.semestre = :semestre"),
    @NamedQuery(name = "Curso.findByNumeroEstudiantesAdmitidos", query = "SELECT c FROM Curso c WHERE c.numeroEstudiantesAdmitidos = :numeroEstudiantesAdmitidos")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CURSO")
    private Integer codigoCurso;
    @Size(max = 50)
    @Column(name = "NOMBRE_CURSO")
    private String nombreCurso;
    @Column(name = "NUMERO_CREDITOS")
    private Integer numeroCreditos;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "NUMERO_ESTUDIANTES_ADMITIDOS")
    private Integer numeroEstudiantesAdmitidos;

    public Curso() {
    }

    public Curso(Integer codigoCurso, String nombreCurso, Integer numeroCreditos, Integer semestre, Integer numeroEstudiantesAdmitidos) {
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.numeroCreditos = numeroCreditos;
        this.semestre = semestre;
        this.numeroEstudiantesAdmitidos = numeroEstudiantesAdmitidos;
    }

    

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getNumeroEstudiantesAdmitidos() {
        return numeroEstudiantesAdmitidos;
    }

    public void setNumeroEstudiantesAdmitidos(Integer numeroEstudiantesAdmitidos) {
        this.numeroEstudiantesAdmitidos = numeroEstudiantesAdmitidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCurso != null ? codigoCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codigoCurso == null && other.codigoCurso != null) || (this.codigoCurso != null && !this.codigoCurso.equals(other.codigoCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CRUD_LAB1.entity.Curso[ codigoCurso=" + codigoCurso + " ]";
    }
    
}
