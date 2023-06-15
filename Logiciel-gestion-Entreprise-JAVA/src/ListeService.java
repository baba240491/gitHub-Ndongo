import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;



public class ListeService extends JFrame{
    JTable table ;
    Container con=null ;
    
    
    
    public ListeService(){
         con=getContentPane();
         con.setLayout(new FlowLayout());
         con.setBackground(Color.lightGray);
         setTitle("LISTE_SERVICE ");
         setSize(new Dimension(1000,900));
         setTitle("Employer");
         setLocationRelativeTo(null);
         
         //variable pour le tableau 
         String col[]={"codeS","lib"};
         String cont[][]= new String[30][2];
         
       
         
          try           
            {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection co;
               co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root",""); 
                //espace memoire piur execution de la requete
               Statement s1 = co.createStatement();
                //declaration de la requete  
               String req="select* from service";
                //execution de la requet  
               ResultSet res=s1.executeQuery(req);
                
                int i=0 ;
             
                while(res.next()){
                   cont[i][0]=res.getString(1);
                   cont[i][1]=res.getString(2);
                  
                   i=i+1 ;
               }
               
               DefaultTableModel mod = new DefaultTableModel(cont, col);
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
        
        new ListeService().setVisible(true);
    }
    
    
    
}