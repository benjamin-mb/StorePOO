package TiendaReal;
 import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("ingresa el nombre de tu tienda");
        String tienda = sc.nextLine();
        Tienda tienda1 = new Tienda(tienda);
        int opcion;

        do {
            System.out.println("///////////////MENU////////////");
            System.out.println(
                    "1.crear una departamento" + "\n" +
                    "2.crear un producto"+ '\n'+
                    "3.eliminar un producto"+'\n'+
                    "4.cambiar precio de un producto" + "\n"+
                    "5.consultar stock de un producto" + '\n'+
                    "6.consultar productos de un departamento"+'\n'+
                    "7.consultar departamentos de la tienda"+"\n"+
                    "8.salir"+"\n"+
                    "SELECCIONA TU OPCION"
            );
           opcion= sc.nextInt();
           sc.nextLine();

           switch (opcion){


               //crear una departamento
               case 1:
                   System.out.println("ingresa el nombre del departamento");
                   String nombreDep = sc.nextLine();
                   Departamento departamento = new Departamento(nombreDep);
                   tienda1.departamentoData.add(departamento);
                   System.out.println("El departamento"+nombreDep+"fue creado");

                   break;


               //crear un producto
               case 2:
                   System.out.println("ingresa el nombre del producto");
                   String nombreProd =sc.nextLine();
                   System.out.println("ingrese el precio del producto");
                   double precio=sc.nextDouble();
                   System.out.println("ingresa la cantidad en stock");
                   int stock=sc.nextInt();
                   sc.nextLine();
                   Producto producto= new Producto(nombreProd,precio,stock);


                   System.out.println("ingresa en cual departamento quisieras agregar el producto");

                   for (int i=0; i<tienda1.getDepartamentos().size();i++){
                       System.out.println((i+1)+ "."+tienda1.getDepartamentos().get(i).getNombre());
                   }
                   int depSeleccionado=sc.nextInt();
                   sc.nextLine();

                   if (depSeleccionado > 0 && depSeleccionado <= tienda1.departamentoData.size()){
                       tienda1.getDepartamentos().get(depSeleccionado-1).addProducto(producto);
                   }
                   else{
                       System.out.println("departamento no encontrado");
                   }
                   break;


               //Eliminar un producto
               case 3:
                    if (tienda1.getDepartamentos().size()==0){
                        System.out.println("no hay departamentos en la tienda");
                    }
                    else {
                        for (int x = 0; x < tienda1.getDepartamentos().size(); x++) {
                            System.out.println((x + 1) + "." + tienda1.getDepartamentos().get(x).getNombre());
                        }
                        System.out.println("selecciona el departamento del cual quieres eliminarl el producto:");
                        int depEliminar = sc.nextInt();
                        sc.nextLine();

                        if (depEliminar > 0 && depEliminar <= tienda1.getDepartamentos().size()) {


                            //obtener departamento seleccionado
                            Departamento departamentoSeleccionado = tienda1.getDepartamentos().get(depEliminar - 1);

                            System.out.println("el departamento el cual seleccionaste es:" + departamentoSeleccionado.getNombre());

                            System.out.println();

                            //mostrar los productps en el dep seleccionado
                            System.out.println("productos del departamento" + departamentoSeleccionado + " : ");
                            for (int i = 0; i < departamentoSeleccionado.getProductoData().size(); i++) {

                                Producto productox = departamentoSeleccionado.getProductoData().get(i);
                                System.out.println((i + 1) +"."+ productox.getNombre());

                            }
                            System.out.println("cual producto deseas eliminar: ");
                            int productoEliminar = sc.nextInt();
                            sc.nextLine();

                            if (productoEliminar > 0 && productoEliminar <= departamentoSeleccionado.getProductoData().size()) {

                                //obteniendo producto para eliminar
                                Producto productoAEliminar = departamentoSeleccionado.getProductoData().get(productoEliminar - 1);
                                departamentoSeleccionado.getProductoData().remove(productoAEliminar);
                                System.out.println("el producto " + productoAEliminar + "fue eliminado del departamento " + departamentoSeleccionado);
                            }
                        } else {
                            System.out.println("error");
                        }
                    }
                   break;


               //cambiar precio de un producto
               case 4:

                   if (tienda1.getDepartamentos().size() == 0){
                         System.out.println("no hay departamentos ");
                   }
                   else {
                           for (int i = 0; i < tienda1.getDepartamentos().size(); i++) {
                               System.out.println((i + 1) + "." + tienda1.getDepartamentos().get(i).getNombre());
                           }
                           System.out.println("selecciona el departamento del cual quisieras editar el producto:");
                           int seleccionDepartamentoEdit = sc.nextInt();
                           sc.nextLine();

                       if (seleccionDepartamentoEdit > 0 && seleccionDepartamentoEdit <= tienda1.getDepartamentos().size()) {


                           //obtener departamento
                               Departamento departamentoEdit = tienda1.getDepartamentos().get(seleccionDepartamentoEdit - 1);

                               System.out.println("el departamento el cual seleccionaste es: " + departamentoEdit);

                           System.out.println();


                           System.out.println("los productos son:");
                               //mostrar todos los productos de el departamento obtenido
                               for (int i = 0; i < departamentoEdit.getProductoData().size(); i++) {


                                   Producto productoEditar=departamentoEdit.getProductoData().get(i);
                                   System.out.println((i + 1) + "." + productoEditar.getNombre());
                               }
                               System.out.println("selecciona el producto el cual deseas editar:");
                               int productoEdicionSeleccion=sc.nextInt();
                               sc.nextLine();

                           if (productoEdicionSeleccion > 0 && productoEdicionSeleccion <= departamentoEdit.getProductoData().size()) {

                                   //obteniendo el producto seleccionado
                                   Producto productoAEditar=departamentoEdit.getProductoData().get(productoEdicionSeleccion-1);
                                   System.out.println("el producto seleccionado es"+productoAEditar + "y su precio actual es "+ productoAEditar.getPrecio());


                                   System.out.println("cual sera el nuevo precio del producto: ");
                                   float Nuevoprecio=sc.nextFloat();
                                   //editando el valor
                                    productoAEditar.setPrecio(Nuevoprecio);
                                   System.out.println("ya has cambiado el valor del producto");
                                   System.out.println("el precio nuevo de "+productoAEditar.getNombre()+" es "+productoAEditar.getPrecio());
                                   break;
                               }
                           }

                  }


               //Consultar stock de un prodcuto
               case 5:
                   if (tienda1.getDepartamentos().size()==0){
                       System.out.println("no hay departamentos en esta tienda");
                   }
                   else {

                       System.out.println("selecciona el departamento donde esta el producto");

                       //mostrar departamentos
                       for (int i = 0; i < tienda1.getDepartamentos().size(); i++) {
                           System.out.println((i + 1) + "." + tienda1.getDepartamentos().get(i).getNombre());
                       }

                       //seleccionar de cual departamento quiere ver productos
                       int indexDepartamentoStock=sc.nextInt();

                       if (indexDepartamentoStock>0 && indexDepartamentoStock <= tienda1.getDepartamentos().size()){

                           Departamento departamentoMostrarStock=tienda1.getDepartamentos().get(indexDepartamentoStock-1);
                           System.out.println("El departamento el cual escogiste es "+ departamentoMostrarStock.getNombre());

                           //mostrar productos de el dep seleccionado
                           for (int i=0;i< departamentoMostrarStock.getProductoData().size();i++){

                               Producto productoStock=departamentoMostrarStock.getProductoData().get(i);
                               System.out.println((i+1)+"."+productoStock.getNombre());
                           }
                           //seleccionar el producto
                           System.out.println("Selecciona el producto del cual deseas saber el stock: ");
                           int seleccionIndexProductoStock=sc.nextInt();

                           if (seleccionIndexProductoStock > 0 && seleccionIndexProductoStock <= departamentoMostrarStock.getProductoData().size()){

                               Producto productoParaMostrarStock=departamentoMostrarStock.getProductoData().get(seleccionIndexProductoStock-1);
                               System.out.println("el stock en "+ productoParaMostrarStock.getNombre()+" es "+productoParaMostrarStock.getCantidad());
                           }
                           else{
                               System.out.println("seleccion no valida");
                           }

                       }
                       else {
                           System.out.println("seleccion no valida");
                       }
                   }
                   break;

               //consultar productos de un departamento
               case 6:
               if (tienda1.getDepartamentos().size()==0){
                   System.out.println("no hay departamentos disponibles");
               }
               else{
                   System.out.println("selecciona el departamento para ver sus productos: ");

                   for (int i=0;i < tienda1.getDepartamentos().size(); i++){
                       System.out.println((i+1)+"."+tienda1.getDepartamentos().get(i).getNombre());
                   }

                   int indexMostrarStock= sc.nextInt();

                   if (indexMostrarStock>0 && indexMostrarStock<=tienda1.getDepartamentos().size()){

                       Departamento departamentoMStock = tienda1.getDepartamentos().get(indexMostrarStock-1);
                       System.out.println("los productos del departamento "+departamentoMStock.getNombre());

                       for (int i=0;i<=departamentoMStock.getProductoData().size();i++){

                           Producto producto1=departamentoMStock.getProductoData().get(i);
                           System.out.println((i+1)+"."+producto1.getNombre());
                       }
                   }
               }
               break;


               //consultar departementos
               case 7:
                   if (tienda1.getDepartamentos().size()== 0){

                       System.out.println("no hay departamentos, debes volver al menu y crear departamentos");

                   }
                   else{
                       System.out.println("Los departamentos son: ");

                       for (int i=0;i < tienda1.getDepartamentos().size(); i++){
                           System.out.println((i+1)+"."+tienda1.getDepartamentos().get(i).getNombre());
                       }
                   }
                   break;
           }

        }
        while ((opcion != 8)||(opcion != 0));

    }
}
