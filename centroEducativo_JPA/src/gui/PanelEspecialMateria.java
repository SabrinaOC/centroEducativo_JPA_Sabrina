package gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.entities.ValoracionMateria;

public class PanelEspecialMateria extends JPanel {
	
	private JPanel pnlBusqueda;
	private JLabel jlblNombre;
	private JTextField jtfNota;
	private List<ValoracionMateria> list;
	
//	int idAlumno, notaAlumno;

	/**
	 * Create the panel.
	 */
	public PanelEspecialMateria() {

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
	}

	public String getAlumno() {
		return this.jlblNombre.getText();
	}

	public void setAlumno(String alumno) {
		this.jlblNombre.setText(alumno);
	}

	public float getNotaAlumno() {
		return Float.parseFloat(this.jtfNota.getText());
	}

	public void setNotaAlumno(float notaAlumno) {
		this.jtfNota.setText("" + notaAlumno);
	}
	
	

}
