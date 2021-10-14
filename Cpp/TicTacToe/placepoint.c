#include "placepoint.h"
#include "con_lib.h"

void PlacePoint(int x, int y, int *array,int who){
    con_set_color(COLOR_BLACK,COLOR_GRAY);

    if(x==1 && y==1 && array[0]==0){
        if(who==1){
                array[0]=1;
                DrawX(x,y);
        }else {
            array[0]=2;
            DrawO(x,y);
        }
    }
    if(x==13 && y==1 && array[1]==0){
        if(who==1){
            array[1]=1;
            DrawX(x,y);
        }else {
            array[1]=2;
            DrawO(x,y);
        }
    }
    if(x==25 && y==1 && array[2]==0){
        if(who==1){
            array[2]=1;
            DrawX(x,y);
        }else{
            array[2]=2;
            DrawO(x,y);
        }
    }
    if(x==1 && y==9 && array[3]==0){
        if(who==1){
            array[3]=1;
            DrawX(x,y);
        }else {
            array[3]=2;
            DrawO(x,y);
        }
    }
    if(x==13 && y==9 && array[4]==0){
        if(who==1){
            array[4]=1;
            DrawX(x,y);
        }else {
            array[4]=2;
            DrawO(x,y);
        }
    }
    if(x==25 && y==9 && array[5]==0){
        if(who==1){
            array[5]=1;
            DrawX(x,y);
        }else {
            array[5]=2;
            DrawO(x,y);
        }
    }
    if(x==1 && y==17 && array[6]==0){
        if(who==1){
            array[6]=1;
            DrawX(x,y);
        }else {
            array[6]=2;
            DrawO(x,y);
        }
    }
    if(x==13 && y==17 && array[7]==0){
        if(who==1){
            array[7]=1;
            DrawX(x,y);
        }else {
            array[7]=2;
            DrawO(x,y);
        }
    }
    if(x==25 && y==17 && array[8]==0){
        if(who==1){
            array[8]=1;
            DrawX(x,y);
        }else{
            array[8]=2;
            DrawO(x,y);
        }
    }
}
void PlacePointBySquareNumber(int square, int piece, int *array){
    int x,y,number;
    number=whichSquare(square);
    y=number%100;
    x=(number-y)/100;
    PlacePoint(x,y,array,piece);
    array[square]=piece;
}
int whichSquare(int square_number){
    if(square_number==0)
        return 101;
    if(square_number==1)
        return 1301;
    if(square_number==2)
        return 2501;
    if(square_number==3)
        return 109;
    if(square_number==4)
        return 1309;
    if(square_number==5)
        return 2509;
    if(square_number==6)
        return 117;
    if(square_number==7)
        return 1317;
    if(square_number==8)
        return 2517;
}