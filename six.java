package questions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ITreturns
 */
public class ITreturns extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ITreturns() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		 String gender=request.getParameter("gender");
		 String salary=request.getParameter("salary");
		 String tax=request.getParameter("tax");
		 PrintWriter out=response.getWriter();
		 File file = new File("/home/mahen/1.txt");
		 file.createNewFile();
		 FileOutputStream fout = new FileOutputStream(file);
		 out.println(""+name+gender+salary+tax);
		 fout.write(("hello"+name+gender+salary+tax).getBytes());
		 fout.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

info.jsp

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ITreturns" method="get" >
name:<input type="text" name="name"/>
<select name="gender">
<option>male</option>
<option>fe</option>
</select>
sal:<input type="text" name="salary"/>
tax:<input type="text" name="tax"/>
<input type="submit"/>
</form>
</body>
</html>