
import java.util.ArrayList;

public class GestorDocumentos {

    private ArrayList<Documento> plantillas;
    private ArrayList<Documento> documentosGenerados;

    public GestorDocumentos() {
        plantillas = new ArrayList<>();
        documentosGenerados = new ArrayList<>();
    }

    public void registrarPlantilla(Documento documento) {
        plantillas.add(documento);
        System.out.println("Plantilla registrada correctamente.");
    }

    public void listarPlantillas() {
        if (plantillas.isEmpty()) {
            System.out.println("No hay plantillas registradas.");
            return;
        }

        System.out.println("\n--- PLANTILLAS REGISTRADAS ---");

        for (int i = 0; i < plantillas.size(); i++) {
            System.out.println((i + 1) + ". "
                    + plantillas.get(i).getClass().getSimpleName());
        }
    }

    public void clonarPlantilla(int indice) {
        if (indice < 0 || indice >= plantillas.size()) {
            System.out.println("Numero de plantilla no valido.");
            return;
        }

        Documento copia = plantillas.get(indice).clonar();
        documentosGenerados.add(copia);

        System.out.println("Documento clonado correctamente.");
        System.out.println("Tipo de documento: "
                + copia.getClass().getSimpleName());
        System.out.println("ID de la copia: "
                + documentosGenerados.size());
    }

    public void listarDocumentosGenerados() {
        if (documentosGenerados.isEmpty()) {
            System.out.println("No hay documentos generados.");
            return;
        }

        System.out.println("\n--- DOCUMENTOS GENERADOS ---");

        for (int i = 0; i < documentosGenerados.size(); i++) {
            System.out.println((i + 1) + ". "
                    + documentosGenerados.get(i)
                            .getClass().getSimpleName());
        }
    }

    public Documento obtenerPlantilla(int indice) {
        if (indice < 0 || indice >= plantillas.size()) {
            return null;
        }

        return plantillas.get(indice);
    }

    public Documento obtenerDocumentoGenerado(int indice) {
        if (indice < 0 || indice >= documentosGenerados.size()) {
            return null;
        }

        return documentosGenerados.get(indice);
    }

    public int cantidadPlantillas() {
        return plantillas.size();
    }

    public int cantidadDocumentosGenerados() {
        return documentosGenerados.size();
    }
    public void mostrarDocumento(Documento documento) {

if (documento instanceof Contrato) {
    ((Contrato) documento).mostrarInformacion();

} else if (documento instanceof Factura) {
    ((Factura) documento).mostrarInformacion();

} else if (documento instanceof InformeTecnico) {
    ((InformeTecnico) documento).mostrarInformacion();
}

}
}
