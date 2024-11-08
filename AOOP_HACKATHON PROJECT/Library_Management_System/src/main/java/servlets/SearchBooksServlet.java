package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Model.Book;
import Model.Library;


@WebServlet("/searchBooks")
public class SearchBooksServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Library library = new Library();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        List<Book> books = library.searchBooks(title);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>Search Results:</h2><ul>");
        for (Book book : books) {
            out.println("<li>" + book.getTitle() + " by " + book.getAuthor() +
                        (book.isAvailable() ? " (Available)" : " (Not Available)") + "</li>");
        }
        out.println("</ul></body></html>");
    }
}
