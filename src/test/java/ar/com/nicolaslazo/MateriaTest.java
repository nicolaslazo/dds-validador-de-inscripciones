class MateriaTest {
    const Materia basica = new Materia("Sin dependencias", new HashSet<Materia>());

    const dependenciaDeBasica = new HashSet<Materia>();
    depedenciaDeBasica.add(basica);
    const Materia conDependencia = new Materia("Depende de basica", dependenciaDeBasica);

    @Test
    void materiaBasicaCumpleDependencias() {
        assertEquals(basica.cumpleDependencias(null), true);
    }

    @Test
    void materiaConDependenciaNoCumpleSiBasicaNoAprobada() {
        const Alumno alumno = new Alumno("Juan", 1, new HashSet<Materia>());

        assertEquals(conDependencia.cumpleDependencias(alumno), false);
    }

    @Test
    void materiaConDependenciaCumpleSiBasicaAprobada() {
        const Alumno alumno = new Alumno("Juan", 1, new HashSet<Materia>());
        alumno.aprobadas.add(basica);

        assertEquals(conDependencia.cumpleDependencias(alumno), true);
    }
}