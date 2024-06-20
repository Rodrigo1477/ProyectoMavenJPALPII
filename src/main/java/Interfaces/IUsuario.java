package Interfaces;

import java.util.List;

import model.TblUsuario;

public interface IUsuario {
	
	public void RegistrarUsuario(TblUsuario usuario);
	public void ActualizarUsuario(TblUsuario usuario);
	public void EliminarUsuario(TblUsuario usuario);
	public TblUsuario BuscarUsuario(TblUsuario usuario);
	public List<TblUsuario> ListarUsuario();

}
