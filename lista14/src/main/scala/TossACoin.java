import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class TossACoin extends JFrame {
    private Random rand = new Random();
    private static final String headsPrefix = "Heads";
    private static final String tailsPrefix = "Tails";
    private static final String buttonPrefix = "Toss a coin";
    private JLabel headsLabel = new JLabel(headsPrefix);
    private JLabel tailsLabel = new JLabel(tailsPrefix);
    private int headsCount = 0;
    private int tailsCount = 0;
    private JButton button;
    private JTextField headsText, tailsText;


    public TossACoin(){
        super("TossACoin");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        headsText = new JTextField(10);
        tailsText = new JTextField(10);
        headsText.setEditable(false);
        tailsText.setEditable(false);
        headsText.setText("0");
        tailsText.setText("0");
        button = new JButton(buttonPrefix);
        button.setMnemonic(KeyEvent.VK_C);
        button.setToolTipText("Keyboard shortcut: Alt+C");
        button.addActionListener((ActionEvent e) -> {
            boolean result = rand.nextBoolean();
            if(result){
                headsCount++;
                headsText.setText("" + headsCount);
            }
            else{
                tailsCount++;
                tailsText.setText("" + tailsCount);
            }
        });

        c.add(headsLabel);
        c.add(headsText);
        c.add(tailsLabel);
        c.add(tailsText);
        c.add(button);
    }


}
