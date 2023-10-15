package classes;

import enums.Curso;
import enums.Programa;

import java.util.Objects;

/**
 * Clase de datos abstracta que representa un estudiante.
 * Esta clase hereda de {@link Persona}.
 * <br><br>
 * Hace uso de la enumeración {@link Curso} y {@link Programa}.
 */
public class Estudiante extends Persona {
    private String programa;
    private String curso;
    private int cuota;

    public Estudiante() {
        super();
        this.programa = Programa.values()[ran.nextInt(Programa.values().length)].toString();
        this.curso = Curso.values()[ran.nextInt(Curso.values().length)].toString();
        this.cuota = ran.nextInt(565,1786);
    }

    public String getPrograma() {
        return programa;
    }


    public String getCurso() {
        return curso;
    }


    public int getCuota() {
        return cuota;
    }


    public void setPrograma(Programa programa) {
        this.programa = programa.toString();
    }


    public void setCurso(Curso curso) {
        this.curso = curso.toString();
    }


    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Estudiante that = (Estudiante) o;
        return cuota == that.cuota && Objects.equals(programa, that.programa) && Objects.equals(curso, that.curso);
    }

    @Override
    public String toString() {
        return "Estudiante {" +
                "nombre=" + getNombre() +
                ", direccion=" + getDireccion() +
                ", programa=" + programa +
                ", curso=" + curso +
                ", cuota=" + cuota +
                '}';
    }
}
