/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Iterator;
public class UpdateInt extends JFrame implements ActionListener
{
    Container co=null;
    JLabel l1 = new JLabel("Matricule");
    JComboBox com=new JComboBox();
    
    JLabel l2= new JLabel("Nom");
    JTextField t2 = new JTextField(25);
    JLabel l3= new JLabel("Adresse");
    JTextField t3 = new JTextField(25);
    
    JButton b1 = new JButton("Modification");
    JButton b2 = new JButton("Exit");
    
    public UpdateInt()
    {
        //chargement du combobox
        try
           {
            Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection co=null;
                co=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","marah");
                Statement s1=co.createStatement();
                String req="select * from  employe";
                ResultSet res=s1.executeQuery(req);
              
                while(res.next())
                {
                    com.addItem(res.getInt("id_mat"));
                }
                            
                }
           
           catch(ClassNotFoundException d)
            {
                        JOptionPane.showMessageDialog(null,"err de pilote ????");
            }
            catch(SQLException g)
            {
                        JOptionPane.showMessageDialog(null,"err de requete ????");
            }
        
        co=getContentPane();
        co.setLayout(new FlowLayout());
        co.setSize(new Dimension(970,1000));
        co.add(l1);
        co.add(com);
        co.add(l2);
        co.add(t2);
        co.add(l3);
        co.add(t3);
        co.add(b1);
        co.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        com.addActionListener(this);
        
    }
    
    
    
    
    
    public void actionPerformed(ActionEvent e1)
    {
        if (e1.getSource()==b2)
        {
            JOptionPane.showMessageDialog(null,"have a good day see you next year");
        System.exit(0);
        }
        else if (e1.getSource()==com)
        {
           //affichage le nom et adresse 
            
            
            try
           {
            Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection co=null;
                co=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","marah");
                Statement s1=co.createStatement();
                String req="select * from  employe where id_mat ="+com.getSelectedItem();
                ResultSet res=s1.executeQuery(req);
              
                while(res.next())
                {
                    t2.setText(res.getString("no"));
                    t3.setText(res.getString("adr"));
                    
                }
                            
                }
           
           catch(ClassNotFoundException d)
            {
                        JOptionPane.showMessageDialog(null,"err de pilote ????");
            }
            catch(SQLException g)
            {
                        JOptionPane.showMessageDialog(null,"err de requete ????");
            }
        
            
            
            
            
            
            
        }
        else
        {
            
            //modification
            
            
            try
           {
            Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection co=null;
                co=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","marah");
                Statement s1=co.createStatement();
                String req="update employe set no='"+t2.getText()+"',adr='"+t3.getText()+"' where id_mat ="+com.getSelectedItem();
                int res=s1.executeUpdate(req);
              
             JOptionPane.showMessageDialog(null,"Update okkkkkkkkkkkkkkk");   
                            
                }
           
           catch(ClassNotFoundException d)
            {
                        JOptionPane.showMessageDialog(null,"err de pilote ????");
            }
            catch(SQLException g)
            {
                        JOptionPane.showMessageDialog(null,"err de requete ????");
            }
        
            
            
            
        }
    }
    
    public static void main(String[] arg)
    {
        new UpdateInt().setVisible(true);
    }
    
}
