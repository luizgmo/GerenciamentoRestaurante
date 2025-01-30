public class Pedido {

    private String prato;
    private int quantidade;
    private String observacao;
    private String tipoPedido;
    private String nomeCliente;

    public Pedido(String prato, int quantidade, String observacao, String tipoPedido, String nomeCliente) {
        this.prato = prato;
        this.quantidade = quantidade;
        this.observacao = observacao;
        this.tipoPedido = tipoPedido;
        this.nomeCliente = nomeCliente;
    }

    public String getPrato() {
        return prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
}
