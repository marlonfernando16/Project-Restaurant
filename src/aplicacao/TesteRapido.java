package aplicacao;
import java.util.ArrayList;

import fachada.Fachada;
import modelo.Produto;
import repositorio.Restaurante;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Conta;
public class TesteRapido {

	 public static void main (String[] args) {  
	        parte1();
	        parte2();
	        parte3();
	        System.out.println("fim do teste");
	        
	    }
	 
	    public static void parte1(){
	        try {   
	            Produto p;
	            p = Fachada.cadastrarProduto("feijoada", 25.0);
	            p = Fachada.cadastrarProduto("bode guisado", 20.0);
	            p = Fachada.cadastrarProduto("galhinhada", 15.0);
	            p = Fachada.cadastrarProduto("cerveja", 6.0);
	            p = Fachada.cadastrarProduto("refrigerante", 5.0);
	            p = Fachada.cadastrarProduto("agua", 2.0);
	            ArrayList<Produto> produtos = Fachada.listarProdutos("");
	            System.out.println("produtos cadastrados:");
	            System.out.println(produtos);
	 
	            Fachada.criarMesas(20);     // 20 mesas
	            ArrayList<Mesa> mesas = Fachada.listarMesas();
	            System.out.println("mesas criadas:");
	            System.out.println(mesas);
	            Garcom g;
	            g = Fachada.cadastrarGarcom("baixinho", 1,5);
	            g = Fachada.cadastrarGarcom("esperto", 6,10);
	            g = Fachada.cadastrarGarcom("zezinho", 11,15);
	            g = Fachada.cadastrarGarcom("zezinho", 16,20);
	            ArrayList<Garcom> garcons = Fachada.listarGarcons();
	            System.out.println("garcons cadastrados:");
	            System.out.println(garcons);
	            System.out.println(Fachada.criarConta(1));
	            System.out.println(Fachada.criarConta(2));
	            Fachada.solicitarProduto(1, "galhinhada");
	            Fachada.solicitarProduto(1, "cerveja");
	            System.out.println(Fachada.listarContas());
	            Fachada.fecharConta(1);
	            System.out.println(Fachada.listarContas());
	            double gorjeta = Fachada.calcularGorjeta("baixinho");
	            System.out.println("gorjeta do baixinho="+gorjeta); 
	            
	        }catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	 
	 
	    public static void parte2() {
	        try {
	            Fachada.criarConta(1);  //mesa 1
	            Fachada.solicitarProduto(1, "galinhada");
	            Fachada.solicitarProduto(1, "cerveja");
	            Fachada.solicitarProduto(1, "refrigerante");
	            System.out.println("conta da mesa 1: \n"+ Fachada.consultarConta(1)); 
	            Fachada.solicitarProduto(1, "cerveja");
	            Fachada.solicitarProduto(1, "cerveja");
	            Fachada.fecharConta(1);
	            System.out.println("conta da mesa 1: \n"+ Fachada.consultarConta(1)); 
	 
	 
	            Fachada.criarConta(5);  //mesa 5
	            Fachada.solicitarProduto(5, "feijoada");
	            Fachada.solicitarProduto(5, "cerveja");
	            Fachada.fecharConta(5);
	            System.out.println("conta da mesa 5: \n"+ Fachada.consultarConta(5)); 
	 
	            

	            double gorjeta = Fachada.calcularGorjeta("baixinho");
	            System.out.println("gorjeta do baixinho="+gorjeta);
	 
	            ArrayList<Conta> contas = Fachada.listarContas();
	            System.out.println("contas existentes:");
	            System.out.println(contas);
	             
	        }catch (Exception e) {
	            System.out.println(e.getMessage());
	       }
	  
	    }
	     
	   
	 
	    
	    public static void parte3() {
	    	try {
	    		Fachada.criarConta(10);
		    	Fachada.solicitarProduto(10, "galhinhada");
		    	Fachada.solicitarProduto(10, "refrigerante");
		    	Fachada.fecharConta(10);
		    	//Fachada.solicitarProduto(10, "cerveja");// falta um exception pra nao permitir solicitar produto em conta fechada
		    	Fachada.criarConta(10);
		    	Fachada.solicitarProduto(10, "cerveja");
		    	Fachada.solicitarProduto(10, "cerveja");
		    	System.out.println(Fachada.listarContas());
		    	System.out.println("conta da mesa 10: \n"+ Fachada.consultarConta(10)); 
		    	System.out.println(Fachada.listarMesas());
		    	
	    	}catch(Exception e) {
	    		System.out.println(e.getMessage());
	    	}
	    	
	    }
	 
	}