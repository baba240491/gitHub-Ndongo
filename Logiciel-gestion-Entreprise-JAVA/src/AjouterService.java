import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class AjouterService extends JFrame implements ActionListener{
                //variable pour table 
                    JTable table ; 
    
         //declarer les variable
          Container con =null; 
          JLabel l1 =new JLabel("CodeService");
          JLabel l2 =new JLabel("LIbelle");
          JTextField t1 =new JTextField(5);
          JTextField t2 =new JTextField(15);
          JButton b1 =new JButton("Ajouter");
          JButton b2 =new JButton("Retour");
          
    
    
public AjouterService(){
        //contanire = panel
        con=getContentPane();
        con.setLayout(new FlowLayout());
        con.setBackground(Color.LIGHT_GRAY);
        setTitle("AJOUTER_SERVICE");
        setSize(900,700);
        setLocationRelativeTo(null);
        
        //mettre les variables dans le contenaire
        con.add(l1);
        con.add(t1);
        con.add(l2);
        con.add(t2);
        con.add(b1);
        con.add(b2);
     b1.addActionListener(this);
     b2.addActionListener(this);
     
     
     
     
             //variable pour le tableau  et creer un tableau et ajouter les donner 
         String col[]={"codeS","lib"};
         String cont[][]= new String[30][2];
          //connection et insertion des donner dans une table 
       try           
            {
                //connexion
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
                //parcoure le tabeau et inserer les donner 
                while(res.next()){
                   cont[i][0]=res.getString(1);
                   cont[i][1]=res.getString(2);
                  
                   i=i+1 ;
               }
               //creer un tableau par defaut
               DefaultTableModel mod = new DefaultTableModel(cont, col);
               table =new JTable(mod);
               //on creer un curseur 
               JScrollPane pane = new JScrollPane(table);
             
                    //ajouter sur curseur dans le contenaire 
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
        
    
                    @Override
    public void actionPerformed(ActionEvent e2){
         if(e2.getSource()==b2){
            Menu r = new Menu(); 
            r.setVisible(true);
             dispose();
         }else if(e2.getSource()==b1){
            
              try
           {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection co;
                co=DriverManager.getConnection("jdbc:mysql://localhost:3306/exercice","root","");           
                Statement s1  = co.createStatement();
                Statement s2 = co.createStatement();
                String req2 ="select* from service where codeS='"+t1.getText()+"'";
                String req1="insert into service(codeS,lib) values("+t1.getText()+",'"+t2.getText()+"')";
                ResultSet res = s2.executeQuery(req2);
                  
                
                //verification de l'insertion s'il existe 
                int exite = 0 ;
                while(res.next()){
                    
                    exite=1 ;
                }
                if(exite==1){
                    
                   JOptionPane.showMessageDialog(null,"servise existe deja  ????");
                }else{
                     int ress= s1.executeUpdate(req1);
                JOptionPane.showMessageDialog(null,"insertion service okkkkkkk");
                //permet de vider le champs de saisie
                    t1.setText("");
                    t2.setText("");

                }
                  
            }
          
            catch(ClassNotFoundException e11)
            {
            JOptionPane.showMessageDialog(null,"err : chargement pilote");    
            }
            catch(SQLException e22)
            {
              JOptionPane.showMessageDialog(null,"erreur de connection ou rquette");  
            }
       }
     
             
            
    }
    
    
    
    
public static void main(String[] args){
        
        new AjouterService().setVisible(true);
    }
    
    
} 
