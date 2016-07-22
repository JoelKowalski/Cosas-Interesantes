

import java.io.IOException;
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

/**
 * Servlet implementation class Servidor
 */
@WebServlet("/Servidor")
public class Servidor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conexion=null;
    Statement statement=null;
    ResultSet resultset=null;
    
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
		resultset=statement.executeQuery("select * from producto");
		Producto useraux=null;
				
		while(resultset.next()){
			useraux=new Producto(resultset);
			listaUser.add(useraux);
		}
		for(Producto p:listaUser){
			System.out.println(p.categoria+" "+p.descripcion+" "+p.nombre+" "+p.imagenurl+" "+p.intro+" "+p.intro+" "+p.precio+" "+p.unidades);
		}
		System.out.println(listaUser.toString());
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		//Conex.liberarRecursos(conexion, statement);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
