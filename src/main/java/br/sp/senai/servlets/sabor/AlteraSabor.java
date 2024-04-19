package br.sp.senai.servlets.sabor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.sp.senai.entities.Sabor;
import br.sp.senai.util.Util;

@WebServlet("/alteraSabor")
public class AlteraSabor extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();

		String id = req.getParameter("ID");
		
		Sabor sabor = new Sabor();
		sabor.setId(Integer.parseInt(id));

		List<Sabor> lista = null;

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("listaSabor");

		if (obj != null) {
			lista = (ArrayList<Sabor>) obj;

			Integer posicao = lista.indexOf(sabor);

			if (posicao >= 0) {
				sabor = lista.get(posicao);
			}
		}

		pw.append("<!DOCTYPE html>");
		pw.append("<html>");
		pw.append("<head>");
		pw.append("<meta charset='ISO-8859-1'>");
		pw.append("<title>Novo Sabor</title>");
		pw.append("</head>");
		pw.append("<body>");
		pw.append("<form action='/Web_teste/novoSabor' method='post'>");
		pw.append("<label for='ID';>Id:</label>");
		pw.append("<input type='text' name='ID' value='"+ sabor.getId() +"'>");
		pw.append("<label for='NAME'>Name:</label>");
		pw.append("<input type='text' name='NAME' value='"+ sabor.getName() +"'>");
		pw.append("<label for='DESC'>Descriptiom:</label>");
		pw.append("<input type='text' name='DESC' value='"+ sabor.getDesc() +"'>");
		pw.append("<label for='PRICE'>Price:</label>");
		pw.append("<input type='text' name='PRICE' value='"+ sabor.getPrice() +"'>");

		pw.append("<input type='submit' value='Alterar'>");

		pw.append("</form>");
		pw.append("</body>");
		pw.append("</html>");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//lista.set(posicao, sabor);
	}

}
