package by.alex.servlet;

import by.alex.service.CityService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private final CityService cityService = CityService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cities", cityService.findAll());
        req.getRequestDispatcher("/WEB-INF/jsp/main.jsp")
                .forward(req, resp);
    }
}
