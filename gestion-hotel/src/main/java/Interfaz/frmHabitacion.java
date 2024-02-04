package Interfaz;

import Datos.vhabitacion;
import Logica.fhabitacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class frmHabitacion extends JFrame {
    private JPanel frmHabitacion;
    private JTable tablalistado;
    private JTextField txtbuscar;
    private JButton btnbuscar;
    private JButton btneliminar;
    private JButton btnsalir;
    private JTextField txtidhabitacion;
    private JTextField txtnumero;
    private JComboBox cbopiso;
    private JTextArea txtdescripcion;
    private JTextArea txtcaracteristicas;
    private JTextField txtprecio;
    private JComboBox cboestado;
    private JComboBox cbotipo;
    private JButton btncancelar;
    private JButton btnguardar;
    private JButton btnnuevo;
    private JLabel lblregistros;

    private String accion = "guardar";

    public frmHabitacion() {

        mostrar("");
        inhabilitar();

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
                if (txtnumero.getText().length()==0){
                    JOptionPane.showConfirmDialog(rootPane,"Debe ingresar un número de habitación");
                    txtnumero.requestFocus();
                    return;
                }
                if (txtprecio.getText().length()==0) {
                    JOptionPane.showConfirmDialog(rootPane, "Debe ingresar un precio por la habitación");
                    txtprecio.requestFocus();
                    return;
                }

                //instancio las clases
                vhabitacion dts = new vhabitacion();
                fhabitacion func = new fhabitacion();

                //asigno los valores a caba propiedad
                dts.setNumero(txtnumero.getText());

                int seleccionado=cbopiso.getSelectedIndex();
                dts.setPiso((String) cbopiso.getItemAt(seleccionado));

                dts.setDescripcion(txtdescripcion.getText());
                dts.setCaracteristicas(txtcaracteristicas.getText());

                dts.setPrecio_diario((Double.parseDouble(txtprecio.getText())));

                seleccionado= cboestado.getSelectedIndex();
                dts.setEstado((String) cboestado.getItemAt(seleccionado));

                seleccionado= cbotipo.getSelectedIndex();
                dts.setTipo_habitacion((String) cbotipo.getItemAt(seleccionado));

                //si la accion es guardar un nuevo registro guarda y mmuestra mensaje (retornará false si hubo un problema)
                if (accion.equals("guardar")){
                    if (func.insertar(dts)){
                        JOptionPane.showMessageDialog(rootPane,"La habitación fue registrada satisfactoriamente");
                        mostrar("");
                        inhabilitar();
                    }
                //y si la accion es editar
                } else if (accion.equals("editar")) {
                    dts.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));

                    if (func.editar(dts)){
                        JOptionPane.showMessageDialog(rootPane,"La habitación fue editada satisfactoriamente");
                        mostrar("");
                        inhabilitar();
                    }

                }
            }
        });

        btneliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //si el id es distinto a vacio consulto si quiere eliminar
                if (!txtidhabitacion.getText().equals("")){
                    int confirmacion = JOptionPane.showConfirmDialog(rootPane," ¿Está seguro de eliminar la habitación ?","Confirmar",2);

                    //0 es que confirmo en el cuadro de dialogo por lo que busca el objeto y lo elimina
                    if (confirmacion==0){
                        fhabitacion func= new fhabitacion();
                        vhabitacion dts= new vhabitacion();

                        dts.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
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
                mostrar(txtbuscar.getText()); //muestra segun lo buscado en la caja de texto
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
                    frmHabitacion.this.dispose();
                    System.exit(0);
                }
            }
        });

        //funciones para pasar a siguiente casilla con enter en el formulario
        txtnumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtnumero.transferFocus();
            }
        });
        cbopiso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbopiso.transferFocus();
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
        txtcaracteristicas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    txtcaracteristicas.transferFocus();
                    e.consume();
                }
            }
        });
        txtprecio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtprecio.transferFocus();
            }
        });
        cboestado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cboestado.transferFocus();
            }
        });
        cbotipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbotipo.transferFocus();
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

                txtidhabitacion.setText(tablalistado.getValueAt(fila,0).toString());
                txtnumero.setText(tablalistado.getValueAt(fila,1).toString());
                cbopiso.setSelectedItem(tablalistado.getValueAt(fila,2).toString());
                txtdescripcion.setText(tablalistado.getValueAt(fila,3).toString());
                txtcaracteristicas.setText(tablalistado.getValueAt(fila,4).toString());
                txtprecio.setText(tablalistado.getValueAt(fila,5).toString());
                cboestado.setSelectedItem(tablalistado.getValueAt(fila,6).toString());
                cbotipo.setSelectedItem(tablalistado.getValueAt(fila,7).toString());
            }
        });


    }

    public static void main(String[] args) {
        frmHabitacion screen = new frmHabitacion();
        screen.setContentPane(screen.frmHabitacion);
        screen.setTitle("Habitación");
        screen.setBounds(100, 150, 1200, 500);
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
        txtidhabitacion.setVisible(false); //que no se vea el cuadro de id habitacion
        cbopiso.setEnabled(false);
        txtnumero.setEnabled(false);
        txtdescripcion.setEnabled(false);
        txtcaracteristicas.setEnabled(false);
        txtprecio.setEnabled(false);
        cboestado.setEnabled(false);
        cbotipo.setEnabled(false);

        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);

        limpiar_data();
    }

    void habilitar() {
        txtidhabitacion.setVisible(false);
        cbopiso.setEnabled(true);
        txtnumero.setEnabled(true);
        txtdescripcion.setEnabled(true);
        txtcaracteristicas.setEnabled(true);
        txtprecio.setEnabled(true);
        cboestado.setEnabled(true);
        cbotipo.setEnabled(true);

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
            fhabitacion func = new fhabitacion();
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
        txtidhabitacion.setText("");
        txtprecio.setText("");
        txtdescripcion.setText("");
        txtcaracteristicas.setText("");
        txtnumero.setText("");
        txtbuscar.setText("");
        cbopiso.setSelectedIndex(0);
        cbotipo.setSelectedIndex(0);
        cboestado.setSelectedIndex(0);
    }
}