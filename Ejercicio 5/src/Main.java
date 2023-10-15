import classes.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Main {

    public static Random ran = new Random();

    public static void main(String[] args) {
        List<Persona> personas = crearPersonasAleatorias(1000000);

        /*
        ordenarPersonasInverso(personas);

        for (int i = 0; i < 10; i++) {
            System.out.println(personas.get(i));
        }
        */

        /*
        List<Estudiante> estudiantes = filtrarEstudiantes(personas);
        ordenarEstudiantesInverso(estudiantes, Estudiante::getPrograma);

        for (int i = 0; i < 10; i++) {
            System.out.println(estudiantes.get(i));
        }
        */
    }

    /**
     * Genera 10^6 instancias de las clases heredadas de personas
     */
    public static List<Persona> crearPersonasAleatorias(int num) {
        List<Persona> personas = new ArrayList<>();
        int select;

        for (int i = 0; i < num; i++) {
            select = ran.nextInt(2);
            if (select == 0) {
                personas.add(new Estudiante());
            } else {
                personas.add(new Profesor());
            }
        }
        return personas;
    }

    /**
     * Filtra los estudiantes de una lista de Personas
     * @param personas lista para filtrar
     * @return lista de Estudiantes filtrada
     */
    public static List<Estudiante> filtrarEstudiantes(List<Persona> personas) {
        List<Estudiante> ret = new ArrayList<>();

        for (Persona persona: personas) {
            if(persona instanceof Estudiante) {
                ret.add((Estudiante) persona);
            }
        }

        return ret;
    }

    /**
     * Ordena alfabéticamente en orden inverso una lista de {@link Persona}
     * por su nombre.<br><br>
     * <pre>
     * P ≡ Todos los objetos de la lista deben ser instancias de la clase Persona
     * </pre>
     *
     * <pre>
     * result ∈ List[Persona]
     * Q ≡ {
     *      ∀i 0 <= i < result.length - 1:
     *       result.get(i).getNombre()
     *       .compareTo(result.get(i+1).getNombre()) >= 0
     *       }
     * </pre>
     * @param personas lista de personas
     */
    public static void ordenarPersonasInverso(List<Persona> personas) {
        personas.sort(Comparator.comparing(Persona::getNombre).reversed());
    }

    /**
     * Ordena alfabéticamente en orden inverso una lista de {@link Estudiante}
     * en base al atributo programa o nombre.<br><br>
     * <pre>
     * P ≡ Todos los objetos de la lista deben ser instancias de la clase Estudiante y
     *     la clave debe ser una referencia al getter del atributo que se va a utilizar como
     *     clave de ordenación.
     * </pre>
     *
     * <pre>
     * result ∈ List[Estudiante]
     * Q ≡ {
     *      ∀i 0 <= i < result.length - 1:
     *       result.get(i).clave
     *       .compareTo(result.get(i+1).clave) >= 0
     *       }
     * @param estudiantes lista de estudiantes
     * @param clave referencia al getter de la clave de ordenación
     */
    public static void ordenarEstudiantesInverso(List<Estudiante> estudiantes, Function<Estudiante, String> clave) {
        estudiantes.sort(Comparator.comparing(clave).reversed());
    }

    /**
     * Ordena alfabéticamente en orden inverso una lista de {@link Profesor}
     * en base al atributo área o nombre.
     * <pre>
     * P ≡ Todos los objetos de la lista deben ser instancias de la clase Profesor y
     *     la clave debe ser una referencia al getter del atributo que se va a utilizar como
     *     clave de ordenación.
     * </pre>
     *
     * <pre>
     * result ∈ List[Profesor]
     * Q ≡ {
     *      ∀i 0 <= i < result.length - 1:
     *       result.get(i).clave
     *       .compareTo(result.get(i+1).clave) >= 0
     *       }
     * </pre>
     * @param profesores lista de profesores
     * @param clave referencia al getter de la clave de ordenación
     */
    public static void ordenarProfesoresInverso(List<Profesor> profesores, Function<Profesor, String> clave) {
        profesores.sort(Comparator.comparing(clave).reversed());
    }
}