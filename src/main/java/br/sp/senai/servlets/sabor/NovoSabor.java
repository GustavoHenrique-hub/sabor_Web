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

@WebServlet("/novoSabor")
public class NovoSabor extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		
		Integer id = Integer.parseInt(req.getParameter("ID"));
		String name = req.getParameter("NAME");
		String desc = req.getParameter("DESC");
		Double price = Double.parseDouble(req.getParameter("PRICE"));
		
		Sabor sabor = new Sabor(id, name, desc, price);
		
		List<Sabor> lista = null;
		
		HttpSession session = req.getSession();	
		Object obj = session.getAttribute("listaSabor");
		
		
		if(obj == null) {
			lista = new ArrayList<>();
			lista.add(sabor);
			
			session.setAttribute("listaSabor", lista);
		}else{
			lista = (ArrayList<Sabor>) obj;
			lista.add(sabor);
			
			session.setAttribute("listaSabor", lista);
		}
		
		Util show = new Util();
		pw.append(show.showList(lista));
	}

}
