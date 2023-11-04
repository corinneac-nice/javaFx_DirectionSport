package sio.leo.javafx_directionsport;
//https://www.youtube.com/watch?v=7mpnDYcg_EA
//***********************************
//ajouter dans module-info : exports sio.leo.javafx_directionsport.modele;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sio.leo.javafx_directionsport.modele.DAO_Utilisaleur;
import sio.leo.javafx_directionsport.modele.DAO_Utilisation;
import sio.leo.javafx_directionsport.modele.Utilisation;

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

    @FXML
    private TableView<Utilisation> tbv_Passage;
    @FXML private TitledPane titledPaneRecap;
    
    @FXML 
    private TableColumn <Utilisation, LocalDate> col_Achat; 
//     private TableColumn <Utilisation, String> col_Achat; 
    @FXML
    private TableColumn <Utilisation, LocalDate> col_Passage;
//    private TableColumn <Utilisation, String> col_Passage;
    public ObservableList<Utilisation> data= FXCollections.observableArrayList();
    
    DAO_Utilisaleur daoUser =new DAO_Utilisaleur();  
    DAO_Utilisation daoPassage= new DAO_Utilisation();
    

    
//    Image logo = new Image(getClass().getResourceAsStream("logo.png"));
//    public void afficheLogo() {
//        Image logo = new Image(getClass().getResourceAsStream("logo.png"));
//        ima_logo.setImage(logo);
//    }    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
//         try {
            //Initialise ComboBox des activités
             cmbActivités.setItems(lesActivites); //TODO récupérer activites dans la base
             cmbQte.setItems(lesQte);
             
//             //remplissage tableView
//             col_Achat.setCellValueFactory(new PropertyValueFactory<>("ach_date"));
//             col_Passage.setCellValueFactory(new PropertyValueFactory<>("dateutilisation"));
//             
//             tbv_Passage.setItems(daoPassage.getLesUtilisations("ADM10"));
//         } catch (SQLException ex) {
//             Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
//         }
    }
    @FXML
    public void cmbActiviteClic(ActionEvent levenement){
        lblActivite.setText(cmbActivités.getValue());
        System.out.println(cmbActivités.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    private void valideLogin(MouseEvent event)  {
            
         try {
             lbl_user.setText(daoUser.getUserById(txtId.getText()).getuti_nom());
         } catch (SQLException ex) {
             System.out.println("Probleme sur valideLogin()****************************************************");
             Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
             
         }
        
    }
    public void initTableView(MouseEvent event){
        String id=txtId.getText();
             //remplissage tableView
             col_Achat.setCellValueFactory(new PropertyValueFactory<>("ach_date"));
             col_Passage.setCellValueFactory(new PropertyValueFactory<>("dateutilisation"));
             
         try {
             tbv_Passage.setItems(daoPassage.getLesUtilisations(id));
         } catch (SQLException ex) {
             Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    

    
}
