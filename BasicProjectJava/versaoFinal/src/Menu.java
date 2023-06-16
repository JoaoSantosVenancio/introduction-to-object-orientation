import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    public static void Menu(ArrayList<Funcionario> Listafuncionarios, ArrayList<Cliente> ListaClientes, ArrayList<Produto> ListaProdutos){
        int op = 0;
        do {
        System.out.println("\n");
        System.out.println("              GJ CLOTHES");
        System.out.println("+--------------------------------------+");
        System.out.println("|                 MENU                 |");
        System.out.println("+--------------------------------------+");
        System.out.println(
                "|     Selecione a opção desejada:      |\n" +
                "|                                      |\n" +
                "| (1)- Buscar                          |\n" +
                "| (2)- Cadastrar                       |\n" +
                "| (3)- Excluir                         |\n" +
                "| (4)- Consultar                       |\n" +
                "| (0)- Sair                            |"
        );
        System.out.println("+--------------------------------------+\n\n");

        op = scanner.nextInt();

            if (op == 1) {
                op = 0;
                System.out.println("+--------------------------------------+");
                System.out.println("|                 BUSCA                |");
                System.out.println("+--------------------------------------+");
                System.out.println(
                        "|     Selecione a opção desejada:      |\n" +
                        "|                                      |\n" +
                        "| (1)- Buscar Produtos                 |\n" +
                        "| (2)- Buscar Funcionários             |\n" +
                        "| (3)- Buscar Clientes                 |\n" +
                        "| (4)- Exibir Listas                   |\n" +
                        "| (0)- Sair                            |"
                );
                System.out.println("+--------------------------------------+\n\n");
                op = scanner.nextInt();

                if (op == 1) {
                    op = 0;
                    System.out.println("+--------------------------------------+");
                    System.out.println("|                 BUSCA                |");
                    System.out.println("+--------------------------------------+");
                    System.out.println(
                            "|     Selecione a opção desejada:      |\n" +
                                    "|                                      |\n" +
                                    "| (1)- Buscar Produtos por Descrição   |\n" +
                                    "| (2)- Buscar Produtos por Preço       |\n" +
                                    "| (3)- Buscar Produtos por Código      |\n" +
                                    "| (0)- Sair                            |"
                    );
                    System.out.println("+--------------------------------------+\n\n");
                    op = scanner.nextInt();
                    scanner.nextLine();
                    if (op == 1) {
                        System.out.println("+--------------------------------------+");
                        System.out.println("|     BUSCAR PRODUTO POR DESCRIÇÃO     |");
                        System.out.println("+--------------------------------------+");
                        System.out.println(
                                "|Digite parte da descrição do produto: |"
                        );
                        System.out.println("+--------------------------------------+\n\n");
                        Scanner scanner = new Scanner(System.in);
                        String descricaoProduto = scanner.nextLine();
                        descricaoProduto.toLowerCase();
                        Produto.buscarProdutosPorDescricao(ListaProdutos,descricaoProduto);

                    } else if (op == 2) {
                        System.out.println("+--------------------------------------+");
                        System.out.println("|       BUSCAR PRODUTO POR PREÇO       |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|Digite o valor mínimo do preço:       |");
                        System.out.println("+--------------------------------------+\n\n");
                        double valorMinimo = scanner.nextDouble();
                        System.out.println("+--------------------------------------+");
                        System.out.println("|       BUSCAR PRODUTO POR PREÇO       |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|Digite o valor máximo do preço:       |");
                        System.out.println("+--------------------------------------+\n\n");
                        double valorMaximo = scanner.nextDouble();
                        Produto.buscarProdutosPorPreco(ListaProdutos,valorMinimo, valorMaximo);
                    }
                    else if ( op == 3) {
                    System.out.println("+--------------------------------------+");
                            System.out.println("|       BUSCAR PRODUTO POR CÓDIGO      |");
                            System.out.println("+--------------------------------------+");
                            System.out.println("|Digite o código do produto:           |");
                            System.out.println("+--------------------------------------+\n\n");
                            String codigoProduto = scanner.nextLine();
                            Produto.buscarProdutosPorCodigo(ListaProdutos,codigoProduto);
                    }
                } else if (op == 2) {
                    System.out.println("+--------------------------------------+");
                    System.out.println("|      BUSCAR FUNCIONÁRIO POR CPF      |");
                    System.out.println("+--------------------------------------+");
                    System.out.println("|Digite o CPF do funcionario: |");
                    System.out.println("+--------------------------------------+\n\n");
                    Funcionario.buscaFunc(Listafuncionarios);
                } else if (op == 3) {
                    op = 0;
                    System.out.println("+--------------------------------------+");
                    System.out.println("|                 BUSCA                |");
                    System.out.println("+--------------------------------------+");
                    System.out.println(
                            "|     Selecione a opção desejada:      |\n" +
                                    "|                                      |\n" +
                                    "| (1)- Buscar por CPF                  |\n" +
                                    "| (2)- Buscar parte do nome            |\n" +
                                    "| (0)- Sair                            |"
                    );
                    System.out.println("+--------------------------------------+\n\n");
                    op = scanner.nextInt();
                    if (op == 1){
                        System.out.println("+--------------------------------------+");
                        System.out.println("|     BUSCAR CLIENTE POR CPF           |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|Digite o CPF do cliente:              |");
                        System.out.println("+--------------------------------------+\n\n");
                        Cliente.buscaClientePorCPF(ListaClientes);
                    }
                    else if (op == 2){
                        System.out.println("+--------------------------------------+");
                        System.out.println("|   BUSCAR CLIENTE POR PARTE DO NOME   |");
                        System.out.println("+--------------------------------------+");
                        System.out.println("|Digite parte do nome do cliente:      |");
                        System.out.println("+--------------------------------------+\n\n");
                        Cliente.buscarClientesPorParteNome(ListaClientes);
                    }
                    else if(op == 0)
                        break;
                    else
                        System.out.println("ATENÇÃO! Selecione uma opção válida!");
                } else if (op == 4) {
                    op = 0;
                    System.out.println("+--------------------------------------+");
                    System.out.println("|                LISTAR                |");
                    System.out.println("+--------------------------------------+");
                    System.out.println(
                                       "|     Selecione a opção desejada:      |\n" +
                                       "|                                      |\n" +
                                       "| (1)- Listar Funcionários             |\n" +
                                       "| (2)- Listar Clientes                 |\n" +
                                       "| (3)- Listar Produtos                 |\n" +
                                       "| (0)- Sair                            |");
                    System.out.println("+--------------------------------------+\n\n");
                    op = scanner.nextInt();
                    if(op == 1){
                        Funcionario.ListarFuncionarios(Listafuncionarios);
                    }
                    else if(op == 2){
                        Cliente.ListarClientes(ListaClientes);
                    }
                    else if(op == 3){
                        Produto.ListarProdutos(ListaProdutos);
                    }
                    else if(op == 0)
                        break;

                    else
                        System.out.println("ATENÇÃO! Selecione uma opção válida!");

                } else if(op == 0)
                    break;

                else {
                    System.out.println("ATENÇÃO! Selecione uma opção válida!");
                }
            } else if (op == 2) {
                op = 0;
                System.out.println("+--------------------------------------+");
                System.out.println("|               CADASTRO               |");
                System.out.println("+--------------------------------------+");
                System.out.println(
                        "|     Selecione a opção desejada:      |\n" +
                                "|                                      |\n" +
                                "| (1)- Cadastrar Funcionários          |\n" +
                                "| (2)- Cadastrar Clientes              |\n" +
                                "| (3)- Cadastrar Produtos              |\n" +
                                "| (0)- Sair                            |"
                );
                System.out.println("+--------------------------------------+\n\n");
                op = scanner.nextInt();
                if (op == 1) {
                    Funcionario.addFunc(Listafuncionarios);
                } else if (op == 2) {
                    Cliente.addCliente(ListaClientes);
                } else if (op == 3) {
                    Produto.addProduto(ListaProdutos);
                }else if(op == 0) {
                    break;
                }else {
                    System.out.println("ATENÇÃO! Selecione uma opção válida!");
                }
            }else if (op == 3){
                op = 0;
                System.out.println("+--------------------------------------+");
                System.out.println("|               EXCLUSÃO               |");
                System.out.println("+--------------------------------------+");
                System.out.println(
                        "|     Selecione a opção desejada:      |\n" +
                        "|                                      |\n" +
                        "| (1)- Excluir Funcionário             |\n" +
                        "| (2)- Excluir Cliente                 |\n" +
                        "| (3)- Excluir Produto                 |\n" +
                        "| (0)- Sair                            |"
                );
                System.out.println("+--------------------------------------+\n\n");
                op = scanner.nextInt();
                if (op == 1) {
                    Funcionario.removeFunc(Listafuncionarios);
                } else if (op == 2) {
                    Cliente.removeCliente(ListaClientes);
                } else if (op == 3) {
                    Produto.removeProduto(ListaProdutos);
                }else if(op == 0) {
                    break;
                }else {
                    System.out.println("ATENÇÃO! Selecione uma opção válida!");
                }
            }else if (op == 4) {
                op = 0;
                System.out.println("+--------------------------------------+");
                System.out.println("|                CONSULTAS             |");
                System.out.println("+--------------------------------------+");
                System.out.println(
                        "|     Selecione a opção desejada:      |\n" +
                                "|                                      |\n" +
                                "| (1)- Consultar cliente mais velho    |\n" +
                                "| (2)- Consultar cliente mais jovem    |\n" +
                                "| (3)- Consultar clientes > de 60 anos |\n" +
                                "| (4)- Consultar clientes < de 18 anos |\n" +
                                "| (5)- Consultar idade média clientes  |\n" +
                                "| (6)- Consultar peça mais caro        |\n" +
                                "| (7)- Consultar peça mais barato      |\n" +
                                "| (8)- Consultar média de preço peças  |\n" +
                                "| (9)- Consultar preças preço > média  |\n" +
                                "| (0)- Sair                            |"
                );
                System.out.println("+--------------------------------------+\n\n");
                op = scanner.nextInt();
                switch (op){
                    case 1:
                        Cliente.clienteMaisVelho(ListaClientes);
                        break;
                    case 2:
                        Cliente.clienteMaisJovem(ListaClientes);
                        break;
                    case 3:
                        Cliente.quantidadeClientesMaiores60(ListaClientes);
                        break;
                    case 4:
                        Cliente.quantidadeClientesMenores18(ListaClientes);
                        break;
                    case 5:
                        Cliente.idadeMediaClientes(ListaClientes);
                        break;
                    case 6:
                        Produto.produtoMaisCaro(ListaProdutos);
                        break;
                    case 7:
                        Produto.produtoMaisBarato(ListaProdutos);
                        break;
                    case 8:
                        Produto.precoMedioProdutos(ListaProdutos);
                        break;
                    case 9:
                        Produto.quantidadeProdutosAcimaMedia(ListaProdutos);
                    case 0:
                        break;
                    default:
                        System.out.println("ERRO");
                }
            }else {
                System.out.println("ATENÇÃO! Selecione uma opção válida!");
            }
        }
        while (op != 0);
    }
}
