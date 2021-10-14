#include <stdlib.h>
#include "con_lib.c"
#include "draw.h"

void draw_play_box(int x, int y, int w, int h, int vline, int hline) {
  int i;
  for (i = 0; i < w; i++) {
    con_set_pos(x + i, y);
    printf("#");

    con_set_pos(x + i, y + h - 1);
    printf("#");
  }

  for (i = 0; i < h; i++) {
    con_set_pos(x, y + i);
    printf("#");

    con_set_pos(x + w - 1, y + i);
    printf("#");
  }
  for(i = 0;i < h;i++){
    con_set_pos(vline, y + i);
    printf("#");

    con_set_pos(vline*2, y + i);
    printf("#");

    con_set_pos(vline*3, y + i);
    printf("#");
  }
  for(i = 0;i < w;i++){
    con_set_pos(x + i, hline);
    printf("#");

    con_set_pos(x + i, hline*2);
    printf("#");

    con_set_pos(x + i, hline*3);
    printf("#");
  }
}
void draw_box(int x, int y, int w, int h,int delsav) {
  int i;
  for (i = 0; i < w; i++) {
    con_set_pos(x + i, y);
    if(delsav){
            printf(" ");
    } else printf("#");

    con_set_pos(x + i, y + h - 1);
    if(delsav){
            printf(" ");
    } else printf("#");

  }

  for (i = 0; i < h; i++) {
    con_set_pos(x, y + i);
    if(delsav){
        printf(" ");
    } else printf("#");
    con_set_pos(x + w - 1, y + i);
    if(delsav){
        printf(" ");
    }else printf("#");

  }
}
void DrawX(int x, int y){
    con_set_color(COLOR_GRAY, COLOR_GRAY);
    con_set_pos(x+3,y+1);
    printf("#");
    con_set_pos(x+7,y+1);
    printf("#");
    con_set_pos(x+4,y+2);
    printf("#");
    con_set_pos(x+6,y+2);
    printf("#");
    con_set_pos(x+5,y+3);
    printf("#");
    con_set_pos(x+4,y+4);
    printf("#");
    con_set_pos(x+6,y+4);
    printf("#");
    con_set_pos(x+3,y+5);
    printf("#");
    con_set_pos(x+7,y+5);
    printf("#");
}
void DrawO(int x, int y){
    int i;
    con_set_color(COLOR_GRAY,COLOR_GRAY);
    for(i = 0; i < 5;i++){
        con_set_pos(x+3+i,y+1);
        printf("#");
        con_set_pos(x+3+i,y+5);
        printf("#");
        con_set_pos(x+2,y+1+i);
        printf("#");
        con_set_pos(x+8,y+1+i);
        printf("#");
    }
}