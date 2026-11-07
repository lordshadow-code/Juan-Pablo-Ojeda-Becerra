import java.util.Scanner;

public class  CentroReciclaje {;
    public static void main(String[] args) {

        try (Scanner teclado = new Scanner(System.in)) {
            int cargas[] = new int[1];
            double pesoCargas[];
            
            int cantidad5a80 = 0;
            int cantidadMayor80 = 0;
            int cantidadMayorPromedio = 0;
            
            double pesoTotal = 0;
            double mayorPeso = 0;
            double promedio;
            
            // Validar cantidad de cargas
            do {
                System.out.print("Ingrese la cantidad de cargas (3 a 20): ");
                cargas[0] = teclado.nextInt();
                
                if (cargas[0] < 3 || cargas[0] > 20) {
                    System.out.println("Error: ingrese un valor entre 3 y 20.");
                }
                
            } while (cargas[0] < 3 || cargas[0] > 20);
            
            // Crear arreglo para los pesos
            pesoCargas = new double[cargas[0]];
            
            // Ingresar los pesos de las cargas
            for (int i = 0; i < cargas[0]; i++) {
                
                do {
                    System.out.print("Ingrese el peso de la carga "
                            + (i + 1) + " (5 a 200 kg): ");
                    
                    pesoCargas[i] = teclado.nextDouble();
                    
                    if (pesoCargas[i] < 5 || pesoCargas[i] > 200) {
                        System.out.println("Error: el peso debe estar entre 5 y 200 kg.");
                    }
                    
                } while (pesoCargas[i] < 5 || pesoCargas[i] > 200);
                
                // Calcular peso total
                pesoTotal += pesoCargas[i];
                
                // Encontrar el mayor peso
                if (pesoCargas[i] > mayorPeso) {
                    mayorPeso = pesoCargas[i];
                }
                
                // Contar cargas entre 5 y 80 kg
                if (pesoCargas[i] >= 5 && pesoCargas[i] <= 80) {
                    cantidad5a80++;
                }
                
                // Contar cargas superiores a 80 kg
                if (pesoCargas[i] > 80) {
                    cantidadMayor80++;
                }
            }
            
            // Calcular promedio
            promedio = pesoTotal / cargas[0];
            
            // Contar cargas superiores al promedio
            for (int i = 0; i < cargas[0]; i++) {
                if (pesoCargas[i] > promedio) {
                    cantidadMayorPromedio++;
                }
            }
            
            // Mostrar resultados
            System.out.println("====== RESULTADOS DE LA JORNADA ======");
            
            System.out.println("Cantidad de cargas entre 5 y 80 kg: "
                    + cantidad5a80);
            
            System.out.println("Cantidad de cargas superiores a 80 kg: "
                    + cantidadMayor80);
            
            System.out.printf("Peso promedio de las cargas: %.2f kg%n", promedio);
            
            System.out.printf("Peso total de la jornada: %.2f kg%n", pesoTotal);
            
            System.out.printf("Mayor peso registrado: %.2f kg%n", mayorPeso);
            
            System.out.println("Cantidad de cargas superiores al promedio: "
                    + cantidadMayorPromedio);
            
            // Listado de todos los pesos
            System.out.println(" ===== LISTADO DE CARGAS ===== ");
            
            for (int i = 0; i < cargas[0]; i++) {
                System.out.println("Carga " + (i + 1) + ": "
                        + pesoCargas[i] + " kg");
            }
        }
    }
}

