/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_final;


/**
 *
 * @author benja
 */
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class Student {
    private String firstName;
    private String lastName;
    private String year;
    private String promo;
    private CheckBox checkbox;  
    private Button update;
    
 
        Student(String fName, String lName, String year, String promo) {
        this.firstName = fName;
        this.lastName = lName;
        this.year = year;
        this.promo = promo;
        this.checkbox = new CheckBox();
        this.update = new Button("Modifier");
    }
 
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String fName) {
        this.firstName= fName;
    }
        
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String fName) {
        this.lastName= fName;
    }
    
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    
    public String getPromo() {
        return promo;
    }
    public void setPromo(String promo) {
        this.promo = promo;
    }
    

    public CheckBox getCheckbox() {
        return checkbox;
    }
 
    public void setCheckBox(CheckBox checkbox) {
        this.checkbox = checkbox;
    }
    
    public Button getUpdate(){
        return this.update;
    }
    public void setUpdate(Button update) {
        this.update = update;
    }
    
    
    
    
}