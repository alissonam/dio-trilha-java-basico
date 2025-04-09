public class Main {
    public static void main(String[] args) {
        // Criação do cliente Venilton
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        // Criação de duas contas para Venilton: uma corrente e uma poupança
        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        // Deposita R$100 na conta corrente
        cc.depositar(100);

        // Saca R$25 da conta corrente
        cc.sacar(25);

        // Transfere R$50 da conta corrente para a poupança
        cc.transferir(50, poupanca);

        // Criação da cliente Maria
        Cliente maria = new Cliente();
        maria.setNome("Maria");

        // Criação da conta corrente de Maria
        Conta ccMaria = new ContaCorrente(maria);

        // Maria deposita R$300 em sua conta corrente
        ccMaria.depositar(300);

        // Maria transfere R$100 para a conta corrente de Venilton
        ccMaria.transferir(100, cc);

        // Impressão dos extratos de todas as contas
        System.out.println("\n--- Extratos ---");
        cc.imprimirExtrato(); // Conta Corrente de Venilton
        poupanca.imprimirExtrato(); // Conta Poupança de Venilton
        ccMaria.imprimirExtrato(); // Conta Corrente de Maria
    }
}
