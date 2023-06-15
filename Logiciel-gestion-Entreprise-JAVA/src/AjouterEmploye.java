import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;



public class AjouterEmploye extends JFrame implements ActionListener{
         //variable pour table 
                JTable table ; 
    
    //Declarer les variables  
    Container con =null ;
       JLabel l1 = new JLabel("Matricule");
       JLabel l2 = new JLabel("Nom");
       JLabel l3 = new JLabel("Salaire");
       JComboBox com = new JComboBox();
       JLabel L4 =new JLabel("codeService");
       JTextField t1 =new JTextField(5);
       JTextField t2 =new JTextField(10);
       JTextField t3 =new JTextField(15);
       
       
       JButton b1 = new JButton("Ajouter");
       JButton b2 = new JButton("Retour");
           
       //constructeur vide
   public AjouterEmploye(){
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
      
       
       
       
       
         con=getContentPane();
         con.setLayout(new FlowLayout());
         con.setBackground(Color.lightGray);
         setTitle("AJOUTER_EMPLOYE ");
         setSize(new Dimension(1000,900));
         setTitle("Employer");
         setLocationRelativeTo(null);
         
         //ajouter les varaibles dans le conteneur
         
         con.add(L4);
         con.add(com);
         con.add(l1);
         con.add(t1);
         con.add(l2);
         con.add(t2);
         con.add(l3);
         con.add(t3);
         
        
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
               
               //parcourire le tableau 
               int i = 0 ;
               
               //inserer les donner dans le tableau 
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
        }else if (e2.getSource()==b1){
            try
           {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection co;
                co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root","");           
                Statement s3  = co.createStatement();
                Statement s4 = co.createStatement();
                String req3 = "select* from employe where matricule="+t1.getText()+" ";
                String req4="insert into employe(matricule,nom, salaire, codeS) values("+t1.getText()+",'"+t2.getText()+"',"+t3.getText()+","+ com.getSelectedItem()+") ";
                ResultSet res = s3.executeQuery(req3);
               
                int exites = 0;
                while(res.next()){
                    exites=1 ;
                    
                }
                if(exites==1){
                    
                    JOptionPane.showMessageDialog(null,"matricule  existe deja  ????");
                    
                }else{
                    
                    int resss = s4.executeUpdate(req4);
                 JOptionPane.showMessageDialog(null,"insertion service okkkkkkk");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                  
                }
                  
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
        
        new AjouterEmploye().setVisible(true);
    }
    
    
    
}
