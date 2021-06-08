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
    entrada.replace("\n","");
    
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
      a = convert(entrada.charAt(0));
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
      b = convert(entrada.charAt(1));
    }// End else 

    zeroA();
    decToBinA(a);
    zeroB();
    decToBinB(b);
    
    switch(chr){
      case '0':
        low();
        if(binA[0] == "1") digitalWrite(led1,LOW);
        else digitalWrite(led1,HIGH);      
        if(binA[1] == "1") digitalWrite(led2,LOW);
        else digitalWrite(led2,HIGH);
        if(binA[2] == "1") digitalWrite(led3,LOW);
        else digitalWrite(led3,HIGH);
        if(binA[3] == "1") digitalWrite(led4,LOW);
        else digitalWrite(led4,HIGH);
        break;
      case '1':
        low();
        nAoB();
        if(binApoioA[0] == "1") digitalWrite(led1,HIGH);
        else digitalWrite(led1,LOW);      
        if(binApoioA[1] == "1") digitalWrite(led2,HIGH);
        else digitalWrite(led2,LOW);
        if(binApoioA[2] == "1") digitalWrite(led3,HIGH);
        else digitalWrite(led3,LOW);
        if(binApoioA[3] == "1") digitalWrite(led4,HIGH);
        else digitalWrite(led4,LOW);
        break;
      case '2':
        low(); 
        AnB();
        if(binApoioA[0] == "1") digitalWrite(led1,HIGH);
        else digitalWrite(led1,LOW);      
        if(binApoioA[1] == "1") digitalWrite(led2,HIGH);
        else digitalWrite(led2,LOW);
        if(binApoioA[2] == "1") digitalWrite(led3,HIGH);
        else digitalWrite(led3,LOW);
        if(binApoioA[3] == "1") digitalWrite(led4,HIGH);
        else digitalWrite(led4,LOW);
        break;
      case '3':
        low();
        digitalWrite(led1,LOW);
        digitalWrite(led2,LOW);
        digitalWrite(led3,LOW);
        digitalWrite(led4,LOW);
        break;
      case '4':
        low(); 
        nAeB();
        if(binApoioA[0] == "1") digitalWrite(led1,HIGH);
        else digitalWrite(led1,LOW);      
        if(binApoioA[1] == "1") digitalWrite(led2,HIGH);
        else digitalWrite(led2,LOW);
        if(binApoioA[2] == "1") digitalWrite(led3,HIGH);
        else digitalWrite(led3,LOW);
        if(binApoioA[3] == "1") digitalWrite(led4,HIGH);
        else digitalWrite(led4,LOW);
        break;
      case '5':
        low(); 
        if(binB[0] == "1") digitalWrite(led1,LOW);
        else digitalWrite(led1,HIGH);      
        if(binB[1] == "1") digitalWrite(led2,LOW);
        else digitalWrite(led2,HIGH);
        if(binB[2] == "1") digitalWrite(led3,LOW);
        else digitalWrite(led3,HIGH);
        if(binB[3] == "1") digitalWrite(led4,LOW);
        else digitalWrite(led4,HIGH);
        break;
      case '6': 
        low();
        AxB();
        if(binApoioA[0] == "1") digitalWrite(led1,HIGH);
        else digitalWrite(led1,LOW);      
        if(binApoioA[1] == "1") digitalWrite(led2,HIGH);
        else digitalWrite(led2,LOW);
        if(binApoioA[2] == "1") digitalWrite(led3,HIGH);
        else digitalWrite(led3,LOW);
        if(binApoioA[3] == "1") digitalWrite(led4,HIGH);
        else digitalWrite(led4,LOW);
        break;
      case '7': 
        low();
        ABn();
        if(binApoioA[0] == "1") digitalWrite(led1,HIGH);
        else digitalWrite(led1,LOW);      
        if(binApoioA[1] == "1") digitalWrite(led2,HIGH);
        else digitalWrite(led2,LOW);
        if(binApoioA[2] == "1") digitalWrite(led3,HIGH);
        else digitalWrite(led3,LOW);
        if(binApoioA[3] == "1") digitalWrite(led4,HIGH);
        else digitalWrite(led4,LOW);
        break;
      case '8':
        low();
        AnoB();
        if(binApoioA[0] == "1") digitalWrite(led1,HIGH);
        else digitalWrite(led1,LOW);      
        if(binApoioA[1] == "1") digitalWrite(led2,HIGH);
        else digitalWrite(led2,LOW);
        if(binApoioA[2] == "1") digitalWrite(led3,HIGH);
        else digitalWrite(led3,LOW);
        if(binApoioA[3] == "1") digitalWrite(led4,HIGH);
        else digitalWrite(led4,LOW);
        break;
      case '9':
        low();
        nAxB();
        if(binApoioA[0] == "1") digitalWrite(led1,HIGH);
        else digitalWrite(led1,LOW);      
        if(binApoioA[1] == "1") digitalWrite(led2,HIGH);
        else digitalWrite(led2,LOW);
        if(binApoioA[2] == "1") digitalWrite(led3,HIGH);
        else digitalWrite(led3,LOW);
        if(binApoioA[3] == "1") digitalWrite(led4,HIGH);
        else digitalWrite(led4,LOW);
        break;
      case 'A':
        low(); 
        if(binB[0] == "1") digitalWrite(led1,HIGH);
        else digitalWrite(led1,LOW);      
        if(binB[1] == "1") digitalWrite(led2,HIGH);
        else digitalWrite(led2,LOW);
        if(binB[2] == "1") digitalWrite(led3,HIGH);
        else digitalWrite(led3,LOW);
        if(binB[3] == "1") digitalWrite(led4,HIGH);
        else digitalWrite(led4,LOW);
        break;
      case 'B': 
        low();
        AB();
        if(binApoioA[0] == "1") digitalWrite(led1,HIGH);
        else digitalWrite(led1,LOW);      
        if(binApoioA[1] == "1") digitalWrite(led2,HIGH);
        else digitalWrite(led2,LOW);
        if(binApoioA[2] == "1") digitalWrite(led3,HIGH);
        else digitalWrite(led3,LOW);
        if(binApoioA[3] == "1") digitalWrite(led4,HIGH);
        else digitalWrite(led4,LOW);
        break;
      case 'C': 
        low();
        digitalWrite(led1,HIGH);
        digitalWrite(led2,HIGH);
        digitalWrite(led3,HIGH);
        digitalWrite(led4,HIGH);
        break;
      case 'D': 
        low();
        AoBn();
        if(binApoioA[0] == "1") digitalWrite(led1,HIGH);
        else digitalWrite(led1,LOW);      
        if(binApoioA[1] == "1") digitalWrite(led2,HIGH);
        else digitalWrite(led2,LOW);
        if(binApoioA[2] == "1") digitalWrite(led3,HIGH);
        else digitalWrite(led3,LOW);
        if(binApoioA[3] == "1") digitalWrite(led4,HIGH);
        else digitalWrite(led4,LOW);
        break;
      case 'E': 
        low();
        AoB();
        if(binApoioA[0] == "1") digitalWrite(led1,HIGH);
        else digitalWrite(led1,LOW);      
        if(binApoioA[1] == "1") digitalWrite(led2,HIGH);
        else digitalWrite(led2,LOW);
        if(binApoioA[2] == "1") digitalWrite(led3,HIGH);
        else digitalWrite(led3,LOW);
        if(binApoioA[3] == "1") digitalWrite(led4,HIGH);
        else digitalWrite(led4,LOW);
        break;
      case 'F':
        low(); 
        if(binA[0] == "1") digitalWrite(led1,HIGH);
        else digitalWrite(led1,LOW);      
        if(binA[1] == "1") digitalWrite(led2,HIGH);
        else digitalWrite(led2,LOW);
        if(binA[2] == "1") digitalWrite(led3,HIGH);
        else digitalWrite(led3,LOW);
        if(binA[3] == "1") digitalWrite(led4,HIGH);
        else digitalWrite(led4,LOW);        
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

int convert(char chr){
  if(chr == '1') return 1;
  if(chr == '2') return 2;
  if(chr == '3') return 3;
  if(chr == '4') return 4;
  if(chr == '5') return 5;
  if(chr == '6') return 6;
  if(chr == '7') return 7;
  if(chr == '8') return 8;
  if(chr == '9') return 9;
  else return 0;
}// End convert()

void low(){
  digitalWrite(led1,LOW);
  digitalWrite(led2,LOW);
  digitalWrite(led3,LOW);
  digitalWrite(led4,LOW);
}// End low()  


// -------------------------------------------------------------------------------------- OPERATIONS -----------------------------------------------------------------------------------------//

void nAoB(){
  for(int i = 0; i < 4; i++){
    
    if(binA[i] == "0" && binB[i] == "0") binApoioA[i] = "0";
    else binApoioA[i] = "1";

    if(binApoioA[i] == '0') binApoioA[i] = "1";
    else binApoioA[i] = "0";
  }// End for
}// End nAonB()

void AnB(){
  for(int i = 0; i < 4; i++){
    if(binA[i] == '0') binA[i] = "1";
    else binA[i] = "0";
    if(binA[i] == "1" && binB[i] == "1") binApoioA[i] = "1";
    else binApoioA[i] = "0";
  }// End for
}// End AnB()

void nAeB(){
  for(int i = 0; i < 4; i++){
    if(binA[i] == "1" && binB[i] == "1") binApoioA[i] = "0";
    else binApoioA[i] = "1";
  }// End for
}// End nAeB

void AxB(){
  for(int i = 0; i < 4; i++){
      if(binA[i] == "0" && binB[i] == "0" || binA[i] == "1" || binB[i] == "1") binApoioA[i] = "0";
      else binApoioA[i] = "1";
  }// End for
}// End AxB()

void AB(){
  for(int i = 0; i < 4; i++){
    if(binA[i] == "1" && binB[i] == "1") binApoioA[i] = "1";
    else binApoioA[i] = "0";
  }// End for
}// End AB()

void AoB(){
  for(int i = 0; i < 4; i++){
    if(binA[i] == "0" && binB[i] == "0") binApoioA[i] = "0";
    else binApoioA[i] = "1";
  }// End for
}// End AB()

void ABn(){
  for(int i = 0; i < 4; i++){
    if(binA[i] == "1" && binB[i] == "1") binApoioA[i] = "0";
    else binApoioA[i] = "1";
  }// End for
}// End ABn()

void AnoB(){
  for(int i = 0; i < 4; i++){
    if(binA[i] == "0") binA[i] = "1";
    else binA[i] = "0";

    if(binA[i] == "0" && binB[i] == "0") binApoioA[i] = "0";
    else binApoioA[i] = "1";
  }// End for
}// End AnoB()

void nAxB(){
  for(int i = 0; i < 4; i++){
    if(binA[i] == "0" && binB[i] == "0" || binA[i] == "1" && binB[i] == "1") binApoioA[i] = "1";
    else binApoioA[i] = "0";
  }// End for
}// End nAxB()

void AoBn(){
  for(int i = 0; i < 4; i++){
    if(binB[i] == "0") binB[i] = "1";
    else binB[i] = "0";

    if(binA[i] == "0" && binB[i] == "0") binApoioA[i] = "0";
    else binApoioA[i] = "1";
  }// End for
}// End AoBn()


