/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package InterfazR;

import javax.swing.JOptionPane;

/**
 *
 * @author Ivana
 */
public class Gestor extends javax.swing.JFrame {

    /**
     * Creates new form Gestor
     */
    public Gestor() {
        initComponents();
        this.setExtendedState(Gestor.MAXIMIZED_BOTH);
        this.escritorio.setVisible(true);
        this.setTitle("Sistema de reserva de habitaciones y gestor de ventas");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        mnusistema = new javax.swing.JMenu();
        mnuarchivo = new javax.swing.JMenu();
        habitacionMenuItem = new javax.swing.JMenuItem();
        productoMenuItem = new javax.swing.JMenuItem();
        mnureserva = new javax.swing.JMenu();
        reservasyclientesMenuItem = new javax.swing.JMenuItem();
        clienteMenuItem = new javax.swing.JMenuItem();
        pagoMenuItem = new javax.swing.JMenuItem();
        mnuconsultas = new javax.swing.JMenu();
        mnuconfig = new javax.swing.JMenu();
        usuariosMenuItem = new javax.swing.JMenuItem();
        mnuherr = new javax.swing.JMenu();
        mnuayuda = new javax.swing.JMenu();
        acercaMenuItem = new javax.swing.JMenuItem();
        ayudaMenuItem = new javax.swing.JMenuItem();
        mnusalir = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("gestor"); // NOI18N

        mnusistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/work-from-home.png"))); // NOI18N
        mnusistema.setMnemonic('f');
        mnusistema.setText("Sistema Reserva");
        menuBar.add(mnusistema);

        mnuarchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/archivo.png"))); // NOI18N
        mnuarchivo.setMnemonic('e');
        mnuarchivo.setText("Archivo");

        habitacionMenuItem.setMnemonic('t');
        habitacionMenuItem.setText("Habitaciones");
        habitacionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habitacionMenuItemActionPerformed(evt);
            }
        });
        mnuarchivo.add(habitacionMenuItem);

        productoMenuItem.setMnemonic('y');
        productoMenuItem.setText("Productos");
        productoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoMenuItemActionPerformed(evt);
            }
        });
        mnuarchivo.add(productoMenuItem);

        menuBar.add(mnuarchivo);

        mnureserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/hotel.png"))); // NOI18N
        mnureserva.setMnemonic('h');
        mnureserva.setText("Reserva");

        reservasyclientesMenuItem.setMnemonic('c');
        reservasyclientesMenuItem.setText("Reservas y Consumos");
        mnureserva.add(reservasyclientesMenuItem);

        clienteMenuItem.setMnemonic('a');
        clienteMenuItem.setText("Clientes");
        clienteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteMenuItemActionPerformed(evt);
            }
        });
        mnureserva.add(clienteMenuItem);

        pagoMenuItem.setText("Pagos");
        mnureserva.add(pagoMenuItem);

        menuBar.add(mnureserva);

        mnuconsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/lupa_gr.png"))); // NOI18N
        mnuconsultas.setText("Consultas");
        menuBar.add(mnuconsultas);

        mnuconfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/fabricacion.png"))); // NOI18N
        mnuconfig.setText("Configuraciones");

        usuariosMenuItem.setText("Usuarios y Accesos");
        usuariosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosMenuItemActionPerformed(evt);
            }
        });
        mnuconfig.add(usuariosMenuItem);

        menuBar.add(mnuconfig);

        mnuherr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/herramientas-para-reparar.png"))); // NOI18N
        mnuherr.setText("Herramientas");
        menuBar.add(mnuherr);

        mnuayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/informacion.png"))); // NOI18N
        mnuayuda.setText("Ayuda");

        acercaMenuItem.setText("Acerca de..");
        mnuayuda.add(acercaMenuItem);

        ayudaMenuItem.setText("Ayuda");
        mnuayuda.add(ayudaMenuItem);

        menuBar.add(mnuayuda);

        mnusalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salida_gr.png"))); // NOI18N
        mnusalir.setText("Salir");
        mnusalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnusalirMouseClicked(evt);
            }
        });
        menuBar.add(mnusalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void habitacionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habitacionMenuItemActionPerformed
        frmHabitacion form = new frmHabitacion();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_habitacionMenuItemActionPerformed

    private void productoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoMenuItemActionPerformed
        frmProducto form = new frmProducto();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_productoMenuItemActionPerformed

    private void clienteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteMenuItemActionPerformed
        frmCliente form = new frmCliente();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_clienteMenuItemActionPerformed

    private void usuariosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosMenuItemActionPerformed
        frmTrabajador form = new frmTrabajador();
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_usuariosMenuItemActionPerformed

    private void mnusalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnusalirMouseClicked
        int opcion = JOptionPane.showConfirmDialog(escritorio, "¿Desea salir del sistema?", "Salir", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_mnusalirMouseClicked

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
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem acercaMenuItem;
    private javax.swing.JMenuItem ayudaMenuItem;
    private javax.swing.JMenuItem clienteMenuItem;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem habitacionMenuItem;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnuarchivo;
    private javax.swing.JMenu mnuayuda;
    private javax.swing.JMenu mnuconfig;
    private javax.swing.JMenu mnuconsultas;
    private javax.swing.JMenu mnuherr;
    private javax.swing.JMenu mnureserva;
    private javax.swing.JMenu mnusalir;
    private javax.swing.JMenu mnusistema;
    private javax.swing.JMenuItem pagoMenuItem;
    private javax.swing.JMenuItem productoMenuItem;
    private javax.swing.JMenuItem reservasyclientesMenuItem;
    private javax.swing.JMenuItem usuariosMenuItem;
    // End of variables declaration//GEN-END:variables

}
