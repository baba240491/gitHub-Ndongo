
package plateformeservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class ModificationOption {
              Menu M = new Menu();
        
    public void OptionRetrait(){
        
         try           
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection co;
                co=DriverManager.getConnection("jdbc:mysql://localhost:3306/multiservice","root","");
                
                //espace memoire pour execution de la requete
               Statement s1 = co.createStatement();
               String req=" update envoyer set option='Retirer' where codeTransaction="+M.NonRetrait+ "       ";
                //execution de la requet  
               
               ResultSet res=s1.executeQuery(req);
               
		
            }
            catch(SQLException e2)
            {
              JOptionPane.showMessageDialog(null,"erreur de conn ou requete");  
            }catch(ClassNotFoundException e2){
                JOptionPane.showMessageDialog(null,"erreur de pilote"); 
            }
    }
    
}
