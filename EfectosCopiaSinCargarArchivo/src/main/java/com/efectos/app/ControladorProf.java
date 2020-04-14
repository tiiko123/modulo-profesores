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
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class ControladorProf implements Initializable {

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
    Button agregarB, leerB, consolaB, crearB, agregarBibB, seleccionarB, modificarB, eliminarB, backupB;
    @FXML
    Label errorL, errorL2, errorSeleccion, errorCoincidencia;
    String ruta = "";


    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {

    }

    public void crearExcel() {
        this.crearB.setDisable(true);

        this.global--;
        final String[] data = new String[]{"Autor", "Titulo"};
        final String fileName = "/home/ahren/profes.xlsx";
        final XSSFWorkbook workbook = new XSSFWorkbook();
        final XSSFSheet sheet = workbook.createSheet("Hoja prueba");


        for (int j = 0; j < 1; j++) {// 2 por el Encabezado y la linea de informacion
            final XSSFRow row = sheet.createRow(j);
            for (int i = 0; i < data.length; i++) {// Tantos loops como info en el arreglo
                final XSSFCell cell = row.createCell(i);
                if (j == 0) {
                    //cell.setCellValue(data[i]);
                }
            }
        }


        try {
            FileOutputStream fos = null;
            File file;

            file = new File(fileName);
            fos = new FileOutputStream(file);

            workbook.write(fos);
            workbook.close();
            fos.close();
            System.out.println("Finalizado");

        } catch (final Exception e) {
          
            System.out.println(e.getMessage());
        }

        //this.cargarTabla();
    }

    public String cargar2() {
        String rutaS="";
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        final FileNameExtensionFilter filter = new FileNameExtensionFilter("Hoja de Excel", "xlsx");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.showOpenDialog(null);

        final File selectedFile = fileChooser.getSelectedFile();

        // this.ruta = selectedFile.getName();
        rutaS = selectedFile.getPath();
        this.ruta=rutaS;
        System.out.println("RUTA: "+this.ruta);
        System.out.println("RUTA2: "+rutaS);
        return rutaS;


    }



   public void empezarExcel(final String tituloT, final String autorT) {
        //this.crearB.setDisable(true);
        final String[] data2 = new String[]{tituloT, autorT};
        final String fileName = this.ruta;
        final XSSFWorkbook workbook = new XSSFWorkbook();
        final XSSFSheet sheet = workbook.createSheet("Hoja prueba");


        for (int j = 0; j < 1; j++) {// 2 por el Encabezado y la linea de informacion
            final XSSFRow row = sheet.createRow(j);
            for (int i = 0; i < data2.length; i++) {// Tantos loops como info en el arreglo
                final XSSFCell cell = row.createCell(i);
                if (j == 0) {
                    cell.setCellValue(data2[i]);
                }
            }
        }


        try {
            FileOutputStream fos = null;
            File file;

            file = new File(fileName);
            fos = new FileOutputStream(file);

            workbook.write(fos);
            workbook.close();
            fos.close();
            System.out.println("Finalizado");

        } catch (final Exception e) {
           
            System.out.println(e.getMessage());
        }
    }

    public void leerExcel() {
        try{

            String fileName="";
            this.leerB.setDisable(true);
            this.seleccionarB.setDisable(false);
            this.agregarB.setDisable(false);
            this.agregarBibB.setDisable(false);
            this.matriz = null;
            matriz = new ArrayList<List<String>>();
            if(this.excelData!=null){
                fileName = this.ruta;
            } else {
                fileName = this.cargar2();
            }
            //this.matriz=null;
            try {
                final InputStream myFile = new FileInputStream(new File(fileName));
                final XSSFWorkbook wb = new XSSFWorkbook(myFile);
                final XSSFSheet sheet = wb.getSheetAt(0);

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

            } catch (final Exception e) {
             
                System.out.println(e.getMessage());
            }
            this.cargarTabla();

        }catch(final Exception e){

        }
    }

    public void cargarTabla() {

        this.global++;
        this.excelData = leerTabla();
        this.backupB.setDisable(false);
        final ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
        //matriz por excelData
        System.out.println("Elegido: "+(matriz.size() / matriz.get(0).size()));//DA 0
        for (int i = 0; i < (this.matriz.size() / this.matriz.get(0).size()); i++) {
            data.add(FXCollections.observableArrayList(this.matriz.get(i)));
            System.out.println("Lo que le agrega: " + data.get(i));
        }
        //this.matriz=this.excelData;

        librosTV.setItems(data);

        for (int i = 0; i <= 1; i++) {
            final int curCol = i;
            String nombreColumna = "";
            switch (curCol) {
                case 0:
                    nombreColumna = "Titulo";
                    break;
                case 1:
                    nombreColumna = "Autor";
                    break;
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
        final String nombreArchivo = this.ruta;
        System.out.println("XXXX: "+ruta);
        final List<List<String>> archivoExcel = new ArrayList();
        int contadorColumna = 0;
        int contadorFila = 0;

        try (InputStream inputStream = new FileInputStream(nombreArchivo)) {
            final DataFormatter formatter = new DataFormatter();

            final Workbook workbook = WorkbookFactory.create(inputStream);
            final Sheet sheet = workbook.getSheetAt(0);

            for (final Row row : sheet) {
                final List<String> tempList = new ArrayList();

                for (final Cell cell : row) {
                    if(contadorColumna<=1){
                        final String text = formatter.formatCellValue(cell);
                        System.out.print(++contadorColumna + ": " + text + " - ");
                        System.out.println(text.length());
                        tempList.add(text.length() == 0 ? "" : text);
                    }

                }

                contadorColumna = 0;
                archivoExcel.add(tempList);

                contadorFila++;
                if (contadorFila == 1) {
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
            this.eliminarB.setDisable(false);
            seleccion = seleccion.substring(1, seleccion.indexOf(","));
            errorSeleccion.setTextFill(Color.BLACK);
            errorSeleccion.setText("Articulo seleccionado: " + seleccion);

            int i = 0;
            while (i <= this.matriz.size() / this.matriz.get(0).size()) {
                if (String.valueOf(this.matriz.get(i).get(0)).equals(seleccion)) {
                    tituloMTF.setText(this.matriz.get(i).get(0));

                    tituloMTF.setText(this.matriz.get(i).get(0));
                    autorMTF.setText(this.matriz.get(i).get(1));

                    tituloMTF.setDisable(false);
                    autorMTF.setDisable(false);

                    posicionSeleccion = i;
                    i = this.matriz.size() * 2;
                }
                i++;
            }


        }
    }

    public void modificar() throws IOException {
        final boolean coincidencia = false;
        final InputStream myFile = new FileInputStream(new File(this.ruta));
        final XSSFWorkbook wb = new XSSFWorkbook(myFile);
        System.out.println(posicionSeleccion);
        final XSSFSheet sheet = wb.getSheetAt(0);


        if (coincidencia == true) {
            errorCoincidencia.setTextFill(Color.RED);
            errorCoincidencia.setText("* Error: ID ya registrado");
        } else {
            errorCoincidencia.setTextFill(Color.GREEN);
            errorCoincidencia.setText("Registro modificado!");
            final Cell cell1Update = sheet.getRow(posicionSeleccion).getCell(0);
            cell1Update.setCellValue(tituloMTF.getText());

            final Cell cell2Update = sheet.getRow(posicionSeleccion).getCell(1);
            cell2Update.setCellValue(autorMTF.getText());

            final FileOutputStream outputStream = new FileOutputStream(this.ruta);
            wb.write(outputStream);
            wb.close();
            outputStream.close();


            autorMTF.setText("");
            tituloMTF.setText("");

            errorSeleccion.setText("");
            modificarB.setDisable(true);
            eliminarB.setDisable(true);
            this.reiniciar();
            this.leerExcel();
        }


    }

    public void backup() throws IOException {
        String rutaBackup=this.ruta;
        rutaBackup=rutaBackup.substring(0,rutaBackup.indexOf("."));
        rutaBackup=rutaBackup+"(Backup).xlsx";
        System.out.println("LEEEL: "+rutaBackup);

        final InputStream myFile = new FileInputStream(new File(this.ruta));
        final XSSFWorkbook wb = new XSSFWorkbook(myFile);
        FileOutputStream fos = null;
        File file;

        file = new File(this.ruta);


        // this.ruta = selectedFile.getName();

        fos = new FileOutputStream(rutaBackup);

        wb.write(fos);
        wb.close();
        try {
            fos.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminar() throws IOException, InvalidFormatException {
        String nuevoNombre =this.ruta;
        final StringBuilder builder=new StringBuilder(nuevoNombre);
        nuevoNombre=builder.reverse().toString();

        nuevoNombre=nuevoNombre.substring(0,nuevoNombre.indexOf("/"));

        final StringBuilder builder2=new StringBuilder(nuevoNombre);
        nuevoNombre=builder2.reverse().toString();


        final InputStream myFile = new FileInputStream(new File(this.ruta));
        final XSSFWorkbook wb = new XSSFWorkbook(myFile);
        System.out.println(posicionSeleccion);
        final XSSFSheet sheet = wb.getSheetAt(0);

        sheet.removeRow(sheet.getRow(posicionSeleccion));
        removeEmptyRows(sheet);
        final FileOutputStream outputStream = new FileOutputStream(nuevoNombre);
        wb.write(outputStream);
        wb.close();
        outputStream.close();


        autorMTF.setText("");
        tituloMTF.setText("");

        errorSeleccion.setText("");
        modificarB.setDisable(true);
        eliminarB.setDisable(true);

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
        } catch (final Exception e) {

            System.out.println("--->" + sheet.getRow(sheet.getLastRowNum()));
        }

    }


}
