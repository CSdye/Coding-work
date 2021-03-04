//Callen Dye
//This program allocates and deallocates memory in order to pass a lot of data through a small RAM.
//This program takes roughly 24 minutes to complete running
#include <stdio.h>
#include<stdlib.h>
#include<limits.h>
#include<time.h>

struct node {
  char * data;
  struct node * next;
};
int enqueue(char * string,struct node ** front,struct node ** tail){
    struct node *temp = NULL;
    temp = (struct node*)malloc(sizeof(struct node));
    (*temp).data = string;
    (*temp).next = NULL;
    if(*front == NULL && *tail == NULL){
      *front = temp;
      *tail = temp;
      return 1;
    }else{
      (**tail).next = temp;
      *tail = temp;
      return 1;
    }
    return 0;
}
char * dequeue(struct node ** front, struct node ** tail){
  if(*front == NULL && *tail == NULL){
    return NULL;
  }
  else if(*front == *tail){
    char *value = (**front).data;
    free(*front);
    *front = NULL;
    *tail = NULL;
    return value;
  }else{
    char *value = (**front).data;
    struct node *temp = *front;
    *front=(**front).next;
    free(temp);
    return value;
 }
}
int main(){
  time_t t=time(NULL);
  printf("Time of program start:\t %s",asctime(localtime(&t)));
  int Nodes=100000;
  int strsize=1000000;
  int lcv1,lcv2,lcv3,lcv4, lcv5;
  srand (time(NULL));
  struct node *first=NULL;
  struct node *last=NULL;
  int numDeq=0;
  int numEnq=0;

  for(lcv1 = 0;lcv1 < 10;lcv1++){
    char *string =(char *)malloc(strsize* sizeof(char));
    for(lcv2 = 0;lcv2 < strsize;lcv2++){
      string[lcv2]=(rand()%26)+65;
      }
    enqueue(string,&first,&last);
    numEnq++;
    }
  for(lcv3 = 0;lcv3 < Nodes; lcv3++){
    char *string =(char *)malloc(strsize* sizeof(char));
    for(lcv4=0;lcv4 < strsize; lcv4++){
      string[lcv4] = (rand()%26)+65;
      }
  enqueue(string,&first,&last);
    char * result = dequeue(&first,&last);
    free(result);
    numDeq++;
    numEnq++;
  }
  //dequeue 12 more times
   for(lcv5 = 0;lcv5 < 12;lcv5++){
      char * result=dequeue(&first,&last);
      free(result);
      numDeq++;
  }
  t=time(NULL);
  printf("Time of program end:\t %s",asctime(localtime(&t)));
  printf("The number of successful enqueues: %d \n",numEnq);
  printf("The number of successful dequeues: %d \n",numDeq);
  return 0;
}
