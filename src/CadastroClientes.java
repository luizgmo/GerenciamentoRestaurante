import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CadastroClientes extends JFrame implements ActionListener {

    private JLabel labelNome, labelTelefone, labelEndereco;
    private JTextField campoNome, campoTelefone, campoEndereco;
    private JButton botaoSalvar, botaoLimpar;
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();

    public CadastroClientes() {
        setTitle("Cadastro de Clientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 250);
        setLayout(null);
        setResizable(false);
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

        labelTelefone = new JLabel("Telefone:");
        labelTelefone.setBounds(30, 70, 100, 25);
        add(labelTelefone);

        campoTelefone = new JTextField();
        campoTelefone.setBounds(150, 70, 300, 25);
        add(campoTelefone);

        labelEndereco = new JLabel("Endereço:");
        labelEndereco.setBounds(30, 110, 100, 25);
        add(labelEndereco);

        campoEndereco = new JTextField();
        campoEndereco.setBounds(150, 110, 300, 25);
        add(campoEndereco);

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
            salvarCliente();
        } else if (e.getSource() == botaoLimpar) {
            limparCampos();
        }
    }

    private void salvarCliente() {
        String nome = campoNome.getText();
        String telefone = campoTelefone.getText();
        String endereco = campoEndereco.getText();

        if (nome.isEmpty() || telefone.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Cliente cliente = new Cliente(nome, telefone, endereco);
            listaClientes.add(cliente);

            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso:\n"
                    + "Nome: " + nome + "\n"
                    + "Telefone: " + telefone + "\n"
                    + "Endereço: " + endereco, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoTelefone.setText("");
        campoEndereco.setText("");
    }

    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
}
