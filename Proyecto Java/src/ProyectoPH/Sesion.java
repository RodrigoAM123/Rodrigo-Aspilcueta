package ProyectoPH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class Sesion extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField pContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sesion frame = new Sesion();
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
	public Sesion() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\png-transparent-toilet-paper-holders-facial-tissues-tissue-paper-toilet-paper.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 235);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicio de sesi\u00F3n");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel.setBounds(52, 12, 185, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 70, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 95, 75, 28);
		contentPane.add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(92, 69, 168, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char [] clave=pContrasena.getPassword();
				String claveFinal = new String(clave);
				
				if(txtNombre.getText().equals("Rodrigo Joel") && claveFinal.equals("PROYECTO")) {
					dispose();
					JOptionPane.showMessageDialog(null, "Bienvenido al sistema","INGRESASTE",
							JOptionPane.INFORMATION_MESSAGE);
					TICMain p = new TICMain ();
					p.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrecta","ERROR",
							JOptionPane.ERROR_MESSAGE);
					txtNombre.setText("");
					pContrasena.setText("");
					txtNombre.requestFocus();
					
				}
				
					
				
			}
		});
		btnIngresar.setBounds(75, 148, 127, 37);
		contentPane.add(btnIngresar);
		
		pContrasena = new JPasswordField();
		pContrasena.setBounds(92, 101, 168, 20);
		contentPane.add(pContrasena);
	}
}
