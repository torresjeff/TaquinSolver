
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class TaquinUI extends javax.swing.JFrame implements ActionListener
{
    private JPanel m_PanelGridTaquin;
    private JPanel m_PanelOptions;
    private JFileChooser fc;
    private String fileName;
    //private String fileName;
    
    //Botones de opciones
    private JButton m_ButtonImageChooser;
    private JButton m_ButtonUnsortGrid;
    private JLabel m_LabelGridSize;
    private JComboBox<Integer> m_ComboSize;
    
    private ArrayList<JButton> buttons;
    private int[][] matrixGrid;
    private Map<Integer,Map<Integer,Integer>> matrixButtons;
    private int n = 4;
    
    /**
     * Inicializacion de la matriz: matrixGrid
     */
    public void initMatrix(){
        int k = 0;
        matrixGrid = new int[n][n];
        matrixButtons = new HashMap<>();
        for(int i = 0; i < n*n;i++)
            matrixButtons.put(i, new HashMap<>());
        for(int i = 0;i < n;i++){
            for(int j = 0;j<n;j++){
                matrixGrid[i][j] = 1;
                matrixButtons.get(k).put(i, j);
                k++;
            }
        }
        matrixGrid[n-1][n-1] = 0;  // cero significa vacio
    }
    
    /**
     * Creates new form TaquinUI
     */
    public TaquinUI() {
        initComponents();
        buttons = new ArrayList<>();
        //fileName = "images/download3.jpg";
        fileName = "";
        
        //Inicializar los paneles y sus botones
        JPanel contentPane;
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        //TAQUIN GRID
        m_PanelGridTaquin = new JPanel();
        contentPane.add(m_PanelGridTaquin);
        
        //PANEL DE OPCIONES
        m_PanelOptions = new JPanel();
        //panel_options.setLayout(new BoxLayout(panel_options, BoxLayout.Y_AXIS));
        contentPane.add(m_PanelOptions);
        
        resetGrid();
        
        initOptionsMenu();
        
        //addButtons();
        
    }
    
    private void initOptionsMenu()
    {
        m_PanelOptions.add(m_ButtonImageChooser = new JButton("Buscar imagen..."));
        
        //Label - tamaño del grid
        m_PanelOptions.add(m_LabelGridSize = new JLabel("Tamaño: "));
        
        //COMBOBOX
        m_PanelOptions.add(m_ComboSize = new JComboBox<>());
        for (int i = 2; i <= 10; ++i)
        {
            m_ComboSize.addItem(i);
        }
        m_ComboSize.setSelectedIndex(2);
        m_ComboSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n = (Integer)m_ComboSize.getSelectedItem();
                TaquinUI.this.resetGrid();
                System.out.println("Se escogio el tamaño: " + n);
            }
        });
        
        m_ButtonImageChooser.addActionListener(this);
        m_PanelOptions.add(m_ButtonUnsortGrid = new JButton("Desordenar tablero"));
        
        
        fc = new JFileChooser();
        fc.setCurrentDirectory(new File("images/")); //El file chooser se abre por defecto en la carpeta "images/"
    }
    
    private void addButtons()
    {
        try {
            //TODO: escoger imagen en runtime
            ImageSplitter.Split(fileName, n, n);
        } catch (IOException ex) {
            Logger.getLogger(TaquinUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < (n * n)-1; ++i)
        {
            System.out.println("addButtons - i = "+i);
            //Las imagenes son opcionales
            JButton button = new JButton(Integer.toString(i+1), new StretchIcon("images/" + Integer.toString(i+1) + ".jpg"));
            buttons.add(button);
            buttons.get(i).addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TaquinUI.this.buttonPerformed(e);
                }
            });
            m_PanelGridTaquin.add(buttons.get(i));
        }
        
        System.out.println("addButtons - n = "+n);
    }
    
    private void buttonPerformed(ActionEvent e){
        int x,y;
        JButton button = (JButton)e.getSource();
        Set<Integer> set = matrixButtons.get(Integer.parseInt(button.getText())-1).keySet();
        y = (Integer)(set.toArray())[0];
        x = matrixButtons.get(Integer.parseInt(button.getText())-1).get(y);
        System.out.println(y+" "+x);
        if( y!=0 && matrixGrid[y-1][x]==0){ // UP
            System.out.println("arriba");
            matrixGrid[y-1][x] = 1;
            matrixGrid[y][x] = 0;
            matrixButtons.get(Integer.parseInt(button.getText())-1).clear();
            matrixButtons.get(Integer.parseInt(button.getText())-1).put(y-1,x);
            button.setLocation(button.getX(), button.getY() - button.getHeight());  // Movimiento hacia arriba
        }else{
            if( x!=0 && matrixGrid[y][x-1]==0){ // Left
                System.out.println("izquierda");
                matrixGrid[y][x-1] = 1;
                matrixGrid[y][x] = 0;
                matrixButtons.get(Integer.parseInt(button.getText())-1).clear();
                matrixButtons.get(Integer.parseInt(button.getText())-1).put(y,x-1);
                button.setLocation(button.getX() - button.getWidth(), button.getY());  // Movimiento hacia la izquierda
            }else{
                if( y!=(n-1) && matrixGrid[y+1][x]==0){ // Down
                    System.out.println("abajo");
                    matrixGrid[y+1][x] = 1;
                    matrixGrid[y][x] = 0;
                    matrixButtons.get(Integer.parseInt(button.getText())-1).clear();
                    matrixButtons.get(Integer.parseInt(button.getText())-1).put(y+1,x);
                    button.setLocation(button.getX(), button.getY()+button.getHeight());  // Movimiento hacia abajo
                }else{
                    if( x!=(n-1) && matrixGrid[y][x+1]==0){ // Right
                        System.out.println("derecha");
                        matrixGrid[y][x+1] = 1;
                        matrixGrid[y][x] = 0;
                        matrixButtons.get(Integer.parseInt(button.getText())-1).clear();
                        matrixButtons.get(Integer.parseInt(button.getText())-1).put(y,x+1);
                        button.setLocation(button.getX() + button.getWidth(), button.getY());  // Movimiento hacia la derecha
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
        setTitle("Taquin Solver");
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 914, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
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
                TaquinUI ui = new TaquinUI();
                ui.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m_ButtonImageChooser)
        {
            int returnVal = fc.showOpenDialog(this);
            
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                fileName = file.getAbsolutePath();
                
                try {
                    ImageSplitter.Split(fileName, n, n);
                    //repaint();
                } catch (IOException ex) {
                    Logger.getLogger(TaquinUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println("Se escogió el archivo: " + fileName);
            }
            else
            {
                System.out.println("Cancelado");
            }
            
        }
    }

    private void resetGrid() {
        m_PanelGridTaquin.removeAll();
        m_PanelGridTaquin.setLayout(new GridLayout(n, n, 0, 0));
        
        int rows = ((GridLayout)m_PanelGridTaquin.getLayout()).getRows();
        int cols = ((GridLayout)m_PanelGridTaquin.getLayout()).getColumns();
        
        System.out.println("Grid: r="+rows+",c="+cols);
        
        initMatrix();
        
        addButtons();
        
        m_PanelGridTaquin.revalidate();
        m_PanelGridTaquin.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
