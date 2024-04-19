package br.sp.senai.util;

import java.util.List;

import br.sp.senai.entities.Sabor;

public class Util {
	public static String showList(List<Sabor> lista) {
		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append("<!DOCTYPE html>");
		strBuffer.append("<html>");
		strBuffer.append("<head>");
		strBuffer.append("<meta charset='ISO-8859-1'>");
		strBuffer.append("<style>");
		strBuffer.append("label{ padding: 5px;}");
		strBuffer.append("a{ padding: 5px; text-decoration: none; color: black }");
		strBuffer.append("</style>");
		strBuffer.append("<title>Novo Sabor</title>");
		strBuffer.append("</head>");
		strBuffer.append("<body>");

		for (Sabor sabores : lista) {
			strBuffer.append("<label> Name: " + sabores.getName() + "</label></br>");
			strBuffer.append("<label> Description: " + sabores.getDesc() + "</label></br>");
			strBuffer.append("<label> Price: " + sabores.getPrice() + "</label></br>");
			strBuffer.append("<label> Id: " + sabores.getId() + "</label></br>");

			strBuffer.append("<a href='/Web_teste/deleteSabor?ID='" + sabores.getId() + "'>Delete</a>");
			strBuffer.append("<a href='/Web_teste/alteraSabor?ID='" + sabores.getId() + "'>Alterar</a></br>");
		}

		strBuffer.append("</body>");
		strBuffer.append("</html>");

		return strBuffer.toString();
	}
}
