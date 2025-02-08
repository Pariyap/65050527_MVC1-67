import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CowView {
    private JFrame frame;

    public CowView() {
        frame = new JFrame("Cow View");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setLocationRelativeTo(null); // Center the window
    }

    public void disableCow() {
        JOptionPane.showMessageDialog(frame, "Your cow is disabled, Sir", "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public void showsMilkamount(int id, int amount) {
        JOptionPane.showMessageDialog(frame, "Milk amount of cow ID: " + id + " is " + amount, "Milk Info",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
