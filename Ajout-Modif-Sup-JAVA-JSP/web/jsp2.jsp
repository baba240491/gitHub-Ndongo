
<%@page import="java.util.*"%>

<%@page import="java.sql.*"%>

<%
  int m=Integer.parseInt(request.getParameter("matricule"));
      
    
    
  try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection co ;
      co=DriverManager.getConnection("jdbc:mysql://localhost:3306/serveurj","root","");
      Statement s1 = co.createStatement();
      String req="select* from user where matricule="+m+" ";
      ResultSet res= s1.executeQuery(req);
      
       while(res.next())
                {
                    %>
                    
                    <head>
                        <title>Modification</title>
                    </head>
                    <body>
                    <center>
                        <h1>Modification</h1>
                        <form action="update.jsp" method="post">
      Matricule
      <input type="text" name="ma" value="<%=res.getInt("matricule")%>"><br>
      
      Nom
      <input type="text" name="no" value="<%=res.getString("nom")%>"><br>
      
      Adresse
      <input type="text" name="ad" value="<%=res.getString("address")%>"><br><br><br>
      
      
      <input type="submit" value="update">
      
                            
                        </form>
                    </center>
                    </body>
                   <% 
                }
      
      
      
  }catch(SQLException e1){
      out.println("err: connection");
      
  }catch(ClassNotFoundException e2){
      
      out.println("err: pilote");
  }
  
  




%>

