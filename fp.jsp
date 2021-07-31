<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%
String Oldpass = request.getParameter("Oldpass");
String Newpass = request.getParameter("Newpass");
String conpass = request.getParameter("Confirmpass");


Connection con = null;
Statement st = null;
String pass = "";
int id = 0;
try {
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/erms";
con = DriverManager.getConnection(url, "root", "root123");
st = con.createStatement();
ResultSet rs = st.executeQuery("select * from Student where password= '"+ Oldpass + "'");
if (rs.next()) { 
pass = rs.getString("Oldpass");
} 
if(Newpass.equals(conpass))
{
if (pass.equals(Oldpass)) {
st = con.createStatement();
int i = st.executeUpdate("update changepassword set password='"+ Newpass + "'");
out.println("Password changed successfully!!");
st.close();
con.close();
} else {
out.println("Old Password doesn't match");
}
/*}else{
out.println("new password and confirm new password is not matching");
}*/
}
} catch (Exception e) {
out.println(e);
}
%>