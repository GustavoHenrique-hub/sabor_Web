package br.sp.senai.servlets.sabor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.sp.senai.entities.Sabor;
import br.sp.senai.util.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/alteraSabor")
public class AlteraSabor extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();

		String id = req.getParameter("ID");
		
		Sabor sabor = new Sabor();
		sabor.setId(id);

		List<Sabor> lista = null;

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("listaSabor");

		if (obj != null) {
			lista = (ArrayList<Sabor>) obj;

			int posicao = lista.indexOf(sabor);

			if (posicao >= 0) {
				sabor = lista.get(posicao);
			}
		}
		
		Util show = new Util();
		
		
		pw.append("<!DOCTYPE html>");
		pw.append("<html>");
		pw.append("<head>");
		pw.append("<meta charset='ISO-8859-1'>");
		pw.append("<title>Novo Sabor</title>");
		pw.append("<style>");
		pw.append("label{ padding: 5px;}");
		pw.append("a{ padding: 5px; text-decoration: none; color: black }");
		pw.append("</style>");
		pw.append("</head>");
		pw.append("<body>");
		pw.append("<form action='/Web_teste/alteraSabor' method='post'>");
		pw.append("<label for='ID';>Id:</label>");
		pw.append("<input type='text' name='ID' value='"+ sabor.getId() +"'>");
		pw.append("<label for='NAME'>Name:</label>");
		pw.append("<input type='text' name='NAME' value='"+ sabor.getName() +"'>");
		pw.append("<label for='DESC'>Descriptiom:</label>");
		pw.append("<input type='text' name='DESC' value='"+ sabor.getDesc() +"'>");
		pw.append("<label for='PRICE'>Price:</label>");
		pw.append("<input type='text' name='PRICE' value='"+ sabor.getPrice() +"'>");

		pw.append("<input type='submit' value='Alterar'>");

		pw.append("</form></br>");
		
		pw.append("<button onclick= \"window.location.href = '/Web_teste/novoSabor.html'\">Cancelar</button></br>");
		pw.append("</body>");
		pw.append("</html>");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		
		String id = req.getParameter("ID");
		String name = req.getParameter("NAME");
		String desc = req.getParameter("DESC");
		Double price = Double.parseDouble(req.getParameter("PRICE"));
		
		Sabor sabor = new Sabor(id, name, desc, price);
		
		List<Sabor> lista = null;
		
		HttpSession session = req.getSession();	
		Object obj = session.getAttribute("listaSabor");
		
		if(obj != null) {
			lista = (ArrayList<Sabor>) obj;
			
			int posicao = lista.indexOf(sabor);
			
			if (posicao >= 0) {
				lista.set(posicao, sabor);
			}		
		}
		
		Util show = new Util();
		pw.append(show.showList(lista));
	}

}
