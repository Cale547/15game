import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class FifteenGame extends Presenter {
    private BlockPanel pan;
    private PicComp winComp;

    public FifteenGame() {
        createWinComp();
        showText("Press a button to start the game");

        pan.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "doWest");
        pan.getActionMap().put("doWest",
        new AbstractAction() {
            public void actionPerformed(ActionEvent e) {westButtonPressed();}
        });

        pan.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "doEast");
        pan.getActionMap().put("doEast",
        new AbstractAction() {
            public void actionPerformed(ActionEvent e) {eastButtonPressed();}
        });

        pan.getInputMap().put(KeyStroke.getKeyStroke("UP"), "doNorth");
        pan.getActionMap().put("doNorth",
        new AbstractAction() {
            public void actionPerformed(ActionEvent e) {northButtonPressed();}
        });

        pan.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "doSouth");
        pan.getActionMap().put("doSouth",
        new AbstractAction() {
            public void actionPerformed(ActionEvent e) {southButtonPressed();}
        });
    }

    public BlockPanel createCenterComponent() {
        pan = new BlockPanel();
        return pan;
    }

    public void createWinComp() {
        File[] pics = new File("WinImages").listFiles();
        int index = (int)(Math.random()*pics.length);
        winComp = new PicComp(pics[index]);
    }

    public void eastButtonPressed() {
        if (pan.getHole().w != null) {
            showText(pan.getHole().w.i + " moved EAST");
            pan.switchSpot(pan.getHole(), pan.getHole().w);
            calculateWin(false);
        }
	}

	public void westButtonPressed() {
        if (pan.getHole().e != null) {
            showText(pan.getHole().e.i + " moved WEST");
            pan.switchSpot(pan.getHole(), pan.getHole().e);
            calculateWin(false);
        }
	}

	public void southButtonPressed() {
        if (pan.getHole().n != null) {
            showText(pan.getHole().n.i + " moved SOUTH");
            pan.switchSpot(pan.getHole(), pan.getHole().n);
            calculateWin(false);
        }
	}

	public void northButtonPressed() {
        if (pan.getHole().s != null) {
            showText(pan.getHole().s.i + " moved NORTH");
            pan.switchSpot(pan.getHole(), pan.getHole().s);
            calculateWin(false);
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
            showText("You win!");
            getFrame().remove(pan);
            getFrame().add(winComp, BorderLayout.CENTER);
            getFrame().update(getFrame().getGraphics());
        }



    }

    public static void main(String[] args) {
        new FifteenGame();
    }

}
