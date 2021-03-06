package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada;
import modelo.Conta;
import modelo.Garcom;
import modelo.Mesa;
import modelo.Produto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal {

	private JFrame frmPrincipal;
	private JMenu menuProduto;
	private JMenuItem itemCadastrarP;
	private JMenuItem itemListarP;
	private JMenu menuGarcom;
	private JMenuItem itemCadastrarG;
	private JMenuItem itemListarG;
	private JMenuItem itemCalcularGorjeta;
	private JMenu menuMesa;
	private JMenuItem itemListarM;
	private JMenuItem itemSolicitarProd;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("Los Pollos Hermanos - Marlon Five");
		try {
			frmPrincipal.setContentPane(new FundoTela("img1.jpg"));
		} catch (IOException e1) {
		}	

		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  pre-cadastro
					Fachada.criarMesas(30);	
					Produto p;
					p = Fachada.cadastrarProduto("arroz", 210.0);
					p = Fachada.cadastrarProduto("feijao", 15.0);
					p = Fachada.cadastrarProduto("macarrao", 31.0);
					p = Fachada.cadastrarProduto("batata", 120.0);
					p = Fachada.cadastrarProduto("estrogonofe", 18.0);
					p = Fachada.cadastrarProduto("picanha", 45.0);
					p = Fachada.cadastrarProduto("salada", 21.0);
					p = Fachada.cadastrarProduto("agua com gas", 17.0);
					p = Fachada.cadastrarProduto("Suco", 10.0);
					p = Fachada.cadastrarProduto("�gua", 3.0);
					p = Fachada.cadastrarProduto("Refrigerante", 5.0);
					p = Fachada.cadastrarProduto("Cerveja", 10.0);
					Garcom g;
					g = Fachada.cadastrarGarcom("Marlon five", 1, 5);
					g = Fachada.cadastrarGarcom("marlon e eu", 6, 10);
					g = Fachada.cadastrarGarcom("guerreirinho", 11, 15);
					g = Fachada.cadastrarGarcom("menino nei", 16, 20);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "adi�s hasta luego!!");
			}
		});

		frmPrincipal.setBounds(100, 100, 450, 320);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);

		menuProduto = new JMenu("   Produto   ");
		menuBar.add(menuProduto);

		itemCadastrarP = new JMenuItem("Cadastrar");
		itemCadastrarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarProduto t = new TelaCadastrarProduto();
				t.setVisible(true);
			}
		});
		menuProduto.add(itemCadastrarP);

		itemListarP = new JMenuItem("Listar");
		itemListarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarProduto t = new TelaListarProduto();
				t.setVisible(true);
			}
		});
		menuProduto.add(itemListarP);
		
 
		menuMesa = new JMenu("       Mesa       ");
		menuBar.add(menuMesa);

		itemListarM = new JMenuItem("Listar");
		itemListarM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarMesas t = new TelaListarMesas();
				t.setVisible(true);
			}
		});
		menuMesa.add(itemListarM);
		
		itemSolicitarProd = new JMenuItem("Sol. Produto");
		itemSolicitarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaSolicitarProduto t = new TelaSolicitarProduto();
				t.setVisible(true);
			}
		});
		menuMesa.add(itemSolicitarProd);

		
		menuGarcom = new JMenu("   Gar�om   ");
		menuBar.add(menuGarcom);

		itemCadastrarG = new JMenuItem("Cadastrar");
		itemCadastrarG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarGarcom t = new TelaCadastrarGarcom();
				t.setVisible(true);
			}
		});
		menuGarcom.add(itemCadastrarG);

		itemListarG = new JMenuItem("Listar");
		itemListarG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarGarcons t = new TelaListarGarcons();
				t.setVisible(true);
			}
		});
		menuGarcom.add(itemListarG);
		
		
		itemCalcularGorjeta = new JMenuItem("Gorjeta");
		itemCalcularGorjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCalculaGorjeta t = new TelaCalculaGorjeta();
				t.setVisible(true);
			}
		});
		menuGarcom.add(itemCalcularGorjeta);
		
		
		JMenu mnConta = new JMenu("     Conta     ");
		menuBar.add(mnConta); 

		JMenuItem mntmCriar = new JMenuItem("Criar");
		mntmCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAbrirConta t = new TelaAbrirConta();
				t.setVisible(true);
			}
		});
		mnConta.add(mntmCriar);

		JMenuItem mntmListarConta = new JMenuItem("Listar");
		mntmListarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarContas t = new TelaListarContas();
				t.setVisible(true);
			}
		});
		mnConta.add(mntmListarConta);

		JMenuItem mntmConsultarConta = new JMenuItem("Consultar");
		mntmConsultarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultarConta t = new TelaConsultarConta();
				t.setVisible(true);
			}
		});
		mnConta.add(mntmConsultarConta);
		
		JMenuItem mntmCancelarConta = new JMenuItem("Cancelar");
		mntmCancelarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCancelarConta t = new TelaCancelarConta();
				t.setVisible(true);
			}
		});
		mnConta.add(mntmCancelarConta);
		
		JMenuItem mntmTransferirConta = new JMenuItem("Transferir");
		mntmTransferirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaTransferirConta t = new TelaTransferirConta();
				t.setVisible(true);
			}
		});
		mnConta.add(mntmTransferirConta);
		
		JMenuItem mntmFecharConta = new JMenuItem("Fechar");
		mntmFecharConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFecharConta t = new TelaFecharConta();
				t.setVisible(true);
			}
		});
		mnConta.add(mntmFecharConta);
	
	}
}