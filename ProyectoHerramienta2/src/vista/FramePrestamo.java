package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Inventario;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class FramePrestamo extends JFrame {

	private JPanel contentPane;
	private JTextField textCodBarra;
	private JTextField textBusquedaPrestamo;
	private JTable table;
	Inventario m=new Inventario();
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrestamo frame = new FramePrestamo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePrestamo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 624);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel.setBounds(35, 70, 366, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Apellidos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(39, 36, 77, 20);
		panel.add(lblNewLabel);
		
		textCodBarra = new JTextField();
		textCodBarra.setBounds(170, 103, 166, 62);
		panel.add(textCodBarra);
		textCodBarra.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar Prestamo");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegistrar.setBounds(95, 194, 160, 42);
		panel.add(btnRegistrar);
		
		JComboBox comboBoxApellidos = new JComboBox();
		comboBoxApellidos.setBounds(170, 37, 166, 36);
		panel.add(comboBoxApellidos);
		
		comboBoxApellidos.addItem("Numero 1 ");
		comboBoxApellidos.addItem("Numero 2 ");
		
		JButton btnLeerCodBarra = new JButton("Cod Barra");
		btnLeerCodBarra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeerCodBarra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLeerCodBarra.setBounds(23, 123, 118, 27);
		panel.add(btnLeerCodBarra);
		
		JButton btnMenuPrincipal = new JButton("Menu");
		btnMenuPrincipal.setBounds(39, 11, 89, 37);
		contentPane.add(btnMenuPrincipal);
		
		JButton btnBusquedaPrestamo = new JButton("Buscar");
		btnBusquedaPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBusquedaPrestamo.setBounds(720, 29, 89, 33);
		contentPane.add(btnBusquedaPrestamo);
		
		textBusquedaPrestamo = new JTextField();
		textBusquedaPrestamo.setBounds(819, 30, 138, 30);
		contentPane.add(textBusquedaPrestamo);
		textBusquedaPrestamo.setColumns(10);
		
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.setBounds(428, 423, 166, 37);
		contentPane.add(btnHistorial);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(419, 68, 538, 344);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBackground(SystemColor.menu);
		scrollPane.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		

		DefaultTableModel	model=(DefaultTableModel) table_1.getModel();
		
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Codigo", "Usuario", "Herramienta", "Hora Inicio"
			}
		));
		table_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.LIGHT_GRAY, null, null));
		
		JButton btnListaPrestamos = new JButton("Lista de Prestamos");
		btnListaPrestamos.setBounds(428, 34, 193, 23);
		contentPane.add(btnListaPrestamos);
	}
}
