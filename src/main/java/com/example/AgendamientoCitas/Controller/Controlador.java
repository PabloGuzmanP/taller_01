package com.example.AgendamientoCitas.Controller;

import com.example.AgendamientoCitas.Modelo.Paciente;
import com.example.AgendamientoCitas.Servicio.ServicioPaciente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controlador {

    private final ServicioPaciente service;
    public Controlador(ServicioPaciente service) {
        this.service = service;
    }

    @GetMapping("/pacientes")
    public Iterable<Paciente>lista(){return service.lista();}

    @GetMapping("/{fecha}")
    public Paciente Buscar(@PathVariable("fecha")int fecha){
        return service.Buscar(fecha);
    }

    @PostMapping("/agendar")
    public boolean CrearPaciente(@RequestBody Paciente person) {
        System.out.println(person); service.CrearPaciente(person); return true;}
}
