package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Model.Library;
/**
 * Servlet implementation class BorrowBookServlet
 */

@WebServlet("/borrowBook")
public class BorrowBookServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Library library = new Library();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int bookId = Integer.parseInt(request.getParameter("bookId"));

        String result = library.borrowBook(userId, bookId);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>" + result + "</h2></body></html>");
    }
}

