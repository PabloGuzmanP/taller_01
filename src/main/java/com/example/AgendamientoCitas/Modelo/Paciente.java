package com.example.AgendamientoCitas.Modelo;

import lombok.Data;

@Data
public class Paciente {

    public int cedula;
    public String nombre;
    public String apellido;
    public int edad;
    public int fecha;
    public String hora;

    public Paciente(int cedula, String nombre, String apellido, int edad, int fecha, String hora) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fecha = fecha;
        this.hora = hora;
    }
}
