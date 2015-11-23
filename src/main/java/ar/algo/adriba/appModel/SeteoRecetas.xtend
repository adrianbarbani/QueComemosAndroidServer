package ar.algo.adriba.appModel

import ar.algo.adriba.tp1.Comida
import ar.algo.adriba.tp1.Publica
import ar.algo.adriba.tp1.RecetaBuilder

class SeteoRecetas {
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
	
	def crearRecetas() {
		
	new RecetaBuilder()
			.tipoDeReceta(new Publica)
			.nombreDelPlato("Milanesas")
			.agregarIngrediente(harina)
			.agregarIngrediente(huevo)
			.agregarIngrediente(aceite)
			.setearTemporadas("Todo")
			.agregarIngrediente(panRallado)
			.agregarIngrediente(carne)
			.agregarIngrediente(oregano)
			.setearCalorias(150)
			.setearDificultad("Dificil")
			.setearPreparacion("Pasar la carne por huevo, harina y pan rallado. Freir con el aceite por 10 minutos")
			.setearNumeroId(1)
			.build
		

	}
	
	
	//------------------------------------------------
	

	public static val INSTANCE = new SeteoRecetas}