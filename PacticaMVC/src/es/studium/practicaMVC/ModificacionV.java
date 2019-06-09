package es.studium.practicaMVC;

import java.awt.Choice;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModificacionV extends JFrame
{
	private static final long serialVersionUID = 1L;

	JLabel lblCliente=new JLabel("Dar de Baja Demandante:");
	static Choice choCliente=new Choice();

	JButton btnEditar=new JButton("Editar");
	JButton btnCancelar=new JButton("Cancelar");

	JPanel pnlSup=new JPanel();
	JPanel pnlInf=new JPanel();

	public ModificacionV() {
		setTitle("Modificar Oferta");
		setSize(300,200);

		pnlSup.add(lblCliente);
		lblCliente.setHorizontalAlignment(0);
		JPanel pnlCent3=new JPanel();
		pnlCent3.add(choCliente);
		pnlSup.add(pnlCent3);

		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnEditar);
		pnlInf.add(btnCancelar);

		add(pnlSup,"North");
		add(pnlInf,"South");

		setLocationRelativeTo(null);
		setLocation(480, 200);

		setVisible(true);
	}
	public static void main(String[] args)
	{
		new ModificacionV();
	}
}
