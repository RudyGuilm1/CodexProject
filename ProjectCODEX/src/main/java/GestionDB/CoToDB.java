package GestionDB;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author norxciel
 */
public class CoToDB {

    // création d'une instance typée CoToDB pour le singleton.
    private static volatile CoToDB instance = null;
    private static Connection DBConnect = null;

    // Constructeur pour établir la connection à la base de donnée.
    private CoToDB() throws SQLException {
        String pathDB = "";

        // Déclaration d'une variable file.
        JFileChooser fileChooser = new JFileChooser();

        // Entrée des filtres, puis application du filtre.
        FileNameExtensionFilter filter = new FileNameExtensionFilter("SQLite", "sqlite");
        fileChooser.setFileFilter(filter);

        // Ouverture de la boite de dialogue pour sélectionner le chemin de la DB.
        int returnVal = fileChooser.showOpenDialog(null);

        // Si l'utilisateur a bien sélectionné un fichier et a bien cliqué sur "ouvrir", alors...
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // Stockage du fichier sélectionné par l'utilisateur.
            File file = fileChooser.getSelectedFile();

            // Stockage du path dans la variable.
            pathDB = file.getAbsolutePath();

            // Etablissement de la connection à la base de données.
            CoToDB.DBConnect = DriverManager.getConnection("jdbc:sqlite:" + pathDB);
        }
    }

    // Methode d'obtention d'instance de la connection à la base de donnée.

    /**
     *
     * @return
     */
    public static CoToDB getInstance() {
        if (instance == null) {
            try {
                instance = new CoToDB();
            } catch (SQLException ex) {
                Logger.getLogger(CoToDB.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erreur de connection à la BDD");
            }
        }

        return instance;
    }

    // Getter pour obtenir la connection à la base de données.

    /**
     *
     * @return
     * @throws ClassNotFoundException
     */
    public static Connection getConnexion() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        CoToDB.getInstance();

        return DBConnect;
    }
}
