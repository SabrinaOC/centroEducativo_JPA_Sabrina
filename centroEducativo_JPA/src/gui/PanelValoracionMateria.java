package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;
import model.controllers.ControladorValoracionMateria;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelValoracionMateria extends JPanel {

	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	JScrollPane scrollPane;

	private ValoracionMateria actual;
	private List<ValoracionMateria> list;

	/**
	 * Create the panel.
	 */
	public PanelValoracionMateria() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 85, 233, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		add(jcbMateria, gbc_jcbMateria);

		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		add(jcbProfesor, gbc_jcbProfesor);

		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Al darle a este botón hay que crear en el scroll pane diversos paneles
				// (estidiante, profesor, materia)
				creacionPanelesBusqueda();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 1;
		add(btnNewButton_1, gbc_btnNewButton_1);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		// cargamos todos los profesores y materias en los combo box
		cargarDatosMaterias();
		cargarDatosProfesores();
		this.actual = ControladorValoracionMateria.getInstance().findPrimero();
		cargarActualEnPantalla();

	}

	/**
	 * Método para cargar todas las materias disponibles
	 */
	private void cargarDatosMaterias() {
		List<Materia> materias = ControladorMateria.getInstance().findAll();

		for (Materia m : materias) {
			this.jcbMateria.addItem(m);
		}
	}

	/**
	 * Método para cargar todos los profesores de la bbdd
	 */
	private void cargarDatosProfesores() {
		List<Profesor> profesores = ControladorProfesor.getInstance().findAll();

		for (Profesor p : profesores) {
			this.jcbProfesor.addItem(p);
		}
	}

	/**
	 * 
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			// Carga del materia
			for (int i = 0; i < this.jcbMateria.getItemCount(); i++) {
				if (this.actual.getMateria().getId() == this.jcbMateria.getItemAt(i).getId()) {
					this.jcbMateria.setSelectedIndex(i);
				}
			}
			//cargamos profesores
			if (this.actual != null) {
				// Carga del materia
				for (int i = 0; i < this.jcbProfesor.getItemCount(); i++) {
					if (this.actual.getProfesor().getId() == this.jcbProfesor.getItemAt(i).getId()) {
						this.jcbProfesor.setSelectedIndex(i);
					}
				}
			}
		}
	}
	
	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
	
		Profesor p = (Profesor) jcbProfesor.getSelectedItem();
		this.actual.setProfesor(p);
		
		Materia m = (Materia) jcbMateria.getSelectedItem();
		this.actual.setMateria(m);
	}

	/**
	 * Método para crear paneles scroll pane
	 */
	public void creacionPanelesBusqueda() {
		//por si se cambian los datos de los jcombo box volveremos a cargar datos pero desde pantalla
		cargarActualDesdePantalla();
		System.out.println("Id profesor: " + this.actual.getProfesor().getId() + 
				" id materia:  " + this.actual.getMateria().getId());
		//recogemos en una lista los resultados de la búsqueda en la bbdd
		 list =
		 ControladorValoracionMateria.getInstance().findAlumnosProfMaterias(this.actual.getProfesor().getId(),
		 this.actual.getMateria().getId());
		 
		 System.out.println("Tamaño lista: " + list.size());
		 
		 if (list.size() != 0) {
			 for (ValoracionMateria v : list) {
				 
				 //por cada vuelta de bucle creamos un panel nuevo
				 PanelEspecialMateria panelAluNota = new PanelEspecialMateria();
				 //completamos los valores del label y textfield para que se muestran en pantalla
				 panelAluNota.setAlumno(v.getEstudiante().getNombre());
				 panelAluNota.setNotaAlumno(v.getValoracion());
				 
				 //System.out.println(this.actual.getEstudiante().getNombre() + this.actual.getValoracion());

					// añadimos el panel creado al scroll pane
					this.scrollPane.setViewportView(panelAluNota);
					this.scrollPane.revalidate();
					this.scrollPane.repaint();			 
					
				}
			 	
			 
		 } else {
			 PanelEspecialMateria panelVacio = new PanelEspecialMateria();
			 panelVacio.setAlumno("No hay coincidencias");
			 this.scrollPane.setViewportView(panelVacio);
			 this.scrollPane.revalidate();
			 this.scrollPane.repaint();
		 }
		
		
		 
//		 //creamos un bucle para crear tantos paneles cómo elementos tenga nuestra lista
//		 for (int i = 0; i < list.size(); i++) {
//			 //por cada vuelta de bucle creamos un panel nuevo
//			 PanelEspecialMateria panelAluNota = new PanelEspecialMateria();
//			 //completamos los valores del label y textfield para que se muestran en pantalla
//			 panelAluNota.setAlumno(this.actual.getEstudiante().getNombre());
//			 panelAluNota.setNotaAlumno(this.actual.getValoracion());
//			 
//			 System.out.println(this.actual.getEstudiante().getNombre() + this.actual.getValoracion());
//
//				// añadimos el panel creado al scroll pane
//				this.scrollPane.setViewportView(panelAluNota);
//				this.scrollPane.revalidate();
//				this.scrollPane.repaint();
//			
//		}

		

	}
}
