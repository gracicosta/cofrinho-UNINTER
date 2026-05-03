import java.util.ArrayList;

public class Cofrinho {

    //Está como private para que apenas a classe cofrinho acesse a array
    private ArrayList<Moeda> listaMoedas = new ArrayList<>();

    //Adicionando moedas
    public void adicionar(Moeda moeda) {
        //Adiciona a moeda na array
        listaMoedas.add(moeda);
        System.out.println("Sua moeda está no cofrinho!");
    }

    //Remover moedas
    public void remover(Moeda moeda) {

        //Vai pegar o valor da moeda e armazenar na variavel, o get é porque a moeda está como private
        double valorRemover = moeda.getValor();

        // For usado para percorrer a array listaMoedas
        for (int i = 0; i < listaMoedas.size(); i++) {
            // Armazenado a moeda na posição i da array dentro da variavel money
            Moeda money = listaMoedas.get(i);

            // Verifica se o money é o mesmo tipo de moeda que será removido, mesma classe
            if (money.getClass() == moeda.getClass()) {

                //Verifica se tem o valor que queremos remover
                if (money.getValor() == valorRemover) {
                    listaMoedas.remove(i);
                    System.out.println("Você gastou " + valorRemover );
                    return;
                } else if (money.getValor() > valorRemover) { //Caso o valor seja maior
                    double novoValor = money.getValor() - valorRemover;
                    listaMoedas.remove(i);

                    // Verifica se o valor da moeda é de qual tipo e adiciona o novo valor
                    if (money instanceof Real) {
                        listaMoedas.add(i, new Real(novoValor));
                    } else if (money instanceof Euro) {
                        listaMoedas.add(i, new Euro(novoValor));
                    } else if (money instanceof Dolar) {
                        listaMoedas.add(i, new Dolar(novoValor));
                    }
                    
                    System.out.println("Você gastou " + valorRemover + ". Agoras você tem " + novoValor + " no cofrinho.");
                    return;
                }
            }
        }

        System.out.println("Não foi possível remover, saldo insuficiente!");
    }
    
    public void listagemMoedas() {
        //isEmpty é para caso a listaMoedas esteja vazia
        if(listaMoedas.isEmpty()) {
            System.out.println("Cofrinho sem moedas. Junte mais!");
            return;
        }

        System.out.println("\nVocê tem dinheiro no cofrinho!");
        // Percorre a listaMoedas e chama a função info das classes real, euro e dolar
        for (Moeda money : listaMoedas) {
            money.info();
        }
    }

    public double totalConvertido() {
        double total = 0;
        
        // Percorre a listaMoedas e chama a função converter das classes real, euro e dolar
        for(Moeda money : listaMoedas) {
            total += money.converter();
        }

        return total;
    }
}
