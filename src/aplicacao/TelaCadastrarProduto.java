package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Produto;

public class TelaCadastrarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField tf_nome;
	private JTextField tf_nome_1;
	private JLabel lb_nome;
	private JLabel lb_preco;
	private JButton btnCriar;
	private JLabel lb_msg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarProduto frame = new TelaCadastrarProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastrarProduto() {
		setTitle("Cadastrar Produto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf_nome = new JTextField();
		tf_nome.setBounds(72, 11, 86, 20);
		contentPane.add(tf_nome);
		tf_nome.setColumns(10);

		lb_nome = new JLabel("Nome");
		lb_nome.setBounds(10, 14, 46, 14);
		contentPane.add(lb_nome);

		lb_preco = new JLabel("Preco");
		lb_preco.setBounds(10, 52, 46, 14);
		contentPane.add(lb_preco);

		tf_nome_1 = new JTextField();
		tf_nome_1.setBounds(72, 49, 86, 20);
		contentPane.add(tf_nome_1);
		tf_nome_1.setColumns(10);

		btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nome = tf_nome.getText();
					double preco = Double.parseDouble(tf_nome_1.getText());
					Produto p = Fachada.cadastrarProduto(nome, preco);
					lb_msg.setText("cadastrado "+p.getNome());
					
					tf_nome.setText("");
					tf_nome.setText("");
					tf_nome.requestFocus();
				}
				catch(Exception erro){
					lb_msg.setText(erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(168, 48, 115, 23);
		contentPane.add(btnCriar);
		
		lb_msg = new JLabel("");
		lb_msg.setBounds(10, 94, 273, 14);
		contentPane.add(lb_msg);
	}
}
