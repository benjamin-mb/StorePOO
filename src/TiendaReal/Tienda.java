package TiendaReal;

import java.util.ArrayList;

public class Tienda {
    private String nombre;
    static ArrayList<Departamento> departamentoData = new ArrayList<>();

    public Tienda(String nombre){
        this.nombre = nombre;

    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void addDepartamento(Departamento departamento){
        Tienda.departamentoData.add(departamento);
    }

    public ArrayList<Departamento>getDepartamentos(){
        return departamentoData;
    }
}


