public class Funcionario {
    private String nome;
    private String cargo;
    private String salario;

    public Funcionario(String nome, String cargo, String salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getSalario() {
        return salario;
    }
}