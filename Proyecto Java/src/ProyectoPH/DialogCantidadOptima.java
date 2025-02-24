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

public class DialogCantidadOptima extends JDialog implements ActionListener {
	public static int codpv=50;

	private final JPanel contentPanel = new JPanel();
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;
	private JTextField txtA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogCantidadOptima dialog = new DialogCantidadOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogCantidadOptima() {
		setTitle("Configurar cantidad \u00F3ptima de paquetes vendidos");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 487, 210);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validacionDatos()){
				codpv=Integer.parseInt(txtA.getText());
				dispose();
				}
			}
			boolean validacionDatos() {
				boolean clave=false;
				int optima=0;
				try {
					optima=Integer.parseInt(txtA.getText());
					
					if(optima<0) {
						JOptionPane.showMessageDialog(null, "Por favor ingresar correctamente una cantidad optima","ERROR",
								JOptionPane.ERROR_MESSAGE);
						txtA.setText("");
						txtA.requestFocus();
					} else {
							clave = true;}
					}
					
					catch(Exception e)
					{ if(optima==0) {
						JOptionPane.showMessageDialog(null, "Por favor ingresar una cantidad optima","ERROR",
								JOptionPane.ERROR_MESSAGE);
						txtA.setText("");
						txtA.requestFocus();
					}
						}
			
				return clave;}
		
			});
		btnAceptar.setBounds(361, 11, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(361, 45, 89, 23);
		contentPanel.add(btnCancelar);
		
		lblNewLabel = new JLabel("Cantidad \u00F3ptima de paquetes vendidos");
		lblNewLabel.setBounds(10, 15, 239, 14);
		contentPanel.add(lblNewLabel);
		
		txtA = new JTextField();
		txtA.setText(Integer.toString(codpv));
		txtA.setBounds(243, 12, 86, 20);
		contentPanel.add(txtA);
		txtA.setColumns(10);
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
