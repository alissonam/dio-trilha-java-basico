# 💳 Banco Digital - Orientação a Objetos com Java

Este projeto é uma solução para o **desafio de orientação a objetos**, com o objetivo de aplicar os principais conceitos de **POO em Java** em um cenário bancário.

---

## 📌 Desafio

> “Um banco oferece aos seus clientes dois tipos de contas (corrente e poupança), as quais possuem as funcionalidades de depósito, saque e transferência (entre contas da própria instituição).”

---

## 🎯 Objetivos

O projeto tem como foco os principais pilares da Programação Orientada a Objetos:

- ✅ **Abstração** – Representação dos elementos principais do domínio bancário.
- ✅ **Encapsulamento** – Organização e ocultação de detalhes internos das classes.
- ✅ **Herança** – Reutilização de código com classes filhas (`ContaCorrente` e `ContaPoupanca`).
- ✅ **Polimorfismo** – Uso da interface `IConta` para generalizar operações com contas.

---

## 🛠️ Tecnologias

- Java 11+
- IDE recomendada: IntelliJ, Eclipse ou VSCode com extensão Java
- Nenhuma dependência externa

---

## 🧪 Funcionalidades

- Criar clientes e contas
- Depositar valores
- Sacar valores
- Transferir entre contas (da mesma instituição)
- Emitir extrato da conta corrente e poupança

---

## 🧾 Estrutura do Projeto

- `Banco` – Armazena as contas cadastradas
- `Cliente` – Representa o cliente do banco
- `Conta` (abstrata) – Base para as contas do banco
  - `ContaCorrente`
  - `ContaPoupanca`
- `IConta` – Interface com as operações essenciais
- `Main` – Classe principal com um exemplo de execução

---

## 📸 Exemplo de saída

```text
=== Extrato Conta Corrente ===
Titular: Venilton
Agencia: 1
Numero: 1
Saldo: 0.00

=== Extrato Conta Poupança ===
Titular: Venilton
Agencia: 1
Numero: 2
Saldo: 100.00
```

---

## 🙌 Créditos

Este projeto foi copiado a partir do repositório original para fins didaticos, o repositório original foi criado por [João Ribeiro (falvojr)](https://github.com/falvojr):

🔗 [https://github.com/falvojr/lab-banco-digital-oo](https://github.com/falvojr/lab-banco-digital-oo)

---
