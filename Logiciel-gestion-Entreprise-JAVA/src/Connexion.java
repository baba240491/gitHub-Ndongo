import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;






public class Connexion extends JFrame implements ActionListener{
      Container con ;
      JLabel l1 = new JLabel("Email");
      JLabel l2 = new JLabel("Password");
      JTextField p = new JTextField(20);
      JTextField t1 = new JTextField(20);  
      JButton b1 =new JButton("Connecter");
      JButton b2=new JButton("Effacer");
      
      
public Connexion(){
        con =getContentPane();
        con.setLayout(new FlowLayout());
        con.setBackground(Color.lightGray);
        setTitle("CONNEXION");
        setSize(800,900);
        setLocationRelativeTo(null);
        
        
        //ajouter les variable dans le con 
        con.add(l1);
        con.add(t1);
        con.add(l2);
        con.add(p);
        con.add(b1);
        con.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
       
        
        
    }
public void actionPerformed(ActionEvent e1){
        //condition pour le b2 effacer le contenue 
        if(e1.getSource()==b2){
            t1.setText("");
            p.setText("");
        }else{
            //verifier si l'utilisateur n'a rien saisie
            if(p.getText().isEmpty() || t1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"veillez remplir tout les champs ");
                
            }else{
                   //connexions 
                  try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection co = null ;
                co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root","");     
                Statement s1 = co.createStatement();
                String req1 ="select* from utilisateur where email='"+t1.getText()+"' and  motPass='"+p.getText()+"' " ;
                ResultSet res = s1.executeQuery(req1);
                    //verifier si email ou la password existe dans la base donner 
                  if(!res.next()){
                    JOptionPane.showMessageDialog(null,"verifier le email ou le mot de pass !!");
                   
                  }else{
                      //se diriger vers le menu s'il existe 
                     Menu msee = new Menu();
                     msee.setVisible(true);
                     dispose();
                    
                }
                  
                
            }catch(ClassNotFoundException ee1){
               JOptionPane.showMessageDialog(null,"err:chargement de pilote");
                
            }catch(SQLException  ee2){
                 JOptionPane.showMessageDialog(null,"err: erreur de connection ou requette");
            }
                  
            
            } 
                  
    
        }  
        
        }
          
public static void main(String[] args){
        
        new Connexion().setVisible(true);
    }
    
    
}