package Package;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameState extends State{
    long lastTime = System.nanoTime();
    long now;
    double delta = 0;
    long timer = 0;
    double timesPerSecond = 1000000000 / 1;
    double deltaCompare =  0.8;
    double difficulty = 0.01;
    int i1 = 0, i2 = 0;

    private Player player;
    //private Blocks blocks;
    private ArrayList<Blocks> arrayBlock = new ArrayList<Blocks>();

    public GameState(Handler handler){
        super(handler);
        player = new Player(handler,330, 500);
        //arrayBlock.add(new Blocks(handler, 100, 100, 50, 50));
        //blocks = new Blocks(handler, 100, 100, 50,50);
    }

    private void newEnemies(){
        now = System.nanoTime();
        delta += (now - lastTime) / timesPerSecond;
        timer += now - lastTime;
        lastTime = now;

        if(delta >= deltaCompare){
            int beginX = ThreadLocalRandom.current().nextInt(0, handler.getWidth());
            int size = i1 + ThreadLocalRandom.current().nextInt(30, 100);
            int speed = i2 + ThreadLocalRandom.current().nextInt(2, 7);

            arrayBlock.add(new Blocks(handler, beginX, 0, size, size, speed));

           // System.out.println(deltaCompare + " " + difficulty);
            delta = delta - deltaCompare;

            deltaCompare = deltaCompare - difficulty;
            difficulty = difficulty - (difficulty/30);
        }

    }

    @Override
    public void tick() {
        consoleCommands();
        newEnemies();

        if (player.toKill()) {

        } else{
            player.tick();
            for (int i = 0; i < arrayBlock.size(); i++) {
                arrayBlock.get(i).tick();
                if (arrayBlock.get(i).collision((int) player.getX(), (int) player.getY(), player.getWidth(), player.getHeight()) == 1) {
                    arrayBlock.get(i).toBeHit();
                    player.toBeHit();
                }
                for (int j = 0; j < arrayBlock.size(); j++) {
                    if (arrayBlock.get(j).toKill()) {
                        arrayBlock.remove(j);
                        j--;
                    }
                }
            }
    }
        //blocks.tick();
//        if(blocks.collision((int)player.getX(), (int)player.getY(), player.getWidth(), player.getHeight()) == 1){
//            System.out.println("kek");
//        }
    }

    @Override
    public void render(Graphics g) {
        if(!player.toKill()){
            player.render(g);
        }
        for(int i = 0; i < arrayBlock.size(); i++){
            arrayBlock.get(i).render(g);
        }
        //blocks.render(g);
        //g.setColor(Color.red);
        //g.drawRect(10,10 ,10,10);
    }
    private void consoleCommands() {
        int com = handler.getGame().getLastCom();
        if (com != -1) {
            if(com == 10){
                difficulty = 0.01;
                deltaCompare = 0.8;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 11){
                difficulty = 0.01;
                //deltaCompare = 0.8;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 12){
                //difficulty = 0.01;
                deltaCompare = deltaCompare - 0.1;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 13){
                //difficulty = 0.01;
                deltaCompare = deltaCompare + 0.1;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 14){
                //difficulty = 0.01;
                //deltaCompare = deltaCompare + 0.1;
                i1 = i1 + 20;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 15){
                //difficulty = 0.01;
                //deltaCompare = deltaCompare + 0.1;
                i1 = i1 - 20;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 16){
                //difficulty = 0.01;
                //deltaCompare = deltaCompare + 0.1;
                i2 = i2 + 2;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 17){
                //difficulty = 0.01;
                //deltaCompare = deltaCompare + 0.1;
                i2 = i2 - 2;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 18){
                //difficulty = 0.01;
                //deltaCompare = deltaCompare + 0.1;
                i1 = 0;
                handler.getGame().setLastBool();
                return;
            }
            if(com == 19){
                //difficulty = 0.01;
                //deltaCompare = deltaCompare + 0.1;
                i2 = 0;
                handler.getGame().setLastBool();
                return;
            }
        }
    }
}
