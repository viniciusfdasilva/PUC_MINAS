int entrada1 = 0;   
int entrada2 = 0;   
int saida;
int led = 13;

void setup() {
        Serial.begin(9600);     
        pinMode(led,OUTPUT);
        }

void loop() {

                if (Serial.available() > 0) {
                
                entrada1 = Serial.parseInt();
                entrada2 = Serial.parseInt();

                if (Serial.read()=='\n')
                {
                  saida = soma(entrada1,entrada2);
                
                  Serial.print(saida);
                
                  if (saida == 1)
                     digitalWrite(led,HIGH);
                  if (saida == 2)
                     digitalWrite(led,LOW);
                   
                }  
      }
}

int soma(int a, int b)
{
  return(a+b);
}
