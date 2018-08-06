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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "hoja_de_vida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HojaDeVida.findAll", query = "SELECT h FROM HojaDeVida h")
    , @NamedQuery(name = "HojaDeVida.findByCedula", query = "SELECT h FROM HojaDeVida h WHERE h.cedula = :cedula")
    , @NamedQuery(name = "HojaDeVida.findByDiplomaPregado", query = "SELECT h FROM HojaDeVida h WHERE h.diplomaPregado = :diplomaPregado")
    , @NamedQuery(name = "HojaDeVida.findByExperiencia01", query = "SELECT h FROM HojaDeVida h WHERE h.experiencia01 = :experiencia01")
    , @NamedQuery(name = "HojaDeVida.findByExperiencia02", query = "SELECT h FROM HojaDeVida h WHERE h.experiencia02 = :experiencia02")})
public class HojaDeVida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private Integer cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "diplomaPregado")
    private String diplomaPregado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "experiencia01")
    private String experiencia01;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "experiencia02")
    private String experiencia02;

    public HojaDeVida() {
    }

    public HojaDeVida(Integer cedula) {
        this.cedula = cedula;
    }

    public HojaDeVida(Integer cedula, String diplomaPregado, String experiencia01, String experiencia02) {
        this.cedula = cedula;
        this.diplomaPregado = diplomaPregado;
        this.experiencia01 = experiencia01;
        this.experiencia02 = experiencia02;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getDiplomaPregado() {
        return diplomaPregado;
    }

    public void setDiplomaPregado(String diplomaPregado) {
        this.diplomaPregado = diplomaPregado;
    }

    public String getExperiencia01() {
        return experiencia01;
    }

    public void setExperiencia01(String experiencia01) {
        this.experiencia01 = experiencia01;
    }

    public String getExperiencia02() {
        return experiencia02;
    }

    public void setExperiencia02(String experiencia02) {
        this.experiencia02 = experiencia02;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HojaDeVida)) {
            return false;
        }
        HojaDeVida other = (HojaDeVida) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.HojaDeVida[ cedula=" + cedula + " ]";
    }
    
}
