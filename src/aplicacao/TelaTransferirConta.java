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

public class TelaTransferirConta extends JFrame {

	private JPanel contentPane;
	private JTextField tf_id_origem;
	private JTextField tf_id_destino;
	private JLabel lb_origem;
	private JLabel lb_destino;
	private JButton btnTransferir;
	private JLabel lb_status;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTransferirConta frame = new TelaTransferirConta();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}


	public TelaTransferirConta() {
		setTitle("Transferir Contas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 348, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf_id_origem = new JTextField();
		tf_id_origem.setBounds(192, 11, 86, 20);
		contentPane.add(tf_id_origem);
		tf_id_origem.setColumns(10);

		lb_origem = new JLabel("Mesa de origem:");
		lb_origem.setBounds(28, 14, 87, 14);
		contentPane.add(lb_origem);

		lb_destino = new JLabel("Mesa de destino:");
		lb_destino.setBounds(28, 52, 87, 14);
		contentPane.add(lb_destino);

		tf_id_destino = new JTextField();
		tf_id_destino.setBounds(192, 49, 86, 20);
		contentPane.add(tf_id_destino);
		tf_id_destino.setColumns(10);

		btnTransferir = new JButton("Transferir");
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(tf_id_origem.getText().equals("") || tf_id_destino.getText().equals(""))
						throw new Exception("Campos em branco, tente novamente");
					int mesa_origem = Integer.parseInt(tf_id_origem.getText());
					int mesa_destino = Integer.parseInt(tf_id_destino.getText());
					Fachada.transferirConta(mesa_origem, mesa_destino);
					lb_status.setText("conta transferida!");
					
					tf_id_origem.setText("");
					tf_id_destino.setText("");
					tf_id_origem.requestFocus();
				}
				catch(Exception e2){
					lb_status.setText(e2.getMessage());
				}
			}
		});
		btnTransferir.setBounds(107, 84, 115, 23);
		contentPane.add(btnTransferir);
		
		lb_status = new JLabel("");
		lb_status.setBounds(10, 130, 322, 20);
		contentPane.add(lb_status);
	}
}