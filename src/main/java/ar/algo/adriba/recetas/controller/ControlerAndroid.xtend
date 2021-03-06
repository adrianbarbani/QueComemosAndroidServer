package ar.algo.adriba.recetas.controller

import ar.algo.adriba.appModel.DetalleDeRecetaAppModel
import ar.algo.adriba.tp1.Busqueda
import ar.algo.adriba.tp1.Comida
import ar.algo.adriba.tp1.Fecha
import ar.algo.adriba.tp1.Publica
import ar.algo.adriba.tp1.Receta
import ar.algo.adriba.tp1.RecetaBuilder
import ar.algo.adriba.tp1.Rutina
import ar.algo.adriba.tp1.Sexo
import ar.algo.adriba.tp1.Usuario
import ar.algo.adriba.tp1.UsuarioBuilder
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.annotation.Post
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.json.JSONUtils

@Controller
@Accessors
class ControlerAndroid {
	extension JSONUtils = new JSONUtils

	Fecha fechaValida = new Fecha(System.currentTimeMillis() - 24 * 60 * 60 * 1000);

	List<Receta> recetas = new ArrayList
	int cont = 0
	Usuario usr = new UsuarioBuilder().agregarPeso(52).agregarAltura(1.64).agregarSexo(Sexo.FEMENINO).
		agregarNombre("Esteban").agregarFechaNacimiento(fechaValida).agregarRutina(new Rutina(61, true)).build("1234")

	Comida carne = new Comida(0, "carne", 1)
	Comida harina = new Comida(0, "Harina", 20)
	Comida huevo = new Comida(0, "Huevo", 3)
	Comida aceite = new Comida(0, "Huevo", 3)
	Comida panRallado = new Comida(0, "Pan Rallado", 50)
	Comida verdura = new Comida(0, "Verdura", 12)
	Comida queso = new Comida(0, "Muzzarella", 200)
	Comida prepizza = new Comida(0, "Prepizza", 1)
	Comida salsaDeTomate = new Comida(0, "Salsa de tomate", 200)
	Comida sal = new Comida(18, "Sal", 0)
	Comida salsaBlanca = new Comida(0, "Salsa Blanca", 400)
	Comida lomo = new Comida(0, "Lomo", 200)
	Comida garbanzos = new Comida(0, "Garbanzos", 500)
	Comida limon = new Comida(10, "Limon", 0)
	Comida ajo = new Comida(5, "Ajo", 0)
	Comida jamon = new Comida(0, "Jamon", 100)
	Comida oregano = new Comida(100, "Oregano", 0)
	Comida azucar = new Comida(0, "azucar", 200)

	def void init() {
		recetas => [
			add(
				new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Milanesas").agregarIngrediente(harina).
					agregarIngrediente(huevo).agregarIngrediente(aceite).setearTemporadas("Todo el año").
					agregarIngrediente(panRallado).agregarIngrediente(carne).agregarIngrediente(oregano).
					setearCalorias(150).setearDificultad("Dificil").setearPreparacion(
						"Pasar la carne por huevo, harina y pan rallado. Freir con el aceite por 10 minutos").
					setearNumeroId(1).build)
			add(
				new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Milanesa Napolitana").
					agregarIngrediente(harina).agregarIngrediente(huevo).agregarIngrediente(panRallado).
					agregarIngrediente(carne).agregarIngrediente(queso).agregarIngrediente(salsaDeTomate).
					setearCalorias(8000).setearTemporadas("Todo el año").setearDificultad("Dificil").
					setearPreparacion(
						"Pasar la carne por huevo, harina y pan rallado. Freir con el aceite por 10 minutos. Luego colocarle la salsa de tomate, el queso y  calentar").
					setearNumeroId(2).build)
			add(
				new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Sopa de Verdura").
					agregarIngrediente(verdura).agregarIngrediente(sal).setearCalorias(200).setearTemporadas("Invierno").
					setearDificultad("Dificil").setearPreparacion("").setearNumeroId(3).build
			)
			add(
				new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Pizza de Muzzarella").
					agregarIngrediente(prepizza).agregarIngrediente(salsaDeTomate).agregarIngrediente(oregano).
					agregarIngrediente(queso).setearTemporadas("Todo el año").setearDificultad("Facil").
					setearCalorias(500).setearPreparacion(
						"Cocinar la prepizza en el horno. Agregar el queso y volver a cocinar. Agregar oregano a gusto").
					setearNumeroId(4).build)
			add(
				new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("Pizza de Verdura y Salsa Blanca").
					agregarIngrediente(prepizza).agregarIngrediente(salsaDeTomate).agregarIngrediente(queso).
					agregarIngrediente(salsaBlanca).agregarIngrediente(verdura).setearTemporadas("Todo el año").
					setearCalorias(560).setearDificultad("Dificil").setearPreparacion(
						"Cocinar la prepizza en el horno. Agregar el queso y volver a cocinar. Agregar la salsa blanca y la verdura").
					setearNumeroId(5).build)
			add(
				new RecetaBuilder().tipoDeReceta(new Publica).nombreDelPlato("asd").agregarIngrediente(prepizza).
					agregarIngrediente(salsaDeTomate).agregarIngrediente(queso).agregarIngrediente(salsaBlanca).
					agregarIngrediente(verdura).setearTemporadas("Todo el año").setearCalorias(560).
					setearDificultad("Dificil").setearPreparacion(
						"Cocinar la prepizza en el horno. Agregar el queso y volver a cocinar. Agregar la salsa blanca y la verdura").
					setearNumeroId(6).build
			)]
	}

	def static void main(String[] args) {
		XTRest.start(ControlerAndroid, 9000)

	}

	@Get("/recetas")
	def Result Recetas() {

		if (cont < 1) {
			cont++
			this.init
		}

		ok(recetas.toJson)

	}

	@Post("/favorita/:favorita:numeroid")
	def Result hacerFavorita(@Body String body) {
		var ParceFavorita aux = body.fromJson(ParceFavorita)
		var detalleApp = this.getDetalleRecetaAppModel(aux.numeroId)

		detalleApp.setFavorita(aux.favorita) // ver esto por que no siempre es un true.

		response.contentType = ContentType.TEXT_PLAIN
		ok('{ "status" : "OK" }')

	}

	def getDetalleRecetaAppModel(long body) {
		var Busqueda busqueda = new Busqueda(usr)

		new DetalleDeRecetaAppModel(busqueda.buscarPorId(body), usr)
	}

}
