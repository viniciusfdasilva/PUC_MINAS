int led1 =  13;      
int led2 =  12;      
int led3 =  11;      
int led4 =  10;      

int a = 0;
int b = 0;

String binApoioA[4];
String binApoioB[4];

String binA[4];
String binB[4];

void setup(){
  Serial.begin(9600);
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);
}// End setup()

void loop(){
  if(Serial.available() > 0){           
    String entrada = Serial.readString();
    char chr = entrada.charAt(entrada.length()-1);
    entrada = entrada.substring(0,entrada.length()-2);
    if(entrada.charAt(0) == 'A'){
      a = 10; 
    }else if(entrada.charAt(0) == 'B'){
      a = 11;
    }else if(entrada.charAt(0) == 'C'){
      a = 12;
    }else if(entrada.charAt(0) == 'D'){
      a = 13;
    }else if(entrada.charAt(0) == 'E'){
      a = 14;
    }else if(entrada.charAt(0) == 'F'){
      a = 15;
    }else{
      a = atoi(entrada.charAt(0));
    }// End else

    if(entrada.charAt(1) == 'A'){
      b = 10;
    }else if(entrada.charAt(1) == 'B'){
      b = 11;
    }else if(entrada.charAt(1) == 'C'){
      b = 12;
    }else if(entrada.charAt(1) == 'D'){
      b = 13;
    }else if(entrada.charAt(1) == 'E'){
      b = 14;
    }else if(entrada.charAt(1) == 'F'){
      b = 15;
    }else{
      b = atoi(entrada.charAt(0));
    }// End else 

    zeroA();
    decToBinA(a);
    zeroB();
    decToBinB(b);
    
    switch(chr){
      case '0':
        notA();
        if(binApoioA[0] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);      
        if(binApoioA[1] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binApoioA[2] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binApoioA[3] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        break;
      case '1':
        norAB();
        if(binApoioB[0] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);      
        if(binApoioB[1] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binApoioB[2] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binApoioB[3] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        break;
      case '2': 
        AnB();
        if(binApoioB[0] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);      
        if(binApoioB[1] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binApoioB[2] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binApoioB[3] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        break;
      case '3': 
        digitalWrite(,LOW);
        digitalWrite(,LOW);
        digitalWrite(,LOW);
        digitalWrite(,LOW);
        break;
      case '4': 
        nAnB();
        if(binApoioB[0] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);      
        if(binApoioB[1] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binApoioB[2] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binApoioB[3] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        break;
      case '5': 
        notB();
        if(binApoioB[0] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);      
        if(binApoioB[1] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binApoioB[2] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binApoioB[3] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        break;
      case '6': break;
      case '7': break;
      case '8': break;
      case '9': break;
      case 'A': 
        if(binB[0] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);      
        if(binB[1] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binB[2] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binB[3] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        break;
      case 'B': break;
      case 'C': 
        digitalWrite(,HIGH);
        digitalWrite(,HIGH);
        digitalWrite(,HIGH);
        digitalWrite(,HIGH);
        digitalWrite(,HIGH);
        break;
      case 'D': break;
      case 'E': break;
      case 'F': 
        if(binA[0] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);      
        if(binA[1] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binA[2] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        if(binA[3] == "1") digitalWrite(,HIGH);
        else digitalWrite(,LOW);
        break;   
    }// End switch
  }// End if
}// End loop()

void decToBinA(int value){
  int i = 3;
      
  while(value >= 1 && i >= 0){
    if(value % 2 == 0){
      binA[i] = "0";
    }else{
      binA[i] = "1";  
    }// End if
    i--;
    value = (int)(value/2);
  }// End while()
}// End decToBin()

void decToBinB(int value){
  int i = 3;
      
  while(value >= 1 && i >= 0){
    if(value % 2 == 0){
      binB[i] = "0";
    }else{
      binB[i] = "1";  
    }// End if
    i--;
    value = (int)(value/2);
  }// End while()
}// End decToBin()
 
void zeroA(){
  for(int i = 0; i < 4; i++){
    binA[i] = "0";
  }// End for
}// End zero()

void zeroB(){
  for(int i = 0; i < 4; i++){
    binB[i] = "0";
  }// End for
}// End zero()

//=============================================== OPERATIONS ============================================================//

void notA(){
  for(int i = 0; i < 4; i++){
    if(binA[i] == "1"){
      binApoioA[i] = "0";        
    }else if(binA[i] == "0"){
      binApoioA[i] = "1";
    }// End else if
  }// End for
}// End notA()

void notB(){
  for(int i = 0; i < 4; i++){
    if(binB[i] == "1"){
      binApoioB[i] = "0";        
    }else if(binB[i] == "0"){
      binApoioB[i] = "1";
    }// End else if
  }// End for
}// End notA()

void norAB(){
  for(int i = 0; i < 4; i++){
    if((binA[i] == 0 &&  binB[i] == 0)){
      binApoioA[i] = "0";  
    }else{
      binApoioA[i] = "1";
    }// End else
  }// End for
  for(int i = 0; i < 4; i++){
    if(binApoioA[i] == "1"){
      binApoioB[i] == "0";
    }else{
      binApoioB[i] == "1";
    }// End else
  }// End for
}// End norAB()

void AnB(){
  for(int i = 0; i < 4; i++){
    if(binA[i] == "1){
      binApoioA[i] = "0";
    }else{
      binApoioA[i] = "1";
    }// End else
    for(int i = 0; i < 4; i++){
      if(binApoioA[i] == "1" binB[i] == "1"){
        binApoioB[i] = "1";
      }else{
        binApoioB[i] = "0";
      }// End else     
    }// End for    
  }// End for
}// End AnB()

void nAnB(){
  for(int i = 0; i < 4; i++){
    if(binA[i] == "1" binB[i] == "1"){
      binApoioA[i] = "1";
    }else{
      binApoioA[i] = "0";
    }// End else
  }// End for  
  for(int i = 0; i < 4; i++){
    if(binApoioA[i] == "1){
      binApoioB[i] = "0";
    }else{
      binApoioB[i] = "1";
    }// End else   
}// End nAnB()
