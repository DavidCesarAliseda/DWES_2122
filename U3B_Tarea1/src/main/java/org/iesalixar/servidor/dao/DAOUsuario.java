package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.models.Usuario;

public interface DAOUsuario {
	public ArrayList<Usuario> getAllUsers();
	public boolean updateUser(Usuario user);
	public boolean insertUser(Usuario user);
	public boolean changePassword(Usuario user, String password);
	public Usuario getUsuario(String nombre);
	public boolean registerUsuario(Usuario usuario);
}
