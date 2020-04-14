package com.efectos.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LecturaMateriales {

    private String direccion;
    private int contador=0;
    private ArrayList<String> array = new ArrayList<>();

    public LecturaMateriales(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<String> getArray() {



            try{
                BufferedReader bf = new BufferedReader(new FileReader(direccion));
                String bfRead;

                while((bfRead = bf.readLine())!= null){

                    array.add(bfRead);

                }
                contador++;


            }catch (Exception e){
                System.out.println("No se pudo cargar el ssssssss");
            }



        return array;

    }
}
