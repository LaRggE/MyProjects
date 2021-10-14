#include "AI.h"
#include "con_lib.h"
#include "saveload.h"
#include "saveload.h"
#include "restart.h"
#include "placepoint.h"
#include "playermovement.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <assert.h>


//multiplayer exit sutvarkyt reik


int X_win_count=0,Y_win_count=0,a_draw=0;

//clock_t t=clock();

void PrintInstrutions();

int main(int argc, char** argv) {
    int array_placed_points[9]={0,0,0,0,0,0,0,0,0};
    int x_axis_size=37,y_axis_size=25;
    int vline=(x_axis_size-1)/3,hline=(y_axis_size-1)/3;
    int dir_x,dir_y;
    int old_x,old_y;
    int difficulty=1;
    int AI_piece=2,player_piece=1;
    int first = 0,flag=0;

    clock_t stime=clock();

    //atexit(logg("aaa",3));

    logg("programa prasidejo",18);

    con_show_echo(0);
    con_show_cursor(0);

    int pos_x = 1, pos_y = 1;

    con_clear();
    PrintInstrutions();

    con_set_color(COLOR_BLACK,COLOR_GRAY);
    draw_play_box(0, 0, x_axis_size, y_axis_size,vline,hline);


    while(1){
        int key = 0;
        con_set_color(COLOR_BLACK,COLOR_GREEN);
        con_set_pos(40,9);
        printf("pasirinkite rezima:");
        con_set_pos(40,10);
        printf("Multiplayer (a)");
        con_set_pos(40,11);
        printf("lengvas AI (s)");
        con_set_pos(40,12);
        printf("Sunkus AI (d)");
        while (key = con_read_key()){
                if(key == 'a'){
                first=0;
                flag=1;
                break;
            }
            if(key == 's'){
                first=1;
                difficulty=0;
                flag=1;
                break;
            }
            if(key == 'd'){
                first=1;
                difficulty=1;
                flag=1;
                break;
            }
        }
        if(flag == 1){
            con_set_color(COLOR_BLACK,COLOR_BLACK);
            con_set_pos(40,9);
            printf("#######################");
            con_set_pos(40,10);
            printf("#####################");
            con_set_pos(40,11);
            printf("#####################");
            con_set_pos(40,12);
            printf("#####################");
            break;
        }
    }
    while (1) {
        int key = 0;

        while (key = con_read_key()) {
            con_set_color(COLOR_BLACK,COLOR_BLUE);
          if (key == 'w') {
            dir_x = 0;
            dir_y = -vline+4;
            }else if(key == 'p'){
                    Save(array_placed_points);
            }else if(key == 'o'){
                    Load(array_placed_points);
            }else if (key == 's') {
                dir_x = 0;
                dir_y = vline-4;
            }else if (key == 'a') {
                dir_x = -hline-4;
                dir_y = 0;
            }else if (key == 'd') {
                dir_x = hline+4;
                dir_y = 0;
            }else if (key == 'q') {
                fflush(stdout);
                exit(1);
            return 0;
          } else if(key == 'e'){
                MakeDecision(pos_x,pos_y,array_placed_points,player_piece,AI_piece,difficulty,first,stime);
          } else if(key == 'r'){
                Restart(array_placed_points);
            }
           con_sleep(0.1);
        }

        pos_x += dir_x;
        if (pos_x < 1)
            pos_x = (hline+4)*2+1;
        else if (pos_x > x_axis_size-2)
                pos_x = 1;
        dir_x=0;

        pos_y += dir_y;
        if (pos_y < 1)
          pos_y = (vline-3)*2-1;
        else if (pos_y > y_axis_size-2)
                pos_y = 1;
        dir_y=0;

        con_set_color(COLOR_BLACK, COLOR_BLACK);
        draw_box(old_x,old_y,(x_axis_size-4)/3,(y_axis_size-4)/3,0);

        con_set_color(COLOR_RED, COLOR_RED);
        draw_box(pos_x,pos_y,(x_axis_size-4)/3,(y_axis_size-4)/3,1);

        con_set_color(COLOR_BLACK,COLOR_GRAY);
        con_set_pos(50,25);
        printf("X:%d   0:%d   D:%d" ,X_win_count , Y_win_count, a_draw);

        fflush(stdout);

        old_x = pos_x;
        old_y = pos_y;

        con_sleep(0.20);

        //test
        int i;

        for(i = 0; i < 9; i++){
            assert(array_placed_points[i]<3 && array_placed_points[i] > -1);
        }
        //test

      }
}
void PrintInstrutions(){
    con_set_color(COLOR_BLACK,COLOR_GREEN);
    con_set_pos(40,1);
    printf("Kryziukai/Nuliukai V1.0.2");
    con_set_pos(40,2);
    printf("Naudoti wasd");
    con_set_pos(40,3);
    printf("spausti e kad padedi kryziuka/nuliuka");
}
