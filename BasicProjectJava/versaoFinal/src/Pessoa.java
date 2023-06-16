public abstract class Pessoa {

    protected String nome;
    protected int idade;
    protected double cep;
    protected String email;
    protected String cpf;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, double cep, String email, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cep = cep;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getCep() {
        return cep;
    }

    public void setCep(double cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
