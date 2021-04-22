package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import model.entities.Tipologiasexo;

import java.awt.Insets;
import javax.swing.JComboBox;

public class PnInfoPersonal extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JComboBox jcbSexo;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	
//	private int id, telefono;
//	private String nombre, apellido1, apellido2, dni, direccion, email;
//	private String sexo;

	/**
	 * Create the panel.
	 */
	public PnInfoPersonal() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(" Primer pellido:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfApellido1 = new JTextField();
		jtfApellido1.setText("");
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 2;
		add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Segundo apellido:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfApellido2 = new JTextField();
		jtfApellido2.setText("");
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 3;
		add(jtfApellido2, gbc_jtfApellido2);
		jtfApellido2.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 4;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jcbSexo = new JComboBox();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 0);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 4;
		add(jcbSexo, gbc_jcbSexo);
		
		JLabel lblNewLabel_4 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Dirección:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfDireccion = new JTextField();
		jtfDireccion.setText("");
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 6;
		add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfEmail = new JTextField();
		jtfEmail.setText("");
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 7;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 8;
		add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);

	}

	public int getId() {
		return Integer.parseInt(this.jtfId.getText());
	}

	public void setId(int id) {
		this.jtfId.setText("" + id);;
	}

	public String getTelefono() {
		return this.jtfTelefono.getText();
	}

	public void setTelefono(String telefono) {
		this.jtfTelefono.setText(telefono);;
	}

	public String getNombre() {
		return this.jtfNombre.getText();
	}

	public void setNombre(String nombre) {
		this.jtfNombre.setText(nombre);;
	}

	public String getApellido1() {
		return this.jtfApellido1.getText();
	}

	public void setApellido1(String apellido1) {
		this.jtfApellido1.setText(apellido1);;
	}

	public String getApellido2() {
		return this.jtfApellido2.getText();
	}

	public void setApellido2(String apellido2) {
		this.jtfApellido2.setText(apellido2);;
	}

	public String getDni() {
		return this.jtfDni.getText();
	}

	public void setDni(String dni) {
		this.jtfDni.setText(dni);;
	}

	public String getDireccion() {
		return this.jtfDireccion.getText();
	}

	public void setDireccion(String direccion) {
		this.jtfDireccion.setText(direccion);;
	}

	public String getEmail() {
		return this.jtfEmail.getText();
	}

	public void setEmail(String email) {
		this.jtfEmail.setText(email);;
	}

	public Tipologiasexo getSexo() {
		return (Tipologiasexo) this.jcbSexo.getSelectedItem();
	}

	public void setSexo(Tipologiasexo sexo) {
		this.jcbSexo.setSelectedItem(sexo);
	}

	
	
	
}
