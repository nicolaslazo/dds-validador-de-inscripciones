package ar.com.nicolaslazo;

public class Alumno {
    String nombre;
    int legajo;
    Set<Materia> aprobadas;

    public Alumno(String nombre, int legajo, Set<Materia> aprobadas) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.aprobadas = aprobadas;
    }

    public Set<Materia> getAprobadas() {
        return this.aprobadas;
    }
}
