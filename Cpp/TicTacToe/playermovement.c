#include "con_lib.h"
#include "playermovement.h"
#include "log.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void MakeDecision(int x, int y, int *array, int player_piece, int AI_piece,int difficulty, int first, clock_t stime){
    if(first == 0){
        Multiplayer(x,y,array,player_piece,AI_piece,stime);
    }
    if(first == 1){
        PlayerFirstMove(x,y,array,player_piece,AI_piece,difficulty,stime);
    }
    if(first == 2){
        PlayerSecondMove(x,y,array,player_piece,AI_piece,difficulty,stime);
    }
}
void Multiplayer(int x, int y, int *array, int player1_piece, int Player2_piece, clock_t stime){
    int win = 0;
    if(IsMovePosible(array,player1_piece)==1){
            PlacePoint(x,y,array,player1_piece);
    }
    win=IsThereAWinner(array);
    if(win == 1){
        if(0 == ToRestart(array)){
            timelog(stime);
            exit(1);
        }
    }

    if(IsMovePosible(array,Player2_piece)==1){
            PlacePoint(x,y,array,Player2_piece);
    }
    win=IsThereAWinner(array);
    if(win == 1){
        if(0 == ToRestart(array)){
            timelog(stime);
            exit(1);
        }
    }
}
void PlayerFirstMove(int x, int y, int *array, int player_piece, int AI_piece, int difficulty, clock_t stime){
    int win = 0;
    PlacePoint(x,y,array,player_piece);
    win=IsThereAWinner(array);
    if(win == 1){
        if(0 == ToRestart(array)){
            timelog(stime);
            exit(1);
            //atexit(timelog(t));

        }
    }
    if(IsMovePosible(array,2)==1){
        AI(difficulty,array,AI_piece);
        win=IsThereAWinner(array);
        if(win == 1){
            if(0 == ToRestart(array)){
                timelog(stime);
                exit(1);
                //atexit(timelog(t));

            }
        }
    }else {
        if(IsMovePosible(array,2) == 2){
            if(0 == ToRestart(array)){
                timelog(stime);
                exit(1);
            }
        }
        }
}
void PlayerSecondMove(int x, int y, int *array, int player_piece, int AI_piece, int difficulty, clock_t stime){
    int win = 0;
    //clock_t stime=clock();
    PlacePoint(x,y,array,player_piece);
    win=IsThereAWinner(array);
    if(win == 1){
        if(0 == ToRestart(array)){
            timelog(stime);
            exit(1);
            //atexit(timelog(t));

        }
    }
    if(IsMovePosible(array,1) == 1){
        AI(difficulty,array,AI_piece);
        win=IsThereAWinner(array);
        if(win == 1){
            if(0 == ToRestart(array)){
                timelog(stime);
                exit(1);
            }
        }
    }else {
        if(IsMovePosible(array,1) == 2){
            if(0 == ToRestart(array)){
                timelog(stime);
                exit(1);
            }
        }
        }
}
