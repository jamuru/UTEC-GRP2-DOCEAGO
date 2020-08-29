package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class VFuncionalidades {

	public JFrame principalFuncionalidad;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VFuncionalidades window = new VFuncionalidades();
					window.principalFuncionalidad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VFuncionalidades() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// propiedades del frame
		principalFuncionalidad = new JFrame();
		principalFuncionalidad.setTitle("FUNCIONALIDADES");
		principalFuncionalidad.setType(Type.POPUP);
		principalFuncionalidad.setIconImage(
				Toolkit.getDefaultToolkit().getImage(VFuncionalidades.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		principalFuncionalidad.getContentPane().setBackground(Color.WHITE);
		principalFuncionalidad.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 153));
		panel.setBounds(0, 0, 97, 261);
		principalFuncionalidad.getContentPane().add(panel);
		panel.setLayout(null);

		JButton igresarFuncion = new JButton("Ingresar Funci\u00F3n");
		igresarFuncion.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {


					
				}
			
		

		});
		igresarFuncion.setBounds(149, 86, 133, 21);
		principalFuncionalidad.getContentPane().add(igresarFuncion);
		
		JButton btnEliminarFuncion = new JButton("Eliminar Funci\u00F3n");
		btnEliminarFuncion.setBounds(150, 179, 133, 21);
		principalFuncionalidad.getContentPane().add(btnEliminarFuncion);
		
		JButton modificarFuncion = new JButton("Modificar Funci\u00F3n");
		modificarFuncion.setBounds(150, 132, 133, 21);
		principalFuncionalidad.getContentPane().add(modificarFuncion);
		principalFuncionalidad.setBackground(Color.WHITE);
		principalFuncionalidad.setBounds(100, 100, 370, 299);
		principalFuncionalidad.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
