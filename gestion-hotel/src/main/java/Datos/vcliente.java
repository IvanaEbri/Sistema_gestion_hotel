package Datos;

public class vcliente  extends vpersona{

    private String codigo_cliente;

    public vcliente() {
    }

    public vcliente(int idpersona, String nombre, String apellido, String tipo_documento, String num_documento, String direccion, String telefono, String email, String codigo_cliente) {
        super(idpersona, nombre, apellido, tipo_documento, num_documento, direccion, telefono, email);
        this.codigo_cliente = codigo_cliente;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
}
