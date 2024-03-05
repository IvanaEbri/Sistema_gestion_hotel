/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Datos.vconsumo;
import Logica.fconsumo;
import Logica.fproducto;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivana
 */
public class frmConsumo extends javax.swing.JInternalFrame {

    public static String idreserva;
    public static String cliente;
    
    
    /**
     * Creates new form frmConsumo
     */
    public frmConsumo() {
        initComponents();
        this.inicio();
        txtcliente.setText(cliente);
        txtidreserva.setText(idreserva);
    }

    private void inicio(){
        this.setTitle("Consumos");
        this.mostrar(idreserva);
        this.inhabilitar();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmConsumo = new javax.swing.JPanel();
        frmProducto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lblregistros = new javax.swing.JLabel();
        btneliminar = new javax.swing.JToggleButton();
        lblconsumo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JToggleButton();
        btnguardar = new javax.swing.JToggleButton();
        btncancelar = new javax.swing.JToggleButton();
        txtidconsumo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboestado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        txtidreserva = new javax.swing.JTextField();
        txtcliente = new javax.swing.JTextField();
        txtidproducto = new javax.swing.JTextField();
        txtnombreproducto = new javax.swing.JTextField();
        btnbuscaproducto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        btnsalir = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Consumo");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado Consumos"));
        jPanel2.setToolTipText("Listado Clientes");
        jPanel2.setName("Listado Clientes"); // NOI18N

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        lblregistros.setText("Registros:");

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/basura.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        lblconsumo.setText("Total:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblconsumo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblregistros))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btneliminar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btneliminar)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblregistros)
                    .addComponent(lblconsumo)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro Consumo"));
        jPanel1.setPreferredSize(new java.awt.Dimension(394, 447));

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/mas.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/disquete.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancelar.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        txtidconsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidconsumoActionPerformed(evt);
            }
        });

        jLabel3.setText("Reserva:");

        jLabel4.setText("Estado:");

        cboestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aceptado", "Cancelado" }));
        cboestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboestadoActionPerformed(evt);
            }
        });

        jLabel9.setText("Cantidad:");

        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });

        txtidreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidreservaActionPerformed(evt);
            }
        });

        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });

        txtidproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidproductoActionPerformed(evt);
            }
        });

        txtnombreproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreproductoActionPerformed(evt);
            }
        });

        btnbuscaproducto.setText("...");
        btnbuscaproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscaproductoActionPerformed(evt);
            }
        });

        jLabel5.setText("Producto:");

        jLabel10.setText("Precio de venta:");

        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnnuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnguardar)
                        .addGap(75, 75, 75)
                        .addComponent(btncancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtidconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtprecio)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtnombreproducto, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnbuscaproducto))
                            .addComponent(txtcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(txtidconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscaproducto)
                    .addComponent(txtidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addContainerGap())
        );

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salida.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmProductoLayout = new javax.swing.GroupLayout(frmProducto);
        frmProducto.setLayout(frmProductoLayout);
        frmProductoLayout.setHorizontalGroup(
            frmProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmProductoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsalir)
                .addContainerGap())
            .addGroup(frmProductoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frmProductoLayout.setVerticalGroup(
            frmProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmProductoLayout.createSequentialGroup()
                .addGroup(frmProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir))
                .addGap(0, 0, 0)
                .addGroup(frmProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout frmConsumoLayout = new javax.swing.GroupLayout(frmConsumo);
        frmConsumo.setLayout(frmConsumoLayout);
        frmConsumoLayout.setHorizontalGroup(
            frmConsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frmProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frmConsumoLayout.setVerticalGroup(
            frmConsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frmProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(frmConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frmConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidconsumo.setText(tablalistado.getValueAt(fila, 0).toString());
        txtidreserva.setText(tablalistado.getValueAt(fila, 1).toString());
        txtidproducto.setText(tablalistado.getValueAt(fila, 2).toString());
        txtnombreproducto.setText(tablalistado.getValueAt(fila,3).toString());
        txtcantidad.setText(tablalistado.getValueAt(fila, 4).toString());
        txtprecio.setText(tablalistado.getValueAt(fila, 5).toString());
        cboestado.setSelectedItem(tablalistado.getValueAt(fila, 6).toString());
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if (!txtidconsumo.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(getParent(), " ¿Está seguro de eliminar el consumo?", "Confirmar", 2);

            //0 es que confirmo en el cuadro de dialogo por lo que busca el objeto y lo elimina
            if (confirmacion == 0) {
                fconsumo func = new fconsumo();
                vconsumo dts = new vconsumo();

                dts.setIdproducto(Integer.parseInt(txtidconsumo.getText()));
                func.eliminar(dts);
                mostrar(idreserva);
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(getParent(), "¿Desea cerrar la ventana?", "Salir", 2);

        if (opcion == 0) {
            idreserva="";
            cliente="";
            frmConsumo.this.dispose();
        }
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if (txtidproducto.getText().length() == 0) {
            JOptionPane.showConfirmDialog(getParent(), "Debe seleccionar un producto");
            btnbuscaproducto.requestFocus();
            return;
        }
        if (txtcantidad.getText().length() == 0) {
            JOptionPane.showConfirmDialog(getParent(), "Debe ingresar una cantidad de consumo");
            txtcantidad.requestFocus();
            return;
        }
        if (txtprecio.getText().length() == 0) {
            JOptionPane.showConfirmDialog(getParent(), "Debe ingresar una precio del producto");
            txtprecio.requestFocus();
            return;
        }

        vconsumo dts = new vconsumo();
        fconsumo func = new fconsumo();

        dts.setIdreserva(Integer.parseInt(txtidreserva.getText()));
        dts.setIdproducto(Integer.parseInt(txtidproducto.getText()));
        dts.setCantidad(Double.valueOf(txtcantidad.getText()));
        dts.setPrecio_venta((Double.valueOf(txtprecio.getText())));
        
        int seleccionado = cboestado.getSelectedIndex();
        dts.setEstado(cboestado.getItemAt(seleccionado));
        

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(getParent(), "El consumo "
                        +txtnombreproducto.getText()+ " del cliente "
                        +txtcliente.getText()+ " fue registrado correctamente");
                mostrar(idreserva);
                inhabilitar();
            }
        } else if (accion.equals("editar")) {
            dts.setIdproducto(Integer.parseInt(txtidconsumo.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(getParent(),"El consumo "
                        +txtnombreproducto.getText()+ " del cliente "
                        +txtcliente.getText()+ " fue editado correctamente");
                mostrar(idreserva);
                inhabilitar();
            }

        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        inhabilitar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtidconsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidconsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidconsumoActionPerformed

    private void cboestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboestadoActionPerformed
        cboestado.transferFocus();
    }//GEN-LAST:event_cboestadoActionPerformed

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        txtcantidad.transferFocus();
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void txtidreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidreservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidreservaActionPerformed

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed
        txtcliente.transferFocus();
    }//GEN-LAST:event_txtclienteActionPerformed

    private void txtidproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidproductoActionPerformed

    private void txtnombreproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreproductoActionPerformed

    private void btnbuscaproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscaproductoActionPerformed
        frmVistaproducto form = new frmVistaproducto();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnbuscaproductoActionPerformed

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        txtprecio.transferFocus();
    }//GEN-LAST:event_txtprecioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmConsumo screen = new frmConsumo();
                screen.setContentPane(screen.frmConsumo);
                screen.pack();
                screen.setVisible(true);
                screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

     private void ocultar_columna() {
        //ocultar la columna id habitacion del listado de las mismas
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
        //oculto idreserva
        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);
        //oculto idproducto
        tablalistado.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(2).setPreferredWidth(0);
    }

    private void inhabilitar() {
        txtidconsumo.setVisible(false);
        txtidproducto.setVisible(false);
        txtnombreproducto.setEnabled(false);
        txtidreserva.setVisible(false);
        txtcliente.setEnabled(false);
        cboestado.setEnabled(false);
        txtcantidad.setEnabled(false);
        txtprecio.setEnabled(false);

        btnbuscaproducto.setEnabled(false);
        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(false);

        limpiar_data();
    }

    private void habilitar() {
        txtidconsumo.setVisible(false);
        txtidproducto.setVisible(false);
        txtnombreproducto.setEnabled(false);
        txtidreserva.setVisible(false);
        txtcliente.setEnabled(false);
        cboestado.setEnabled(true);
        txtcantidad.setEnabled(true);
        txtprecio.setEnabled(false);

        btnbuscaproducto.setEnabled(true);
        btnguardar.setEnabled(true);
        btneliminar.setEnabled(true);
        btncancelar.setEnabled(true);

        limpiar_data();
    }

    //tabla de registros
    private void mostrar(String buscar) {
        try {
            //instancio la logica de la habitacion para pasarsela a la tabla de la interfaz
            DefaultTableModel modelo;
            fconsumo func = new fconsumo();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            tablalistado.getTableHeader().setReorderingAllowed(false);
            ocultar_columna();

            lblregistros.setText("Total registros: " + Integer.toString(func.totalregistros));
            lblconsumo.setText("Consumo total: " + Double.toString(func.totalconsumo));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(getParent(), e);
        }
    }

    private void limpiar_data() {
        txtidconsumo.setText("");
        txtidproducto.setText("");
        txtnombreproducto.setText("");
        txtcantidad.setText("");
        txtprecio.setText("");
        cboestado.setSelectedIndex(0);
    }

    private String accion = "guardar";
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscaproducto;
    private javax.swing.JToggleButton btncancelar;
    private javax.swing.JToggleButton btneliminar;
    private javax.swing.JToggleButton btnguardar;
    private javax.swing.JToggleButton btnnuevo;
    private javax.swing.JToggleButton btnsalir;
    private javax.swing.JComboBox<String> cboestado;
    private javax.swing.JPanel frmConsumo;
    private javax.swing.JPanel frmProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblconsumo;
    private javax.swing.JLabel lblregistros;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtcantidad;
    public static javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtidconsumo;
    public static javax.swing.JTextField txtidproducto;
    public static javax.swing.JTextField txtidreserva;
    public static javax.swing.JTextField txtnombreproducto;
    public static javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
