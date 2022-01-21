package controller;

import dao.BulletinDAO;
import dao.PersonDAO;
import model.Bulletin;
import model.Person;
import view.BoardView;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class BoardServlet extends HttpServlet {
    PersonDAO personDAO;
    BulletinDAO bulletinDAO;

    public void init() {
        personDAO = new PersonDAO();
        bulletinDAO = new BulletinDAO();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        RequestDispatcher requestDispatcher;
        ServletContext servletContext = getServletContext();
        session.setAttribute("bulletinDAO", bulletinDAO);

        requestDispatcher = servletContext.getRequestDispatcher("/mainpage.jsp");

        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        if (session.getAttribute("dislike") != null) {
            Bulletin bulletin = bulletinDAO.getByID((Integer) session.getAttribute("like"));
        }

        if (session.getAttribute("person") != null) {
            if (req.getParameter("bullheader") != null & req.getParameter("bulltext") != null) {
                bulletinDAO.add(req.getParameter("bullheader"), req.getParameter("bulltext"));
            }

            if (req.getParameter("like") != null) {
                Bulletin bulletin = bulletinDAO.getByID(Integer.parseInt(req.getParameter("like").trim()));
                Person person = (Person) session.getAttribute("person");

                if (!bulletin.checkPerson(person.getName())) {
                    bulletin.addToList(person.getName(), "like");
                }

                if (bulletin.checkPerson(person.getName())) {
                    if (bulletin.getValue(person.getName()).equals("like")) {
                        bulletin.changeValue(person.getName(), "none");
                    } else {
                        bulletin.changeValue(person.getName(), "like");
                    }
                }
            }

            if (req.getParameter("dislike") != null) {
                Bulletin bulletin = bulletinDAO.getByID(Integer.parseInt(req.getParameter("dislike").trim()));
                Person person = (Person) session.getAttribute("person");

                if (!bulletin.checkPerson(person.getName())) {
                    bulletin.addToList(person.getName(), "dislike");
                }

                if (bulletin.checkPerson(person.getName())) {
                    if (bulletin.getValue(person.getName()).equals("dislike")) {
                        bulletin.changeValue(person.getName(), "none");
                    } else {
                        bulletin.changeValue(person.getName(), "dislike");
                    }
                }
            }
        }

        personDAO.index().forEach(person -> {
            if (person.getName().equals(req.getParameter("username")) & person.getPassword().equals(req.getParameter("password"))) {
                session.setAttribute("person", person);
            }
        });

        resp.sendRedirect("/board");
    }
}