package controladoresypaneles.venta;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import controladoresypaneles.cliente.ControladorCliente;
import controladoresypaneles.coche.ControladorCoche;
import controladoresypaneles.concesionario.ControladorConcesionario;
import model.entities.Cliente;
import model.entities.Coche;
import model.entities.Concesionario;
import model.entities.Venta;

import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelVenta extends JPanel{

	Venta actual = null;
	
	private JPanel panel;
	private JTextField jtfId;
	private JTextField jtfFecha;
	private JTextField jtfPrecio;
	private JComboBox<Cliente> cmbIdCliente;
	private JComboBox<Concesionario> cmbIdConcesionario;
	private JComboBox<Coche> cmbIdCoche;
	
	private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");


	/**
	 * Create the application.
	 */
	public PanelVenta() {
		super();
		initialize();
		this.actual = ControladorVenta.getInstance().findPrimero();
		cargarActualEnPantalla();
	}

	/**
	 * 
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfFecha.setText("" + this.formatoFecha.format(this.actual.getFecha()));
			this.jtfPrecio.setText("" + this.actual.getPrecioVenta());
			
			//Cargar los campos de cliente
			for (int i = 0; i < this.cmbIdCliente.getItemCount(); i++) {
				
				if (this.actual.getCliente() == this.cmbIdCliente.getItemAt(i).getId()) {
					this.cmbIdCliente.setSelectedIndex(i);
				}
			}
			//Cargar los campos de fabricante
			for (int i = 0; i < this.cmbIdConcesionario.getItemCount(); i++) {
				
				if (this.actual.getConcesionario() == this.cmbIdConcesionario.getItemAt(i).getId()) {
					this.cmbIdConcesionario.setSelectedIndex(i);
				}
			}
			//Cargar los campos de coche
			for (int i = 0; i < this.cmbIdCoche.getItemCount(); i++) {
				
				if (this.actual.getCoche() == this.cmbIdCoche.getItemAt(i).getId()) {
					this.cmbIdCoche.setSelectedIndex(i);
				}
			}
			
		}
	}
	
	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
		this.actual.setId(Integer.parseInt(jtfId.getText()));
		this.actual.setCliente(((Cliente)cmbIdCliente.getSelectedItem()).getId());
		this.actual.setConcesionario(((Concesionario)cmbIdConcesionario.getSelectedItem()).getId());
		this.actual.setCoche(((Coche)cmbIdCoche.getSelectedItem()).getId());
		try { //Intentar recoger la fecha
			this.actual.setFecha(this.formatoFecha.parse(this.jtfFecha.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.actual.setPrecioVenta(Float.parseFloat(jtfPrecio.getText()));
	}
	
	/**
	 * Método utilizado para cargar todos los clientes en una lista para trabajarla en esta clase
	 */
	private void cargarDatosCliente() {
		List<Cliente> clientes = ControladorCliente.getInstance().findAll();
		
		for (Cliente cl: clientes) {
			this.cmbIdCliente.addItem(cl);
		}
	}
	/**
	 * Método utilizado para cargar todos los concesionarios en una lista para trabajarla en esta clase
	 */
	private void cargarDatosConcesionario() {
		List<Concesionario> concesionarios = ControladorConcesionario.getInstance().findAll();
		
		for (Concesionario co: concesionarios) {
			this.cmbIdConcesionario.addItem(co);
		}
	}
	/**
	 * Método utilizado para cargar todos los coches en una lista para trabajarla en esta clase
	 */
	private void cargarDatosCoche() {
		List<Coche> coches = ControladorCoche.getInstance().findAll();
		
		for (Coche c: coches) {
			this.cmbIdCoche.addItem(c);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		this.add(lblNewLabel, gbc_lblNewLabel);
		
		
		//TextField Id:
		jtfId = new JTextField();
		jtfId.setEnabled(false); //Deshabilitado
		jtfId.setEditable(false); //No editable
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		this.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre cliente:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		cmbIdCliente = new JComboBox();
		GridBagConstraints gbc_cmbIdCliente = new GridBagConstraints();
		gbc_cmbIdCliente.insets = new Insets(0, 0, 5, 0);
		gbc_cmbIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbIdCliente.gridx = 1;
		gbc_cmbIdCliente.gridy = 1;
		this.add(cmbIdCliente, gbc_cmbIdCliente);
		
		JLabel lblNewLabel_2 = new JLabel("Datos concesionario:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		cmbIdConcesionario = new JComboBox();
		GridBagConstraints gbc_cmbIdConcesionario = new GridBagConstraints();
		gbc_cmbIdConcesionario.insets = new Insets(0, 0, 5, 0);
		gbc_cmbIdConcesionario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbIdConcesionario.gridx = 1;
		gbc_cmbIdConcesionario.gridy = 2;
		this.add(cmbIdConcesionario, gbc_cmbIdConcesionario);
		
		JLabel lblNewLabel_3 = new JLabel("Datos coche:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		this.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		cmbIdCoche = new JComboBox();
		GridBagConstraints gbc_cmbIdCoche = new GridBagConstraints();
		gbc_cmbIdCoche.insets = new Insets(0, 0, 5, 0);
		gbc_cmbIdCoche.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbIdCoche.gridx = 1;
		gbc_cmbIdCoche.gridy = 3;
		this.add(cmbIdCoche, gbc_cmbIdCoche);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		this.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 4;
		this.add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Precio de venta:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		this.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfPrecio = new JTextField();
		GridBagConstraints gbc_jtfPrecio = new GridBagConstraints();
		gbc_jtfPrecio.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrecio.gridx = 1;
		gbc_jtfPrecio.gridy = 5;
		this.add(jtfPrecio, gbc_jtfPrecio);
		jtfPrecio.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		this.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnPrimero);
		
		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnAnterior);
		
		JButton btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnSiguiente);
		
		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnUltimo);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		panel.add(btnNuevo);
		panel.add(btnBorrar);
		
		cargarDatosCliente();
		cargarDatosConcesionario();
		cargarDatosCoche();
		
		this.actual = ControladorVenta.getInstance().findPrimero();
		cargarActualEnPantalla();
	}
	
	/**
	 * 
	 */
	private void guardar () {
		cargarActualDesdePantalla();
		boolean resultado = ControladorVenta.getInstance().guardar(this.actual);
		if (resultado == true && this.actual != null && this.actual.getId() > 0) {
			this.jtfId.setText("" + this.actual.getId());
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}
	
	/**
	 * Método utilizado para vaciar los campos de los JTextField para poder añadir uno nuevo
	 */
	private void vaciarCampos() {
		this.jtfId.setText("0");
		this.jtfFecha.setText("");
		this.jtfPrecio.setText("0");
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
	    	ControladorVenta.getInstance().borrar(this.actual);
	    }
	}
}
