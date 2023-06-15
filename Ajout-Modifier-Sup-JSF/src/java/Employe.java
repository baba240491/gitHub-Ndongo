/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.* ;

/**
 *
 * @author LENOVO
 */
@Named(value = "employe")
@SessionScoped
public class Employe implements Serializable {
       private int matricule ;
        private float salaire ;
        private String nom ;

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    public Employe() {
    }
    
   public ArrayList Afficher(){
          
          ArrayList l1 = new ArrayList();
       
        try           
            {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection co;
               co=DriverManager.getConnection("jdbc:mysql://localhost:3306/serveurj","root","");
               Statement s1 = co.createStatement();
               String req ="select* from employe" ;
               ResultSet res= s1.executeQuery(req);
              
               
                    while(res.next()){
                       Employe emp = new Employe();
                       emp.setMatricule(res.getInt("matricule"));
                       emp.setNom(res.getString("nom"));
                       emp.setSalaire(res.getFloat("salaire"));
                       l1.add(emp);
                    
                    }
               
            }
            catch(ClassNotFoundException e11)
            {
                System.out.println("err pilote");
            }
            catch(SQLException e2)
            {
               System.out.println("err connection");
            }
           return l1 ;
       
       
   }

public String save() {
    
    try           
            {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection co;
               co=DriverManager.getConnection("jdbc:mysql://localhost:3306/serveurj","root","");
               PreparedStatement s1 = co.prepareStatement("insert into employe values (?,?,?)");
               s1.setInt(1, matricule);
               s1.setString(2, nom);
               s1.setFloat(3, salaire);
               
               int res = s1.executeUpdate();
               
            }
            catch(ClassNotFoundException e3)
            {
                System.out.println("err pilote");
            }
            catch(SQLException e4)
            {
               System.out.println("err connection");
            }
    
           return "index.xhtml?faces-redirect=true";
          
}
    
public String delete(int id){
    
                try           
            {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection co;
               co=DriverManager.getConnection("jdbc:mysql://localhost:3306/serveurj","root","");
               Statement s1 =co.createStatement();
              String req = "delete from  employe where matricule ="+id  ;
               int res = s1.executeUpdate(req) ;
               
            }
            catch(ClassNotFoundException e3)
            {
                System.out.println("err pilote");
            }
            catch(SQLException e4)
            {
               System.out.println("err connection");
            }
    
           return "index.xhtml?faces-redirect=true";
          
}
    
    public String Rechercher(int id){
     Employe emp =new Employe();
                try           
            {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection co;
               co=DriverManager.getConnection("jdbc:mysql://localhost:3306/serveurj","root","");
               Statement s1 =co.createStatement();
              String req = "select* from  employe where matricule ="+id  ;
                  ResultSet res = s1.executeQuery(req);
                
                  while(res.next()){
                       
                        emp.setMatricule(res.getInt("matricule"));
                        emp.setNom(res.getString("nom"));
                        emp.setSalaire(res.getFloat("salaire"));          
            }
               emp.matricule=0;
               emp.nom="";
               emp.salaire=0 ;
               
                  
            }
            catch(ClassNotFoundException e3)
            {
                System.out.println("err pilote");
            }
            catch(SQLException e4)
            {
               System.out.println("err connection");
            }
    
           return "Modify.xhtml?faces-redirect=true";
    
}
    
    public String Update(int id){
                 Employe e = new Employe();
                
        
            try           
            {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection co;
               co=DriverManager.getConnection("jdbc:mysql://localhost:3306/serveurj","root","");
               Statement s1 =co.createStatement();
              String req = "update employe set nom=? , salaire=? where matricule ="+id  ;
                  ResultSet res = s1.executeQuery(req);
                  
                  while(res.next()){
                      
                      e.setNom(res.getString("nom"));
                      e.setSalaire(res.getFloat("salaire"));
                      
                  }
                       
               
            }
            catch(ClassNotFoundException e3)
            {
                System.out.println("err pilote");
            }
            catch(SQLException e4)
            {
               System.out.println("err connection");
            }
    
           return "index.xhtml?faces-redirect=true";
          
    }
    
  
    
}
