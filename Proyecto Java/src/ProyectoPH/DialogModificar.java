package ProyectoPH;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class DialogModificar extends JDialog implements ActionListener, ItemListener {
	public static int hojas1=300,hojas2=500,hojas3=600,hojas4=600,hojas5=500;
	public static double precio1=2.0,precio2=2.8,precio3=3.2,precio4=4.0,precio5=3.6;
	public static String suavidad1="Poco suave", suavidad2 = "Suave", suavidad3="Muy suave", suavidad4="Super suave",
						suavidad5="Super suave", tamaño1="10 cm x 10 cm", tamaño2="10.2 cm x 10.2 cm",
						tamaño3="10.5 cm x 11.0 cm", tamaño4="10.5 cm x 11.0 cm", tamaño5="11.0 cm x 11.0 cm";
	private final JPanel contentPanel = new JPanel();
	private JComboBox comboModelo;
	private JTextField txtSuavidad;
	private JTextField txtNumero;
	private JTextField txtTamano;
	private JTextField txtPrecio;
	private JLabel lblModelo;
	private JLabel lblSuavidad;
	private JLabel lblNumero;
	private JLabel lblTamano;
	private JLabel lblPrecio;
	private JButton btnCerrar;
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogModificar dialog = new DialogModificar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogModificar() {
		setTitle("Modificar modelo");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 600, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboModelo = new JComboBox();
		comboModelo.addItemListener(this);
		comboModelo.setModel(new DefaultComboBoxModel(new String[] {"Confort", "Secreto", "Carmin", "P\u00E9talo", "Panda"}));
		comboModelo.setBounds(203, 11, 163, 22);
		contentPanel.add(comboModelo);
		
		txtSuavidad = new JTextField();
		txtSuavidad.setText(suavidad1);
		txtSuavidad.setColumns(10);
		txtSuavidad.setBounds(203, 44, 163, 20);
		contentPanel.add(txtSuavidad);
		
		txtNumero = new JTextField();
		txtNumero.setText(Integer.toString(hojas1));
		txtNumero.setColumns(10);
		txtNumero.setBounds(203, 75, 163, 20);
		contentPanel.add(txtNumero);
		
		txtTamano = new JTextField();
		txtTamano.setText(tamaño1);
		txtTamano.setColumns(10);
		txtTamano.setBounds(203, 106, 163, 20);
		contentPanel.add(txtTamano);
		
		txtPrecio = new JTextField();
		txtPrecio.setText(String.valueOf(precio1));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(203, 137, 163, 20);
		contentPanel.add(txtPrecio);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(26, 15, 66, 14);
		contentPanel.add(lblModelo);
		
		lblSuavidad = new JLabel("Suavidad");
		lblSuavidad.setBounds(26, 47, 90, 14);
		contentPanel.add(lblSuavidad);
		
		lblNumero = new JLabel("N\u00FAmero de hojas por rollo");
		lblNumero.setBounds(26, 78, 167, 14);
		contentPanel.add(lblNumero);
		
		lblTamano = new JLabel("Tama\u00F1o de hoja");
		lblTamano.setBounds(26, 109, 138, 14);
		contentPanel.add(lblTamano);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(26, 140, 90, 14);
		contentPanel.add(lblPrecio);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(469, 11, 89, 23);
		contentPanel.add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int modelo;
				modelo = comboModelo.getSelectedIndex();
				if(validacionDatos()) {
				switch(modelo) {
					case 0:
							hojas1 = Integer.parseInt(txtNumero.getText());
							precio1 = Double.parseDouble(txtPrecio.getText());
							tamaño1 = txtTamano.getText();
							suavidad1 = txtSuavidad.getText();
								break;
					case 1: hojas2 = Integer.parseInt(txtNumero.getText());
							precio2 = Double.parseDouble(txtPrecio.getText());
							tamaño2 = txtTamano.getText();
							suavidad2 = txtSuavidad.getText();
							break;
					case 2: hojas3 = Integer.parseInt(txtNumero.getText());
							precio3 = Double.parseDouble(txtPrecio.getText());
							tamaño3 = txtTamano.getText();
							suavidad3 = txtSuavidad.getText();
							break;
					case 3:hojas4 = Integer.parseInt(txtNumero.getText());
							precio4 = Double.parseDouble(txtPrecio.getText());
							tamaño4 = txtTamano.getText();
							suavidad4 = txtSuavidad.getText();
							break;
					case 4: hojas5 = Integer.parseInt(txtNumero.getText());
							precio5 = Double.parseDouble(txtPrecio.getText());
							tamaño5 = txtTamano.getText();
							suavidad5 = txtSuavidad.getText();
							break;}
				}}
			boolean validacionDatos() {
				boolean clave=false;
				int rollos=0;
				double preci=0.0;
				try {
					rollos=Integer.parseInt(txtNumero.getText());
					preci=Double.parseDouble(txtPrecio.getText());
					
					if(rollos<0) {
						JOptionPane.showMessageDialog(null, "Por favor ingresar correctamente la cantidad","ERROR",
								JOptionPane.ERROR_MESSAGE);
						txtNumero.setText("");
						txtNumero.requestFocus();
					} else { if(preci<0.0) {
						JOptionPane.showMessageDialog(null, "Por favor digite correctamente el precio","ERROR",
								JOptionPane.ERROR_MESSAGE);
						txtPrecio.setText("");
						txtPrecio.requestFocus();}
						else {
							clave = true;}
					}
					}
					catch(Exception e)
					{ if(rollos==0) {
						JOptionPane.showMessageDialog(null, "Por favor ingresar una cantidad","ERROR",
								JOptionPane.ERROR_MESSAGE);
						txtNumero.setText("");
						txtNumero.requestFocus();
					} else { if(preci==0) {
						JOptionPane.showMessageDialog(null, "Por favor ingrese un precio","ERROR",
								JOptionPane.ERROR_MESSAGE);
						txtPrecio.setText("");
						txtPrecio.requestFocus();}
					}
						}
			
				return clave;}
				
		});
		btnGrabar.setBounds(469, 43, 89, 23);
		contentPanel.add(btnGrabar);
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
		if (e.getSource() == comboModelo) {
			itemStateChangedComboModelo(e);
		}
	}
	protected void itemStateChangedComboModelo(ItemEvent e) {
		int modelos;
		modelos = comboModelo.getSelectedIndex();
		switch(modelos) {
			case 0: txtNumero.setText(Integer.toString(hojas1));
					txtPrecio.setText(String.valueOf(precio1));
					txtTamano.setText(tamaño1);
					txtSuavidad.setText(suavidad1);
					break;
			case 1: txtNumero.setText(Integer.toString(hojas2));
					txtPrecio.setText(String.valueOf(precio2));
					txtTamano.setText(tamaño2);
					txtSuavidad.setText(suavidad2);
					break;
			case 2: txtNumero.setText(Integer.toString(hojas3));
					txtPrecio.setText(String.valueOf(precio3));
					txtTamano.setText(tamaño3);
					txtSuavidad.setText(suavidad3);
					break;
			case 3:txtNumero.setText(Integer.toString(hojas4));
					txtPrecio.setText(String.valueOf(precio4));
					txtTamano.setText(tamaño4);
					txtSuavidad.setText(suavidad4);
					break;
			case 4: txtNumero.setText(Integer.toString(hojas5));
					txtPrecio.setText(String.valueOf(precio5));
					txtTamano.setText(tamaño5);
					txtSuavidad.setText(suavidad5);
					break;
		}
	}
}
