package ar.algo.adriba.appModel;

import ar.algo.adriba.tp1.CondicionPreexistente;
import ar.algo.adriba.tp1.Cosas;
import ar.algo.adriba.tp1.Receta;
import ar.algo.adriba.tp1.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors
@SuppressWarnings("all")
public class RecetaPack {
  private boolean editable = false;
  
  private Receta receta;
  
  private Usuario usuario;
  
  public RecetaPack(final Receta receta, final Usuario usuario) {
    this.receta = receta;
    this.usuario = usuario;
  }
  
  @JsonProperty("isFavorita")
  public boolean isFavorita() {
    return false;
  }
  
  @JsonProperty("condimentos")
  public List<String> condimentos() {
    List<Cosas> _subRecetaseIngredientes = this.receta.getSubRecetaseIngredientes();
    final Function1<Cosas, Boolean> _function = new Function1<Cosas, Boolean>() {
      public Boolean apply(final Cosas cosa) {
        return Boolean.valueOf(cosa.unCondimento());
      }
    };
    Iterable<Cosas> _filter = IterableExtensions.<Cosas>filter(_subRecetaseIngredientes, _function);
    final Function1<Cosas, String> _function_1 = new Function1<Cosas, String>() {
      public String apply(final Cosas it) {
        return it.nombre();
      }
    };
    Iterable<String> _map = IterableExtensions.<Cosas, String>map(_filter, _function_1);
    return IterableExtensions.<String>toList(_map);
  }
  
  @JsonProperty("ingredientes")
  public List<Cosas> ingredientes() {
    List<Cosas> _subRecetaseIngredientes = this.receta.getSubRecetaseIngredientes();
    final Function1<Cosas, Boolean> _function = new Function1<Cosas, Boolean>() {
      public Boolean apply(final Cosas cosa) {
        return Boolean.valueOf(cosa.unIngrediente());
      }
    };
    Iterable<Cosas> _filter = IterableExtensions.<Cosas>filter(_subRecetaseIngredientes, _function);
    return IterableExtensions.<Cosas>toList(_filter);
  }
  
  @JsonProperty("condiciones")
  public List<String> condiciones() {
    List<CondicionPreexistente> _paraQueCondicionesSoyInadecuada = this.receta.getParaQueCondicionesSoyInadecuada();
    final Function1<CondicionPreexistente, String> _function = new Function1<CondicionPreexistente, String>() {
      public String apply(final CondicionPreexistente condicion) {
        return condicion.getNombre();
      }
    };
    List<String> _map = ListExtensions.<CondicionPreexistente, String>map(_paraQueCondicionesSoyInadecuada, _function);
    return IterableExtensions.<String>toList(_map);
  }
  
  public String getEsDelUsuario() {
    String _xifexpression = null;
    boolean _usuarioTiene = this.usuario.usuarioTiene(this.receta);
    if (_usuarioTiene) {
      _xifexpression = "vos";
    } else {
      _xifexpression = "otro";
    }
    return _xifexpression;
  }
  
  @JsonProperty("caloriasYAutor")
  public String calorias() {
    int _caloriasReceta = this.receta.getCaloriasReceta();
    return (Integer.valueOf(_caloriasReceta) + " Calorias");
  }
  
  @JsonProperty("origen")
  public String origen() {
    String _xifexpression = null;
    boolean _usuarioTiene = this.usuario.usuarioTiene(this.receta);
    if (_usuarioTiene) {
      _xifexpression = "usuario";
    } else {
      _xifexpression = "publica";
    }
    return _xifexpression;
  }
  
  @Pure
  public boolean isEditable() {
    return this.editable;
  }
  
  public void setEditable(final boolean editable) {
    this.editable = editable;
  }
  
  @Pure
  public Receta getReceta() {
    return this.receta;
  }
  
  public void setReceta(final Receta receta) {
    this.receta = receta;
  }
  
  @Pure
  public Usuario getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }
}
