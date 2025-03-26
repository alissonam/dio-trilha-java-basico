import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        // Declara o scanner para receber entradas do usuário.
        Scanner scanner = new Scanner(System.in);

        // Solicita e recebe o número da conta.
        System.out.print("Por favor, digite o número da Conta: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Pula para a proxima linha.

        // Solicita e recebe o número da agência.
        System.out.print("Por favor, digite o número da Agência: ");
        String agency = scanner.nextLine();

        // Solicita e recebe o nome do cliente.
        System.out.print("Por favor, digite o nome do Cliente: ");
        String clientName = scanner.nextLine();

        // Solicita e recebe o saldo que será depósitado já na criação da conta.
        System.out.print("Por favor, digite o saldo: ");
        double balance = scanner.nextDouble();

        // Encerra o Scanner.
        scanner.close();

        // Mostrando ao usuário todos os dados coletados.
        System.out.println("\nOlá " + clientName + ", obrigado por criar uma conta em nosso banco, " +
                "sua agência é " + agency + ", conta " + number + " e seu saldo R$ " + balance
                + " já está disponível para saque.");
    }
}
