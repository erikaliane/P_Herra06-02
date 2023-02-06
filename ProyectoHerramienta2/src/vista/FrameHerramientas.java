package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;

import vista.FramePrincipal;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.Inventario;

public class FrameHerramientas extends JFrame {

	private JPanel contentPane;
	private JTextField textNombreHerra;
	private JTextField textMarca;
	private JTextField textSerie;
	private JTextField textCodBarra;
	
	Inventario m=new Inventario();
	private JTextField textBuscarHerra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHerramientas frame = new FrameHerramientas();
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
	public FrameHerramientas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1235, 785);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistroHerra = new JButton("Registrar");
		btnRegistroHerra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom=textNombreHerra.getText();
				String marca=textMarca.getText();
				String serie=textSerie.getText();
				String cod_barra=textCodBarra.getText();
				boolean w=m.registrar_herra(nom,marca,serie,cod_barra);
				if(w==true) {
					
					JOptionPane.showMessageDialog(null,"Herramienta Registrada Correctamente");
					textNombreHerra.setText("");
					textMarca.setText("");
					textSerie.setText("");
					textCodBarra.setText("");
					
				}else {
					JOptionPane.showMessageDialog(null, "Error al registrar Usuario");
				}	
				
				
				
				
			}
		});
		btnRegistroHerra.setBounds(49, 403, 175, 49);
		contentPane.add(btnRegistroHerra);
		
		textNombreHerra = new JTextField();
		textNombreHerra.setBounds(114, 76, 86, 20);
		contentPane.add(textNombreHerra);
		textNombreHerra.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setBounds(114, 123, 86, 20);
		contentPane.add(textMarca);
		textMarca.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(32, 79, 72, 14);
		contentPane.add(lblNombre);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(32, 126, 72, 14);
		contentPane.add(lblMarca);
		
		textSerie = new JTextField();
		textSerie.setBounds(114, 165, 86, 20);
		contentPane.add(textSerie);
		textSerie.setColumns(10);
		
		JLabel lblSerie = new JLabel("Serie");
		lblSerie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSerie.setBounds(32, 168, 53, 17);
		contentPane.add(lblSerie);
		
		
		JTextArea textListaHerramienta = new JTextArea();
		textListaHerramienta.setBounds(462, 102, 644, 320);
		contentPane.add(textListaHerramienta);
		
		JButton btnListaHerra = new JButton("Lista de Herramientas");
		btnListaHerra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textListaHerramienta.setText("Codigo \tNombre\tMarca \tSerie \tCOD BARRA");
				
				ResultSet data=m.consulta("select * from herramienta");
				try {
				while(data.next()) {
					textListaHerramienta.append("\n"+"\n"+data.getInt(1)+"\t"+data.getString(2)+
							"\t"+data.getString(3)+
							"\t"+data.getString(4)+
							"\t"+data.getString(5));
				}
				}catch(SQLException e1) {
				}
			}
		});
		
		btnListaHerra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListaHerra.setBounds(462, 54, 199, 30);
		contentPane.add(btnListaHerra);
		
		
		
		textCodBarra = new JTextField();
		textCodBarra.setBounds(32, 260, 192, 64);
		contentPane.add(textCodBarra);
		textCodBarra.setColumns(10);
		
		JButton btnCodBarra = new JButton("Generar Cod Barra");
		btnCodBarra.setBounds(33, 219, 123, 23);
		contentPane.add(btnCodBarra);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(32, 335, 89, 23);
		contentPane.add(btnImprimir);
		
		JButton btnNewButton_2 = new JButton("Menu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FramePrincipal window= new FramePrincipal();
				window.frame.setVisible(true);
				
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("D:\\Descargas1\\flecha.jpg"));
		btnNewButton_2.setBounds(32, 11, 180, 35);
		contentPane.add(btnNewButton_2);
		
		textBuscarHerra = new JTextField();
		textBuscarHerra.setBounds(920, 54, 175, 30);
		contentPane.add(textBuscarHerra);
		textBuscarHerra.setColumns(10);
		
		JButton btnBuscarHerra = new JButton("Buscar");
		btnBuscarHerra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textListaHerramienta.setText("Codigo \tNombre \tMarca \tSerie \tCod Barra");
				String nom =textBuscarHerra.getText();
				ResultSet data=m.consulta("select * from herramienta where nombre='"+ nom +"'");
				try {
				while(data.next()) {
					textListaHerramienta.append("\n"+data.getInt(1)+"\t"+data.getString(2)+
							"\t"+data.getString(3)+
							"\t"+data.getString(4)+
							"\t"+data.getString(5));
				}
				}catch(SQLException e1) {
				}		
			}
			
		});
		btnBuscarHerra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarHerra.setBounds(800, 54, 115, 30);
		contentPane.add(btnBuscarHerra);
		

		
	}
}
