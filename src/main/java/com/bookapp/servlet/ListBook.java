package com.bookapp.servlet;

import com.bookapp.model.Book;
import com.bookapp.model.Chapter;
import com.bookapp.serivce.Book.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListBook extends HttpServlet {
    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Book> bookList = bookService.getAll();
            ObjectMapper objectMapper = new ObjectMapper();
            String bookListJSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookList);

            /*
            ObjectMapper objectMapper = new ObjectMapper();
            String JSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookList);

            PrintWriter printWriter = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            printWriter.write(JSON);
            printWriter.close();

             */
            request.setAttribute("bookListJSON", bookListJSON);
            request.getRequestDispatcher("library/index.jsp").forward(request, response);

        } catch (ServletException exception) {
            exception.printStackTrace();
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }
}
