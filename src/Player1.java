
import java.util.ArrayList;


public class Player1 implements ISolver
{
    /**
     * Implementacion de la funcion solve() de la interfaz ISolver. Ver comentarios de la interfaz.
     * El jugador es responsable de hacerle un "swap" a los valores de la matriz para actualizar el tablero segun los movimientos que quiere que se hagan.
     * @param tablero matriz que indica el orden actual de las fichas.
     * @param n tamaño de UNA dimension del tablero.
     * @return Lista que indica las fichas que se deben mover EN ORDEN. Todos los movimientos deben ser legales.
     * Esto quiere decir que una ficha solo se puede mover a una posicion vacia (el espacio vacio tiene un valor de -1 en la matriz/tablero).
     */
    @Override
    public ArrayList<Integer> solve(int[][] tablero, int n)
    {
        System.out.println("Tablero dado: ");
        //System.out.println("" + tablero[0][2]);
        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println("");
        }
        
        ArrayList<Integer> movimientos = new ArrayList<>();
        
        //TODO: reemplazar este codigo por la implementacion verdadera.
        
        //Estamos moviendo las fichas de la ultima columna
        movimientos.add(tablero[n-2][n-1]);
        movimientos.add(tablero[n-3][n-1]);
        movimientos.add(tablero[n-4][n-1]);
        
        return movimientos;
    }
    
}
