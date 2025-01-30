import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CadastroFuncionarios extends JFrame implements ActionListener {

    private JLabel labelNome, labelCargo, labelSalario;
    private JTextField campoNome, campoSalario;
    private JComboBox<String> comboCargo;
    private JButton botaoSalvar, botaoLimpar;
    private static ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

    public CadastroFuncionarios() {
        setTitle("Cadastro de Funcionários");
        setSize(500, 250);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        inicializarComponentes();
        configurarEventos();

        setVisible(true);
    }

    private void inicializarComponentes() {
        labelNome = new JLabel("Nome:");
        labelNome.setBounds(30, 30, 100, 25);
        add(labelNome);

        campoNome = new JTextField();
        campoNome.setBounds(150, 30, 300, 25);
        add(campoNome);

        labelCargo = new JLabel("Cargo:");
        labelCargo.setBounds(30, 70, 100, 25);
        add(labelCargo);

        String[] cargos = {"Selecione o Cargo", "Gerente", "Cozinheiro", "Garçom", "Atendente", "Caixa"};
        comboCargo = new JComboBox<>(cargos);
        comboCargo.setBounds(150, 70, 300, 25);
        add(comboCargo);

        labelSalario = new JLabel("Salário:");
        labelSalario.setBounds(30, 110, 100, 25);
        add(labelSalario);

        campoSalario = new JTextField();
        campoSalario.setBounds(150, 110, 300, 25);
        add(campoSalario);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(190, 150, 100, 30);
        add(botaoSalvar);

        botaoLimpar = new JButton("Limpar");
        botaoLimpar.setBounds(300, 150, 100, 30);
        add(botaoLimpar);
    }

    private void configurarEventos() {
        botaoSalvar.addActionListener(this);
        botaoLimpar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoSalvar) {
            salvarFuncionario();
        } else if (e.getSource() == botaoLimpar) {
            limparCampos();
        }
    }

    private void salvarFuncionario() {
        String nome = campoNome.getText();
        String cargo = (String) comboCargo.getSelectedItem();
        String salario = campoSalario.getText();

        if (nome.isEmpty() || cargo.equals("Selecione o Cargo") || salario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Funcionario funcionario = new Funcionario(nome, cargo, salario);
            listaFuncionarios.add(funcionario);

            JOptionPane.showMessageDialog(this, "Funcionário salvo com sucesso:\n"
                    + "Nome: " + nome + "\n"
                    + "Cargo: " + cargo + "\n"
                    + "Salário: " + salario, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        comboCargo.setSelectedIndex(0);
        campoSalario.setText("");
    }

    public static ArrayList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }
}
