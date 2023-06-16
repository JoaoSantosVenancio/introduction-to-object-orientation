import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Produto {
    private String tipo;
    private String codigo;
    private String descricao;
    private double preco;
    private String tamanho;
    private String cor;

    public Produto(String tipo, String codigo, String descricao, double preco, String tamanho, String cor) {
    this.tipo = tipo;
    this.codigo = codigo;
    this.descricao = descricao;
    this.preco = preco;
    this.tamanho = tamanho;
    this.cor = cor;
    }

    public void exibirDados() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Código: " + codigo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Tamanho: " + tamanho);
        System.out.println("Cor: " + cor);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Produto() {

    }

    public static void addProduto(ArrayList<Produto> ListaProdutos) {
        String tipo = null, descricao = null, tamanho = null, cor = null,codigo = null;
        double preco = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Insira o tipo do produto: ");
            tipo = scanner.nextLine();
            System.out.println("Insira o código do produto: ");
            codigo = scanner.nextLine();
            System.out.println("Insira a descrição do produto: ");
            descricao = scanner.nextLine();
            System.out.println("Insira o preço do produto: ");
            preco = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Insira o tamanho do produto: ");
            tamanho = scanner.nextLine();
            System.out.println("Insira a cor do produto: ");
            cor = scanner.nextLine();

            Produto produtoNovo = new Produto(tipo, codigo, descricao, preco, tamanho, cor);
            ListaProdutos.add(produtoNovo);
        } catch (DescricaoNulaException e) {
            System.out.println(e.getMessage());
        } catch (PrecoNuloException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n");
        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void removeProduto(ArrayList<Produto> ListaProdutos) {
        System.out.println("Digite o código do produto que deseja excluir:");
        Scanner scanner = new Scanner(System.in);
        String codigoProduto = scanner.nextLine();
        codigoProduto.toLowerCase();

        if(ListaProdutos.size() == 0) {
            System.out.println("Não há produtos para serem removidos!");
            System.exit(10);
        }
            for (Produto produto : ListaProdutos) {

                if (produto.getCodigo().equals(codigoProduto)) {
                    System.out.println("Dados do produto que será removido: ");
                    produto.exibirDados();
                    System.out.println("Insira a opção desejada:" + "\n" + "(SIM) Remover" + "\n" + "(NÃO) Cancelar" + "\n");
                    String resposta = scanner.nextLine();

                    do {
                        if (resposta.equalsIgnoreCase("sim")) {
                            ListaProdutos.remove(produto);
                            System.out.println("Produto: " + produto.getCodigo() + " removido com sucesso!");
                            break;
                        } else if (resposta.equalsIgnoreCase("Nao")) {
                            System.out.println("O produto não foi removido.");
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
    public static void buscarProdutosPorPreco(ArrayList <Produto> ListaProdutos,double valorMinimo, double valorMaximo) {
        for(Produto produto:ListaProdutos){
            if((produto.getPreco() >= valorMinimo) || (produto.getPreco()<=valorMaximo)){
                produto.exibirDados();
                System.out.println("---");
            }
        }
    }

    public static void ListarProdutos(ArrayList <Produto> ListaProdutos){
        for(Produto produto: ListaProdutos){
            System.out.println("----");
            produto.exibirDados();
            System.out.println("----");
        }
    }
    public static void buscarProdutosPorCodigo(ArrayList<Produto> ListaProdutos,String codigoProduto) {
        for(Produto produto: ListaProdutos){
            if(produto.getCodigo().equals(codigoProduto)){
                produto.exibirDados();
            }
        }
    }

    public static void buscarProdutosPorDescricao(ArrayList <Produto> ListaProdutos, String descricaoProduto){
        for (Produto i : ListaProdutos) {
            String descricaoProdutoArray = i.getDescricao().toLowerCase();

            if (descricaoProdutoArray.contains(descricaoProduto)) {
                i.exibirDados();
            }
        }
    }
    public static void produtoMaisCaro(ArrayList <Produto> ListaProdutos) {
        if (ListaProdutos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            Produto maisCaro = ListaProdutos.get(0);
            for (Produto produto : ListaProdutos) {
                if (produto.preco > maisCaro.preco) {
                    maisCaro = produto;
                }
            }
            System.out.println("Produto mais caro:");
            maisCaro.exibirDados();
        }
    }

    public static void produtoMaisBarato(ArrayList <Produto> ListaProdutos) {
        if (ListaProdutos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            Produto maisBarato = ListaProdutos.get(0);
            for (Produto produto : ListaProdutos) {
                if (produto.preco < maisBarato.preco) {
                    maisBarato = produto;
                }
            }
            System.out.println("Produto mais barato:");
            maisBarato.exibirDados();
        }
    }

    public static void precoMedioProdutos(ArrayList <Produto> ListaProdutos) {
        if (ListaProdutos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            double totalPreco = 0;
            for (Produto produto : ListaProdutos) {
                totalPreco += produto.preco;
            }
            double media = totalPreco / ListaProdutos.size();
            System.out.println("Preço médio dos produtos: " + media);
        }
    }

    public static void quantidadeProdutosAcimaMedia(ArrayList <Produto> ListaProdutos) {
        if (ListaProdutos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            double media = 0;
            for (Produto produto : ListaProdutos) {
                media += produto.preco;
            }
            media /= ListaProdutos.size();

            int quantidade = 0;
            for (Produto produto : ListaProdutos) {
                if (produto.preco > media) {
                    quantidade++;
                }
            }
            System.out.println("Quantidade de produtos com preço acima da média: " + quantidade);
        }
    }

}

