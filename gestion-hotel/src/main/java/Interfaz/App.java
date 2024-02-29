package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JDesktopPane desktopPane;

    public App() {
        setTitle("Gestor Hoteleria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(App.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        getContentPane().add(desktopPane, BorderLayout.CENTER);
        desktopPane.setBorder(BorderFactory.createTitledBorder("JDesktopPane con Borde"));
        setContentPane(desktopPane);
        desktopPane.setVisible(true);

        createMenuBar();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new App().setVisible(true);

        });
    }

    public void createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu sistMenu = new JMenu("Sistema Reserva");
        JMenu archivoMenu = new JMenu("Archivo");
        JMenu reservasMenu = new JMenu("Reservas");
        JMenu consultasMenu = new JMenu("Consultas");
        JMenu configMenu = new JMenu("Configuraciones");
        JMenu herMenu = new JMenu("Herramientas");
        JMenu ayudaMenu = new JMenu("Ayuda");
        JMenu salirMenu = new JMenu("Salir");
        menuBar.add(sistMenu);
        menuBar.add(archivoMenu);
        menuBar.add(reservasMenu);
        menuBar.add(consultasMenu);
        menuBar.add(configMenu);
        menuBar.add(herMenu);
        menuBar.add(ayudaMenu);
        menuBar.add(salirMenu);



        JMenuItem habArchivo = new JMenuItem("Habitaciones");
        habArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmHabitacion form = new frmHabitacion();
                desktopPane.add(form);
                form.setVisible(true);
                form.pack();
                form.setLocation(0,0);
            }
        });
        JMenuItem prodArchivo = new JMenuItem("Productos");
        prodArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        archivoMenu.add(habArchivo);
        archivoMenu.add(prodArchivo);


        JMenuItem resconReservas = new JMenuItem("Reservas y Consumos");
        resconReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JMenuItem clientesReservas = new JMenuItem("Clientes");
        clientesReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JMenuItem pagosReservas = new JMenuItem("Pagos");
        pagosReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        reservasMenu.add(resconReservas);
        reservasMenu.add(clientesReservas);
        reservasMenu.add(pagosReservas);


        JMenuItem usuaccConfig = new JMenuItem("Usuarios y Accesos");
        usuaccConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        configMenu.add(usuaccConfig);

        JMenuItem acercaAyuda = new JMenuItem("Acerca de...");
        acercaAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JMenuItem ayudaAyuda = new JMenuItem("Ayuda");
        ayudaAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ayudaMenu.add(acercaAyuda);
        ayudaMenu.add(ayudaAyuda);


        JMenuItem salirSalir = new JMenuItem("Salir");
        salirSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(salirMenu, "¿Desea salir del sistema?", "Salir", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    dispose();
                    System.exit(0);
                }
            }
        });
        salirMenu.add(salirSalir);

        ImageIcon iconArchivo = new ImageIcon("gestion-hotel/src/main/java/Files/archivo.png");
        ImageIcon iconInicio= new ImageIcon("gestion-hotel/src/main/java/Files/work-from-home.png");
        ImageIcon iconReserva= new ImageIcon("gestion-hotel/src/main/java/Files/hotel.png");
        ImageIcon iconBuscar= new ImageIcon("gestion-hotel/src/main/java/Files/lupa_gr.png");
        ImageIcon iconConfig= new ImageIcon("gestion-hotel/src/main/java/Files/fabricacion.png");
        ImageIcon iconHer= new ImageIcon("gestion-hotel/src/main/java/Files/herramientas-para-reparar.png");
        ImageIcon iconAyuda= new ImageIcon("gestion-hotel/src/main/java/Files/informacion.png");
        ImageIcon iconSalir= new ImageIcon("gestion-hotel/src/main/java/Files/salida.png");

        sistMenu.setIcon(iconInicio);
        archivoMenu.setIcon(iconArchivo);
        reservasMenu.setIcon(iconReserva);
        consultasMenu.setIcon(iconBuscar);
        configMenu.setIcon(iconConfig);
        herMenu.setIcon(iconHer);
        ayudaMenu.setIcon(iconAyuda);
        salirMenu.setIcon(iconSalir);

    }
}

