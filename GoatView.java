import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoatView {
    public void IfoundtheGoat() {
        JFrame frame = new JFrame("Warning");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JButton button = new JButton("Get out!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the window when clicked
            }
        });

        frame.add(button, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }

}
