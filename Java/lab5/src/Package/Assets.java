package Package;

import java.awt.image.BufferedImage;

public class Assets {

    private static int pWidth = 62, pHeight = 97;

    public static BufferedImage player;
    public static BufferedImage block;
    //public static SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
    //private static int pi = 0;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/0.png"));
        player = sheet.crop(0, 0, 52, 86);
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/block.png"));
        block = sheet.crop(0,0,512, 512);

        //player = sheet.crop(0,0, pWidth, pHeight);
    }
//    public static BufferedImage playerImage(){
//        System.out.println(pWidth * (pi));
//        //BufferedImage player = sheet.crop(pWidth * pi, 0, pWidth * (pi+1), pHeight);
//        BufferedImage player = sheet.crop(pWidth * (pi), 0, pWidth, pHeight);
//
//        pi++;
//        if(pi == 35){
//            pi = 0;
//        }
//        return player;
//    }
}
