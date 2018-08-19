# Verificador de balanceamento de "Brackets"

## Introdução
Projeto criado com a finalidade de verificar se uma sequência de "brackets" é válida.

O que define se a sequência é válida é:
- Conter apenas os "brackets" válidos {}()[];
- O subconjunto de "brackets" entre os limites de um par combinado de "brackets" é também um par combinado de "brackets".

Exemplos:
- Válidos:
    - (){}[]
    - [{()}](){}

- Inválidos:
    - []{()
    - [{)]

## Instalação e execução
1) A utilização do verificador é feita via linha de comando. Para isso, é preciso que, após baixar este projeto, você possua o maven instalado em sua máquina e execute na raíz de seu diretório o comando *mvn package*.

2) Execute o comando *java -jar target/balanced-brackets.jar "[SEQUENCIA]"*.
É possível passar mais de uma sequência de brackets como argumento, separando-as com um espaço. Exemplo:
*java -jar target/balanced-brackets.jar "[][[{}]]" "{[[()]]}" "{(()}"*