import javax.swing.*;
import java.awt.*;

public class AllGames2{

    public JPanel createContentPane (){
        
        JPanel totalGUI = new JPanel();
        //setResizable(false);
        
        // We create a JPanel with the GridLayout.
        JPanel mainPanel = new JPanel(new GridLayout(2, 2, 0, 0));
        
        JPanel blue = createSquareJPanel(new Color(159, 179, 243), 400);
        JPanel green = createSquareJPanel(new Color (120, 250, 140), 400);
        JPanel white = createSquareJPanel(Color.white, 400);
        JPanel purple = createSquareJPanel(new Color(204, 153, 255), 400);
      
        mainPanel.add(blue);
        mainPanel.add(green);
        mainPanel.add(white);
        mainPanel.add(purple);

        totalGUI.add(mainPanel);
        totalGUI.setOpaque(true);
        return totalGUI;
    }

    private JPanel createSquareJPanel(Color color, int size)
    {
        JPanel tempPanel = new JPanel();
        tempPanel.setBackground(color);
        tempPanel.setMinimumSize(new Dimension(size, size));
        tempPanel.setMaximumSize(new Dimension(size, size));
        tempPanel.setPreferredSize(new Dimension(size, size));
        return tempPanel;
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("GridLayout");

        AllGames2 demo = new AllGames2();
        frame.setContentPane(demo.createContentPane());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
    public static void main(String[] args) {
    
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}