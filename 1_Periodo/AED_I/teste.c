#include<stdio.h>
static int teste(){
	static int var = 0;
	return ++var;
}// End teste()


int main(void){
	teste();
	teste();
	teste();
	teste();
	teste();
	teste();
	teste();
	teste();
	teste();
	teste();
	teste();
	teste();
	teste();
	teste();
	teste();
	int var = teste();
	printf("%i\n",var);
	return(0);
}// End main()