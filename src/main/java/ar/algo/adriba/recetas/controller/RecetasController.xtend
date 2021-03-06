package ar.algo.adriba.recetas.controller

import ar.algo.adriba.appModel.CopiarReceta
import ar.algo.adriba.appModel.DetalleDeRecetaAppModel
import ar.algo.adriba.appModel.LoginAppModel
import ar.algo.adriba.appModel.RecetasObjectSet
import ar.algo.adriba.appModel.UltimasConsultasAppModel
import ar.algo.adriba.appModel.UsuariosObjectSet
import ar.algo.adriba.tp1.Busqueda
import ar.algo.adriba.tp1.Privada
import ar.algo.adriba.tp1.Receta
import ar.algo.adriba.tp1.RecetaBuilder
import ar.algo.adriba.tp1.RepoDeTemporadas
import ar.algo.adriba.tp1.RepoDificultades
import ar.algo.adriba.tp1.Usuario
import java.util.List
import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.annotation.Post
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.json.JSONUtils

@Controller
class RecetasController {

	Usuario usr

	extension JSONUtils = new JSONUtils
	extension JSONPropertyUtils = new JSONPropertyUtils

	def static void main(String[] args) {
		XTRest.start(RecetasController, 9000)
	}

	@Post("/login/")
	def Result login(@Body String body) {
		val LoginAppModel login = body.fromJson(LoginAppModel)
		UsuariosObjectSet.INSTANCE.crearUsuarios

		try {

			login.autorizarLogin
			usr = login.usuarioLogin
			RecetasObjectSet.INSTANCE.crearRecetas(usr)

			response.contentType = ContentType.TEXT_PLAIN
			ok(login.nombreUsuarioABuscar.toJson)

		} catch (Exception e) {
			badRequest(e.message)
		}

	}

	@Get("/recetas")
	def Result Recetas() {

		var List<Receta> recetas = listarLasRecetas()

		response.contentType = ContentType.APPLICATION_JSON
		ok(recetas.toJson)
	}

	@Get("/temporadas")
	def Result temporadas() {
		var temporadas = RepoDeTemporadas.getInstance.dameLasTemporadas()

		response.contentType = ContentType.APPLICATION_JSON
		ok(temporadas.toJson)
	}

	@Get("/dificultades")
	def Result dificultades() {
		var dificultades = RepoDificultades.getInstance.getTodasLasDificultades()

		response.contentType = ContentType.APPLICATION_JSON
		ok(dificultades.toJson)
	}

	@Post("/receta/:id")
	def Result getRecetaByNombre(@Body String body) {

		var Receta receta = getDetalleRecetaAppModel(body).unaReceta

		response.contentType = ContentType.APPLICATION_JSON
		ok(receta.toJson)
	}

	//devuelve el app de los detalles receta, ingresar el id de la receta a buscar
	def getDetalleRecetaAppModel(long body) {
		var Busqueda busqueda = new Busqueda(usr)

		var detalleReceta = new DetalleDeRecetaAppModel(busqueda.buscarPorId(body), usr)
		detalleReceta
	}

	//hacer favorita
	@Post("/favorita/")
	def Result hacerFavorita(@Body String body) {
		var ParceFavorita aux = body.fromJson(ParceFavorita)
		var detalleApp = this.getDetalleRecetaAppModel(aux.numeroId)

		detalleApp.setFavorita(aux.favorita) // ver esto por que no siempre es un true.

		response.contentType = ContentType.TEXT_PLAIN
		ok('{ "status" : "OK" }')

	}

	@Post("/copiar/")
	def Result receta(@Body String body) {

		var Busqueda busqueda = new Busqueda(usr)

		var id = body.getPropertyValue("numeroId")
		var String nombreDeCopia = body.getPropertyValue("nombreDeCopia")

		var copiaReceta = new CopiarReceta(busqueda.buscarPorId(id), usr, nombreDeCopia)


		copiaReceta.copiar()
		
		response.contentType = ContentType.TEXT_PLAIN
		ok('{ "status" : "OK" }')
	}

	@Post("/buscar/")
	def Result buscar(@Body String body) {
		var consultas = new UltimasConsultasAppModel(usr)
		var ParceBusqueda aux = body.fromJson(ParceBusqueda)

		consultas.caloriasDesde = aux.caloriasDesde
		consultas.caloriasHasta = aux.caloriasHasta
		consultas.nombre = aux.nombreReceta
		consultas.dificultadSeleccionada = aux.dificultad
		consultas.temporadaSeleccionada = aux.temporada
		consultas.ingredienteABuscar = aux.ingrediente
		consultas.buscar()

		response.contentType = ContentType.APPLICATION_JSON
		ok(consultas.resultados.toJson)
	}

	//------------------------------------------------------------------
	def listarLasRecetas() {
		val appModel = new UltimasConsultasAppModel(usr)
		appModel.initSearch()

		var List<Receta> recetas = appModel.resultados
		recetas
	}
}
