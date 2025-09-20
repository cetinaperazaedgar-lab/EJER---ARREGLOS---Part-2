import java.util.Scanner;

public class Ventas {
    // Definir meses y departamentos
    static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                             "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    static String[] departamentos = {"Ropa", "Deportes", "Juguetería"};

    // Crear matriz de 12x3 inicializada en 0
    static int[][] ventas = new int[12][3];

    // Método para insertar venta
    public static void insertarVenta(String mes, String depto, int valor) {
        int i = buscarIndiceMes(mes);
        int j = buscarIndiceDepto(depto);
        if (i != -1 && j != -1) {
            ventas[i][j] = valor;
        } else {
            System.out.println("Mes o departamento inválido.");
        }
    }


    // Método para buscar venta
    public static int buscarVenta(String mes, String depto) {
        int i = buscarIndiceMes(mes);
        int j = buscarIndiceDepto(depto);
        if (i != -1 && j != -1) {
            return ventas[i][j];
        } else {
            System.out.println("Mes o departamento inválido.");
            return -1;
        }
    }

    // Método para eliminar venta (poner en 0)
    public static void eliminarVenta(String mes, String depto) {
        int i = buscarIndiceMes(mes);
        int j = buscarIndiceDepto(depto);
        if (i != -1 && j != -1) {
            ventas[i][j] = 0;
        } else {
            System.out.println("Mes o departamento inválido.");
        }
    }

    // Método para mostrar tabla
    public static void mostrarTabla() {
        System.out.println("\nTabla de Ventas:\n");
        System.out.print("Mes\\Depto\t");
        for (String depto : departamentos) {
            System.out.print(depto + "\t");
        }
        System.out.println();
        for (int i = 0; i < meses.length; i++) {
            System.out.print(meses[i] + "\t");
            for (int j = 0; j < departamentos.length; j++) {
                System.out.print(ventas[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Métodos auxiliares para buscar índices
    public static int buscarIndiceMes(String mes) {
        for (int i = 0; i < meses.length; i++) {
            if (meses[i].equalsIgnoreCase(mes)) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarIndiceDepto(String depto) {
        for (int j = 0; j < departamentos.length; j++) {
            if (departamentos[j].equalsIgnoreCase(depto)) {
                return j;
            }
        }
        return -1;
    }

    // Menú interactivo
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n==============================");
            System.out.println("--- MENÚ DE VENTAS ---");
            System.out.println("1. Insertar venta");
            System.out.println("2. Buscar venta");
            System.out.println("3. Eliminar venta");
            System.out.println("4. Mostrar tabla");
            System.out.println("5. Salir");
            System.out.println("==============================");
            System.out.print("Elige una opción: ");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el mes (Ejemplo: Enero): ");
                    String mes1 = sc.nextLine();
                    System.out.print("Ingrese el departamento (Ropa/Deportes/Juguetería): ");
                    String depto1 = sc.nextLine();
                    System.out.print("Ingrese la venta: ");
                    int valor = Integer.parseInt(sc.nextLine());
                    insertarVenta(mes1, depto1, valor);
                    System.out.println("Venta insertada con éxito.");
                    break;
                case "2":
                    System.out.print("Ingrese el mes: ");
                    String mes2 = sc.nextLine();
                    System.out.print("Ingrese el departamento: ");
                    String depto2 = sc.nextLine();
                    int resultado = buscarVenta(mes2, depto2);
                    if (resultado != -1) {
                        System.out.println("🔎 Venta encontrada: " + resultado);
                    }
                    break;
                case "3":
                    System.out.print("Ingrese el mes: ");
                    String mes3 = sc.nextLine();
                    System.out.print("Ingrese el departamento: ");
                    String depto3 = sc.nextLine();
                    eliminarVenta(mes3, depto3);
                    System.out.println("Venta eliminada con éxito.");
                    break;
                case "4":
                    mostrarTabla();
                    break;
                case "5":
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
    }
}
