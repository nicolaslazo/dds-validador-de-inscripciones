package ar.com.nicolaslazo;

import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlumnoTest {
    @Test
    void alumnoInstancia() {
        Alumno alumno = new Alumno("Juan", 1, new HashSet<Materia>());
        Assertions.assertInstanceOf(Alumno.class, alumno);
    }
}