public class LinkedList {

    class Node {
        int value;
        Node next = null;
        Node(int value){
            this.value = value;
        }
    }

    protected Node head = null;
    protected Node tail = null;

    public void agregarValorAlInicio(int valor){
        Node nuevoNodo = new Node(valor);
        nuevoNodo.next = head;
        head = nuevoNodo;
        if(nuevoNodo.next == null) {
            tail = nuevoNodo;
        }
    }

    public void agregarFinal(int valor) {
        Node nuevoNodo = new Node(valor);
        if(tail == null){
            head = nuevoNodo;
        } else {
            tail.next = nuevoNodo;
            tail = nuevoNodo;
        }
    }

    public void agregarPorPosicion(int posicion, int valor){
        if(posicion < 0) {
            throw new IndexOutOfBoundsException();
        } else if(posicion == 0){
            agregarValorAlInicio(valor);
        } else{
            Node nuevoNodo = new Node(valor);
            Node actual = head;
            for (int i = 0; i < posicion-1; i++) {
                if(actual == null) {
                    throw new IndexOutOfBoundsException();
                }
                actual = actual.next;
            }
            if(actual.next == null){
                agregarFinal(valor);
            } else {
                nuevoNodo.next = actual.next;
                actual.next = nuevoNodo;
            }
        }

    }

    // 1) Crear el metodo contiene.
    public boolean metodoContiene(int valor){
        Node actual = head;
        while(actual!=null){
            if(actual.value == valor){
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    //1) Crear el metodo obtener por posicion.
    public int getPorPosicion(int posicion){
        int contador = 0;
        Node actual = head;
        while(actual!=null){
            if(contador == posicion){
                return actual.value;
            }
            contador++;
            actual = actual.next;
        }
        return -1;
    }

    //Eliminar el valor del frente (head).
    //1) Crear el metodo eliminar frente
    public int eliminarHead(){
        if(head == null){
            return -1;
        }
        int valorEliminado = head.value;
        head = head.next;
        return valorEliminado;
    }

    //Eliminar el valor del frente (head).
    //
    //1) Crear el metodo  eliminar frente

    public int eliminarTail() {
        if (head == null) {
            return -1;
        }
        if (head.next == null) {
            int valorEliminado = head.value;
            head = null;
            return valorEliminado;
        }
        Node penultimoNodo = head;
        while (penultimoNodo.next.next != null) {
            penultimoNodo = penultimoNodo.next;
        }
        int valorEliminado = penultimoNodo.next.value;
        penultimoNodo.next = null;
        return valorEliminado;
    }

    //Eliminar dado una posicion.

    public int eliminarPorPosicion(int posicion){
        if(posicion< 0 || posicion>=longitud()){
            return -1;
        }
        if(posicion==0){
            return eliminarHead();
        }
        if(posicion == longitud()-1){
            return eliminarTail();
        }
        Node nodoAnterior = head;
        for (int i = 0; i < posicion-1; i++) {
            nodoAnterior = nodoAnterior.next;
        }
        int valorEliminado = nodoAnterior.next.value;
        nodoAnterior.next= nodoAnterior.next.next;
        return valorEliminado;
    }

    public int longitud(){
        int longitud = 0;
        Node nodoActual = head;
        while (nodoActual != null){
            longitud++;
            nodoActual = nodoActual.next;
        }
        return longitud;
    }

}