import java.sql.ResultSet;
import java.sql.SQLException;

public class Producto {
	String intro;
	String imagen;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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
	
	public Producto(String intro, String imagen, String nombre, double precio, int unidades, String descripcion,
			String categoria) {
		super();
		this.intro = intro;
		this.imagen = imagen;
		this.nombre = nombre;
		this.precio = precio;
		this.unidades = unidades;
		this.descripcion = descripcion;
		this.categoria = categoria;
	}
	
	public Producto(ResultSet rs) throws SQLException{
		this.intro=rs.getString("intro");
		this.imagen=rs.getString("imagen");
		this.nombre=rs.getString("nombre"); 
		this.precio=rs.getDouble("precio");
		this.unidades=rs.getInt("unidades");
		this.descripcion=rs.getString("descripcion");
		this.categoria=rs.getString("categoria");
		}
}
