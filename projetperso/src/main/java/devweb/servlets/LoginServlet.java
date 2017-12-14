package devweb.servlets;



import devweb.managers.MembreLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;




@WebServlet("/login")
public class LoginServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html class=\"registration\">");
        out.println("<!-- Titre de l'onglet -->");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta content='text/html; charset=utf-8' http-equiv='Content-Type'>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/login.css\">");
        out.println("<title>XTREM HARDWARE - Login</title>");
        out.println("</head>");
        out.println("<!-- Formulaire de connexion avec pseudo et mot de passe -->");
        out.println("<body>");

        out.println("<div class=\"registration-box-container\">");
        out.println("<div class=\"registration-box\">");
        out.println("<div class=\"registration-box-heading\">");
        out.println("<p> XTREM HARDWARE <br> LOGIN </p>");
        out.println("<div class=\"registration-box-content\">");
        out.println("<div class=\"login\">");
        out.println("<form method=\"post\">");
        out.println("<div class=\"pad-block\">");
        out.println("<div class=\"input-label\">Pseudo</div>");
        out.println("<input id=\"id_username\" type=\"text\" name=\"pseudo\" required maxlength=\"75\">");
        out.println("</div>");
        out.println("<div class=\"pad-block\">");
        out.println("<div class=\"input-label\">Mot de Passe</div>");
        out.println("<input type=\"password\" name=\"password\" required id=\"id_password\">");
        out.println("</div>");
        out.println("<div class=\"pad-block\">");
        out.println("<input type=\"checkbox\" name=\"checkbox\" id=\"checkbox\" />");
        out.println("<span class=\"login-remember-me\">Se souvenir de moi</span>");
        out.println("</div>");
        out.println("<div class=\"pad-block\">");
        out.println("<input type=\"submit\" value=\"Se Connecter\" /></div>");
        out.println("<div class=\"pad-block login-register-text\">");
        out.println("<div>Tu veux nous rejoindre?  <a href=\"register\">Inscrit toi !</a></div>");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pseudo1=req.getParameter("pseudo");
        String password1= MembreLibrary.getInstance().getMdp(pseudo1);
        String password2=req.getParameter("password");

        if (password1==null){
            password1="";
        }

        if (password1.equals(password2)) {
            req.getSession().setAttribute("utilisateurConnecte",pseudo1);
            resp.sendRedirect("compte");
        } else{
            resp.sendRedirect("error");
        }

    }
}

