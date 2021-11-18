package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iesalixar.servidor.bd.ConexionBD;
<<<<<<< HEAD
=======

>>>>>>> d8d766ce2c47d28587f40b92d8f50ab4c43b721b
import org.iesalixar.servidor.model.Usuario;

public class DAOUsuarioImpl implements DAOUsuario {

	public DAOUsuarioImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario getUsuario(String nombre) {
		Usuario usuario = null;
<<<<<<< HEAD

		try {

			String sql = "select * from usuarios where usuario=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, nombre);

			ResultSet rs = statement.executeQuery();

			// Como el campo de b�squeda es la clave solo deber�a obtener un resultado
			// si no es as� estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				usuario = new Usuario();
=======
		try {
			String sql = "select * from usuarios where usuario = ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {

				usuario = new Usuario();

>>>>>>> d8d766ce2c47d28587f40b92d8f50ab4c43b721b
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setRole(rs.getString("role"));

			}
<<<<<<< HEAD

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

=======
			ConexionBD.close();
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
>>>>>>> d8d766ce2c47d28587f40b92d8f50ab4c43b721b
		return usuario;
	}

	@Override
	public boolean registerUsuario(Usuario usuario) {
<<<<<<< HEAD
		int resultado = 0;

		try {

			String sql = "insert into usuarios values(?,?,?,?)";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, usuario.getUsuario());
			statement.setString(3, usuario.getPassword());
			statement.setString(2, usuario.getEmail());
			statement.setString(4, usuario.getRole());

			resultado = statement.executeUpdate();

			ConexionBD.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return (resultado == 0 ? false : true);
=======
		int result = 0;
		try {
			String sql = "insert into usuarios values(?,?,?,?)";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getPassword());
			statement.setString(4, usuario.getRole());
			
			result = statement.executeUpdate();
			
			ConexionBD.close();
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return (result == 0 ? false : true);
>>>>>>> d8d766ce2c47d28587f40b92d8f50ab4c43b721b
	}

}
