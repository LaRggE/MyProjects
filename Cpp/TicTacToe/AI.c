#include <stdlib.h>
#include "con_lib.h"
#include "AI.h"

void AI(int difficulty, int *array, int piece){
    int enemy;
    if(piece == 2){
        enemy=1;
    }else enemy=2;

    if(difficulty==0){
        RandomDecision(array,piece);
    } else {
        if(SmartAI(array,enemy,piece) == 1){
            if(SmartAI(array,piece,piece) == 1){
                if(array[4] == 0){
                    PlacePointBySquareNumber(4,piece,array);
                }
                else if(array[0] == 0){
                          PlacePointBySquareNumber(0,piece,array);
                     }
                     else if(array[8] == 0){
                              PlacePointBySquareNumber(8,piece,array);
                           }
                            else RandomDecision(array,piece);
            }
        }
    }
}
int SmartAI(int *array, int piece, int tpiece){
    int x,y,flag=0,enemy;
    if(piece == 2){
         enemy=1;
    }else enemy=2;
    if(array[0] == enemy || array[1] == enemy ||array[2] == enemy){
        if((array[0] == array[1] && array[0] == enemy)|| (array[0] == array[2] && array[0] == enemy) || (array[1] == array[2] && array[1] == enemy)){
            if(array[0] == 0){
                //array[0]=piece;
                PlacePointBySquareNumber(0,tpiece,array);
                return 0;
            }
            if(array[1] == 0){
                //array[1]=piece;
                PlacePointBySquareNumber(1,tpiece,array);
                return 0;
            }
            if(array[2]==0){
                //array[2]=piece;
                PlacePointBySquareNumber(2,tpiece,array);
                return 0;
            }
        }
    }
    if(array[3] == enemy || array[4] == enemy ||array[5] == enemy){
        if((array[3] == array[4] && array[3] == enemy) || (array[3] == array[5] && array[3] == enemy) || ( array[4] == array[5] && array[4] == enemy)){
            if(array[3] == 0){
                //array[3]=piece;
                PlacePointBySquareNumber(3,tpiece,array);
                return 0;
            }
            if(array[4] == 0){
                //array[4]=piece;
                PlacePointBySquareNumber(4,tpiece,array);
                return 0;
            }
            if(array[5]==0){
                //array[5]=piece;
                PlacePointBySquareNumber(5,tpiece,array);
                return 0;
            }
        }
    }
    if(array[6] == enemy || array[7] == enemy ||array[8] == enemy){
        if((array[6] == array[7] && array[6] == enemy) || ( array[6] == array[8] && array[6] == enemy) || ( array[7] == array[8] && array[7] == enemy)){
            if(array[6] == 0){
                //array[6]=piece;
                PlacePointBySquareNumber(6,tpiece,array);
                return 0;
            }
            if(array[7] == 0){
                //array[7]=piece;
                PlacePointBySquareNumber(7,tpiece,array);
                return 0;
            }
            if(array[8]==0){
                //array[8]=piece;
                PlacePointBySquareNumber(8,tpiece,array);
                return 0;
            }
        }
    }
    if(array[0] == enemy || array[3] == enemy ||array[6] == enemy){
        if((array[0] == array[3] && array[0] == enemy) || ( array[0] == array[6] && array[0] == enemy) || ( array[3] == array[6] && array[3] == enemy)){
            if(array[0] == 0){
                //array[0]=piece;
                PlacePointBySquareNumber(0,tpiece,array);
                return 0;
            }
            if(array[3] == 0){
                //array[3]=piece;
                PlacePointBySquareNumber(3,tpiece,array);
                return 0;
            }
            if(array[6]==0){
                //array[6]=piece;
                PlacePointBySquareNumber(6,tpiece,array);
                return 0;
            }
        }
    }
    if(array[1] == enemy || array[4] == enemy ||array[7] == enemy){
        if(( array[1] == array[4] && array[1] == enemy) || ( array[1] == array[7] && array[1] == enemy) || ( array[4] == array[7]&& array[4] == enemy)){
            if(array[1] == 0){
                //array[1]=piece;
                PlacePointBySquareNumber(1,tpiece,array);
                return 0;
            }
            if(array[4] == 0){
                //array[4]=piece;
                PlacePointBySquareNumber(4,tpiece,array);
                return 0;
            }
            if(array[7]==0){
                //array[7]=piece;
                PlacePointBySquareNumber(7,tpiece,array);
                return 0;
            }
        }
    }
    if(array[2] == enemy || array[5] == enemy ||array[8] == enemy){
        if(( array[2] == array[5] && array[2] == enemy) ||  (array[2] == array[8] && array[2] == enemy) ||  (array[5] == array[8] && array[5] == enemy)){
            if(array[2] == 0){
                //array[2]=piece;
                PlacePointBySquareNumber(2,tpiece,array);
                return 0;
            }
            if(array[5] == 0){
                //array[5]=piece;
                PlacePointBySquareNumber(5,tpiece,array);
                return 0;
            }
            if(array[8]==0){
                //array[8]=piece;
                PlacePointBySquareNumber(8,tpiece,array);
                return 0;
            }
        }
    }
    if(array[0] == enemy || array[4] == enemy ||array[8] == enemy){
        if((array[0] == array[4] && array[0] == enemy) || (array[0] == array[8] && array[0] == enemy)|| ( array[4] == array[8] && array[4] == enemy)){
            if(array[0] == 0){
                //array[0]=piece;
                PlacePointBySquareNumber(0,tpiece,array);
                return 0;
            }
            if(array[4] == 0){
                //array[4]=piece;
                PlacePointBySquareNumber(4,tpiece,array);
                return 0;
            }
            if(array[8]==0){
                //array[8]=piece;
                PlacePointBySquareNumber(8,tpiece,array);
                return 0;
            }
        }
    }
    if(array[2] == enemy || array[4] == enemy ||array[6] == enemy){
        if((array[2] == array[4] && array[2] == enemy) || ( array[2] == array[6] && array[2] == enemy) || ( array[4] == array[6] && array[4] == enemy)){
            if(array[2] == 0){
                //array[2]=piece;
                PlacePointBySquareNumber(2,tpiece,array);
                return 0;
            }
            if(array[4] == 0){
                //array[4]=piece;
                PlacePointBySquareNumber(4,tpiece,array);
                return 0;
            }
            if(array[6]==0){
                //array[6]=piece;
                PlacePointBySquareNumber(6,tpiece,array);
                return 0;
            }
        }
    }
    con_set_color(COLOR_BLACK,COLOR_BLUE);
    return 1;
}
void RandomDecision(int *array, int piece){
    int ran,x,y,number;
    srand(time(NULL));
    while(1){
         ran = rand()%(8-0+1)+0;
         if(array[ran] == 0){
            PlacePointBySquareNumber(ran,piece,array);
            //number=whichSquare(ran);
            //y=number%100;
            //x=(number-y)/100;
            //PlacePoint(x,y,array,piece);
            array[ran]=piece;
            break;
         }
    }
}