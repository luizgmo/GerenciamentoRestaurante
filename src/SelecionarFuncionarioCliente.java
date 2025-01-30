import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelecionarFuncionarioCliente extends JFrame implements ActionListener {

    private JComboBox<String> comboFuncionarios, comboClientes;
    private JButton botaoSelecionar;
    private ArrayList<Funcionario> listaFuncionarios;
    private ArrayList<Cliente> listaClientes;

    public SelecionarFuncionarioCliente(ArrayList<Funcionario> listaFuncionarios, ArrayList<Cliente> listaClientes) {
        this.listaFuncionarios = listaFuncionarios;
        this.listaClientes = listaClientes;

        setTitle("Selecionar Funcionário e Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        inicializarComponentes();
        configurarEventos();

        setVisible(true);
    }

    private void inicializarComponentes() {
        JLabel labelFuncionario = new JLabel("Funcionário:");
        labelFuncionario.setBounds(30, 30, 100, 25);
        add(labelFuncionario);

        comboFuncionarios = new JComboBox<>();
        preencherComboFuncionarios();
        comboFuncionarios.setBounds(150, 30, 200, 25);
        add(comboFuncionarios);

        JLabel labelCliente = new JLabel("Cliente:");
        labelCliente.setBounds(30, 70, 100, 25);
        add(labelCliente);

        comboClientes = new JComboBox<>();
        preencherComboClientes();
        comboClientes.setBounds(150, 70, 200, 25);
        add(comboClientes);

        botaoSelecionar = new JButton("Selecionar");
        botaoSelecionar.setBounds(150, 120, 100, 30);
        add(botaoSelecionar);
    }

    private void configurarEventos() {
        botaoSelecionar.addActionListener(this);
    }

    private void preencherComboFuncionarios() {
        comboFuncionarios.addItem("Selecione um Funcionário");
        for (Funcionario funcionario : listaFuncionarios) {
            comboFuncionarios.addItem(funcionario.getNome());
        }
    }

    private void preencherComboClientes() {
        comboClientes.addItem("Selecione um Cliente");
        for (Cliente cliente : listaClientes) {
            comboClientes.addItem(cliente.getNome());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoSelecionar) {
            String nomeFuncionario = (String) comboFuncionarios.getSelectedItem();
            String nomeCliente = (String) comboClientes.getSelectedItem();

            if (nomeFuncionario.equals("Selecione um Funcionário") || nomeCliente.equals("Selecione um Cliente")) {
                JOptionPane.showMessageDialog(this, "Por favor, selecione um funcionário e um cliente válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                NovoPedido novoPedido = new NovoPedido(nomeCliente);
                novoPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dispose();
            }
        }
    }
}
