int entrada = 0;   
int led = 13;

void setup() {
        Serial.begin(9600);    
        pinMode(led,OUTPUT);
        }

void loop() {

          if (Serial.available() > 0) {
                entrada = Serial.parseInt();
                if (entrada != '\n')
                {
                  if (entrada == 1)
                     digitalWrite(led,HIGH);
                  if (entrada == 2)
                     digitalWrite(led,LOW);
                   
                  Serial.print(entrada);
                }
        }
}
