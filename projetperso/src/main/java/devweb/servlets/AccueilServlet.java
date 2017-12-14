package devweb.servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/accueil")
public class AccueilServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("        <!DOCTYPE html>");
        out.println("<html xmlns:th=\"http://www.thymeleaf.org\">");
        out.println("");
        out.println("<!-- Titre de l'onglet -->");
        out.println("");
        out.println("                <head>");
        out.println("	<title> Accueil Xtrem-Hardware </title>");
        out.println("	<meta charset=\"utf-8\">");
        out.println("	<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/accueil.css\">");
        out.println("</head>");
        out.println("");
        out.println("");
        out.println("<body>");
        out.println("");
        out.println("<!-- Image titre et option de connexion pour toutes les pages -->");
        out.println("");
        out.println("	<header>");
        out.println("		<div class=\"pcheader\">");
        out.println("			<img src=\"../img/titre.png\">");
        out.println("			<ul class=\"user-nav\">");

        String identifiantUtilisateurConnecte = (String) req.getSession().getAttribute("utilisateurConnecte");
        if (identifiantUtilisateurConnecte==null || "".equals(identifiantUtilisateurConnecte)) {
        out.println("<li><a href=\"../login\"><b>Login</b></a></li>");
        out.println("<li><a href=\"../register\"><b>Register</b></a></li>");
        } else {
            out.println("<li><a href=\"../compte\"><b>Mon Compte</b></a></li>");
            out.println("<li><a href=\"../deconnexion\"><b>Deconnexion</b></a></li>");
        }

        out.println("");
        out.println("			</ul>");
        out.println("		</div>");
        out.println("		<br>");
        out.println("	</header>");
        out.println("");
        out.println("");
        out.println("<!-- Barre de navigation identique pour toutes les pages-->");
        out.println("");
        out.println("	<nav class=\"nav\">");
        out.println("		<ul>");
        out.println("			<li><a href=\"accueil\">ACCUEIL</a></li>");
        out.println("			<li><a href=\"guide\">GUIDE DE MONTAGE</a></li>");
        out.println("			<li><a href=\"config\">MA CONFIG</a></li>");
        out.println("			<li><a href=\"photos\">PHOTOS</a></li>");
        out.println("			<li><a href=\"contact\">CONTACT</a></li>");
        out.println("		</ul>");
        out.println("	</nav>");
        out.println("");
        out.println("");
        out.println("<!-- 3 classes côte à côte  -->");
        out.println("");
        out.println("	<div class=\"guides\">");
        out.println("");
        out.println("");
        out.println("		<div class=\"intro\">");
        out.println("			<h2> GUIDE MONTAGE </h2>");
        out.println("			<p> Ce site va vous permettre de construire votre propre PC. Besoin d'aide pour trouver une config ? Explorez notre guide de montage, qui va vous permettre de déterminer les composants systèmes pour tout types d'utilisation, ou créer vous mêmes votre propre config grâce à la communauté ! </p>");
        out.println("			<a href=\"guide\">Voir les Guides</a>");
        out.println("		</div>");
        out.println("");
        out.println("");
        out.println("		<div class=\"derniere\">");
        out.println("			<h3> DERNIERE CONFIG</h3>");
        out.println("			<h4> LA VR LOW-COST </h4>");
        out.println("			<table>");
        out.println("				<tr> <th> Processeur </th> <td> Intel Core i3-7100 </td> </tr>");
        out.println("				<tr> <th> Carte mère </th> <td> MSI BP150 </td> </tr>");
        out.println("				<tr> <th> Carte Graphique </th> <td> Geforce GTX 1050 </td> </tr>");
        out.println("				<tr> <th> Prix :</th> <td> 550 € </td> </tr>");
        out.println("			</table>");
        out.println("			<br>");
        out.println("			<img src=\"../img/pc.png\"/>");
        out.println("		</div>");
        out.println("");
        out.println("");
        out.println("		<div class=\"populaire\">");
        out.println("			<h3> BUILDS POPULAIRES </h3>");
        out.println("			<div>");
        out.println("				<h4> Modest Gaming Build </h4>");
        out.println("				<p>AMD Ryzen 5 1600 <br>");
        out.println("                GeForce GTX 1060 6GB <br>");
        out.println("        Fractal Design Focus G Mini Noir</p>");
        out.println("				<p id=\"prix\"> 768.34€ </p>");
        out.println("			</div>");
        out.println("			<div>");
        out.println("				<h4> Entry Level AMD Gaming Build </h4>");
        out.println("				<p>AMD Ryzen 3 1200 <br>");
        out.println("                GeForce GTX 1050 Ti <br>");
        out.println("        Corsair Carbide SPEC-04 Noir/Rouge <br> </p>");
        out.println("				<p id=\"prix\"> 508.32€</p>");
        out.println("				</div>");
        out.println("			<div>");
        out.println("				<h4> Great Intel Gaming Build </h4>");
        out.println("				<p>Intel Core i5-7500 <br>");
        out.println("                GeForce GTX 1080 <br>");
        out.println("                Phanteks Enthoo Pro M Gris Métal <br> </p>");
        out.println("				<p id=\"prix\"> 1113.94€ </p>");
        out.println("			</div>");
        out.println("		</div>");
        out.println("");
        out.println("<!-- 3 autres classes avec images côte à côte -->");
        out.println("");
        out.println("		</div>");
        out.println("");
        out.println("			<div class=\"apercu\">");
        out.println("");
        out.println("				<h2> APERCU DE CONFIG </h2>");
        out.println("				<figure id=\"photos\">");
        out.println("					<div class=\"photo1\">");
        out.println("						<img class=\"img-circle\" src=\"../img/pc1.jpeg\"  alt=\"HEI c’est bien\" /> <br>");
        out.println("						<a id=\"legende\" href=\"http://gamekult.com\"> Poséidon By Daenerys </a>");
        out.println("					</div>");
        out.println("					<div class=\"photo3\">");
        out.println("						<img class=\"img-circle\" src=\"../img/pc3.jpg\"oc alt=\"HEI c’est bien\"/> <br>");
        out.println("						<a id=\"legende\" href=\"http://gamekult.comv\"> RedHot By Sersei </a>");
        out.println("					</div>");
        out.println("					<div class=\"photo2\">");
        out.println("						<img class=\"img-circle\" src=\"../img/pc2.jpg\" alt=\"HEI c’est bien\"/> <br>");
        out.println("						<a id=\"legende\" href=\"http://gamekult.com\"> UV Radiation By JohnSnow </a>");
        out.println("					</div>");
        out.println("					<br>");
        out.println("				</figure>");
        out.println("			</div>");
        out.println("");
        out.println("<!-- Barre de bas de page identique pour toutes les pages -->");
        out.println("");
        out.println("		<footer>");
        out.println("			<div class=\"bas-page\">");
        out.println("");
        out.println("				<ul class=\"footer-nav\">");
        out.println("					<h4>Sections</h4>");
        out.println("					<li><a href=\"../accueil\">Accueil</a></li>");
        out.println("					<li><a href=\"../guide\">Guide de Montage</a></li>");
        out.println("					<li><a href=\"../config\">Configuration</a></li>");
        out.println("					<li><a href=\"../photos\">Album Photos</a></li>");
        out.println("				</ul>");
        out.println("");
        out.println("				<ul class=\"footer-nav\">");
        out.println("					<h4> A Propos</h4>");
        out.println("					<li><a href=\"../accueil\">About</a></li>");
        out.println("					<li><a href=\"../contact\">Contact </a></li>");
        out.println("				</ul>");
        out.println("");
        out.println("				<ul class=\"footer-nav\">");
        out.println("					<h4>Rejoins Nous </h4>");
        out.println("					<li><a href=\"https://www.facebook.com\">Facebook</a></li>");
        out.println("					<li><a href=\"https://instagram.com\">Instagram</a></li>");
        out.println("					<li><a href=\"https://twitter.com\">Twitter</a></li>");
        out.println("					<li><a href=\"https://www.youtube.com\">YouTube</a></li>");
        out.println("				</ul>");
        out.println("");
        out.println("				<div class=\"footer-branding\">");
        out.println("					<div class=\"copyright-notice\">2017 Xtrem Hardware.  All rights reserved.</div>");
        out.println("				</div>");
        out.println("");
        out.println("			</div>");
        out.println("			</footer>");
        out.println("");
        out.println("		</body>");
        out.println("");
        out.println("");
        out.println("		</html>");


    }


}

