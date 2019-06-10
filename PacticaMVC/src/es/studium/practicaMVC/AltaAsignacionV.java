package es.studium.practicaMVC;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AltaAsignacionV extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	JLabel lblFecha = new JLabel("Fecha:");
	JTextField txtFecha = new JTextField(10);
	JLabel lblFechaFin = new JLabel("Oferta:");
	Choice choOferta= new Choice();
	JLabel lblReq=new JLabel("Demandante:");
	Choice choDemandante=new Choice();
	JButton btnAcpt = new JButton("Aceptar");
	JButton btnCancelar = new JButton("Cancelar");
	
	JPanel pnlSup =new JPanel();
	JPanel pnlInf =new JPanel();
	
	public AltaAsignacionV(){
		setTitle ("Edición Oferta");
		setSize(300,200);
		//setVisible(true);
		
		pnlSup.setLayout(new GridLayout(4,2));
		pnlSup.add(lblFecha);
		lblFecha.setHorizontalAlignment(0);
		JPanel pnlSupSup =new JPanel();
		pnlSupSup.add(txtFecha);
		txtFecha.setText("AAAA-MM-DD");
		pnlSup.add(pnlSupSup);
		
		pnlSup.add(lblFechaFin);
		lblFechaFin.setHorizontalAlignment(0);
		JPanel pnlCent2=new JPanel();
		pnlCent2.add(choOferta);
		pnlSup.add(pnlCent2);
		
		pnlSup.add(lblReq);
		lblReq.setHorizontalAlignment(0);
		JPanel pnlCent3=new JPanel();
		pnlCent3.add(choDemandante);
		pnlSup.add(pnlCent3);
		
		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnAcpt);
		pnlInf.add(btnCancelar);
		
		add(pnlSup,"North");
		add(pnlInf,"South");
		
		setLocationRelativeTo(null);
		setLocation(480, 200);
//		setVisible(true);
	}
}
