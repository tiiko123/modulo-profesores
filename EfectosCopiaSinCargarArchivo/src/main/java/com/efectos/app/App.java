package com.efectos.app;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args ) {

    launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/1.fxml"));
            op.show();

        } catch (IOException e) {
            System.out.println("error: "+e);
        }
    }

    public void fxml2(){
        try {
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/2.fxml"));
            op.show();

        } catch (IOException e) {
            System.out.println("error");
        }
    }
    public void fxml3(){
        try {
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/3.fxml"));
            op.show();

        } catch (IOException e) {
            System.out.println("error");
        }
    }
    public void fxml3b(){
        try {
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/3b.fxml"));
            op.show();

        } catch (IOException e) {
            System.out.println("error");
        }
    }
    public void fxml4(){
        try {
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/4.fxml"));
            op.show();

        } catch (IOException e) {
            System.out.println("error");
        }
    }
    public void todo(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/todo.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("error entrada");

        }
    }

    public void evaluar(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/eva.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("error ");

        }
    }

    public void dispo(){
        try {
            final Stage op = FXMLLoader.load(getClass().getResource("/FXML/Disponibilidad.fxml"));
            op.show();
            

        } catch (final IOException e) {
            System.out.println("error: ");
        }
    }

    public void men_director(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/menu_director.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("error ");

        }
    }

    public void menu_profes(){
        try{
            Stage op = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
            op.show();
        }catch (Exception e){
            System.out.println("error ");

        }
    }
    
    

}
