// Análisis (completar)
// Descripción del programa: maquina que calcula los puntos de los jugadores y muestra el ganador y el promedio de los puntos
// Entradas:cantidad de jugadores, cantidad de rondas y puntuaciones de los jugadores 
// Salidas: me pregunta cuantos jugadores, cuantas rondas, quien gano y cual fue el promedio de los puntos  
// Ejemplo: 
/*Ingrese el numero de jugadores (maximo 10): 
Ingrese el numero de rondas (maximo 5): 3
Jugador 1:
  Ingrese la puntuacion en la ronda 1: 5
  Ingrese la puntuacion en la ronda 2: 2
  Ingrese la puntuacion en la ronda 3: 3
Jugador 2:
  Ingrese la puntuacion en la ronda 1: 4
  Ingrese la puntuacion en la ronda 2: 2
  Ingrese la puntuacion en la ronda 3: 3

--- Resultados Finales ---
Jugador 1 - Total: 10
Jugador 2 - Total: 9

--- Resultados Finales ---
Jugador 1 - Total: 10
Jugador 2 - Total: 9
El ganador es...: 10.0
Jugador 1 - Total: 10
Jugador 2 - Total: 9
El ganador es...: 10.0
Jugador 2 - Total: 9
El ganador es...: 10.0
El puntaje promedio es: 9.5*/


package ui; 

import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {

	// Declaración del Escaner que nos ayudará en todo el programa
	private Scanner escaner;

	// Declaración de nuestras constantes a utilizar
  	private static final int max_jugadores = 10;
    private static final int max_rondas = 5;


	private AtlasPuntuaciones() {
		escaner = new Scanner(System.in);
	}
	
    public static void main (String[] args){
AtlasPuntuaciones MainApp = new AtlasPuntuaciones();
MainApp.run();

    }
	        // Notificacion al usuario de la solicitud de dato
	public void run()
	{
		int jugadores, rondas;
		int [][] puntuaciones;
		int [] totales;

		System.out.println("Ingrese el numero de jugadores (maximo 10): ");
		jugadores = escaner.nextInt();

		System.out.print("Ingrese el numero de rondas (maximo 5): ");
        rondas = Math.min(escaner.nextInt(), max_rondas);

        	// Inicialización de arreglos
        puntuaciones = new int[jugadores][rondas];
        totales = new int[jugadores];

        	// Captura de datos
        for (int i = 0; i < jugadores; i++) {
            System.out.println("Jugador " + (i + 1) + ":");
            for (int j = 0; j < rondas; j++) {
                System.out.print("  Ingrese la puntuacion en la ronda " + (j + 1) + ": ");
                puntuaciones[i][j] = escaner.nextInt();
 
			}
		}
		
		for (int i = 0; i < jugadores; i++) {
            totales[i] = calcularSumaTotal(puntuaciones[i]);

		}

			// Notificación al usuario de los resultados
			System.out.println("\n--- Resultados Finales ---");
		for (int i = 0; i < jugadores; i++) {
				System.out.println("Jugador " + (i + 1) + " - Total: " + totales[i]);
			}
	

			// Cálculo de totales
        for (int i = 0; i < jugadores; i++) {
            totales[i] = calcularSumaTotal(puntuaciones[i]);

			// Notificación al usuario de los resultados
			System.out.println("\n--- Resultados Finales ---");
			for (int r = 0; i < jugadores; i++) {
				System.out.println("Jugador " + (i + 1) + " - Total: " + totales[i]);


			}
		}

        	// determino el ganador y el promedio 
        double maxPuntos = encontrarMayor(convertirAEnterosADoubles(totales)); 
        double promedio = calcularPromedio(totales);
        
        System.out.println("El ganador es...: " + maxPuntos);
        System.out.println("El puntaje promedio es: " + promedio);

        escaner.close(); 
    }

    /**
     * Descripción: El método calcularSumaTotal permite calcular la suma total de un arreglo de enteros.
     * @param numeros Arreglo de números enteros.
     * @return La suma total de los números.
     */
    public int calcularSumaTotal(int[] numeros) {
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        return suma;
    }

    /**
     * Descripción: El método calcularPromedio permite calcular el promedio de un arreglo de enteros.
     * @param numeros Arreglo de números enteros.
     * @return El promedio de los números.
     */
    public double calcularPromedio(int[] numeros) {
        if (numeros.length == 0) return 0;
        return (double) calcularSumaTotal(numeros) / numeros.length;
    }

    /**
     * Descripción: El método encontrarMayor permite encontrar el número más alto en un arreglo de dobles.
     * @param numeros Arreglo de números en tipo double.
     * @return El número más alto encontrado.
     */
    public double encontrarMayor(double[] numeros) {
        double mayor = numeros[0];
        for (double num : numeros) {
            if (num > mayor) {
                mayor = num;
            }
        }
        return mayor;
    }

    /**
     * Descripción: Método auxiliar para convertir un arreglo de enteros a un arreglo de doubles.
     * @param numeros Arreglo de enteros.
     * @return Arreglo de doubles.
     */
    public double[] convertirAEnterosADoubles(int[] numeros) {
        double[] resultado = new double[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            resultado[i] = numeros[i];
        }
        return resultado;
    

  
    }

	
		}
	

