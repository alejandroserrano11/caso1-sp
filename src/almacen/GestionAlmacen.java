package almacen;

public class GestionAlmacen extends Thread {

    private Producto producto;
    private int numPrecios;

    public GestionAlmacen(Producto producto, int numPrecios) {
        this.producto = producto;
        this.numPrecios = numPrecios;
    }

    public void run() {

        PrecioProducto precioProducto;

        for (int i = 0; i < numPrecios; i++) {

            producto.addProducto(this.getName() + "-" + i, i * 10 + 1);
        }
    }

}
