
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Random;


public class TaquinUI extends javax.swing.JFrame implements ActionListener
{
    private JPanel m_PanelGridTaquin;
    private JPanel m_PanelOptions;
    private JFileChooser m_FileChooser;
    private String m_FileName;
    private ArrayList<ISolver> players;
    
    
    //Botones de opciones
    private JButton m_ButtonImageChooser;
    private JButton m_ButtonUnsortGrid;
    private JLabel m_LabelGridSize;
    private JComboBox<Integer> m_ComboSize;
    private JLabel m_LabelPlayer;
    private JComboBox<String> m_ComboPlayer;
    private JButton m_ButtonSolve;
    
    private ArrayList<JButton> m_Buttons;
    private int[][] m_MatrixGrid;
    private Map<Integer,Map<Integer,Integer>> m_MatrixButtons;
    private int n = 4;
    private int m_CurrentPlayer;
    
    /**
     * Inicializacion de la matriz m_MatrixGrid.
     * Esta funcion llena la matriz de enteros m_MatrixGrid con valores desde 0 hasta n - 2. Estos valores indican el orden de las fichas en el tablero.
     * Un valor de -1 indica el espacio vacio del tablero. Debe haber un solo valor -1 en toda la matriz.
     * Ejemplo para un tablero 3x3 ordenado:
     * m_Matrix Grid = 
     *   [[ 0 1 2  ]
     *    [ 3 4 5  ]
     *    [ 6 7 -1 ]]
     * 
     * Ejemplo para un tablero 3x3 ordenado al reves:
     * m_Matrix Grid = 
     *   [[ 7 6 5  ]
     *    [ 4 3 2  ]
     *    [ 1 0 -1 ]]
     * 
     * Un tablero solucionado debe quedar en orden ascendente de 0 hasta n-2 (como el primer ejemplo).
     */
    public void initMatrix(){
        int k = 0;
        m_MatrixGrid = new int[n][n];
        m_MatrixButtons = new HashMap<>();
        for(int i = 0; i < n*n;i++)
            m_MatrixButtons.put(i, new HashMap<>());
        
        
        for(int i = 0;i < n;i++){
            for(int j = 0;j<n;j++){
                m_MatrixGrid[i][j] = (i*n)+j;
                m_MatrixButtons.get(k).put(i, j);
                k++;
            }
        }
        m_MatrixGrid[n-1][n-1] = -1;  // -1 significa vacio
    }
    
    /**
     * Creates new form TaquinUI
     */
    public TaquinUI() {
        initComponents();
        m_Buttons = new ArrayList<>();
        players = new ArrayList<>();
        
        addPlayers();
        
        m_FileName = "";
        
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
        m_PanelOptions.setLayout(new BoxLayout(m_PanelOptions, BoxLayout.Y_AXIS));
        contentPane.add(m_PanelOptions);
        
        resetGrid(true);
        
        initOptionsMenu();
    }
    
    /**
     * Inicializacion de botones/comboboxes/etc. de las opciones del usuario.
     */
    private void initOptionsMenu()
    {
        m_PanelOptions.add(m_ButtonImageChooser = new JButton("Buscar imagen..."));
        m_PanelOptions.setMaximumSize(new Dimension(300, 500));
        m_PanelOptions.setPreferredSize(new Dimension(300, 500));
        
        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new GridLayout(1, 2));
        sizePanel.setMaximumSize(new Dimension(200, 30));
        sizePanel.setPreferredSize(new Dimension(200, 30));
        m_PanelOptions.add(sizePanel);
        
        //Label - tamaño del grid
        sizePanel.add(m_LabelGridSize = new JLabel("Tamaño: "));
        
        //COMBOBOX TAMAÑO TABLERO
        sizePanel.add(m_ComboSize = new JComboBox<>());
        
