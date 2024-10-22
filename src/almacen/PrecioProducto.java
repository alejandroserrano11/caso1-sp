package almacen;

public class PrecioProducto {
    // atributos

    private String proveedor;
    private float precio;

    // constructor

    public PrecioProducto(String proveedor, float precio) {
        this.proveedor = proveedor;
        this.precio = precio;
    }

    // getters y setters
    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
