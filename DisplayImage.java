import javax.swing.*;
import java.awt.*;
/*
 * class to implement graphics for lab and biomes
 */
public class DisplayImage extends JFrame {

    private JLabel label;
    
    public DisplayImage() {
        setTitle("Image Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        label = new JLabel();

        getContentPane().add(label, BorderLayout.CENTER);

        /*
         * sets initial image for start of game (lab image)
         */
        ImageIcon initialIcon = new ImageIcon("cs120_lab_image.png");
        label.setIcon(initialIcon);
    }
    /*
     * method to update image as game progresses through biomes
     * @param imagePath 
     */
    public void updateImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        label.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DisplayImage imageDisplay = new DisplayImage();
            imageDisplay.setVisible(true);
        });
    }
}
