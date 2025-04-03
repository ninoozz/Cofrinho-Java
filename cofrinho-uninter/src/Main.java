import cofrinho.Cofrinho;
import moeda.Dolar;
import moeda.Euro;
import moeda.Real;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Criei a classe Cofrinho como Singleton seguindo exemplos dos módulos
        final Cofrinho cofrinho = Cofrinho.getInstancia();

        Scanner teclado = new Scanner(System.in);

        //Utilizo um loop para fazer controle das informações exibidas no terminal
        while (true){
            //implementação de try/catch para previnir Exceptions do tipo InputMismatchException
            try {
                System.out.println("OPÇÕES DO COFRINHO\n");
                System.out.println("Escolha uma opção baseado no número:\n");
                System.out.println("1 - Adicionar um valor de moeda");
                System.out.println("2 - Remover um valor de moeda");
                System.out.println("3 - Listar moedas do cofrinho");
                System.out.println("4 - Exibir total em Real");
                System.out.println("0 - Encerrar");
                int opcao = teclado.nextInt();

                //Ao invés de utilizar switch/case para verificar a opção do menu,
                //utilizei if/else por ter uma grande quantidade de código, e utilizei
                //switch case dentro dos if's
                if (opcao == 1) {
                    System.out.println("Escolha uma moeda:");
                    System.out.println("1 - Real");
                    System.out.println("2 - Dolar");
                    System.out.println("3 - Euro");
                    System.out.println("0 - Cancelar");
                    opcao = teclado.nextInt();

                    if (opcao == 0) continue;

                    System.out.println("Digite um valor a adicionar: ");
                    double valor = teclado.nextDouble();

                    if (valor == 0) {
                        System.out.println("Valor inválido!\n");
                        continue;
                        //Valor sendo inválido retorno às opções do menu
                    }

                    //Executando função adicionar baseado no input do usuário
                    switch (opcao) {
                        case 1 -> {
                            cofrinho.adicionar(new Real(valor));
                        }
                        case 2 -> {
                            cofrinho.adicionar(new Dolar(valor));
                        }
                        case 3 -> {
                            cofrinho.adicionar(new Euro(valor));
                        }
                        default -> System.out.println("Valor inválido\n");

                    }
                } else if (opcao == 2) {
                    //Basicamente é a mesma lógica que a usada para adicionar no bloco
                    //de if acima.
                    //Embora as funções funcionem de forma muito diferente,
                    //os detalhes de sua implementação ficam na classe Cofrinho.
                    System.out.println("Escolha uma moeda:");
                    System.out.println("1 - Real");
                    System.out.println("2 - Dolar");
                    System.out.println("3 - Euro");
                    System.out.println("0 - Cancelar");
                    opcao = teclado.nextInt();

                    if (opcao == 0) continue;

                    System.out.println("Digite um valor a remover: ");
                    double valor = teclado.nextDouble();

                    if (valor == 0) {
                        System.out.println("Valor inválido!\n");
                        continue;
                    }

                    switch (opcao) {
                        case 1 -> {
                            cofrinho.remover(new Real(valor));
                        }
                        case 2 -> {
                            cofrinho.remover(new Dolar(valor));
                        }
                        case 3 -> {
                            cofrinho.remover(new Euro(valor));
                        }
                        default -> System.out.println("Valor inválido!\n");

                    }

                } else if (opcao == 3) {
                    //Ao invés de retornar a lista com objetos da Classe Moeda para
                    //fazer a listagem e implementar a lógica aqui, preferi
                    //manter a centralização dos dados, deixando-os na instância única
                    //de Cofrinho e recupero apenas os valores já formatados em String
                    //prontos para serem exibidos no terminal.
                    //Os detalhes da lógica ficam na classe Cofrinho.
                    ArrayList<String> listaMoedas = cofrinho.listagemMoedas();
                    for (String moedaNoCofre : listaMoedas) {
                        System.out.println(moedaNoCofre);
                    }
                    System.out.println("\n");

                } else if (opcao == 4) {

                    System.out.println("TOTAL : R$" + cofrinho.totalConvertido() + "\n");

                } else if (opcao == 0) {
                    //Encerrando o laço caso a opção escolhida seja 0
                    break;
                } else {
                    System.out.println("Valor inválido");
                    continue;
                }
            }catch (InputMismatchException e){
                //Para tentar deixar este tipo de exception mais clara para o usuário,
                //usei o catch para coletá-la e exibir umas mensagem.
                System.out.println("\nVocê digitou um valor inválido!\n");
                System.out.println("Erro: digite valores numéricos inteiros ou com \"," +
                        "\" para valores decimais\n");
                break;
            }
        }
    }
}