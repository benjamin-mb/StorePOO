package TiendaReal;
import java.util.ArrayList;

public class Departamento {
    private int id;
    private String nombre;
    private Producto producto;
    private static int contadorId;

    public ArrayList<Producto> productoData;

    public Departamento(String nombre){
        this.id = ++contadorId;
        this.nombre = nombre;
        this.productoData= new ArrayList<>();
    }

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public Producto getProducto(){
        return this.producto;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setProducto(Producto producto){
        this.producto = producto;
    }

    public void addProducto(Producto producto){
        productoData.add(producto);
    }

    public void eliminarProducto(int id){
        productoData.removeIf(cosa -> producto.getId() == id);
    }


    public void actualizarPrecio(int id, double nuevoprecio){
    for (Producto producto : productoData){
        if (producto.getId() == id){
            producto.setPrecio(nuevoprecio);
        }
        }
    }

    public void mostrarStock(int id){
        for (Producto producto : productoData){
            if (producto.getId() == id){
                System.out.println("la cantidad en stock del producto "+ producto.getNombre() +"es"+ producto.getCantidad());
            }
        }
    }

    public ArrayList<Producto>getProductoData(){
        return productoData;

    }
}


