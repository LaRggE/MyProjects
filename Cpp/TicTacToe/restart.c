#include <stdlib.h>
#include <stdio.h>
#include "con_lib.h"
#include "restart.h"

int ToRestart(int *array){
    int key=0;
    con_set_pos(48,7);
    printf("Ar norite zaisti dar karta? y/n");
    while(1){
        key=con_read_key();
        if(key == 'y'){
            Restart(array);
            return 1;
        }else if(key == 'n'){
                //Restart(array);
                return 0;
                }
    }

}
int* Restart(int *array){
    int i;
    con_clear();
    con_set_color(COLOR_BLACK,COLOR_GRAY);
    draw_play_box(0, 0, 37, 25, 12, 8);
    con_set_color(COLOR_BLACK,COLOR_BLACK);
    for(i = 0; i < 20; i++){
        con_set_pos(50+i,6);
        printf("#");
    }
    for(i = 0;i < 9 ;i++){
        array[i]=0;
    }
    PrintInstrutions();
    return array;
}