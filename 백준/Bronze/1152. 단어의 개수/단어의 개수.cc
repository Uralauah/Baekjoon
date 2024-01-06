#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 1000002

int main(){

    char *sentence = (char *)malloc(sizeof(char) * MAX);
    if(sentence == NULL){
        printf("Failed to allocate memory\n");
        exit(-1);
    }

   fgets(sentence, MAX,stdin);

    int length = strlen(sentence);
    sentence[--length] = '\0';

    char prev = ' ';
    int word_count = 0;
    for(int i = 0 ; i <= length ; i++){
        if(prev != ' ' && (sentence[i] == ' ' || sentence[i] == '\0')){
            word_count++;
        }
        prev = sentence[i];
    }

    printf("%d\n", word_count);

    free(sentence);
    return 0;
}