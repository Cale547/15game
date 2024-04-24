import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.JComponent;

public class FifteenGame {
    private JFrame frame;
	private JTextArea txt = new JTextArea(2,28);
    private int steps;
    private BlockPanel pan;
    private PicComp winComp;
    private boolean gameOver = false;
    private String folder;
    private String extension;
    private PuzzleMenu puzzlemenu;

    public FifteenGame(String f, String e, PuzzleMenu pm) {
        puzzlemenu = pm;
        folder = f;
        extension = e;
        steps = 0;

        frame = new JFrame("Solve the puzzle!");
		frame.setBounds(0, 0, 418, 520);
		// setup layout manager for frame
		frame.setLayout(new BorderLayout());

		JButton northButton = new JButton("North");
		JButton eastButton = new JButton("East");
		JButton southButton = new JButton("South");
		JButton westButton = new JButton("West");

		northButton.addActionListener(event->northButtonPressed());		
		eastButton.addActionListener(event->eastButtonPressed());		
		southButton.addActionListener(event->southButtonPressed());		
		westButton.addActionListener(event->westButtonPressed());		

		// add northButton to a JPanel, add that lpanel to frame
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BorderLayout());
		buttonPane.add(northButton, BorderLayout.NORTH);
		buttonPane.add(eastButton, BorderLayout.EAST);
		buttonPane.add(southButton, BorderLayout.SOUTH);
		buttonPane.add(westButton, BorderLayout.WEST);

		// create other components (text component, e.g.), add them to frame
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		pane.add(buttonPane, BorderLayout.WEST);		
		pane.add(txt, BorderLayout.EAST);
		frame.add(pane, BorderLayout.SOUTH);

		JComponent centerComponent = createCenterComponent();
		// add centerComponent to frame
		frame.add(centerComponent, BorderLayout.CENTER);
		// show frame	
		
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	Not needed when part of PuzzleMenu
		frame.setVisible(true);

        
        createWinComp(f + "result" + e);
        showText("Press a button to start the game");
        txt.setFocusable(false);
        JRootPane rootPane = frame.getRootPane();
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "doWest");
        rootPane.getActionMap().put("doWest",
        new AbstractAction() {
            public void actionPerformed(ActionEvent e) {westButtonPressed();}
        });

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "doEast");
        rootPane.getActionMap().put("doEast",
        new AbstractAction() {
            public void actionPerformed(ActionEvent e) {eastButtonPressed();}
        });

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "doNorth");
        rootPane.getActionMap().put("doNorth",
        new AbstractAction() {
            public void actionPerformed(ActionEvent e) {northButtonPressed();}
        });

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "doSouth");
        rootPane.getActionMap().put("doSouth",
        new AbstractAction() {
            public void actionPerformed(ActionEvent e) {southButtonPressed();}
        });
    }

    public BlockPanel createCenterComponent() {
        pan = new BlockPanel(folder, extension);
        return pan;
    }

    public void createWinComp(String filePath) {
        winComp = new PicComp(new File(filePath));
    }

    public void eastButtonPressed() {
        if (!gameOver) {
            if (puzzlemenu.getControls() == PuzzleMenu.MOVENEIGHBORS && pan.getHole().w != null) {
                pan.switchSpot(pan.getHole(), pan.getHole().w);
                steps++;
                showText("Steps: " + steps);
            } else if (puzzlemenu.getControls() == PuzzleMenu.MOVEHOLE && pan.getHole().e != null) {
                pan.switchSpot(pan.getHole(), pan.getHole().e);
                steps++;
                showText("Steps: " + steps);
            }

            calculateWin(false);
        }
	}

	public void westButtonPressed() {
        if (!gameOver) {
            if (puzzlemenu.getControls() == PuzzleMenu.MOVENEIGHBORS && pan.getHole().e != null) {
                pan.switchSpot(pan.getHole(), pan.getHole().e);
                steps++;
                showText("Steps: " + steps);
            } else if (puzzlemenu.getControls() == PuzzleMenu.MOVEHOLE && pan.getHole().w != null) {
                pan.switchSpot(pan.getHole(), pan.getHole().w);
                steps++;
                showText("Steps: " + steps);
            }

            calculateWin(false);
        }
	}

	public void southButtonPressed() {
        if (!gameOver) {
            if (puzzlemenu.getControls() == PuzzleMenu.MOVENEIGHBORS && pan.getHole().n != null) {
                pan.switchSpot(pan.getHole(), pan.getHole().n);
                steps++;
                showText("Steps: " + steps);
            } else if (puzzlemenu.getControls() == PuzzleMenu.MOVEHOLE && pan.getHole().s != null) {
                pan.switchSpot(pan.getHole(), pan.getHole().s);
                steps++;
                showText("Steps: " + steps);
            }

            calculateWin(false);
        }

        else {
            gameOver = false;
            this.frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            puzzlemenu.getFrame().setState(JFrame.NORMAL);
        }
	}

	public void northButtonPressed() {
        if (!gameOver) {
            if (puzzlemenu.getControls() == PuzzleMenu.MOVENEIGHBORS && pan.getHole().s != null) {
                    pan.switchSpot(pan.getHole(), pan.getHole().s);
                    steps++;
                    showText("Steps: " + steps);
            } else if (puzzlemenu.getControls() == PuzzleMenu.MOVEHOLE && pan.getHole().n != null) {
                    pan.switchSpot(pan.getHole(), pan.getHole().n);
                    steps++;
                    showText("Steps: " + steps);
            } 

            calculateWin(false);
        }

        else {
            gameOver = false;
            steps = 0;
            pan = new BlockPanel(folder, extension);
            frame.remove(winComp);
            frame.add(pan, BorderLayout.CENTER);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setExtendedState(JFrame.NORMAL);
            showText("Press a button to start the game");
        }
	}

    public void calculateWin(boolean autoWin) {
        boolean win = true;
        for (int i = 1; i < pan.b.length + 1; i++) {
            if (i != pan.b[i-1].i) {
                win = false;
                break;
            }
        }
        if (win || autoWin) {
            gameOver = true;
            showText("You won in " + steps + " steps!\nPress 'North' to begin a new game.\nPress 'South' to choose a new puzzle.");
            frame.remove(pan);
            frame.add(winComp, BorderLayout.CENTER);
            //rad 139-140 krävs för att framen ska uppdateras
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setExtendedState(JFrame.NORMAL);    
        }
    }

    public void showText(String text) {
		// update the text component
		txt.setText(text);
	}
    
    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        FifteenGame a = new FifteenGame("Puzzles/NUMBERS/", ".jpg", new PuzzleMenu());
        a.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
