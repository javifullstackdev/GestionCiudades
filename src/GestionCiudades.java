import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GestionCiudades {
    public static void main(String[] args) {

        // Voy a utilizar un HashSet, ya que no se permiten ciudades duplicadas.

        Set<String> cities = new HashSet<>();

        // Creo el objeto scanner para leer las entradas del usuario:

        Scanner scanner = new Scanner(System.in);

        // Creo la variable option para almacenar qué opción elige el usuario dentro del menú:

            int option;

        // El menú va a repetirse hasta que se seleccione la opción 5
            
            do {
                System.out.println("\n--- Menú de Gestión de Ciudades ---");
                System.out.println("1. Añadir una ciudad");
                System.out.println("2. Mostrar todas las ciudades");
                System.out.println("3. Buscar una ciudad");
                System.out.println("4. Eliminar una ciudad");
                System.out.println("5. Salir");
                System.out.print("Selecciona una opción: ");

                // Introduzco una validación por si el usuario no introdujese un número entero
                
                while (!scanner.hasNextInt()) {
                    System.out.print("Por favor, ingresa un número válido: ");

                    // Limpiamos el buffer:

                    scanner.next();
                }
                option = scanner.nextInt();
                scanner.nextLine();

                // A través de un switch presentamos todas las opciones del menú:
                
                switch (option) {

                    // Opción 1: Añadir una nueva ciudad

                    case 1 :
                        System.out.print("Ingresa el nombre de la ciudad a agregar: ");
                        String newCity = scanner.nextLine().toLowerCase();

                        // Si ya ha sido añadida anteriormente, nos lo dice

                        if (cities.add(newCity)) {
                            System.out.println("Ciudad añadida correctamente.");
                        } else {
                            System.out.println("La ciudad ya existe en la lista.");
                        }
                        break;

                        // Opción 2: Mostrar ciudades
                    
                    case 2 :

                    // Comprueba si la lista está vacía, de ser así nos lo dice.

                        if (cities.isEmpty()) {
                            System.out.println("La lista de ciudades está vacía.");

                            // Si no está vacía, nos muestra las ciudades.

                        } else {
                            System.out.println("Ciudades registradas:");
                            for (String city : cities) {
                                System.out.println("- " + city);
                            }
                        }
                        break;

                    // Opción 3: Buscar ciudad
                    
                    case 3 :
                        System.out.print("Ingresa el nombre de la ciudad a buscar: ");
                        String searchCity = scanner.nextLine().toLowerCase();
                        
                        if (cities.contains(searchCity)) {
                            System.out.println("La ciudad '" + searchCity + "' se encuentra en la lista.");
                        } else {
                            System.out.println("La ciudad no fue encontrada.");
                        }
                        break;

                    // Opción 4: Eliminar ciudad

                    case 4 :
                        System.out.print("Ingresa el nombre de la ciudad a eliminar: ");
                        String deleteCity = scanner.nextLine().toLowerCase();
                        
                        if (cities.remove(deleteCity)) {
                            System.out.println("Ciudad eliminada correctamente.");
                        } else {
                            System.out.println("No se encontró la ciudad en la lista.");
                        }
                        break;

                    // Opción 5: Salimos del programa
                    
                    case 5 :
                        System.out.println("Saliendo del programa. ¡Hasta pronto!");
                        break;

                    // En caso de que el usuario introduzca una opción no válida, nos salta el error.
                    
                    default :
                        System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 5.");
                    }
                
            } while (option != 5);

        scanner.close();
    }
}