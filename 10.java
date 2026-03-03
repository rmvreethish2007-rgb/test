
<%@ page import="java.sql.*" %>
<html>
<body>

<%
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;

try{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/jspcrud","root","admin");

/* INSERT */
if(request.getParameter("save")!=null){
    
ps=con.prepareStatement(
"insert into student values(?,?,?)");
ps.setInt(1,Integer.parseInt(request.getParameter("id")));
ps.setString(2,request.getParameter("name"));
ps.setString(3,request.getParameter("course"));
ps.executeUpdate();
}

/* UPDATE */
if(request.getParameter("update")!=null){
    
ps=con.prepareStatement(
"update student set name=?,course=? where id=?");
ps.setString(1,request.getParameter("name"));
ps.setString(2,request.getParameter("course"));
ps.setInt(3,Integer.parseInt(request.getParameter("id")));
ps.executeUpdate();
}

/* DELETE */
if(request.getParameter("delete")!=null){
    
ps=con.prepareStatement(
"delete from student where id=?");
ps.setInt(1,Integer.parseInt(request.getParameter("delete")));
ps.executeUpdate();
}
%>

<!-- FORM -->
<form method="post">
ID:<input type="number" name="id"><br><br>
Name:<input type="text" name="name"><br><br>
Course:<input type="text" name="course"><br><br>

<input type="submit" name="save" value="Insert">
<input type="submit" name="update" value="Update">
</form>

<hr>

<!-- DISPLAY -->
<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Course</th>
<th>Delete</th>
</tr>

<%
rs=con.createStatement().executeQuery("select * from student");
while(rs.next()){
%>

<tr>
<td><%=rs.getInt(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(3)%></td>
<td>
    
<form method="post">
<button name="delete" value="<%=rs.getInt(1)%>">Delete</button>
</form>

</td>
</tr>

<%
}
}catch(Exception e){
out.println(e);
}
%>

</table>
</body>
</html>

