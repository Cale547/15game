import javax.swing.JLabel;

public class Block extends JLabel {
    int i;
    int pos;
    boolean isHole = i == 16;
    PicComp num;
    Block n;
    Block s;
    Block w;
    Block e;

    public Block(int index, int position, PicComp img) {
        i = index;
        pos = position;
        num = img;
    }

    public void setNeighbors(Block n, Block s, Block w, Block e) {
        this.n = n;
        this.s = s;
        this.w = w;
        this.e = e;
    }
}