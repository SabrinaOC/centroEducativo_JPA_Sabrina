package gui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame {

	private JTabbedPane jTabbedPane = null;
	
	private static VentanaPrincipal instance = null;
	
	/**
	 * 
	 * @return
	 */
	public static VentanaPrincipal getInstance () {
		if (instance == null) {
			instance = new VentanaPrincipal();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public VentanaPrincipal() {
		super("Educación");
		this.setBounds(0, 0, 600, 400);

		this.setJMenuBar(new MenuBar());

		this.setLayout(new BorderLayout());
		this.add(getPanelPrincipal(), BorderLayout.CENTER);

		// Control del evento de cierre de ventana
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {// Clase anónima para establecer comportamiento de ventana al
			@Override // detectarse acción cierre ventana
			public void windowClosing(WindowEvent e) {
				String opciones[] = { "Aceptar", "Cancelar" };// Creamos opciones que aparecerán en ventana
				int choice = JOptionPane.showOptionDialog(null, "¿Quiere abandonar la aplicación?",
						"Abandonar aplicación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones,
						"Aceptar");
				if (choice == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}

	/**
	 * 
	 * @return
	 */
	private JTabbedPane getPanelPrincipal() {
		jTabbedPane = new JTabbedPane();
		
		jTabbedPane.add("Profesores", new PanelProfesor());
		jTabbedPane.add("Estudiantes", new PanelEstudiante());
		jTabbedPane.add("Valoración materia", new PanelValoracionMateria());
//		jTabbedPane.add("Concesionarios", new PanelConcesionario());
//		jTabbedPane.add("Ventas", new PanelVenta());
		
		return jTabbedPane;
	}
	
	
	
	
	
	/**
	 * @return the jTabbedPane
	 */
	public JTabbedPane getjTabbedPane() {
		return jTabbedPane;
	}


	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		VentanaPrincipal.getInstance().setVisible(true);
	}

}
