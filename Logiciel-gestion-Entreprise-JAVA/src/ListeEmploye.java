import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class ListeEmploye extends JFrame{
    //variable pour table
        Container con =null ;
        JTable table ;
    
    
    public ListeEmploye(){
        con=getContentPane();
        con.setLayout(new FlowLayout());
        setTitle("Liste-Employe");
        setSize(new Dimension(1000,900));
        setLocationRelativeTo(null);
        
        //les variable du tableau
        String colonne[]={"Matricule","Nom","Salaire","CodeService"};
        String dim[][]= new String[30][4];
        
        
        
        //connection 
         try           
            {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection co;
               co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root",""); 
                //espace memoire piur execution de la requete
               Statement s1 = co.createStatement();
                //declaration de la requete  
               String req="select* from employe";
                //execution de la requet  
               ResultSet res=s1.executeQuery(req);
               int i = 0 ;
               while(res.next()){
                  dim[i][0]= res.getString(1); 
                  dim[i][1]=res.getString(2);
                  dim[i][2]=res.getString(3);
                  dim[i][3]=res.getString(4);
                  i=i+1 ;
                   
               }
               //creer un table par defaut
               DefaultTableModel mod = new DefaultTableModel(dim, colonne);
               table =new JTable(mod);
               //on creer un curseur 
               JScrollPane pane = new JScrollPane(table);
             
 
               con.add(pane);
                
              
            }
            catch(ClassNotFoundException e11)
            {
            JOptionPane.showMessageDialog(null,"err : chargement pilote");    
            }
            catch(SQLException e2)
            {
              JOptionPane.showMessageDialog(null,"erreur de conn ou requete");  
            }
      
        
        
        
        
    }
    
    
    
    
    
    
    public static void main(String[] args){
        new ListeEmploye().setVisible(true);
    }
}