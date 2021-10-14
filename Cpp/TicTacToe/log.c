#include <stdio.h>
#include <time.h>
#include "log.h"

void logg(char *name, int size){
    FILE *file=NULL;
    file=fopen("log.txt","r+");

    if(file == NULL){
        printf("bb");
        file=fopen("log.txt","w");
    }
    else{
        fseek(file,0,SEEK_END);
        fprintf(file,"\n");
        }

    int i=0;
    while(size--){
        printf("%c",name[i]);
        fprintf(file,"%c",name[i]);
        i++;
    }
    fflush(file);
}
void timelog(clock_t t){
    FILE *file=NULL;
    file=fopen("log.txt","r+");

    if(file == NULL){
        printf("bb");
        file=fopen("log.txt","w");
    }
    else {
        fseek(file,0,SEEK_END);
        fprintf(file,"\n");
        }

    t=clock()-t;

    fprintf(file,"%f",(float)t/CLOCKS_PER_SEC);
    fflush(file);
}
