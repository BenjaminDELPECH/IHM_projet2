/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_final;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import static jdk.nashorn.internal.objects.NativeRegExpExecResult.length;

/**
 *
 * @author benja
 */
public class formAddStudent extends Parent {

    public formAddStudent(ObservableList<Student> data) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

       
        
        Text scenetitle = new Text("Ajouter un étudiant");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 3, 1);

        Label nomLabel = new Label("Nom:");
        grid.add(nomLabel, 0, 1);

        TextField nomTextField = new TextField();
        grid.add(nomTextField, 1, 1);

        final Text nomError = new Text("");
        grid.add(nomError, 2, 1);

        Label prenomLabel = new Label("Prénom:");
        grid.add(prenomLabel, 0, 2);

        TextField prenomTextField = new TextField();
        grid.add(prenomTextField, 1, 2);

        final Text prenomError = new Text("");
        grid.add(prenomError, 2, 2);

        //Date Naissance
        Label dateNaissanceLabel = new Label("Date de naissance:");
        grid.add(dateNaissanceLabel, 0, 3);
        TextField dateNaissanceField = new TextField();
        grid.add(dateNaissanceField, 1, 3);
        final Text dateError = new Text();
        dateError.setFill(Color.FIREBRICK);
        grid.add(dateError, 2, 3);

        Label selectPromotionLabel = new Label("Promotion:");
        grid.add(selectPromotionLabel, 0, 4);

        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().add("L3");
        choiceBox.getItems().add("M1");
        choiceBox.getItems().add("M2");
        choiceBox.getStyleClass().add("test");
        grid.add(choiceBox, 1, 4);

        Button btn = new Button("Valider");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);
        final Text actiontarget = new Text("");
        grid.add(actiontarget, 1, 6);
        
        
        ImageView add_etu = new ImageView(new Image(formAddStudent.class.getResourceAsStream("images/add.png")));
        add_etu.setFitHeight(50);
        
        
        grid.setMinWidth(500);
        
        
        this.getChildren().add(grid);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                nomError.setFill(Color.FIREBRICK);
                prenomError.setFill(Color.FIREBRICK);
                boolean valid = true;
                
                
                switch (verifChampsStudent.verifName(nomTextField.getText())) {
                    case 1:
                        nomError.setText("Champ vide");
                        valid = false;
                        break;
                    case 2:
                        nomError.setText("Champ invalide");
                        valid = false;
                        break;
                    default:
                        nomError.setText("");
                        break;
                }

                switch (verifChampsStudent.verifName(prenomTextField.getText())) {
                    case 1:
                        prenomError.setText("Champ vide");
                        valid = false;
                        break;
                    case 2:
                        prenomError.setText("Champ invalide");
                        valid = false;
                        break;
                    default:
                        prenomError.setText("");
                        break;
                }

                if (dateNaissanceField.getText().length()!=0) {
                    switch (verifChampsStudent.verifDateOfBirth(Integer.valueOf(dateNaissanceField.getText()))) {
                        case 1:
                            dateError.setText("Champ vide");
                            valid = false;
                            break;
                        case 2:
                            dateError.setText("Champ invalide");
                            valid = false;
                            break;
                        default:
                            dateError.setText("");
                            break;
                    }
                } else {
                    dateError.setText("Champ vide");
                }

                if (valid) {
                    Student student1 = new Student(nomTextField.getText(), prenomTextField.getText(), dateNaissanceField.getText(), choiceBox.getValue().toString());
                    nomTextField.clear();
                    prenomTextField.clear();
                    dateNaissanceField.clear();
                    
                    
                    data.add(student1);
                    
                    final Text success = new Text("Vos modifications ont bien été enregistrées");
                    success.setFill(Color.GREEN);
                    grid.add(success, 0, 7);
                }
            }
        });

        dateNaissanceField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue
            ) {
                if (!newValue.matches("\\d*")) {
                    dateNaissanceField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }
}
