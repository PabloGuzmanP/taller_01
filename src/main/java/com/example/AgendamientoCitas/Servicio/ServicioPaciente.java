package com.example.AgendamientoCitas.Servicio;

import com.example.AgendamientoCitas.Modelo.Paciente;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioPaciente {

    private List<Paciente> person;

    public ServicioPaciente() {
        person =new ArrayList<>();
        person.add(new Paciente(1000,"Omar", "Lopez", 30, 20230202, "8:00"));
        person.add(new Paciente(1001,"Samuel", "Bright", 20, 20230202, "10:00"));
    }
    public List <Paciente> lista(){return person;}

    public Paciente Buscar(int fecha){
        for (Paciente l : person){
            if (l.fecha==fecha){
                return l;
            }
        }
        return null;
    }

    public void CrearPaciente(Paciente paciente){
        person.add(paciente);
        //return paciente;
        String pathDirectorio = ""+paciente.fecha+"";
        String pathArchivo = ""+paciente.fecha+"/"+paciente.cedula+".json";
        File directorio = new File(""+pathDirectorio+"");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        if(!directorio.equals(pathDirectorio)){
            try(PrintWriter out = new PrintWriter(new FileWriter(pathArchivo))){
                Gson gson = new Gson();
                String jsonString = gson.toJson(paciente);
                out.write(jsonString);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
