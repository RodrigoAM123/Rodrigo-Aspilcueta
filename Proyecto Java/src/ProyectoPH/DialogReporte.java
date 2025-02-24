package ProyectoPH;

import java.awt.BorderLayout; 
import java.awt.FlowLayout;
import java.lang.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class DialogReporte extends JDialog implements ActionListener {
	public static double ImporteGeneral=0.0,precioMENOR=0.0,precioMAYOR=0.0;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JComboBox comboBox;
	private JTextArea textSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogReporte dialog = new DialogReporte();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogReporte() {
		setTitle("Generar reportes");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 600, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblReporte = new JLabel("Tipo de reporte");
			lblReporte.setBounds(10, 15, 103, 14);
			contentPanel.add(lblReporte);
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(485, 11, 89, 23);
			contentPanel.add(btnCerrar);
		}
		{
			comboBox = new JComboBox();
			comboBox.addActionListener(this);
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Modelos con venta \u00F3ptima", "Modelo con precios superiores a precio promedio", "Modelos con  precios  inferiores a precio promedio", "Precios promedio,menor y mayor"}));
			comboBox.setBounds(104, 11, 360, 22);
			contentPanel.add(comboBox);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 45, 564, 255);
			contentPanel.add(scrollPane);
			
			textSalida = new JTextArea();
			textSalida.setEditable(false);
			scrollPane.setViewportView(textSalida);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBox) {
			actionPerformedComboBox(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		textSalida.setText("");
		textSalida.requestFocus();
		dispose();
	}
	protected void actionPerformedComboBox(ActionEvent e) {
		double preciopromedio=0.0;
		int a,contador1=0,contador2=0;
		a=comboBox.getSelectedIndex();
		
		preciopromedio=(DialogModificar.precio1+DialogModificar.precio2+DialogModificar.precio3+DialogModificar.precio4+DialogModificar.precio5)/5;
		
		
		
		textSalida.setText("");
		
		 
		switch(a) {
		
		case 0:
			
			textSalida.append("VENTAS POR MODELO");
			textSalida.append("Modelo :  Confort\n");
			textSalida.append("Cantidad de ventas : "+DialogVender.acum1+"\n");
			textSalida.append("Cantidad total de paquetes vendidos : "+DialogVender.CantidadTotal1+"\n");
			textSalida.append("Importe total acumulado :  "+String.format("%.2f",DialogVender.ImporteTotal1)+"\n");
			textSalida.append("Modelo :  Secreto\n");
			textSalida.append("Cantidad de ventas : "+DialogVender.acum2+"\n");
			textSalida.append("Cantidad total de paquetes vendidos : "+DialogVender.CantidadTotal2+"\n");
			textSalida.append("Importe total acumulado :  "+String.format("%.2f",DialogVender.ImporteTotal2)+"\n");
			textSalida.append("Modelo :  Carmín\n");
			textSalida.append("Cantidad de ventas : "+DialogVender.acum3+"\n ");
			textSalida.append("Cantidad total de paquetes vendidos : "+ DialogVender.CantidadTotal3+"\n");
			textSalida.append("Importe total acumulado :  "+String.format("%.2f",DialogVender.ImporteTotal3)+"\n");
			textSalida.append("Modelo :  Pétalo\n");
			textSalida.append("Cantidad de ventas : "+DialogVender.acum4+"\n ");
			textSalida.append("Cantidad total de paquetes vendidos : "+ DialogVender.CantidadTotal4+"\n");
			textSalida.append("Importe total acumulado : "+String.format("%.2f",DialogVender.ImporteTotal4)+"\n");
			textSalida.append("Modelo :  Panda\n");
			textSalida.append("Cantidad de ventas : "+DialogVender.acum5+"\n ");
			textSalida.append("Cantidad total de paquetes vendidos : "+ DialogVender.CantidadTotal5+ "\n");
			textSalida.append("Importe total acumulado : "+ String.format("%.2f",DialogVender.ImporteTotal5)+"\n");
			
			ImporteGeneral=DialogVender.ImporteTotal1+DialogVender.ImporteTotal2+DialogVender.ImporteTotal3+DialogVender.ImporteTotal4+DialogVender.ImporteTotal5;

			textSalida.append("IMPORTE TOTAL ACUMULADO GENERAL :"+String.format("%.2f",ImporteGeneral));
			
			break;
		case 1:
			
			textSalida.append("MODELOS EN VENTE OPTIMA\n");
			if(DialogCantidadOptima.codpv<=DialogVender.CantidadTotal1 ) {
				
			
			textSalida.append("MODELO:Confort\n");
			textSalida.append("Cantidad de ventas : "+DialogVender.CantidadTotal1+"\n");}
			if(DialogCantidadOptima.codpv<=DialogVender.CantidadTotal2 ) {
				
				
				textSalida.append("MODELO:Secreto\n");
				textSalida.append("Cantidad de ventas : "+DialogVender.CantidadTotal2+"\n");}
			if(DialogCantidadOptima.codpv<=DialogVender.CantidadTotal3 ) {
				
			
				textSalida.append("MODELO:Carmín\n");
				textSalida.append("Cantidad de ventas : "+DialogVender.CantidadTotal3+"\n");}
			if(DialogCantidadOptima.codpv<=DialogVender.CantidadTotal4 ) {
				
				
				textSalida.append("MODELO:Pétalo\n");
				textSalida.append("Cantidad de ventas : "+DialogVender.CantidadTotal4+"\n");}
			if(DialogCantidadOptima.codpv<=DialogVender.CantidadTotal5 ) {
		
				textSalida.append("MODELO:Panda\n");
				textSalida.append("Cantidad de ventas : "+DialogVender.CantidadTotal5+"\n");}
				
			break;
		case 2:
			textSalida.append("MODELOS CON PRECIOS INFERIORES AL PRECIO PROMEDIO\n");
			
			if(preciopromedio>DialogModificar.precio1) {
			textSalida.append("MODELO:Confort\n");
			contador1++;
			}
			if(preciopromedio>DialogModificar.precio2) {
			textSalida.append("MODELO:Secreto\n");
			contador1++;
			}
			if(preciopromedio>DialogModificar.precio3) {
			textSalida.append("MODELO:Carmín\n");
			contador1++;
			}
			if(preciopromedio>DialogModificar.precio4) {
			textSalida.append("MODELO:Pétalo\n");
			contador1++;
			}
			if(preciopromedio>DialogModificar.precio5) {		
            textSalida.append("MODELO:Panda\n");
            contador1++;
 
            }
			textSalida.append("EL PRECIO PROMEDIO ES :  S/."+preciopromedio+"\n");
			textSalida.append("NUMERO DE MODELOS : "+contador1+"\n");
			
			break;
		case 3:
			
			textSalida.append("MODELOS CON PRECIOS SUPERIORES AL PRECIO PROMEDIO\n");
			if(preciopromedio<=DialogModificar.precio1) {
			textSalida.append("MODELO:Confort\n");
			contador2++;
			}
			if(preciopromedio<=DialogModificar.precio2) {
			textSalida.append("MODELO:Secreto\n");
			contador2++;
			}
			if(preciopromedio<=DialogModificar.precio3) {
			textSalida.append("MODELO:Carmín\n");
			contador2++;
			}
			if(preciopromedio<=DialogModificar.precio4) {
			textSalida.append("MODELO:Pétalo\n");
			contador2++;
			}
			if(preciopromedio<=DialogModificar.precio5) {
				
            textSalida.append("MODELO:Panda\n");
            contador2++;
            }
			textSalida.append("EL PRECIO PROMEDIO ES :  S/."+preciopromedio+"\n");
			textSalida.append("NUMERO DE MODELOS : "+contador2+"\n");
			break;
		case 4:
			textSalida.append("PRECIOS PROMEDIO,MENOR Y MAYOR"+"\n");
			textSalida.append("El precio promedio es ES :  S/."+preciopromedio+"\n");
				precioMENOR=preciopromedio*5;
			if (precioMENOR>DialogModificar.precio1) {
				precioMENOR=DialogModificar.precio1;
				}
			if (precioMENOR>DialogModificar.precio2) {
				precioMENOR=DialogModificar.precio2;
				}
			if (precioMENOR>DialogModificar.precio3) {
				precioMENOR=DialogModificar.precio3;
				}
			if (precioMENOR>DialogModificar.precio4) {
				precioMENOR=DialogModificar.precio4;
				}
			if (precioMENOR>DialogModificar.precio5) {
				precioMENOR=DialogModificar.precio5;
				}
				textSalida.append("El precio menor es :  S/."+precioMENOR+"soles\n");
				precioMAYOR=0.0;
			if(precioMAYOR<DialogModificar.precio1) {
				precioMAYOR=DialogModificar.precio1;
			}
			if(precioMAYOR<DialogModificar.precio2) {
				precioMAYOR=DialogModificar.precio2;
			}
			if(precioMAYOR<DialogModificar.precio3) {
				precioMAYOR=DialogModificar.precio3;
			}
			if(precioMAYOR<DialogModificar.precio4) {
				precioMAYOR=DialogModificar.precio4;
			}
			if(precioMAYOR<DialogModificar.precio5) {
				precioMAYOR=DialogModificar.precio5;
			}
				textSalida.append("El precio mayor es :  S/."+precioMAYOR+"soles\n");
		
		}
	}
}
