#ifndef PLAYERMOVEMENT_H
#define PLAYERMOVEMENT_H
#include <time.h>

extern clock_t stime;

void MakeDecision(int x, int y, int *array, int player_piece ,int AI_piece, int difficulty, int first, clock_t stime);
void Multiplayer(int x, int y, int *array, int player1_piece, int Player2_piece, clock_t stime);
void PlayerFirstMove(int x, int y, int *array, int player_piece, int AI_piece, int difficulty, clock_t stime);
void PlayerSecondMove(int x, int y, int *array, int player_piece, int AI_piece, int difficulty, clock_t stime);

#endif
