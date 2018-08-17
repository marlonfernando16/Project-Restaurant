package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Conta;

public class TelaConsultarConta extends JFrame {

	private JPanel contentPane;
	private JTextField td_id;
	private JLabel lb_texto;
	private JButton btnConsultar;
	private JTextArea listaContas;
	private JLabel lb_status;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarConta frame = new TelaConsultarConta();
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
	public TelaConsultarConta() {
		setTitle("Consultar Conta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		td_id = new JTextField();
		td_id.setBounds(72, 11, 86, 20);
		contentPane.add(td_id);
		td_id.setColumns(10);

		lb_texto = new JLabel("Conta");
		lb_texto.setBounds(33, 14, 46, 14);
		contentPane.add(lb_texto);

		

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(td_id.getText().equals("")) 
						throw new Exception("Campo em branco, tente novamente");
					int id = Integer.parseInt(td_id.getText());
					Conta c = Fachada.consultarConta(id);
					listaContas.setText("");
					listaContas.setText(c.toString());
			
					td_id.setText("");
					td_id.requestFocus();
				}
				catch(Exception e2){
					lb_status.setText(e2.getMessage());
				}
			}
		});
		btnConsultar.setBounds(444, 10, 90, 23);
		contentPane.add(btnConsultar);
		
		listaContas = new JTextArea();
		JScrollPane scroll = new JScrollPane(listaContas);
		scroll.setBounds(24, 50, 510, 174);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		lb_status = new JLabel("");
		lb_status.setBounds(25, 235, 483, 14);
		contentPane.add(lb_status);
	}
}