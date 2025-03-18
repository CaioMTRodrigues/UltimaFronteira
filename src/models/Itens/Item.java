package models.Itens;

public abstract class Item {
    protected String nome; 
    protected double peso;
    protected int durabilidade; 
    
        public Item(String nome, double peso, int durabilidade) {
            this.nome = nome;
            this.peso = peso;
            this.durabilidade = durabilidade;
        }
    
        public String getNome() {
            return nome;
        }
    
        public double getPeso() {
            return peso;
        }
    
        public int getDurabilidade() {
            return durabilidade;
        }
    
        public void reduzirDurabilidade() {
            if (durabilidade > 0) {
                durabilidade--;
                System.out.println(nome + " agora tem durabilidade: " + durabilidade);
            } else {
                System.out.println(nome + " está quebrado e não pode ser usado.");
            }
        }
    
        public abstract void usar();
}
