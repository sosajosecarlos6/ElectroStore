package mx.unam.fi.sosa.electrostore.entidades;

import java.io.Serializable;

public class Resistencias implements Serializable{

    private String valor;
    private String cantidad;

    public Resistencias() {
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
