package com.learning.hello;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guess")
public class Guessnumber extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int randomNumber;
    private int guesses;

    @Override
    public void init() throws ServletException {
        // Initialize the random number and reset the guesses
        randomNumber = (int) (Math.random() * 100) + 1;
        guesses = 0;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the user's guess
        String userGuessStr = request.getParameter("guess");
        int userGuess = -1;
        if (userGuessStr != null && !userGuessStr.isEmpty()) {
            userGuess = Integer.parseInt(userGuessStr);
            guesses++;

            // Check if the guess is correct
            String message = "";
            if (userGuess == randomNumber) {
                message = "Congratulations! You guessed the correct number " + randomNumber + " in " + guesses + " guesses.";
            } else if (userGuess < randomNumber) {
                message = "Try higher.";
            } else {
                message = "Try lower.";
            }
            out.println(message);
        } else {
            // Display the initial input form
            ServletContext sc = getServletContext();
            sc.getRequestDispatcher("/highlow.html").forward(request, response);
        }

        out.close();
    }
}
