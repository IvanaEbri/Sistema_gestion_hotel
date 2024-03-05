package Logica;

import Datos.vreserva;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class freserva {

    private conexion mysql= new conexion(); //creo la variable tipo conexion
    private Connection cn=mysql.conectar(); //genero una conexion a la base
    private String sSQL="";
    public Integer totalregistros;


    //adapto el codigo de fhabitacion al producto
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        String[] titulos={"ID","Id Habitacion","Numero","Id Cliente","Cliente","Id Trabajador",
            "Trabajador", "Tipo Reserva","Fecha Reserva","Fecha Ingreso", "Fecha Salida",
            "Costo","Estado"};
        String[] registro = new String [14];

        totalregistros=0;
        modelo= new DefaultTableModel(null,titulos);

        sSQL="select r.idreserva, r.idhabitacion, h.numero, r.idcliente, "
                + "(select nombre from persona where idpersona=r.idcliente) as clienten,"
                + "(select apellido from persona where idpersona=r.idcliente) as clientea,"
                + "r.idtrabajador, "
                + "(select nombre from persona where idpersona=r.idtrabajador)as trabajadorn,"
                + "(select apellido from persona where idpersona=r.idtrabajador)as trabajadora,"
                + "r.tipo_reserva, r.fecha_reserva, r.fecha_ingreso, r.fecha_salida,"
                + " r.costo_alojamiento, r.observacion, r.estado"
                + " from reserva r inner join habitacion h on r.idhabitacion=h.idhabitacion"
                + " where r.fecha_reserva like '%"+buscar+"%' order by idreserva";

        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);

            while (rs.next()){
                registro[0]=rs.getString("idreserva");
                registro[1]=rs.getString("idhabitacion");
                registro[2]=rs.getString("numero");
                registro[3]=rs.getString("idcliente");
                registro[4]=rs.getString("clienten")+" "+rs.getString("clientea");
                registro[5]=rs.getString("idtrabajador");
                registro[6]=rs.getString("trabajadorn")+" "+rs.getString("trabajadora");
                registro[7]=rs.getString("tipo_reserva");
                registro[8]=rs.getString("fecha_reserva");
                registro[9]=rs.getString("fecha_ingreso");
                registro[10]=rs.getString("fecha_salida");
                registro[11]=rs.getString("costo_alojamiento");
                registro[12]=rs.getString("observacion");
                registro[13]=rs.getString("estado");

                //añado la fila a la tabla
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }

            return modelo;
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null,e);
            return null;
        }
    }

    public boolean insertar (vreserva dts){
        sSQL="insert into reserva(idhabitacion, idcliente, idtrabajador ,tipo_reserva,"
                + "fecha_reserva, fecha_ingreso, fecha_salida, costo_alojamiento,"
                + "observacion, estado)"+
                "values(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst= cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdhabitacion());
            pst.setInt(2,dts.getIdcliente());
            pst.setInt(3,dts.getIdtrabajador());
            pst.setString(4,dts.getTipo_reserva());
            pst.setDate(5,dts.getFecha_reserva());
            pst.setDate(6,dts.getFecha_ingreso());
            pst.setDate(7,dts.getFecha_salida());
            pst.setDouble(8,dts.getCosto_alojamiento());
            pst.setString(9,dts.getObservacion());
            pst.setString(10,dts.getEstado()); 
            
            

            int n=pst.executeUpdate();

            if(n!=0){
                return true;
            }else {
                return false;
            }

        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar (vreserva dts){
        sSQL="update reserva set idhabitacion=?, idcliente=?, idtrabajador=? ,tipo_reserva=?,"
                + "fecha_reserva=?, fecha_ingreso=?, fecha_salida=?, costo_alojamiento=?,"
                + "observacion=?, estado=? where idreserva=?";
        try {
            PreparedStatement pst= cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdhabitacion());
            pst.setInt(2,dts.getIdcliente());
            pst.setInt(3,dts.getIdtrabajador());
            pst.setString(4,dts.getTipo_reserva());
            pst.setDate(5,dts.getFecha_reserva());
            pst.setDate(6,dts.getFecha_ingreso());
            pst.setDate(7,dts.getFecha_salida());
            pst.setDouble(8,dts.getCosto_alojamiento());
            pst.setString(9,dts.getObservacion());
            pst.setString(10,dts.getEstado());
            pst.setInt(11,dts.getIdreserva());
                        

            int n=pst.executeUpdate();

            if(n!=0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar (vreserva dts){
        sSQL="delete from reserva where idreserva=?";
        try {
            PreparedStatement pst= cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdreserva());

            int n=pst.executeUpdate();

            if(n!=0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean pagar (vreserva dts){
        sSQL="update reserva set estado='Pagada' where idreserva=?";
        try {
            PreparedStatement pst= cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdreserva());
                        

            int n=pst.executeUpdate();

            if(n!=0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
