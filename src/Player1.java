
import java.util.ArrayList;


public class Player1 implements ISolver
{
    /**
     * Implementacion de la funcion solve() de la interfaz ISolver. Ver comentarios de la interfaz.
     * El jugador es responsable de hacerle un "swap" a los valores de la matriz para actualizar el tablero segun los movimientos que se van haciendo.
     * @param tablero matriz que indica el orden actual de las fichas.
     * @param n tamaño de UNA dimension del tablero.
     * @return Lista que indica las fichas que se deben mover EN ORDEN. Todos los movimientos deben ser legales.
     * Esto quiere decir que una ficha solo se puede mover a una posicion vacia (el espacio vacio tiene un valor de -1 en la matriz/tablero).
     */
    @Override
    public ArrayList<Integer> solve(int[][] tablero, int n)
    {
        System.out.println("Tablero dado: ");
        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println("");
        }
        
        
        ArrayList<Integer> movimientos = new ArrayList<>();
        int aux;
        
        //TODO: REEMPLAZAR ESTE CODIGO POR LA IMPLEMENTACION VERDADERA.
        
        //Estamos moviendo las fichas de la ultima columna
        //1er movimiento
        movimientos.add(tablero[n-2][n-1]);
        aux = tablero[n-2][n-1];
        tablero[n-2][n-1] = -1;
        tablero[n-1][n-1] = aux; //Actualizamos las fichas del tablero, cambiando el espacio vacio por la ficha que acabamos de mover. Esto es una función swap.
        
        //2do movimiento
        movimientos.add(tablero[n-3][n-1]);
        aux = tablero[n-3][n-1];
        tablero[n-3][n-1] = -1;
        tablero[n-2][n-1] = aux;
        
        //3er movimiento
        movimientos.add(tablero[n-4][n-1]);
        aux = tablero[n-4][n-1];
        tablero[n-4][n-1] = -1;
        tablero[n-3][n-1] = aux;
        
        
        System.out.println("Tablero final: ");
        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println("");
        }
        
        return movimientos;
    }
    
}
