package ar.com.nicolaslazo;

import java.util.Set;

public class Materia {
    String nombre;
    Set<Materia> dependencias;

    public Materia(String nombre, Set<Materia> dependencias) {
        this.nombre = nombre;
        this.dependencias = dependencias;
    }

    public boolean cumpleDependencias(Alumno alumno) {
        boolean noTieneDependencias = this.dependencias.isEmpty();
        return noTieneDependencias || alumno.getAprobadas().containsAll(this.dependencias);
    }
}
