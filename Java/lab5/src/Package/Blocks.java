package Package;

import java.awt.*;

public class Blocks extends Actors {
    public Blocks(Handler handler, float x, float y, int width, int height, int speed) {
        super(handler, x, y, width, height);
        yMove = speed;
    }

    @Override
    public void tick() {
        xMove = 0;
        //yMove = 5;
        move();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.block, (int)x, (int)y, width, height, null);

    }
}
