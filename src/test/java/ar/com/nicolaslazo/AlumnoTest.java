package ar.com.nicolaslazo;

class AlumnoTest {
    @Test
    void alumnoInstancia() {
        const Alumno alumno = new Alumno("Juan", 1, new HashSet<Materia>);
        assertThat(alumno, instanceof(Alumno));
    }
}