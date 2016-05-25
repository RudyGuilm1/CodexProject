package benjaminetrudy.projectcodex;

//import javax.swing.JFrame;
import GestionDB.CoToDB;
import GestionDB.Requests;
import java.sql.SQLException;
import views.CodexFrame;

/**
 *
 * @author norxciel
 */
public class CodexApplication {

    public static void main(String[] args) throws SQLException {
        /*CodexFrame fenetre = new CodexFrame();
        fenetre.setTitle("Bienvenue dans le Chocodex !");
        fenetre.setVisible(true);*/
                
        for (Requests ans : Requests.findAll()) {
                System.out.println(ans);
        }
    }
}
