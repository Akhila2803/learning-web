package com.learning.hello;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public List<Integer> GenerateFibonacci(int n){
        List<Integer> fib= new ArrayList<Integer>();
        for( int i=0; i<n;i++)
        {
            if(i==0) { fib.add(0); }
            else if(i==1) { fib.add(1); }
            else { fib.add(fib.get(i-1)+fib.get(i-2)); }
        }
        return fib;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(request.getParameter("value")==null) {
			out.println("<h1>give a value</h1>");
			return;
		}
		else {
			String val = request.getParameter("value");
	        int m= Integer.parseInt(val);
	        List<Integer> n= new ArrayList<Integer>();
	        //PrintWriter out=response.getWriter();
	        for(int i=0;i<m;i++) {
	        out.print(String.format("%d ",GenerateFibonacci(m).get(i)));
	        }
		}
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		if(request.getParameter("formlimit")==null) {
			out.println("<h1>give a value</h>");
			return;
		}
		else {
			String val = request.getParameter("formlimit");
	        int m= Integer.parseInt(val);
	        List<Integer> n= new ArrayList<Integer>();
	        //PrintWriter out=response.getWriter();
	        for(int i=0;i<m;i++) {
	        out.print(String.format("%d ",GenerateFibonacci(m).get(i)));
	        }
		}
    }
 
}