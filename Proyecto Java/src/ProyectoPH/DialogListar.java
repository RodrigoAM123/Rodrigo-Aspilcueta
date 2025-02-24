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
			tama�o1=DialogModificar.tama�o1,tama�o2=DialogModificar.tama�o2,tama�o3=DialogModificar.tama�o3,tama�o4=DialogModificar.tama�o4,
			tama�o5=DialogModificar.tama�o5;
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
			imprimir("N�mero de hojas por rollo: "+DialogModificar.hojas1);
			imprimir("Tama�o de hoja: "+DialogModificar.tama�o1);
			imprimir("Precio: "+DialogModificar.precio1+"\n");
			imprimir("Modelo: Secreto");
			imprimir("Suavidad: "+DialogModificar.suavidad2);
			imprimir("N�mero de hojas por rollo: "+DialogModificar.hojas2);
			imprimir("Tama�o de hoja: "+DialogModificar.tama�o2);
			imprimir("Precio: "+DialogModificar.precio2+"\n");
			imprimir("Modelo: Carmin");
			imprimir("Suavidad: "+DialogModificar.suavidad3);
			imprimir("N�mero de hojas por rollo: "+DialogModificar.hojas3);
			imprimir("Tama�o de hoja: "+DialogModificar.tama�o3);
			imprimir("Precio: "+DialogModificar.precio3+"\n");
			imprimir("Modelo: P�talo");
			imprimir("Suavidad: "+DialogModificar.suavidad4);
			imprimir("N�mero de hojas por rollo: "+DialogModificar.hojas4);
			imprimir("Tama�o de hoja: "+DialogModificar.tama�o4);
			imprimir("Precio: "+DialogModificar.precio4+"\n");
			imprimir("Modelo: Panda");
			imprimir("Suavidad: "+DialogModificar.suavidad5);
			imprimir("N�mero de hojas por rollo: "+DialogModificar.hojas5);
			imprimir("Tama�o de hoja: "+DialogModificar.tama�o5);
			imprimir("Precio: "+DialogModificar.precio5+"\n");
			

		}	
		void imprimir(String cadena){
			
			txtSalida.append(cadena +"\n");
		}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}

