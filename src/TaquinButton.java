
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author torre
 */
public class TaquinButton extends JButton implements ActionListener {
    private int m_Pos;
    private int[][] m_Mat;
    private Map<Integer,Map<Integer,Integer>> m_MatrixButtons;
    private int n;
    
    public TaquinButton(int pos, int[][] mat, Map<Integer,Map<Integer,Integer>> matrixButtons, int n, ImageIcon icon)
    {
        super(Integer.toString(pos), icon);
        
        m_Pos = pos;
        m_Mat = mat;
        m_MatrixButtons = matrixButtons;
        this.n = n;
        
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x,y;
        JButton button = (JButton)e.getSource();
        Set<Integer> set = m_MatrixButtons.get(Integer.parseInt(button.getText())-1).keySet();
        y = (Integer)(set.toArray())[0];
        x = m_MatrixButtons.get(Integer.parseInt(button.getText())-1).get(y);
        System.out.println(y+" "+x);
        if( y!=0 && m_Mat[y-1][x]==0){ // UP
            System.out.println("arriba");
            m_Mat[y-1][x] = 1;
            m_Mat[y][x] = 0;
            m_MatrixButtons.get(Integer.parseInt(button.getText())-1).clear();
            m_MatrixButtons.get(Integer.parseInt(button.getText())-1).put(y-1,x);
            button.setLocation(button.getX(), button.getY() - button.getHeight());  // Movimiento hacia arriba
        }else{
            if( x!=0 && m_Mat[y][x-1]==0){ // Left
                System.out.println("izquierda");
                m_Mat[y][x-1] = 1;
                m_Mat[y][x] = 0;
                m_MatrixButtons.get(Integer.parseInt(button.getText())-1).clear();
                m_MatrixButtons.get(Integer.parseInt(button.getText())-1).put(y,x-1);
                button.setLocation(button.getX() - button.getWidth(), button.getY());  // Movimiento hacia la izquierda
            }else{
                if( y!=(n-1) && m_Mat[y+1][x]==0){ // Down
                    System.out.println("abajo");
                    m_Mat[y+1][x] = 1;
                    m_Mat[y][x] = 0;
                    m_MatrixButtons.get(Integer.parseInt(button.getText())-1).clear();
                    m_MatrixButtons.get(Integer.parseInt(button.getText())-1).put(y+1,x);
                    button.setLocation(button.getX(), button.getY()+button.getHeight());  // Movimiento hacia abajo
                }else{
                    if( x!=(n-1) && m_Mat[y][x+1]==0){ // Right
                        System.out.println("derecha");
                        m_Mat[y][x+1] = 1;
                        m_Mat[y][x] = 0;
                        m_MatrixButtons.get(Integer.parseInt(button.getText())-1).clear();
                        m_MatrixButtons.get(Integer.parseInt(button.getText())-1).put(y,x+1);
                        button.setLocation(button.getX() + button.getWidth(), button.getY());  // Movimiento hacia la derecha
                    }
                }
            }
        }
    }
}
