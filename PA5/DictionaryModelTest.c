#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"Dictionary.h"


int isEmptyTests(Dictionary dict){
	int points = 0;
	int total = 9;
	int testSize = 1000;
	int i;

	printf("============================\n");
	printf("	isEmtpy Tests\n");
	printf("----------------------------\n");

	//TEST 1
	if(isEmpty(dict)){
		printf("isEmpty test 1 passed!\n");
		points += 3;
	}else{
		printf("isEmpty test 1 failed!\n");
	}
	
	//TEST 2
	char tkey[100];
	char tvalue[100];

	for(i = 0; i < testSize; i++){
		sprintf(tkey,"key_%d",i);
		sprintf(tvalue,"value_%d",i);
		insert(dict,tkey,tvalue);	
	}
	if(isEmpty(dict)){
		printf("isEmpty test 2 failed!\n");
	}else{
		printf("isEmpty test 2 passed!\n");
		points += 3;
	}
	
	//TEST 3
	int flag = 1;
	for(i = 0; i < testSize; i++){
		sprintf(tkey,"key_%d",i);
		delete(dict,tkey);
		if(i < (testSize - 1) && isEmpty(dict)){
			printf("isEmpty test 3 failed!: Key == %s\n",tkey);
			flag = 0;
			break;
		}
	}
	if(flag && isEmpty(dict)){
		printf("isEmpty test 3 passed!\n");
		points += 3;
	}else{
		printf("isEmpty test 3 failed!: dict size: %d\n", size(dict));
	}
	
	printf("----------------------------\n");
	printf("isEmpty score: %d / %d\n", points, total);
	printf("============================\n");
	return points;	
}

int sizeTests(Dictionary dict){
	int points = 0;
	int total = 9;
	int testSize = 1000;
	int i;

	printf("============================\n");
	printf("	size Tests\n");
	printf("----------------------------\n");

	//TEST 1
	if(size(dict) == 0){
		printf("size test 1 passed!\n");
		points += 3;
	}else{
		printf("size test 1 failed!\n");
	}

	//Test 2
	char tkey[100];
	char tvalue[100];

	for(i = 0; i < testSize; i++){
		sprintf(tkey,"key_%d",i);
		sprintf(tvalue,"value_%d",i);
		insert(dict,tkey,tvalue);	
	}

	if(size(dict) == testSize){
		printf("size test 2 passed!\n");
		points += 3;
	}else{
		printf("size test 2 failed!\n");
	}

	//Test 3
	for(i = 0; i < testSize; i++){
		sprintf(tkey,"key_%d",i);
		delete(dict,tkey);	
	}

	if(size(dict) == 0){
		printf("size test 3 passed!\n");
		points += 3;
	}else{
		printf("size test 3 failed!\n");
	}

	printf("----------------------------\n");
	printf("size score: %d / %d\n", points, total);
	printf("============================\n");
	return points;	
}

int newDictTests(){
	int points = 0;
	int total = 8;
	int testSize = 1000;
	int i;

	printf("============================\n");
	printf("	newDictionary Tests\n");
	printf("----------------------------\n");

	//Test 1
	Dictionary newDict = newDictionary();
	if(newDict != NULL){
		printf("newDictionary test 1 passed!\n");
		points += 8;
	}else{
		printf("newDictionary test 1 failed!\n");
	}

	printf("----------------------------\n");
	printf("newDictionary score: %d / %d\n", points, total);
	printf("============================\n");
	return points;	
}

int freeDictTests(Dictionary dict){
	int points = 0;
	int total = 9;
	int testSize = 1000;
	int i;

	printf("============================\n");
	printf("	freeDictionary Tests\n");
	printf("----------------------------\n");

	freeDictionary(&dict);
	if(dict){
		printf("freeDictionary test 1 failed!\n");
	}else{
		printf("freeDictionary test 1 passed!\n");
		points += 9;
	}

	printf("----------------------------\n");
	printf("freeDictionary score: %d / %d\n", points, total);
	printf("============================\n");
	return points;	
}

int lookupTests(Dictionary dict){
	int points = 0;
	int total = 9;
	int testSize = 1000;
	int i;

	printf("============================\n");
	printf("	lookup Tests\n");
	printf("----------------------------\n");

	//Test 1
	insert(dict,"key","value");
	if(strcmp(lookup(dict,"key"),"value") == 0){
		printf("lookup test 1 passed!\n");
		points += 3;
	}else{
		printf("lookup test 1 failed!\n");
	}

	//Test 2
	char tvalue[100];
	char tkey[100];
	for(i = 0; i < testSize; i++){
		sprintf(tvalue,"value_%d", i);
		sprintf(tkey,"key_%d",i);
		insert(dict,tkey,tvalue);
	}
	int flag = 1;
	for(i = 0; i < testSize; i++){
		sprintf(tkey,"key_%d",i);
		sprintf(tvalue,"value_%d",i);
		if(strcmp(lookup(dict,tkey),tvalue) != 0){
			printf("lookup test 2 failed\n");
			flag = 0;
			break;
		}
	}
	if(flag){
		printf("lookup test 2 passed!\n");
		points += 3;
	}

	//Test 3
	char vkey[100];
	flag = 1;
	for(i = 0; i < testSize-1; i++){
		sprintf(tkey,"key_%d",i);
		sprintf(vkey,"key_%d",i+1);
		sprintf(tvalue,"value_%d",i+1);
		delete(dict,tkey);
		if(strcmp(lookup(dict,vkey),tvalue) != 0){
			printf("lookup test 3 failed\n");
			flag = 0;
			break;
		}
	}
	if(flag){
		printf("lookup test 3 passed!\n");
		points += 3;
	}


	printf("----------------------------\n");
	printf("lookup score: %d / %d\n", points, total);
	printf("============================\n");
	return points;	
}

