package sio.leo.javafx_directionsport;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sio.leo.javafx_directionsport.modele.DAO_Utilisaleur;
import sio.leo.javafx_directionsport.modele.Utilisateur;
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
    private Button btn_valideLogin;

    @FXML
    private Label lbl_user;
        
    @FXML
    private ComboBox<Integer> cmbQte;
     ObservableList<Integer> lesQte=FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);

    DAO_Utilisaleur daoUser =new DAO_Utilisaleur();  ;
    

    
//    Image logo = new Image(getClass().getResourceAsStream("logo.png"));
//    public void afficheLogo() {
//        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
//        ima_logo.setImage(logo);
//    }    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      cmbActivités.setItems(lesActivites); //TODO récupérer activites dans la base
      cmbQte.setItems(lesQte);
      
    }
    @FXML
    public void cmbActiviteClic(ActionEvent levenement){
        lblActivite.setText(cmbActivités.getValue());
        System.out.println(cmbActivités.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    private void valideLogin(MouseEvent event) throws SQLException {
        Utilisateur user= daoUser.getUserById(txtId.getText());
        System.out.println( user);
        String login= user.getuti_nom();
        lbl_user.setText(login);

    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    

    
}
