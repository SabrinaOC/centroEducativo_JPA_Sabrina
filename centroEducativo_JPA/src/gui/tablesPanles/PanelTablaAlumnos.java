package gui.tablesPanles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.PanelEstudiante;
import model.controllers.ControladorEstudiante;
import model.entities.Estudiante;

import java.awt.GridBagConstraints;

public class PanelTablaAlumnos extends JPanel {
	
	private Estudiante estSelec;
	private List<Estudiante> list = new ArrayList();

	/**
	 * Create the panel.
	 */
	public PanelTablaAlumnos() {
		//cargo en una lista todos los alumnos
		list = ControladorEstudiante.getInstance().findAll();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		//creamos tabla
		JTable tabla = new JTable(DatosDeTabla.getDatosDeTabla(), DatosDeTabla.getTitulosColumnas());

		//añadimos tabla al scrollpane
		JScrollPane scrollPane = new JScrollPane(tabla);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		// Accedemos a los clics realizados sobre la tabla
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//guardamos el índice seleccionado para cargar estudiante 
				int indiceFilaSel = tabla.getSelectedRow();
				//System.out.println("Clic en JTAble: " + DatosDeTabla.getDatosDeTabla()[indiceFilaSel][2]);
				estSelec = list.get(indiceFilaSel);
				//System.out.println("BBDD: " + list.get(indiceFilaSel));
				
				//creamos jframe para mostrar alumno seleccionado
				JFrame ventanaAlu = new JFrame("Datos alumno");
				ventanaAlu.setBounds(100, 100, 600, 350);
				PanelEstudiante pnlEst = new PanelEstudiante(estSelec);
				
				ventanaAlu.add(pnlEst);
				ventanaAlu.setVisible(true);
			}
		});

	}

}
