import javax.swing.*;

public class zad1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                TossACoin frame = new TossACoin();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(150, 200);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
    }
}
