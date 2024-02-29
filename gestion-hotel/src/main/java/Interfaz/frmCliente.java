package Interfaz;

import Datos.vcliente;
import Datos.vproducto;
import Logica.fcliente;
import Logica.fproducto;

import javax.swing.*;
import javax.swing.plaf.ToolTipUI;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class frmCliente extends  JFrame{
    private JPanel frmCliente;
    private JTextField txtidpersona;
    private JTextField txtnombre;
    private JButton btncancelar;
    private JButton btnguardar;
    private JButton btnnuevo;
    private JTextField txtemail;
    private JTextField txtbuscar;
    private JButton btneliminar;
    private JButton btnsalir;
    private JLabel lblregistros;
    private JScrollPane tablaclientes;
    private JTable tablalistado;
    private JButton btnbuscar;
    private JTextField txtapellido;
    private JComboBox cbotipo;
    private JTextField txtnumero;
    private JTextField txtdireccion;
    private JTextField txttelefono;
    private JTextField txtcodigo;

    private String accion = "guardar";

    public frmCliente() {

        mostrar("");
        inhabilitar();
        setIconsButtons();

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
                    JOptionPane.showConfirmDialog(getParent(),"Debe ingresar el nombre del cliente");
                    txtnombre.requestFocus();
                    return;
                }
                if (txtapellido.getText().length()==0) {
                    JOptionPane.showConfirmDialog(getParent(), "Debe ingresar el apellido del cliente");
                    txtapellido.requestFocus();
                    return;
                }
                if (txtnumero.getText().length()==0) {
                    JOptionPane.showConfirmDialog(getParent(), "Debe ingresar el número de documento del cliente");
                    txtnumero.requestFocus();
                    return;
                }
                if (txtcodigo.getText().length()==0) {
                    JOptionPane.showConfirmDialog(getParent(), "Debe ingresar el código del cliente");
                    txtcodigo.requestFocus();
                    return;
                }

                vcliente dts = new vcliente();
                fcliente func = new fcliente();

                dts.setNombre(txtnombre.getText());
                dts.setApellido(txtapellido.getText());
                int seleccionado=cbotipo.getSelectedIndex();
                dts.setTipo_documento((String) cbotipo.getItemAt(seleccionado));
                dts.setNum_documento(txtnumero.getText());
                dts.setDireccion(txtdireccion.getText());
                dts.setTelefono(txttelefono.getText());
                dts.setEmail(txtemail.getText());
                dts.setCodigo_cliente(txtcodigo.getText());

                if (accion.equals("guardar")){
                    if (func.insertar(dts)){
                        JOptionPane.showMessageDialog(getParent(),"El cliente fue registrado satisfactoriamente");
                        mostrar("");
                        inhabilitar();
                    }
                } else if (accion.equals("editar")) {
                    dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));

                    if (func.editar(dts)){
                        JOptionPane.showMessageDialog(getParent(),"El cliente fue editado satisfactoriamente");
                        mostrar("");
                        inhabilitar();
                    }

                }
            }
        });

        btneliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtidpersona.getText().equals("")){
                    int confirmacion = JOptionPane.showConfirmDialog(getParent()," ¿Está seguro de eliminar al cliente?","Confirmar",2);

                    if (confirmacion==0){
                        fcliente func= new fcliente();
                        vcliente dts= new vcliente();

                        dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));
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
                int opcion= JOptionPane.showConfirmDialog(getParent(),"¿Desea salir del sistema?","Salir",2);

                if (opcion==0) {
                    frmCliente.this.dispose();
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
        txtapellido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtapellido.transferFocus();
            }
        });
        cbotipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbotipo.transferFocus();
            }
        });
        txtnumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtnumero.transferFocus();
            }
        });
        txtdireccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtdireccion.transferFocus();
            }
        });
        txttelefono.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txttelefono.transferFocus();
            }
        });
        txtemail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtemail.transferFocus();
            }
        });
        txtcodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtcodigo.transferFocus();
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

                txtidpersona.setText(tablalistado.getValueAt(fila,0).toString());
                txtnombre.setText(tablalistado.getValueAt(fila,1).toString());
                txtapellido.setText(tablalistado.getValueAt(fila,2).toString());
                cbotipo.setSelectedItem(tablalistado.getValueAt(fila,3).toString());
                txtnumero.setText(tablalistado.getValueAt(fila,4).toString());
                txtdireccion.setText(tablalistado.getValueAt(fila,5).toString());
                txttelefono.setText(tablalistado.getValueAt(fila,6).toString());
                txtemail.setText(tablalistado.getValueAt(fila,7).toString());
                txtcodigo.setText(tablalistado.getValueAt(fila,8).toString());
            }
        });

        txtbuscar.setToolTipText("Busqueda por número de documento");
    }

    public static void main(String[] args) {
        frmCliente screen = new frmCliente();
        screen.setContentPane(screen.frmCliente);
        screen.setTitle("Cliente");
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
        txtidpersona.setVisible(false);
        cbotipo.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
        txtnumero.setEnabled(false);
        txtdireccion.setEnabled(false);
        txttelefono.setEnabled(false);
        txtemail.setEnabled(false);
        txtcodigo.setEnabled(false);

        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);

        limpiar_data();
    }

    void habilitar() {
        txtidpersona.setVisible(false);
        cbotipo.setEnabled(true);
        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);
        txtnumero.setEnabled(true);
        txtdireccion.setEnabled(true);
        txttelefono.setEnabled(true);
        txtemail.setEnabled(true);
        txtcodigo.setEnabled(true);

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
            fcliente func = new fcliente();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            tablalistado.getTableHeader().setReorderingAllowed(false);
            ocultar_columna();

            lblregistros.setText("Total registros: " + Integer.toString(func.totalregistros));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(getParent(), e);
        }
    }

    private void limpiar_data(){
        txtidpersona.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtnumero.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txttelefono.setText("");
        txtcodigo.setText("");
        txtbuscar.setText("");
        cbotipo.setSelectedIndex(0);
    }

    private void setIconsButtons(){
        ImageIcon iconEliminar = new ImageIcon("gestion-hotel/src/main/java/Files/basura.png");
        ImageIcon iconCancelar= new ImageIcon("gestion-hotel/src/main/java/Files/cancelar.png");
        ImageIcon iconGuardar= new ImageIcon("gestion-hotel/src/main/java/Files/disquete.png");
        ImageIcon iconBuscar= new ImageIcon("gestion-hotel/src/main/java/Files/lupa.png");
        ImageIcon iconNuevo= new ImageIcon("gestion-hotel/src/main/java/Files/mas.png");
        ImageIcon iconSalir= new ImageIcon("gestion-hotel/src/main/java/Files/salida.png");

        btneliminar.setIcon(iconEliminar);
        btncancelar.setIcon(iconCancelar);
        btnguardar.setIcon(iconGuardar);
        btnbuscar.setIcon(iconBuscar);
        btnnuevo.setIcon(iconNuevo);
        btnsalir.setIcon(iconSalir);
    }
}
