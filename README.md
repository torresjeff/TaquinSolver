# TaquinSolver

Para uso con Netbeans 8.0.2+.

Las personas interesadas en crear su propio algoritmo de solución a un tablero de Taquin deben implementar la interfaz ISolver. Para conocer mas sobre la interfaz, ver documentación en ISolver.java.
Luego de haber implementado la interfaz, se debe agregar la clase al arreglo de "players" en TaquinUI.java. Esto se hace por medio de la función "addPlayers".
Ejemplo:

* Para crear el algoritmo de solucion:
//MiAlgoritmoDeSolucion.java - Este archivo lo crea la persona que va a implementar el algoritmo
public class MiAlgoritmoDeSolucion implements ISolver
{
  @Override
  public ArrayList<Integer> solve(int[][] tablero, int n)
  {
      ArrayList<Integer> movimientos = new ArrayList<>();
      // Algoritmo de resolucion del tablero....
      return movimientos;
  }
}

* Para agregar el algoritmo que creamos a la lista de jugadores:
//TaquinUI.java - Este archivo ya viene incluido en el proyecto
public class TaquinUI extends javax.swing.JFrame implements ActionListener
{
  //....
  
  //Esta funcion ya existe en la clase TaquinUI.
  private void addPlayers()
  {
    players.add(new MiAlgoritmoDeSolucion());
    
    //Agregar jugadores adicionales aqui
  }
}
