import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NovoPedido extends JFrame implements ActionListener {

    private JLabel labelPrato, labelQuantidade, labelObservacao;
    private JComboBox<String> comboPratos;
    private JSpinner spinnerQuantidade;
    private JTextArea txtObservacao;
    private JCheckBox checkboxEntrega, checkboxComerNoLocal;
    private JButton botaoSalvar;
    private static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private String nomeCliente;

    public NovoPedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;

        setTitle("Novo Pedido");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 350);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        inicializarComponentes();
        configurarEventos();

        setVisible(true);
    }

    private void inicializarComponentes() {
        labelPrato = new JLabel("Prato:");
        labelPrato.setBounds(30, 30, 100, 25);
        add(labelPrato);

        comboPratos = new JComboBox<>();
        preencherComboPratos();
        comboPratos.setBounds(150, 30, 200, 25);
        add(comboPratos);

        labelQuantidade = new JLabel("Quantidade:");
        labelQuantidade.setBounds(30, 70, 100, 25);
        add(labelQuantidade);

        SpinnerModel model = new SpinnerNumberModel(1, 1, 100, 1);
        spinnerQuantidade = new JSpinner(model);
        spinnerQuantidade.setBounds(150, 70, 60, 25);
        add(spinnerQuantidade);

        labelObservacao = new JLabel("Observações:");
        labelObservacao.setBounds(30, 110, 100, 25);
        add(labelObservacao);

        txtObservacao = new JTextArea();
        txtObservacao.setLineWrap(true);
        txtObservacao.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtObservacao);
        scrollPane.setBounds(150, 110, 200, 50);
        add(scrollPane);

        checkboxEntrega = new JCheckBox("Entrega");
        checkboxEntrega.setBounds(150, 180, 100, 25);
        add(checkboxEntrega);

        checkboxComerNoLocal = new JCheckBox("Comer no local");
        checkboxComerNoLocal.setBounds(250, 180, 150, 25);
        add(checkboxComerNoLocal);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(150, 230, 100, 30);
        add(botaoSalvar);
    }

    private void configurarEventos() {
        botaoSalvar.addActionListener(this);
    }

    private void preencherComboPratos() {
        comboPratos.addItem("Selecione um Prato");

        ArrayList<Prato> listaPratos = CadastroPratos.getListaPratos();
        for (Prato prato : listaPratos) {
            comboPratos.addItem(prato.getNome());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoSalvar) {
            String prato = (String) comboPratos.getSelectedItem();
            int quantidade = (int) spinnerQuantidade.getValue();
            String observacao = txtObservacao.getText();
            String tipoPedido = "";

            if (prato.equals("Selecione um Prato")) {
                JOptionPane.showMessageDialog(this, "Por favor, selecione um prato válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (checkboxEntrega.isSelected()) {
                tipoPedido = "Entrega";
            } else if (checkboxComerNoLocal.isSelected()) {
                tipoPedido = "Comer no local";
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecione o tipo de pedido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            listaPedidos.add(new Pedido(prato, quantidade, observacao, tipoPedido, nomeCliente));

            JOptionPane.showMessageDialog(this, "Pedido salvo com sucesso:\n"
                    + "Prato: " + prato + "\n"
                    + "Quantidade: " + quantidade + "\n"
                    + "Observação: " + observacao + "\n"
                    + "Tipo de Pedido: " + tipoPedido + "\n"
                    + "Cliente: " + nomeCliente, "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            limparCampos();
        }
    }

    private void limparCampos() {
        comboPratos.setSelectedIndex(0);
        spinnerQuantidade.setValue(1);
        txtObservacao.setText("");
        checkboxEntrega.setSelected(false);
        checkboxComerNoLocal.setSelected(false);
    }

    public static ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }
}