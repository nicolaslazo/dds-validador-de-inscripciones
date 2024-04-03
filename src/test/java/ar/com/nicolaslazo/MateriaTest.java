package ar.com.nicolaslazo;

import java.util.Set;
import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MateriaTest {
    @Test
    void materiaInstancia() {
        Materia materiaBasica = new Materia("Sin dependencias", new HashSet<Materia>());
        Assertions.assertInstanceOf(Materia.class, materiaBasica);
    }

    @Test
    void materiaBasicaCumpleDependencias() {
        Materia materiaBasica = new Materia("Sin dependencias", new HashSet<Materia>());
        Assertions.assertTrue(materiaBasica.cumpleDependencias(null));
    }

    @Test
    void materiaConDependenciaNoCumpleSiBasicaNoAprobada() {
        Materia materiaBasica = new Materia("Sin dependencias", new HashSet<Materia>());

        Set<Materia> dependenciaDeBasica = new HashSet<Materia>();
        dependenciaDeBasica.add(materiaBasica);
        Materia conDependencia = new Materia("Depende de materiaBasica", dependenciaDeBasica);

        Alumno alumno = new Alumno("Juan", 1, new HashSet<Materia>());

        Assertions.assertTrue(alumno.aprobadas.isEmpty());
        Assertions.assertFalse(conDependencia.cumpleDependencias(alumno));
    }

    @Test
    void materiaConDependenciaCumpleSiBasicaAprobada() {
        Materia materiaBasica = new Materia("Sin dependencias", new HashSet<Materia>());

        Alumno alumno = new Alumno("Juan", 1, new HashSet<Materia>());
        alumno.aprobadas.add(materiaBasica);

        Set<Materia> dependenciaDeBasica = new HashSet<Materia>();
        dependenciaDeBasica.add(materiaBasica);
        Materia conDependencia = new Materia("Depende de materiaBasica", dependenciaDeBasica);

        Assertions.assertTrue(conDependencia.cumpleDependencias(alumno));
    }
}