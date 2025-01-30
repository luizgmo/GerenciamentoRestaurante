import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class HistoricoPedidos extends JFrame {

    private JTable tabelaPedidos;
    private JScrollPane scrollPane;
    private DefaultTableModel model;

    public HistoricoPedidos() {
        setTitle("Histórico de Pedidos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 400);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        inicializarComponentes();
        preencherTabela();
        ajustarLargurasColunas();

        setVisible(true);
    }

    private void inicializarComponentes() {
        model = new DefaultTableModel();
        model.addColumn("Prato");
        model.addColumn("Quantidade");
        model.addColumn("Observação");
        model.addColumn("Tipo de Pedido");
        model.addColumn("Cliente");

        tabelaPedidos = new JTable(model);
        scrollPane = new JScrollPane(tabelaPedidos);
        scrollPane.setBounds(30, 30, 630, 300);
        add(scrollPane);
    }

    private void preencherTabela() {
        ArrayList<Pedido> listaPedidos = NovoPedido.getListaPedidos();
        for (Pedido pedido : listaPedidos) {
            String prato = pedido.getPrato();
            int quantidade = pedido.getQuantidade();
            String observacao = pedido.getObservacao();
            String tipoPedido = pedido.getTipoPedido();
            String nomeCliente = pedido.getNomeCliente();

            model.addRow(new Object[]{prato, quantidade, observacao, tipoPedido, nomeCliente});
        }
    }

    private void ajustarLargurasColunas() {
        tabelaPedidos.getColumnModel().getColumn(0).setPreferredWidth(125);
        tabelaPedidos.getColumnModel().getColumn(1).setPreferredWidth(75);
        tabelaPedidos.getColumnModel().getColumn(2).setPreferredWidth(175);
        tabelaPedidos.getColumnModel().getColumn(3).setPreferredWidth(125);
        tabelaPedidos.getColumnModel().getColumn(4).setPreferredWidth(125);
    }
}
