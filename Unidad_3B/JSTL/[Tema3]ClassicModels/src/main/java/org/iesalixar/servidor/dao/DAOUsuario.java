package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Usuario;

public interface DAOUsuario {
	public List<Usuario> getAllUsers();
	public boolean updateUser(Usuario user);
	public boolean insertUser(Usuario user);
	public boolean changePassword(Usuario user, String password);
	public Usuario getUsuario(String nombre);
	public boolean registerUsuario(Usuario usuario);
}
