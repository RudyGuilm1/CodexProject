package GestionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author norxciel
 */
public class Requests {
    private int id,percentChoco;
    private String name, descript;
    //private Bytes imgChoco;       A gérer pour l'image du chocolat.
    
    private static Connection connection = null;
    private static ArrayList<Requests> resultsList;
    
    private Requests(int pId, String pName, String pDescript, int pPercent){
        this.id = pId;
        this.name = pName;
        this.descript = pDescript;
        this.percentChoco = pPercent;
    }
    
    public static ArrayList<Requests> findAll() throws SQLException, ClassNotFoundException{
        
        Class.forName("org.sqlite.JDBC");
        CoToDB.getInstance();
        connection = CoToDB.getConnexion();
        
        if (connection != null){
            // Création du statement.
            Statement statement = connection.createStatement();
            
            // Requete SQL pour TOUT sélectionner.
            ResultSet resultSet = statement.executeQuery("SELECT id, Name, Description, Cacao FROM Chocolates ORDER BY id;");
            // Tant qu'on trouve un résultat...
            while(resultSet.next()){
                int id = -1;
                String name = "Not Found";
                String descript = "No Description";
                int percent = 0;

                id = resultSet.getInt("id");
                name = resultSet.getString("Name");
                descript = resultSet.getString("Description");
                percent = resultSet.getInt("Cacao");                

                //System.out.println(String.format("id: %s ~ name: %s",id,name));
                resultsList.add(new Requests(id, name, descript, percent));
            }
        }
        
        return resultsList;
    }
    
    @Override
    public String toString() {
        return  "Chocolat n°" + id + " : " + name+" (Cacao : "+percentChoco+"% )\n Description : "+descript;
    }
}
