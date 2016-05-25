package benjaminetrudy.projectcodex;

//import javax.swing.JFrame;
import GestionDB.CoToDB;
import GestionDB.Requests;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.CodexFrame;

/**
 *
 * @author norxciel
 */
public class CodexApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*CodexFrame fenetre = new CodexFrame();
        fenetre.setTitle("Bienvenue dans le Chocodex !");
        fenetre.setVisible(true);*/
                
        try{
            for (Requests ans : Requests.findAll()) {
                System.out.println(ans);
            }
        }catch (SQLException ex) {
            Logger.getLogger(CodexApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
