package ar.com.nicolaslazo;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*
    No sé cuál es el equivalente de Java de los fixtures de Python
    (objetos repetidos que se inyectan en el scope local)
    así que pido perdón por adelantado por la redundancia de código
 */
class InscripcionTest {
    @Test
    void inscripcionInstancia() {
        Materia materiaBasica = new Materia("Sin dependencias", new HashSet<Materia>());

        Set<Materia> dependenciaDeBasica = new HashSet<Materia>();
        dependenciaDeBasica.add(materiaBasica);
        Materia materiaConDependencia = new Materia("Depende de basica", dependenciaDeBasica);

        Set<Materia> basicaAprobada = new HashSet<Materia>();
        basicaAprobada.add(materiaBasica);
        Alumno alumnoBasico = new Alumno("Juan", 1, basicaAprobada);

        Set<Materia> materiasSolicitadas = new HashSet<Materia>();
        materiasSolicitadas.add(materiaConDependencia);
        Inscripcion inscripcion = new Inscripcion(alumnoBasico, materiasSolicitadas);

        Assertions.assertInstanceOf(Inscripcion.class, inscripcion);
    }

    @Test
    void inscripcionDeMateriamateriaConDependenciaAprobadaEsValida() {
        Materia materiaBasica = new Materia("Sin dependencias", new HashSet<Materia>());

        Set<Materia> dependenciaDeBasica = new HashSet<Materia>();
        dependenciaDeBasica.add(materiaBasica);
        Materia materiaConDependencia = new Materia("Depende de basica", dependenciaDeBasica);

        Set<Materia> basicaAprobada = new HashSet<Materia>();
        basicaAprobada.add(materiaBasica);
        Alumno alumnoBasico = new Alumno("Juan", 1, basicaAprobada);

        Set<Materia> materiasSolicitadas = new HashSet<Materia>();
        materiasSolicitadas.add(materiaConDependencia);
        Inscripcion inscripcion = new Inscripcion(alumnoBasico, materiasSolicitadas);

        Assertions.assertTrue(inscripcion.aprobada());
    }
}