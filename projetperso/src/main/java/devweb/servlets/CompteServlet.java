package devweb.servlets;

import devweb.entities.Membre;
import devweb.managers.MembreLibrary;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

@WebServlet("/compte")
public class CompteServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        WebContext context = new WebContext(req, resp, req.getServletContext());
        List<Membre> listOfMembres = MembreLibrary.getInstance().listMembres();
        context.setVariable("membresList", listOfMembres);

        TemplateEngine templateEngine = createTemplateEngine(req.getServletContext());
        templateEngine.process("compte", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pseudoX="";
        req.getSession().setAttribute("utilisateurConnecte",pseudoX);
        try {
            Membre deleteMembre = MembreLibrary.getInstance().deleteMembre(pseudoX);
            resp.sendRedirect("accueil");
        } catch (IllegalArgumentException e) {
            resp.sendRedirect("error");
            showMessageDialog(null,"Erreur de suppression");
            return;
        }
    }
}
