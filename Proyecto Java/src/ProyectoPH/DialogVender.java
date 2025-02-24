package ProyectoPH;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class DialogVender extends JDialog implements ActionListener {

	public static double Efectivo,ImporteCompra,paquete,ImportePago=0.0,CantidadTotalUltimo=0.0,ImporteTotal1=0.0,ImporteTotal2=0.0,ImporteTotal3=0.0,
			ImporteTotal4=0.0,ImporteTotal5=0.0;
	public static int Cantidad,clientes=0,venta1=-1,venta2=-1,venta3=-1,venta4=-1,venta5=-1,acum1=0,acum2=0,acum3=0,acum4=0,acum5=0,
			CantidadTotal1=0,CantidadTotal2=0,CantidadTotal3=0,CantidadTotal4=0,CantidadTotal5=0,aux1=0,aux2=0,aux3=0,aux4=0,aux5=0,aux6=0,aux7=0
			,aux8=0,aux9=0,aux10=0;
			
	private final JPanel contentPanel = new JPanel();
	private JTextField textCantidadPaquetes;
	private JTextField textEfectivo;
	private JButton btnCerrar;
	private JButton btnVender;
	private JTextArea textArea1;
	private JComboBox cbomodelaje;
	private JScrollPane scrollPane;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogVender dialog = new DialogVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogVender() {
		setResizable(false);
		setModal(true);
		setTitle("Vender papel higi\u00E9nico");
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblModelo = new JLabel("Modelo de papel");
			lblModelo.setBounds(10, 11, 119, 14);
			contentPanel.add(lblModelo);
		}
		{
			textCantidadPaquetes = new JTextField();
			textCantidadPaquetes.setBounds(172, 40, 119, 20);
			contentPanel.add(textCantidadPaquetes);
			textCantidadPaquetes.setColumns(10);
		}
		{
			textEfectivo = new JTextField();
			textEfectivo.setBounds(172, 71, 119, 20);
			contentPanel.add(textEfectivo);
			textEfectivo.setColumns(10);
		}
		{
			JLabel lblCantidad = new JLabel("Cantidad de paquetes");
			lblCantidad.setBounds(10, 43, 152, 14);
			contentPanel.add(lblCantidad);
		}
		{
			JLabel lblEfectivo = new JLabel("Efectivo");
			lblEfectivo.setBounds(10, 74, 46, 14);
			contentPanel.add(lblEfectivo);
		}
		{
			btnVender = new JButton("Vender");
			btnVender.addActionListener(this);
			btnVender.setBounds(485, 7, 89, 23);
			contentPanel.add(btnVender);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(485, 39, 89, 23);
			contentPanel.add(btnCerrar);
		}
		{
			cbomodelaje = new JComboBox();
			cbomodelaje.addActionListener(this);
			cbomodelaje.setModel(new DefaultComboBoxModel(new String[] {"Confort", "Secreto", "Carm\u00EDn", "P\u00E9talo", "Panda"}));
			cbomodelaje.setBounds(170, 7, 121, 22);
			contentPanel.add(cbomodelaje);
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 99, 536, 131);
		contentPanel.add(scrollPane);
		
		textArea1 = new JTextArea();
		textArea1.setEditable(false);
		scrollPane.setViewportView(textArea1);
	}

	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnVender(ActionEvent e) {
		
		double Efectivo,ImporteCompra=0.0,paquete=0.0,ImporteDescuento=0.0,Vuelto=0.0,max=0.0;
		int Cantidad,model;
		model=cbomodelaje.getSelectedIndex();
		if(validacionDatos()) {
		Cantidad=Integer.parseInt(textCantidadPaquetes.getText());
		Efectivo=Double.parseDouble(textEfectivo.getText());
		textArea1.setText("");
		switch(model) {
		case 0: 
			paquete=DialogModificar.precio1;
			ImporteCompra=paquete*Cantidad;
			Obtenerdescuentos(Cantidad,ImporteCompra,ImporteDescuento);
			ImportePago=ImporteCompra-ImporteDescuento;
			if(ImportePago<=Efectivo) {
		    	 aux1++;
		    	 CantidadTotal1=Cantidad*aux1;
		    	 aux6++;
		    	 venta1++;
		    	 clientes++;
		    	 acum1=venta1+1;
				 Vuelto=Efectivo-ImportePago;
				 ImporteTotal1=ImportePago*aux6;
				 ObtenerResultados(model,paquete,Cantidad,ImporteCompra,ImportePago,ImporteDescuento,Vuelto);
				   if(DialogObsequio.cantmin<=Cantidad) {
						textArea1.append("Tu premio es : "+ DialogObsequio.obsequio+"\n");}
				   	if(clientes==DialogPremio.numClien) {
			         textArea1.append("!SORPRESA! Al ser el cliente número "+DialogPremio.numClien+" te llevas "+DialogPremio.cantChoco);}}
			     
				  else {  JOptionPane.showMessageDialog(null, "No puedes pagar con este efectivo","ERROR",
						    JOptionPane.ERROR_MESSAGE);
						    textEfectivo.setText("");
						    textCantidadPaquetes.setText("");
						    textArea1.setText("");
						    ImportePago=0;
						    textEfectivo.requestFocus();}
				break;
			     
		
			
		 case 1:
			paquete=DialogModificar.precio2;
			ImporteCompra=paquete*Cantidad;	
			Obtenerdescuentos(Cantidad,ImporteCompra,ImporteDescuento);
			ImportePago=ImporteCompra-ImporteDescuento;
			if(ImportePago<=Efectivo) {
		    	 aux2++;
		    	 CantidadTotal2=Cantidad*aux2;
		    	 aux7++;
				 venta2++;
				 clientes++;
			     acum2=venta2+1;
			     Vuelto=Efectivo-ImportePago;
			     ImporteTotal2=ImportePago*aux7;
			     ObtenerResultados(model,paquete,Cantidad,ImporteCompra,ImportePago,ImporteDescuento,Vuelto);
				   if(DialogObsequio.cantmin<=Cantidad) {
						textArea1.append("Tu premio es : "+ DialogObsequio.obsequio+"\n");}
				   	if(clientes==DialogPremio.numClien) {
			         textArea1.append("!SORPRESA! Al ser el cliente número "+DialogPremio.numClien+" te llevas "+DialogPremio.cantChoco);}}
			      else {  JOptionPane.showMessageDialog(null, "No puedes pagar con este efectivo","ERROR",
						    JOptionPane.ERROR_MESSAGE);
						    textEfectivo.setText("");
						    textCantidadPaquetes.setText("");
						    textArea1.setText("");
						    ImportePago=0;
						    textEfectivo.requestFocus();}
					break;
		 
		 case 2:
			paquete=DialogModificar.precio3;
			ImporteCompra=paquete*Cantidad;
			Obtenerdescuentos(Cantidad,ImporteCompra,ImporteDescuento);
			ImportePago=ImporteCompra-ImporteDescuento;
			if(ImportePago<=Efectivo) {
				aux3++;
				CantidadTotal3=Cantidad*aux3;
				aux8++;
				venta3++;
				clientes++;
			   acum3=venta3+1;
			   Vuelto=Efectivo-ImportePago;
			    ImporteTotal2=ImportePago*aux7;
			    ObtenerResultados(model,paquete,Cantidad,ImporteCompra,ImportePago,ImporteDescuento,Vuelto);
			   if(DialogObsequio.cantmin<=Cantidad) {
					textArea1.append("Tu premio es : "+ DialogObsequio.obsequio+"\n");}
			   	if(clientes==DialogPremio.numClien) {
		         textArea1.append("!SORPRESA! Al ser el cliente número "+DialogPremio.numClien+" te llevas "+DialogPremio.cantChoco);}}
				else {  JOptionPane.showMessageDialog(null, "Tu efectivo no alcanza","ERROR",
				    JOptionPane.ERROR_MESSAGE);
				    textEfectivo.setText("");
				    textCantidadPaquetes.setText("");
				    textArea1.setText("");
				    ImportePago=0;
				    textEfectivo.requestFocus();}
				break;
	
			   
		
			case 3:
			paquete=DialogModificar.precio4;
			ImporteCompra=paquete*Cantidad;
			Obtenerdescuentos(Cantidad,ImporteCompra,ImporteDescuento);
			ImportePago=ImporteCompra-ImporteDescuento;
			if(ImportePago<=Efectivo) {
				aux4++;
				CantidadTotal4=Cantidad*aux4;
				aux9++;
				venta4++;
				clientes++;
			    acum4=venta4+1;
			   Vuelto=Efectivo-ImportePago;
			   ImporteTotal4=ImportePago*aux9;
			   ObtenerResultados(model,paquete,Cantidad,ImporteCompra,ImportePago,ImporteDescuento,Vuelto);
				   if(DialogObsequio.cantmin<=Cantidad) {
						textArea1.append("Tu premio es : "+ DialogObsequio.obsequio+"\n");}
				if(clientes==DialogPremio.numClien) {
			         textArea1.append("!SORPRESA! Al ser el cliente número "+DialogPremio.numClien+" te llevas "+DialogPremio.cantChoco);}}
				else {  JOptionPane.showMessageDialog(null, "No puedes pagar con este efectivo","ERROR",
					    JOptionPane.ERROR_MESSAGE);
					    textEfectivo.setText("");
					    textCantidadPaquetes.setText("");
					    textArea1.setText("");
					    ImportePago=0;
					    textEfectivo.requestFocus();}
			break;
		
			case 4:
			paquete=DialogModificar.precio5;
			ImporteCompra=paquete*Cantidad;
			Obtenerdescuentos(Cantidad,ImporteCompra,ImporteDescuento);
			ImportePago=ImporteCompra-ImporteDescuento;
			if(ImportePago<=Efectivo) {
				aux5++;
				CantidadTotal5=Cantidad*aux5;
				aux10++;
				venta5++;
				clientes++;
			    acum5=venta5+1;
				Vuelto=Efectivo-ImportePago;
                ImporteTotal5=ImportePago*aux10;
                ObtenerResultados(model,paquete,Cantidad,ImporteCompra,ImportePago,ImporteDescuento,Vuelto);
			 if(DialogObsequio.cantmin<=Cantidad) {
				textArea1.append("Tu premio es : "+ DialogObsequio.obsequio+"\n");}
			 if(clientes==DialogPremio.numClien) {
	         textArea1.append("!SORPRESA! Al ser el cliente número "+DialogPremio.numClien+" te llevas "+DialogPremio.cantChoco);}}
			else { 
			 JOptionPane.showMessageDialog(null, "No puedes pagar con este efectivo","ERROR",
					    JOptionPane.ERROR_MESSAGE);
					    textEfectivo.setText("");
					    textCantidadPaquetes.setText("");
					    textArea1.setText("");
					    ImportePago=0;
					    textEfectivo.requestFocus();}
				break;}}
	}	boolean validacionDatos() {
		boolean clave=false;
		int cantid=0;
		double efecti=0.0;
		try {
			cantid=Integer.parseInt(textCantidadPaquetes.getText());
			efecti=Double.parseDouble(textEfectivo.getText());
			
			if(cantid<0) {
				JOptionPane.showMessageDialog(null, "Por favor ingresar un número entero","ERROR",
						JOptionPane.ERROR_MESSAGE);
				textCantidadPaquetes.setText("");
				textCantidadPaquetes.requestFocus();
			} else { if(efecti<0.0) {
				JOptionPane.showMessageDialog(null, "Por favor ingresar el precio","ERROR",
						JOptionPane.ERROR_MESSAGE);
				textEfectivo.setText("");
				textEfectivo.requestFocus();}
				else {
					clave = true;}
			}
			}
			catch(Exception e)
			{ if(cantid==0) {
				JOptionPane.showMessageDialog(null, "Por favor ingresar un número entero","ERROR",
						JOptionPane.ERROR_MESSAGE);
				textCantidadPaquetes.setText("");
				textCantidadPaquetes.requestFocus();
			} else { if(efecti==0) {
				JOptionPane.showMessageDialog(null, "Por favor ingresar el precio","ERROR",
						JOptionPane.ERROR_MESSAGE);
				textEfectivo.setText("");
				textEfectivo.requestFocus();}
			}
				}
	
		return clave;}
	void Obtenerdescuentos(int cant,double ImpCompra,double importdesc) {
		if(cant<6 && 1<=cant) {
			importdesc=((DialogDescuento.desc1)/100)*ImpCompra;}
		if(cant<10 && 6<=cant) {
			importdesc=((DialogDescuento.desc2)/100)*ImpCompra;}
		if(cant<15 && 11<=cant) {
			importdesc=((DialogDescuento.desc3)/100)*ImpCompra;}
		if(cant<=15) {
			importdesc=((DialogDescuento.desc1)/100)*ImpCompra;}
		
	}
	void Imprimir(String cadena) {
		textArea1.append(cadena+"\n");
	}
	void ObtenerResultados(int model,double packag,int cantid,double importcom,double importpago,double importdescu, double vuel) {
		switch(model) {
		case 0: Imprimir("El modelo es : Confort");
				break;
		case 1: Imprimir("El modelo es : Secreto");
				break;
		case 2: Imprimir("El modelo es : Carmín");
				break;
		case 3: Imprimir("El modelo es : Pétalo");
				break;
		case 4: Imprimir("El modelo es : Panda");
				break;}
				Imprimir("El precio del paquete es :"+packag);
				Imprimir("Cantidad de paquetes vendidos :"+cantid);
				Imprimir("El importe de compra es :"+ String.format("%.2f",importcom));
				Imprimir("El importe de descuento es: "+ String.format("%.2f",importdescu));
				Imprimir("El importe a pagar es : "+ String.format("%.2f",importpago));
				Imprimir("El vuelto es : "+ String.format("%.2f",vuel));
		}
		
		}
	
	
	 
                       

                       
                     

	
	
	



 
	
     
 
		



