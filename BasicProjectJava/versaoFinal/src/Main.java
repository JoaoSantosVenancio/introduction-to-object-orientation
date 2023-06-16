import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //FUNCIONÁRIOS

        ArrayList <Funcionario> Listafuncionarios = new ArrayList<>();

        //CLIENTES

        ArrayList <Cliente> ListaClientes = new ArrayList<>();

        //PRODUTO

        ArrayList <Produto> ListaProdutos = new ArrayList<Produto>();
        ArrayList produtosEncontrados = new ArrayList<>();

        //MENU
            Menu.Menu(Listafuncionarios,ListaClientes,ListaProdutos);

    }
}