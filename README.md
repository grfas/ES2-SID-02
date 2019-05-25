# ES2-SID

Grupo 2

Francisco Bruno
João Estevão
Hugo João
Gonçalo Ferreira
Tiago Neves
Filipe Ferreira


A entrega foi feita em VM VirtualBox 

Será necessário Transferir a pasta Windows10 Clone, que contem a virtual machine já com o estado guardado, onde já se encontram a correr o servidor mysql e o mongodb.


Para correr o nosso programa é necessário 
1. Correr  LeituraSensor.jar que se encontra no ambiente de trabalho da VM , que vai começar a leitura do sensor

2. Correr o Leitura LeituraMongo.jar que vai ler os valores colocados na Base de dados mongoDB

3.Correr GUI Login
    Caso queira entrar como Administrador user: pedro 
                                          password: pedro 
                                          
    Caso queira entrar como investigador user: joao
                                         password : joao
                                         


4. Caso o sensor apenas esteja a enviar um valor, é devido ao broker inserido no ficheiro de configuração que pode ser encontrado na diretoria C:\Users\ES2\eclipse-workspace\javamongo\src\configMongo.cfg


Onde pode alterar o valor do broker que está por pré-definição

Variável mBrokerName
=tcp://iot.eclipse.org:1883
e tem como alternativa =tcp://broker.mqtt-dashboard.com:1883

E pode alterar o nome do topico subscrito
Variável mTopicName =/sid_lab_2019_2
e como alternativa  =/sid_lab_2019
