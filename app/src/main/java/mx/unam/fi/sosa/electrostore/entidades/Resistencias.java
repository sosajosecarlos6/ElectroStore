package mx.unam.fi.sosa.electrostore.entidades;

public class Resistencias {

    private int valor;
    private int cantidad;

    public Resistencias(int valor, int cantidad) {
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
