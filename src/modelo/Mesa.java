package modelo;

import java.util.ArrayList;

public class Mesa {

	
	private  int id;
	private boolean ocupado;
	private ArrayList<Conta> contas = new ArrayList<>();
	private Garcom garcom;
	
	public Mesa() {
		super();
		
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

	public Garcom getGarcom() {
		return garcom;
	}

	public void setGarcom(Garcom garcom) {
		this.garcom = garcom;
	}
	
	public void adicionarConta(Conta c) {
		 contas.add(c);
		 c.setMesa(this); // Bidirecional
	} 
   
	
	@Override
	public String toString() {
		return "Mesa [id=" + id + ", ocupado=" + ocupado  + "]";
	}
	
	

	


















}
