import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SettingsMenu {
    JFrame frame;
    PuzzleMenu pm;

    public SettingsMenu(PuzzleMenu puz) {
        pm = puz;

        frame = new JFrame("Change the settings!");
        frame.setBounds(0, 0, 418, 520);
        frame.setLayout(new GridLayout(4,4));

        JButton controlsButton = new JButton("<html><body>Toggle controls<br>Current: Move neighbors</body></html>");
        controlsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pm.currentControls == PuzzleMenu.MOVENEIGHBORS) {
                    pm.currentControls = PuzzleMenu.MOVEHOLE;
                    controlsButton.setText("<html><body>Toggle controls<br>Current: Move hole</body></html>");
                } else {
                    pm.currentControls = PuzzleMenu.MOVENEIGHBORS;
                    controlsButton.setText("<html><body>Toggle controls<br>Current: Move neighbors</body></html>");
                }
            }
        });
        frame.add(controlsButton);

        JButton back = new JButton("Back to Puzzle menu");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pm.getFrame().setState(JFrame.NORMAL);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        frame.add(back);

        


		frame.setVisible(true);


    }


}