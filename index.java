import java.util.Scanner;

public class index {
    
    public static void main(String[] args) {

        //Scanner para que o usuário escolha a opção do programa
        Scanner teclado = new Scanner(System.in);
        int opcao;


        //Essa classe está sendo criada antes porque vou usar ela no if, as outras estou criando depois, porque tenho que definir o valor da moeda que vai ser usada antes
        Cofrinho cofre = new Cofrinho();

        do {
            System.out.println("\n|------------------------------------|");
            System.out.println("|            MENU PRINCIPAL          |");
            System.out.println("|------------------------------------|");
            System.out.println("| 1 - Adicionar Moedas               |");
            System.out.println("| 2 - Remover Moedas                 |");
            System.out.println("| 3 - Listar Moedas                  |");
            System.out.println("| 4 - Converter em Real              |");
            System.out.println("| 0 - Sair                           |");
            System.out.println("|------------------------------------|");
            System.out.println("Escolha uma opcao: ");
            opcao = teclado.nextInt();
            print

            if (opcao == 1) {
                System.out.println("Qual tipo de moeda gostaria de adicionar: ");
                System.out.println("1 - Real");
                System.out.println("2 - Euro");
                System.out.println("3 - Dolar");
                System.out.println("4 - Retornar ao menu");
                int tipo = teclado.nextInt();
                double valor = 0;

                if (tipo != 4) {
                    System.out.println("Qual valor gostaria de adicionar: ");
                    valor = teclado.nextDouble();
                }

                // Adicionar moedas no cofre
                if (tipo == 1) {
                    cofre.adicionar(new Real(valor));
                } else if (tipo == 2) {
                    cofre.adicionar(new Euro(valor));
                } else if (tipo == 3) {
                    cofre.adicionar(new Dolar(valor)); 
                } else if (tipo == 4) {
                    System.out.println("Retornando ao menu...");
                    continue;
                } else {
                    System.out.println("Valor Invalido! Tente novamente.");
                }

            } else if (opcao == 2) {
                System.out.println("Qual tipo de moeda gostaria de remover: ");
                System.out.println("1 - Real");
                System.out.println("2 - Euro");
                System.out.println("3 - Dolar");
                System.out.println("4 - Retornar ao menu");
                int tipo = teclado.nextInt();
                double valor = 0;

                System.out.println("Qual valor gostaria de remover: ");
                valor = teclado.nextDouble();

                // Remover tipos de moedas do cofre
                if (tipo == 1) {
                    cofre.remover(new Real(valor));
                } else if (tipo == 2) {
                    cofre.remover(new Euro(valor));
                } else if (tipo == 3) {
                    cofre.remover(new Dolar(valor));
                } else if(tipo == 4) {
                    System.out.println("Retornando ao menu...");
                    continue;
                } else {
                    System.out.println("Valor Invalido! Tente novamente.");
                }

            } else if (opcao == 3) {
                // Listar as moedas que tem no cofre
                cofre.listagemMoedas();

            } else if (opcao == 4) {
                // Converter as moedas em reias que tem no cofre
                double total = cofre.totalConvertido();
                System.out.println("Total em reais: R$ " + total);

            } else if (opcao == 0) {
                System.out.println("Encerrando programa...");
                break;
            } else {
                System.out.println("Valor Invalido! Tente novamente.");
            }
        } while (opcao != 0);

        // Fechando Scanner para não ter vazamento de memoria e para boas praticas, tudo que for aberto, tem que ter seu fechamento.
        teclado.close();
    }
}
