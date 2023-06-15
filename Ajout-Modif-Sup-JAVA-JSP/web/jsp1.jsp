
<%@page import="java.sql.*" %>


        <body>
            <table border="2">
                <thead>
                    <tr>

                        <th>Matricule</th>
                        <th>Nom</th>
                        <th>Address</th>
                        <th>Action1</th>
                        <th>Action2</th>
                    </tr>
                </thead>
                <tbody>
<%
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection co ;
        co=DriverManager.getConnection("jdbc:mysql://localhost:3306/serveurj","root","");
        Statement s1 =co.createStatement();
        String req= "select* from user " ;
        ResultSet res= s1.executeQuery(req);
  
                      while(res.next()){ 
  %>
                           <tr>
                               <td><%=res.getInt("matricule")%></td>
                               <td><%=res.getString("nom")%></td>
                               <td><%=res.getString("address")%></td>
            <td><a href="jsp2.jsp?matricule=<%=res.getInt("matricule")%>">Modifier</a></td>
            <td><a href="delete.jsp?matricule=<%=res.getInt("matricule")%>">Supprimer</a></td>
                               
                         </tr> 
       <%                     
    }  
              
      
    }catch(SQLException e1){
        out.println("err: erreur de connection");
        
    }catch(ClassNotFoundException e2){
        out.println("err: erreur de pilote ");
    }

%>

</tbody>              
            </table>
        </body>
    