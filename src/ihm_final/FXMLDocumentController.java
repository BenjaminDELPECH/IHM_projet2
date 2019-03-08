/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_final;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author benja
 */
public class FXMLDocumentController implements Initializable {
    
     
    final ObservableList<Student> data = FXCollections.observableArrayList(
            new Student("DELPECH", "Benjamin", "1996", "M1"),
            new Student("AUDOUARD", "Luc", "1996", "M1"),
            new Student("POULLOT", "Amandine", "1995", "M1")
    );
    @FXML
    private Label label;

   
    private final TableView myTable;
    
    @FXML
    private BorderPane myBorderP;

    @FXML
    private Button deleteStudent;

    public FXMLDocumentController() {
        this.myTable = new TableView();
    }
    formAddStudent formAdd = new formAddStudent(data);
    //FormUpdate formUpdate = new formUpdateStudent(data, Student);
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
          myBorderP.setTop(null);
        myBorderP.setCenter(null);
        myBorderP.setCenter(myTable);
       deleteStudent.setVisible(true);
        
        // TODO
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn yearCol = new TableColumn("Année de naissance");
        TableColumn promoCol = new TableColumn("Promo");
        TableColumn actionCol = new TableColumn("Selectionner");
        TableColumn updateCol = new TableColumn("Modifier");

        myTable.getColumns().addAll(firstNameCol, lastNameCol, yearCol, promoCol, actionCol, updateCol);

        //Define data in Observable list
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Student, String>("firstName")
        );
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Student, String>("lastName")
        );

        yearCol.setCellValueFactory(
                new PropertyValueFactory<Student, String>("year")
        );

        promoCol.setCellValueFactory(
                new PropertyValueFactory<Student, String>("promo")
        );

        actionCol.setCellValueFactory(
                new PropertyValueFactory<Student, String>("checkbox")
        );
        updateCol.setCellValueFactory(
                new PropertyValueFactory<Student, String>("update")
        );

        myTable.setItems(data);
        
         for (Student elem : data){
                elem.getUpdate().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               int index = data.indexOf(elem);
               FormUpdate formUpdate = new FormUpdate(data, elem);
              myBorderP.setCenter(null);
                myBorderP.setTop(formUpdate);
                deleteStudent.setVisible(false);
            }
            });
        }
        
    }

    @FXML
    private void delete(ActionEvent event) {

        ObservableList<Student> dataListRemove = FXCollections.observableArrayList();

        for (Student bean : data) {
            if (bean.getCheckbox().isSelected()) {
                dataListRemove.add(bean);
            }

        }
        data.removeAll(dataListRemove);
    }
    
    @FXML
    private void displayListStudent(){
       myBorderP.setTop(null);
        myBorderP.setCenter(null);
        myBorderP.setCenter(myTable);
       deleteStudent.setVisible(true);
        for (Student elem : data){
                elem.getUpdate().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               int index = data.indexOf(elem);
               FormUpdate formUpdate = new FormUpdate(data, elem);
              myBorderP.setCenter(null);
                myBorderP.setTop(formUpdate);
                deleteStudent.setVisible(false);
            }
            });
        }
    }
    
    @FXML
    private void displayAddStudent(){
         myBorderP.setTop(null);
        myBorderP.setCenter(null);
        myBorderP.setTop(formAdd);
        deleteStudent.setVisible(false);
    }
   

}
