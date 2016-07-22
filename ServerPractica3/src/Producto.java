import java.sql.ResultSet;
import java.sql.SQLException;

public class Producto {
	String intro;
	String imagenurl;
	String nombre;
	double precio;
	int unidades;
	String descripcion;
	String categoria;
	
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getImagenurl() {
		return imagenurl;
	}

	public void setImagenurl(String imagenurl) {
		this.imagenurl = imagenurl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}	
	
	public Producto(String intro, String imagenurl, String nombre, double precio, int unidades, String descripcion,
			String categoria) {
		super();
		this.intro = intro;
		this.imagenurl = imagenurl;
		this.nombre = nombre;
		this.precio = precio;
		this.unidades = unidades;
		this.descripcion = descripcion;
		this.categoria = categoria;
	}
	
	public Producto(ResultSet rs) throws SQLException{
		this.intro=rs.getString("intro");
		this.imagenurl=rs.getString("imagenurl");
		this.nombre=rs.getString("nombre"); 
		this.precio=rs.getDouble("precio");
		this.unidades=rs.getInt("unidades");
		this.descripcion=rs.getString("descripcion");
		this.categoria=rs.getString("categoria");
		}
}
