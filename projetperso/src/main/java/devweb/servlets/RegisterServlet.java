package devweb.servlets;

import devweb.managers.MembreLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static javax.swing.JOptionPane.showMessageDialog;

@WebServlet("/register")
public class RegisterServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html class=\"registration\">");
        out.println("<!-- Titre de l'onglet -->");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>XTREM HARDWARE - Register</title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/login.css\">");
        out.println("</head>");
        out.println("<!-- Formulaire d'enregistrement de l'utilisateur -->");
        out.println("<body>");
        out.println("<div class=\"registration-box-container\">");
        out.println("<div class=\"registration-box\">");
        out.println("<div class=\"registration-box-heading\">");
        out.println("<p> XTREM HARDWARE <br>");
        out.println("INSCRIPTION </p>");
        out.println("</div>");
        out.println("<div class=\"registration-box-content\">");
        out.println("<div class=\"login\">");
        out.println("<form method=\"post\">");
        out.println("<div class=\"pad-block\">");
        out.println("<div class=\"input-label\"><label for=\"id_username\">Pseudo:</label></div>");
        out.println("<div><input required id=\"id_username\" maxlength=\"30\" name=\"pseudo\" type=\"text\" /></div>");
        out.println("</div>");
        out.println("<div class=\"pad-block\">");
        out.println("<div class=\"input-label\"><label for=\"id_username\">Nom et Prénom:</label></div>");
        out.println("<div><input required id=\"id_username\" maxlength=\"30\" name=\"name\" type=\"text\" /></div>");
        out.println("</div>");
        out.println("<div class=\"pad-block\">");
        out.println("<div class=\"input-label\"><label for=\"id_email\">E-mail:</label></div>");
        out.println("<div><input required id=\"id_email\" maxlength=\"75\" name=\"email\" type=\"text\" /></div>");
        out.println("</div>");
        out.println("<div class=\"pad-block\">");
        out.println("<div class=\"input-label\"><label for=\"id_email2\">E-mail (Confirmation):</label></div>");
        out.println("<div><input required id=\"id_email2\" maxlength=\"75\" name=\"email2\" type=\"text\" /></div>");
        out.println("</div>");
        out.println("<div class=\"pad-block\">");
        out.println("<div class=\"input-label\"><label for=\"id_password1\">Password:</label></div>");
        out.println("<div><input required id=\"id_password1\" name=\"password1\" type=\"password\" /></div>");
        out.println("</div>");
        out.println("<div class=\"pad-block\">");
        out.println("<div class=\"input-label\"><label for=\"id_password2\">Password (Confirmation):</label></div>");
        out.println("<div><input required id=\"id_password2\" name=\"password2\" type=\"password\" /></div>");
        out.println("</div>");
        out.println("<div class=\"pad-block\"><input type=\"submit\" value=\"VALIDER\" /></div>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("/body>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pseudo = req.getParameter("pseudo");
        String nom = req.getParameter("name");
        String email = req.getParameter("email");
        String mdp = req.getParameter("password1");
        try {
            MembreLibrary.getInstance().addMembre(pseudo,nom,email,mdp);
        } catch (IllegalArgumentException e) {
            resp.sendRedirect("error");
            showMessageDialog(null,"Erreur d'inscription");
            return;
        }
        resp.sendRedirect("login");
    }
}


