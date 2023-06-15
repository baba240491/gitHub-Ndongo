import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;



public class ModifierEmploye extends JFrame implements ActionListener{
        //variable pour table 
          JTable table ; 
    
    //Declarer les variables  
    Container con = null;
        JComboBox com = new JComboBox(); 
        JLabel l1 = new JLabel("Matricule");
        JLabel l2 = new JLabel("Nom");
        JLabel l3 = new JLabel("Salaire");    
       JLabel l4 = new JLabel("CodeS");
       
       JTextField t2 =new JTextField(10);
       JTextField t3 =new JTextField(15);
       JTextField t4 =new JTextField(10);
       
       
       JButton b1 = new JButton("Modifier");
       JButton b2 = new JButton("Retour");
           
       //constructeur vide
    public ModifierEmploye(){
        
        //chargement du combox 
       try           
            {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection co;
               co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root",""); 
                //espace memoire piur execution de la requete
                Statement s1 = co.createStatement();
               
               
                //declaration de la requete  
                String req1="select * from employe";
               
                
                //execution de la requet
                
                ResultSet res=s1.executeQuery(req1);
                
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
         setTitle(" MODIFIER_EMPLOYE ");
         setSize(new Dimension(1000,900));
         setTitle("Employer");
         setLocationRelativeTo(null);
         
         //ajouter les varaibles dans le conteneur
         con.add(l1);
         con.add(com);
         con.add(l2);
         con.add(t2);
         con.add(l3);
         con.add(t3);
         con.add(l4);
         con.add(t4);
         con.add(b1);
         con.add(b2);
         
       //creer des evenemment 
         b1.addActionListener(this);
         b2.addActionListener(this);
         com.addActionListener(this);
         
         
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
               
               //parcoure le tabeau et inserer les donner dans le tableau 
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
             
                //ajouter le curseur dans le tableau
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
   
   
    
    
    public void actionPerformed(ActionEvent e2){
        //ajouter une action sur les buttons
        if(e2.getSource()==b2){
           Menu s = new Menu();
           s.setVisible(true);
           dispose();
           
        }else if(e2.getSource()==com){
            try
           {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection co;
                co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root",""); 
                Statement s1 =co.createStatement();
                String req1="select* from employe where matricule="+com.getSelectedItem()+" ";
                ResultSet res = s1.executeQuery(req1);
                
                while(res.next()){
                    
                    t2.setText(res.getString("nom"));
                    t3.setText(res.getString("salaire"));
                    t4.setText(res.getString("codeS"));
                    
                    
                }   
   
           }
     
          
            catch(ClassNotFoundException ea)
            {
            JOptionPane.showMessageDialog(null,"err : chargement pilote");    
            }
            catch(SQLException eb)
            {
              JOptionPane.showMessageDialog(null,"erreur de connection ou rquette");  
            }     
            
        }
        

  
        
        else{
            try
           {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection co;
                co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root",""); 
                Statement s1 =co.createStatement();
                String req1="update employe set nom='"+t2.getText()+"',salaire="+t3.getText()+",codeS="+t4.getText()+" where matricule="+com.getSelectedItem()+" ";
                int res=s1.executeUpdate(req1);
                JOptionPane.showMessageDialog(null,"Modfier avec succées "); 
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
        
        new ModifierEmploye().setVisible(true);
    }
    
    
    
}
