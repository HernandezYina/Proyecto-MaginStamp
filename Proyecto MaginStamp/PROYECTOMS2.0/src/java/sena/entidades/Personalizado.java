/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "personalizado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personalizado.findAll", query = "SELECT p FROM Personalizado p")
    , @NamedQuery(name = "Personalizado.findByIdPersonalizado", query = "SELECT p FROM Personalizado p WHERE p.idPersonalizado = :idPersonalizado")
    , @NamedQuery(name = "Personalizado.findByFecha", query = "SELECT p FROM Personalizado p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Personalizado.findByCantidad", query = "SELECT p FROM Personalizado p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Personalizado.findByTalla", query = "SELECT p FROM Personalizado p WHERE p.talla = :talla")
    , @NamedQuery(name = "Personalizado.findByTipoCamisa", query = "SELECT p FROM Personalizado p WHERE p.tipoCamisa = :tipoCamisa")
    , @NamedQuery(name = "Personalizado.findByColor", query = "SELECT p FROM Personalizado p WHERE p.color = :color")
    , @NamedQuery(name = "Personalizado.findByDetalles", query = "SELECT p FROM Personalizado p WHERE p.detalles = :detalles")
    , @NamedQuery(name = "Personalizado.findByDisenioCliente", query = "SELECT p FROM Personalizado p WHERE p.disenioCliente = :disenioCliente")
    , @NamedQuery(name = "Personalizado.findByDisenioClienteTrasero", query = "SELECT p FROM Personalizado p WHERE p.disenioClienteTrasero = :disenioClienteTrasero")})
public class Personalizado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPersonalizado")
    private Integer idPersonalizado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Size(max = 45)
    @Column(name = "talla")
    private String talla;
    @Size(max = 45)
    @Column(name = "tipoCamisa")
    private String tipoCamisa;
    @Size(max = 45)
    @Column(name = "color")
    private String color;
    @Size(max = 500)
    @Column(name = "detalles")
    private String detalles;
    @Size(max = 500)
    @Column(name = "disenioCliente")
    private String disenioCliente;
    @Size(max = 500)
    @Column(name = "disenioClienteTrasero")
    private String disenioClienteTrasero;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario idUsuario;

    public Personalizado() {
    }

    public Personalizado(Integer idPersonalizado) {
        this.idPersonalizado = idPersonalizado;
    }

    public Personalizado(Integer idPersonalizado, int cantidad) {
        this.idPersonalizado = idPersonalizado;
        this.cantidad = cantidad;
    }

    public Integer getIdPersonalizado() {
        return idPersonalizado;
    }

    public void setIdPersonalizado(Integer idPersonalizado) {
        this.idPersonalizado = idPersonalizado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getTipoCamisa() {
        return tipoCamisa;
    }

    public void setTipoCamisa(String tipoCamisa) {
        this.tipoCamisa = tipoCamisa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getDisenioCliente() {
        return disenioCliente;
    }

    public void setDisenioCliente(String disenioCliente) {
        this.disenioCliente = disenioCliente;
    }

    public String getDisenioClienteTrasero() {
        return disenioClienteTrasero;
    }

    public void setDisenioClienteTrasero(String disenioClienteTrasero) {
        this.disenioClienteTrasero = disenioClienteTrasero;
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
        hash += (idPersonalizado != null ? idPersonalizado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personalizado)) {
            return false;
        }
        Personalizado other = (Personalizado) object;
        if ((this.idPersonalizado == null && other.idPersonalizado != null) || (this.idPersonalizado != null && !this.idPersonalizado.equals(other.idPersonalizado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sena.entidades.Personalizado[ idPersonalizado=" + idPersonalizado + " ]";
    }
    
}
