package com.learning.hello;
import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class CheckPasswords extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String[] bannedPasswords = { "password123", "qwerty", "123456" };
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		boolean isBanned = false;
		for (String bannedPassword : bannedPasswords) {
			if (newPassword.equals(bannedPassword)) {
				isBanned = true;
				break;
			}
		}
	
		if (isBanned) {
		out.println("Sorry, this password is not available. Please choose another password.");
		} else {
		if (newPassword.equals(confirmPassword)) {
		out.println("Password set successfully!");
		} else {
		out.println("Password and Confirm Password do not match. Please try again.");
		}
	}
	
	}
}