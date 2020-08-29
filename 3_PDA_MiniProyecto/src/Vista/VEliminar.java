package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import DAO.DAO_Persona;
import Modelo.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class VEliminar {

	public JFrame delete;
	public JTextField ingresoDocumento;
	private JTextField ingreoPrimerApellido;
	private JTextField ingreoPrimerNombre;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VEliminar window = new VEliminar();
					window.delete.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VEliminar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// propiedades del frame
		delete = new JFrame();
		delete.setTitle("Eliminar registro");
		delete.setType(Type.POPUP);
		delete.setIconImage(
				Toolkit.getDefaultToolkit().getImage(VEliminar.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		delete.getContentPane().setBackground(Color.WHITE);
		delete.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 153));
		panel.setBounds(0, 0, 97, 307);
		delete.getContentPane().add(panel);
		panel.setLayout(null);

		ingresoDocumento = new JTextField();
		ingresoDocumento.setBounds(107, 73, 229, 20);
		delete.getContentPane().add(ingresoDocumento);
		ingresoDocumento.setColumns(10);

		JLabel lblNewLabel = new JLabel("Documento*");
		lblNewLabel.setBounds(107, 48, 81, 14);
		delete.getContentPane().add(lblNewLabel);

		JLabel lblPrimerApellido = new JLabel("Primer Apellido*");
		lblPrimerApellido.setBounds(107, 104, 126, 14);
		delete.getContentPane().add(lblPrimerApellido);

		ingreoPrimerApellido = new JTextField();
		ingreoPrimerApellido.setColumns(10);
		ingreoPrimerApellido.setBounds(107, 129, 229, 20);
		delete.getContentPane().add(ingreoPrimerApellido);

		JLabel lblPrimerApellido_1_1 = new JLabel("Primer Nombre*");
		lblPrimerApellido_1_1.setBounds(108, 160, 125, 14);
		delete.getContentPane().add(lblPrimerApellido_1_1);

		ingreoPrimerNombre = new JTextField();
		ingreoPrimerNombre.setColumns(10);
		ingreoPrimerNombre.setBounds(104, 185, 232, 20);
		delete.getContentPane().add(ingreoPrimerNombre);

		JButton eliminarPersona = new JButton("Eliminar");
		eliminarPersona.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

if(controlTextosBuscar()) {
					
					//Busco la persona a eliminar.
					Persona unaPer = DAO_Persona.findPersona(ingreoPrimerApellido.getText(), ingreoPrimerNombre.getText());
					if (unaPer != null) {
						
						//Elimino a la Persona encontrada
						if (DAO_Persona.delete(unaPer.getId_persona())) {
							
							JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
							//limpiarTextos();
							
						}else {
							
							JOptionPane.showMessageDialog(null, "Error al eliminar el registro, verifique los datos ingresados");
							
						}//fin if eliminarRegistro DAOPersona
						
					}else {
						
						JOptionPane.showMessageDialog(null, "No se encontro a la persona especificada, verifique los datos ingresados");
						
					}//fin if persona=null
												
					} else {
						
						JOptionPane.showMessageDialog(null, "Debe especifar el Primer apellido y el Primer Nombre de la Persona");
						
					}//fin if controlTextos
					
				}//fin actionPerformed
			
			public boolean controlTextosBuscar() {
				
				if (ingresoDocumento.getText().isEmpty()&&ingreoPrimerNombre.getText().isEmpty()) {
					
					return false;
					
				}else {
					
					return true;
					
				}//fin if
			}//fin controlTextos()

		});
		eliminarPersona.setBounds(107, 273, 89, 23);
		delete.getContentPane().add(eliminarPersona);
		delete.setBackground(Color.WHITE);
		delete.setBounds(100, 100, 370, 345);
		delete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
