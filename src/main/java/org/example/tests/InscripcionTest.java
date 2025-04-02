package org.example.tests;
import org.example.entities.Alumno;
import org.example.entities.Inscripcion;
import org.example.entities.Materia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class InscripcionTest {

    @Test
    public void testInscripcionAprobadaCuandoTodasCorrelativasEstanAprobadas() {

        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos");
        Materia paradigmas = new Materia("Paradigmas de Programación");
        Materia disenoSistemas = new Materia("Diseño de Sistemas");

        Materia analisisI = new Materia("Analisis matematico 1");
        Materia analisisII = new Materia("Analisis matematico 2");

        paradigmas.agregarCorrelativas(algoritmos);
        disenoSistemas.agregarCorrelativas(paradigmas);
        analisisII.agregarCorrelativas(analisisI);

        Alumno alumno = new Alumno("Juan");
        alumno.agregarMateriasAprobadas(algoritmos,paradigmas,analisisI);


        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMateriasInscripcion(disenoSistemas,analisisII);
        assertTrue(inscripcion.aprobada(), "La inscripción debería ser aprobada ya que se tienen todas las correlativas");
    }

    @Test
    public void testInscripcionRechazada() {

        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos");
        Materia paradigmas = new Materia("Paradigmas de Programación");
        Materia disenoSistemas = new Materia("Diseño de Sistemas");


        paradigmas.agregarCorrelativas(algoritmos);
        disenoSistemas.agregarCorrelativas(paradigmas);


        Alumno alumno = new Alumno("María");
        alumno.agregarMateriasAprobadas(algoritmos);


        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMateriasInscripcion(disenoSistemas);
        assertFalse(inscripcion.aprobada(), "La inscripción debería ser rechazada ya que falta aprobar Paradigmas");
    }


    @Test
    public void testInscripcionConMateriaSinCorrelativas() {

        Materia introduccion = new Materia("Introducción a la Programación");


        Alumno alumno = new Alumno("Carlos");


        Inscripcion inscripcion = new Inscripcion(alumno);
        assertTrue(inscripcion.aprobada(), "La inscripción debería ser aprobada ya que la materia no tiene correlativas");
    }

}
