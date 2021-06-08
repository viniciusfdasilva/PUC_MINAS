// Chaves
 
int botao1 = A0;     // define primeiro botao
int botao2 = A1;     // define segundo botao
int botao3 = A2;     // define terceiro botao
int botao4 = A3;     // define quarto botao

int led1 =  13;      // pino do led
int led2 =  12;      
int led3 =  11;      
int led4 =  10;      

// variables will change:
int pos_bot1 = 0;
int pos_bot2 = 0;
int pos_bot3 = 0;
int pos_bot4 = 0;


void setup() {
// Define as entradas e saídas
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);

  pinMode(botao1, INPUT);     
  pinMode(botao2, INPUT);     
  pinMode(botao3, INPUT);     
  pinMode(botao4, INPUT);     

}

void loop(){
  // read the state of the pushbutton value:
  pos_bot1 = digitalRead(botao1);
  pos_bot2 = digitalRead(botao2);
  pos_bot3 = digitalRead(botao3);
  pos_bot4 = digitalRead(botao4);

  if (pos_bot1 == HIGH) {     
    digitalWrite(led1, HIGH);  
  } 
  else {
    digitalWrite(led1, LOW); 
  }

  if (pos_bot2 == HIGH) {     
    digitalWrite(led2, HIGH);  
  } 
  else {
    digitalWrite(led2, LOW); 
  }
  if (pos_bot3 == HIGH) {     
    digitalWrite(led3, HIGH);  
  } 
  else {
    digitalWrite(led3, LOW); 
  }
  if (pos_bot4 == HIGH) {     
    digitalWrite(led4, HIGH);  
  } 
  else {
    digitalWrite(led4, LOW); 
  }



}
