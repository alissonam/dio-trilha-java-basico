# Desafio Controle de Fluxo

Este projeto consiste em um programa Java que recebe dois números inteiros como entrada e realiza uma contagem com base nesses valores. Caso o primeiro número seja maior ou igual ao segundo, o programa lança uma exceção personalizada.

## Estrutura do Projeto

O projeto contém as seguintes classes:

- **`Contador`**: Classe principal que solicita os parâmetros ao usuário e chama o método de contagem.
- **`ParametrosInvalidosException`**: Exceção personalizada para lidar com entradas inválidas.

## Funcionamento

1. O usuário insere dois números inteiros pelo terminal.
2. O programa verifica se o segundo número é maior que o primeiro.
3. Caso contrário, lança uma exceção `ParametrosInvalidosException` com a mensagem: _"O segundo parâmetro deve ser maior que o primeiro"_.
4. Se os parâmetros forem válidos, o programa realiza um loop `for` para imprimir os números incrementados.

## Exemplo de Execução

Entrada:

```
Digite o primeiro parâmetro:
5
Digite o segundo parâmetro:
10
```

Saída:

```
Imprimindo o número 1
Imprimindo o número 2
Imprimindo o número 3
Imprimindo o número 4
Imprimindo o número 5
```
