public class listadoble {

    private int tamanio;
    private Nodo cabeza;
    private Nodo cola;
    // constructor de la lista doble
    public listadoble(){
        tamanio=0;
        cabeza=null;
        cola=null;

    }
    //verificacion de si la lista esta vacia
    public boolean estaVacia(){
        if(cabeza==null && cola==null){// revisa la cabeza y la cola si son nulas
            return true;
        }
        else{
            return false;
        }
    }

    public int getTamanio() {
        return tamanio;// mide el tamaño de la lista
    }

    //buscar por medio de un valor

    public boolean Buscar(int x){
        if(estaVacia())
            return false;
        Nodo aux=cabeza;
        while (aux!=null){
            if(aux.getDato()==x){
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;

    }
    // actualizar un dato en la lista
    public void actualizar(int dato, int pos){
        Nodo aux = obtenerNodo(pos);
        aux.setDato(dato);
    }
    // insertar al inicio
    public void insertarAlInicio(int dato){
        Nodo nuevo= new Nodo(dato);
        if (estaVacia()){// primero se revisa si esta vacia
            cabeza=nuevo;
            cola=nuevo;
            tamanio++;
        }
        else {// en caso de que no pasa la cabeza al que se ingreso
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza=nuevo;
            tamanio++;
        }
    }
    // busca el nodo
    public Nodo obtenerNodo(int pos){
        if(pos<=0 || pos>tamanio){ // revisa si la posicion no es cero y si la posicion no es mas grande
            //que el tamaño en caso  de que se cumpla manda esa exepcion
            throw new IllegalStateException("posicion invalida"+ pos + "rango valido es de 1 a"+tamanio);
        }
        Nodo aux=cabeza;
        for (int i=0; i<pos; i++){
            aux=aux.getSiguiente();// va buscando asta que encuentre el nodo
        }
        return aux;
    }
    @Override
    public String toString(){// imprime
        String res="null <-";
        Nodo aux=cabeza;
        while(aux !=null){
            res=res+"<-["+aux.getDato()+"]->";
            aux=aux.getSiguiente();
        }
        res=res+"null";
        return res;
    }
    public int eliminarAlInicio(){//
        if (estaVacia()){
            throw  new IllegalStateException("la lista esta vacia");
        }
        int dato= cabeza.getDato();
        if (cabeza==cola){// en caso de que solo hay un regsitro ps los manda a nulo
            cabeza=null;
            cola= null;
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.getAnterior().setSiguiente(null);
            cabeza.setAnterior(null);
        }
        tamanio--;
        return dato;
    }
    public boolean insertarEnPosicion(int pos, int dato) {

        if (pos < 0 || pos > tamanio) {
            System.out.println("Posicion fuera de rango.");
            return false;
        }

        Nodo nuevo = new Nodo(dato);

        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        }
        else if (pos == 0) {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
        else if (pos == tamanio) {
            nuevo.anterior = cola;
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        else {
            Nodo actual = cabeza;
            for (int i = 0; i < pos; i++) {
                actual = actual.siguiente;
            }
            Nodo previo = actual.anterior;

            nuevo.anterior = previo;
            nuevo.siguiente = actual;
            previo.siguiente = nuevo;
            actual.anterior = nuevo;
        }

        tamanio++;
        return true;
    }
    public boolean eliminarPorValor(int dato){
        if(estaVacia())
            return false;
        Nodo aux=cabeza;  //[|na=c=10|] [10] [20] [30]
        while (aux!=null){  // mientras no sea diferente de nulo va a seguir
            if(aux.getDato()==dato){  // en el avance se busca el dato y si es igual lo elimina
                if (aux== cabeza && aux == cola) {
                    cabeza = null;
                    cola = null;
                }
                else if(aux==cabeza){
                    cabeza = aux.getSiguiente();
                    cabeza.setAnterior(null);
                }
                else if(aux == cola){
                    cola= aux.getAnterior();
                    cola.setSiguiente(null);

                }
                else {//para saltar el dato
                    aux.getAnterior().setSiguiente(aux.getSiguiente());
                    aux.getSiguiente().setAnterior(aux.getAnterior());

                }

                tamanio--;
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;



    }
    public boolean eliminarUltimo() {// elimina el ultimo elemento de la lsita
        if (estaVacia()) {
            return  false;
        }
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {// empieza a soltarse de cada uno asta que ya no es accesible
            cola = cola.getAnterior();
            cola.getSiguiente().setAnterior(null);
            cola.setSiguiente(null);
        }
        tamanio--;
        return true;
    }
    public boolean insertarOrdenado(int dato){// inserta los datos de forma ordenada validando los diferentes casos de prueba
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()){
            cabeza= nuevo;
            cola= nuevo;
        }
        else if (dato <= cabeza.getDato()){
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza=nuevo;
        } else if (dato >=cola.getDato()) {
            nuevo.setAnterior(cola);
            cola.setSiguiente(nuevo);
            cola=nuevo;
        }
        else {
            Nodo actual = cabeza;
            while (actual.getDato() < dato){
                actual= actual.getSiguiente();
            }
            Nodo previo = actual.getAnterior();

            nuevo.setAnterior(previo);
            nuevo.setSiguiente(actual);
            previo.setSiguiente(nuevo);
            actual.setAnterior(nuevo);
        }
        tamanio++;
        return true;

    }
    public int eliminarEnPosicion(int pos){
        if (pos<0 || pos>= tamanio){
            throw new IllegalStateException("posicion invalida " + pos);
        }

        //recorrer y llegar al nodo a eliminar
        Nodo aux=cabeza;
        for (int i=0; i<pos; i++){
            aux=aux.getSiguiente();
        }
        int dato = aux.getDato();
        if (aux == cabeza && aux == cola) {
            cabeza = null;
            cola = null;
        }
        else if (aux == cabeza) {
            cabeza = aux.getSiguiente();
            cabeza.setAnterior(null);
        }
        else if (aux == cola) {
            cola = aux.getAnterior();
            cola.setSiguiente(null);
        }
        else {
            // suelta de la lista el elemento
            aux.getAnterior().setSiguiente(aux.getSiguiente());
            aux.getSiguiente().setAnterior(aux.getAnterior());
        }
        tamanio--;
        return dato;
    }
    // Imprime la lista desde la cola hasta la cabeza
    public String mostrarReversa() {
        String res = "null <- ";
        Nodo aux = cola;
        while (aux != null) {
            res = res + "[" + aux.getDato() + "] ";
            aux = aux.getAnterior();
        }
        return res + "-> null";
    }
}