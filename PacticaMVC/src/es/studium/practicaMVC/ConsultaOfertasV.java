package es.studium.practicaMVC;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ConsultaOfertasV extends JFrame
{

	private static final long serialVersionUID = 1L;


	String data[][]={ {"101","Amit","670000"},    
			{"102","Jai","780000"},    
			{"101","Sachin","700000"}};
	
	String column[]={"Oferta","NºDemandantes Asignados","Fecha Fin"}; 
	
	JTable jt=new JTable(data,column);

	//	JScrollPane scrollPane = new JScrollPane(table);


	JButton btnAceptar=new JButton ("Aceptar");

	JPanel pnlCent = new JPanel();
	JPanel pnlInf = new JPanel();

	public ConsultaOfertasV() {
		setTitle ("Consulta Ofertas");
		setSize(500,250);

		pnlCent.setLayout(new GridLayout(1,1));
		jt.setBounds(30,40,200,300);
		JScrollPane sp=new JScrollPane(jt);
		pnlCent.add(sp);


		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnAceptar);

		add(pnlCent,"Center");
		add(pnlInf,"South");

		setLocationRelativeTo(null);
		setLocation(480, 200);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new ConsultaOfertasV();
	}

}
