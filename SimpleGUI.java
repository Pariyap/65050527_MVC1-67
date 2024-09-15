import javax.swing.*;
import java.awt.*;

public class SimpleGUI extends JFrame {
    private JButton dynamicButton;

    public SimpleGUI() {
        setTitle("Simple GUI");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        dynamicButton = new JButton("Get bavk to the mountain");
    }

    public void showButton() {
        add(dynamicButton);
        revalidate();
        repaint();
    }

}