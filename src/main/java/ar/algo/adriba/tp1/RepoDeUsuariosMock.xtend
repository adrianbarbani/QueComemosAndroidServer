package ar.algo.adriba.tp1

import java.util.HashMap
import java.util.List
import java.util.Map
import org.uqbar.commons.model.UserException

class RepoDeUsuariosMock {
	static RepoDeUsuariosMock repositorio = null

	public List<Usuario> todosLosUsuarios = newArrayList
	Map<Usuario, String> usuarioContrasenia = new HashMap<Usuario, String>
	
	public new() {
		
	}

	
	def agregarUsuarioConContrase�a(Usuario usuario, String contrasenia){
		todosLosUsuarios.add(usuario)
		usuarioContrasenia.put(usuario,contrasenia)
			
	}
	
	def quitarUsuario(Usuario usuario, String contrasenia){
		todosLosUsuarios.remove(usuario)
		usuarioContrasenia.remove(usuario)
	}
	
	def Usuario compararContrase�a(String usr, String contraseniaIngresada){
		val Usuario usuario = this.obtenerUsuario(usr)
		if(!usuarioContrasenia.get(usuario).equals(contraseniaIngresada))
		throw new RuntimeException("Contraseña incorrecta")else{usuario}	
	} 
	
	
	def  obtenerUsuario(String nombre){
		val Usuario usuario = todosLosUsuarios.findFirst[usr|usr.esTuNombre(nombre)]
		if (usuario==null){
			throw new RuntimeException ("Ingrese un usuario existente")
		}else{usuario}
	}
	
	
	
	static public def RepoDeUsuariosMock getInstance() {
		if (repositorio == null) {
			repositorio = new RepoDeUsuariosMock()
		}
      repositorio;
	}
	
	
}
