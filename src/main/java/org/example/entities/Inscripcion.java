package org.example.entities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Inscripcion {


    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno) {
            this.materias = new ArrayList<>();
            this.alumno = alumno;
    }

    public void agregarMateriasInscripcion(Materia ... materias){
        Collections.addAll(this.materias, materias);
    }

    public boolean aprobada(){
        return this.materias.stream()
                .allMatch(materia -> materia.getMateriasCorrelativas().stream()
                        .allMatch(correlativa ->alumno.tieneAprobada(correlativa)));
    }

}
