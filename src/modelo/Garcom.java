package modelo;

import java.util.ArrayList;

public class Garcom {

	private String apelido;
	private ArrayList<Mesa> mesas = new ArrayList<>(5);
	
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public ArrayList<Mesa> getMesas() {
		return mesas;
	}
	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}
	
	public void adicionarMesa(Mesa mesa) {
		 mesas.add(mesa);
		 mesa.setGarcom(this); // Bidirecional
	}
	@Override
	public String toString() {
		ArrayList<Integer> idMesas = new ArrayList<>();
		for(Mesa m: mesas) {
			idMesas.add(m.getId());
		}
		return "Garcom [apelido=" + apelido + ", idMesas=" + idMesas + "]";
	}
	
	
}
