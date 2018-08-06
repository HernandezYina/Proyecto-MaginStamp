/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author User
 */
@Entity
@Table(name = "cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c")
    , @NamedQuery(name = "Cotizacion.findByIdCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.idCotizacion = :idCotizacion")
    , @NamedQuery(name = "Cotizacion.findByNombres", query = "SELECT c FROM Cotizacion c WHERE c.nombres = :nombres")
    , @NamedQuery(name = "Cotizacion.findByApellidos", query = "SELECT c FROM Cotizacion c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "Cotizacion.findByEmail", query = "SELECT c FROM Cotizacion c WHERE c.email = :email")
    , @NamedQuery(name = "Cotizacion.findByFecha", query = "SELECT c FROM Cotizacion c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Cotizacion.findByCantidad", query = "SELECT c FROM Cotizacion c WHERE c.cantidad = :cantidad")
    , @NamedQuery(name = "Cotizacion.findByDetalles", query = "SELECT c FROM Cotizacion c WHERE c.detalles = :detalles")
    , @NamedQuery(name = "Cotizacion.findByDisenioCliente", query = "SELECT c FROM Cotizacion c WHERE c.disenioCliente = :disenioCliente")})
public class Cotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCotizacion")
    private Integer idCotizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "detalles")
    private String detalles;
    @Size(max = 500)
    @Column(name = "disenioCliente")
    private String disenioCliente;
    @OneToMany(mappedBy = "idCotizacion", fetch = FetchType.EAGER)
    private List<Mensaje> mensajeList;

    public Cotizacion() {
    }

    public Cotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Cotizacion(Integer idCotizacion, String nombres, String apellidos, String email, int cantidad, String detalles) {
        this.idCotizacion = idCotizacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.cantidad = cantidad;
        this.detalles = detalles;
    }

    public Integer getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @XmlTransient
    @JsonIgnore
    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotizacion != null ? idCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.idCotizacion == null && other.idCotizacion != null) || (this.idCotizacion != null && !this.idCotizacion.equals(other.idCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sena.entidades.Cotizacion[ idCotizacion=" + idCotizacion + " ]";
    }
    
}
