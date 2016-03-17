
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
public class TaquinButton extends JButton {
    private int m_Pos;
    //private int[]
    public TaquinButton(int pos, ImageIcon icon)
    {
        super(Integer.toString(pos), icon);
        
        m_Pos = pos;
    }
}
