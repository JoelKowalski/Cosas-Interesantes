package edu.cice.remoto;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class SubirPersona
 */
@WebServlet("/SubirPersona")
public class SubirPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubirPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getInputStream();//si voy a  leer bytes
		BufferedReader br= request.getReader();//si voy a leer texto
		String persona_json=br.readLine();
		Gson gson=new Gson();
		Persona p=gson.fromJson(persona_json, Persona.class);
		System.out.println(p.toString());
	}

}
