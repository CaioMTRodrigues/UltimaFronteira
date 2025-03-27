package models.Itens;

public class ItemRemedios extends Item {

    private String tipo;
    private String efeito;

    // Construtor que inicializa os dados do item Remédio
    public ItemRemedios(String nome, double peso, int durabilidade, String tipo, String efeito) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.efeito = efeito;
    }

    // Métodos de Acesso
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getEfeito() { return efeito; }
    public void setEfeito(String efeito) { this.efeito = efeito; }

    // Método sobrescrito para usar o item Remédio
    @Override
    public void usar() {
        System.out.println("💊 Você usou " + getNome() + ". Efeito: " + efeito);
        reduzirDurabilidade();
    }
}



