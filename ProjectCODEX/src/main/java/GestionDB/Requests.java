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

    private int id, percentChoco;
    private String name, descript;
    //private Bytes imgChoco;       A gérer pour l'image du chocolat.

    private static Connection connection = null;
    private static ArrayList<Requests> resultsList = new ArrayList();

    public Requests(int pId, String pName, String pDescript, int pPercent) {
        this.id = pId;
        this.name = pName;
        this.descript = pDescript;
        this.percentChoco = pPercent;
    }

    public static ArrayList<Requests> findAll() throws SQLException, ClassNotFoundException {

        // Etablissement de la connection.
        connection = CoToDB.getConnexion();

        if (connection != null) {
            // Requete SQL pour TOUT sélectionner.
            try (
                    // Création du statement.
                    Statement statement = connection.createStatement(); 
                    // Requete SQL pour TOUT sélectionner.
                    ResultSet resultSet = statement.executeQuery("SELECT id, Name, Description, Cacao FROM Chocolates ORDER BY id;")) {
                // Tant qu'on trouve un résultat...
                while (resultSet.next()) {
                    // ... On crée des variables locales tampon...
                    int id = -1;
                    String name = "Not Found";
                    String descript = "No Description";
                    int percent = 0;

                    // ... On buff les variables précédentes dans les résultats de la requète...
                    id = resultSet.getInt("id");
                    name = resultSet.getString("Name");
                    descript = resultSet.getString("Description");
                    percent = resultSet.getInt("Cacao");

                    // ... Et on ajoute dans l'ArrayList.
                    resultsList.add(new Requests(id, name, descript, percent));
                }

            }
        }

        return resultsList;
    }
    
    
    // Penser aux preparedStatements.
    public void addToDB() throws SQLException{
        try (Statement statementAdd = connection.createStatement()) {
            Boolean Querry = statementAdd.execute("INSERT INTO Chocolates(id,Name,Desccription,Cacao) VALUES('"+id+"','"+name+"','"+descript+"','"+percentChoco+"')");
        }
    }
    
    public void UpdateDB() throws SQLException{
        try (Statement statementUpdate = connection.createStatement()) {
            Boolean Querry = statementUpdate.execute("UPDATE Chocolates SET (...)");
        }
    }
    
    public void DeleteToDB() throws SQLException{
        Statement statementDel = connection.createStatement();
        
        Boolean Querry = statementDel.execute("");
    }

    @Override
    public String toString() {
        return "Chocolat n°" + id + " : " + name + " (Cacao : " + percentChoco + "%)\n\tDescription : " + descript;
    }
}
