import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CadastroPratos extends JFrame implements ActionListener {

    private JLabel labelNomePrato, labelPreco, labelCategoria;
    private JTextField campoNomePrato, campoPreco;
    private JComboBox<String> comboCategoria;
    private JButton botaoCadastrar;
    private static ArrayList<Prato> listaPratos = new ArrayList<>();

    public CadastroPratos() {
        setTitle("Cadastro de Pratos");
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
        labelNomePrato = new JLabel("Nome do Prato:");
        labelNomePrato.setBounds(30, 30, 150, 25);
        add(labelNomePrato);

        campoNomePrato = new JTextField();
        campoNomePrato.setBounds(150, 30, 200, 25);
        add(campoNomePrato);

        labelPreco = new JLabel("Preço:");
        labelPreco.setBounds(30, 70, 120, 25);
        add(labelPreco);

        campoPreco = new JTextField();
        campoPreco.setBounds(150, 70, 200, 25);
        add(campoPreco);

        labelCategoria = new JLabel("Categoria:");
        labelCategoria.setBounds(30, 110, 120, 25);
        add(labelCategoria);

        comboCategoria = new JComboBox<>(new String[]{"Selecione a Categoria", "Entrada", "Prato Principal", "Sobremesa"});
        comboCategoria.setBounds(150, 110, 200, 25);
        add(comboCategoria);

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(185, 150, 130, 30);
        add(botaoCadastrar);
    }

    private void configurarEventos() {
        botaoCadastrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoCadastrar) {
            cadastrarPrato();
        }
    }

    private void cadastrarPrato() {
        String nomePrato = campoNomePrato.getText();
        String preco = campoPreco.getText();
        String categoria = (String) comboCategoria.getSelectedItem();

        if (nomePrato.isEmpty() || preco.isEmpty() || categoria.equals("Selecione a Categoria")) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            listaPratos.add(new Prato(nomePrato));
            JOptionPane.showMessageDialog(this, "Prato cadastrado com sucesso:\n"
                    + "Nome: " + nomePrato + "\n"
                    + "Preço: " + preco + "\n"
                    + "Categoria: " + categoria, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        }
    }

    private void limparCampos() {
        campoNomePrato.setText("");
        campoPreco.setText("");
        comboCategoria.setSelectedIndex(0);
    }

    public static ArrayList<Prato> getListaPratos() {
        return listaPratos;
    }
}
