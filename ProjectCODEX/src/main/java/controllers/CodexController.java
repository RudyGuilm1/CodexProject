/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import GestionDB.Requests;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import views.CodexFrame;

/**
 *
 * @author norxciel
 */
public final class CodexController {

    private CodexFrame myView;
    
    public CodexController(){
        myView = new CodexFrame();
        InitCodexController();
        
        try {
            Refresh();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        myView.getBtn_Save().setEnabled(false);
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

        myView.getBtn_Nouveau().addActionListener(CodexButtonAddListener);
        myView.getBtn_Delete().addActionListener(CodexButtonSupprListener);
        myView.getBtn_Save().addActionListener(CodexButtonUpdateListener);
        
        myView.setVisible(true);
    }

    private void CodexBtnAdd() throws ClassNotFoundException {
        int id, percent;
        String name, desc;

        id = -1;
        name = myView.getTxtzone_NomChoco().getText();
        desc = myView.getTxtzone_Descript().getText();
        percent = Integer.parseInt(myView.getTxtzone_PourcentChoco().getText());

        Requests newChoco = new Requests(id, name, desc, percent);
        try {
            newChoco.addToDB();
        } catch (SQLException ex) {
            Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Err:CodexController:SQLAdd");
        }

        clearAll();
        Refresh();
    }

    private void CodexBtnSuppr() throws ClassNotFoundException {
        
        Requests delChoco = new Requests(myView.getTxtzone_NomChoco().getText());
        
        try {
            delChoco.DeleteFromDB();
        } catch (SQLException ex) {
            Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Err:CodexController:SQLDelete.");
        }
        
        clearAll();
        Refresh();
    }

    private void CodexBtnUpdate() throws ClassNotFoundException {
        // Déclaration de variable buffers.
        int percent;
        String name, desc;
        
        // Buffering des variables.
        name = myView.getTxtzone_NomChoco().getText();
        desc = myView.getTxtzone_Descript().getText();
        percent = Integer.parseInt(myView.getTxtzone_PourcentChoco().getText());
        
        // Création d'une variable Requests et exécution de la méthode d'update.
        Requests updateChoco = new Requests(name, desc, percent);
        try {
            updateChoco.UpdateDB();
        } catch (SQLException ex) {
            Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Err:CodexController:SQLUpdate");
        }
        
        // Clean des champs & rafraichissement de la liste.
        clearAll();
        Refresh();
    }

    public void clearAll() {
        // Méthode pour reset TOUS les champs.
        myView.getTxtzone_Descript().removeAll();
        myView.getTxtzone_NomChoco().removeAll();
        myView.getTxtzone_PourcentChoco().removeAll();
        myView.getPannel_ImgChoco().removeAll();
    }

    public void Refresh() throws ClassNotFoundException {
        // Création d'une variable buffer pour établir une nouvelle liste.
        DefaultListModel<String> bufferList = new DefaultListModel();
        
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
        this.myView.get_listChoco().setModel(bufferList);
    }
}