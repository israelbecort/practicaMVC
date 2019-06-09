package es.studium.practicaMVC;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EdicionOfertaV extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	JLabel lblOferta = new JLabel("Oferta:");
	JLabel lblResOferta = new JLabel("15");
	JLabel lblFecha = new JLabel("Fecha:");
	JTextField txtFecha = new JTextField(10);
	JLabel lblFechaFin = new JLabel("Fecha Fin:");
	JTextField txtFechaFin= new JTextField(10);
	JLabel lblReq=new JLabel("Requisitos:");
	JTextField txtReq=new JTextField(10);
	JButton btnAct = new JButton("Actualizar");
	JButton btnCancelar = new JButton("Cancelar");
	
	JPanel pnlSup =new JPanel();
	JPanel pnlInf =new JPanel();
	
	public EdicionOfertaV(){
		setTitle ("Edición Oferta");
		setSize(300,200);
		//setVisible(true);
		
		pnlSup.setLayout(new GridLayout(4,2));
		pnlSup.add(lblOferta);
		lblOferta.setHorizontalAlignment(0);
		pnlSup.add(lblResOferta);
//		lblResOferta.setHorizontalAlignment(0);
		pnlSup.add(lblFecha);
		lblFecha.setHorizontalAlignment(0);
		JPanel pnlSupSup =new JPanel();
		pnlSupSup.add(txtFecha);
		txtFecha.setText("DD/MM/AAAA");
		pnlSup.add(pnlSupSup);
		
		pnlSup.add(lblFechaFin);
		lblFechaFin.setHorizontalAlignment(0);
		JPanel pnlCent2=new JPanel();
		pnlCent2.add(txtFechaFin);
		txtFechaFin.setText("DD/MM/AAAA");
		pnlSup.add(pnlCent2);
		
		pnlSup.add(lblReq);
		lblReq.setHorizontalAlignment(0);
		JPanel pnlCent3=new JPanel();
		pnlCent3.add(txtReq);
		txtReq.setText("Lorem ipsum...");
		pnlSup.add(pnlCent3);
		
		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnAct);
		pnlInf.add(btnCancelar);
		
		add(pnlSup,"North");
		add(pnlInf,"South");
		
		setLocationRelativeTo(null);
		setLocation(480, 200);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new EdicionOfertaV();
	}

}
