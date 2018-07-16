<%@page import="java.util.ArrayList"%>
<%@page import="totalcode.Totalcode"%>
<%@page import="pojo.Viewpojo"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.topnav-right {
  float: right;
}
table {
    border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
    border: 1px solid #ddd;
}

th, td {
    text-align: left;
    padding: 16px;
}

tr:nth-child(even) {
    background-color: #f2f2f2
}

.button {
  border-radius:35px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 25px;
  padding: 10px;
  width: 150px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 10px;
  position:200px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: 20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}

.btn {
  background-color:green;
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  font-size: 16px;
  margin: 4px 2px;
  opacity: 0.6;
  transition: 0.3s;
}

.btn:hover {opacity: 1}



</style>

</head>
<body>
<a href="add_assignment.jsp"><button class="btn">ADD ASSIGNMENT</button></a>
<div class="topnav-right">
<a href="Signout"><button class="button"><span>LOGOUT</span></button></a>
</div>


<%
String id="";
try{
id=(String)session.getAttribute("ses");
if(id.equals("")){
	response.sendRedirect("Login.jsp");

	
}
}
catch(Exception e){
	response.sendRedirect("Login.jsp");
}

 Totalcode t=new Totalcode();
 ArrayList<Viewpojo> ar=t.view(id);
%>


<table>
  <tr>
    <th>Assignment</th>
    <th>Assignment Date</th>
    <th>Status</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  <%
  for(Viewpojo v:ar)
  {
	
  %>
  <tr>
    <th><%=v.getAssignname() %></th>
    <th><%=v.getAssigndate() %></th>
    <th><%=v.getStatus()%></th>
    <th><a href="edit.jsp?aid=<%=v.getAid()%>">Edit</a></th>
    <th><a href="Delete?aid=<%=v.getAid() %>"
    >Delete</a></th>
  </tr>
   <% 
   
   
   }
   %>
</table>

</body>
</html>
