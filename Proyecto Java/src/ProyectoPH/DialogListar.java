package ProyectoPH;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class DialogListar extends JDialog implements ActionListener {
	//Variables Globales
	public static int hojas1=DialogModificar.hojas1,hojas2=DialogModificar.hojas2,hojas3=DialogModificar.hojas3,hojas4=DialogModificar.hojas4,
			hojas5=DialogModificar.hojas5;
	public static double precio1=DialogModificar.precio1,precio2=DialogModificar.precio2,precio3=DialogModificar.precio3,
			precio4=DialogModificar.precio4,precio5=DialogModificar.precio5;
	public static String suavidad1=DialogModificar.suavidad1,suavidad2=DialogModificar.suavidad2,
			suavidad3=DialogModificar.suavidad3,suavidad4=DialogModificar.suavidad4,suavidad5=DialogModificar.suavidad5,
			tamaño1=DialogModificar.tamaño1,tamaño2=DialogModificar.tamaño2,tamaño3=DialogModificar.tamaño3,tamaño4=DialogModificar.tamaño4,
			tamaño5=DialogModificar.tamaño5;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JButton btnListar;
	private JTextArea txtSalida;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogListar dialog = new DialogListar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogListar() {
		setModal(true);
		setResizable(false);
		setTitle("Listado de modelos");
		setBounds(100, 100, 600, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(181, 277, 89, 23);
			contentPanel.add(btnCerrar);
		}
		{
			btnListar = new JButton("Listar");
			btnListar.addActionListener(this);
			btnListar.setBounds(311, 277, 89, 23);
			contentPanel.add(btnListar);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(10, 11, 564, 243);
			contentPanel.add(scrollPane);
			
			txtSalida = new JTextArea();
			txtSalida.setEditable(false);
			scrollPane.setViewportView(txtSalida);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnListar(ActionEvent e) {		
		imprimir();			
		}
		
		void imprimir(){
			
			txtSalida.setText("");
			imprimir("LISTADO DE MODELOS\n");
			imprimir("Modelo: Confort");
			imprimir("Suavidad: "+DialogModificar.suavidad1);
			imprimir("Número de hojas por rollo: "+DialogModificar.hojas1);
			imprimir("Tamaño de hoja: "+DialogModificar.tamaño1);
			imprimir("Precio: "+DialogModificar.precio1+"\n");
			imprimir("Modelo: Secreto");
			imprimir("Suavidad: "+DialogModificar.suavidad2);
			imprimir("Número de hojas por rollo: "+DialogModificar.hojas2);
			imprimir("Tamaño de hoja: "+DialogModificar.tamaño2);
			imprimir("Precio: "+DialogModificar.precio2+"\n");
			imprimir("Modelo: Carmin");
			imprimir("Suavidad: "+DialogModificar.suavidad3);
			imprimir("Número de hojas por rollo: "+DialogModificar.hojas3);
			imprimir("Tamaño de hoja: "+DialogModificar.tamaño3);
			imprimir("Precio: "+DialogModificar.precio3+"\n");
			imprimir("Modelo: Pétalo");
			imprimir("Suavidad: "+DialogModificar.suavidad4);
			imprimir("Número de hojas por rollo: "+DialogModificar.hojas4);
			imprimir("Tamaño de hoja: "+DialogModificar.tamaño4);
			imprimir("Precio: "+DialogModificar.precio4+"\n");
			imprimir("Modelo: Panda");
			imprimir("Suavidad: "+DialogModificar.suavidad5);
			imprimir("Número de hojas por rollo: "+DialogModificar.hojas5);
			imprimir("Tamaño de hoja: "+DialogModificar.tamaño5);
			imprimir("Precio: "+DialogModificar.precio5+"\n");
			

		}	
		void imprimir(String cadena){
			
			txtSalida.append(cadena +"\n");
		}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}

