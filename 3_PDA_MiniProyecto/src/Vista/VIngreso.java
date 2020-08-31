package Vista; 

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.Instant;
//import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import DAO.DAO_Persona;
import DAO.DAO_Rol;
import Modelo.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Window.Type;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class VIngreso {

	public JFrame ingreso;
	public JTextField ingresoDocumento;
	JTextField ingreoPrimerApellido;
	JTextField ingreoSegundoApellido;
	JTextField ingreoPrimerNombre;
	JTextField ingreoSegundoNombre;
	JTextField textContraseña;
	JTextField textMail;
	private String textRol;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIngreso window = new VIngreso();
					window.ingreso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//fin Main

	/**
	 * Create the application.
	 */
	public VIngreso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		ingreso = new JFrame();
		ingreso.setTitle("Ingreso de registro");
		ingreso.setType(Type.POPUP);
		ingreso.setIconImage(
				Toolkit.getDefaultToolkit().getImage(VIngreso.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		ingreso.getContentPane().setBackground(Color.WHITE);
		ingreso.getContentPane().setLayout(null);

		JPanel panelIngreso = new JPanel();
		panelIngreso.setBackground(new Color(153, 204, 153));
		panelIngreso.setBounds(0, 0, 148, 375);
		ingreso.getContentPane().add(panelIngreso);
		panelIngreso.setLayout(null);

		ingresoDocumento = new JTextField();
		ingresoDocumento.setBounds(195, 36, 131, 20);
		ingreso.getContentPane().add(ingresoDocumento);
		ingresoDocumento.setColumns(10);

		JLabel lblNewLabel = new JLabel("Documento*");
		lblNewLabel.setBounds(200, 11, 126, 14);
		ingreso.getContentPane().add(lblNewLabel);

		JLabel lblPrimerApellido = new JLabel("Primer Apellido*");
		lblPrimerApellido.setBounds(200, 67, 126, 14);
		ingreso.getContentPane().add(lblPrimerApellido);

		ingreoPrimerApellido = new JTextField();
		ingreoPrimerApellido.setColumns(10);
		ingreoPrimerApellido.setBounds(195, 92, 131, 20);
		ingreso.getContentPane().add(ingreoPrimerApellido);

		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(200, 123, 126, 14);
		ingreso.getContentPane().add(lblSegundoApellido);

		ingreoSegundoApellido = new JTextField();
		ingreoSegundoApellido.setColumns(10);
		ingreoSegundoApellido.setBounds(195, 148, 131, 20);
		ingreso.getContentPane().add(ingreoSegundoApellido);

		JLabel lblPrimerApellido_1_1 = new JLabel("Primer Nombre*");
		lblPrimerApellido_1_1.setBounds(200, 179, 126, 14);
		ingreso.getContentPane().add(lblPrimerApellido_1_1);

		ingreoPrimerNombre = new JTextField();
		ingreoPrimerNombre.setColumns(10);
		ingreoPrimerNombre.setBounds(195, 204, 131, 20);
		ingreso.getContentPane().add(ingreoPrimerNombre);

		JLabel lblPrimerApellido_1_2 = new JLabel("Segundo Nombre");
		lblPrimerApellido_1_2.setBounds(200, 235, 126, 14);
		ingreso.getContentPane().add(lblPrimerApellido_1_2);

		ingreoSegundoNombre = new JTextField();
		ingreoSegundoNombre.setColumns(10);
		ingreoSegundoNombre.setBounds(195, 260, 131, 20);
		ingreso.getContentPane().add(ingreoSegundoNombre);
		
		JLabel lblFechNac = new JLabel("Fecha de Nacimiento");
		lblFechNac.setBounds(371, 11, 126, 14);
		ingreso.getContentPane().add(lblFechNac);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setBounds(371, 67, 126, 14);
		ingreso.getContentPane().add(lblContrasenia);
		
		textContraseña = new JPasswordField();
		textContraseña.setColumns(10);
		textContraseña.setBounds(366, 92, 131, 20);
		ingreso.getContentPane().add(textContraseña);
		
		
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setBounds(371, 123, 126, 14);
		ingreso.getContentPane().add(lblRol);
				
		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(366, 204, 131, 20);
		ingreso.getContentPane().add(textMail);
		
		JLabel lblMail = new JLabel("E-Mail");
		lblMail.setBounds(371, 179, 126, 14);
		ingreso.getContentPane().add(lblMail);
		
		JComboBox comboBoxRol = new JComboBox();
		comboBoxRol.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBoxRol.setToolTipText("");
		comboBoxRol.setModel(new DefaultComboBoxModel(new String[] {"Admin", "JefeSec", "OperSec"}));
		comboBoxRol.setBounds(366, 148, 131, 20);
		
		//comboBoxRol.addItem("Administrador del sistema");
		//comboBoxRol.addItem("Jefe de sección");
		//comboBoxRol.addItem("Operador de sección");
		
		ingreso.getContentPane().add(comboBoxRol);
		ingreso.setBackground(Color.WHITE);
		ingreso.setBounds(100, 100, 558, 413);
		ingreso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		JDateChooser dcFecha = new JDateChooser();
		dcFecha.setDateFormatString("yyyy-MM-dd");
		dcFecha.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dcFecha.setBounds(366, 36, 131, 20);
		ingreso.getContentPane().add(dcFecha);
		
		
		
		
		JButton agregarPersona = new JButton("Agregar");
		agregarPersona.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				if(controlTextos()) {
					Persona unaP = new Persona();
					
					unaP.setDocumento(ingresoDocumento.getText());
					unaP.setApellido1(ingreoPrimerApellido.getText());
					unaP.setApellido2(ingreoSegundoApellido.getText());
					unaP.setNombre1(ingreoPrimerNombre.getText());
					unaP.setNombre2(ingreoSegundoNombre.getText());
					unaP.setFecNac(dcFecha.getDate());
					unaP.setClave(textContraseña.getText());
					unaP.setMail(textMail.getText());
					
					//Buscamos el Id del Rol seleccionado
					textRol = comboBoxRol.getSelectedItem().toString();
					unaP.setId_rol(DAO_Rol.findRol(textRol).getId_rol());
					
					if (DAO_Persona.insertar_Persona(unaP)){
						
						JOptionPane.showMessageDialog(null, "Datos agregados correctamente.", "Datos agregados", JOptionPane.INFORMATION_MESSAGE, null);
						limpiarTextos();
						
					} else {
						
						JOptionPane.showMessageDialog(null, "Error al ingresar los datos", "Error al ingresar los datos", JOptionPane.ERROR_MESSAGE);
						
					}
				}else {
					
					JOptionPane.showMessageDialog(null, "Error al ingresar los datos. Los campos obligatorios deben estar completos", "Error al ingresar los datos", JOptionPane.ERROR_MESSAGE);
					
				}

			}//fin actionperformed

		});
		agregarPersona.setBounds(421, 331, 89, 23);
		ingreso.getContentPane().add(agregarPersona);
		
	}
	
	public boolean controlTextos() {
		if (ingreoPrimerApellido.getText().isEmpty()||ingreoPrimerNombre.getText().isEmpty()||ingresoDocumento.getText().isEmpty()||textMail.getText().isEmpty()||textContraseña.getText().isEmpty()) {
			
			return false;
			
		}else {
			
			return true;
			
		}
	}
	
	public void limpiarTextos() {
		
		ingresoDocumento.setText("");
		ingreoPrimerApellido.setText("");
		ingreoSegundoApellido.setText("");
		ingreoPrimerNombre.setText("");
		ingreoSegundoNombre.setText("");
		textContraseña.setText("");
		textMail.setText("");
		
	}
	
}//fin clase

