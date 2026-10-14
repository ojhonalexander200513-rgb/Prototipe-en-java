
public class Contrato implements Documento {

    private String numero;
    private String contratista;
    private String entidad;
    private double valor;
    private int duracion;

    public Contrato(String numero, String contratista,
                    String entidad, double valor, int duracion) {
        this.numero = numero;
        this.contratista = contratista;
        this.entidad = entidad;
        this.valor = valor;
        this.duracion = duracion;
    }

    @Override
    public Documento clonar() {
        return new Contrato(
            this.numero,
            this.contratista,
            this.entidad,
            this.valor,
            this.duracion
        );
    }

    public String getNumero() {
        return numero;
    }

    public String getContratista() {
        return contratista;
    }

    public void setContratista(String contratista) {
        this.contratista = contratista;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void mostrarInformacion() {
        System.out.println("Numero: " + numero);
        System.out.println("Contratista: " + contratista);
        System.out.println("Entidad: " + entidad);
        System.out.println("Valor: $" + valor);
        System.out.println("Duracion: " + duracion + " meses");
    }
}
