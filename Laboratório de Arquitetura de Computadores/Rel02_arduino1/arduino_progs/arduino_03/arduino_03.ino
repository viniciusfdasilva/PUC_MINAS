char entrada = 'c';   
int led = 13;
int i;
void setup() {
        Serial.begin(9600);     // abre a porta serial a 9600 bps
        pinMode(led,OUTPUT);
        }

void loop() {

        // verifica se existe dados a ser lido
        if (Serial.available() > 0) 
        {
                // lê o dado
                entrada = Serial.read();
                if (entrada != '\n')
                {
                  if (entrada == 'a')
                     digitalWrite(led,HIGH);
                  if (entrada == 'b')
                     digitalWrite(led,LOW);
                  Serial.println(entrada);
                }
         }
}