int insertTests(Dictionary dict){
	int points = 0;
	int total = 9;
	int testSize = 1000;
	int i;

	printf("============================\n");
	printf("	insert Tests\n");
	printf("----------------------------\n");

	//Test 1
	insert(dict,"key","value");
	if(strcmp(lookup(dict,"key"),"value") == 0 && size(dict) == 1){
		printf("insert test 1 passed!\n");
		points += 4;
	}else{
		printf("insert test 1 failed!\n");
	}

	//Test 2
	char tvalue[100];
	char tkey[100];
	int flag = 1;
	for(i = 0; i < testSize; i++){
		sprintf(tvalue,"value_%d", i);
		sprintf(tkey,"key_%d",i);
		insert(dict,tkey,tvalue);
		if(strcmp(lookup(dict,tkey),tvalue) != 0 && size(dict) != i+1){
			printf("insert test 2 failed\n");
			flag = 0;
			break;
		}
	}
	if(flag){
		printf("insert test 2 passed!\n");
		points += 5;
	}

	printf("----------------------------\n");
	printf("insert score: %d / %d\n", points, total);
	printf("============================\n");
	return points;	
}

int deleteTests(Dictionary dict){
	int points = 0;
	int total = 9;
	int testSize = 1000;
	int i;

	printf("============================\n");
	printf("	delete Tests\n");
	printf("----------------------------\n");

	//Test 1
	insert(dict,"key","value");
	delete(dict,"key");
	if(lookup(dict,"key") && size(dict) != 0){
		printf("delete test 1 failed\n");
	}else{
		printf("delete test 1 passed!\n");
		points += 4;
	}

	//Test 2
	char tvalue[100];
	char tkey[100];
	int flag = 1;
	for(i = 0; i < testSize; i++){
		sprintf(tvalue,"value_%d", i);
		sprintf(tkey,"key_%d",i);
		insert(dict,tkey,tvalue);
	}
	for(i = 0; i < testSize; i++){
		sprintf(tkey,"key_%d",i);
		delete(dict,tkey);
		if(lookup(dict,tkey) != NULL && size(dict) != i+1){
			printf("delete test 2 failed\n");
			flag = 0;
			break;
		}
	}

	if(flag){
		printf("delete test 2 passed!\n");
		points += 5;
	}


	printf("----------------------------\n");
	printf("delete score: %d / %d\n", points, total);
	printf("============================\n");
	return points;	
}

int makeEmptyTests(Dictionary dict){
	int points = 0;
	int total = 9;
	int testSize = 1000;
	int i;

	printf("============================\n");
	printf("	makeEmpty Tests\n");
	printf("----------------------------\n");

	//Test 1
	insert(dict,"key","value");
	makeEmpty(dict);
	if(lookup(dict,"key") && size(dict) != 0){
		printf("makeEmpty test 1 failed\n");
	}else{
		printf("makeEmpty test 1 passed!\n");
		points += 4;
	}

	//Test 2
	char tvalue[100];
	char tkey[100];
	int flag = 1;
	for(i = 0; i < testSize; i++){
		sprintf(tvalue,"value_%d", i);
		sprintf(tkey,"key_%d",i);
		insert(dict,tkey,tvalue);
	}

	makeEmpty(dict);

	if(size(dict)!=0 && lookup(dict,tvalue) != NULL){
		printf("makeEmpty test 2 failed!\n");

	}else{
		printf("makeEmpty test 2 passed!\n");		
		points += 5;
	}


	printf("----------------------------\n");
	printf("makeEmpty score: %d / %d\n", points, total);
	printf("============================\n");
	return points;	
}

int printDictionaryTests(Dictionary dict){
	int points = 0;
	int total = 9;
	int testSize = 1000;
	int i;

	printf("============================\n");
	printf("	printDictionary Tests\n");
	printf("----------------------------\n");

   	FILE* out = fopen("printDictionary-Test-out", "w");

	char tvalue[100];
	char tkey[100];
	for(i = 0; i < testSize; i++){
		sprintf(tvalue,"value_%d", i);
		sprintf(tkey,"key_%d",i);
		insert(dict,tkey,tvalue);
		fprintf(out,"Inserting: %s -> %s\n",tkey,tvalue);
		printDictionary(out, dict);
	}
	
	printf("printDictionary test 1 passed!\n");	
	points += 9;

	printf("----------------------------\n");
	printf("printDictionary score: %d / %d\n", points, total);
	printf("============================\n");
	return points;	
}

int main(int argc, char* argv[]){

	int points = 0;
	int total = 80;

	points += newDictTests();

	Dictionary freeDict = newDictionary();
	points += freeDictTests(freeDict);

	Dictionary insertDict = newDictionary();
	points += insertTests(insertDict);
	freeDictionary(&insertDict);

	Dictionary lookupDict = newDictionary();
	points += lookupTests(lookupDict);
	freeDictionary(&lookupDict);

	Dictionary deleteDict = newDictionary();
	points += deleteTests(deleteDict);
	freeDictionary(&deleteDict);

	Dictionary sizeDict = newDictionary();
	points += sizeTests(sizeDict);
	freeDictionary(&sizeDict );

	Dictionary emptyDict = newDictionary();
	points += isEmptyTests(emptyDict);
	freeDictionary(&emptyDict);

	Dictionary makeEmptyDict = newDictionary();
	points += makeEmptyTests(makeEmptyDict);
	freeDictionary(&makeEmptyDict);
	
	Dictionary printDict = newDictionary();
	points += printDictionaryTests(printDict);
	freeDictionary(&printDict);

	printf("Overall Score: %d / 80\n", points);
	printf("============================\n");

	return 0;
}
