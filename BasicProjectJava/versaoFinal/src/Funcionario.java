import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Pessoa implements IPessoa{

    protected String cargo;

    public Funcionario() {
    }

    public Funcionario(String nome, int idade, double cep, String email, String cpf, String cargo) {
        super(nome, idade, cep, email, cpf);
        this.cargo = cargo;
    }

    @Override
    public void ExibirDados() {
        System.out.println("-----------");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CEP: " + cep);
        System.out.println("E-mail: " + email);
        System.out.println("CPF: " + cpf);
        System.out.println("Cargo: " + cargo);
        System.out.println("-----------");
    }

    public static void buscaFunc(ArrayList<Funcionario> Listafuncionarios){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o cpf do funcionario: ");

        String Buscacpf = scanner.nextLine();
        Buscacpf.toLowerCase();

        for(Funcionario funcionario: Listafuncionarios){
            if(funcionario.getCpf().equals(Buscacpf))
                funcionario.ExibirDados();
        }
    }
    public static void removeFunc(ArrayList<Funcionario> Listafuncionarios) {
        System.out.println("Digite o CPF do funcionário que deseja excluir:");
        Scanner scanner = new Scanner(System.in);
        String cpfFunc = scanner.nextLine();
        cpfFunc.toLowerCase();
        int temp = 0;
        if (Listafuncionarios.size() == 0) {
            System.out.println("Não há funcionários para serem removidos!");
            System.exit(10);
        }
        else{
            for (Funcionario funcionario : Listafuncionarios) {

                if (funcionario.getCpf().equals(cpfFunc)) {
                    System.out.println("Dados do funcionário que será removido: ");
                    funcionario.ExibirDados();
                    System.out.println("Insira a opção desejada:" + "\n" + "(SIM) Remover" + "\n" + "(NÃO) Cancelar" + "\n");
                    String resposta = scanner.nextLine();

                    do {
                        if (resposta.equalsIgnoreCase("sim")) {
                            Listafuncionarios.remove(funcionario);
                            System.out.println("Funcionário: " + funcionario.getNome() + " removido com sucesso!");
                            temp = 1;
                            break;
                        } else if (resposta.equalsIgnoreCase("Nao")) {
                            System.out.println("O funcionário não foi removido.");
                            break;
                        } else {
                            System.out.println("ERRO! Opção inválida." + "\n");
                            break;
                        }

                    }
                    while (!(resposta.equalsIgnoreCase("SIM")) || !(resposta.equalsIgnoreCase("nao")));
                }
                if(temp == 1)
                    break;
            }
        }
    }
    public static void ListarFuncionarios(ArrayList <Funcionario> ListaFuncionarios){
        for(Funcionario funcionario : ListaFuncionarios){
            System.out.println("-----");
            funcionario.ExibirDados();
            System.out.println("-----");
        }
    }
    public static void addFunc(ArrayList<Funcionario> Listafuncionarios){
        String nome = null,email = null, cpf = null,cargo = null;
        int idade = 0;
        int cep = 0;

        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Digite o nome do funcionario: ");
            nome = scanner.nextLine();
            System.out.println("Digite o email do funcionario: ");
            email = scanner.nextLine();
            System.out.println("Digite a idade do funcionario: ");
            idade = scanner.nextInt();
            System.out.println("Digite o CEP do funcionario: ");
            cep = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite o CPF do funcionario: ");
            cpf = scanner.nextLine();
            System.out.println("Digite o cargo do funcionario: ");
            cargo = scanner.nextLine();

            Funcionario funcionarioNovo = new Funcionario(nome,idade,cep,email,cpf,cargo);
            Listafuncionarios.add(funcionarioNovo);}
        catch (NomeNuloException e){
            System.out.println(e.getMessage());
        }
        catch (IdadeNulaException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n");
        System.out.println("Funcionário cadastrado com sucesso!");
    }
}
