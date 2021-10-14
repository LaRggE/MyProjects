#ifndef LOGIC_H
#define LOGIC_H

extern int X_win_count,Y_win_count,a_draw;

int IsThereAWinner(int *array);
int IsMovePosible(int *array, int AI);

#endif
