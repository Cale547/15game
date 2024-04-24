import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.JComponent;

public class FifteenGame extends Presenter {
    private BlockPanel pan;
    private PicComp winComp;
    private boolean gameOver = false;

    public FifteenGame() {
        createWinComp(pan.folder + "result" + pan.extension);
        showText("Press a button to start the game");

        JRootPane rootPane = getFrame().getRootPane();
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
        pan = new BlockPanel();
        return pan;
    }

    public void createWinComp(String filePath) {
        winComp = new PicComp(new File(filePath));
    }

    public void eastButtonPressed() {
        if (pan.getHole().w != null && !gameOver) {
            showText(pan.getHole().w.i + " moved EAST");
            pan.switchSpot(pan.getHole(), pan.getHole().w);
            calculateWin(false);
        }
	}

	public void westButtonPressed() {
        if (pan.getHole().e != null && !gameOver) {
            showText(pan.getHole().e.i + " moved WEST");
            pan.switchSpot(pan.getHole(), pan.getHole().e);
            calculateWin(false);
        }
	}

	public void southButtonPressed() {
        if (pan.getHole().n != null && !gameOver) {
            showText(pan.getHole().n.i + " moved SOUTH");
            pan.switchSpot(pan.getHole(), pan.getHole().n);
            calculateWin(false);
        }
	}

	public void northButtonPressed() {
        if (pan.getHole().s != null && !gameOver) {
            showText(pan.getHole().s.i + " moved NORTH");
            pan.switchSpot(pan.getHole(), pan.getHole().s);
            calculateWin(false);
            return;
        }

        if (gameOver) {
            gameOver = false;
            pan = new BlockPanel();
            getFrame().remove(winComp);
            getFrame().add(pan, BorderLayout.CENTER);
            getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
            getFrame().setExtendedState(JFrame.NORMAL);
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
            showText("You win! Press 'North' to begin a new game.");
            getFrame().remove(pan);
            getFrame().add(winComp, BorderLayout.CENTER);
            //rad 139-140 krävs för att framen ska uppdateras
            getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
            getFrame().setExtendedState(JFrame.NORMAL);    
            
        }
    }

    public static void main(String[] args) {
        new FifteenGame();
    }

}
