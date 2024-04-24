import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

public class BlockPanel extends JPanel {
    Block[] b = new Block[16];
    int hPos;
    String folder;
    String extension;

    
    public BlockPanel(String f, String e) {
        folder = f;
        extension = e;

        setLayout(new GridLayout(4,4));        
        int[] nr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

        //Add all blocks to the centercomponent
        for (int i = 0; i < 16; i++) {
            String path = folder + nr[i] + extension;
            b[i] = new Block(nr[i], i, new PicComp(new File(path)));
            if (nr[i] == 16) {
                hPos = i;
            }
            add(b[i].num);
        }

        shuffle();

        //Set neighbors of all blocks
        b[0].setNeighbors(null, b[4], null, b[1]);
        b[1].setNeighbors(null, b[5], b[0], b[2]);
        b[2].setNeighbors(null, b[6], b[1], b[3]);
        b[3].setNeighbors(null, b[7], b[2], null);
        
        b[4].setNeighbors(b[0], b[8], null, b[5]);
        b[5].setNeighbors(b[1], b[9], b[4], b[6]);
        b[6].setNeighbors(b[2], b[10], b[5], b[7]);
        b[7].setNeighbors(b[3], b[11], b[6], null);

        b[8].setNeighbors(b[4], b[12], null, b[9]);
        b[9].setNeighbors(b[5], b[13], b[8], b[10]);
        b[10].setNeighbors(b[6], b[14], b[9], b[11]);
        b[11].setNeighbors(b[7], b[15], b[10], null);

        b[12].setNeighbors(b[8], null, null, b[13]);
        b[13].setNeighbors(b[9], null, b[12], b[14]);
        b[14].setNeighbors(b[10], null, b[13], b[15]);
        b[15].setNeighbors(b[11], null, b[14], null);

    }

    public void shuffle() {
        for (int i = 0; i < 200; i++) {
            int rand1 = 0, rand2 = 0;
            while (rand1 == rand2) {
                rand1 = (int)(Math.random()*16);
                rand2 = (int)(Math.random()*16);
            }
            switchSpot(b[rand1], b[rand2]);
        }

        ArrayList<Integer> oddPos = new ArrayList<>(Arrays.asList(1,3,4,6,9,11,12,14));
        if (oddPos.contains(hPos)) {
            switchSpot(b[6], b[7]);
        }
    }

    public Block getHole() {
        return b[hPos];
    }
    public void switchSpot(Block A, Block B) {
        A.num.setImage(new File(folder + B.i + extension));
        B.num.setImage(new File(folder + A.i + extension));
        A.num.repaint();
        B.num.repaint();

        int temp = A.i;
        A.i = B.i;
        B.i = temp;

        if (A.i == 16) {
            hPos = A.pos;
        }
        if (B.i == 16) {
            hPos = B.pos;
        }
    }
}
