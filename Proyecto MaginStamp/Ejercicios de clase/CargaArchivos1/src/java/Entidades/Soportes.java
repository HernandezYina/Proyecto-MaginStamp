/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JohanOrtiz
 */
@Entity
@Table(name = "soportes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soportes.findAll", query = "SELECT s FROM Soportes s")
    , @NamedQuery(name = "Soportes.findByIdsoportes", query = "SELECT s FROM Soportes s WHERE s.idsoportes = :idsoportes")
    , @NamedQuery(name = "Soportes.findByCedula", query = "SELECT s FROM Soportes s WHERE s.cedula = :cedula")
    , @NamedQuery(name = "Soportes.findByDiplomaPregrado", query = "SELECT s FROM Soportes s WHERE s.diplomaPregrado = :diplomaPregrado")
    , @NamedQuery(name = "Soportes.findByExperiencia1", query = "SELECT s FROM Soportes s WHERE s.experiencia1 = :experiencia1")
    , @NamedQuery(name = "Soportes.findByExperiencia2", query = "SELECT s FROM Soportes s WHERE s.experiencia2 = :experiencia2")})
public class Soportes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsoportes")
    private Integer idsoportes;
    @Size(max = 60)
    @Column(name = "Cedula")
    private String cedula;
    @Size(max = 60)
    @Column(name = "diplomaPregrado")
    private String diplomaPregrado;
    @Size(max = 60)
    @Column(name = "experiencia1")
    private String experiencia1;
    @Size(max = 60)
    @Column(name = "experiencia2")
    private String experiencia2;
    @JoinColumn(name = "Empleado_idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleadoidEmpleado;

    public Soportes() {
    }

    public Soportes(Integer idsoportes) {
        this.idsoportes = idsoportes;
    }

    public Integer getIdsoportes() {
        return idsoportes;
    }

    public void setIdsoportes(Integer idsoportes) {
        this.idsoportes = idsoportes;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDiplomaPregrado() {
        return diplomaPregrado;
    }

    public void setDiplomaPregrado(String diplomaPregrado) {
        this.diplomaPregrado = diplomaPregrado;
    }

    public String getExperiencia1() {
        return experiencia1;
    }

    public void setExperiencia1(String experiencia1) {
        this.experiencia1 = experiencia1;
    }

    public String getExperiencia2() {
        return experiencia2;
    }

    public void setExperiencia2(String experiencia2) {
        this.experiencia2 = experiencia2;
    }

    public Empleado getEmpleadoidEmpleado() {
        return empleadoidEmpleado;
    }

    public void setEmpleadoidEmpleado(Empleado empleadoidEmpleado) {
        this.empleadoidEmpleado = empleadoidEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsoportes != null ? idsoportes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soportes)) {
            return false;
        }
        Soportes other = (Soportes) object;
        if ((this.idsoportes == null && other.idsoportes != null) || (this.idsoportes != null && !this.idsoportes.equals(other.idsoportes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Soportes[ idsoportes=" + idsoportes + " ]";
    }
    
}
