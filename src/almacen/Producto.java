package almacen;

import java.util.concurrent.locks.ReentrantLock;

public class Producto {
    // atributos

    private static ReentrantLock cerrojo;
    private PrecioProducto[] preciosProveedores;
    private int sigProveedor; // almacena el siguiente hueco libre

    // constructor

    public Producto(int MaxPreciosProducto) {
        // inicializar
        sigProveedor = 0;
        cerrojo = new ReentrantLock();
        preciosProveedores = new PrecioProducto[MaxPreciosProducto];
        // dentro del array hay null en cada hueco
    }

    // metodos solicitados

    public void addProducto(String nombreProveedor, float precio) {

        accederSeccionCritica();

        try {
            if (sigProveedor == preciosProveedores.length) {
                System.out.println("No se puede añadir, el almacen está lleno.");
            } else { // tengo hueco
                preciosProveedores[sigProveedor] = new PrecioProducto(nombreProveedor, precio);
                sigProveedor++;
            }
        } finally {
            salirSeccionCritica();
        }
    }

    public void mostrarPreciosProveedores() {

        accederSeccionCritica();

        try {
            if (sigProveedor == 0) {
                System.out.println("No hay precios de proveedores para este producto.");
            } else {
                for (int i = 0; i < sigProveedor; i++) {
                    System.out.println("El proveedor: " +
                            preciosProveedores[i].getProveedor() +
                            " ofrece el producto al precio: " +
                            preciosProveedores[i].getPrecio() + "€.");
                }
            }
        } finally {
            salirSeccionCritica();
        }
    }

    public void mostrarMejorPrecio() {

        accederSeccionCritica();

        try {
            if (sigProveedor <= 0) {
                System.out.println("No hay información disponible para ese producto.");
            } else {
                PrecioProducto mejorProducto = new PrecioProducto(null, Float.POSITIVE_INFINITY);
                // float min = Float.POSITIVE_INFINITY;
                for (int i = 0; i < sigProveedor; i++) {
                    if (preciosProveedores[i].getPrecio() < mejorProducto.getPrecio()) {
                        mejorProducto = preciosProveedores[i];
                    }
                }
                System.out.println("El mejor precio para el producto es: " +
                        mejorProducto.getPrecio() +
                        "y es ofrecido por el proveedor: " +
                        mejorProducto.getProveedor());
            }

        } finally {
            salirSeccionCritica();
        }
    }

    // getters y setters

    public PrecioProducto[] getPreciosProveedores() {
        accederSeccionCritica();
        try{
        return preciosProveedores;
        } finally {
            salirSeccionCritica();
        }
    }

    private void accederSeccionCritica() {
        cerrojo.lock();
    }

    private void salirSeccionCritica() {
        cerrojo.unlock();
    }
}
