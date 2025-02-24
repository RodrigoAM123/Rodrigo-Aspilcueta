package ProyectoPH;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DialogObsequio extends JDialog implements ActionListener {
	public static int cantmin=6;
	public static String obsequio="Un lapicero";

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtcantidadmin;
	private JTextField txtobsequio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogObsequio dialog = new DialogObsequio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogObsequio() {
		setTitle("Configurar obsequio");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(validacionDatos()) {
					cantmin = Integer.parseInt(txtcantidadmin.getText());
					obsequio = txtobsequio.getText();
					dispose();}
				}
				boolean validacionDatos() {
					boolean clave=false;
					int cantidadmin=0;
					try {
						cantidadmin=Integer.parseInt(txtcantidadmin.getText());
						
						if(cantidadmin<0) {
							JOptionPane.showMessageDialog(null, "Por favor ingresar un número entero","ERROR",
									JOptionPane.ERROR_MESSAGE);
							txtcantidadmin.setText("");
							txtcantidadmin.requestFocus();
						} else {
								clave = true;}
						}
						
						catch(Exception e)
						{ if(cantidadmin==0) {
							JOptionPane.showMessageDialog(null, "Por favor ingresar un número entero","ERROR",
									JOptionPane.ERROR_MESSAGE);
							txtcantidadmin.setText("");
							txtcantidadmin.requestFocus();
						}
							}
				
					return clave;}
			});
			btnAceptar.setBounds(485, 11, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(485, 45, 89, 23);
			contentPanel.add(btnCancelar);
		}
		{
			lblNewLabel = new JLabel("Cantidad m\u00EDnima de paquetes adquiridos");
			lblNewLabel.setBounds(10, 15, 250, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Obsequio");
			lblNewLabel_1.setBounds(10, 49, 89, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtcantidadmin = new JTextField();
			txtcantidadmin.setText(Integer.toString(cantmin));
			txtcantidadmin.setBounds(255, 12, 130, 20);
			contentPanel.add(txtcantidadmin);
			txtcantidadmin.setColumns(10);
		}
		{
			txtobsequio = new JTextField();
			txtobsequio.setText(obsequio);
			txtobsequio.setBounds(255, 46, 130, 20);
			contentPanel.add(txtobsequio);
			txtobsequio.setColumns(10);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
