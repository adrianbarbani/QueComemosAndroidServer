package ar.algo.adriba.appModel

import ar.algo.adriba.tp1.Cosas
import ar.algo.adriba.tp1.Receta
import ar.algo.adriba.tp1.Usuario
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@JsonIgnoreProperties(ignoreUnknown=true)
@Accessors
class RecetaPack {
	boolean editable = false
	Receta receta
	Usuario usuario

	new(Receta receta, Usuario usuario) {
		this.receta = receta
		this.usuario = usuario
	}

	@JsonProperty("isFavorita")
	def boolean isFavorita() {
		//usuario.esFavoritaEsta(receta)
		false	
		}

	@JsonProperty("condimentos")
	def List<String> condimentos() {
		receta.subRecetaseIngredientes.filter[cosa|cosa.unCondimento].map[it.nombre].toList
	}

	@JsonProperty("ingredientes")
	def List<Cosas> ingredientes() {
		receta.subRecetaseIngredientes.filter[cosa|cosa.unIngrediente].toList
	}

	@JsonProperty("condiciones")
	def List<String> condiciones() {
		receta.getParaQueCondicionesSoyInadecuada.map[condicion|condicion.nombre].toList
	}

	def String getEsDelUsuario() {
		if (usuario.usuarioTiene(receta)) {
			"vos"
		} else {
			"otro"
		}
	}

	@JsonProperty("caloriasYAutor")
	def String calorias() {
		receta.caloriasReceta + " Calorias"
	}

	@JsonProperty("origen")
	def String origen() {
		if (usuario.usuarioTiene(receta)) {
			"usuario"
		} else {
			"publica"
		}
	}
}
