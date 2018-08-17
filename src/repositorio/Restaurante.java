package repositorio;
import java.util.ArrayList;
import modelo.*;

public class Restaurante {

	private static ArrayList<Produto> produtos = new ArrayList<>();
	private static ArrayList<Mesa> mesas = new  ArrayList<>();
	private static ArrayList<Conta> contas = new  ArrayList<>();
	private static ArrayList<Garcom> garcons = new  ArrayList<>();
	
	public static  ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public static void setProdutos(ArrayList<Produto> produtos) {
		Restaurante.produtos = produtos;
	}
	public static ArrayList<Mesa> getMesas() {
		return mesas;
	}
	public static void setMesas(ArrayList<Mesa> mesas) {
		Restaurante.mesas = mesas;
	}
	
	
	
	public static ArrayList<Conta> getContas() {
		return contas;
	}
	public static void setContas(ArrayList<Conta> contas) {
		Restaurante.contas = contas;
	}
	
	public static void adicionarConta(Conta c) {
		contas.add(c);
	}
	public static ArrayList<Garcom> getGarcons() {
		return garcons;
	}
	public static void setGarcons(ArrayList<Garcom> garcons) {
		Restaurante.garcons = garcons;
	}
	
	public static void adicionarProduto(Produto p) {
		produtos.add(p);
	}
	
	public static Produto localizarProduto(String nome) {
		for(Produto p : Restaurante.produtos) {
			if(p.getNome().equalsIgnoreCase(nome)){
				return p;
			}

		}
		
		return null;
	}
	
	public void removerProduto(Produto p) throws Exception {
		   if(!produtos.remove(p)){
			 throw new Exception("Falha na remoção");
		}
	
}
	public static void adicionarGarcom(Garcom g) {
		garcons.add(g);
	}
	
	
	
	public static Garcom localizarGarcom(String apelido) {
		for(Garcom g : Restaurante.garcons) {
			if(g.getApelido().equals(apelido)){
				return g;
			}

		}
		
		return null;
	}
	
	
	public static Mesa localizarMesaById(int id) {
		for(Mesa m: mesas) {
			if(m.getId() == id) {
				return m;
			}
		}
		
		return null;
	}
			
}