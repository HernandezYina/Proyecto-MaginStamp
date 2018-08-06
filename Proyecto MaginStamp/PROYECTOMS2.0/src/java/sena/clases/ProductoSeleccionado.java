/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.clases;

import sena.entidades.Producto;

/**
 *
 * @author User
 */
public class ProductoSeleccionado {

    private Producto producto;
    private int cantidad;
    private String talla;
    private String genero;

    public ProductoSeleccionado() {
    }

    public ProductoSeleccionado(Producto producto, int cantidad, String talla, String genero) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.talla = talla;
        this.genero = genero;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
