import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class validateloginteacher extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3307/mini_project";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "Kanna128#";
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {


        try {
            // Connect to database
            Class.forName(JDBC_DRIVER);
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare statement to select user from database
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM login WHERE  role='Teacher' AND username=? AND password=?  ");
            ps.setString(1, request.getParameter("username"));
            ps.setString(2, request.getParameter("password"));

            // Execute query and get result set
            ResultSet rs = ps.executeQuery();

            // If user is found, create session and redirect to home page
            if (rs.next()) {
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html><html lang=\"en\"><head><title>Login Success!</title><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\"></head><body><div class=\"limiter\"><div class=\"container-login100\"><div class=\"wrap-login100\"><div class=\"login100-pic js-tilt\" data-tilt><img src=\"img/portfolio-3.jpg\" alt=\"IMG\"></div><form class=\"login100-form validate-form\" action=\"\"><span class=\"login100-form-title\" style=\"font-size: 50px\">Login Success!</span><div class=\"container-login100-form-btn\"><button class=\"login100-form-btn\" onclick=\"location.href='Teacher_home.html'\" type=\"button\">Go</button></div><br><br><br><br><br><br><br></form></div></div></div><script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script><script src=\"vendor/bootstrap/js/popper.js\"></script><script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script><script src=\"vendor/select2/select2.min.js\"></script><script src=\"vendor/tilt/tilt.jquery.min.js\"></script><script >$('.js-tilt').tilt({scale: 1.1})</script><script src=\"js/main1.js\"></script>");

            } else {
                // If user is not found, display error message
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html><html lang=\"en\"><head><title>Login Failed!</title><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\"></head><body><div class=\"limiter\"><div class=\"container-login100\"><div class=\"wrap-login100\"><div class=\"login100-pic js-tilt\" data-tilt><img src=\"img/portfolio-3.jpg\" alt=\"IMG\"></div><form class=\"login100-form validate-form\" action=\"\"><span class=\"login100-form-title\" style=\"font-size: 50px\">Login Failed!</span><div class=\"container-login100-form-btn\"><button class=\"login100-form-btn\" onclick=\"location.href='Teacher_login.html'\" type=\"button\">Try Again</button></div><br><br><br><br><br><br><br></form></div></div></div><script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script><script src=\"vendor/bootstrap/js/popper.js\"></script><script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script><script src=\"vendor/select2/select2.min.js\"></script><script src=\"vendor/tilt/tilt.jquery.min.js\"></script><script >$('.js-tilt').tilt({scale: 1.1})</script><script src=\"js/main1.js\"></script>");

            }

            // Close resources
            rs.close();
            ps.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
