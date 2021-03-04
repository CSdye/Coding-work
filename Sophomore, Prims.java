/*
 ============================================================================
 Name        : Prims.c
 Author      : Callen Dye
 Version     :
 Copyright   : Your copyright notice
 Description : Prims Algorithm implemented in code
 ============================================================================
 */

#include <stdio.h>
#include <limits.h>
int main() {
	int MAX = 10000;
	int data [5][5];
	data [0][0]=0;	data [0][1]=5;	data [0][2]=13;	data [0][3]=11;	data [0][4]=0;
	data [1][0]=5;	data [1][1]=0;	data [1][2]=7; 	data [1][3]=0;	data [1][4]=3;
	data [2][0]=13;	data [2][1]=7;	data [2][2]=0;	data [2][3]=1;	data [2][4]=4;
	data [3][0]=11;	data [3][1]=0;	data [3][2]=1;	data [3][3]=0;	data [3][4]=2;
	data [4][0]=0;	data [4][1]=3;	data [4][2]=4;	data [4][3]=2;	data [4][4]=0;
	int cost[] ={0, MAX,MAX,MAX,MAX};
	int visited[] = {0,0,0,0,0};
	int prev[] = {-1,-1,-1,-1,-1};
	int min;
	int next =0;
	for(int i=0;i<5;i++){
		min=MAX;
		for(int j=0;j<5;j++){
			if(visited[j] != 1 && cost[j] < min){
				min = cost[j];
				next=j;
			}
		}
		visited[next]=1;
		for(int i=0;i<5;i++){
			if(visited[i] !=1){
				if(data[next][i] < cost[i]){
					printf("update %d %d %d %d\n" , i, next, min, data[next][i]);
					cost[i]= data[next][i];
					prev[i]=next;
				}
			}
		}
	}
	printf("\n");
	for(int f = 0;f<5;f++){
		printf("|%d",cost[f]);
	}
	printf("\n");
	for(int q = 0;q<5;q++){
		printf("PATH%d ", prev[q] );
	}
	return 0;
}
