package Interfaz;

import Logica.fhabitacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmHabitacion {

    private JTextField txtidhabitacion;
    private JTextField txtnumero;
    private JTextArea txtdescripcion;
    private JComboBox cbopiso;
    private JTextArea txtcaracteristicas;
    private JTextField txtpreciodiario;
    private JComboBox cboestado;
    private JComboBox cbotipohab;
    private JButton btncancelar;
    private JButton btnnuevo;
    private JButton btnguardar;
    private JTable tablalistado;
    private JTextField txtbuscar;
    private JButton btnsalir;
    private JButton btneliminar;
    private JButton btnbuscar;
    private JLabel lbltotalregistros;
    private String accion="guardar";

    private void createUIComponents() {

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
                    JOptionPane.showConfirmDialog(btnguardar,"Debe ingresar un número de habitación");
                    txtnumero.requestFocus();
                    return;
                } else if (txtpreciodiario.getText().length()==0){
                    JOptionPane.showConfirmDialog(btnguardar,"Debe ingresar un precio diario por la habitación");
                    txtpreciodiario.requestFocus();
                }
            }
        });
    }

    public void mostrarInterfaz(){
        JFrame frame = new JFrame("Habitacion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 600);

        createUIComponents();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmHabitacion ventana = new frmHabitacion();
                ventana.mostrarInterfaz(); // Llama a createUIComponents en la instancia de la clase
            }
        });
    }



    //funciones auxiliares
    void ocultar_columna(){
        //ocultar la columna id habitacion del listado de las mismas
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    void inhabilitar(){
        txtidhabitacion.setVisible(false); //que no se vea el cuadro de id habitacion
        cbopiso.setEnabled(false);
        txtnumero.setEnabled(false);
        txtdescripcion.setEnabled(false);
        txtcaracteristicas.setEnabled(false);
        txtpreciodiario.setEnabled(false);
        cboestado.setEnabled(false);
        cbotipohab.setEnabled(false);

        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);

        txtidhabitacion.setText("");
        txtpreciodiario.setText("");
        txtdescripcion.setText("");
        txtcaracteristicas.setText("");
    }

    void habilitar(){
        txtidhabitacion.setVisible(false);
        cbopiso.setEnabled(true);
        txtnumero.setEnabled(true);
        txtdescripcion.setEnabled(true);
        txtcaracteristicas.setEnabled(true);
        txtpreciodiario.setEnabled(true);
        cboestado.setEnabled(true);
        cbotipohab.setEnabled(true);

        btnguardar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);

        txtidhabitacion.setText("");
        txtpreciodiario.setText("");
        txtdescripcion.setText("");
        txtcaracteristicas.setText("");
    }


    //funcionamiento y objetos

    //tabla de registros
    void mostrar(String buscar){
        try {
            //instancio la logica de la habitacion para pasarsela a la tabla de la interfaz
            DefaultTableModel modelo;
            fhabitacion func= new fhabitacion();
            modelo=func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columna();
            lbltotalregistros.setText("Total registros: "+Integer.toString(func.totalregistros));
        } catch (Exception e){
            JOptionPane.showConfirmDialog(null,e);
        }
    }

    //boton nuevo


}
