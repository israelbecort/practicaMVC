package es.studium.practicaMVC;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PracticaV extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	// En primer lugar creamos la barra de menú
		JMenuBar barraMenu = new JMenuBar();
		// Ahora creamos los elementos principales del menú
		JMenu menuDemandantes = new JMenu("Demandantes");
		JMenu menuOfertas = new JMenu("Ofertas");
		JMenu menuGestion = new JMenu("Gestion");
		// Los siguientes son MenuItem pues dentro no tienen submenús
		JMenuItem mniDemandantesBaja = new JMenuItem("Baja");

		JMenuItem mniOfertasMod = new JMenuItem("Modificacion");
		JMenuItem mniOfertasCons = new JMenuItem("Consulta");
		
		JMenuItem mniGestionAlta = new JMenuItem("Alta");
		
		public PracticaV() {
			setTitle ("Práctica MVC" );
			
			menuDemandantes.add(mniDemandantesBaja);
			
			menuOfertas.add(mniOfertasMod);
			menuOfertas.add(mniOfertasCons);
			
			menuGestion.add(mniGestionAlta);
			
			barraMenu.add(menuDemandantes);
			barraMenu.add(menuOfertas);
			barraMenu.add(menuGestion);
			
			setJMenuBar(barraMenu);
			setLocationRelativeTo(null);
			setLocation(480, 200);
			setSize(250,200);
			setVisible(true);
		}
			

}
