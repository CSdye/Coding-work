// Callen Dye
// This program displays the adding of integers and reports int overflow/underflow
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
int main(int argc, char *argv[]) {
  int over = 0; //overflow tracker
  int under = 0; // underlow tracker
  long val = 0; // input
  int j;
  for(j = 1; j < argc; j++){
    val += atol(argv[j]);
    if(val > INT_MAX){
      over++;
    }
    if(val < INT_MIN){
      under++;
    }
    if(val >= LONG_MAX || val <= LONG_MIN){
      val = 0;
      printf("You reached the maximum amount of memory... don't do that. Reset to 0\n");
    }
  }
  printf("%ld\n", val);;
  printf("This is the number of times there was overflow:%d\n", over);
  printf("This is the number of times there was underflow:%d\n", under);
  return 0;
}
