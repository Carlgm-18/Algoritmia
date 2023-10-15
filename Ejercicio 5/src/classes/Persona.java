package classes;

import java.util.Objects;
import java.util.Random;

/**
 * Clase de datos abstracta que representa una persona
 */
public class Persona {
    private String nombre;
    private String direccion;

    protected static final Random ran = new Random();

    public Persona() {
        this.nombre = generateRandomString();
        this.direccion = generateRandomString();
    }

    /**
     * Genera una palabra de entre 4 y 7 letras de
     * manera aleatoria.
     * @return un string de letras aleatorias
     */
    private String generateRandomString() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < ran.nextInt(4,8); i++) {
            ret.append((char) ran.nextInt(97,123));
        }
        return ret.toString();
    }

    /**
     * Devuelve el nombre de una instancia de la clase Persona
     * o que herede de ella
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la dirección de una instancia de la clase Persona
     * o que herede de ella
     * @return dirección de la persona
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Permite cambiar el nombre de una instancia de la clase Persona
     * o que herede ella
     * @param nombre nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Permite cambiar la dirección de una instancia de la clase Persona
     * o que herede ella
     * @param direccion dirección de la persona
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(direccion, persona.direccion);
    }

    @Override
    public String toString() {
        return "Persona {" +
                "nombre=" + nombre +
                ", direccion=" + direccion +
                '}';
    }
}
