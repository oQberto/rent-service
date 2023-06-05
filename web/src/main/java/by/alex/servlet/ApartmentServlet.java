package by.alex.servlet;

import by.alex.service.ApartmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/apartment")
public class ApartmentServlet extends HttpServlet {
    private final ApartmentService apartmentService = ApartmentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer cityId = Integer.valueOf(req.getParameter("cityId"));
        req.setAttribute("apartments", apartmentService.findByCityId(cityId));
        req.getRequestDispatcher("/WEB-INF/jsp/apartments.jsp")
                .forward(req, resp);
    }
}
