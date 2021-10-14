package Package;

import java.awt.*;

public class Player extends Actors{

    private Handler handler;

    public Player(Handler handler, float x, float y){
        super(handler, x, y, 52, 86);
        this.handler = handler;
        health = 10;

    }

    @Override
    public void tick() {
        //System.out.println(health);

        consoleCommands();

        getInput();
        move();

        if(x < 0){
            x = 0;
        }
        if(y < 0){
            y = 0;
        }
        if(handler.getWidth() - 60 < x){
            x = handler.getWidth() - 60;
        }
        if(handler.getHeight() - 90 < y){
            y = handler.getHeight() - 90;
        }
    }
    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){
            yMove = -speed;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }

    }
    private void consoleCommands(){
        int com = handler.getGame().getLastCom();
        if(com != -1){
            if(com == 2){
                x = x + 100;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 3){
                x = x - 100;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 4){
                y = y - 100;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 5){
                y = y + 100;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 6){
                health = health + 5;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 7){
                speed = speed + 5;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 8){
                speed = speed - 1;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 9){
                speed = speed * -1;
                handler.getGame().setLastBool();
                return;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int)x, (int)y, width, height, null);
    }
}
