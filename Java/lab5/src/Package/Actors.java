package Package;

public abstract class Actors extends Entity{

    public static final int DEFAULT_HEALTH = 1;
    public static final float DEAFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64;

    protected int health;
    protected float speed;
    protected float xMove, yMove;


    public Actors(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEAFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move(){
        moveX();
        moveY();
    }

    public void moveX(){
        x = x + xMove;
        if(xMove > 0){

            //int tx = (int)(x + xMove + bounds.x + bounds.width);
            //if()

        }else if(xMove < 0){

        }
    }

    public void moveY(){
        y = y + yMove;
    }

    public boolean toKill(){
        if(outOfborder())
            return true;
        if(health != 0){
               return false;
        }
        else return true;
    }

    public void toBeHit(){
        health--;
    }

    public boolean outOfborder(){
        if(x < 0)
            return true;
        if(y < 0)
            return true;
        if(y > handler.getHeight())
            return true;
        if(x > handler.getWidth())
            return true;
        return false;
    }

    public int collision(int otherX, int otherY, int otherW, int otherH){
        
            if(otherX <= x && (otherW + otherX) >= x &&
        otherY <= y && (otherY + otherH) >= y){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
        if(otherX <= (x + width) && (otherW + otherX) >= (x + width) &&
        otherY <= y && (otherY + otherH) >= y){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
        if(otherX <= x && (otherW + otherX) >= x &&
        otherY <= (y + height) && (otherY + otherH) >= (y + height)){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
        if(otherX <= (x + width) && (otherW + otherX) >= (x + width) &&
        otherY <= (y + height) && (otherY + otherH) >= (y + height)){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
    
        //pusiniai kampai VV KV AV
        if(otherX <= (x + (width/2)) && (otherW + otherX) >= (x + (width/2)) &&
        otherY <= y && (otherY + otherH) >= y){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
        if(otherX <= x && (otherW + otherX) >= x &&
        otherY <= (y + (height/2)) && (otherY + otherH) >= (y + (height/2))){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
        if(otherX <= (x + (width/2)) && (otherW + otherX) >= (x + (width/2)) &&
        otherY <= (y + height) && (otherY + otherH) >= (y + height)){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
        if(otherX <= (x + width) && (otherW + otherX) >= (x + width) &&
        otherY <= (y + (height/2)) && (otherY + otherH) >= (y + (height/2))){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
    
    
        //reverse
        if(x <=otherX  && (width + x) >= otherX  &&
        y <= otherY  && (y + height) >= otherY){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
        if(x <= (otherX + otherW) && (width + x) >= (otherX + otherW) &&
        y <= otherY && (y + height) >= otherY){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
        if(x <=otherX  && (width + x) >= otherX  &&
        y <= (otherY + otherH) && (y + height) >= (otherY + otherH)){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
        if(x <= (otherX + otherW) && (width + x) >= (otherX + otherW) &&
        y <= (otherY + otherH) && (y + height) >= (otherY + otherH)){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
    
    
        //Reverse pusiniai kampai
        if(x <= (otherX + (otherW/2))  && (width + x) >= (otherX + (otherW/2))  &&
        y <= otherY  && (y + height) >= otherY){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
        if(x <= (otherX + otherW) && (width + x) >= (otherX + otherW) &&
        y <= (otherY +(otherH/2)) && (y + height) >= (otherY + (otherH/2))){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
        if(x <= (otherX + (otherW/2))  && (width + x) >= (otherX + (otherW/2))  &&
        y <= (otherY + otherH) && (y + height) >= (otherY + otherH)){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
        if(x <= (otherX + (otherW))  && (width + x) >= (otherX + (otherW))  &&
        y <= otherY +(otherH/2) && (y + height) >= (otherY + (otherH/2))){
            //cout << "Smashhhhh" << endl;
            return 1;
        }
    
        return 0;
}

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
