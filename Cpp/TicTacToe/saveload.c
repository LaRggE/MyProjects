#include "saveload.h"
#include <stdio.h>
#include <stdlib.h>
#include "con_lib.h"

void Save(int *array){
    FILE *file=NULL;
    file=fopen("save.txt", "wb");
    if(file == NULL){
        con_set_pos(40,29);
        printf("Error: failed to open file");
        return;
    }
    int i;
    fwrite(array, 1, 9*sizeof(int), file);

    con_set_color(COLOR_BLACK,COLOR_GREEN);
    con_set_pos(40,30);
    printf("Issaugota");
    fflush(file);
    fclose(file);

}
void Load(int *array){
    int i,tem;
    //array=Restart(array);

    FILE *file=NULL;
    file=fopen("save.txt","rb");

    if(file == NULL){
        printf("Error: failed to load file");
    }

    fread(array, 1, 9*sizeof(int), file);

    for(i = 0; i < 9; i++){
        if(array[i] > 0 && array[i] < 3){
            tem=array[i];
            array[i]=0;
            PlacePointBySquareNumber(i, tem ,array);
            }
    }
    fflush(file);
    fclose(file);

}