        for (int i = 2; i <= 10; ++i)
        {
            m_ComboSize.addItem(i);
        }
        m_ComboSize.setSelectedIndex(2);
        m_ComboSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n = (Integer)m_ComboSize.getSelectedItem();
                TaquinUI.this.resetGrid(true);
                System.out.println("Se escogio el tamaño: " + n);
            }
        });
        
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(1, 2));
        playerPanel.setMaximumSize(new Dimension(200, 30));
        playerPanel.setPreferredSize(new Dimension(200, 30));
        m_PanelOptions.add(playerPanel);
        
        //Label - Jugador actual
        playerPanel.add(m_LabelPlayer = new JLabel("Player: "));
        
        //COMBOBOX JUGADOR ACTUAL
        playerPanel.add(m_ComboPlayer = new JComboBox<>());
        for (int i = 0; i < players.size(); ++i)
        {
            m_ComboPlayer.addItem(players.get(i).getClass().getName());
        }
        m_ComboPlayer.setSelectedIndex(0);
        m_ComboPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaquinUI.this.m_CurrentPlayer = m_ComboPlayer.getSelectedIndex();
                TaquinUI.this.resetGrid(true);
                System.out.println("Se escogio el tamaño: " + n);
            }
        });
        
        
        m_PanelOptions.add(m_ButtonUnsortGrid = new JButton("Desordenar tablero"));
        
        m_PanelOptions.add(m_ButtonSolve = new JButton("Solucionar"));
        m_ButtonSolve.addActionListener(this);
        
        m_ButtonImageChooser.addActionListener(this);
        
        m_FileChooser = new JFileChooser();
        m_FileChooser.setCurrentDirectory(new File("images/")); //El file chooser se abre por defecto en la carpeta "images/"
        m_ButtonUnsortGrid.addActionListener(this);
    }
    
    /**
     * Esta funcion agrega los botones necesarios para jugar Taquin. El numero de botones agregados depende del tamaño del tablero escogido.
     * @param option verdadero si se quiere crear un tablero organizado, falso si se quiere crear un tablero aleatorio.
     */
    private void addButtons(boolean option)
    {
        if(option)// Cualquier operación excepto la de desordenar
        {
            for (JButton b : m_Buttons)
            {
                ImageIcon i = (ImageIcon) b.getIcon();
                i.getImage().flush(); // Flush para clear el cache de la imagen. Sino se sigue mostrando la imagen anterior.
            }

            m_Buttons.clear();

            try {
                ImageSplitter.Split(m_FileName, n, n);
            } catch (IOException ex) {
                Logger.getLogger(TaquinUI.class.getName()).log(Level.SEVERE, null, ex);
            }


            for (int i = 0; i < (n * n)-1; ++i)
            {
                //Las imagenes son opcionales
                JButton button = new JButton(Integer.toString(i), new StretchIcon("images/" + Integer.toString(i+1) + ".jpg"));
                m_Buttons.add(button);
                m_Buttons.get(i).addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        TaquinUI.this.buttonPerformed(e);
                    }
                });

                m_PanelGridTaquin.add(m_Buttons.get(i));
            }
        }
        else//Opción de desordenar
        {
            int[] temp_array = new int [n*n];
            int cont = 1, pos;
            Random rn = new Random();
            for(int i=0; i<n*n; i++)
            {
                temp_array[i]=0;
            }
            while(cont < n*n)
            {
                pos = rn.nextInt(n*n-1);
                if(temp_array[pos]==0)
                {
                    temp_array[pos]=cont;
                    cont++;
                }
            }
            
            //m_Buttons.clear();
            
            for (int i = 0; i < (n * n)-1; ++i)
            {
                //Las imagenes son opcionales
                JButton button = new JButton(Integer.toString(temp_array[i]-1), new StretchIcon("images/" + Integer.toString(temp_array[i]) + ".jpg"));
                m_Buttons.set(temp_array[i]-1,button);
                m_Buttons.get(temp_array[i]-1).addActionListener(new java.awt.event.ActionListener() {
                
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        TaquinUI.this.buttonPerformed(e);
                    }
                });

                
                m_PanelGridTaquin.add(m_Buttons.get(temp_array[i]-1));
                
                m_MatrixButtons.get(Integer.parseInt(button.getText())).clear();
                m_MatrixButtons.get(Integer.parseInt(button.getText())).put(i/n,i%n);
                
                m_MatrixGrid[i/n][i%n]=temp_array[i]-1;

            }
        }

    }
    
    /**
     * Funcion que responde a un click en los botones del Taquin. Se encarga de mover el boton a la posicion vacia.
     * @param e tipo de evento accionado.
     */
    private void buttonPerformed(ActionEvent e){
        int x,y;
        JButton button = (JButton)e.getSource();
        Set<Integer> set = m_MatrixButtons.get(Integer.parseInt(button.getText())).keySet();
        y = (Integer)(set.toArray())[0];
        x = m_MatrixButtons.get(Integer.parseInt(button.getText())).get(y);
        System.out.println(y+" "+x);
        if( y!=0 && m_MatrixGrid[y-1][x]==-1){ // UP
            System.out.println("arriba");
            m_MatrixGrid[y-1][x] = m_MatrixGrid[y][x];
            m_MatrixGrid[y][x] = -1;
            m_MatrixButtons.get(Integer.parseInt(button.getText())).clear();
            m_MatrixButtons.get(Integer.parseInt(button.getText())).put(y-1,x);
            button.setLocation(button.getX(), button.getY() - button.getHeight());  // Movimiento hacia arriba
        }else{
            if( x!=0 && m_MatrixGrid[y][x-1]==-1){ // Left
                System.out.println("izquierda");
                m_MatrixGrid[y][x-1] = m_MatrixGrid[y][x];
                m_MatrixGrid[y][x] = -1;
                m_MatrixButtons.get(Integer.parseInt(button.getText())).clear();
                m_MatrixButtons.get(Integer.parseInt(button.getText())).put(y,x-1);
                button.setLocation(button.getX() - button.getWidth(), button.getY());  // Movimiento hacia la izquierda
            }else{
                if( y!=(n-1) && m_MatrixGrid[y+1][x]==-1){ // Down
                    System.out.println("abajo");
                    m_MatrixGrid[y+1][x] = m_MatrixGrid[y][x];
                    m_MatrixGrid[y][x] = -1;
                    m_MatrixButtons.get(Integer.parseInt(button.getText())).clear();
                    m_MatrixButtons.get(Integer.parseInt(button.getText())).put(y+1,x);
                    button.setLocation(button.getX(), button.getY()+button.getHeight());  // Movimiento hacia abajo
                }else{
                    if( x!=(n-1) && m_MatrixGrid[y][x+1]==-1){ // Right
                        System.out.println("derecha");
                        m_MatrixGrid[y][x+1] = m_MatrixGrid[y][x];
                        m_MatrixGrid[y][x] = -1;
                        m_MatrixButtons.get(Integer.parseInt(button.getText())).clear();
                        m_MatrixButtons.get(Integer.parseInt(button.getText())).put(y,x+1);
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

    /**
     * Responde a eventos
     * @param e tipo de evento accionado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m_ButtonImageChooser)
        {
            int returnVal = m_FileChooser.showOpenDialog(this);
            
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = m_FileChooser.getSelectedFile();
                m_FileName = file.getAbsolutePath();

                resetGrid(true);
                
                System.out.println("Se escogió el archivo: " + m_FileName);
            }
            else
            {
                System.out.println("Cancelado");
            }
            
        }
        else if (e.getSource() == m_ButtonSolve)
        {
            solve();
        }
        else if (e.getSource() == m_ButtonUnsortGrid)
        {
            resetGrid(false);
        }
    }

    /**
     * Repinta los botones del Taquin. Cada vez que el tablero cambia de tamaño se llama esta funcion.
     */
    private void resetGrid(boolean option) {
        m_PanelGridTaquin.removeAll();
        m_PanelGridTaquin.setLayout(new GridLayout(n, n, 0, 0));
        
        initMatrix();
        
        addButtons(option);
        
        m_PanelGridTaquin.revalidate();
        m_PanelGridTaquin.repaint();
    }

    /**
     * Resuelve el tablero actual segun el jugador que esta escogido.
     */
    private void solve() {
        ArrayList<Integer> movimientos = players.get(m_CurrentPlayer).solve(deepCopyIntMatrix(m_MatrixGrid), n);
        
        System.out.print("Movimientos para solucionar el tablero: ");
        
        for (Integer i : movimientos)
        {
            System.out.print(i + " ");
        }
        System.out.println("");
        
        ThreadButton th = new ThreadButton(n, movimientos, m_Buttons, m_MatrixGrid, m_MatrixButtons);
        th.start();
    }
    
    /**
     * Hacemos una copia del tablero para pasarselo a la clase que implemente la funcion solve. Esto lo hacemos con el fin de que no se cambien los valores
     * del tablero de TaquinUI.
     * @param input matriz a clonar
     * @return matriz con los mismos valores pero una referencia diferente.
     */
    int[][] deepCopyIntMatrix(int[][] input) {
        if (input == null)
            return null;
        int[][] result = new int[input.length][];
        
        for (int r = 0; r < input.length; r++) {
            result[r] = input[r].clone();
        }
        
        return result;
    }

    /**
     * En esta funcion agregamos a los jugadores. Los jugadores deben implementar la clase ISolver.
     */
    private void addPlayers() {
        players.add(new Player1());
        
        //Agregar jugadores adicionales aqui
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
