package Package;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Game implements Runnable{

    private int deltaCompare = 1;

    private Display display;
    public int width, height;
    public String title;

    private long now;
    private double delta = 0;
    private int lastCom = -1;
    private boolean lastComBool = true;
    private boolean running = false;
    private boolean paused = true;
    private Thread thread;
    private Thread consoleThread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    //private State menuS

    private KeyManager keyManager;

    private Handler handler;

    ConsoleInput consoleInput;

    {
        try {
            consoleInput = new ConsoleInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }


    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        handler = new Handler(this);

        gameState = new GameState(handler);
        State.setState(gameState);
    }

    private void tick(){
        keyManager.tick();

        if(State.getState() != null){
            State.getState().tick();
        }
    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0,0,width,height);

        if(State.getState() != null){
            State.getState().render(g);
        }


        bs.show();
        g.dispose();
    }

    public void run(){

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (paused) {
                if (delta >= deltaCompare) {
                    tick();
                    render();
                    ticks++;
                    delta = delta -deltaCompare;
                }
                if (timer >= 1000000000) {
                    //System.out.println("timer and Frames" + ticks);
                    ticks = 0;
                    timer = 0;
                }

            }
            setLastCommand(consoleCommands(consoleInput.getLastCommand()));
        }
    }
    public KeyManager getKeyManager(){
        return keyManager;
    }

    public synchronized void start() throws IOException {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
        consoleThread = new Thread(consoleInput);
        consoleThread.start();
    }
    public synchronized void stop() throws InterruptedException {
        if (!running)
            return;
        running = false;
        thread.join();
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public int consoleCommands(String command){
        if(command == null){
            return -1;
        }
        if(command.compareTo("pause") == 0){
            System.out.println("pause pressed");
            paused = false;
            return 0;
        }
        if(command.compareTo("resume") == 0){
            System.out.println("resume pressed");
            paused = true;
            delta = 0;
            now = 0;
            return 0;
        }
        if(command.compareTo("fpsdrop") == 0){
            System.out.println("fpsdrop pressed");
            deltaCompare++;
            return 0;
        }
        if(command.compareTo("fpsup") == 0){
            System.out.println("fpsup pressed");
            deltaCompare--;
            return 0;
        }
        if(command.compareTo("right") == 0){
            System.out.println("right pressed");
            return 2;  // + 4
        }
        if(command.compareTo("left") == 0){
            System.out.println("left pressed");
            return 3;
        }
        if(command.compareTo("up") == 0){
            System.out.println("up pressed");
            return 4;
        }
        if(command.compareTo("down") == 0){
            System.out.println("down pressed");
            return 5;
        }
        if(command.compareTo("health") == 0){
            System.out.println("down pressed");
            return 6;
        }
        if(command.compareTo("speedup") == 0){
            System.out.println("speedup pressed");
            return 7;
        }
        if(command.compareTo("speeddown") == 0){
            System.out.println("speeddown pressed");
            return 8;
        }
        if(command.compareTo("inverse") == 0){
            System.out.println("inverse pressed");
            return 9;
        }
        if(command.compareTo("resetdiff") == 0){
            System.out.println("resetdiff pressed");
            return 10;
        }
        if(command.compareTo("diffcurv") == 0){
            System.out.println("diffcurv pressed");
            return 11;
        }
        if(command.compareTo("hard") == 0){
            System.out.println("hard pressed");
            return 12;
        }
        if(command.compareTo("easy") == 0){
            System.out.println("easy pressed");
            return 13;
        }
        if(command.compareTo("big") == 0){
            System.out.println("big pressed");
            return 14;
        }
        if(command.compareTo("small") == 0){
            System.out.println("small pressed");
            return 15;
        }
        if(command.compareTo("fast") == 0){
            System.out.println("fast pressed");
            return 16;
        }
        if(command.compareTo("slow") == 0){
            System.out.println("slow pressed");
            return 17;
        }
        if(command.compareTo("normsize") == 0){
            System.out.println("normsize pressed");
            return 18;
        }
        if(command.compareTo("normspeed") == 0){
            System.out.println("normspeed pressed");
            return 19;  // +4
        }
        return 0;
        //System.out.println(command);
    }
    public void setLastCommand(int lastCom){
        if(lastCom!= -1){
            lastComBool = true;
            this.lastCom = lastCom;
        }

    }
    public int getLastCom(){
        if(lastComBool){
            return lastCom;
        }
            else return -1;
    }
    public void setLastBool(){
        lastComBool = false;
    }
}