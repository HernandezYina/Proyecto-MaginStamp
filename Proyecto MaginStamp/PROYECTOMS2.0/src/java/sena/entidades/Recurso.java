/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.entidades;

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
 * @author User
 */
@Entity
@Table(name = "recurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recurso.findAll", query = "SELECT r FROM Recurso r")
    , @NamedQuery(name = "Recurso.findByIdRecurso", query = "SELECT r FROM Recurso r WHERE r.idRecurso = :idRecurso")
    , @NamedQuery(name = "Recurso.findByImgPNG", query = "SELECT r FROM Recurso r WHERE r.imgPNG = :imgPNG")
    , @NamedQuery(name = "Recurso.findByImgJPG", query = "SELECT r FROM Recurso r WHERE r.imgJPG = :imgJPG")
    , @NamedQuery(name = "Recurso.findByImgVECTORIAL", query = "SELECT r FROM Recurso r WHERE r.imgVECTORIAL = :imgVECTORIAL")
    , @NamedQuery(name = "Recurso.findByTipografia", query = "SELECT r FROM Recurso r WHERE r.tipografia = :tipografia")})
public class Recurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRecurso")
    private Integer idRecurso;
    @Size(max = 300)
    @Column(name = "imgPNG")
    private String imgPNG;
    @Size(max = 45)
    @Column(name = "imgJPG")
    private String imgJPG;
    @Size(max = 45)
    @Column(name = "imgVECTORIAL")
    private String imgVECTORIAL;
    @Size(max = 45)
    @Column(name = "tipografia")
    private String tipografia;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario idUsuario;

    public Recurso() {
    }

    public Recurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Integer getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getImgPNG() {
        return imgPNG;
    }

    public void setImgPNG(String imgPNG) {
        this.imgPNG = imgPNG;
    }

    public String getImgJPG() {
        return imgJPG;
    }

    public void setImgJPG(String imgJPG) {
        this.imgJPG = imgJPG;
    }

    public String getImgVECTORIAL() {
        return imgVECTORIAL;
    }

    public void setImgVECTORIAL(String imgVECTORIAL) {
        this.imgVECTORIAL = imgVECTORIAL;
    }

    public String getTipografia() {
        return tipografia;
    }

    public void setTipografia(String tipografia) {
        this.tipografia = tipografia;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecurso != null ? idRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recurso)) {
            return false;
        }
        Recurso other = (Recurso) object;
        if ((this.idRecurso == null && other.idRecurso != null) || (this.idRecurso != null && !this.idRecurso.equals(other.idRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sena.entidades.Recurso[ idRecurso=" + idRecurso + " ]";
    }
    
}
