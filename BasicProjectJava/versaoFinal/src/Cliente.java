import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Pessoa implements IPessoa{

    private static int contClientes = 0;
    private int maiorIdade = 0;
    private int maiores60 = 0;
    private int menores18 = 0;
    private int somaIdades = 0;
    private int menorIdade = 120;

    public Cliente() {
        contClientes++;
    }

    public Cliente(String nome, int idade, double cep, String email, String cpf) {
        super(nome, idade, cep, email, cpf);
        contClientes++;
    }

    @Override
    public void ExibirDados() {
        System.out.println("-----------");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CEP: " + cep);
        System.out.println("E-mail: " + email);
        System.out.println("CPF: " + cpf);
        System.out.println("-----------");
    }

    public static void buscarClientesPorParteNome(ArrayList<Cliente> ListaClientes) {
        Scanner scanner = new Scanner(System.in);
        String parteDoNome = scanner.nextLine();
        parteDoNome.toLowerCase();
        for (Cliente cliente : ListaClientes) {
            String nomeCliente = cliente.getNome().toLowerCase();

            if(nomeCliente.contains(parteDoNome)){
                cliente.ExibirDados();
            }
        }
    }


    public static void buscaClientePorCPF(ArrayList<Cliente> ListaClientes){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        for(Cliente cliente: ListaClientes){
            if(cliente.getCpf().equalsIgnoreCase(cpf)){
                cliente.ExibirDados();
            }
            else{
                System.out.println("Cliente não encontrado! Não foi possível exibir os resultados para a busca.");
            }
        }
    }
    public static void addCliente(ArrayList<Cliente> ListaClientes) {
        String nome = null,email = null, cpf = null;
        int idade = 0;
        double cep = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite o nome do cliente: ");
            nome = scanner.nextLine();
            System.out.println("Digite o e-mail do cliente: ");
            email = scanner.nextLine();
            System.out.println("Digite a idade do cliente: ");
            idade = scanner.nextInt();
            System.out.println("Digite o CEP do cliente: ");
            cep = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Digite o CPF do cliente: ");
            cpf = scanner.nextLine();

            Cliente clienteNovo = new Cliente(nome,idade,cep,email,cpf);
            ListaClientes.add(clienteNovo);

        } catch (DescricaoNulaException e) {
            System.out.println(e.getMessage());
        } catch (PrecoNuloException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n");
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public static void ListarClientes(ArrayList<Cliente> ListaClientes){
        for(Cliente cliente:ListaClientes){
            System.out.println("----");
            cliente.ExibirDados();
            System.out.println("----");
        }
    }
    public static void removeCliente (ArrayList<Cliente> ListaClientes) {
        System.out.println("Digite o CPF do cliente que deseja excluir:");
        Scanner scanner = new Scanner(System.in);
        String cpfCli = scanner.nextLine();
        cpfCli.toLowerCase();

        if (ListaClientes.size() == 0) {
            System.out.println("Não há clientes para serem removidos!");
            System.exit(10);
        }
            if (ListaClientes.size() == 0) {
                System.out.println("Não há clientes para serem removidos!");
                System.exit(10);

                for (Cliente cliente : ListaClientes) {

                    if (cliente.getCpf().equals(cpfCli)) {
                        System.out.println("Dados do cliente que será removido: ");
                        cliente.ExibirDados();
                        System.out.println("Insira a opção desejada:" + "\n" + "(SIM) Remover" + "\n" + "(NÃO) Cancelar" + "\n");
                        String resposta = scanner.nextLine();

                        do {
                            if (resposta.equalsIgnoreCase("sim")) {
                                ListaClientes.remove(cliente);
                                System.out.println("Cliente: " + cliente.getNome() + " removido com sucesso!");
                                contClientes--;
                                break;
                            } else if (resposta.equalsIgnoreCase("Nao")) {
                                System.out.println("O cliente não foi removido.");
                                break;
                            } else {
                                System.out.println("ERRO! Opção inválida." + "\n");
                                break;
                            }

                        }
                        while (!(resposta.equalsIgnoreCase("sim")) || !(resposta.equalsIgnoreCase("nao")));
                    }
                }
            }
        }

    public static void clienteMaisVelho(ArrayList<Cliente> ListaClientes) {
        if (ListaClientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            Cliente maisVelho = ListaClientes.get(0);
            for (Cliente cliente : ListaClientes) {
                if (cliente.idade > maisVelho.idade) {
                    maisVelho = cliente;
                }
            }
            System.out.println("Cliente mais velho:");
            maisVelho.ExibirDados();
        }
    }

    public static void clienteMaisJovem(ArrayList<Cliente> ListaClientes) {
        if (ListaClientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            Cliente maisJovem = ListaClientes.get(0);
            for (Cliente cliente : ListaClientes) {
                if (cliente.idade < maisJovem.idade) {
                    maisJovem = cliente;
                }
            }
            System.out.println("Cliente mais jovem:");
            maisJovem.ExibirDados();
        }
    }

    public static void quantidadeClientesMaiores60(ArrayList<Cliente> ListaClientes) {
        int quantidade = 0;
        for (Cliente cliente : ListaClientes) {
            if (cliente.idade > 60) {
                quantidade++;
            }
        }
        System.out.println("Quantidade de clientes maiores de 60 anos: " + quantidade);
    }

    public static void quantidadeClientesMenores18(ArrayList<Cliente> ListaClientes) {
        int quantidade = 0;
        for (Cliente cliente : ListaClientes) {
            if (cliente.idade < 18) {
                quantidade++;
            }
        }
        System.out.println("Quantidade de clientes menores de 18 anos: " + quantidade);
    }

    public static void idadeMediaClientes(ArrayList <Cliente> ListaClientes) {
        if (ListaClientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            int totalIdade = 0;
            for (Cliente cliente : ListaClientes) {
                totalIdade += cliente.idade;
            }
            double media = (double) totalIdade / ListaClientes.size();
            System.out.println("Idade média dos clientes: " + media);
        }
    }

}
