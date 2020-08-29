package Vista;

import java.awt.Dimension;
import java.sql.Date;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_Persona;
import Modelo.Persona;

import java.awt.Toolkit;
import java.awt.Color;

public class VResultado extends JFrame {
	public VResultado() {
		getContentPane().setBackground(new Color(245, 255, 250));
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VResultado.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
	}

	public void mostrarTodo() {

		JFrame frame = new JFrame("Listado de Personas");

		// creamos el modelo de Tabla
		DefaultTableModel modelo = new DefaultTableModel();

		// se crea la Tabla con el modelo DefaultTableModel
		final JTable table = new JTable(modelo);
		// crea un array que contiene los nombre de las columnas
		final String[] columnNames = { "Documento", "Primer Apellido", "Primer Nombre", "Fecha de Nacimiento" };
		// insertamos las columnas
		for (int column = 0; column < columnNames.length; column++) {
			// agrega las columnas a la tabla
			modelo.addColumn(columnNames[column]);
		}

		// Se crea un array que será una de las filas de la tabla.
		Object[] fila = new Object[columnNames.length];
		// Se rellena cada posición del array con una de las columnas de la tabla en
		// base de datos.
		LinkedList<Persona> personas = DAO_Persona.findAll();

		for (int i = 0; i < personas.size(); i++) {

			String documento = personas.get(i).getDocumento();
			String apellido1 = personas.get(i).getApellido1();
			String nombre1 = personas.get(i).getNombre1();
			Date fechNac = (Date) personas.get(i).getFecNac();
			String mail = personas.get(i).getMail();

			fila[0] = documento;
			fila[1] = apellido1;
			fila[2] = nombre1;
			fila[3] = fechNac;
			fila[3] = mail;

			modelo.addRow(fila);
		}
		// Se añade al modelo la fila completa.

		// System.out.println(modelo);

		// se define el tamaño de la tabla
		table.setPreferredScrollableViewportSize(new Dimension(600, 300));
		// Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(table);
		// crea el panel
		JPanel panel = new JPanel();
		// definimos un layout
		// Agregamos el JScrollPane al contenedor
		panel.add(scrollPane);

		frame.getContentPane().add(panel);
		frame.pack();

		frame.setVisible(true);

	}

}// Fin clase