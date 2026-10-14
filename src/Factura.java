
public class Factura implements Documento {

    private String numero;
    private String cliente;
    private String fecha;
    private double subtotal;
    private double impuestos;

    public Factura(String numero, String cliente, String fecha,
                   double subtotal, double impuestos) {
        this.numero = numero;
        this.cliente = cliente;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
    }

    @Override
    public Documento clonar() {
        return new Factura(
            this.numero,
            this.cliente,
            this.fecha,
            this.subtotal,
            this.impuestos
        );
    }

    public String getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public void mostrarInformacion() {
        System.out.println("Numero de factura: " + numero);
        System.out.println("Cliente: " + cliente);
        System.out.println("Fecha: " + fecha);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Impuestos: $" + impuestos);
        System.out.println("Total: $" + (subtotal + impuestos));
    }
}
