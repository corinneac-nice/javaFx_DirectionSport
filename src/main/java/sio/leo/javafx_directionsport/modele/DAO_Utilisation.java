/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.leo.javafx_directionsport.modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Corinne
 */
public class DAO_Utilisation {
    private Utilisation uti;
    private final Connection connexion; 
    private PreparedStatement psmt;
    private ResultSet curseur;
    private ObservableList<Utilisation> lesUtilisations=FXCollections.observableArrayList();
    
    public DAO_Utilisation(){
        this.connexion=new DAO_DirectionSport().getConnexion();
    } 
    
    public ObservableList<Utilisation> getLesUtilisations(String id, String activite) throws SQLException{
      
    String laRequete = "select uti_id,ach_date, dateutilisation from utiliser where uti_id = ? and act_id= ?;"; 
      
        psmt = connexion.prepareStatement(laRequete);
        psmt.setString(1, id);
        psmt.setString(2, activite);
        curseur=psmt.executeQuery();
        //postionne sur 1er élément du curseur (si non vide)
        while(curseur.next()){
            //Instancie un Utilisateur
            uti=new Utilisation(
                    curseur.getString("uti_id"),
                    //dateEnSql.toLocalDate() pour convertion d'une sql date en LocalDate java
                    curseur.getDate("ach_date").toLocalDate(),
                    curseur.getDate("dateutilisation").toLocalDate()
            );    
            lesUtilisations.add(uti);
            
        }
        return lesUtilisations;
    }
}
