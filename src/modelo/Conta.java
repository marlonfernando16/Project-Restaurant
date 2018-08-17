package modelo;

import java.util.ArrayList;

public class Conta {

	private int numero;
	private String dtfechamento;
	private double total;
	private Mesa mesa;
    private ArrayList<Produto> produtos = new  ArrayList<>();
    
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getdtfechamento() {
		return dtfechamento;
	}
	public void setdtfechamento(String dtfechamento) {
		this.dtfechamento = dtfechamento;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", dtfechamento=" + dtfechamento + ", total=" + total + ", mesa=" + mesa
				+ ", produtos=" + produtos + "]";
	}
		
	

}
