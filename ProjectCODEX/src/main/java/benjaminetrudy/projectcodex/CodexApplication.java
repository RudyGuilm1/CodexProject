/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package benjaminetrudy.projectcodex;

import javax.swing.JFrame;
import views.CodexFrame;

/**
 *
 * @author norxciel
 */
public class CodexApplication {
    public static void main(String[] args) {
        CodexFrame fenetre = new CodexFrame();
        fenetre.setTitle("Bienvenue dans le Chocodex !");
        fenetre.setVisible(true);
        //System.out.println("Bonjour, Chocolat");
    }
}
