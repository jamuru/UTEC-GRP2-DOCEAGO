package Vista;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.SystemColor;


public class VPersonas extends JFrame {
	
	public JFrame persona;
	private JPanel dpPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPersonas window = new VPersonas();
					window.persona.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VPersonas() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// propiedades del frame
		persona = new JFrame();
		persona.setTitle("Persona");
		persona.setType(Type.POPUP);
		persona.setIconImage(Toolkit.getDefaultToolkit().getImage(VPersonas.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		persona.getContentPane().setBackground(Color.WHITE);
		persona.getContentPane().setLayout(null);

		dpPanel = new JPanel();
		dpPanel.setBackground(new Color(153, 204, 153));
		dpPanel.setBounds(0, 0, 438, 126);
		persona.getContentPane().add(dpPanel);
		dpPanel.setLayout(null);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VIngreso window = new VIngreso();
				window.ingreso.setVisible(true);			
				
			}
		});
		btnIngresar.setBounds(63, 150, 305, 23);
		persona.getContentPane().add(btnIngresar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VModificar window = new VModificar();
				window.modificar.setVisible(true);
			}
		});
		btnModificar.setBounds(63, 218, 305, 23);
		persona.getContentPane().add(btnModificar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VConsulta window = new VConsulta();
				window.consulta.setVisible(true);
				
			}
		});
		btnConsultar.setBounds(63, 184, 305, 23);
		persona.getContentPane().add(btnConsultar);
		
		JButton btnEliminar = new JButton("Elimnar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VEliminar window = new VEliminar();
				window.delete.setVisible(true);
			}
		});
		btnEliminar.setBounds(63, 252, 305, 23);
		persona.getContentPane().add(btnEliminar);
		persona.setBackground(Color.WHITE);
		persona.setBounds(100, 100, 454, 344);
		persona.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
