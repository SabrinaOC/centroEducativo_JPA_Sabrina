package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JToolBar;


import model.controllers.ControladorProfesor;
import model.entities.Profesor;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





public class PanelProfesor extends JPanel {
	//creamos un panel de tipo pninfopersonal, el cual contiene los campos comunes que necesitamos
	PnInfoPersonal panelcomun = new PnInfoPersonal();
	//creamos una variable de tipo profesor para poder interactuar con la bbdd-gui
	Profesor actual = new Profesor();
	
	/**
	 * Create the panel.
	 */
	public PanelProfesor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 5, 0);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		add(toolBar, gbc_toolBar);
		
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorProfesor.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnPrimer.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorProfesor.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		btnAnterior.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnAnterior.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorProfesor.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnSiguiente.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorProfesor.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		btnUltimo.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnUltimo.png")));
		toolBar.add(btnUltimo);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		btnNuevo.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnNuevo.png")));
		toolBar.add(btnNuevo);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnGuardar.png")));
		toolBar.add(btnGuardar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		btnEliminar.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnEliminar.png")));
		toolBar.add(btnEliminar);
		
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(panelcomun, gbc_lblNewLabel);
		
		this.actual = ControladorProfesor.getInstance().findPrimero();
		cargarActualEnPantalla();
		

	}
	
	/**
	 * 
	 */
//	private void cargarDatosSexo() {
//		List<TipologiaSexo> sexos = ControladorFabricante.getInstance().findAll();
//		
//		for (TipologiaSexo s : sexos) {
//			this.panelcomun.getSexo().addItem(s);
//		}
//	}

	/**
	 * 
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			panelcomun.setId(this.actual.getId());
			panelcomun.setNombre(this.actual.getNombre());
			panelcomun.setApellido1(this.actual.getApellido1());
			panelcomun.setApellido2(this.actual.getApellido2());
			panelcomun.setDni(this.actual.getDni());
			panelcomun.setDireccion(this.actual.getDireccion());
			panelcomun.setEmail(this.actual.getEmail());
			panelcomun.setTelefono(this.actual.getTelefono());
			
			
		}
	}
	
	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
		this.actual.setId(panelcomun.getId());
		this.actual.setNombre(panelcomun.getNombre());
		this.actual.setApellido1(panelcomun.getApellido1());
		this.actual.setApellido2(panelcomun.getApellido2());
		this.actual.setDni(panelcomun.getDni());
		this.actual.setDireccion(panelcomun.getDireccion());
		this.actual.setEmail(panelcomun.getEmail());
		
	}
	
	/**
	 * 
	 */
	private void vaciarCampos() {
		this.panelcomun.setId(0);
		this.panelcomun.setNombre("");
		this.panelcomun.setApellido1("");
		this.panelcomun.setApellido2("");
		this.panelcomun.setDni("");
		this.panelcomun.setDireccion("");
		this.panelcomun.setEmail("");
		this.panelcomun.setTelefono("");
	}
	
	/**
	 * 
	 */
	private void guardar () {
		cargarActualDesdePantalla();
		boolean resultado = ControladorProfesor.getInstance().guardar(this.actual);
		if (resultado == true && this.actual != null && this.actual.getId() > 0) {
			this.panelcomun.getId();
			//this.jtfId.setText("" + this.actual.getId());
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}
	

	/**
	 * 
	 */
	private void borrar() {
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opci�n se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Desea eliminar?", "Gestión venta de coches", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	ControladorProfesor.getInstance().borrar(this.actual);
	    	//vaciamos campos y mostramos mensaje de que la operación se ha realizado correctamente
		    vaciarCampos();
		    JOptionPane.showMessageDialog(null, "Eliminado correctamente");
	    }
	    
	}
}
