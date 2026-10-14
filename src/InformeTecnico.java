
public class InformeTecnico implements Documento {

    private String titulo;
    private String responsable;
    private String areaTrabajo;
    private String fecha;
    private String conclusiones;

    public InformeTecnico(String titulo, String responsable,
                          String areaTrabajo, String fecha,
                          String conclusiones) {
        this.titulo = titulo;
        this.responsable = responsable;
        this.areaTrabajo = areaTrabajo;
        this.fecha = fecha;
        this.conclusiones = conclusiones;
    }

    @Override
    public Documento clonar() {
        return new InformeTecnico(
            this.titulo,
            this.responsable,
            this.areaTrabajo,
            this.fecha,
            this.conclusiones
        );
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getConclusiones() {
        return conclusiones;
    }

    public void setConclusiones(String conclusiones) {
        this.conclusiones = conclusiones;
    }

    public void mostrarInformacion() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Responsable: " + responsable);
        System.out.println("Area de trabajo: " + areaTrabajo);
        System.out.println("Fecha: " + fecha);
        System.out.println("Conclusiones: " + conclusiones);
    }
}
