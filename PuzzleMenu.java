import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PuzzleMenu {
    JFrame frame;
    JButton[] buttons;
    int currentControls = MOVENEIGHBORS;
    static final int MOVENEIGHBORS = 0;
    static final int MOVEHOLE = 1;
    
    public PuzzleMenu() {
        frame = new JFrame("Choose a puzzle!");
        frame.setBounds(0, 0, 418, 520);
        frame.setLayout(new GridLayout(4,4));        
        
        JButton city = new JButton("CITY");
        city.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifteenGame("Puzzles/CITY/", ".jpg", PuzzleMenu.this);    
                frame.dispose();
            }
        });
        frame.add(city);

        JButton mario = new JButton("MARIO");
        mario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifteenGame("Puzzles/MARIO/", ".jpg", PuzzleMenu.this);
                frame.dispose();
            }
        });
        frame.add(mario);

        JButton numbers = new JButton("NUMBERS");
        numbers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifteenGame("Puzzles/NUMBERS/", ".jpg", PuzzleMenu.this);  
                frame.dispose();
            }
        });
        frame.add(numbers);

        JButton maiden = new JButton("<html><body>IRON<br>MAIDEN</body></html>");
        maiden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifteenGame("Puzzles/IRONMAIDEN/", ".jpg", PuzzleMenu.this);  
                frame.dispose();   
            }
        });
        frame.add(maiden);

        JButton zelda = new JButton("ZELDA");
        zelda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifteenGame("Puzzles/ZELDA/", ".jpg", PuzzleMenu.this);  
                frame.dispose();   
            }
        });
        frame.add(zelda);

        JButton ow = new JButton("<html><body>OUTER<br>WILDS</body></html>");
        ow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifteenGame("Puzzles/OUTERWILDS/", ".jpg", PuzzleMenu.this);  
                frame.dispose();   
            }
        });
        frame.add(ow);

        JButton ada = new JButton("ADA");
        ada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifteenGame("Puzzles/ADA/", ".jpg", PuzzleMenu.this);  
                frame.dispose();   
            }
        });
        frame.add(ada);

        JButton tegnell = new JButton("TEGNELL");
        tegnell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifteenGame("Puzzles/TEGNELL/", ".jpg", PuzzleMenu.this);  
                frame.dispose();   
            }
        });
        frame.add(tegnell);

        JButton spider = new JButton("<html><body>SPIDER-<br>VERSE</body></html>");
        spider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifteenGame("Puzzles/SPIDERVERSE/", ".jpg", PuzzleMenu.this);  
                frame.dispose();   
            }
        });
        frame.add(spider);

        JButton hitman = new JButton("HITMAN");
        hitman.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifteenGame("Puzzles/HITMAN/", ".jpg", PuzzleMenu.this);  
                frame.dispose();   
            }
        });
        frame.add(hitman);

        JButton minecraft = new JButton("<html><body>MINE-<br>CRAFT</body></html>");
        minecraft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifteenGame("Puzzles/MINECRAFT/", ".jpg", PuzzleMenu.this);  
                frame.dispose();   
            }
        });
        frame.add(minecraft);

        JButton rdr = new JButton("<html><body>RED<br>DEAD<br>REDEMPTION</body></html>");
        rdr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FifteenGame("Puzzles/RDR/", ".jpg", PuzzleMenu.this);  
                //frame.dispose();
                frame.dispose();
            }
        });
        frame.add(rdr);
        




        
        JButton settingsButton = new JButton("Settings");
        settingsButton.setBackground(Color.RED);
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SettingsMenu(PuzzleMenu.this);
                frame.dispose();
            }
        });
        frame.add(settingsButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setVisible(true);
    }

    public int getControls() {
        return currentControls;
    }

    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        new PuzzleMenu();
    }
}
