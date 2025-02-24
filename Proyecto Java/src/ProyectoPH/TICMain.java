package ProyectoPH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TICMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmListar;
	private JMenuItem mntmVender;
	private JMenuItem mntmReportes;
	private JMenuItem mntmDescuentos;
	private JMenuItem mntmObsequios;
	private JMenuItem mntmPVendidos;
	private JMenuItem mntmPSorpresa;
	private JMenuItem mntmAcerca;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TICMain frame = new TICMain();
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
	public TICMain() {
		setResizable(false);
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 430);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmConsultar = new JMenuItem("Consultar modelo");
		mntmConsultar.addActionListener(this);
		mnMantenimiento.add(mntmConsultar);
		
		mntmModificar = new JMenuItem("Modificar modelo");
		mntmModificar.addActionListener(this);
		mnMantenimiento.add(mntmModificar);
		
		mntmListar = new JMenuItem("Listar modelo");
		mntmListar.addActionListener(this);
		mnMantenimiento.add(mntmListar);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmReportes = new JMenuItem("Generar reportes");
		mntmReportes.addActionListener(this);
		mnVentas.add(mntmReportes);
		
		mnConfiguracion = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguracion);
		
		mntmDescuentos = new JMenuItem("Configurar descuentos");
		mntmDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmDescuentos);
		
		mntmObsequios = new JMenuItem("Configurar obsequios");
		mntmObsequios.addActionListener(this);
		mnConfiguracion.add(mntmObsequios);
		
		mntmPVendidos = new JMenuItem("Configurar cantidad \u00F3ptima de paquetes vendidos");
		mntmPVendidos.addActionListener(this);
		mnConfiguracion.add(mntmPVendidos);
		
		mntmPSorpresa = new JMenuItem("Configurar premio sorpresa");
		mntmPSorpresa.addActionListener(this);
		mnConfiguracion.add(mntmPSorpresa);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcerca = new JMenuItem("Acerca de Tienda");
		mntmAcerca.addActionListener(this);
		mnAyuda.add(mntmAcerca);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("media/toilet-paper-4974461_1280.jpg"));
		lblNewLabel.setBounds(0, 0, 684, 369);
		contentPane.add(lblNewLabel);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmAcerca) {
			actionPerformedMntmAcerca(e);
		}
		if (e.getSource() == mntmPSorpresa) {
			actionPerformedMntmPSorpresa(e);
		}
		if (e.getSource() == mntmPVendidos) {
			actionPerformedMntmPVendidos(e);
		}
		if (e.getSource() == mntmObsequios) {
			actionPerformedMntmObsequios(e);
		}
		if (e.getSource() == mntmDescuentos) {
			actionPerformedMntmDescuentos(e);
		}
		if (e.getSource() == mntmReportes) {
			actionPerformedMntmReportes(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmListar) {
			actionPerformedMntmListar(e);
		}
		if (e.getSource() == mntmModificar) {
			actionPerformedMntmModificar(e);
		}
		if (e.getSource() == mntmConsultar) {
			actionPerformedMntmConsultar(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedMntmConsultar(ActionEvent e) {
		DialogConsultar dc;
		dc = new DialogConsultar();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
		
	}
	protected void actionPerformedMntmModificar(ActionEvent e) {
		DialogModificar dm;
		dm = new DialogModificar();
		dm.setLocationRelativeTo(this);
		dm.setVisible(true);
	}
	protected void actionPerformedMntmListar(ActionEvent e) {
		DialogListar dl;
		dl = new DialogListar();
		dl.setLocationRelativeTo(this);
		dl.setVisible(true);
	}
	protected void actionPerformedMntmVender(ActionEvent e) {
		DialogVender dv;
		dv = new DialogVender();
		dv.setLocationRelativeTo(this);
		dv.setVisible(true);
	}
	protected void actionPerformedMntmReportes(ActionEvent e) {
		DialogReporte dr;
		dr = new DialogReporte();
		dr.setLocationRelativeTo(this);
		dr.setVisible(true);	
	}
	protected void actionPerformedMntmDescuentos(ActionEvent e) {
		DialogDescuento dd;
		dd = new DialogDescuento();
		dd.setLocationRelativeTo(this);
		dd.setVisible(true);
	}		
	protected void actionPerformedMntmObsequios(ActionEvent e) {
		DialogObsequio dob;
		dob = new DialogObsequio();
		dob.setLocationRelativeTo(this);
		dob.setVisible(true);
	}
	protected void actionPerformedMntmPVendidos(ActionEvent e) {
		DialogCantidadOptima dco;
		dco = new DialogCantidadOptima();
		dco.setLocationRelativeTo(this);
		dco.setVisible(true);
	}
	protected void actionPerformedMntmPSorpresa(ActionEvent e) {
		DialogPremio dp;
		dp = new DialogPremio();
		dp.setLocationRelativeTo(this);
		dp.setVisible(true);
	}
	protected void actionPerformedMntmAcerca(ActionEvent e) {
		DialogAcercaTienda dat;
		dat = new DialogAcercaTienda();
		dat.setLocationRelativeTo(this);
		dat.setVisible(true);
	}
}
