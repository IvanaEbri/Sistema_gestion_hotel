package Interfaz;


import Datos.vhabitacion;
import Datos.vproducto;
import Logica.fhabitacion;
import Logica.fproducto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class frmProducto extends JFrame {
    private JPanel frmProducto;
    private JTextField txtidproducto;
    private JTextField txtnombre;
    private JTextArea txtdescripcion;
    private JTextField txtprecio;
    private JComboBox cbounidad;
    private JButton btncancelar;
    private JButton btnguardar;
    private JButton btnnuevo;
    private JTextField txtbuscar;
    private JButton btneliminar;
    private JButton btnsalir;
    private JLabel lblregistros;
    private JTable tablalistado;
    private JButton btnbuscar;
    private JScrollPane tablaproductos;

    private String accion = "guardar";

    public frmProducto() {

        mostrar("");
        inhabilitar();

        //codigo de listeners

        btnnuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                habilitar();
                btnguardar.setText("Guardar");
                accion="guardar";
            }
        });
        btnguardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtnombre.getText().length()==0){
                    JOptionPane.showConfirmDialog(rootPane,"Debe ingresar un nombre de producto");
                    txtnombre.requestFocus();
                    return;
                }
                if (txtprecio.getText().length()==0) {
                    JOptionPane.showConfirmDialog(rootPane, "Debe ingresar un precio por el producto");
                    txtprecio.requestFocus();
                    return;
                }

                vproducto dts = new vproducto();
                fproducto func = new fproducto();

                dts.setNombre(txtnombre.getText());
                dts.setDescripcion(txtdescripcion.getText());
                int seleccionado=cbounidad.getSelectedIndex();
                dts.setUnidad_medida((String) cbounidad.getItemAt(seleccionado));
                dts.setPrecio_venta((Double.parseDouble(txtprecio.getText())));

                if (accion.equals("guardar")){
                    if (func.insertar(dts)){
                        JOptionPane.showMessageDialog(rootPane,"El producto fue registrado satisfactoriamente");
                        mostrar("");
                        inhabilitar();
                    }
                } else if (accion.equals("editar")) {
                    dts.setIdproducto(Integer.parseInt(txtidproducto.getText()));

                    if (func.editar(dts)){
                        JOptionPane.showMessageDialog(rootPane,"El producto fue editado satisfactoriamente");
                        mostrar("");
                        inhabilitar();
                    }

                }
            }
        });

        btneliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtidproducto.getText().equals("")){
                    int confirmacion = JOptionPane.showConfirmDialog(rootPane," ¿Está seguro de eliminar el producto?","Confirmar",2);

                    //0 es que confirmo en el cuadro de dialogo por lo que busca el objeto y lo elimina
                    if (confirmacion==0){
                        fproducto func= new fproducto();
                        vproducto dts= new vproducto();

                        dts.setIdproducto(Integer.parseInt(txtidproducto.getText()));
                        func.eliminar(dts);
                        mostrar("");
                        inhabilitar();
                    }
                }
            }
        });

        btnbuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrar(txtbuscar.getText());
                inhabilitar();
            }
        });

        btncancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inhabilitar();
            }
        });

        btnsalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion= JOptionPane.showConfirmDialog(rootPane,"¿Desea salir del sistema?","Salir",2);

                if (opcion==0) {
                    frmProducto.this.dispose();
                    System.exit(0);
                }
            }
        });

        txtnombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtnombre.transferFocus();
            }
        });
        cbounidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbounidad.transferFocus();
            }
        });
        //los text adapter no poseen el metodo addactionlistener, por lo que empleará uno que espere por la tecla
        txtdescripcion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    // Enter key pressed, transfer focus to the next component
                    txtdescripcion.transferFocus();
                    e.consume(); // Consumes the Enter key event to prevent it from being added to the text area
                }
            }
        });
        txtprecio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtprecio.transferFocus();
            }
        });

        //seleccionar registros clickeandolos en la tabla
        tablalistado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                btnguardar.setText("Editar");
                habilitar();
                btneliminar.setEnabled(true);
                accion="editar";

                int fila = tablalistado.rowAtPoint(e.getPoint());

                txtidproducto.setText(tablalistado.getValueAt(fila,0).toString());
                txtnombre.setText(tablalistado.getValueAt(fila,1).toString());
                txtdescripcion.setText(tablalistado.getValueAt(fila,2).toString());
                cbounidad.setSelectedItem(tablalistado.getValueAt(fila,3).toString());
                txtprecio.setText(tablalistado.getValueAt(fila,4).toString());
            }
        });

        txtbuscar.setToolTipText("Busqueda por nombre de producto");
    }

    public static void main(String[] args) {
        frmProducto screen = new frmProducto();
        screen.setContentPane(screen.frmProducto);
        screen.setTitle("Producto");
        screen.pack();
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //funciones auxiliares
    void ocultar_columna() {
        //ocultar la columna id habitacion del listado de las mismas
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    void inhabilitar() {
        txtidproducto.setVisible(false);
        cbounidad.setEnabled(false);
        txtnombre.setEnabled(false);
        txtdescripcion.setEnabled(false);
        txtprecio.setEnabled(false);

        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);

        limpiar_data();
    }

    void habilitar() {
        txtidproducto.setVisible(false);
        cbounidad.setEnabled(true);
        txtnombre.setEnabled(true);
        txtdescripcion.setEnabled(true);
        txtprecio.setEnabled(true);

        btnguardar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);

        limpiar_data();
    }


    //tabla de registros
    void mostrar(String buscar) {
        try {
            //instancio la logica de la habitacion para pasarsela a la tabla de la interfaz
            DefaultTableModel modelo;
            fproducto func = new fproducto();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            tablalistado.getTableHeader().setReorderingAllowed(false);
            ocultar_columna();

            lblregistros.setText("Total registros: " + Integer.toString(func.totalregistros));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    private void limpiar_data(){
        txtidproducto.setText("");
        txtprecio.setText("");
        txtdescripcion.setText("");
        txtnombre.setText("");
        txtbuscar.setText("");
        cbounidad.setSelectedIndex(0);
    }
}
