package classes;

import enums.Area;

import java.util.Objects;

/**
 * Clase de datos abstracta que representa un profesor.
 * Esta clase hereda de {@link Persona} <br><br>
 * Hace uso de la enumeración {@link Area}
 */
public class Profesor extends Persona {
    private String area;
    private int sueldo;

    public Profesor() {
        super();
        this.area = Area.values()[ran.nextInt(Area.values().length)].toString();
        this.sueldo = ran.nextInt(1800,2500);
    }

    /**
     * Devuelve el area de una instancia de la clase Profesor
     * @return area del profesor
     */
    public String getArea() {
        return area;
    }

    /**
     * Devuelve el area de una instancia de la clase Profesor
     * @return sueldo del profesor
     */
    public int getSueldo() {
        return sueldo;
    }

    /**
     * Permite cambiar el área de una instancia de la clase Profesor
     * @param area área del profesor
     */
    public void setArea(Area area) {
        this.area = area.toString();
    }

    /**
     * Permite cambiar el sueldo de una instancia de la clase Profesor
     * @param sueldo sueldo del profesor
     */
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Profesor profesor = (Profesor) o;
        return sueldo == profesor.sueldo && Objects.equals(area, profesor.area);
    }

    @Override
    public String toString() {
        return "Profesor {" +
                "nombre=" + getNombre() +
                ", direccion=" + getDireccion() +
                ", area=" + area +
                ", sueldo=" + sueldo +
                '}';
    }
}
