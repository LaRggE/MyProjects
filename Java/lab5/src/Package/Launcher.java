package Package;

import java.io.IOException;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) throws IOException {

        Game game = new Game("title", 640, 640);
        game.start();
    }
}
