package es.studium.practicaMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class PracticaC implements WindowListener, ActionListener
{
	PracticaV objVista=null;
	BajaV bajav=null;
	ModificacionV modificacionv=null;
	EdicionOfertaV edicionofertav=null;
	ConsultaOfertasV consultaofertasv=null;
	AltaAsignacionV altaasignacionv=null;
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/practicamvc?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "Studium2018;";
	Statement statement = null;
	ResultSet rs = null;
	Connection connection = null;
	
	public PracticaC(PracticaV objVista) {
		this.objVista=objVista;
		
		try
		{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Se ha producido un error al cargar el Driver");
		}
		//ESTABLECER CONEXION CON BASE DE DATOS
		try
		{
			connection = DriverManager.getConnection(url, login, password);
		}
		catch(SQLException e)
		{
			System.out.println("Se produjo un error al conectar a la Base de Datos");
		}
		
		objVista.mniDemandantesBaja.addActionListener(this);
		objVista.mniOfertasMod.addActionListener(this);
		objVista.mniOfertasCons.addActionListener(this);
		objVista.mniGestionAlta.addActionListener(this);
		objVista.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(objVista.mniDemandantesBaja.equals(arg0.getSource())) {
			bajav=new BajaV();
			
			//PREPARAR EL STATEMENT
			try
			{
				statement=connection.createStatement();
				rs=statement.executeQuery("SELECT * FROM demandantes");
				BajaV.choDemand.add("Elige uno...");
				String idDemandante="";
				String nombreDemandante="";
				String apellidosDemandante="";
				while (rs.next())
				{
					idDemandante=rs.getString("idDemandante");
					nombreDemandante=rs.getString("nombreDemandante");
					apellidosDemandante=rs.getString("apellidosDemandante");
					BajaV.choDemand.add("id: "+idDemandante+" - "+nombreDemandante+" "+apellidosDemandante);
				}
			}
			catch(SQLException e)
			{
				System.out.println("Error en la sentencia SQL");
			}
			bajav.btnCancelar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					bajav.setVisible(false);
				}
			});
			bajav.btnEliminar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String select = BajaV.choDemand.getSelectedItem();
					String[] select_splited = select.split(" ");
					String id = select_splited[1];
					System.out.println(id);
					
					try
					{
						String cadena= ("DELETE FROM demandantes WHERE idDemandante="+id+";");

						statement=connection.createStatement();
						statement.executeUpdate(cadena);
						
						BajaV.choDemand.removeAll();
						BajaV.choDemand.add("Elige uno...");
						
						try
						{
							statement=connection.createStatement();
							rs=statement.executeQuery("SELECT * FROM demandantes");
							BajaV.choDemand.add("Elige uno...");
							String idDemandante="";
							String nombreDemandante="";
							String apellidosDemandante="";
							while (rs.next())
							{
								idDemandante=rs.getString("idDemandante");
								nombreDemandante=rs.getString("nombreDemandante");
								apellidosDemandante=rs.getString("apellidosDemandante");
								BajaV.choDemand.add("id: "+idDemandante+" - "+nombreDemandante+" "+apellidosDemandante);
							}
						}
						catch(SQLException arg0)
						{
							System.out.println("Error en la sentencia SQL");
						}
					}
					catch(SQLException arg0)
					{
						System.out.println("Error en la sentencia SQL 2");
					}
					
					
				}
			});
						
			bajav.setVisible(true);
		}else if(objVista.mniOfertasMod.equals(arg0.getSource())) {
			modificacionv=new ModificacionV();
			
			//PREPARAR EL STATEMENT
			try
			{
				statement=connection.createStatement();
				rs=statement.executeQuery("SELECT * FROM ofertas");
				ModificacionV.choCliente.add("Elige uno...");
				String idOferta="";
				String requisitosOferta="";
				
				while (rs.next())
				{
					idOferta=rs.getString("idOferta");
					requisitosOferta=rs.getString("requisitosOferta");
					
					
					ModificacionV.choCliente.add("id: "+idOferta+" - "+requisitosOferta);
				}
			}
			catch(SQLException e)
			{
				System.out.println("Error en la sentencia SQL");
			}
			
			
			modificacionv.btnEditar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String select = ModificacionV.choCliente.getSelectedItem();
					String[] select_splited = select.split(" ");
					String id = select_splited[1];
					
					edicionofertav=new EdicionOfertaV();
					edicionofertav.lblResOferta.setText(id);
					try
					{
						statement=connection.createStatement();
						rs=statement.executeQuery("SELECT * FROM ofertas where idOferta="+id+";");
						
						if(rs.next()) {
						String fechaOferta=rs.getString("fechaOferta");
						String fechaFinOferta=rs.getString("fechaFinOferta");
						String requisitosOferta=rs.getString("requisitosOferta");
												
						edicionofertav.txtFecha.setText(fechaOferta);
						edicionofertav.txtFechaFin.setText(fechaFinOferta);
						edicionofertav.txtReq.setText(requisitosOferta);
						}else {
							JOptionPane.showMessageDialog(null, "Error: Datos no validos ","Modificacion Incorrecta",JOptionPane.WARNING_MESSAGE);
						}
						
					}
					catch(SQLException arg0)
					{
						System.out.println("Error en la sentencia SQL");
					}
					
					edicionofertav.btnAct.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							String fechaOferta=edicionofertav.txtFecha.getText();
							String fechaFinOferta=edicionofertav.txtFechaFin.getText();
							String requisitosOferta=edicionofertav.txtReq.getText()	;				
							
							try
							{
								String cadena= ("UPDATE ofertas SET fechaOferta='"+fechaOferta+"', fechaFinOferta='"+fechaFinOferta+"', requisitosOferta='"+requisitosOferta+"' WHERE idOferta="+
										id+";");
								
								statement=connection.createStatement();
								statement.executeUpdate(cadena);
								
								
								try
								{
									statement=connection.createStatement();
									rs=statement.executeQuery("SELECT * FROM ofertas");
									ModificacionV.choCliente.removeAll();
									ModificacionV.choCliente.add("Elige uno...");
									String idOferta="";
									requisitosOferta="";
									
									while (rs.next())
									{
										idOferta=rs.getString("idOferta");
										requisitosOferta=rs.getString("requisitosOferta");
										
										
										ModificacionV.choCliente.add("id: "+idOferta+" - "+requisitosOferta);
									}
								}
								catch(SQLException arg0)
								{
									System.out.println("Error en la sentencia SQL");
								}
		
								
								
							}
							catch(SQLException arg0)
							{
								System.out.println("Error en la sentencia SQL");
							}
							edicionofertav.setVisible(false);
							
						}
					});
					
					
				}
			});
			modificacionv.btnCancelar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ModificacionV.choCliente.removeAll();
					modificacionv.setVisible(false);
				}
			});
			
			modificacionv.setVisible(true);
		}else if(objVista.mniOfertasCons.equals(arg0.getSource())) {
			
			//PREPARAR EL STATEMENT
			try
			{
				statement=connection.createStatement();
				rs=statement.executeQuery("SELECT * FROM asignaciones");
				String idOferta="";
				String idDemandante="";
				String fechaAsignacion="";
				
				int i=0;
				int x=0;
				
				while (rs.next())
				{
					idOferta=rs.getString("idOfertaFK");
					idDemandante=rs.getString("idDemandanteFK");
					fechaAsignacion=rs.getString("fechaAsignacion");
					
					ConsultaOfertasV.data[x][i]=idOferta;
					i++;
					ConsultaOfertasV.data[x][i]=idDemandante;
					i++;
					ConsultaOfertasV.data[x][i]=fechaAsignacion;
					i=0;
					x++;
				}
			}
			catch(SQLException e)
			{
				System.out.println("Error en la sentencia SQL");
			}
			
			consultaofertasv=new ConsultaOfertasV();
			
			consultaofertasv.btnAceptar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					consultaofertasv.setVisible(false);
				}
			});
			
			consultaofertasv.setVisible(true);
		}else if(objVista.mniGestionAlta.equals(arg0.getSource())) {
			altaasignacionv=new AltaAsignacionV();
			
			//PREPARAR EL STATEMENT
			try
			{
				statement=connection.createStatement();
				rs=statement.executeQuery("SELECT * FROM ofertas");
				altaasignacionv.choOferta.add("Elige uno...");
				String idOferta="";
				
				while (rs.next())
				{
					idOferta=rs.getString("idOferta");
	
					altaasignacionv.choOferta.add("id: "+idOferta);
					
					
				}
			}
			catch(SQLException e)
			{
				System.out.println("Error en la sentencia SQL");
			}
			
			try
			{
				statement=connection.createStatement();
				rs=statement.executeQuery("SELECT * FROM demandantes");
				altaasignacionv.choDemandante.add("Elige uno...");
				String idDemandante="";
				
				while (rs.next())
				{
					idDemandante=rs.getString("idDemandante");
	
					altaasignacionv.choDemandante.add("id: "+idDemandante);
					
					
				}
			}
			catch(SQLException e)
			{
				System.out.println("Error en la sentencia SQL");
			}
			
			altaasignacionv.btnAcpt.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					String selectO = altaasignacionv.choOferta.getSelectedItem();
					String[] select_splitedO = selectO.split(" ");
					String idO = select_splitedO[1];
					System.out.println(idO);
					
					String selectD = altaasignacionv.choDemandante.getSelectedItem();
					String[] select_splitedD = selectD.split(" ");
					String idD = select_splitedD[1];
					System.out.println(idD);
					
					altaasignacionv.btnAcpt.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							String fechaOferta=altaasignacionv.txtFecha.getText();
							
							
							try
							{
								String cadena= ("insert into asignaciones(fechaAsignacion, idOfertaFK, idDemandanteFK) values('"+fechaOferta+"',"+idO+","+idD+");");
								
								statement=connection.createStatement();
								statement.executeUpdate(cadena);
								altaasignacionv.setVisible(false);
							}
							catch(SQLException arg0)
							{
								System.out.println("Error en la sentencia SQL");
							}
							
							
						}
					});
					
					
				}
			});
			
			altaasignacionv.setVisible(true);
		}
		
	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
