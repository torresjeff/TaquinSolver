
import java.util.ArrayList;

//Para solucionar el tablero se debe crear una clase que implemente esta interface.
public interface ISolver
{
    //Dado un tablero, debemos retornar una lista con los movimientos que se deben hacer para resolver ese tablero.
    //TODO: poner parametro que se debe pasar
    public ArrayList<Integer> solve();
}
