package gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.controllers.ControladorValoracionMateria;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;

public class PanelEspecialMateria extends JPanel {
	
	private JPanel pnlBusqueda;
	private JLabel jlblNombre;
	private JTextField jtfNota;
	private List<ValoracionMateria> list;
	
	Estudiante estudiante;
	Profesor profesor;
	Materia materia;

	/**
	 * Create the panel.
	 */
	public PanelEspecialMateria(Estudiante estudiante, Materia materia, Profesor profesor) {

		this.estudiante = estudiante;
		this.materia = materia;
		this.profesor = profesor;
		// creamos el panel que pondremos en el scroll bar
		pnlBusqueda = new JPanel();

		// en esta tiqueta guardaremos el resultado de la búsqueda en la bbdd
		jlblNombre = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(jlblNombre, gbc_lblNewLabel_1);

		// creamos campo de texto para poner la nota
		jtfNota = new JTextField();
		GridBagConstraints gbc_jtfNota = new GridBagConstraints();
		gbc_jtfNota.insets = new Insets(0, 0, 0, 5);
		gbc_jtfNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNota.gridx = 1;
		gbc_jtfNota.gridy = 9;
		add(jtfNota, gbc_jtfNota);
		jtfNota.setColumns(10);
		
		cargarDatos(this.estudiante, this.profesor, this.materia);
	}

	public void cargarDatos(Estudiante estudiante, Profesor prof, Materia mat) {
		// si estudiante es distinto de null, poner su apellido, nombre
		if (estudiante != null) {
			this.jlblNombre.setText(this.estudiante.getApellido1() + " " + this.estudiante.getApellido2() + ", "
					+ this.estudiante.getNombre());
		}
		
		//buscar por materia, nota, profesor
		//si existe el registro, lo mostramos, si no, dejamos el espacio en blanco para guardar
		ValoracionMateria nota = ControladorValoracionMateria.getInstance().findByAlumnoAndProfesorAndMateria(estudiante.getId(),
				prof.getId(), mat.getId());
		if (nota != null) {
			this.jtfNota.setText("" + ControladorValoracionMateria.getInstance().findByAlumnoAndProfesorAndMateria(estudiante.getId(),
					prof.getId(), mat.getId()).getValoracion());
			
			System.out.println("jtfNombre: " + this.jlblNombre + "\nnota: " + nota.getValoracion()
			+ " estudiante: " + nota.getEstudiante().getNombre() + " profesor: " + nota.getProfesor().getNombre() + " materia: " + nota.getMateria().getNombre());
		}
		

		
		
		
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	

}
