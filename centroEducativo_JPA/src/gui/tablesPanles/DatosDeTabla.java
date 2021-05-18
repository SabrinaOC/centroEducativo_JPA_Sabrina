package gui.tablesPanles;

import java.util.List;

import model.controllers.ControladorEstudiante;
import model.entities.Estudiante;



public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Nombre", "Apellido 1", "Apellido 2", "DNI", "Dirección", "Email", "Teléfono", "Sexo"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Estudiante> estudiantes = ControladorEstudiante.getInstance().findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[estudiantes.size()][getTitulosColumnas().length];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < estudiantes.size(); i++) {
			Estudiante persona = estudiantes.get(i);
			datos[i][0] = persona.getId();
			datos[i][1] = persona.getNombre();
			datos[i][2] = persona.getApellido1();
			datos[i][3] = persona.getApellido2();
			datos[i][4] = persona.getDni();
			datos[i][5] = persona.getDireccion();
			datos[i][6] = persona.getEmail();
			datos[i][7] = persona.getTelefono();
			datos[i][8] = persona.getTipologiasexo();
			//datos[i][9] = persona.getImagen();
			//datos[i][8] = persona.getColorPreferido();
		}
		
		return datos;
	}
	
	
}
