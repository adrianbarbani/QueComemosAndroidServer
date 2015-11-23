package ar.algo.adriba.appModel;

import ar.algo.adriba.appModel.RecetaPack;
import ar.algo.adriba.tp1.Comida;
import ar.algo.adriba.tp1.Fecha;
import ar.algo.adriba.tp1.Publica;
import ar.algo.adriba.tp1.Receta;
import ar.algo.adriba.tp1.RecetaBuilder;
import ar.algo.adriba.tp1.Rutina;
import ar.algo.adriba.tp1.Sexo;
import ar.algo.adriba.tp1.Usuario;
import ar.algo.adriba.tp1.UsuarioBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoPackRecetas {
  private List<Receta> recetas = new ArrayList<Receta>();
  
  private List<RecetaPack> packDeRecetas = new ArrayList<RecetaPack>();
  
  private Usuario usuarioDefault;
  
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
  
  public void init() {
    final Procedure1<List<Receta>> _function = new Procedure1<List<Receta>>() {
      public void apply(final List<Receta> it) {
        RecetaBuilder _recetaBuilder = new RecetaBuilder();
        Publica _publica = new Publica();
        RecetaBuilder _tipoDeReceta = _recetaBuilder.tipoDeReceta(_publica);
        RecetaBuilder _nombreDelPlato = _tipoDeReceta.nombreDelPlato("Milanesas");
        RecetaBuilder _agregarIngrediente = _nombreDelPlato.agregarIngrediente(RepoPackRecetas.this.harina);
        RecetaBuilder _agregarIngrediente_1 = _agregarIngrediente.agregarIngrediente(RepoPackRecetas.this.huevo);
        RecetaBuilder _agregarIngrediente_2 = _agregarIngrediente_1.agregarIngrediente(RepoPackRecetas.this.aceite);
        RecetaBuilder _setearTemporadas = _agregarIngrediente_2.setearTemporadas("Todo el año");
        RecetaBuilder _agregarIngrediente_3 = _setearTemporadas.agregarIngrediente(RepoPackRecetas.this.panRallado);
        RecetaBuilder _agregarIngrediente_4 = _agregarIngrediente_3.agregarIngrediente(RepoPackRecetas.this.carne);
        RecetaBuilder _agregarIngrediente_5 = _agregarIngrediente_4.agregarIngrediente(RepoPackRecetas.this.oregano);
        RecetaBuilder _setearCalorias = _agregarIngrediente_5.setearCalorias(150);
        RecetaBuilder _setearDificultad = _setearCalorias.setearDificultad("Dificil");
        RecetaBuilder _setearPreparacion = _setearDificultad.setearPreparacion(
          "Pasar la carne por huevo, harina y pan rallado. Freir con el aceite por 10 minutos");
        RecetaBuilder _setearNumeroId = _setearPreparacion.setearNumeroId(1);
        Receta _build = _setearNumeroId.build();
        it.add(_build);
        RecetaBuilder _recetaBuilder_1 = new RecetaBuilder();
        Publica _publica_1 = new Publica();
        RecetaBuilder _tipoDeReceta_1 = _recetaBuilder_1.tipoDeReceta(_publica_1);
        RecetaBuilder _nombreDelPlato_1 = _tipoDeReceta_1.nombreDelPlato("Milanesa Napolitana");
        RecetaBuilder _agregarIngrediente_6 = _nombreDelPlato_1.agregarIngrediente(RepoPackRecetas.this.harina);
        RecetaBuilder _agregarIngrediente_7 = _agregarIngrediente_6.agregarIngrediente(RepoPackRecetas.this.huevo);
        RecetaBuilder _agregarIngrediente_8 = _agregarIngrediente_7.agregarIngrediente(RepoPackRecetas.this.panRallado);
        RecetaBuilder _agregarIngrediente_9 = _agregarIngrediente_8.agregarIngrediente(RepoPackRecetas.this.carne);
        RecetaBuilder _agregarIngrediente_10 = _agregarIngrediente_9.agregarIngrediente(RepoPackRecetas.this.queso);
        RecetaBuilder _agregarIngrediente_11 = _agregarIngrediente_10.agregarIngrediente(RepoPackRecetas.this.salsaDeTomate);
        RecetaBuilder _setearCalorias_1 = _agregarIngrediente_11.setearCalorias(8000);
        RecetaBuilder _setearTemporadas_1 = _setearCalorias_1.setearTemporadas("Todo el año");
        RecetaBuilder _setearDificultad_1 = _setearTemporadas_1.setearDificultad("Dificil");
        RecetaBuilder _setearPreparacion_1 = _setearDificultad_1.setearPreparacion(
          "Pasar la carne por huevo, harina y pan rallado. Freir con el aceite por 10 minutos. Luego colocarle la salsa de tomate, el queso y  calentar");
        RecetaBuilder _setearNumeroId_1 = _setearPreparacion_1.setearNumeroId(2);
        Receta _build_1 = _setearNumeroId_1.build();
        it.add(_build_1);
        RecetaBuilder _recetaBuilder_2 = new RecetaBuilder();
        Publica _publica_2 = new Publica();
        RecetaBuilder _tipoDeReceta_2 = _recetaBuilder_2.tipoDeReceta(_publica_2);
        RecetaBuilder _nombreDelPlato_2 = _tipoDeReceta_2.nombreDelPlato("Sopa de Verdura");
        RecetaBuilder _agregarIngrediente_12 = _nombreDelPlato_2.agregarIngrediente(RepoPackRecetas.this.verdura);
        RecetaBuilder _agregarIngrediente_13 = _agregarIngrediente_12.agregarIngrediente(RepoPackRecetas.this.sal);
        RecetaBuilder _setearCalorias_2 = _agregarIngrediente_13.setearCalorias(200);
        RecetaBuilder _setearTemporadas_2 = _setearCalorias_2.setearTemporadas("Invierno");
        RecetaBuilder _setearDificultad_2 = _setearTemporadas_2.setearDificultad("Dificil");
        RecetaBuilder _setearPreparacion_2 = _setearDificultad_2.setearPreparacion("");
        RecetaBuilder _setearNumeroId_2 = _setearPreparacion_2.setearNumeroId(3);
        Receta _build_2 = _setearNumeroId_2.build();
        it.add(_build_2);
        RecetaBuilder _recetaBuilder_3 = new RecetaBuilder();
        Publica _publica_3 = new Publica();
        RecetaBuilder _tipoDeReceta_3 = _recetaBuilder_3.tipoDeReceta(_publica_3);
        RecetaBuilder _nombreDelPlato_3 = _tipoDeReceta_3.nombreDelPlato("Pizza de Muzzarella");
        RecetaBuilder _agregarIngrediente_14 = _nombreDelPlato_3.agregarIngrediente(RepoPackRecetas.this.prepizza);
        RecetaBuilder _agregarIngrediente_15 = _agregarIngrediente_14.agregarIngrediente(RepoPackRecetas.this.salsaDeTomate);
        RecetaBuilder _agregarIngrediente_16 = _agregarIngrediente_15.agregarIngrediente(RepoPackRecetas.this.oregano);
        RecetaBuilder _agregarIngrediente_17 = _agregarIngrediente_16.agregarIngrediente(RepoPackRecetas.this.queso);
        RecetaBuilder _setearTemporadas_3 = _agregarIngrediente_17.setearTemporadas("Todo el año");
        RecetaBuilder _setearDificultad_3 = _setearTemporadas_3.setearDificultad("Facil");
        RecetaBuilder _setearCalorias_3 = _setearDificultad_3.setearCalorias(500);
        RecetaBuilder _setearPreparacion_3 = _setearCalorias_3.setearPreparacion(
          "Cocinar la prepizza en el horno. Agregar el queso y volver a cocinar. Agregar oregano a gusto");
        RecetaBuilder _setearNumeroId_3 = _setearPreparacion_3.setearNumeroId(4);
        Receta _build_3 = _setearNumeroId_3.build();
        it.add(_build_3);
        RecetaBuilder _recetaBuilder_4 = new RecetaBuilder();
        Publica _publica_4 = new Publica();
        RecetaBuilder _tipoDeReceta_4 = _recetaBuilder_4.tipoDeReceta(_publica_4);
        RecetaBuilder _nombreDelPlato_4 = _tipoDeReceta_4.nombreDelPlato("Pizza de Verdura y Salsa Blanca");
        RecetaBuilder _agregarIngrediente_18 = _nombreDelPlato_4.agregarIngrediente(RepoPackRecetas.this.prepizza);
        RecetaBuilder _agregarIngrediente_19 = _agregarIngrediente_18.agregarIngrediente(RepoPackRecetas.this.salsaDeTomate);
        RecetaBuilder _agregarIngrediente_20 = _agregarIngrediente_19.agregarIngrediente(RepoPackRecetas.this.queso);
        RecetaBuilder _agregarIngrediente_21 = _agregarIngrediente_20.agregarIngrediente(RepoPackRecetas.this.salsaBlanca);
        RecetaBuilder _agregarIngrediente_22 = _agregarIngrediente_21.agregarIngrediente(RepoPackRecetas.this.verdura);
        RecetaBuilder _setearTemporadas_4 = _agregarIngrediente_22.setearTemporadas("Todo el año");
        RecetaBuilder _setearCalorias_4 = _setearTemporadas_4.setearCalorias(560);
        RecetaBuilder _setearDificultad_4 = _setearCalorias_4.setearDificultad("Dificil");
        RecetaBuilder _setearPreparacion_4 = _setearDificultad_4.setearPreparacion(
          "Cocinar la prepizza en el horno. Agregar el queso y volver a cocinar. Agregar la salsa blanca y la verdura");
        RecetaBuilder _setearNumeroId_4 = _setearPreparacion_4.setearNumeroId(5);
        Receta _build_4 = _setearNumeroId_4.build();
        it.add(_build_4);
        RecetaBuilder _recetaBuilder_5 = new RecetaBuilder();
        Publica _publica_5 = new Publica();
        RecetaBuilder _tipoDeReceta_5 = _recetaBuilder_5.tipoDeReceta(_publica_5);
        RecetaBuilder _nombreDelPlato_5 = _tipoDeReceta_5.nombreDelPlato("asd");
        RecetaBuilder _agregarIngrediente_23 = _nombreDelPlato_5.agregarIngrediente(RepoPackRecetas.this.prepizza);
        RecetaBuilder _agregarIngrediente_24 = _agregarIngrediente_23.agregarIngrediente(RepoPackRecetas.this.salsaDeTomate);
        RecetaBuilder _agregarIngrediente_25 = _agregarIngrediente_24.agregarIngrediente(RepoPackRecetas.this.queso);
        RecetaBuilder _agregarIngrediente_26 = _agregarIngrediente_25.agregarIngrediente(RepoPackRecetas.this.salsaBlanca);
        RecetaBuilder _agregarIngrediente_27 = _agregarIngrediente_26.agregarIngrediente(RepoPackRecetas.this.verdura);
        RecetaBuilder _setearTemporadas_5 = _agregarIngrediente_27.setearTemporadas("Todo el año");
        RecetaBuilder _setearCalorias_5 = _setearTemporadas_5.setearCalorias(560);
        RecetaBuilder _setearDificultad_5 = _setearCalorias_5.setearDificultad("Dificil");
        RecetaBuilder _setearPreparacion_5 = _setearDificultad_5.setearPreparacion(
          "Cocinar la prepizza en el horno. Agregar el queso y volver a cocinar. Agregar la salsa blanca y la verdura");
        RecetaBuilder _setearNumeroId_5 = _setearPreparacion_5.setearNumeroId(6);
        Receta _build_5 = _setearNumeroId_5.build();
        it.add(_build_5);
      }
    };
    ObjectExtensions.<List<Receta>>operator_doubleArrow(
      this.recetas, _function);
  }
  
  private Fecha fechaValida = new Fecha((System.currentTimeMillis() - (((24 * 60) * 60) * 1000)));
  
  public Usuario crearUsuarioDefault() {
    UsuarioBuilder _usuarioBuilder = new UsuarioBuilder();
    UsuarioBuilder _agregarPeso = _usuarioBuilder.agregarPeso(52);
    UsuarioBuilder _agregarAltura = _agregarPeso.agregarAltura(1.64);
    UsuarioBuilder _agregarSexo = _agregarAltura.agregarSexo(Sexo.FEMENINO);
    UsuarioBuilder _agregarNombre = _agregarSexo.agregarNombre("Esteban");
    UsuarioBuilder _agregarFechaNacimiento = _agregarNombre.agregarFechaNacimiento(this.fechaValida);
    Rutina _rutina = new Rutina(61, true);
    UsuarioBuilder _agregarRutina = _agregarFechaNacimiento.agregarRutina(_rutina);
    Usuario _build = _agregarRutina.build("1234");
    return this.usuarioDefault = _build;
  }
  
  public void crearPack() {
    final Consumer<Receta> _function = new Consumer<Receta>() {
      public void accept(final Receta receta) {
        RecetaPack _recetaPack = new RecetaPack(receta, RepoPackRecetas.this.usuarioDefault);
        RepoPackRecetas.this.packDeRecetas.add(_recetaPack);
      }
    };
    this.recetas.forEach(_function);
  }
  
  public void iniciar() {
    this.init();
    this.crearUsuarioDefault();
    this.crearPack();
  }
  
  @Pure
  public List<Receta> getRecetas() {
    return this.recetas;
  }
  
  public void setRecetas(final List<Receta> recetas) {
    this.recetas = recetas;
  }
  
  @Pure
  public List<RecetaPack> getPackDeRecetas() {
    return this.packDeRecetas;
  }
  
  public void setPackDeRecetas(final List<RecetaPack> packDeRecetas) {
    this.packDeRecetas = packDeRecetas;
  }
  
  @Pure
  public Usuario getUsuarioDefault() {
    return this.usuarioDefault;
  }
  
  public void setUsuarioDefault(final Usuario usuarioDefault) {
    this.usuarioDefault = usuarioDefault;
  }
  
  @Pure
  public Comida getCarne() {
    return this.carne;
  }
  
  public void setCarne(final Comida carne) {
    this.carne = carne;
  }
  
  @Pure
  public Comida getHarina() {
    return this.harina;
  }
  
  public void setHarina(final Comida harina) {
    this.harina = harina;
  }
  
  @Pure
  public Comida getHuevo() {
    return this.huevo;
  }
  
  public void setHuevo(final Comida huevo) {
    this.huevo = huevo;
  }
  
  @Pure
  public Comida getAceite() {
    return this.aceite;
  }
  
  public void setAceite(final Comida aceite) {
    this.aceite = aceite;
  }
  
  @Pure
  public Comida getPanRallado() {
    return this.panRallado;
  }
  
  public void setPanRallado(final Comida panRallado) {
    this.panRallado = panRallado;
  }
  
  @Pure
  public Comida getVerdura() {
    return this.verdura;
  }
  
  public void setVerdura(final Comida verdura) {
    this.verdura = verdura;
  }
  
  @Pure
  public Comida getQueso() {
    return this.queso;
  }
  
  public void setQueso(final Comida queso) {
    this.queso = queso;
  }
  
  @Pure
  public Comida getPrepizza() {
    return this.prepizza;
  }
  
  public void setPrepizza(final Comida prepizza) {
    this.prepizza = prepizza;
  }
  
  @Pure
  public Comida getSalsaDeTomate() {
    return this.salsaDeTomate;
  }
  
  public void setSalsaDeTomate(final Comida salsaDeTomate) {
    this.salsaDeTomate = salsaDeTomate;
  }
  
  @Pure
  public Comida getSal() {
    return this.sal;
  }
  
  public void setSal(final Comida sal) {
    this.sal = sal;
  }
  
  @Pure
  public Comida getSalsaBlanca() {
    return this.salsaBlanca;
  }
  
  public void setSalsaBlanca(final Comida salsaBlanca) {
    this.salsaBlanca = salsaBlanca;
  }
  
  @Pure
  public Comida getLomo() {
    return this.lomo;
  }
  
  public void setLomo(final Comida lomo) {
    this.lomo = lomo;
  }
  
  @Pure
  public Comida getGarbanzos() {
    return this.garbanzos;
  }
  
  public void setGarbanzos(final Comida garbanzos) {
    this.garbanzos = garbanzos;
  }
  
  @Pure
  public Comida getLimon() {
    return this.limon;
  }
  
  public void setLimon(final Comida limon) {
    this.limon = limon;
  }
  
  @Pure
  public Comida getAjo() {
    return this.ajo;
  }
  
  public void setAjo(final Comida ajo) {
    this.ajo = ajo;
  }
  
  @Pure
  public Comida getJamon() {
    return this.jamon;
  }
  
  public void setJamon(final Comida jamon) {
    this.jamon = jamon;
  }
  
  @Pure
  public Comida getOregano() {
    return this.oregano;
  }
  
  public void setOregano(final Comida oregano) {
    this.oregano = oregano;
  }
  
  @Pure
  public Comida getAzucar() {
    return this.azucar;
  }
  
  public void setAzucar(final Comida azucar) {
    this.azucar = azucar;
  }
  
  @Pure
  public Fecha getFechaValida() {
    return this.fechaValida;
  }
  
  public void setFechaValida(final Fecha fechaValida) {
    this.fechaValida = fechaValida;
  }
}
