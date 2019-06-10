package es.studium.practicaMVC;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BajaV extends JFrame
{

	private static final long serialVersionUID = 1L;
	
	JLabel lblCliente=new JLabel("Dar de Baja Demandante:");
	static Choice choDemand=new Choice();
	
	JButton btnEliminar=new JButton("Eliminar");
	JButton btnCancelar=new JButton("Cancelar");
	
	JPanel pnlSup=new JPanel();
	JPanel pnlInf=new JPanel();
	
	public BajaV() {
		setTitle("Baja Demandante");
		setSize(350,200);
		
		pnlSup.setLayout(new GridLayout(2,1));
		pnlSup.add(lblCliente);
		lblCliente.setHorizontalAlignment(0);
		JPanel pnlCent3=new JPanel();
		pnlCent3.add(choDemand);
		pnlSup.add(pnlCent3);
		
		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnEliminar);
		pnlInf.add(btnCancelar);
		
		add(pnlSup,"North");
		add(pnlInf,"South");
		
		setLocationRelativeTo(null);
		setLocation(480, 200);
		
		setVisible(true);
	}
	
	
}
