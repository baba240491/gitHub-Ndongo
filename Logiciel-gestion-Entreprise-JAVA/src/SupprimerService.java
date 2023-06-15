import java.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SupprimerService extends JFrame implements ActionListener{
    //declarer les variables
       Container con = null ;
          JComboBox com =new JComboBox();  
          JLabel l1 =new JLabel("CodeService");
          JButton b1 =new JButton("Supprimer");
          JButton b2 =new JButton("Retour"); 
   
    
public SupprimerService(){
        //recuperer le code service dans la BBD et le mettre sur combox
         try           
            {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection co;
               co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root",""); 
                //espace memoire piur execution de la requete
                Statement s1 = co.createStatement();
                //declaration de la requete  
                String req="select * from service";
                //execution de la requet
                
                ResultSet res=s1.executeQuery(req);
                
                while(res.next())
                {
                    com.addItem(res.getInt("codeS"));
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
        
        
          //contanire = panel
          con=getContentPane();
        con.setLayout(new FlowLayout());
        con.setBackground(Color.LIGHT_GRAY);
        setTitle("SUPPRIMER_SERVICE");
        setSize(900,700);
        
        //mettre les variables dans le contenaire
        con.add(l1);
        con.add(com);
        con.add(b1);
        con.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }

        
public void actionPerformed(ActionEvent e1){
       if(e1.getSource()==b2){
            Menu msee = new Menu();
            msee.setVisible(true);
            dispose();
            
        }else if(e1.getSource()==b1){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection co = null ;
                co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root","");     
                Statement s1 = co.createStatement();
                String req1 ="delete from service where codeS="+com.getSelectedItem()+" ";
                int res = s1.executeUpdate(req1);
                 JOptionPane.showMessageDialog(null,"Supprimer avec succées !!!");
                
                
            }catch(ClassNotFoundException ee1){
               JOptionPane.showMessageDialog(null,"err:chargement de pilote");
                
            }catch(SQLException  ee2){
                 JOptionPane.showMessageDialog(null,"err: erreur de connection ou requette");
            }
                   
        }    
        
    }
    
    
    
    
public static void main(String[]  args){
        
        new SupprimerService().setVisible(true);
    }
    
}