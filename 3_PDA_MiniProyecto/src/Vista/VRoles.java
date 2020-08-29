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

public class VRoles {

	public JFrame principalRol;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRoles window = new VRoles();
					window.principalRol.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VRoles() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// propiedades del frame
		principalRol = new JFrame();
		principalRol.setTitle("ROL");
		principalRol.setType(Type.POPUP);
		principalRol.setIconImage(
				Toolkit.getDefaultToolkit().getImage(VRoles.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		principalRol.getContentPane().setBackground(Color.WHITE);
		principalRol.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 153));
		panel.setBounds(0, 0, 97, 240);
		principalRol.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnIngresarRol = new JButton("Ingresar Rol");
		btnIngresarRol.setBounds(150, 84, 130, 23);
		principalRol.getContentPane().add(btnIngresarRol);
		
		JButton btnEditarRol = new JButton("Modificar Rol");
		btnEditarRol.setBounds(150, 131, 130, 23);
		principalRol.getContentPane().add(btnEditarRol);
		principalRol.setBackground(Color.WHITE);
		principalRol.setBounds(100, 100, 333, 279);
		principalRol.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
