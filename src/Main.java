
import java.util.Scanner;

public class Main {

    private static Scanner teclado = new Scanner(System.in);
    private static GestorDocumentos gestor = new GestorDocumentos();

    public static void main(String[] args) {

        registrarPlantillasIniciales();

        int opcion;

        do {
            System.out.println("\n===== SISTEMA PROTOTYPE =====");
            System.out.println("1. Registrar una plantilla");
            System.out.println("2. Consultar plantillas");
            System.out.println("3. Clonar una plantilla");
            System.out.println("4. Consultar documentos generados");
            System.out.println("5. Ver detalle de un documento");
            System.out.println("6. Modificar un documento generado");
            System.out.println("7. Ver detalle de una plantilla");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    registrarPlantilla();
                    break;
                case 2:
                    gestor.listarPlantillas();
                    break;
                case 3:
                    clonarPlantilla();
                    break;
                case 4:
                    gestor.listarDocumentosGenerados();
                    break;

                case 5:
                    verDetalleDocumento();
                    break;

                 case 6:
                    modificarDocumento();
                    break;  
                 
                 case 7:
                    verDetallePlantilla();
                    break;

                case 0:
                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        teclado.close();
    }

    private static void registrarPlantillasIniciales() {
        gestor.registrarPlantilla(
            new Contrato("C001", "Juan", "Empresa A", 2000000, 12)
        );

        gestor.registrarPlantilla(
            new Factura("F001", "Cliente A", "14/10/2026", 1000000, 190000)
        );

        gestor.registrarPlantilla(
            new InformeTecnico(
                "Informe de sistemas",
                "Carlos",
                "Tecnologia",
                "14/10/2026",
                "Sistema funcionando correctamente"
            )
        );
    }

    private static void registrarPlantilla() {
        System.out.println("\nTIPOS DE DOCUMENTO");
        System.out.println("1. Contrato");
        System.out.println("2. Factura");
        System.out.println("3. Informe tecnico");
        System.out.print("Seleccione el tipo: ");

        int tipo = leerEntero();

        switch (tipo) {
            case 1:
                System.out.print("Numero de contrato: ");
                String numero = teclado.nextLine();

                System.out.print("Contratista: ");
                String contratista = teclado.nextLine();

                System.out.print("Entidad contratante: ");
                String entidad = teclado.nextLine();

                System.out.print("Valor: ");
                double valor = leerDouble();

                System.out.print("Duracion en meses: ");
                int duracion = leerEntero();

                gestor.registrarPlantilla(
                    new Contrato(numero, contratista, entidad, valor, duracion)
                );
                break;

            case 2:
                System.out.print("Numero de factura: ");
                String factura = teclado.nextLine();

                System.out.print("Cliente: ");
                String cliente = teclado.nextLine();

                System.out.print("Fecha: ");
                String fecha = teclado.nextLine();

                System.out.print("Subtotal: ");
                double subtotal = leerDouble();

                System.out.print("Impuestos: ");
                double impuestos = leerDouble();

                gestor.registrarPlantilla(
                    new Factura(factura, cliente, fecha, subtotal, impuestos)
                );
                break;

            case 3:
                System.out.print("Titulo: ");
                String titulo = teclado.nextLine();

                System.out.print("Responsable: ");
                String responsable = teclado.nextLine();

                System.out.print("Area de trabajo: ");
                String area = teclado.nextLine();

                System.out.print("Fecha: ");
                String fechaInforme = teclado.nextLine();

                System.out.print("Conclusiones: ");
                String conclusiones = teclado.nextLine();

                gestor.registrarPlantilla(
                    new InformeTecnico(
                        titulo, responsable, area, fechaInforme, conclusiones
                    )
                );
                break;

            default:
                System.out.println("Tipo de documento no valido.");
        }
    }

    private static void clonarPlantilla() {
        gestor.listarPlantillas();

        if (gestor.cantidadPlantillas() == 0) {
            return;
        }

        System.out.print("Numero de plantilla que desea clonar: ");
        int numero = leerEntero();

        gestor.clonarPlantilla(numero - 1);
    }

    private static int leerEntero() {
        while (true) {
            try {
                int numero = Integer.parseInt(teclado.nextLine().trim());
                return numero;
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un numero entero valido: ");
            }
        }
    }

    private static double leerDouble() {
        while (true) {
            try {
                String entrada = teclado.nextLine().trim().replace(',', '.');
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un valor numerico valido: ");
            }
        }
    }

    private static void verDetalleDocumento() {

    gestor.listarDocumentosGenerados();

    if (gestor.cantidadDocumentosGenerados() == 0) {
        return;
    }

    System.out.print("Seleccione el documento: ");
    int numero = leerEntero();

    Documento documento =
        gestor.obtenerDocumentoGenerado(numero - 1);

    if (documento == null) {
        System.out.println("Documento no valido.");
        return;
    }

    gestor.mostrarDocumento(documento);
}

private static void modificarDocumento() {

    gestor.listarDocumentosGenerados();

    if (gestor.cantidadDocumentosGenerados() == 0) {
        return;
    }

    System.out.print("Seleccione el documento que desea modificar: ");
    int numero = leerEntero();

    Documento documento =
        gestor.obtenerDocumentoGenerado(numero - 1);

    if (documento == null) {
        System.out.println("Documento no valido.");
        return;
    }

    if (documento instanceof Contrato) {
        Contrato contrato = (Contrato) documento;

        System.out.print("Nuevo nombre del contratista: ");
        contrato.setContratista(teclado.nextLine());

        System.out.println("Documento modificado correctamente.");

    } else if (documento instanceof Factura) {
        Factura factura = (Factura) documento;

        System.out.print("Nuevo nombre del cliente: ");
        factura.setCliente(teclado.nextLine());

        System.out.println("Documento modificado correctamente.");

    } else if (documento instanceof InformeTecnico) {
        InformeTecnico informe = (InformeTecnico) documento;

        System.out.print("Nuevo titulo del informe: ");
        informe.setTitulo(teclado.nextLine());

        System.out.println("Documento modificado correctamente.");
    }
}

private static void verDetallePlantilla() {

    gestor.listarPlantillas();

    if (gestor.cantidadPlantillas() == 0) {
        return;
    }

    System.out.print("Seleccione la plantilla: ");
    int numero = leerEntero();

    Documento documento = gestor.obtenerPlantilla(numero - 1);

    if (documento == null) {
        System.out.println("Plantilla no valida.");
        return;
    }

    gestor.mostrarDocumento(documento);
}
}
