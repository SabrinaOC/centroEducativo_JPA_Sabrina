package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;


import javax.swing.JButton;
import javax.swing.JScrollPane;

import model.controllers.ControladorEstudiante;
import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;
import model.controllers.ControladorValoracionMateria;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelValoracionMateria extends JPanel {

	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	JScrollPane scrollPane;

	private ValoracionMateria actual;
	private List<Estudiante> estudiantes;
	private List<PanelEspecialMateria> listaPaneles;
	private Profesor profActual;
	private Materia matActual;
	private final JButton btnGuardar = new JButton("Guardar");

	/**
	 * Create the panel.
	 */
	public PanelValoracionMateria() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 85, 233, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.gridwidth = 2;
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
		gbc_jcbProfesor.gridwidth = 2;
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		add(jcbProfesor, gbc_jcbProfesor);

		// cargamos todos los profesores y materias en los combo box
		cargarDatosMaterias();
		cargarDatosProfesores();

		// cargamos el primer resultado en actual
		this.actual = ControladorValoracionMateria.getInstance().findPrimero();
		
				JButton btnNewButton_1 = new JButton("Buscar");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cargarActualDesdePantalla();
						
						System.out.println("Profesor: " + profActual.getNombre() + "\nMateria: " + matActual.getNombre());

						// Al darle a este botón hay que crear en el scroll pane diversos paneles
						// (estidiante, profesor, materia)
						creacionPanelesBusqueda();
					}
				});
				GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
				gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton_1.gridx = 4;
				gbc_btnNewButton_1.gridy = 1;
				add(btnNewButton_1, gbc_btnNewButton_1);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnGuardar.gridx = 4;
		gbc_btnGuardar.gridy = 5;
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		add(btnGuardar, gbc_btnGuardar);

		// mostramos datos en pantalla
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
			// cargamos profesores
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
		//cargamos desde pantalla el elemendo del jcombo box elegido
		Profesor p = (Profesor) jcbProfesor.getSelectedItem();
		this.actual.setProfesor(p);
		//cargamos el profesor seleccionado en nuestra variable profesor actual
		this.profActual = this.actual.getProfesor();
		//hacemos lo mismo con las materias
		Materia m = (Materia) jcbMateria.getSelectedItem();
		this.actual.setMateria(m);
		this.matActual = this.actual.getMateria();
	}

	/**
	 * Método para crear paneles scroll pane
	 */
	public void creacionPanelesBusqueda() {

		// guardamos todos los estudiantes en una lista
		estudiantes = ControladorEstudiante.getInstance().findAll();

		// creamos el panel que contendrá a todos los paneles especiales materia
		// y que añadiremos al scrollpane
		JPanel pnl = new JPanel();
		// recorremos la lista para crear tantos paneles como elementos
		for (Estudiante e : estudiantes) {
			System.out.println("Estudiante: " + e.getNombre());
			PanelEspecialMateria pnlAluNota = new PanelEspecialMateria(e, this.matActual, this.profActual);
			
			

			// añadimos los paneles a la lista de paneles
			listaPaneles.add(pnlAluNota);
		}

		for (int i = 0; i < listaPaneles.size()-1; i++) {

			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = i;
		}

		this.scrollPane.setViewportView(pnl);
		this.scrollPane.revalidate();
		this.scrollPane.repaint();


	}
	
	/**
	 * 
	 */
	private void guardar() {
		// cargarActualDesdePantalla();
		for (int i = 0; i < listaPaneles.size() - 1; i++) {

			//cargo en actual todos los datos que necesito para guardar en bbdd
			this.actual.setEstudiante(listaPaneles.get(i).getEstudiante());
			this.actual.setProfesor(listaPaneles.get(i).getProfesor());
			this.actual.setMateria(listaPaneles.get(i).getMateria());
			
			boolean resultado = ControladorValoracionMateria.getInstance().guardar(this.actual);
			if (resultado == true && this.actual != null && this.actual.getId() > 0) {
				this.actual.getId();
				// this.jtfId.setText("" + this.actual.getId());
				JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "Error al guardar registro " + this.actual.getEstudiante().getApellido1()
						+ " " + this.actual.getEstudiante().getApellido2() + ", " + this.actual.getEstudiante().getNombre());
			}
		}

	}
}
