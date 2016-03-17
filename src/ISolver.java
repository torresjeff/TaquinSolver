
import java.util.ArrayList;

/**
 * Para solucionar el tablero se debe crear una clase que implemente esta interface.
 * */
public interface ISolver
{
    /**
     * Todo jugador debe implementar esta función para solucionar un tablero dado.
     * @param tablero matriz de enteros con valores desde 0 hasta n - 2. Estos valores indican el orden de las fichas en el tablero.
     * Un valor de -1 indica el espacio vacio del tablero. Debe haber un solo valor -1 en toda la matriz.
     * Ejemplo para un tablero 3x3 ordenado:
     * tablero = 
     *   [[ 0 1 2  ]
     *    [ 3 4 5  ]
     *    [ 6 7 -1 ]]
     * 
     * Ejemplo para un tablero 3x3 ordenado al reves:
     * tablero = 
     *   [[ 7 6 5  ]
     *    [ 4 3 2  ]
     *    [ 1 0 -1 ]]
     * 
     * Un tablero solucionado debe quedar en orden ascendente de 0 hasta n-2 (como el primer ejemplo).
     * 
     * @param n tamaño de UNA dimension del tablero.
     * @return Lista que indica las fichas que se deben mover, esta lista debe estar en el orden en que se deben hacer los movimientos.
     * Los elementos de la lista son el numero de la ficha que se debe mover (corresponde a los valores de la matriz).
     * Todos los movimientos deben ser legales. Esto quiere decir que una ficha solo se puede mover a una posicion vacia (el espacio vacio tiene un valor de -1 en la matriz/tablero).
     */
    public ArrayList<Integer> solve(int[][] tablero, int n);
}
