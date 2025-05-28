package models.Personagens;

import models.Itens.Inventario;
import models.exceptions.MortePorFomeOuSedeException;

/**
 * Classe abstrata base para todos os personagens do jogo.
 * Define os atributos e comportamentos genéricos de qualquer personagem.
 */
public abstract class Personagem {

    protected String nome;
    protected double vida;
    protected double fome;
    protected double sede;
    protected double energia;
    protected double sanidade;
    protected String localizacao;
    protected Inventario inventario;

    // Atributo para indicar se encontrou refúgio seguro
    protected boolean refugioSeguroEncontrado;

    // Atributo para indicar se construiu abrigo permanente
    protected boolean abrigoConstruido;

    // Atributo para indicar se ativou pedido de resgate
    protected boolean pedidoResgateAtivado;

    // Contador de turnos desde o pedido de resgate
    protected int turnosDesdePedidoResgate;

    /**
     * Construtor do personagem.
     * 
     * @param nome Nome do personagem.
     * @param vida Quantidade de vida do personagem.
     * @param fome Quantidade de fome do personagem.
     * @param sede Quantidade de sede do personagem.
     * @param energia Quantidade de energia do personagem.
     * @param sanidade Quantidade de sanidade do personagem.
     * @param localizacao Localização atual do personagem.
     */
    public Personagem(String nome, double vida, double fome, double sede, double energia, double sanidade, String localizacao) {
        this.nome = nome;
        this.vida = vida;
        this.fome = fome;
        this.sede = sede;
        this.energia = energia;
        this.sanidade = sanidade;
        this.localizacao = localizacao;
        this.inventario = new Inventario(30.0);

        this.refugioSeguroEncontrado = false;
        this.abrigoConstruido = false;
        this.pedidoResgateAtivado = false;
        this.turnosDesdePedidoResgate = 0;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getFome() {
        return fome;
    }

    public void setFome(double fome) {
        this.fome = fome;
    }

    public double getSede() {
        return sede;
    }

    public void setSede(double sede) {
        this.sede = sede;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public double getSanidade() {
        return sanidade;
    }

    public void setSanidade(double sanidade) {
        this.sanidade = sanidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    // Métodos para refúgio seguro
    public boolean isRefugioSeguroEncontrado() {
        return refugioSeguroEncontrado;
    }

    public void setRefugioSeguroEncontrado(boolean refugioSeguroEncontrado) {
        this.refugioSeguroEncontrado = refugioSeguroEncontrado;
    }

    // Métodos para abrigo construído
    public boolean isAbrigoConstruido() {
        return abrigoConstruido;
    }

    public void setAbrigoConstruido(boolean abrigoConstruido) {
        this.abrigoConstruido = abrigoConstruido;
    }

    // Métodos para pedido de resgate
    public boolean isPedidoResgateAtivado() {
        return pedidoResgateAtivado;
    }

    public void setPedidoResgateAtivado(boolean pedidoResgateAtivado) {
        this.pedidoResgateAtivado = pedidoResgateAtivado;
    }

    public int getTurnosDesdePedidoResgate() {
        return turnosDesdePedidoResgate;
    }

    public void setTurnosDesdePedidoResgate(int turnosDesdePedidoResgate) {
        this.turnosDesdePedidoResgate = turnosDesdePedidoResgate;
    }

    /**
     * Aplica dano na vida do personagem, garantindo que a vida não seja negativa.
     * 
     * @param dano Quantidade de dano a ser aplicada.
     */
    public void aplicarDano(double dano) {
        if (dano < 0) {
            throw new IllegalArgumentException("Dano não pode ser negativo.");
        }
        this.vida -= dano;
        if (this.vida < 0) this.vida = 0;
        System.out.println(nome + " sofreu " + dano + " de dano. Vida atual: " + this.vida);
    }

    /**
     * Exibe os atributos atuais do personagem.
     */
    public void exibirStatus() {
        System.out.println("\nStatus de " + nome + ":");
        System.out.println("Vida: " + vida);
        System.out.println("Fome: " + fome);
        System.out.println("Sede: " + sede);
        System.out.println("Energia: " + energia);
        System.out.println("Sanidade: " + sanidade);
        System.out.println("Localização: " + localizacao);
    }

    /**
     * Permite ao personagem descansar, recuperando energia e sanidade.
     */
    public void descansar() {
        energia += 15;
        sanidade += 10;
        System.out.println("Você descansou. Energia e sanidade recuperadas.");
        if (energia > 100) energia = 100;
        if (sanidade > 100) sanidade = 100;
    }

    /**
     * Habilidade especial única de cada personagem.
     * Cada classe de personagem deve implementar suas habilidades especiais.
     */
    public abstract void habilidadeEspecial();

    /**
     * Verifica se o personagem morreu de fome ou sede e lança uma exceção.
     * 
     * @throws MortePorFomeOuSedeException Se o personagem morreu de fome ou sede.
     */
    public void verificarMorte() throws MortePorFomeOuSedeException {
        if (fome >= 100 || sede >= 100) {
            throw new MortePorFomeOuSedeException("Você morreu de fome ou sede.");
        }
    }
}
