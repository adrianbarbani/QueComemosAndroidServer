package ar.algo.adriba.appModel;

import ar.algo.adriba.tp1.Comida;
import ar.algo.adriba.tp1.Publica;
import ar.algo.adriba.tp1.Receta;
import ar.algo.adriba.tp1.RecetaBuilder;

@SuppressWarnings("all")
public class SeteoRecetas {
  private Comida carne = new Comida(0, "carne", 1);
  
  private Comida harina = new Comida(0, "Harina", 20);
  
  private Comida huevo = new Comida(0, "Huevo", 3);
  
  private Comida aceite = new Comida(0, "Huevo", 3);
  
  private Comida panRallado = new Comida(0, "Pan Rallado", 50);
  
  private Comida verdura = new Comida(0, "Verdura", 12);
  
  private Comida queso = new Comida(0, "Muzzarella", 200);
  
  private Comida prepizza = new Comida(0, "Prepizza", 1);
  
  private Comida salsaDeTomate = new Comida(0, "Salsa de tomate", 200);
  
  private Comida sal = new Comida(18, "Sal", 0);
  
  private Comida salsaBlanca = new Comida(0, "Salsa Blanca", 400);
  
  private Comida lomo = new Comida(0, "Lomo", 200);
  
  private Comida garbanzos = new Comida(0, "Garbanzos", 500);
  
  private Comida limon = new Comida(10, "Limon", 0);
  
  private Comida ajo = new Comida(5, "Ajo", 0);
  
  private Comida jamon = new Comida(0, "Jamon", 100);
  
  private Comida oregano = new Comida(100, "Oregano", 0);
  
  private Comida azucar = new Comida(0, "azucar", 200);
  
  public Receta crearRecetas() {
    RecetaBuilder _recetaBuilder = new RecetaBuilder();
    Publica _publica = new Publica();
    RecetaBuilder _tipoDeReceta = _recetaBuilder.tipoDeReceta(_publica);
    RecetaBuilder _nombreDelPlato = _tipoDeReceta.nombreDelPlato("Milanesas");
    RecetaBuilder _agregarIngrediente = _nombreDelPlato.agregarIngrediente(this.harina);
    RecetaBuilder _agregarIngrediente_1 = _agregarIngrediente.agregarIngrediente(this.huevo);
    RecetaBuilder _agregarIngrediente_2 = _agregarIngrediente_1.agregarIngrediente(this.aceite);
    RecetaBuilder _setearTemporadas = _agregarIngrediente_2.setearTemporadas("Todo");
    RecetaBuilder _agregarIngrediente_3 = _setearTemporadas.agregarIngrediente(this.panRallado);
    RecetaBuilder _agregarIngrediente_4 = _agregarIngrediente_3.agregarIngrediente(this.carne);
    RecetaBuilder _agregarIngrediente_5 = _agregarIngrediente_4.agregarIngrediente(this.oregano);
    RecetaBuilder _setearCalorias = _agregarIngrediente_5.setearCalorias(150);
    RecetaBuilder _setearDificultad = _setearCalorias.setearDificultad("Dificil");
    RecetaBuilder _setearPreparacion = _setearDificultad.setearPreparacion("Pasar la carne por huevo, harina y pan rallado. Freir con el aceite por 10 minutos");
    RecetaBuilder _setearNumeroId = _setearPreparacion.setearNumeroId(1);
    return _setearNumeroId.build();
  }
  
  public final static SeteoRecetas INSTANCE = new SeteoRecetas();
}
