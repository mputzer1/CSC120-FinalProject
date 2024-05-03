import javax.swing.*;
import java.awt.*;


/**
 * Display image class attributes
 */
public class DisplayImage extends JFrame {
    private JLabel label;
    

    /**
     * Constructor for display image class
     */
    public DisplayImage() {
        setTitle("Image Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        label = new JLabel();

        getContentPane().add(label, BorderLayout.CENTER);

        //set initial image of lab for game start
        ImageIcon initialIcon = new ImageIcon("lab.png");
        label.setIcon(initialIcon);
    }
    
    /**
     * Updates image as game progresses
     * @param imagePath string for image
     */
    public void updateImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        label.setIcon(icon);
    }
}
