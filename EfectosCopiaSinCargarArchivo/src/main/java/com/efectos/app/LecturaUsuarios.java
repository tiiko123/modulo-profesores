package com.efectos.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LecturaUsuarios {

    private String direccion;
    private ArrayList<String> array = new ArrayList<>();


    public LecturaUsuarios(String direccion){
        this.direccion = direccion;
    }

    public ArrayList<String> getArray() {
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String bfRead;

            while((bfRead = bf.readLine())!= null){
                array.add(bfRead);
            }


        }catch (Exception e){
            System.out.println("No se pudo cargar el archivo");
        }
        return array;
    }
}
