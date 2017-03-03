package ubahn.joel.ubahnproject.model;


import java.io.Serializable;

public class Estacion implements Serializable,Comparable {
    public int id;
    public String nombre;
    public int id_linea;



    public Estacion(int id, String nombre, int id_linea, int id_servicio, String mapa) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.id_linea = id_linea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_linea() {
        return id_linea;
    }

    public void setId_linea(int id_linea) {
        this.id_linea = id_linea;
    }



    public int compareTo(Object o) {
        Estacion estacion = (Estacion) o;

        if (this.nombre.compareToIgnoreCase(estacion.nombre) == 0) {
            return this.nombre.compareToIgnoreCase(String.valueOf(estacion.id));
        } else {
            return this.nombre.compareToIgnoreCase(estacion.nombre);
        }
    }
}

