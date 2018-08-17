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
import modelo.Garcom;

public class TelaCadastrarGarcom extends JFrame{

	private JPanel contentPane;
	private JTextField tf_apelido;
	private JTextField tf_mesa;
	private JLabel lb_nome;
	private JLabel lb_mesa;
	private JButton btnCadastro;
	private JLabel mensagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarGarcom frame = new TelaCadastrarGarcom();
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
	public TelaCadastrarGarcom() {
		setTitle("Cadastro de Garçons");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf_apelido = new JTextField();
		tf_apelido.setBounds(72, 11, 86, 20);
		contentPane.add(tf_apelido);
		tf_apelido.setColumns(10);

		lb_nome = new JLabel("Nome");
		lb_nome.setBounds(16, 14, 46, 14);
		contentPane.add(lb_nome);

		lb_mesa = new JLabel("Mesa");
		lb_mesa.setBounds(16, 52, 46, 14);
		contentPane.add(lb_mesa);

		tf_mesa = new JTextField();
		tf_mesa.setBounds(72, 49, 86, 20);
		contentPane.add(tf_mesa);
		tf_mesa.setColumns(10);

		btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					if(tf_apelido.getText().equals("") || tf_mesa.getText().equals(""))
						throw new Exception("Campos em branco, tente novamente");
					
					String apelido = tf_apelido.getText();
					int id = Integer.parseInt(tf_mesa.getText());
					
					Garcom g = Fachada.cadastrarGarcom(apelido, id, id+4);
					mensagem.setText("cadastrado "+g.getApelido());
					
					tf_apelido.setText("");
					tf_mesa.setText("");
					tf_apelido.requestFocus();
				}
				catch(Exception erro){
					mensagem.setText(erro.getMessage());
				}
			}
		});
		btnCadastro.setBounds(168, 30, 115, 23);
		contentPane.add(btnCadastro);
		
		mensagem = new JLabel("");
		mensagem.setBounds(10, 94, 273, 14);
		contentPane.add(mensagem);
	}
}