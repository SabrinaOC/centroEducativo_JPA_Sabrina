package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;
import model.controllers.ControladorValoracionMateria;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelNotasLista extends JPanel {

	JComboBox<Materia> jcbMateria;
	JComboBox<Profesor> jcbProfesor;
	JComboBox<Float> jcbNota;

	// Elemento JList a utilizar en el ejemplo
	private JList<Estudiante> jlstNoSelec;
	private JList<Estudiante> jlstSelec;

	// Modelo del elemento JList, necesario para que podamos c�modamente agregar y
	// eliminar elementos
	private DefaultListModel<Estudiante> listModelNoSelec = null;
	private DefaultListModel<Estudiante> listModelSelec = null;
	// Lista de todas las provincias de la BBDD, para incluir en el elemento JList
	private List<Estudiante> listaNoSelec = new ArrayList();
	private List<Estudiante> listaSelec = new ArrayList();
	// �ndice de la �ltima provincia agregada, para saber cu�l debe ser la siguiente
	// provincia a agregar
	// private int indiceProximaProvinciaParaAgregar = 0;

	/**
	 * Create the panel.
	 */
	public PanelNotasLista() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);

		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);

		JLabel lblNewLabel_2 = new JLabel("Nota:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbNota = new JComboBox();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// llamamos al método para añadir a la lista los estudiantes no seleccionados
				agregarNoSelec();
				agregarSelec();
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.EAST;
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 3;
		panel.add(btnBuscar, gbc_btnBuscar);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 6;
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_3 = new JLabel("Alumno no seleccionado");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Alumno seleccionado");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jlstNoSelec = new JList(this.getDefaultListModelNoSelect());
		this.jlstNoSelec.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JScrollPane scrollPane = new JScrollPane(jlstNoSelec);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.weightx = 0.5;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JButton btnRmvAll = new JButton("<<");
		btnRmvAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deseleccionarTodos();
			}
		});
		GridBagConstraints gbc_btnRmvAll = new GridBagConstraints();
		gbc_btnRmvAll.gridwidth = 2;
		gbc_btnRmvAll.insets = new Insets(0, 0, 5, 5);
		gbc_btnRmvAll.gridx = 0;
		gbc_btnRmvAll.gridy = 0;
		panel_2.add(btnRmvAll, gbc_btnRmvAll);

		JButton btnRmvOne = new JButton("<");
		btnRmvOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeOneFromSelectedAndAddToNoSelec();
			}
		});
		GridBagConstraints gbc_btnRmvOne = new GridBagConstraints();
		gbc_btnRmvOne.gridwidth = 2;
		gbc_btnRmvOne.insets = new Insets(0, 0, 5, 5);
		gbc_btnRmvOne.gridx = 0;
		gbc_btnRmvOne.gridy = 1;
		panel_2.add(btnRmvOne, gbc_btnRmvOne);

		JButton btnAddAll = new JButton(">>");
		btnAddAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarTodos();
			}
		});
		GridBagConstraints gbc_btnAddAll = new GridBagConstraints();
		gbc_btnAddAll.gridwidth = 2;
		gbc_btnAddAll.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddAll.gridx = 0;
		gbc_btnAddAll.gridy = 2;
		panel_2.add(btnAddAll, gbc_btnAddAll);

		JButton btnAddOne = new JButton(">");
		btnAddOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeOneFromNotSelectedAndAddToSelec();
			}
		});
		GridBagConstraints gbc_btnAddOne = new GridBagConstraints();
		gbc_btnAddOne.gridwidth = 2;
		gbc_btnAddOne.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddOne.gridx = 0;
		gbc_btnAddOne.gridy = 3;
		panel_2.add(btnAddOne, gbc_btnAddOne);

		jlstSelec = new JList(this.getDefaultListModelSelect());
		this.jlstSelec.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		// jlstSelec = new JList();
		// scrollPane_1.setViewportView(jlstSelec);

		JScrollPane scrollPane_1 = new JScrollPane(jlstSelec);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.weightx = 1.0;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 1;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 9;
		add(btnGuardar, gbc_btnGuardar);

		cargarDatosMaterias();
		cargarDatosProfesores();
		cargarNotasFl();
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
	 * Método para cargar todos las notas
	 */
	private void cargarNotasFl() {
		// List<Integer> notas;

		for (int i = 0; i < 11; i++) {
			this.jcbNota.addItem((float) i);

		}
	}

	/**
	 * Método que construye el modelo de JList, a utilizar para agregar y eliminar
	 * provincias
	 */
	private DefaultListModel getDefaultListModelNoSelect() {
		this.listModelNoSelec = new DefaultListModel<Estudiante>();
		return this.listModelNoSelec;
	}

	/**
	 * Método que construye el modelo de JList, a utilizar para agregar y eliminar
	 * provincias
	 */
	private DefaultListModel getDefaultListModelSelect() {
		this.listModelSelec = new DefaultListModel<Estudiante>();
		return this.listModelSelec;
	}

	/**
	 * Para agregar alumnos que no tienen esa nota
	 */
	private void agregarNoSelec() {
		// Para que cuando volvamos a darle a buscar no se dupliquen rsultados
		this.listModelNoSelec.clear();
		this.listaNoSelec.clear();

		Materia materia = (Materia) this.jcbMateria.getSelectedItem();
		Profesor profesor = (Profesor) this.jcbProfesor.getSelectedItem();
		float nota = (float) this.jcbNota.getSelectedItem();

		// System.out.println(materia.getId() + "profesor: " + profesor.getId() + "Nota:
		// " + nota);

		// añadimos a la lista tipo estudiante creada los resultados de la búsqueda en
		// la bbdd
		this.listaNoSelec = ControladorValoracionMateria.getInstance().findEstudiantesNotIn(materia.getId(),
				profesor.getId(), nota);
		// añadimos esta lista a nuestro list model de no seleccionados
		this.listModelNoSelec.addAll(listaNoSelec);

	}

	/**
	 * Para agregar alumnos que coinciden con esa selección
	 */
	private void agregarSelec() {

		this.listModelSelec.clear();
		this.listaSelec.clear();

		Materia materia = (Materia) this.jcbMateria.getSelectedItem();
		Profesor profesor = (Profesor) this.jcbProfesor.getSelectedItem();
		float nota = (float) this.jcbNota.getSelectedItem();

		// añadimos a la lista tipo estudiante creada los resultados de la búsqueda en
		// la bbdd
		this.listaSelec = ControladorValoracionMateria.getInstance().findByMateriaAndProfesorAndNota(materia.getId(),
				profesor.getId(), nota);
		// añadimos esta lista a nuestro list model de no seleccionados
		this.listModelSelec.addAll(listaSelec);

	}

	/**
	 * 
	 */
	private void removeOneFromNotSelectedAndAddToSelec() {

		// doble bucle primero uno para agregar a seleccionados y luego otro para
		// eliminarlos de la lista de no seleccionados
		for (int i = 0; i < this.jlstNoSelec.getSelectedIndices().length; i++) {
			this.listModelSelec.addElement(this.listModelNoSelec.getElementAt(jlstNoSelec.getSelectedIndices()[i]));
		}

		for (int i = this.jlstNoSelec.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listModelNoSelec.removeElementAt(jlstNoSelec.getSelectedIndices()[i]);
		}

	}

	/**
	 * 
	 */
	private void removeOneFromSelectedAndAddToNoSelec() {

		// doble bucle primero uno para agregar a seleccionados y luego otro para
		// eliminarlos de la lista de no seleccionados
		for (int i = 0; i < this.jlstSelec.getSelectedIndices().length; i++) {
			this.listModelNoSelec.addElement(this.listModelSelec.getElementAt(jlstSelec.getSelectedIndices()[i]));
		}

		for (int i = this.jlstSelec.getSelectedIndices().length - 1; i >= 0; i--) {
			this.listModelSelec.removeElementAt(jlstSelec.getSelectedIndices()[i]);
		}

	}

	/**
	 * 
	 */
	private void deseleccionarTodos() {

		for (int i = 0; i < listModelSelec.size(); i++) {
			this.listModelNoSelec.addElement(listModelSelec.getElementAt(i));
		}

		this.listModelSelec.clear();
	}

	/**
	 * 
	 */
	private void seleccionarTodos() {
		for (int i = 0; i < listModelNoSelec.size(); i++) {
			this.listModelSelec.addElement(listModelNoSelec.getElementAt(i));
		}

		this.listModelNoSelec.clear();
	}

	/**
	 * 
	 */
	private void guardar() {
		
		//creamos variables que necesitamos para guardar en la bbdd
		Profesor p = (Profesor)this.jcbProfesor.getSelectedItem();
		Materia m = (Materia)this.jcbMateria.getSelectedItem();
		float v = (float) this.jcbNota.getSelectedItem();
		
		
		ValoracionMateria vm = new ValoracionMateria();
		
		//variables a modo contador para registros guardados
		int regCorrectos = 0, regError = 0;
		
		for (int i = 0; i < this.listModelSelec.size(); i++) {
			
			Estudiante e = this.listModelSelec.getElementAt(i);
			
			vm = ControladorValoracionMateria.getInstance().findByAlumnoAndProfesorAndMateria(e.getId(), p.getId(), m.getId());
			
			if (vm == null) {
				//si no existe en la bbdd lo creamos y le damos valores
				vm = new ValoracionMateria();
				vm.setEstudiante(e);
				vm.setMateria(m);
				vm.setProfesor(p);
				vm.setValoracion(v);
				
			} else {
				//si existe, actualizamos sus datos
				vm.setValoracion(v);
			}
			
			Boolean resultado = ControladorValoracionMateria.getInstance().guardar(vm);
			if (resultado == true ) {
				//JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
				//si se guarda correctamente sumamos uno al contador
				regCorrectos ++;
			}
			else {
				//JOptionPane.showMessageDialog(null, "Error al guardar");
				//si da error sumamos uno al contador
				regError ++;
			}
		}
		
		//sacamos en pantalla cuantos registros se han guardado 
		JOptionPane.showMessageDialog(null, "Registros guardados correctamente: " + regCorrectos
				+ "\nError al guardar: " + regError);
		
		
	}
}
