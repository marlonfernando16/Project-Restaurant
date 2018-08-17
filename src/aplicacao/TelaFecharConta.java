package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;

public class TelaFecharConta extends JFrame {

	private JPanel contentPane;
	private JTextField tf_id;
	private JLabel lb_mesa;
	private JButton btnFechar;
	private JLabel lb_msg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFecharConta frame = new TelaFecharConta();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaFecharConta() {
		setTitle("Fechar Conta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf_id = new JTextField();
		tf_id.setBounds(147, 22, 67, 20);
		contentPane.add(tf_id);
		tf_id.setColumns(10);

		lb_mesa = new JLabel("Mesa");
		lb_mesa.setBounds(99, 25, 46, 14);
		contentPane.add(lb_mesa);

		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(tf_id.getText().equals(""))
						throw new Exception ("Campo em branco, tente novamente");
					int id = Integer.parseInt(tf_id.getText());
					Fachada.fecharConta(id);
					lb_msg.setText("conta da mesa número: " + id + " fechada");
					
					tf_id.setText("");
					tf_id.requestFocus();
				}
				catch(Exception e2){
					lb_msg.setText(e2.getMessage());
				}
			}
		});
		btnFechar.setBounds(99, 53, 115, 23);
		contentPane.add(btnFechar);
		
		lb_msg = new JLabel("");
		lb_msg.setBounds(10, 87, 285, 21);
		contentPane.add(lb_msg);
	}
}