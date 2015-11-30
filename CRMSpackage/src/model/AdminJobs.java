package model;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;
public class AdminJobs extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/crms","newuser1","password");
		PreparedStatement ps=con.prepareStatement("select * from job");
		ResultSet rs=ps.executeQuery();
		out.println("<html><body bgcolor=pink><a href=AdminHome.jsp>HOME</a><center>");
		out.println("<table boarder height=80% width=100%>");
		out.println("<tr><td>Reference ID</td><td>Responsibilities</td><td>Job Name</td><td>Vacancies</td><td>");
		out.println("Qualification</td><td>Required Skills</td><td>Created By</td>");
		out.println("<td>Required Experience</td><td>Status</td><td>Details</td></tr>");
		out.println("<form action=apply method=post>");
		while(rs.next())
			{
			out.println("<tr><td>"+rs.getString("referencenumber")+"<td>"+rs.getString("responsibilities")+"</td><td>"+rs.getString("jobname")+"</td>");
			out.println("<td>"+rs.getString("vacancies")+"</td><td>"+rs.getString("qualification")+"</td><td>"+rs.getString("requiredskills")+"</td>");
			out.println("<td>"+rs.getString("createdby")+"</td><td>"+rs.getString("requiredexperience")+"</td><td>"+rs.getString("status")+"</td><td><input type=submit name=apply value="+rs.getString("referencenumber")+"></td><tr>");
			}
		out.println("</form>");
		out.println("</table></center></body></html>");
	}
	catch(Exception e)
	{
		out.println("The Exception has been caught at AdminJobs Servlet class");
		out.println(e);
	}
}
}
