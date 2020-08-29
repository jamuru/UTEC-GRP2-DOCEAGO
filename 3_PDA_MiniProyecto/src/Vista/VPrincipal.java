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


public class VPrincipal extends JFrame {
	
	public JFrame principal;
	private JPanel dpPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPrincipal window = new VPrincipal();
					window.principal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VPrincipal() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// propiedades del frame
		principal = new JFrame();
		principal.setTitle("Men\u00FA principal");
		principal.setType(Type.POPUP);
		principal.setIconImage(Toolkit.getDefaultToolkit().getImage(VPrincipal.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		principal.getContentPane().setBackground(Color.WHITE);
		principal.getContentPane().setLayout(null);

		dpPanel = new JPanel();
		dpPanel.setBackground(new Color(153, 204, 153));
		dpPanel.setBounds(0, 0, 438, 230);
		principal.getContentPane().add(dpPanel);
		dpPanel.setLayout(null);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnUsuarios.setForeground(new Color(255, 255, 255));
		btnUsuarios.setBackground(new Color(0, 128, 0));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VPersonas window = new VPersonas();
				window.persona.setVisible(true);			
				
			}
		});
		btnUsuarios.setBounds(61, 240, 305, 53);
		principal.getContentPane().add(btnUsuarios);
		
		JButton btnFuncionalidades = new JButton("Funcionalidades");
		btnFuncionalidades.setForeground(new Color(255, 255, 255));
		btnFuncionalidades.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnFuncionalidades.setBackground(new Color(0, 128, 0));
		btnFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VFuncionalidades window = new VFuncionalidades();
				window.principalFuncionalidad.setVisible(true);
			}
		});
		btnFuncionalidades.setBounds(61, 368, 305, 52);
		principal.getContentPane().add(btnFuncionalidades);
		
		JButton btnRoles = new JButton("Roles");
		btnRoles.setForeground(new Color(255, 255, 255));
		btnRoles.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRoles.setBackground(new Color(0, 128, 0));
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VRoles window = new VRoles();
				window.principalRol.setVisible(true);
				
			}
		});
		btnRoles.setBounds(61, 304, 305, 53);
		principal.getContentPane().add(btnRoles);
		principal.setBackground(Color.WHITE);
		principal.setBounds(100, 100, 454, 472);
		principal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
