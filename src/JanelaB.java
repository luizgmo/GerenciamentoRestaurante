import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

public class JanelaB extends JFrame implements ActionListener, KeyListener {

    private JMenuBar jMenuBarPrincipal;
    private JMenu jMenuCadastro, jMenuPedidos;
    private JMenuItem jMenuItemCadastroPratos, jMenuItemCadastroClientes, jMenuItemCadastroFuncionarios;
    private JMenuItem jMenuItemNovoPedido, jMenuItemHistoricoPedidos;

    private Image fundoImagem;
    private JPanel painelFundo;

    public JanelaB() {
        setTitle("Sistema de Gerenciamento do Restaurante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(960, 540);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        inicializarComponentes();
        carregarImagemFundo();
        configurarMenu();

        addKeyListener(this);
        setVisible(true);
    }

    private void inicializarComponentes() {
        painelFundo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (fundoImagem != null) {
                    g.drawImage(fundoImagem, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        painelFundo.setBounds(0, 25, 960, 515);
        add(painelFundo);
    }

    private void carregarImagemFundo() {
        try {
            URL urlImagem = new URL("https://wallpapers.com/images/hd/restaurant-in-conrad-koh-samui-thailand-vv0zzvvrhgo6wvj0.jpg");
            fundoImagem = new ImageIcon(urlImagem).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void configurarMenu() {
        jMenuBarPrincipal = new JMenuBar();
        jMenuBarPrincipal.setBounds(0, 0, 960, 25);
        add(jMenuBarPrincipal);

        jMenuCadastro = new JMenu("Cadastro");
        jMenuPedidos = new JMenu("Pedidos");
        jMenuBarPrincipal.add(jMenuCadastro);
        jMenuBarPrincipal.add(jMenuPedidos);

        jMenuItemCadastroPratos = new JMenuItem("Pratos");
        jMenuItemCadastroClientes = new JMenuItem("Clientes");
        jMenuItemCadastroFuncionarios = new JMenuItem("Funcionários");
        jMenuItemNovoPedido = new JMenuItem("Novo Pedido");
        jMenuItemHistoricoPedidos = new JMenuItem("Histórico de Pedidos");

        jMenuItemCadastroPratos.addActionListener(this);
        jMenuItemCadastroClientes.addActionListener(this);
        jMenuItemCadastroFuncionarios.addActionListener(this);
        jMenuItemNovoPedido.addActionListener(this);
        jMenuItemHistoricoPedidos.addActionListener(this);

        jMenuCadastro.add(jMenuItemCadastroPratos);
        jMenuCadastro.add(jMenuItemCadastroClientes);
        jMenuCadastro.add(jMenuItemCadastroFuncionarios);
        jMenuPedidos.add(jMenuItemNovoPedido);
        jMenuPedidos.add(jMenuItemHistoricoPedidos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("Pratos")) {
            CadastroPratos janela = new CadastroPratos();
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (comando.equals("Clientes")) {
            CadastroClientes janela = new CadastroClientes();
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (comando.equals("Funcionários")) {
            CadastroFuncionarios janela = new CadastroFuncionarios();
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (comando.equals("Novo Pedido")) {
            ArrayList<Funcionario> listaFuncionarios = CadastroFuncionarios.getListaFuncionarios();
            ArrayList<Cliente> listaClientes = CadastroClientes.getListaClientes();
            SelecionarFuncionarioCliente selecionarFuncionarioCliente = new SelecionarFuncionarioCliente(listaFuncionarios, listaClientes);
            selecionarFuncionarioCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else if (comando.equals("Histórico de Pedidos")) {
            HistoricoPedidos janela = new HistoricoPedidos();
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
