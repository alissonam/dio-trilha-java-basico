import java.util.Scanner;

// Classe de exceção personalizada para validar os parâmetros
class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String message) {
        super(message);
    }
}

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        // Solicita o primeiro parâmetro
        System.out.print("Digite o primeiro parâmetro: ");
        int primeiroParametro = terminal.nextInt();

        // Solicita o segundo parâmetro
        System.out.print("Digite o segundo parâmetro: ");
        int segundoParametro = terminal.nextInt();

        try {
            // Chama o método para realizar a contagem
            contar(primeiroParametro, segundoParametro);
        } catch (ParametrosInvalidosException exception) {
            // Captura e exibe a exceção caso o primeiro parâmetro seja maior ou igual ao
            // segundo
            System.out.println("O segundo parâmetro deve ser maior que o primeiro");
        }
    }

    // Método responsável por realizar a contagem
    static void contar(int primeiroParametro, int segundoParametro) throws ParametrosInvalidosException {
        // Verifica se o primeiro parâmetro é maior ou igual ao segundo e lança a
        // exceção
        if (primeiroParametro >= segundoParametro) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        // Calcula a quantidade de iterações
        int contagem = segundoParametro - primeiroParametro;

        // Laço de repetição para imprimir os números incrementados
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}
