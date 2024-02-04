package Logica;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    public String db="base_reserva"; //nombre de la base de datos
    public String url="jdbc:mysql://localhost:3306/"+db; //ruta de la base de datos
    public String user="root"; //usuario de la bd
    public String pass=""; //contraseña de la bd

    public conexion() {
        //init
    }

    public Connection conectar(){
        Connection link= null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //ruta de la clase driver de la libreria jdbc
            link = DriverManager.getConnection(this.url,this.user,this.pass); //conector
        } catch (Exception e){
            JOptionPane.showConfirmDialog(null,e); //muestra el error
        }
        return link;
    }
}
