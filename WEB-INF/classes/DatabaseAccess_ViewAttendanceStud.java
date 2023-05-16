import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DatabaseAccess_ViewAttendanceStud extends HttpServlet {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3307/mini_project";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "Kanna128#";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "My Attendance";
		Integer id = 0;
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("username");

		out.println("<!doctype html>\n" +
		            "<html>\n" +
		            "<head><title>My Attendance</title><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">" +
		            "</head>\n<body>\n" +
		            "<div class=\"limiter\"><div class=\"container-login100\"><div class=\"card\" align=\"center;\" >" +

		            "<span class=\"login100-form-title\" style=\"font-size: 30px;text-align:center;\">My Attendance</span>\n");
		try {

			//out.println("<p>Driver Access Initialising....</p>");
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);
			//Class.forName("com.mysql.cj.jdbc.Driver");

			//out.println("<p>Driver Access Succesful....</p>");
			// Open a connection
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//out.println("<p>Database Connection Successful....</p>");


			// Execute SQL query
			Statement stmt = conn.createStatement();
			String sql;

			sql = "SELECT id FROM login where username = '" + user + "'";

			ResultSet rs1 = stmt.executeQuery(sql);
			if (rs1.next()) {
				//Retrieve by column name
				id = rs1.getInt("id");
			}
			rs1.close();

			sql = "SELECT * FROM attendance where id=" + id;
			ResultSet rs = stmt.executeQuery(sql);
			out.print("<table style = \"width:80%;margin:auto;\" border = \"1\">");
			out.print("<tr><th style=\"width:50%;padding:10px 10px 10px 10px;\">Date</th>");
			//out.print("<th style=\"width:50%;padding:10px 10px 10px 10px;\">ID</th>");
			//out.print("<th style=\"width:50%;padding:10px 10px 10px 10px;\">Name</th>");
			out.print("<th style=\"width:50%;padding:10px 10px 10px 10px;\">Present</th>");
			out.print("</tr>");

			// Extract data from result set
			while (rs.next()) {
				//Retrieve by column namess
				String curr_date = rs.getString("curr_date");
				//int ids  = rs.getInt("id");
				//String name = rs.getString("name");
				String present = rs.getString("present");



				//Display values
				out.print("<tr><td style=\"padding:10px 10px 10px 10px;\">" + curr_date + "</td>");
				//out.print("<td style=\"padding:10px 10px 10px 10px;\">" + ids + "</td>");
				//out.print("<td style=\"padding:10px 10px 10px 10px;\">" + name + "</td>");
				out.print("<td style=\"padding:10px 10px 10px 10px;\">" + present + "</td></tr>");
			}


			// Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
			out.println("</table>");
			out.println("<div class=\"container-login100-form-btn\"><button class=\"login100-form-btn\" onclick=\"location.href='Student_home.html'\" type=\"button\">Go Home</button>");
			out.println("</div></div></div><script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script><script src=\"vendor/bootstrap/js/popper.js\"></script><script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script><script src=\"vendor/select2/select2.min.js\"></script><script src=\"vendor/tilt/tilt.jquery.min.js\"></script><script >$('.js-tilt').tilt({scale: 1.1})</script><script src=\"js/main1.js\"></script></body></html>");

		} catch (SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}
}