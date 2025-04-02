package org.example.entities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.List;

public class Alumno {

    private String nombre;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void agregarMateriasAprobadas(Materia ... materiasAprobadas){
        Collections.addAll(this.materiasAprobadas, materiasAprobadas);
    }

    public boolean tieneAprobada(Materia materia) {
        return materiasAprobadas.contains(materia);
    }
}



