
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TaquinUI extends javax.swing.JFrame
{

    ArrayList<JButton> buttons;
    final int DISTANCE_X = 178;
    final int DISTANCE_Y = 116;
    final int LIMIT_X = 536;
    final int LIMIT_Y = 350;
    
    /**
     * Creates new form TaquinUI
     */
    public TaquinUI(int n) {
        initComponents();
        buttons = new ArrayList<>();
        //TODO: ver GridBagLayout
        getContentPane().setLayout(new GridLayout(n, n));
        
        for (int i = 0; i < (n * n)-1; ++i)
        {
            //Las imagenes son opcionales, se deben colocar en la carpeta "imagenes" y su nombre debe ser "1", "2", ..., "n", y deben estar en formato "jpg".
            buttons.add(new JButton(Integer.toString(i+1), new ImageIcon("imagenes/" + Integer.toString(i+1) + ".jpg")));
            add(buttons.get(i));
        }
        
        buttonsPerformed();
    }
    
    public void buttonsPerformed(){
        buttons.get(0).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });
        buttons.get(1).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        buttons.get(2).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        buttons.get(3).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        buttons.get(4).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        buttons.get(5).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        buttons.get(6).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        buttons.get(7).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        buttons.get(8).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        buttons.get(9).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        buttons.get(10).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        buttons.get(11).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        buttons.get(12).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        buttons.get(13).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        buttons.get(14).addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
    }
    
    /*public void buttonsAction(){
    }*/
    
    /*
        Botón 1, según el grid.
    */
    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 0,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 2, según el grid.
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 1,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 3, según el grid.
    */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 2,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 4, según el grid.
    */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 3,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 5, según el grid.
    */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 4,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 6, según el grid.
    */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 5,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 7, según el grid.
    */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 6,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 8, según el grid.
    */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 7,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 9, según el grid.
    */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 8,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 10, según el grid.
    */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 9,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 11, según el grid.
    */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 10,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 12, según el grid.
    */
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 11,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 13, según el grid.
    */
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 12,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 14, según el grid.
    */
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 13,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }
    
    /*
        Botón 15, según el grid.
    */
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {
        // Si es instancia de JPanel significa que la puedo mover.
        int i = 14,x,y;
        x = buttons.get(i).getX();
        y = buttons.get(i).getY()-DISTANCE_Y;
        if( getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Up
            buttons.get(i).setLocation(x, y);
        }else{
            x = buttons.get(i).getX()-DISTANCE_X;
            y = buttons.get(i).getY();
            if(getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Left{
                buttons.get(i).setLocation(x, y);
            }else{
                x = buttons.get(i).getX();
                y = buttons.get(i).getY()+DISTANCE_Y;
                if(y < LIMIT_Y && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Down
                    buttons.get(i).setLocation(x, y);
                }else{
                    x = buttons.get(i).getX()+DISTANCE_X;
                    y = buttons.get(i).getY();
                    if(x < LIMIT_X && getContentPane().getComponentAt(x, y) instanceof JPanel){  //  Right
                        buttons.get(i).setLocation(x, y);
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaquinUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaquinUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaquinUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaquinUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TaquinUI ui = new TaquinUI(4);
                ui.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
