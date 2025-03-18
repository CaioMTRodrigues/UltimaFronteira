package models.Itens;
public class ItemRemedios extends Item{
    private String tipo; 
    private String efeito; 

    public ItemRemedios(String nome, double peso, int durabilidade, String tipo, String efeito) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.efeito = efeito;
    }

    @Override
    public void usar() {
        System.out.println("💊 Você usou " + nome + ". Efeito: " + efeito);
        reduzirDurabilidade();
    }

}
