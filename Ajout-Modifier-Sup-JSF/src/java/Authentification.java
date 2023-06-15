/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
@Named(value = "authentification")
@SessionScoped
public class Authentification implements Serializable {

    private String email ;
        private String pass ;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
            
    public Authentification() {
        
        
    }
    
    public String verifier(){
        
     if(email == "test" && pass =="test")
         System.out.println("bonjour");
            return "create.xhtml?faces=redirect=true" ;
    }

    
}