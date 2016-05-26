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
import views.CodexFrame;

/**
 *
 * @author norxciel
 */
public class CodexController {

    private CodexFrame myView;

    public CodexController() {

        ActionListener CodexButtonAddListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CodexBtnAdd();
                } catch (SQLException ex) {
                    Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        ActionListener CodexButtonSupprListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CodexBtnSuppr();
            }
        };

        ActionListener CodexButtonUpdateListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CodexBtnUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(CodexController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        myView.getBtn_Nouveau().addActionListener(CodexButtonAddListener);

    }

    private void CodexBtnAdd() throws SQLException {
        int id,percent;
        String name, desc;
        
        id = -1;
        name = myView.getTxtzone_NomChoco().getText();
        desc = myView.getTxtzone_Descript().getText();
        percent = Integer.parseInt(myView.getTxtzone_PourcentChoco().getText());
        
        Requests newChoco = new Requests(id, name, desc, percent);
        newChoco.addToDB();
        
        clearAll();
    }

    private void CodexBtnSuppr() {
        
        clearAll();
    }
    
    private void CodexBtnUpdate() throws SQLException{
        int id,percent;
        String name, desc;
        
        id = -1;
        name = myView.getTxtzone_NomChoco().getText();
        desc = myView.getTxtzone_Descript().getText();
        percent = Integer.parseInt(myView.getTxtzone_PourcentChoco().getText());
        
        Requests updateChoco = new Requests(id, name, desc, percent);
        updateChoco.UpdateDB();
        
        clearAll();
    }
    
    public void Refresh(){
        
    }
    
    public void clearAll(){
        myView.getTxtzone_Descript().removeAll();
        myView.getTxtzone_NomChoco().removeAll();
        myView.getTxtzone_PourcentChoco().removeAll();
        myView.getPannel_ImgChoco().removeAll();
    }
    
    public void iniList() throws ClassNotFoundException, SQLException{
            for (Requests ans : Requests.findAll()) {
                // Ajouter des lignes dans la liste.
            }
    }
}
