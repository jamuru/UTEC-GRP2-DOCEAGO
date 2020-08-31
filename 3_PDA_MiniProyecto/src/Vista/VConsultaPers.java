package Vista;


import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import DAO.DAO_Persona;
import Modelo.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class VConsultaPers {

	public JFrame consultap;
	private JTextField ingreoPrimerApellido;
	private JTextField ingresoPrimerNombre;

	/**
	 * Launch the application.
	 */

	Connection conectar = null;
	

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VConsultaPers window = new VConsultaPers();
					window.consultap.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VConsultaPers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// propiedades del frame
		consultap = new JFrame();
		consultap.setTitle("Consulta personalizada");
		consultap.setType(Type.POPUP);
		consultap.setIconImage(
				Toolkit.getDefaultToolkit().getImage(VConsultaPers.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		consultap.getContentPane().setBackground(new Color(204, 255, 204));
		consultap.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Ingrese datos de la persona que queire buscar");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setBounds(76, 11, 232, 37);
		consultap.getContentPane().add(lblNewLabel);

		JLabel lblPrimerApellido = new JLabel("Primer Apellido*");
		lblPrimerApellido.setBounds(24, 69, 131, 14);
		consultap.getContentPane().add(lblPrimerApellido);

		ingreoPrimerApellido = new JTextField();
		ingreoPrimerApellido.setColumns(10);
		ingreoPrimerApellido.setBounds(24, 94, 131, 20);
		consultap.getContentPane().add(ingreoPrimerApellido);

		JButton verResultado = new JButton("Ver resultado");
		verResultado.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
									
				if(controlTextosBuscar()) {
					
					Persona unaPer = DAO_Persona.findPersona(ingreoPrimerApellido.getText(), ingresoPrimerNombre.getText());
					
					if (unaPer != null) {
						
						VIngreso v = new VIngreso();
						
						v.ingresoDocumento.setText(unaPer.getDocumento());
						v.ingreoPrimerApellido.setText(unaPer.getApellido1());
						v.ingreoSegundoApellido.setText(unaPer.getApellido2());
						ingresoPrimerNombre.setText(unaPer.getNombre1());
						v.ingreoSegundoNombre.setText(unaPer.getNombre2());
						//v.textFechNac.setText(unaPer.getFecNac().toString());
						//v.textRol.setText(unaPer.getId_rol());
						v.textMail.setText(unaPer.getMail());
						
						v.ingreso.setVisible(true);		
						
					}else {
						
						JOptionPane.showMessageDialog(null, "No se encontro a la persona especificada, verifique los datos ingresados");
						
					}//fin if persona!=null
												
					} else {
						
						JOptionPane.showMessageDialog(null, "Debe especifar el Primer Apellido y el Primer Nombre de la Persona");
						
					}//fin if controlTextos
			}

			

		});
		verResultado.setBounds(118, 152, 160, 23);
		consultap.getContentPane().add(verResultado);

		JLabel lblPrimerNombre = new JLabel("Primer Nombre*");
		lblPrimerNombre.setBounds(236, 69, 128, 14);
		consultap.getContentPane().add(lblPrimerNombre);

		ingresoPrimerNombre = new JTextField();
		ingresoPrimerNombre.setColumns(10);
		ingresoPrimerNombre.setBounds(233, 95, 131, 20);
		consultap.getContentPane().add(ingresoPrimerNombre);
		consultap.setBackground(Color.WHITE);
		consultap.setBounds(100, 100, 418, 243);
		consultap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public boolean controlTextos() {
		
		if (ingreoPrimerApellido.getText().isEmpty()||ingresoPrimerNombre.getText().isEmpty()) {
		
			return false;
		
		}else {
		
			return true;
		
		}//fin if
	}//fin controlTextos()
	
	public boolean controlTextosBuscar() {
		
		if (ingresoPrimerNombre.getText().isEmpty()) {
			
			return false;
			
		}else {
			
			return true;
			
		}//fin if
	}//fin controlTextos()
}