
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class ThreadButton extends Thread implements Runnable{
    
    private ArrayList<Integer> array;
    private ArrayList<JButton> m_Buttons;
    private int[][] m_MatrixGrid;
    private Map<Integer,Map<Integer,Integer>> m_MatrixButtons;
    private int n;

    public ThreadButton(int n, ArrayList<Integer> array, ArrayList<JButton> m_Buttons, int[][] m_MatrixGrid, Map<Integer, Map<Integer, Integer>> m_MatrixButtons) {
        super();
        this.n = n;
        this.array = array;
        this.m_Buttons = m_Buttons;
        this.m_MatrixGrid = m_MatrixGrid;
        this.m_MatrixButtons = m_MatrixButtons;
    }
    
    @Override
    public void run(){
        int i = 0;
        while(i < array.size()){
            JButton button = m_Buttons.get(array.get(i));
            
            for (int j = 0; j < n; ++j)
            {
                for (int k = 0; k < n; ++k)
                {
                    System.out.print(m_MatrixGrid[j][k] + "\t");
                }
                System.out.println("");
            }
            
            Set<Integer> set = m_MatrixButtons.get(Integer.parseInt(button.getText())).keySet();
            int r = (Integer)(set.toArray())[0];
            int c = m_MatrixButtons.get(Integer.parseInt(button.getText())).get(r);
            
            System.out.println("r="+r+",c="+c);
            
            if( r!=0 && m_MatrixGrid[r-1][c]==-1){ // UP
                System.out.println("arriba");
                m_MatrixGrid[r-1][c] = m_MatrixGrid[r][c];
                m_MatrixGrid[r][c] = -1;
                m_MatrixButtons.get(Integer.parseInt(button.getText())).clear();
                m_MatrixButtons.get(Integer.parseInt(button.getText())).put(r-1,c);
                button.setLocation(button.getX(), button.getY() - button.getHeight());  // Movimiento hacia arriba
            }else{
                
                if( c!=0 && m_MatrixGrid[r][c-1]==-1){ // Left
                    System.out.println("izquierda");
                    m_MatrixGrid[r][c-1] = m_MatrixGrid[r][c];
                    m_MatrixGrid[r][c] = -1;
                    m_MatrixButtons.get(Integer.parseInt(button.getText())).clear();
                    m_MatrixButtons.get(Integer.parseInt(button.getText())).put(r,c-1);
                    button.setLocation(button.getX() - button.getWidth(), button.getY());  // Movimiento hacia la izquierda
                }else{
                    if( r!=(n-1) && m_MatrixGrid[r+1][c]==-1){ // Down
                        System.out.println("abajo");
                        m_MatrixGrid[r+1][c] = m_MatrixGrid[r][c];
                        m_MatrixGrid[r][c] = -1;
                        m_MatrixButtons.get(Integer.parseInt(button.getText())).clear();
                        m_MatrixButtons.get(Integer.parseInt(button.getText())).put(r+1,c);
                        button.setLocation(button.getX(), button.getY()+button.getHeight());  // Movimiento hacia abajo
                    }else{
                        if( c!=(n-1) && m_MatrixGrid[r][c+1]==-1){ // Right
                            System.out.println("derecha");
                            m_MatrixGrid[r][c+1] = m_MatrixGrid[r][c];
                            m_MatrixGrid[r][c] = -1;
                            m_MatrixButtons.get(Integer.parseInt(button.getText())).clear();
                            m_MatrixButtons.get(Integer.parseInt(button.getText())).put(r,c+1);
                            button.setLocation(button.getX() + button.getWidth(), button.getY());  // Movimiento hacia la derecha
                        }
                    }
                }
            }
            try {
                Thread.sleep(3000);
                i++;
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadButton.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
