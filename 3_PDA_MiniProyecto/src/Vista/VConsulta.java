package Vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class VConsulta {

	public JFrame consulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VConsulta window = new VConsulta();
					window.consulta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VConsulta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		consulta = new JFrame();
		consulta.setIconImage(Toolkit.getDefaultToolkit().getImage(VConsulta.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		consulta.setTitle("Consulta");
		consulta.setBackground(new Color(135, 206, 235));
		consulta.setBounds(100, 100, 360, 300);
		consulta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		consulta.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 344, 263);
		consulta.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Consulta general");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				VResultado resultado = new VResultado();
				resultado.mostrarTodo();
			}
		});
		btnNewButton.setBounds(102, 126, 173, 23);
		panel.add(btnNewButton);

		JButton btnConsultaPersonalizada = new JButton("Consulta personalizada");
		btnConsultaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VConsultaPers window = new VConsultaPers();
				window.consultap.setVisible(true);
			}
		});
		btnConsultaPersonalizada.setBounds(102, 168, 173, 23);
		panel.add(btnConsultaPersonalizada);

		JLabel lblNewLabel = new JLabel("Elija el tipo de consulta");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(102, 153, 102));
		lblNewLabel.setBounds(92, 62, 200, 39);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 153));
		panel_1.setBounds(0, 0, 72, 263);
		panel.add(panel_1);
	}
}
