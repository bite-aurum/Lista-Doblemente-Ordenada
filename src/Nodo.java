public class Nodo {

    int dato;
    Nodo siguiente;
    Nodo anterior;
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}