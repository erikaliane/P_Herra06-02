package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Inventario {
	public Connection con;
	public PreparedStatement sen;
	public Statement sen2;
	public ResultSet datos;
	public String driver="com.mysql.jdbc.Driver";
	public String cadena="jdbc:mysql://localhost/p_herramienta";
	public String usuario="root";
	public String clave="";
	public Connection conectarBD() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(cadena,usuario,clave);
		}catch(ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null,"Error en el driver");
		}catch(SQLException e2) {
			JOptionPane.showMessageDialog(null, "Error en la conexion");
		}return con;
	}
	
	public  boolean  registrar_herra( String nom, String marca,String serie,String cod_barra ) {
		try {
			String codigo="insert into herramienta (nombre,marca,serie,cod_barra) values(?,?,?,?)";
			sen=conectarBD().prepareStatement(codigo);
			sen.setString(1, nom);
			sen.setString(2, marca);
			sen.setString(3, serie);
			sen.setString(4,cod_barra);
			sen.executeUpdate();		
		}catch(SQLException e3) {
			
		}
		return true;
		
	}
	
	public  boolean  registrar_usuario(int cod, String nom, String apell ) {
		try {
			String codigo="insert into usuario values(?,?,?)";
			sen=conectarBD().prepareStatement(codigo);
			sen.setInt(1, cod);
			sen.setString(2, nom);
			sen.setString(3, apell);
			sen.executeUpdate();		
		}catch(SQLException e3) {
			
		}
		return true;
	}
	
	public ResultSet consulta(String codigosql) {
		try {
			String codigo=codigosql;
			sen2=conectarBD().createStatement();
			datos=sen2.executeQuery(codigo);
		}catch(SQLException e3) {
			JOptionPane.showMessageDialog(null, "Error en la consulta ");
			
		}
		return datos;
	}
	public void imprimir(javax.swing.JTextArea caja) {
		caja.setText(" \tCodigo \tNombre \tApellido");
		ResultSet data=consulta("select * from usuario");
		try {
		while(data.next()) {
			caja.append("\n"+"\n"+data.getInt(1)+"\t"+data.getString(2)+
					"\t"+data.getString(3));
		}
		}catch(SQLException e) {
	    }
	}
} 