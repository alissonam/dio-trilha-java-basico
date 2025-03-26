# ContaBanco - Cadastro de Conta Bancária

Este projeto em Java permite que o usuário insira dados de uma conta bancária via terminal e exibe uma mensagem confirmando o cadastro.

## Como Funciona

O programa solicita os seguintes dados:

- **Número da Conta**
- **Número da Agência**
- **Nome do Cliente**
- **Saldo Inicial**

Após a inserção, uma mensagem de confirmação com os dados fornecidos é exibida.

## Exemplo de Execução

```shell
Por favor, digite o número da Conta: 1021
Por favor, digite o número da Agência: 067-8
Por favor, digite o nome do Cliente: Mario Andrade
Por favor, digite o saldo: 237.48

Olá Mario Andrade, obrigado por criar uma conta em nosso banco, sua agência é 067-8, conta 1021 e seu saldo R$ 237.48 já está disponível para saque.
```

## Como Executar

1. **Compilar o código:**
   ```shell
   javac ContaTerminal.java
   ```
2. **Executar o programa:**
   ```shell
   java ContaTerminal
   ```

## Tecnologias Utilizadas

- **Java SE**
- **Scanner (java.util.Scanner)** para entrada de dados
