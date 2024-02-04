package Logica;

import Datos.vcliente;
import Datos.vproducto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class fcliente {
    private conexion mysql= new conexion(); //creo la variable tipo conexion
    private Connection cn=mysql.conectar(); //genero una conexion a la base
    private String sSQL="";
    private String sSQL2="";
    public Integer totalregistros;


    //adapto el codigo
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        String[] titulos={"ID","Nombre","Apellido","Tipo de documento","Número de documento","Dirección","Teléfono","Email","Código"};
        String[] registro = new String [9];

        totalregistros=0;
        modelo= new DefaultTableModel(null,titulos);

        sSQL="select p.idpersona, p.nombre, p.apellido, p.tipo_documento,p.numero_documento,"+
                "p.direccion, p.telefono, p.email, c.codigo_cliente from persona p inner join"+
                " cliente c on p.idpersona= c.idpersona where numero_documento like '%"+
                buscar+"%' order by idpersona desc";

        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);

            while (rs.next()){
                registro[0]=rs.getString("idpersona");
                registro[1]=rs.getString("nombre");
                registro[2]=rs.getString("apellido");
                registro[3]=rs.getString("tipo_documento");
                registro[4]=rs.getString("numero_documento");
                registro[5]=rs.getString("direccion");
                registro[6]=rs.getString("telefono");
                registro[7]=rs.getString("email");
                registro[8]=rs.getString("codigo_cliente");

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

    public boolean insertar (vcliente dts){
        sSQL="insert into persona(nombre, apellido, tipo_documento,numero_documento,"+
                "direccion, telefono, email) values(?,?,?,?,?,?,?)";
        sSQL2="insert into cliente (idpersona, codigo_cliente) values("+
                "(select idpersona from persona order by idpersona desc limit 1),?)";
        try {
            PreparedStatement pst= cn.prepareStatement(sSQL);
            PreparedStatement pst2= cn.prepareStatement(sSQL2);

            pst.setString(1,dts.getNombre());
            pst.setString(2,dts.getApellido());
            pst.setString(3,dts.getTipo_documento());
            pst.setString(4,dts.getNum_documento());
            pst.setString(5,dts.getDireccion());
            pst.setString(6,dts.getTelefono());
            pst.setString(7,dts.getEmail());

            pst2.setString(1, dts.getCodigo_cliente());

            int n=pst.executeUpdate();

            if(n!=0){
                int n2=pst2.executeUpdate();
                if (n2!=0){
                    return true;
                } else {
                    return false;
                }
            }else {
                return false;
            }

        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar (vcliente dts){
        sSQL="update persona set nombre=?,apellido=?,tipo_documento=?, numero_documento=?,"+
                "direccion=?,telefono=?,email=? where idpersona=?";
        sSQL2="update cliente set codigo_cliente=? where idpersona=?";
        try {
            PreparedStatement pst= cn.prepareStatement(sSQL);
            PreparedStatement pst2= cn.prepareStatement(sSQL2);

            pst.setString(1,dts.getNombre());
            pst.setString(2,dts.getApellido());
            pst.setString(3,dts.getTipo_documento());
            pst.setString(4,dts.getNum_documento());
            pst.setString(5,dts.getDireccion());
            pst.setString(6,dts.getTelefono());
            pst.setString(7,dts.getEmail());
            pst.setInt(8,dts.getIdpersona());

            pst2.setString(1, dts.getCodigo_cliente());
            pst2.setInt(2,dts.getIdpersona());

            int n=pst.executeUpdate();

            if(n!=0){
                int n2=pst2.executeUpdate();
                if (n2!=0){
                    return true;
                } else {
                    return false;
                }
            }else {
                return false;
            }
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar (vcliente dts){
        sSQL="delete from cliente where idpersona=?";
        sSQL2="delete from persona where idpersona=?";

        try {
            PreparedStatement pst= cn.prepareStatement(sSQL);
            PreparedStatement pst2= cn.prepareStatement(sSQL2);
            pst.setInt(1,dts.getIdpersona());
            pst2.setInt(1,dts.getIdpersona());

            int n=pst.executeUpdate();

            if(n!=0){
                int n2=pst2.executeUpdate();
                if (n2!=0){
                    return true;
                } else {
                    return false;
                }
            }else {
                return false;
            }
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
