

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class Servidor
 */
@WebServlet("/Servidor")
public class Servidor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conexion=null;
    Statement statement=null;
    ResultSet resultset=null;
    HttpURLConnection http=null;
    PrintWriter pw = null;
 /**
  * @see HttpServlet#HttpServlet()
  */
 public Servidor() {
     super();
     // TODO Auto-generated constructor stub
 }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	try {
		List<Producto> listaUser=null;
		listaUser=new ArrayList<Producto>();
		
		conexion=ConectorBD.getConnection();
		statement=conexion.createStatement();
		if(!request.getParameter("nombre").equals("Todo")){
			resultset=statement.executeQuery("select * from producto where categoria='"+request.getParameter("nombre")+"'");
		}else{
			resultset=statement.executeQuery("select * from producto");
		}
		Producto useraux=null;
				
		while(resultset.next()){
			useraux=new Producto(resultset);
			listaUser.add(useraux);
			System.out.println(listaUser.get(0).getImagen());
		}
		response.setContentType("application/json");//seteo la respuesta
		response.setStatus(HttpURLConnection.HTTP_OK);//seteo el código http de que ha ido bien la cosa! OK = 200
		String puntuaciones_json = transformarPuntuacionesAJSON (listaUser);
		
		
		
		pw = response.getWriter();
		pw.print(puntuaciones_json);
		
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		ConectorBD.liberarRecursos(conexion, statement);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}
	
	private String transformarPuntuacionesAJSON (List<Producto> lista)
	    {
	    	String listaProductos_json = null;
	    	
	    		
	    		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	    		listaProductos_json = gson.toJson(lista);
	    	
	    	return listaProductos_json;
	    }


}
