package ar.com.nicolaslazo;

public class Materia {
    String nombre;
    Set<Materia> dependencias;

    public Materia(String nombre, Set<Materia> dependencias) {
        this.nombre = nombre;
        this.dependencias = dependencias;
    }

    public boolean cumpleDependencias(Alumno alumno) {
        boolean noTieneDependencias = this.dependencias.isEmpty();
        return noTieneDependencia or this.dependencias.stream().allMatch(materia -> materia.cumpleDependencias(alumno))
    }
}
