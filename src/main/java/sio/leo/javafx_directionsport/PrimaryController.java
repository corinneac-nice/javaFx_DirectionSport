package sio.leo.javafx_directionsport;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//https://www.youtube.com/watch?v=7mpnDYcg_EA
public class PrimaryController implements Initializable{
     @FXML
    private ComboBox<String> cmbActivités;
     ObservableList<String> lesActivites=FXCollections.observableArrayList("Piscine","Patinoire");
     @FXML 
     private Label lblActivite;
    @FXML
    private TextField txtId;

     @FXML
    private ComboBox<Integer> cmbQte;
     ObservableList<Integer> lesQte=FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);

    
    

    
//    Image logo = new Image(getClass().getResourceAsStream("logo.png"));
//    public void afficheLogo() {
//        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
//        ima_logo.setImage(logo);
//    }    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      cmbActivités.setItems(lesActivites);
      cmbQte.setItems(lesQte);
        
    }
    @FXML
    public void cmbActiviteClic(ActionEvent levenement){
        lblActivite.setText(cmbActivités.getValue());
        System.out.println(cmbActivités.getSelectionModel().getSelectedItem());
    }
    
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    

    
}
