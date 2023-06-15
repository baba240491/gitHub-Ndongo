import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SupprimerEmploye extends JFrame implements ActionListener{
    //Declarer les variables  
    Container con = null;
        JComboBox com = new JComboBox();
        JLabel l1 = new JLabel("Matricule");
       
     
       
       
       
       
       
       JButton b1 = new JButton("Supprimer");
       JButton b2 = new JButton("Retour");
           
       //constructeur vide
   public SupprimerEmploye(){
       try           
            {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection co;
               co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root",""); 
                //espace memoire piur execution de la requete
                Statement s1 = co.createStatement();
                //declaration de la requete  
                String req="select * from employe";
                //execution de la requet
                
                ResultSet res=s1.executeQuery(req);
                
                while(res.next())
                {
                    com.addItem(res.getInt("matricule"));
                }
                
              
            }
            catch(ClassNotFoundException e11)
            {
            JOptionPane.showMessageDialog(null,"err : chargement pilote");    
            }
            catch(SQLException e2)
            {
              JOptionPane.showMessageDialog(null,"erreur de conn ou requete");  
            }
     
       //contenaire =pane   
         con=getContentPane();
         con.setLayout(new FlowLayout());
         con.setBackground(Color.lightGray);
         setTitle("SUPPRIMER_EMPLOYE ");
         setSize(new Dimension(1000,900));
         setTitle("Employer");
         setLocationRelativeTo(null);
         
         //ajouter les varaibles dans le conteneur
         con.add(l1);
         con.add(com);
         con.add(b1);
         con.add(b2);
         
       //creer des evenemment 
         b1.addActionListener(this);
         b2.addActionListener(this);
   }        
    
    
    public void actionPerformed(ActionEvent e2){
        //ajouter une action sur les buttons
        if(e2.getSource()==b2){
           Menu s = new Menu();
           s.setVisible(true);
           dispose();
        }else if(e2.getSource()==b1){
            try
           {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection co;
                co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root",""); 
                Statement s1 =co.createStatement();
                String req1="delete from employe where matricule="+com.getSelectedItem() ;
                int res=s1.executeUpdate(req1);
                JOptionPane.showMessageDialog(null,"Supprimer  avec succées "); 
           }
     
          
            catch(ClassNotFoundException e11)
            {
            JOptionPane.showMessageDialog(null,"err : chargement pilote");    
            }
            catch(SQLException e3)
            {
              JOptionPane.showMessageDialog(null,"erreur de connection ou rquette");  
            }    
        }
        
    }
   
    
    
    
    public static void main(String[]  args){
        
        new SupprimerEmploye().setVisible(true);
    }
    
    
    
}
