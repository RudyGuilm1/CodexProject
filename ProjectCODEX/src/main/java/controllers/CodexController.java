/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import GestionDB.Requests;
import static GestionDB.Requests.getResultsList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import views.CodexFrame;//

/**
 *
 * @author norxciel
 */
public final class CodexController {

    private CodexFrame myView;

    /**
     *
     * @throws ClassNotFoundException
     */
    public CodexController() throws ClassNotFoundException {
        myView = new CodexFrame();
        InitCodexController();

        try {
            Refresh();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void InitCodexController() {

        ActionListener CodexButtonAddListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CodexBtnAdd();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Err:CodexController:BtnAdd");
                }
            }
        };

        ActionListener CodexButtonSupprListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CodexBtnSuppr();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Err:CodexController:BtnSuppr");
                }
            }
        };

        ActionListener CodexButtonUpdateListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CodexBtnUpdate();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Err:CodexController:BtnUpdate");
                }
            }
        };
        
        // Initialisation des différents boutons.
        myView.getBtn_Nouveau().addActionListener(CodexButtonAddListener);
        myView.getBtn_Delete().addActionListener(CodexButtonSupprListener);
        myView.getBtn_Save().addActionListener(CodexButtonUpdateListener);

        // Visibilité de la fenetre.
        myView.setVisible(true);
    }

    private void CodexBtnAdd() throws ClassNotFoundException {
        int percent;
        String name, desc;
        
        // Buffering de variables.
        name = myView.getTxtzone_NomChoco().getText();
        desc = myView.getTxtzone_Descript().getText();
        percent = Integer.parseInt(myView.getTxtzone_PourcentChoco().getText());
        
        // Création d'une variable newChoco et ajout dans la DB.
        Requests newChoco = new Requests();
        try {
            newChoco.addToDB(name, desc, percent);
        } catch (SQLException ex) {
            Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Err:CodexController:SQLAdd");
        }
        
        // Clear de zones + refresh de la liste.
        clearAll();
        Refresh();
    }

    private void CodexBtnSuppr() throws ClassNotFoundException {

        // Création de variable et delete de la DB.
        Requests delChoco = new Requests();       
        try {
            delChoco.DeleteFromDB(myView.get_listChoco().getSelectedValue());
        } catch (SQLException ex) {
            Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Err:CodexController:SQLDelete.");
        }
        
        // Clear de zones + refresh de la liste.
        clearAll();
        Refresh();
    }

    private void CodexBtnUpdate() throws ClassNotFoundException {
        // Déclaration de variable buffers.
        int percent;
        String name, desc;

        // Buffering des variables.
        if (myView.getTxtzone_NomChoco().getText() != "" || myView.getTxtzone_Descript().getText() != "" || myView.getTxtzone_PourcentChoco().getText() != "") {
            name = myView.getTxtzone_NomChoco().getText();
            desc = myView.getTxtzone_Descript().getText();
            percent = Integer.parseInt(myView.getTxtzone_PourcentChoco().getText());

            // Création d'une variable Requests et exécution de la méthode d'update.
            Requests updateChoco = new Requests(name, desc, percent);

            try {
                updateChoco.UpdateDB(name, desc, percent, myView.get_listChoco().getSelectedValue());
            } catch (SQLException ex) {
                Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Err:CodexController:SQLUpdate");
            }

            // Clear de zones + refresh de la liste.
            clearAll();
            Refresh();
        }else{
            System.out.println("Err:Update:Champs Vides !");
        }
    }

    /**
     *
     */
    public void clearAll() {
        // Méthode pour reset TOUS les champs.
        myView.getTxtzone_Descript().setText("");
        myView.getTxtzone_NomChoco().setText("");
        myView.getTxtzone_PourcentChoco().setText("");
        //myView.getPannel_ImgChoco().setText("");
    }

    /**
     *
     * @throws ClassNotFoundException
     */
    public void Refresh() throws ClassNotFoundException {
        // Création d'une variable buffer pour établir une nouvelle liste.
        DefaultListModel<String> bufferList = new DefaultListModel();
        getResultsList().clear();
        try {
            // Pour chaque résultat : ajout dans le buffer.
            for (Requests ans : Requests.findAll()) {
                bufferList.addElement(ans.getName());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Err:CodexController:Refresh");
        }

        // On remplace l'ancienne liste par le buffer.
        myView.get_listChoco().setModel(bufferList);

    }

}
