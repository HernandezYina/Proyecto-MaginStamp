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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "factura_has_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaHasProducto.findAll", query = "SELECT f FROM FacturaHasProducto f")
    , @NamedQuery(name = "FacturaHasProducto.findByIdDetalle", query = "SELECT f FROM FacturaHasProducto f WHERE f.idDetalle = :idDetalle")
    , @NamedQuery(name = "FacturaHasProducto.findByCantidad", query = "SELECT f FROM FacturaHasProducto f WHERE f.cantidad = :cantidad")
    , @NamedQuery(name = "FacturaHasProducto.findByDireccion", query = "SELECT f FROM FacturaHasProducto f WHERE f.direccion = :direccion")})
public class FacturaHasProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalle")
    private Integer idDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "idFactura", referencedColumnName = "idFactura")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Factura idFactura;
    @JoinColumn(name = "idproducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto idproducto;

    public FacturaHasProducto() {
    }

    public FacturaHasProducto(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public FacturaHasProducto(Integer idDetalle, int cantidad, String direccion) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.direccion = direccion;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaHasProducto)) {
            return false;
        }
        FacturaHasProducto other = (FacturaHasProducto) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sena.entidades.FacturaHasProducto[ idDetalle=" + idDetalle + " ]";
    }
    
}
