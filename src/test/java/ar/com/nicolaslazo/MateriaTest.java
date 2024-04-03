package ar.com.nicolaslazo;

import java.util.Set;
import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MateriaTest {
    @Test
    void materiaInstancia() {
        Materia materiaBasica = new Materia("Sin dependencias", new HashSet<>());
        Assertions.assertInstanceOf(Materia.class, materiaBasica);
    }

    @Test
    void materiaBasicaCumpleDependencias() {
        Materia materiaBasica = new Materia("Sin dependencias", new HashSet<>());
        Assertions.assertTrue(materiaBasica.cumpleDependencias(null));
    }

    @Test
    void materiaConDependenciaNoCumpleSiBasicaNoAprobada() {
        Materia materiaBasica = new Materia("Sin dependencias", new HashSet<>());

        Set<Materia> dependenciaDeBasica = new HashSet<>();
        dependenciaDeBasica.add(materiaBasica);
        Materia conDependencia = new Materia("Depende de materiaBasica", dependenciaDeBasica);

        Alumno alumno = new Alumno("Juan", 1, new HashSet<>());

        Assertions.assertTrue(alumno.aprobadas.isEmpty());
        Assertions.assertFalse(conDependencia.cumpleDependencias(alumno));
    }

    @Test
    void materiaConDependenciaCumpleSiBasicaAprobada() {
        Materia materiaBasica = new Materia("Sin dependencias", new HashSet<>());

        Alumno alumno = new Alumno("Juan", 1, new HashSet<>());
        alumno.aprobadas.add(materiaBasica);

        Set<Materia> dependenciaDeBasica = new HashSet<>();
        dependenciaDeBasica.add(materiaBasica);
        Materia conDependencia = new Materia("Depende de materiaBasica", dependenciaDeBasica);

        Assertions.assertTrue(conDependencia.cumpleDependencias(alumno));
    }
}