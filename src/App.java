import almacen.GestionAlmacen;
import almacen.PrecioProducto;
import almacen.Producto;

public class App {
    public static void main(String[] args) throws Exception {
        Thread.currentThread().setName("principal");
        Producto manzana = new Producto(10);
        GestionAlmacen gestor = new GestionAlmacen(manzana, manzana.getPreciosProveedores().length);
        gestor.run();

        /*
        for (int i = 0; i < manzana.getPreciosProveedores().length; i++) {
            manzana.addProducto("proveedor " + i, i*10+1);
        }
        */

        manzana.mostrarPreciosProveedores();
        manzana.mostrarMejorPrecio();
    }
}
