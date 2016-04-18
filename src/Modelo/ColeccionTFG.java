package Modelo;
import java.util.LinkedList;
import java.util.List;

public class ColeccionTFG {
	private List<TFG> trabajos;
	
	public ColeccionTFG(){
		trabajos = new LinkedList<>();
	}
	
	public void anyadirTrabajo(TFG trabajo){
		trabajos.add(trabajo);
	}
	
	public void anyadirTrabajos(List<TFG> trabajos){
		this.trabajos.addAll(trabajos);
	}
	
	public void eliminarTrabajo(int indice){
		trabajos.remove(indice);
	}
	
	public void eliminarTrabajo(String titulo){
		for(int i = 0; i < trabajos.size(); i++){
			if(trabajos.get(i).getTitulo().equals(titulo)){
				trabajos.remove(i);
				break;
			}
		}
	}
	
	public List<TFG> getTrabajosLibres(){
		List<TFG> libres = new LinkedList<>();
		for(TFG trabajo : trabajos){
			if(trabajo.estaDisponible()){
				libres.add(trabajo);
			}
		}
		return libres;
	}

	public List<TFG> getTrabajos(){
		return trabajos;
	}
	
	public TFG getTrabajo(int indice){
		return trabajos.get(indice);
	}
}
