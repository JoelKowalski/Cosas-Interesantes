import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;
public class ConectorBD {
private static final String fuente = "java:comp/env/jdbc/pool";
	
	
	private static DataSource fuenteDatos = null;
	
	static
	
	{
		new ConectorBD();
	}
	
	
	private ConectorBD ()
	{
		fuenteDatos = iniciarFuente();
	}
	
		

	private static DataSource iniciarFuente ()
	{
		DataSource ds = null;
		
		try
		{
			InitialContext ct = new InitialContext ();
			ds = (DataSource)ct.lookup(fuente);
		}
		catch (Exception e) {
			
		}
		return ds;
	}
	
	
	
	public static Connection getConnection ()
	{
		Connection conexion = null;
		try
		{
			conexion = fuenteDatos.getConnection();
			
		}
		catch (Exception e) {
			
		}
		return conexion;
	}
	
	public static void liberarRecursos (Connection conexion, Statement st, ResultSet rs)
	{
		
			
			 try 
			 {
				 rs.close(); 
			 }
			 catch (SQLException e)
			 {
				
			 }
			 try 
			 {
				 st.close(); 
			 }
			 catch (SQLException e)
			 {
				
			 }
			 try 
			 {conexion.close();
			 
			 } catch (SQLException e) {
		
			}
		
		
	}
	
	
	public static void liberarRecursos (Connection conexion, Statement st)
	{
			
			 try 
			 {
				 st.close(); 
			 }
			 catch (SQLException e)
			 {
				
			 }
			 try 
			 {conexion.close();
			 
			 } catch (SQLException e) {
				
			}
		
	}
}
