package com.disponibilidad;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.*;


import java.awt.*;
import java.sql.DriverManager;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    @FXML
    Button boton0_0,boton0_1,boton0_2,boton0_3,boton0_4,boton0_5;
    @FXML
    Button boton1_0,boton1_1,boton1_2,boton1_3,boton1_4,boton1_5;
    @FXML
    Button boton2_0,boton2_1,boton2_2,boton2_3,boton2_4,boton2_5;
    @FXML
    Button boton3_0,boton3_1,boton3_2,boton3_3,boton3_4,boton3_5;
    @FXML
    Button boton4_0,boton4_1,boton4_2,boton4_3,boton4_4,boton4_5;
    @FXML
    Button boton5_0,boton5_1,boton5_2,boton5_3,boton5_4,boton5_5;
    @FXML
    Button boton6_0,boton6_1,boton6_2,boton6_3,boton6_4,boton6_5;
    @FXML
    Button boton7_0,boton7_1,boton7_2,boton7_3,boton7_4,boton7_5;
    @FXML
    Button boton8_0,boton8_1,boton8_2,boton8_3,boton8_4,boton8_5;
    @FXML
    Button boton9_0,boton9_1,boton9_2,boton9_3,boton9_4,boton9_5;
    @FXML
    Button boton10_0,boton10_1,boton10_2,boton10_3,boton10_4,boton10_5;
    @FXML
    Button boton11_0,boton11_1,boton11_2,boton11_3,boton11_4,boton11_5;
    @FXML
    Button boton12_0,boton12_1,boton12_2,boton12_3,boton12_4,boton12_5;
    @FXML
    Button boton13_0,boton13_1,boton13_2,boton13_3,boton13_4,boton13_5;
    @FXML
    Label usuario,nombre,nivel,contrato;

    int seleccion;
    //Matriz para guardar en la base de datos
    static int [][] matriz = new int[14][7];
    static Button[][] matriz2 = new Button[14][6];
    final static Conexion conectar = new Conexion();
    static Connection con = null;
    static String[] profesor = new String [7];

    static {
        try {
            con = conectar.conexion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void algo(int[][] matriz1){



        matriz2[0][0]=boton0_0;
        matriz2[0][1]=boton0_1;
        matriz2[0][2]=boton0_2;
        matriz2[0][3]=boton0_3;
        matriz2[0][4]=boton0_4;
        matriz2[0][5]=boton0_5;

        matriz2[1][0]=boton1_0;
        matriz2[1][1]=boton1_1;
        matriz2[1][2]=boton1_2;
        matriz2[1][3]=boton1_3;
        matriz2[1][4]=boton1_4;
        matriz2[1][5]=boton1_5;

        matriz2[2][0]=boton2_0;
        matriz2[2][1]=boton2_1;
        matriz2[2][2]=boton2_2;
        matriz2[2][3]=boton2_3;
        matriz2[2][4]=boton2_4;
        matriz2[2][5]=boton2_5;

        matriz2[3][0]=boton3_0;
        matriz2[3][1]=boton3_1;
        matriz2[3][2]=boton3_2;
        matriz2[3][3]=boton3_3;
        matriz2[3][4]=boton3_4;
        matriz2[3][5]=boton3_5;

        matriz2[4][0]=boton4_0;
        matriz2[4][1]=boton4_1;
        matriz2[4][2]=boton4_2;
        matriz2[4][3]=boton4_3;
        matriz2[4][4]=boton4_4;
        matriz2[4][5]=boton4_5;

        matriz2[5][0]=boton5_0;
        matriz2[5][1]=boton5_1;
        matriz2[5][2]=boton5_2;
        matriz2[5][3]=boton5_3;
        matriz2[5][4]=boton5_4;
        matriz2[5][5]=boton5_5;

        matriz2[6][0]=boton6_0;
        matriz2[6][1]=boton6_1;
        matriz2[6][2]=boton6_2;
        matriz2[6][3]=boton6_3;
        matriz2[6][4]=boton6_4;
        matriz2[6][5]=boton6_5;

        matriz2[7][0]=boton7_0;
        matriz2[7][1]=boton7_1;
        matriz2[7][2]=boton7_2;
        matriz2[7][3]=boton7_3;
        matriz2[7][4]=boton7_4;
        matriz2[7][5]=boton7_5;

        matriz2[8][0]=boton8_0;
        matriz2[8][1]=boton8_1;
        matriz2[8][2]=boton8_2;
        matriz2[8][3]=boton8_3;
        matriz2[8][4]=boton8_4;
        matriz2[8][5]=boton8_5;

        matriz2[9][0]=boton9_0;
        matriz2[9][1]=boton9_1;
        matriz2[9][2]=boton9_2;
        matriz2[9][3]=boton9_3;
        matriz2[9][4]=boton9_4;
        matriz2[9][5]=boton9_5;

        matriz2[10][0]=boton10_0;
        matriz2[10][1]=boton10_1;
        matriz2[10][2]=boton10_2;
        matriz2[10][3]=boton10_3;
        matriz2[10][4]=boton10_4;
        matriz2[10][5]=boton10_5;


        matriz2[11][0]=boton11_0;
        matriz2[11][1]=boton11_1;
        matriz2[11][2]=boton11_2;
        matriz2[11][3]=boton11_3;
        matriz2[11][4]=boton11_4;
        matriz2[11][5]=boton11_5;

        matriz2[12][0]=boton12_0;
        matriz2[12][1]=boton12_1;
        matriz2[12][2]=boton12_2;
        matriz2[12][3]=boton12_3;
        matriz2[12][4]=boton12_4;
        matriz2[12][5]=boton12_5;

        matriz2[13][0]=boton13_0;
        matriz2[13][1]=boton13_1;
        matriz2[13][2]=boton13_2;
        matriz2[13][3]=boton13_3;
        matriz2[13][4]=boton13_4;
        matriz2[13][5]=boton13_5;




        for(int i = 0; i < 14; i++){
            for(int j =  0; j < 6 ; j ++){
                System.out.println(matriz2[i][j].getId());
                System.out.println(matriz1[i][j]);
                if(matriz1[i][j]==0){
                    matriz2[i][j].setStyle("-fx-background-color: #FFFFFF;-fx-border-color: #000000");
                    matriz[i][j] = 0;

                }else{

                    matriz2[i][j].setStyle("-fx-background-color: #15EC00; -fx-border-color: #000000");
                    matriz[i][j] = 1;
                }
            }
        }


    }


    public int cambiarColor(Button boton){
        if (boton.getBackground().getFills().get(0).getFill().toString().substring(2).equals("ffffffff")){
            boton.setStyle("-fx-background-color: #15EC00; -fx-border-color: #000000");
            return seleccion = 1;
        }else{
            boton.setStyle("-fx-background-color: #FFFFFF;-fx-border-color: #000000");
            return seleccion = 0;
        }

    }

    //Metodos de la primera fila
    public void cambiar0_0(){
        matriz[0][0]= cambiarColor(boton0_0);
    }
    public void cambiar0_1(){
        matriz[0][1]=cambiarColor(boton0_1);
    }
    public void cambiar0_2(){
        matriz[0][2]=cambiarColor(boton0_2);
    }
    public void cambiar0_3(){
        matriz[0][3]=cambiarColor(boton0_3);
    }
    public void cambiar0_4(){
        matriz[0][4]=cambiarColor(boton0_4);
    }
    public void cambiar0_5(){
        matriz[0][5]=cambiarColor(boton0_5);
    }

    //Segunda fila
    public void cambiar1_0(){
        matriz[1][0]=cambiarColor(boton1_0);
    }
    public void cambiar1_1(){
        matriz[1][1]=cambiarColor(boton1_1);
    }
    public void cambiar1_2(){
        matriz[1][2]=cambiarColor(boton1_2);
    }
    public void cambiar1_3(){
        matriz[1][3]=cambiarColor(boton1_3);
    }
    public void cambiar1_4(){
        matriz[1][4]=cambiarColor(boton1_4);
    }
    public void cambiar1_5(){
        matriz[1][5]=cambiarColor(boton1_5);
    }

    //Tercera fila
    public void cambiar2_0(){
        matriz[2][0]=cambiarColor(boton2_0);
    }
    public void cambiar2_1(){
        matriz[2][1]=cambiarColor(boton2_1);
    }
    public void cambiar2_2(){
        matriz[2][2]=cambiarColor(boton2_2);
    }
    public void cambiar2_3(){
        matriz[2][3]=cambiarColor(boton2_3);
    }
    public void cambiar2_4(){
        matriz[2][4]=cambiarColor(boton2_4);
    }
    public void cambiar2_5(){
        matriz[2][5]=cambiarColor(boton2_5);
    }

    //Cuarta fila
    public void cambiar3_0(){
        matriz[3][0]=cambiarColor(boton3_0);
    }
    public void cambiar3_1(){
        matriz[3][1]=cambiarColor(boton3_1);
    }
    public void cambiar3_2(){
        matriz[3][2]=cambiarColor(boton3_2);
    }
    public void cambiar3_3(){
        matriz[3][3]=cambiarColor(boton3_3);
    }
    public void cambiar3_4(){
        matriz[3][4]=cambiarColor(boton3_4);
    }
    public void cambiar3_5(){
        matriz[3][5]=cambiarColor(boton3_5);
    }

    //Quinta fila
    public void cambiar4_0(){
        matriz[4][0]=cambiarColor(boton4_0);
    }
    public void cambiar4_1(){
        matriz[4][1]=cambiarColor(boton4_1);
    }
    public void cambiar4_2(){
        matriz[4][2]=cambiarColor(boton4_2);
    }
    public void cambiar4_3(){
        matriz[4][3]=cambiarColor(boton4_3);
    }
    public void cambiar4_4(){
        matriz[4][4]=cambiarColor(boton4_4);
    }
    public void cambiar4_5(){
        matriz[4][5]=cambiarColor(boton4_5);
    }

    //Sexta fila
    public void cambiar5_0(){
        matriz[5][0]=cambiarColor(boton5_0);
    }
    public void cambiar5_1(){
        matriz[5][1]=cambiarColor(boton5_1);
    }
    public void cambiar5_2(){
        matriz[5][2]=cambiarColor(boton5_2);
    }
    public void cambiar5_3(){
        matriz[5][3]=cambiarColor(boton5_3);
    }
    public void cambiar5_4(){
        matriz[5][4]=cambiarColor(boton5_4);
    }
    public void cambiar5_5(){
        matriz[5][5]=cambiarColor(boton5_5);
    }

    //Septima fila
    public void cambiar6_0(){
        matriz[6][0]=cambiarColor(boton6_0);
    }
    public void cambiar6_1(){
        matriz[6][1]=cambiarColor(boton6_1);
    }
    public void cambiar6_2(){
        matriz[6][2]=cambiarColor(boton6_2);
    }
    public void cambiar6_3(){
        matriz[6][3]=cambiarColor(boton6_3);
    }
    public void cambiar6_4(){
        matriz[6][4]=cambiarColor(boton6_4);
    }
    public void cambiar6_5(){
        matriz[6][5]=cambiarColor(boton6_5);
    }

    //Octava fila
    public void cambiar7_0(){
        matriz[7][0]=cambiarColor(boton7_0);
    }
    public void cambiar7_1(){
        matriz[7][1]=cambiarColor(boton7_1);
    }
    public void cambiar7_2(){
        matriz[7][2]=cambiarColor(boton7_2);
    }
    public void cambiar7_3(){
        matriz[7][3]=cambiarColor(boton7_3);
    }
    public void cambiar7_4(){
        matriz[7][4]=cambiarColor(boton7_4);
    }
    public void cambiar7_5(){
        matriz[7][5]=cambiarColor(boton7_5);
    }

    //Novena fila
    public void cambiar8_0(){
        matriz[8][0]=cambiarColor(boton8_0);
    }
    public void cambiar8_1(){
        matriz[8][1]=cambiarColor(boton8_1);
    }
    public void cambiar8_2(){
        matriz[8][2]=cambiarColor(boton8_2);
    }
    public void cambiar8_3(){
        matriz[8][3]=cambiarColor(boton8_3);
    }
    public void cambiar8_4(){
        matriz[8][4]=cambiarColor(boton8_4);
    }
    public void cambiar8_5(){
        matriz[8][5]=cambiarColor(boton8_5);
    }

    //Decima fila
    public void cambiar9_0(){
        matriz[9][0]=cambiarColor(boton9_0);
    }
    public void cambiar9_1(){
        matriz[9][1]=cambiarColor(boton9_1);
    }
    public void cambiar9_2(){
        matriz[9][2]=cambiarColor(boton9_2);
    }
    public void cambiar9_3(){
        matriz[9][3]=cambiarColor(boton9_3);
    }
    public void cambiar9_4(){
        matriz[9][4]=cambiarColor(boton9_4);
    }
    public void cambiar9_5(){
        matriz[9][5]=cambiarColor(boton9_5);
    }

    //Onceava fila
    public void cambiar10_0(){
        matriz[10][0]=cambiarColor(boton10_0);
    }
    public void cambiar10_1(){
        matriz[10][1]=cambiarColor(boton10_1);
    }
    public void cambiar10_2(){
        matriz[10][2]=cambiarColor(boton10_2);
    }
    public void cambiar10_3(){
        matriz[10][3]=cambiarColor(boton10_3);
    }
    public void cambiar10_4(){
        matriz[10][4]=cambiarColor(boton10_4);
    }
    public void cambiar10_5(){
        matriz[10][5]=cambiarColor(boton10_5);
    }

    //Doceava fila
    public void cambiar11_0(){
        matriz[11][0]=cambiarColor(boton11_0);
    }
    public void cambiar11_1(){
        matriz[11][1]=cambiarColor(boton11_1);
    }
    public void cambiar11_2(){
        matriz[11][2]=cambiarColor(boton11_2);
    }
    public void cambiar11_3(){
        matriz[11][3]=cambiarColor(boton11_3);
    }
    public void cambiar11_4(){
        matriz[11][4]=cambiarColor(boton11_4);
    }
    public void cambiar11_5(){
        matriz[11][5]=cambiarColor(boton11_5);
    }

    //Treceava o como se escriba fila
    public void cambiar12_0(){
        matriz[12][0]=cambiarColor(boton12_0);
    }
    public void cambiar12_1(){
        matriz[12][1]=cambiarColor(boton12_1);
    }
    public void cambiar12_2(){
        matriz[12][2]=cambiarColor(boton12_2);
    }
    public void cambiar12_3(){
        matriz[12][3]=cambiarColor(boton12_3);
    }
    public void cambiar12_4(){
        matriz[12][4]=cambiarColor(boton12_4);
    }
    public void cambiar12_5(){
        matriz[12][5]=cambiarColor(boton12_5);
    }

    //Catorceavazsshs o como se escriba fila
    public void cambiar13_0(){
        matriz[13][0]=cambiarColor(boton13_0);
    }
    public void cambiar13_1(){
        matriz[13][1]=cambiarColor(boton13_1);
    }
    public void cambiar13_2(){
        matriz[13][2]=cambiarColor(boton13_2);
    }
    public void cambiar13_3(){
        matriz[13][3]=cambiarColor(boton13_3);
    }
    public void cambiar13_4(){
        matriz[13][4]=cambiarColor(boton13_4);
    }
    public void cambiar13_5(){
        matriz[13][5]=cambiarColor(boton13_5);
    }


    public void conexion() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        /*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerConnection");

        final String connectionURL = "jdbc:mysql://localhost/escuela";
        final String user = "root";
        final String password = "";



        //DriverManager.registerDriver(new SQLServerDriver());
        Connection co= DriverManager.getConnection("http://localhost:8080/phpmyadmin/db_structure.php?server=1&db=mysql", "root", "");

        //Connection connection = DriverManager.getConnection(connectionURL,user,password);*/
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerConnection");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyecto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "tiiko123");

        System.out.println("Nos conectamos");

        String dtb = "SELECT * FROM disponibilidad";


    }
    public void consultar(){


    }

    public void actualizar() throws SQLException {

        Connection con = conectar.conexion();
        System.out.println("Entro aquilos valores");
        System.out.println(matriz[1][0]);
        for(int i = 0; i < 14; i++){
           String sql = "UPDATE disponibilidad SET id=?,Lunes=?, Martes=?, Miercoles=?, Jueves=?, Viernes=?,Sabado=? where id ="+(i+1);

            PreparedStatement statement = con.prepareStatement(sql);

            statement.executeUpdate("UPDATE disponibilidad SET id="+(1+i)+",Lunes="+matriz[i][0]+",Martes="+matriz[i][1]+",Miercoles="+matriz[i][2]+",Jueves="+matriz[i][3]+",Viernes="+matriz[i][4]+",Sabado="+matriz[i][5]+" where id ="+(i+1));

       }

/*
        while(statement.nex){

        }*/


        /*
        for(int i = 0; i < 14; i++){
            for(int j = 0; j < 6; j++){
                System.out.print("\t"+matriz[i][j]);
            }
            System.out.println("\n");
        }
         */
    }

    public void desconectar(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyecto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "tiiko123");
            con.close();
            System.out.println("Base de datos desconectada");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cargarUsuario(){

    }


    public void mostrarMatriz(){
        for(int i = 0; i < 14; i++){
            for(int j = 0; j < 7; j++){
                System.out.print("\t"+matriz[i][j]);
            }
            System.out.println("\n");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String sql ="SELECT * FROM disponibilidad";

        try{
            System.out.println("entra");


            System.out.println("Conect2 "+con);
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyecto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "tiiko123");

            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            int contador=0;
            while(rs.next()){

                matriz[contador][0]=Integer.parseInt(rs.getString("Lunes"));
                matriz[contador][1]=Integer.parseInt(rs.getString("Martes"));
                matriz[contador][2]=Integer.parseInt(rs.getString("Miercoles"));
                matriz[contador][3]=Integer.parseInt(rs.getString("Jueves"));
                matriz[contador][4]=Integer.parseInt(rs.getString("Viernes"));
                matriz[contador][5]=Integer.parseInt(rs.getString("Sabado"));
                matriz[contador][6]=Integer.parseInt(rs.getString("id"));
                contador++;
                System.out.println("oli");
                System.out.println(matriz[1][1]);

            }
            algo(matriz);

            sql ="SELECT * FROM usuarios";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            contador=0;
            while(rs.next()){

                profesor[0]=rs.getString("clv_usuario");
                profesor[1]=rs.getString("pass_usuario");
                profesor[2]=rs.getString("tipo_usuario");
                profesor[3]=rs.getString("idcarrera");
                profesor[4]=rs.getString("nombre_usuario");
                profesor[5]=rs.getString("nivel_ads");
                profesor[6]=rs.getString("contrato");

                contador++;
                System.out.println("oli");
                System.out.println(matriz[1][1]);

            }

            usuario.setText(profesor[0]);
            nombre.setText(profesor[4]);
            nivel.setText(profesor[5]);
            contrato.setText(profesor[6]);



            for(int i = 0; i < 7; i++){
                System.out.println(profesor[i]);
            }

        }catch (Exception e){

        }


    }
}
