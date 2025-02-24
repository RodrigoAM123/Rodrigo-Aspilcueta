package ProyectoPH;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class DialogConsultar extends JDialog implements ActionListener, ItemListener {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboModelo1;
	private JLabel lblModelo;
	private JTextField txtSuavidad1;
	private JTextField txtNumero1;
	private JTextField txtTamano1;
	private JTextField txtPrecio1;
	private JLabel lblSuavidad;
	private JLabel lblNumero;
	private JLabel lblTamano;
	private JLabel lblPrecio;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogConsultar dialog = new DialogConsultar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogConsultar() {
		setModal(true);
		setResizable(false);
		setTitle("Consultar modelo");
		setBounds(100, 100, 600, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboModelo1 = new JComboBox();
		comboModelo1.addItemListener(this);
		comboModelo1.addActionListener(this);
		comboModelo1.setModel(new DefaultComboBoxModel(new String[] {"Confort", "Secreto", "Carmin", "P\u00E9talo", "Panda"}));
		comboModelo1.setBounds(200, 11, 163, 22);
		contentPanel.add(comboModelo1);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(23, 15, 66, 14);
		contentPanel.add(lblModelo);
		
		txtSuavidad1 = new JTextField();
		txtSuavidad1.setEditable(false);
		txtSuavidad1.setText(DialogModificar.suavidad1);
		txtSuavidad1.setBounds(200, 44, 163, 20);
		contentPanel.add(txtSuavidad1);
		txtSuavidad1.setColumns(10);
		
		txtNumero1 = new JTextField();
		txtNumero1.setEditable(false);
		txtNumero1.setText(Integer.toString(DialogModificar.hojas1));
		txtNumero1.setBounds(200, 75, 163, 20);
		contentPanel.add(txtNumero1);
		txtNumero1.setColumns(10);
		
		txtTamano1 = new JTextField();
		txtTamano1.setEditable(false);
		txtTamano1.setText((DialogModificar.tamaño1));
		txtTamano1.setBounds(200, 106, 163, 20);
		contentPanel.add(txtTamano1);
		txtTamano1.setColumns(10);
		
		txtPrecio1 = new JTextField();
		txtPrecio1.setEditable(false);
		txtPrecio1.setText(String.valueOf(DialogModificar.precio1));
		txtPrecio1.setBounds(200, 137, 163, 20);
		contentPanel.add(txtPrecio1);
		txtPrecio1.setColumns(10);
		
		lblSuavidad = new JLabel("Suavidad");
		lblSuavidad.setBounds(23, 47, 90, 14);
		contentPanel.add(lblSuavidad);
		
		lblNumero = new JLabel("N\u00FAmero de hojas por rollo");
		lblNumero.setBounds(23, 78, 167, 14);
		contentPanel.add(lblNumero);
		
		lblTamano = new JLabel("Tama\u00F1o de hoja");
		lblTamano.setBounds(23, 109, 138, 14);
		contentPanel.add(lblTamano);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(23, 140, 90, 14);
		contentPanel.add(lblPrecio);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(466, 11, 89, 23);
		contentPanel.add(btnCerrar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
		public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == comboModelo1) {
			itemStateChangedComboModelo(e);
		}
	}
	protected void itemStateChangedComboModelo(ItemEvent e) {
		int modelos;
		modelos = comboModelo1.getSelectedIndex();
		switch(modelos) {
			case 0: txtNumero1.setText(Integer.toString(DialogModificar.hojas1));
					txtPrecio1.setText(String.valueOf(DialogModificar.precio1));
					txtTamano1.setText(DialogModificar.tamaño1);
					txtSuavidad1.setText(DialogModificar.suavidad1);
					break;
			case 1: txtNumero1.setText(Integer.toString(DialogModificar.hojas2));
					txtPrecio1.setText(String.valueOf(DialogModificar.precio2));
					txtTamano1.setText(DialogModificar.tamaño2);
					txtSuavidad1.setText(DialogModificar.suavidad2);
					break;
			case 2: txtNumero1.setText(Integer.toString(DialogModificar.hojas3));
					txtPrecio1.setText(String.valueOf(DialogModificar.precio3));
					txtTamano1.setText(DialogModificar.tamaño3);
					txtSuavidad1.setText(DialogModificar.suavidad3);
					break;
			case 3:txtNumero1.setText(Integer.toString(DialogModificar.hojas4));
					txtPrecio1.setText(String.valueOf(DialogModificar.precio4));
					txtTamano1.setText(DialogModificar.tamaño4);
					txtSuavidad1.setText(DialogModificar.suavidad4);
					break;
			case 4: txtNumero1.setText(Integer.toString(DialogModificar.hojas5));
					txtPrecio1.setText(String.valueOf(DialogModificar.precio5));
					txtTamano1.setText(DialogModificar.tamaño5);
					txtSuavidad1.setText(DialogModificar.suavidad5);
					break;
		}
	}
}
