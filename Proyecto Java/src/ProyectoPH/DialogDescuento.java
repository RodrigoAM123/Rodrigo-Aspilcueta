package ProyectoPH;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogDescuento extends JDialog implements ActionListener {
	public static double desc1=5.0,desc2=6.5,desc3=8.0,desc4=9.5;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPorcentaje4;
	private JTextField txtPorcentaje3;
	private JTextField txtPorcentaje2;
	private JTextField txtPorcentaje1;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogDescuento dialog = new DialogDescuento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogDescuento() {
		setTitle("Configurar porcentajes de descuento");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 600, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("1 a 5 unidades");
			lblNewLabel.setBounds(10, 11, 123, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("6 a 10 unidades");
			lblNewLabel_1.setBounds(10, 36, 123, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("11 a 15 unidades");
			lblNewLabel_2.setBounds(10, 61, 123, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("M\u00E1s de 15 unidades");
			lblNewLabel_3.setBounds(10, 86, 123, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			txtPorcentaje4 = new JTextField();
			txtPorcentaje4.setText(String.valueOf(desc4));
			txtPorcentaje4.setBounds(170, 83, 86, 20);
			contentPanel.add(txtPorcentaje4);
			txtPorcentaje4.setColumns(10);
		}
		{
			txtPorcentaje3 = new JTextField();
			txtPorcentaje3.setText(String.valueOf(desc3));
			txtPorcentaje3.setBounds(170, 58, 86, 20);
			contentPanel.add(txtPorcentaje3);
			txtPorcentaje3.setColumns(10);
		}
		{
			txtPorcentaje2 = new JTextField();
			txtPorcentaje2.setText(String.valueOf(desc2));
			txtPorcentaje2.setBounds(170, 33, 86, 20);
			contentPanel.add(txtPorcentaje2);
			txtPorcentaje2.setColumns(10);
		}
		{
			txtPorcentaje1 = new JTextField();
			txtPorcentaje1.setText(String.valueOf(desc1));
			txtPorcentaje1.setBounds(170, 8, 86, 20);
			contentPanel.add(txtPorcentaje1);
			txtPorcentaje1.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("%");
			lblNewLabel_4.setBounds(266, 11, 46, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("%");
			lblNewLabel_4.setBounds(266, 36, 46, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("%");
			lblNewLabel_4.setBounds(266, 61, 46, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("%");
			lblNewLabel_4.setBounds(266, 86, 46, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(validacionDatos()) {
					desc1 = Double.parseDouble(txtPorcentaje1.getText());
					desc2 = Double.parseDouble(txtPorcentaje2.getText());
					desc3 = Double.parseDouble(txtPorcentaje3.getText());
					desc4 = Double.parseDouble(txtPorcentaje4.getText());
					dispose();}
				}
				boolean validacionDatos() {
					boolean clave=false;
					double por1=0.0,por2=0.0,por3=0.0,por4=0.0;
					try {
						por1=Double.parseDouble(txtPorcentaje1.getText());
						por2=Double.parseDouble(txtPorcentaje2.getText());
						por3=Double.parseDouble(txtPorcentaje3.getText());
						por4=Double.parseDouble(txtPorcentaje4.getText());
						
						if(por1<0 || por1>100) {
							JOptionPane.showMessageDialog(null, "Por favor ingresar un porcentaje correcto","ERROR",
									JOptionPane.ERROR_MESSAGE);
							txtPorcentaje1.setText("");
							txtPorcentaje1.requestFocus();
						} else {
							if(por2<0 || por1>100) {
								JOptionPane.showMessageDialog(null, "Por favor ingresar un porcentaje correcto","ERROR",
										JOptionPane.ERROR_MESSAGE);
								txtPorcentaje2.setText("");
								txtPorcentaje2.requestFocus();}
								else {
									if(por3<0 || por1>100) {
										JOptionPane.showMessageDialog(null, "Por favor ingresar un porcentaje correcto","ERROR",
												JOptionPane.ERROR_MESSAGE);
										txtPorcentaje3.setText("");
										txtPorcentaje3.requestFocus();}
									else {if(por4<0 || por1>100) {
											JOptionPane.showMessageDialog(null, "Por favor ingresar un porcentaje correcto","ERROR",
												JOptionPane.ERROR_MESSAGE);
											txtPorcentaje4.setText("");
											txtPorcentaje4.requestFocus();}
								
											else{
												clave = true;}}}}}
							
						
						catch(Exception e)
						{ if(por1==0) {
							JOptionPane.showMessageDialog(null, "Por favor ingresar un porcentaje","ERROR",
									JOptionPane.ERROR_MESSAGE);
							txtPorcentaje1.setText("");
							txtPorcentaje1.requestFocus();
						} else {
							if(por2==0) {
								JOptionPane.showMessageDialog(null, "Por favor ingresar un porcentaje","ERROR",
										JOptionPane.ERROR_MESSAGE);
								txtPorcentaje2.setText("");
								txtPorcentaje2.requestFocus();}
								else {
									if(por3==0) {
										JOptionPane.showMessageDialog(null, "Por favor ingresar un porcentaje","ERROR",
												JOptionPane.ERROR_MESSAGE);
										txtPorcentaje3.setText("");
										txtPorcentaje3.requestFocus();}
									else {if(por4==0) {
											JOptionPane.showMessageDialog(null, "Por favor ingresar un porcentaje","ERROR",
												JOptionPane.ERROR_MESSAGE);
											txtPorcentaje4.setText("");
											txtPorcentaje4.requestFocus();}}}}
						}
					return clave;	}
			});
			btnAceptar.setBounds(485, 11, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(485, 57, 89, 23);
			contentPanel.add(btnCerrar);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
