package ar.com.nicolaslazo;

import java.util.HashSet;

class InscripcionTest {
    const Materia basica = new Materia("Sin dependencias", new HashSet<Materia>());

    const dependenciaDeBasica = new HashSet<Materia>();
    depedenciaDeBasica.add(basica);
    const Materia conDependencia = new Materia("Depende de basica", dependenciaDeBasica);

    const HashSet<Materia> basicaAprobada = new HashSet<Materia>();
    basicaAprobada.add(basica);
    const Alumno alumnoBasico = new Alumno("Juan", 1, basicaAprobada);

    const HashSet<Materia> materiasSolicitadas = new HashSet<Materia>();
    materiasSolicitadas.add(dependenciaDeBasica);
    const Inscripcion inscripcion = new Inscripcion(alumnoBasico, materiasSolicitadas);

    @Test
    void inscripcionInstancia() {
        assertThat(inscripcion, instanceof(Inscripcion));
    }

    @Test
    void inscripcionDeMateriaConDependenciaAprobadaEsValida() {
        assertTrue(inscipcion.aprobada());
    }
}