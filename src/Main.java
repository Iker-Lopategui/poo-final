import java.util.Map;
import java.util.Scanner;

public class Main {

    // Método para obter a categoria de referência do usuário
    public static String obterCategoriaReferencia(Scanner scanner) {
        System.out.println("Escolha a categoria de referência para comparação:");
        System.out.println("1. Homem adulto");
        System.out.println("2. Mulher adulta");
        System.out.println("3. Criança");
        System.out.print("Digite o número correspondente à sua escolha (1, 2 ou 3): ");
        
        int escolha = scanner.nextInt();
        
        switch (escolha) {
            case 1:
                return "Adulto-Masculino";
            case 2:
                return "Adulto-Feminino";
            case 3:
                return "Criança";
            default:
                System.out.println("Escolha inválida. Usando padrão Mulher adulta.");
                return "Adulto-Feminino";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação dos valores de referência
        ValoresReferencia valoresReferencia = new ValoresReferencia();

        // Obtendo a categoria de referência do usuário
        String categoria = obterCategoriaReferencia(scanner);

        // Solicitação de dados do hemograma
        Hemograma hemograma = new Hemograma();
        System.out.println("Insira os dados do hemograma:");
        for (String parametro : valoresReferencia.obterValores(categoria).keySet()) {
            System.out.print(parametro + ": ");
            double valor = scanner.nextDouble();
            hemograma.adicionarValor(parametro, valor);
        }

        // Comparação com os valores de referência
        Map<String, FaixaValores> valoresReferenciaUsuario = valoresReferencia.obterValores(categoria);
        for (String parametro : hemograma.valores.keySet()) {
            double valor = hemograma.obterValor(parametro);
            FaixaValores faixaValores = valoresReferenciaUsuario.get(parametro);
            if (valor < faixaValores.getMin() || valor > faixaValores.getMax()) {
                System.out.println(parametro + " fora do valor de referência: " + valor + " " + faixaValores.getUnidade());
            }
        }

        scanner.close();
    }
}