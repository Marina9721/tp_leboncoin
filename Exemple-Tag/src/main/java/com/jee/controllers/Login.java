package com.jee.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		int a = (int) (Math.random()*2000);
		System.out.println(a);
		session.setAttribute("variable", a);
		
		ArrayList<String> liste = new ArrayList();
		liste.add("toto");
		liste.add("tata");
		liste.add("titi");
		
		session.setAttribute("liste", liste);
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("mylogin", login);
		session.setAttribute("mypassword", password);
		
		doGet(request, response);
	}
	
}
