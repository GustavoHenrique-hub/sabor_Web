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

@WebServlet("/deleteSabor")
public class DeleteSabor extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = res.getWriter();
		
		String id = req.getParameter("ID");
		
		Sabor sabor = new Sabor();
		sabor.setId(id);
		
		List<Sabor> lista = new ArrayList<>();
		
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("listaSabor");
		
		if(obj != null) {
			lista = (ArrayList<Sabor>) obj;
			lista.remove(sabor);
			
			session.setAttribute("listaSabor", lista);
		}
		
		Util show = new Util();
		pw.append(show.showList(lista));
	}

}
