public class FifteenGame extends Presenter {
    private BlockPanel pan;

    public FifteenGame() {
        showText("Press a button to start the game");
    }

    public BlockPanel createCenterComponent() {
        pan = new BlockPanel();
        return pan;
    }

    

    public void eastButtonPressed() {
        if (pan.getHole().w != null) {
            showText(pan.getHole().w.i + " moved EAST");
            pan.switchSpot(pan.getHole(), pan.getHole().w);
            calculateWin();
        }
	}

	public void westButtonPressed() {
        if (pan.getHole().e != null) {
            showText(pan.getHole().e.i + " moved WEST");
            pan.switchSpot(pan.getHole(), pan.getHole().e);
            calculateWin();
        }
	}

	public void southButtonPressed() {
        if (pan.getHole().n != null) {
            showText(pan.getHole().n.i + " moved SOUTH");
            pan.switchSpot(pan.getHole(), pan.getHole().n);
            calculateWin();
        }
	}

	public void northButtonPressed() {
        if (pan.getHole().s != null) {
            showText(pan.getHole().s.i + " moved NORTH");
            pan.switchSpot(pan.getHole(), pan.getHole().s);
            calculateWin();
        }
	}

    public void calculateWin() {
        boolean win = true;
        for (int i = 1; i < pan.b.length + 1; i++) {
            if (i != pan.b[i-1].i) {
                win = false;
                break;
            }
        }
        if (win) {
            showText("You win!");
        }
    }

    public static void main(String[] args) {
        new FifteenGame();
    }

}
