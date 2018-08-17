/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 @autor: Marlon Fernando
 **********************************/

package fachada;
import modelo.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modelo.*;
import repositorio.Restaurante;
public class Fachada {
	private static Restaurante res = new Restaurante();
	
	private static int numconta = 0;

	public  static  ArrayList<Produto>  listarProdutos(String nome){
		ArrayList<Produto> lista = new ArrayList<Produto>();
		for(Produto p: res.getProdutos()) {
			if(p.getNome().contains(nome)) {
				lista.add(p);
			}
		}
		if(nome.equals("")) {
			return res.getProdutos();
		}
		else
			return lista;
	}

	public static ArrayList<Garcom> listarGarcons(){    
		return res.getGarcons();
	}
	
	public  static  ArrayList<Mesa>  listarMesas(){		
		return res.getMesas();
	}

	public  static  ArrayList<Conta>  listarContas(){
		return res.getContas();

	}

	static Garcom ListarGarcomByApelido(String apelido) {
		for(Garcom g: res.getGarcons()) {
			if(g.getApelido().equals(apelido)) {
				return g;
			}
		}
		
		return null;
	}
	
	public static void criarMesas(int n) {
		ArrayList<Mesa> lista = new	ArrayList<>();
		for(int i=1;i<=n;i++) {
			Mesa mesa  = new Mesa();
			mesa.setId(i);
			lista.add(mesa);
		}

		res.getMesas().addAll(lista);
	}

	public static Produto cadastrarProduto(String nome,double preco) throws Exception{
		Produto  p  = res.localizarProduto(nome);
		if(p!=null) 
			throw  new  Exception("produto  ja  cadastrado");

		p = new Produto(nome,preco);
		res.adicionarProduto(p);

		return p;
	}

	public static Garcom cadastrarGarcom(String nome, int mesainicial,int  mesafinal) throws Exception {	
		Garcom g = new Garcom();
		
		for(int i = mesainicial; i<= mesafinal; i++) {
			Mesa m = res.localizarMesaById(i); 
			if(m != null && 1 + mesafinal - mesainicial == 5){
				g.adicionarMesa(m);
				res.getMesas().get(i-1).setGarcom(g);

			} else
				throw  new  Exception("Intervalo incorreto ou inexistente");
		}
		
		 for(Garcom ga: res.getGarcons()) {
			for(Mesa m: ga.getMesas()) {
				if(m.getId()== mesainicial || m.getId() == mesafinal) 
					throw  new  Exception("Nao pode cadastrar essa mesa para o garcom" + nome);
				
			} 
		}
			

		res.adicionarGarcom(g);
		g.setApelido(nome);					 

		return g;
	}

	public static Conta criarConta(int idmesa) throws Exception{
		Mesa m = res.localizarMesaById(idmesa);
		 
		if( m.isOcupado())
				throw  new  Exception("Ultima conta ainda esta em aberto!");
			if(idmesa == m.getId()) {
				Conta conta = new Conta();
				conta.setNumero(++numconta);
				m.adicionarConta(conta);
				conta.getMesa().setOcupado(true);
				res.adicionarConta(conta);
				return conta;

			
		} throw  new  Exception("id inexistente");

	}

	public static Conta consultarConta(int idmesa) throws Exception{
		Mesa m = res.localizarMesaById(idmesa);
		if(m == null) 
			throw  new  Exception("mesa inexistente");
		Conta conta = m.getContas().get(m.getContas().size()-1);
		if(conta == null) 
			throw  new  Exception("conta inexistente");
		return conta;
	}

	public static Produto solicitarProduto(int idmesa,String nomeproduto) throws Exception {
		
		Produto  p  = res.localizarProduto(nomeproduto);
		Mesa m = res.localizarMesaById(idmesa); 
		if(p==null)  
			throw  new  Exception("produto  nao cadastrado");
		if(m==null)  
			throw  new  Exception("mesa inexistente");
		Conta c = Fachada.consultarConta(idmesa);
		if(c == null) 
			throw  new  Exception("nao ha conta para esta mesa");
		if(c.getdtfechamento() != null)
			throw  new  Exception("produto nao pode ser cadastrado! Conta fechada!");
		
		if(c.getMesa() == null)
			throw  new  Exception("Não há conta criada para esta mesa!");
		c.getProdutos().add(p);
		return p; 
	}

	public static void cancelarConta(int idmesa) throws Exception {
		Mesa mesa = res.localizarMesaById(idmesa); 
		
		if(mesa == null)
			throw  new  Exception("mesa inexistente");
		
		if(mesa.isOcupado()) {
			
			Conta c = mesa.getContas().get(mesa.getContas().size()-1);
			
			res.getContas().remove(c);
			mesa.getContas().remove(c);
			mesa.setOcupado(false);
		} else {
			throw  new  Exception("mesa nao esta ocupada!");
		}
			
	}

	public static void fecharConta(int idmesa) throws Exception {
		
		Mesa mesa = res.localizarMesaById(idmesa); 
		if(mesa == null)
			throw  new  Exception("conta inexistente");
		else {
			mesa.setOcupado(false);	
			Conta c = mesa.getContas().get(mesa.getContas().size()-1);
			Date data = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			c.setdtfechamento(sdf.format(data));
			for(Produto p: c.getProdutos()) {
				c.setTotal(c.getTotal() + p.getPreco());  
			}					
		}
	}
	
	public  static  void  transferirConta(int idmesaorigem,int idmesadestino) throws Exception{

		Mesa mesainicio = res.localizarMesaById(idmesaorigem); 
		if(mesainicio == null)
			throw  new  Exception("conta de origem, inexistente");
		

		Mesa mesafim = res.localizarMesaById(idmesadestino); 
		if(mesafim == null)
			throw  new  Exception("conta de destino, inexistente");
		
		if(mesainicio.getContas() == null)
			throw  new  Exception("nao existe conta na mesa de origem");
		
		Conta cInicio = mesainicio.getContas().get(mesainicio.getContas().size()-1);
		if(cInicio.getdtfechamento()!=null)
			throw  new  Exception("conta de origem fechada");
		
		Conta cFim = mesafim.getContas().get(mesafim.getContas().size()-1);
		if(cFim.getdtfechamento()!=null)
			throw  new  Exception("conta de destino fechada");
		
		cFim.getProdutos().addAll(cInicio.getProdutos());
		
		Fachada.cancelarConta(mesainicio.getId());
	}
	
	public  static  double  calcularGorjeta(String apelido) throws Exception{
		double count = 0;
		Garcom g = ListarGarcomByApelido(apelido);
		if(g  == null)
			throw  new  Exception("Garcom nao cadastrado no Restaurante");
		else{
			
			for(int i = 0; i< g.getMesas().size();i++) {
				for(int j =0; j < g.getMesas().get(i).getContas().size();j++) {
					if(g.getMesas().get(i).getContas().get(j).getdtfechamento()!= null) {
						count += g.getMesas().get(i).getContas().get(j).getTotal() * 0.1;
					}
				}
			}
		}
		

		return count;
	}
	
}
