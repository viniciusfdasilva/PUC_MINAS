char entrada = '0';   
int led = 13;
int i;
void setup() {
        Serial.begin(9600);     // abre a porta serial a 9600 bps
        pinMode(led,OUTPUT);
        }

void loop() {

        // verifica se existe dados a ser lido
        if (Serial.available() > 0) {
                // lê o dado
                entrada = Serial.read();

                if (entrada == '1')
                   digitalWrite(led,HIGH);
                if (entrada == '2')
                   digitalWrite(led,LOW);
                }
}
