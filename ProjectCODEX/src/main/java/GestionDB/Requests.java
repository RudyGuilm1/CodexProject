package GestionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static ArrayList<Requests> getResultsList() {
        return resultsList;
    }

    public Requests(int pId, String pName, String pDesc, int pPercent) {
        this.id = pId;
        this.name = pName;
        this.descript = pDesc;
        this.percentChoco = pPercent;
    }

    public Requests(String pName) {
        this.id = -1;
        this.name = pName;
        this.descript = "?";
        this.percentChoco = -1;
    }

    public Requests(String pName, String pDesc, int pPercent) {
        this.id = -1;
        this.name = pName;
        this.descript = pDesc;
        this.percentChoco = pPercent;
    }

    public Requests() {
        this.id = -1;
        this.name = "?";
        this.descript = "?";
        this.percentChoco = -1;
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
                // Fermeture du resultSet + statement.
                resultSet.close();
                statement.close();
                
            }
        }
        
        // ... Et on return notre tableau d'objet.
        return resultsList;
    }

    
    public void addToDB(String pName, String pDesc, int pCacao) throws SQLException, ClassNotFoundException {
        try (Statement statementAdd = connection.createStatement()) {
            
            // Déclaration d'un String pour la requète SQL + le PreparedStatement.
            String sql = "INSERT INTO Chocolates('Name','Description','Cacao') VALUES(?,?,?)";
            PreparedStatement preparedStatement = CoToDB.getConnexion().prepareStatement(sql);

            // Buffering du PreparedStatement.
            preparedStatement.setString(1, pName);
            preparedStatement.setString(2, pDesc);
            preparedStatement.setInt(3, pCacao);
            
            // Execution du PreparedStatement.
            boolean temp = preparedStatement.execute();
            
            // Fermeture du PreparedStatement.
            statementAdd.close();
        }
    }

    public void UpdateDB(String pName, String pDesc, int pCacao, String pNameList) throws SQLException, ClassNotFoundException {
        // Déclaration d'un String pour la requète SQL + le PreparedStatement.
        String sql = "UPDATE Chocolates SET Name = ?, Description = ?, Cacao = ? WHERE"
                        +" Name = ?";
        try (PreparedStatement preparedStatement = CoToDB.getConnexion().prepareStatement(sql)) {
            // Buffering du PreparedStatement.
            preparedStatement.setString(1, pName);
            preparedStatement.setString(2, pDesc);
            preparedStatement.setInt(3, pCacao);
            preparedStatement.setString(4, pNameList);
            
            // Execution du PreparedStatement.
            Boolean Querry = preparedStatement.execute();
        }
        
    }

    public void DeleteFromDB(String pName) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM 'Chocolates' WHERE Name = ?";
        
        try (PreparedStatement preparedStatement = CoToDB.getConnexion().prepareStatement(sql)) {
            preparedStatement.setString(1, pName);
            
            preparedStatement.execute();
            preparedStatement.close();
        }
    }
    public Requests returnObjByID(int pId) throws ClassNotFoundException {
        Requests buffer = new Requests();

        String sql = "SELECT Name,Description,Cacao FROM Chocolates WHERE id = ?";

        try (PreparedStatement preparedStatement = CoToDB.getConnexion().prepareCall(sql)) {
            preparedStatement.setInt(1, pId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                buffer.name = resultSet.getString("Name");
                buffer.descript = resultSet.getString("Description");
                buffer.percentChoco = resultSet.getInt("Cacao");
                resultSet.close();
            }
            
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Requests.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Err:Requests:preparedStatement");
        }

        return buffer;
    }

    @Override
    public String toString() {
        return "Chocolat n°" + id + " : " + name + " (Cacao : " + percentChoco + "%)\n\tDescription : " + descript;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public int getPercentChoco() {
        return percentChoco;
    }

    public String getDescript() {
        return descript;
    }
}
