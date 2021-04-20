package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JToolBar;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.ImageIcon;





public class PanelProfesor extends JPanel {
	
	PnInfoPersonal panelcomun = new PnInfoPersonal();
	
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
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnPrimer.png")));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnAnterior.png")));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnSiguiente.png")));
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnUltimo.png")));
		toolBar.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnNuevo.png")));
		toolBar.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnGuardar.png")));
		toolBar.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon(PanelProfesor.class.getResource("/gui/iconos/btnEliminar.png")));
		toolBar.add(btnNewButton_6);
		
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(panelcomun, gbc_lblNewLabel);
		
		
		

	}

}
