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

public class DialogPremio extends JDialog implements ActionListener {
	public static int numClien=5;
	public static String cantChoco="Un chocolate";

	private final JPanel contentPanel = new JPanel();
	private JTextField txtnum;
	private JTextField txtUnChocolate;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogPremio dialog = new DialogPremio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogPremio() {
		setTitle("Configurar premio sorpresa");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 510, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("N\u00FAmero de cliente");
			lblNewLabel.setBounds(10, 11, 122, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Premio sorpresa");
			lblNewLabel_1.setBounds(10, 36, 99, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtnum = new JTextField();
			txtnum.setText(Integer.toString(numClien));
			txtnum.setBounds(130, 8, 122, 20);
			contentPanel.add(txtnum);
			txtnum.setColumns(10);
		}
		{
			txtUnChocolate = new JTextField();
			txtUnChocolate.setText(cantChoco);
			txtUnChocolate.setColumns(10);
			txtUnChocolate.setBounds(130, 33, 122, 20);
			contentPanel.add(txtUnChocolate);
		}
		{
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(validacionDatos()) {
					numClien=Integer.parseInt(txtnum.getText());
					cantChoco=txtUnChocolate.getText();
					dispose();
					}
				}
				boolean validacionDatos() {
					boolean clave=false;
					int cliente=0;
					try {
						cliente=Integer.parseInt(txtnum.getText());
						
						if(cliente<0) {
							JOptionPane.showMessageDialog(null, "Por favor ingresar un número entero","ERROR",
									JOptionPane.ERROR_MESSAGE);
							txtnum.setText("");
							txtnum.requestFocus();
						} else {
								clave = true;}
						}
						
						catch(Exception e)
						{ if(cliente==0) {
							JOptionPane.showMessageDialog(null, "Por favor ingresar un número entero","ERROR",
									JOptionPane.ERROR_MESSAGE);
							txtnum.setText("");
							txtnum.requestFocus();
						}
							}
				
					return clave;}
			});
			btnAceptar.setBounds(370, 7, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(370, 32, 89, 23);
			contentPanel.add(btnCancelar);
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
