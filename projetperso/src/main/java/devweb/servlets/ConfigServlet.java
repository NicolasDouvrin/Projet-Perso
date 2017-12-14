package devweb.servlets;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/config")
public class ConfigServlet extends GenericServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("        <!DOCTYPE html>");
        out.println("<html>");
        out.println("");
        out.println("<!-- Titre de l'onglet -->");
        out.println("");
        out.println("                <head>");
        out.println("	<title> Config Xtrem-Hardware </title>");
        out.println("	<meta charset=\"utf-8\">");
        out.println("	<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/accueil.css\">");

        out.println("<script type=\"text/javascript\" src=\"js/form.js\"></script>");

        out.println("</head>");
        out.println("");
        out.println("");
        out.println("<body>");
        out.println("");
        out.println("<!-- Image titre et option de connexion pour toutes les pages -->");
        out.println("");
        out.println("<header>");
        out.println("	<div class=\"pcheader\">");
        out.println("		<img src=\"../img/titre.png\">");
        out.println("		<ul class=\"user-nav\">");

        String identifiantUtilisateurConnecte = (String) req.getSession().getAttribute("utilisateurConnecte");
        if (identifiantUtilisateurConnecte==null || "".equals(identifiantUtilisateurConnecte)) {
            out.println("<li><a href=\"../login\"><b>Login</b></a></li>");
            out.println("<li><a href=\"../register\"><b>Register</b></a></li>");
        } else {
            out.println("<li><a href=\"../compte\"><b>Mon Compte</b></a></li>");
            out.println("<li><a href=\"../deconnexion\"><b>Deconnexion</b></a></li>");
        }

        out.println("		</ul>");
        out.println("	</div>");
        out.println("</header>");
        out.println("");
        out.println("<!-- Barre de navigation identique pour toutes les pages-->");
        out.println("");
        out.println("<nav class=\"nav\">");
        out.println("	<ul>");
        out.println("		<li><a href=\"accueil\">ACCUEIL</a></li>");
        out.println("		<li><a href=\"guide\">GUIDE DE MONTAGE</a></li>");
        out.println("		<li><a href=\"config\">MA CONFIG</a></li>");
        out.println("		<li><a href=\"photos\">PHOTOS</a></li>");
        out.println("			<li><a href=\"contact\">CONTACT</a></li>");
        out.println("	</ul>");
        out.println("</nav>");
        out.println("");
        out.println("<!-- Formulaire qui selon les choix va indiquer le pc le plus adpaté -->");
        out.println("");
        out.println("<div class=\"config\">");
        out.println("	<form id=\"multiphase\" onsubmit=\"return false\">");
        out.println("");
        out.println("		<div class=\"profil\" >");
        out.println("			<h2 id=\"profil\" >Sélection du Profil</h2>");
        out.println("");
        out.println("			<p id=\"phase1\">");
        out.println("				<label for=\"type\">Quel type de PC souhaitez-vous ?</label><br/><br/>");
        out.println("				<select name=\"type\" id=\"type\">");
        out.println("					<option value=\"fixe\">PC Fixe</option>");
        out.println("					<option value=\"portable\">PC Portable</option>");
        out.println("				</select><br/>");
        out.println("			</br><input type=\"image\" id=\"submit_next\" name=\"valider\" onclick=\"processPhase1()\" src=\"../img/valider.png\" width=\"100px\" />");
        out.println("			</p>");

        out.println("");
        out.println("			<p id=\"phase2\" style=\"display: none\">");
        out.println("				<label for=\"activite\">Quelle est votre activité principale pour bureautique?</label><br/><br/>");
        out.println("				<select name=\"activite\" id=\"activite\">");
        out.println("					<option value=\"aucun\"> </option>");
        out.println("					<option value=\"jeu\"> Jouer</option>");
        out.println("					<option value=\"montage\">Montage Photo/Video</option>");
        out.println("					<option value=\"web\">Naviger sur internet/Cours</option>");
        out.println("				</select><br/>");
        out.println("			</br><input type=\"image\" id=\"submit_next\" name=\"valider\" onclick=\"processPhase2()\" src=\"../img/valider.png\" width=\"100px\" />");
        out.println("			</p>");

        out.println("");
        out.println("			<p id=\"phase3\" style=\"display: none\">");
        out.println("				<label for=\"jeux\">Quels sont vos jeux principaux?</label><br/><br/>");
        out.println("				<select name=\"jeux\" id=\"jeux\">");
        out.println("					<option value=\"aucun\"> </option>");
        out.println("					<option value=\"mmo\"> MMO (WOW, AION, GUILDWARS)</option>");
        out.println("					<option value=\"fps\">FPS (CSGO, COD, DESTINY)</option>");
        out.println("					<option value=\"aventure\">AVENTURE (TOM RAIDER, GTA V)</option>");
        out.println("					<option value=\"plateform\">PLATEFORM (LOL, BATTLERITE, DOFUS)</option>");
        out.println("				</select><br/>");
        out.println("			</br><input type=\"image\" id=\"submit_next\" name=\"valider\" onclick=\"processPhase3()\" src=\"../img/valider.png\" width=\"100px\" />");
        out.println("			</p>");
        out.println("");
        out.println("			<p id=\"phase4\" style=\"display: none\">");
        out.println("				<label for=\"favportable\">Que favorisez vous pour PC Portable?</label><br/><br/>");
        out.println("				<select name=\"favportable\" id=\"favportable\">");
        out.println("					<option value=\"aucun\"> </option>");
        out.println("					<option value=\"poids\"> Légèreté </option>");
        out.println("					<option value=\"autonomie\"> Autonomie </option>");
        out.println("					<option value=\"puissance\"> Puissance </option>");
        out.println("					<option value=\"design\"> Design </option>");
        out.println("				</select><br/>");
        out.println("			</br><input type=\"image\" id=\"submit_next\" name=\"valider\" onclick=\"valider()\" src=\"../img/valider.png\" width=\"100px\" />");
        out.println("			</p>");
        out.println("");
        out.println("			<p id=\"phase5\" style=\"display: none\">");
        out.println("				<label for=\"favfixe\">Que favorisez vous pour PC Fixe?</label><br/><br/>");
        out.println("				<select name=\"favfixe\" id=\"favfixe\">");
        out.println("					<option value=\"aucun\"> </option>");
        out.println("					<option value=\"puissance\"> Puissance </option>");
        out.println("					<option value=\"silence\"> Silence </option>");
        out.println("					<option value=\"graphisme\"> Graphismes </option>");
        out.println("					<option value=\"design\"> Design </option>");
        out.println("				</select><br/>");
        out.println("			</br><input type=\"image\" id=\"submit_next\" name=\"valider\" onclick=\"valider()\" src=\"../img/valider.png\" width=\"100px\" />");
        out.println("			</p>");

        out.println("			    <div id=\"result1\" style=\"display: none\">");
        out.println("			         <h2>Voici l'ordinateur le plus adapté pour vous</h2>");
        out.println("		             <img src=\"../img/fixem.jpg\" style=\"height: 500px; width: 500px;\"></br><br/>");
        out.println("		             <a href=\"https://www.topachat.com/pages/detail2_cat_est_ordinateurs_puis_rubrique_est_w_pc_puis_ref_est_in10109015.html\">HP Envy Curved All-in-One</a>");
        out.println("			    </div>");

        out.println("			<div id=\"result2\" style=\"display: none\">");
        out.println("			    <h2>Voici l'ordinateur le plus adapté pour vous</h2>");
        out.println("		        <img src=\"../img/fixew.jpg\" style=\"height: 500px; width: 500px;\"></br><br/>");
        out.println("		        <a href=\"https://www.topachat.com/pages/detail2_cat_est_ordinateurs_puis_rubrique_est_w_pc_puis_ref_est_in10109070.html\">PC MOBA 1</a>");
        out.println("			</div>");

        out.println("			<div id=\"result3\" style=\"display: none\">");
        out.println("			    <h2>Voici l'ordinateur le plus adapté pour vous</h2>");
        out.println("		        <img src=\"../img/fixej.jpg\" style=\"height: 500px; width: 500px;\"></br><br/>");
        out.println("		        <a href=\"https://www.topachat.com/pages/detail2_cat_est_ordinateurs_puis_rubrique_est_w_pc_puis_ref_est_in10107604.html\">PC BARYUM</a>");
        out.println("			</div>");

        out.println("			<div id=\"result4\" style=\"display: none\">");
        out.println("			    <h2>Voici l'ordinateur le plus adapté pour vous</h2>");
        out.println("		        <img src=\"../img/portm.jpg\" style=\"height: 500px; width: 500px;\"></br><br/>");
        out.println("		        <a href=\"https://www.topachat.com/pages/detail2_cat_est_ordinateurs_puis_rubrique_est_w_porgam_puis_ref_est_in10108254.html\">Gigabyte Aero 14</a>");
        out.println("			</div>");

        out.println("			<div id=\"result5\" style=\"display: none\">");
        out.println("			    <h2>Voici l'ordinateur le plus adapté pour vous</h2>");
        out.println("		        <img src=\"../img/portw.jpg\" style=\"height: 500px; width: 500px;\"></br><br/>");
        out.println("		        <a href=\"https://www.topachat.com/pages/detail2_cat_est_ordinateurs_puis_rubrique_est_wport_puis_ref_est_in10106336.html\">Asus VivoBook S14</a>");
        out.println("			</div>");

        out.println("			<div id=\"result6\" style=\"display: none\">");
        out.println("			    <h2>Voici l'ordinateur le plus adapté pour vous</h2>");
        out.println("		        <img src=\"../img/portj.jpg\" style=\"height: 300px; width: 500px;\"></br><br/>");
        out.println("		        <a href=\"https://www.topachat.com/pages/detail2_cat_est_ordinateurs_puis_rubrique_est_w_porgam_puis_ref_est_in10108089.html\">HP Omen 15</a>");
        out.println("			</div>");

        out.println("");
        out.println("		</div>");
        out.println("	</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("");
        out.println("");
        out.println("<!-- Barre de bas de page identique pour toutes les pages -->");
        out.println("");
        out.println("<footer>");
        out.println("	<div class=\"bas-page\">");
        out.println("");
        out.println("		<ul class=\"footer-nav\">");
        out.println("			<h4>Sections</h4>");
        out.println("			<li><a href=\"../accueil\">Accueil</a></li>");
        out.println("			<li><a href=\"../guide\">Guide de Montage</a></li>");
        out.println("			<li><a href=\"../config\">Configuration</a></li>");
        out.println("			<li><a href=\"../photos\">Album Photos</a></li>");
        out.println("		</ul>");
        out.println("");
        out.println("		<ul class=\"footer-nav\">");
        out.println("			<h4> A Propos</h4>");
        out.println("			<li><a href=\"../accueil\">About</a></li>");
        out.println("			<li><a href=\"../contact\">Contact </a></li>");
        out.println("		</ul>");
        out.println("");
        out.println("		<ul class=\"footer-nav\">");
        out.println("			<h4>Rejoins Nous </h4>");
        out.println("			<li><a href=\"https://www.facebook.com\">Facebook</a></li>");
        out.println("			<li><a href=\"https://instagram.com\">Instagram</a></li>");
        out.println("			<li><a href=\"https://twitter.com\">Twitter</a></li>");
        out.println("			<li><a href=\"https://www.youtube.com\">YouTube</a></li>");
        out.println("		</ul>");
        out.println("");
        out.println("		<div class=\"footer-branding\">");
        out.println("			<div class=\"copyright-notice\">2017 Xtrem Hardware.  All rights reserved.</div>");
        out.println("		</div>");
        out.println("");
        out.println("	</div>");
        out.println("</footer>");
        out.println("");
        out.println("</html>");
    }
}

