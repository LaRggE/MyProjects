#include "logic.h"
#include <stdio.h>
#include "con_lib.h"

//int X_win_count=0,Y_win_count=0,a_draw=0;

int IsThereAWinner(int *array){
    int winner=0,key;
    if(array[0] != 0 && array[0] == array[1] && array[1] == array[2]){
        winner=array[0];
    }
    if(array[3] != 0 && array[3] == array[4] && array[4] == array[5]){
        winner=array[3];
    }
    if(array[6] != 0 && array[6] == array[7] && array[7] == array[8]){
        winner=array[6];
    }
    if(array[0] != 0 && array[0] == array[3] && array[3] == array[6]){
        winner=array[0];
    }
    if(array[1] != 0 && array[1] == array[4] && array[4] == array[7]){
        winner=array[1];
    }
    if(array[2] != 0 && array[2] == array[5] && array[5] == array[8]){
        winner=array[2];
    }
    if(array[0] != 0 && array[0] == array[4] && array[4] == array[8]){
        winner=array[0];
    }
    if(array[2] != 0 && array[2] == array[4] && array[4] == array[6]){
        winner=array[2];
    }
    if(array[0] == -1){
        con_set_color(COLOR_BLACK,COLOR_GREEN);
        con_set_pos(50,6);
        printf("Lygiosios !!");
        winner=0;
        a_draw++;
        return 1;
    }
    if(winner>0){
        con_set_color(COLOR_BLACK,COLOR_GREEN);
        con_set_pos(50,6);
        if(winner==1){
            printf("laimejo kryziukai !!");
            winner=0;
            X_win_count++;
            return 1;
        }else {
            printf("laimejo nuliukai !!");
            winner=0;
            Y_win_count++;
            return 1;
        }
    }
    return 0;
}
int IsMovePosible(int *array, int AI){
    int i,flag=0;
    for(i = 0;i < 9; i++){
        if(array[i]==0){
            flag++;
        }
    }
    if(flag == 0){
        array[0]=-1;
        if(1 == IsThereAWinner(array)){
            return 2;
        }
    }
    if(AI == 2){
        if(flag%2==0){
            return 1;
        }else return 0;
    }
    if(AI == 1){
        if(flag%2==1){
            return 1;
        }else return 0;
    }
}
