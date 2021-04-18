package controladoresypaneles.cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import controladoresypaneles.concesionario.ControladorConcesionario;
import controladoresypaneles.fabricante.ControladorFabricante;
import model.entities.Cliente;

import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;


	public class PanelClientes extends JPanel {
		
		Cliente actual = null;
		private JTextField jtfId;
		private JTextField jtfNombre;
		private JTextField jtfApellidos;
		private JTextField jtfLocalidad;
		private JTextField jtfDniNie;
		private JTextField jtfFechaNac;
		private JCheckBox jchckbxActivo;
		
		private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
		
		
		public PanelClientes() {
			super();
			initialize();
			this.actual = ControladorCliente.getInstance().findPrimero();
			cargarActualEnPantalla();
		}
		/**
		 * 
		 */
		private void cargarActualEnPantalla() {
			if (this.actual != null) {
				this.jtfId.setText("" + this.actual.getId());
				this.jtfNombre.setText("" + this.actual.getNombre());
				this.jtfApellidos.setText("" + this.actual.getApellidos());
				this.jtfLocalidad.setText("" + this.actual.getLocalidad());
				this.jtfDniNie.setText("" + this.actual.getDniNie());
				this.jtfFechaNac.setText(this.formatoFecha.format(this.actual.getFechaNac()));
				this.jchckbxActivo.setSelected(this.actual.getActivo());
			}
		}
		
		/**
		 * 
		 */
		private void cargarActualDesdePantalla() {
			this.actual.setId(Integer.parseInt(jtfId.getText()));
			this.actual.setNombre(jtfNombre.getText());
			this.actual.setApellidos(jtfApellidos.getText());
			this.actual.setLocalidad(jtfLocalidad.getText());
			this.actual.setDniNie(jtfDniNie.getText());
			try {
				this.actual.setFechaNac(this.formatoFecha.parse(this.jtfFechaNac.getText()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			this.actual.setActivo(jchckbxActivo.isSelected());
		}
		/**
		 * Create the panel.
		 * @return 
		 */
		public void initialize() {
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{0, 0, 0};
			gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			
			JLabel lblNewLabel = new JLabel("ID:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			add(lblNewLabel, gbc_lblNewLabel);
			
			jtfId = new JTextField();
			jtfId.setEnabled(false);
			jtfId.setEditable(false);
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
			
			JLabel lblNewLabel_2 = new JLabel("Apellidos:");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			jtfApellidos = new JTextField();
			GridBagConstraints gbc_jtfApellidos = new GridBagConstraints();
			gbc_jtfApellidos.insets = new Insets(0, 0, 5, 0);
			gbc_jtfApellidos.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtfApellidos.gridx = 1;
			gbc_jtfApellidos.gridy = 2;
			add(jtfApellidos, gbc_jtfApellidos);
			jtfApellidos.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Localidad:");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 3;
			add(lblNewLabel_3, gbc_lblNewLabel_3);
			
			jtfLocalidad = new JTextField();
			GridBagConstraints gbc_jtfLocalidad = new GridBagConstraints();
			gbc_jtfLocalidad.insets = new Insets(0, 0, 5, 0);
			gbc_jtfLocalidad.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtfLocalidad.gridx = 1;
			gbc_jtfLocalidad.gridy = 3;
			add(jtfLocalidad, gbc_jtfLocalidad);
			jtfLocalidad.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("DniNie:");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 4;
			add(lblNewLabel_4, gbc_lblNewLabel_4);
			
			jtfDniNie = new JTextField();
			GridBagConstraints gbc_jtfDniNie = new GridBagConstraints();
			gbc_jtfDniNie.insets = new Insets(0, 0, 5, 0);
			gbc_jtfDniNie.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtfDniNie.gridx = 1;
			gbc_jtfDniNie.gridy = 4;
			add(jtfDniNie, gbc_jtfDniNie);
			jtfDniNie.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("FechaNac:");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 0;
			gbc_lblNewLabel_5.gridy = 5;
			add(lblNewLabel_5, gbc_lblNewLabel_5);
			
			jtfFechaNac = new JTextField();
			GridBagConstraints gbc_jtfFechaNac = new GridBagConstraints();
			gbc_jtfFechaNac.insets = new Insets(0, 0, 5, 0);
			gbc_jtfFechaNac.fill = GridBagConstraints.HORIZONTAL;
			gbc_jtfFechaNac.gridx = 1;
			gbc_jtfFechaNac.gridy = 5;
			add(jtfFechaNac, gbc_jtfFechaNac);
			jtfFechaNac.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Activo:");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 0;
			gbc_lblNewLabel_6.gridy = 6;
			add(lblNewLabel_6, gbc_lblNewLabel_6);
			
			jchckbxActivo = new JCheckBox("True");
			GridBagConstraints gbc_jchckbxActivo = new GridBagConstraints();
			gbc_jchckbxActivo.insets = new Insets(0, 0, 5, 0);
			gbc_jchckbxActivo.gridx = 1;
			gbc_jchckbxActivo.gridy = 6;
			add(jchckbxActivo, gbc_jchckbxActivo);
			
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridwidth = 2;
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 7;
			add(panel, gbc_panel);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JButton btnPrimero = new JButton("<<");
			btnPrimero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actual = ControladorCliente.getInstance().findPrimero();
					cargarActualEnPantalla();
				}
			});
			panel.add(btnPrimero);
			
			JButton btnAnterior = new JButton("<");
			btnAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actual = ControladorCliente.getInstance().findAnterior(actual.getId());
					cargarActualEnPantalla();
				}
			});
			panel.add(btnAnterior);
			
			JButton btnSiguiente = new JButton(">");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actual = ControladorCliente.getInstance().findSiguiente(actual.getId());
					cargarActualEnPantalla();
				}
			});
			panel.add(btnSiguiente);
			
			JButton btnUltimo = new JButton(">>");
			btnUltimo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actual = ControladorCliente.getInstance().findUltimo();
					cargarActualEnPantalla();
				}
			});
			panel.add(btnUltimo);
			
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
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrar();
				}
			});
			panel.add(btnEliminar);
			
			
//			this.actual = ControladorCliente.getInstance().findPrimero();
//			cargarActualEnPantalla();

		}
		
		/**
		 * 
		 */
		private void guardar () {
			cargarActualDesdePantalla();
			boolean resultado = ControladorCliente.getInstance().guardar(this.actual);
			if (resultado == true && this.actual != null && this.actual.getId() > 0) {
				this.jtfId.setText("" + this.actual.getId());
				JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al guardar");
			}
		}
		
		/**
		 * 
		 */
		private void vaciarCampos() {
			this.jtfId.setText("0");
			this.jtfNombre.setText("");
			this.jtfApellidos.setText("");
			this.jtfLocalidad.setText("");
			this.jtfDniNie.setText("");
			this.jtfFechaNac.setText("");
			this.jchckbxActivo.setSelected(false);
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
		    	ControladorCliente.getInstance().borrar(this.actual);
		    }
		}
}
