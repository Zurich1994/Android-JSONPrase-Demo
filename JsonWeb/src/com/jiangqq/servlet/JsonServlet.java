package com.jiangqq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jiangqq.bean.Person;
import com.jiangqq.csdn.JsonService;

public class JsonServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<Person> persons = JsonService.getListPerson();
		StringBuffer sb = new StringBuffer();
		sb.append('[');
		for (Person person : persons) {
			sb.append('{').append("\"name\":").append("\""+person.getName()+"\"").append(
					",");
			sb.append("\"address\":").append("\""+person.getAddress()+"\"").append(",");
			sb.append("\"age\":").append(person.getAge());
			sb.append('}').append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(']');
		out.write(new String(sb));
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
