package ar.com.nicolaslazo;

import java.util.Set;

public class Inscripcion {
    Alumno alumno;
    Set<Materia> asignaturas;

    public Inscripcion(Alumno alumno, Set<Materia> asignaturas) {
        this.alumno = alumno;
        this.asignaturas = asignaturas;
    }

    public boolean aprobada() {
        return this.asignaturas.stream().allMatch(asignatura -> asignatura.cumpleDependencias(this.alumno));
    }
}
