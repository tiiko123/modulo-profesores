package com.efectos.app;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControladorDir implements Initializable {

    App app = new App();
    String autor = "", titulo = "";
    List<List<String>> matriz = new ArrayList<List<String>>();
    List<List<String>> excelData;
    int contador = 1, global = 1, global2=1, posicionSeleccion = 0;
    @FXML
    TableView librosTV;
    @FXML
    TextField autorTF, tituloTF;
    @FXML
    TextField autorMTF, tituloMTF;
    @FXML
    Button leerB, seleccionarB, modificarB;
    @FXML
    Label errorL, errorL2, errorSeleccion, errorCoincidencia;
    String ruta = "/home/ahren/Escritorio/Efectos/ponderacion.xlsx";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void leerExcel() {
        try{

            String fileName="";
            this.leerB.setDisable(true);
            this.seleccionarB.setDisable(false);
            this.matriz = null;
            matriz = new ArrayList<List<String>>();
            if(this.excelData!=null){
                fileName = this.ruta;
            } else {
                //fileName = this.cargar2();
               fileName = "/home/ahren/Escritorio/Efectos/ponderacion.xlsx";
            }
            //this.matriz=null;
            try {
                InputStream myFile = new FileInputStream(new File(fileName));
                XSSFWorkbook wb = new XSSFWorkbook(myFile);
                XSSFSheet sheet = wb.getSheetAt(0);

                XSSFCell cell;
                XSSFRow row;

                for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
                    row = sheet.getRow(i);
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        cell = row.getCell(j);
                        //matriz POR excelData
                        this.matriz.add(new ArrayList<String>());
                        this.matriz.get(i).add(cell.toString());

                    }
                }
                System.out.println("Finalizado\n\n");

            } catch (Exception e) {
               
                System.out.println(e.getMessage());
            }
            this.cargarTabla();

        }catch(Exception e){

        }
    }

    public void cargarTabla() {

        this.global++;
        this.excelData = leerTabla();

        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

        for (int i = 0; i < (matriz.size() / matriz.get(0).size()); i++) {
            data.add(FXCollections.observableArrayList(matriz.get(i)));
            //System.out.println("Lo que le agrega: " + data.get(i));
        }
        librosTV.setItems(data);

        for (int i = 0; i < 5; i++) {
            int curCol = i;
            String nombreColumna = "";
            switch (curCol) {
                case 0:
                    nombreColumna = "Materia";
                    break;
                case 1:
                    nombreColumna = "Carrera";
                    break;
                case 2:
                    nombreColumna = "Ponderacion Profesor";
                    break;
                case 3:
                    nombreColumna = "Ponderacion Director de Carrera";
                    break;
                case 4:
                    nombreColumna = "Ponderacion Total";

            }
            final TableColumn<ObservableList<String>, String> column = new TableColumn<>(
                    nombreColumna
            );
            column.setCellValueFactory(
                    param -> new ReadOnlyObjectWrapper<>(param.getValue().get(curCol))
            );
            librosTV.getColumns().add(column);
        }


    }

    public void reiniciar() {
        librosTV.getColumns().clear();
    }

    public List<List<String>> leerTabla() {
        String nombreArchivo = this.ruta;
        //System.out.println("XXXX: "+ruta);
        List<List<String>> archivoExcel = new ArrayList();
        int contadorColumna = 0;
        int contadorFila = 0;

        try (InputStream inputStream = new FileInputStream(nombreArchivo)) {
            DataFormatter formatter = new DataFormatter();

            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                List<String> tempList = new ArrayList();

                for (Cell cell : row) {
                    String text = formatter.formatCellValue(cell);
                    System.out.print(++contadorColumna + ": " + text + " - ");
                    System.out.println(text.length());
                    tempList.add(text.length() == 0 ? "" : text);
                }
                contadorColumna = 0;
                archivoExcel.add(tempList);

                contadorFila++;
                if (contadorFila == 5) {
                    break;
                }
            }
        } catch (IOException | EncryptedDocumentException | InvalidFormatException ex) {
            System.out.println(ex.toString());

        }

        return archivoExcel;

    }

    public void seleccionar() {
        String seleccion = "";
        this.errorCoincidencia.setText("");

        seleccion = String.valueOf(librosTV.getSelectionModel().getSelectedItem());
        System.out.println("alab :" + seleccion);

        if (seleccion.equals("null")) {
            errorSeleccion.setTextFill(Color.RED);
            errorSeleccion.setText("* Seleccione un registro");
        } else {
            this.modificarB.setDisable(false);

            seleccion = seleccion.substring(1, seleccion.indexOf(","));
            errorSeleccion.setTextFill(Color.BLACK);
            errorSeleccion.setText(seleccion);

            int i = 0;
            while (i <= this.matriz.size() / this.matriz.get(0).size()) {
                if (String.valueOf(this.matriz.get(i).get(0)).equals(seleccion)) {

                    autorMTF.setText(this.matriz.get(i).get(3));
                    autorMTF.setDisable(false);

                    posicionSeleccion = i;
                    i = this.matriz.size() * 2;
                }
                i++;
            }


        }
    }

    public void modificar() throws IOException {
        int ponProf=0, ponDir=0, ponSum=0;
        boolean coincidencia = false;
        InputStream myFile = new FileInputStream(new File(this.ruta));
        XSSFWorkbook wb = new XSSFWorkbook(myFile);
        System.out.println(posicionSeleccion);
        XSSFSheet sheet = wb.getSheetAt(0);



            errorCoincidencia.setTextFill(Color.GREEN);
            errorCoincidencia.setText("Registro modificado!");


            Cell cell2Update = sheet.getRow(posicionSeleccion).getCell(2);


            Cell cell3Update = sheet.getRow(posicionSeleccion).getCell(3);
            cell3Update.setCellValue(autorMTF.getText());

            ponProf = Integer.parseInt(cell2Update.getStringCellValue());
            ponDir = Integer.parseInt(autorMTF.getText()) ;

            ponSum=ponProf+ponDir;
            Cell cell4Update = sheet.getRow(posicionSeleccion).getCell(4);
            cell4Update.setCellValue(String.valueOf(ponSum));
            FileOutputStream outputStream = new FileOutputStream(this.ruta);
            wb.write(outputStream);
            wb.close();
            outputStream.close();

            autorMTF.setText("");

            errorSeleccion.setText("");
            modificarB.setDisable(true);
            this.reiniciar();
            this.leerExcel();



    }

    private void removeEmptyRows(final Sheet sheet) {
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            boolean isRowEmpty;
            if (sheet.getRow(i) == null) {
                sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
                i--;
                continue;
            }
            final Row actualRow = sheet.getRow(i);
            isRowEmpty =
                    actualRow.getCell(1).toString().trim().equals("");
            if (isRowEmpty) {
                if (i == sheet.getLastRowNum()) {
                    sheet.removeRow(actualRow);
                } else {
                    sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);

                }
                i--;
            }

        }

        try {
            sheet.removeRow(sheet.getRow(sheet.getLastRowNum() + 1));
        } catch (Exception e) {

            System.out.println("--->" + sheet.getRow(sheet.getLastRowNum()));
        }

    }


}
