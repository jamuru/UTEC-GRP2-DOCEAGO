package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import DAO.DAO_Persona;
import Modelo.Persona;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import java.awt.SystemColor;
import java.awt.Window.Type;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class VModificar {

	public JFrame modificar;
	public JTextField ingresoDocumento;
	private JTextField ingresoPrimerApellido;
	private JTextField ingresoSegundoApellido;

	/**
	 * Launch the application.
	 */

	Connection conectar = null;
	private JTextField ingresoPrimerNombre;
	private JTextField ingresoSegundoNombre;
	private JTextField textFecNac;
	private JTextField textContrase;
	private JTextField textMail;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VModificar window = new VModificar();
					window.modificar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VModificar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		modificar = new JFrame();
		modificar.setTitle("Modificar Registro");
		modificar.setType(Type.POPUP);
		modificar.setIconImage(
				Toolkit.getDefaultToolkit().getImage(VModificar.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		modificar.getContentPane().setBackground(Color.WHITE);
		modificar.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 153));
		panel.setBounds(0, 0, 81, 438);
		modificar.getContentPane().add(panel);
		panel.setLayout(null);

		ingresoDocumento = new JTextField();
		ingresoDocumento.setBackground(new Color(240, 255, 255));
		ingresoDocumento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		ingresoDocumento.setHorizontalAlignment(SwingConstants.RIGHT);
		ingresoDocumento.setForeground(SystemColor.controlText);
		ingresoDocumento.setBounds(176, 47, 131, 20);
		modificar.getContentPane().add(ingresoDocumento);
		ingresoDocumento.setColumns(10);

		JLabel lblNewLabel = new JLabel("Ingrese documento de persona a modificar");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setBounds(132, 11, 232, 37);
		modificar.getContentPane().add(lblNewLabel);

		JLabel lblPrimerApellido = new JLabel("Primer Apellido*");
		lblPrimerApellido.setBounds(91, 99, 81, 14);
		modificar.getContentPane().add(lblPrimerApellido);

		ingresoPrimerApellido = new JTextField();
		ingresoPrimerApellido.setColumns(10);
		ingresoPrimerApellido.setBounds(91, 124, 131, 20);
		modificar.getContentPane().add(ingresoPrimerApellido);

		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(91, 155, 106, 14);
		modificar.getContentPane().add(lblSegundoApellido);

		ingresoSegundoApellido = new JTextField();
		ingresoSegundoApellido.setColumns(10);
		ingresoSegundoApellido.setBounds(91, 180, 131, 20);
		modificar.getContentPane().add(ingresoSegundoApellido);

		ingresoPrimerNombre = new JTextField();
		ingresoPrimerNombre.setColumns(10);
		ingresoPrimerNombre.setBounds(91, 236, 131, 20);
		modificar.getContentPane().add(ingresoPrimerNombre);
		
		JLabel lblPrimerNombre_ = new JLabel("Segundo Nombre");
		lblPrimerNombre_.setBounds(91, 267, 109, 14);
		modificar.getContentPane().add(lblPrimerNombre_);
		
		ingresoSegundoNombre = new JTextField();
		ingresoSegundoNombre.setColumns(10);
		ingresoSegundoNombre.setBounds(91, 292, 131, 20);
		modificar.getContentPane().add(ingresoSegundoNombre);
		
		JLabel lblFecNac = new JLabel("Fecha Nacimiento");
		lblFecNac.setBounds(245, 99, 109, 14);
		modificar.getContentPane().add(lblFecNac);
		
		textFecNac = new JTextField();
		textFecNac.setText("fechaporlasdudas");
		textFecNac.setColumns(10);
		textFecNac.setBounds(91, 383, 131, 20);
		modificar.getContentPane().add(textFecNac);
		
		textContrase = new JTextField();
		textContrase.setColumns(10);
		textContrase.setBounds(245, 180, 131, 20);
		modificar.getContentPane().add(textContrase);
		
		JLabel lblContrasenia = new JLabel("Contrse\u00F1a");
		lblContrasenia.setBounds(245, 155, 109, 14);
		modificar.getContentPane().add(lblContrasenia);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setBounds(245, 211, 109, 14);
		modificar.getContentPane().add(lblRol);
		
		JComboBox comboBoxRol = new JComboBox();
		comboBoxRol.setToolTipText("");
		comboBoxRol.setFont(new Font("Tahoma", Font.PLAIN, 9));
		comboBoxRol.setBounds(245, 236, 131, 20);
		modificar.getContentPane().add(comboBoxRol);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(245, 267, 109, 14);
		modificar.getContentPane().add(lblEmail);
		
		
		

		JDateChooser dcFecha = new JDateChooser();
		dcFecha.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dcFecha.setBounds(245, 124, 137, 20);
		modificar.getContentPane().add(dcFecha);
		
		
		
		JButton modificarPersona = new JButton("Modificar");
		modificarPersona.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String documento = ingresoDocumento.getText();
				
				String apellido1 = ingresoPrimerApellido.getText();
				
				String apellido2 = ingresoSegundoApellido.getText();
				
				String nombre1 = ingresoPrimerNombre.getText();
				
				String nombre2 = ingresoSegundoNombre.getText();
				
				//int idPersona = Integer.parseInt(textIdPersona.getText());
				
				Date fecNac = Date.valueOf(textFecNac.getText());
				
				
				String clave = textContrase.getText();
				
				//int id_rol = Integer.parseInt(textRol.getText());
				
				String mail = textMail.getText();
				
				Persona p = new Persona();
				
				p.setDocumento(documento);
				p.setApellido1(apellido1);
				p.setApellido2(apellido2);
				p.setNombre1(nombre1);
				p.setNombre2(nombre2);
				p.setFecNac(fecNac);
				p.setMail(mail);
				p.setClave(clave);
				
				DAO_Persona.edit(p);
				
				if (DAO_Persona.edit(p)) {
					
					JOptionPane.showMessageDialog(null, "Se ha editado la información correctamente.");
					
				} else {
					
					JOptionPane.showMessageDialog(null, "No se ha editado la información.");
					
				}
			}
		});
		modificarPersona.setBounds(339, 404, 89, 23);
		modificar.getContentPane().add(modificarPersona);

		JLabel lblPrimerNombre = new JLabel("Primer Nombre*");
		lblPrimerNombre.setBounds(91, 211, 81, 14);
		modificar.getContentPane().add(lblPrimerNombre);

		textMail = new JTextField();
		textMail.setColumns(10);
		textMail.setBounds(245, 292, 131, 20);
		modificar.getContentPane().add(textMail);
		modificar.setBackground(Color.WHITE);
		modificar.setBounds(100, 100, 454, 476);
		modificar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
