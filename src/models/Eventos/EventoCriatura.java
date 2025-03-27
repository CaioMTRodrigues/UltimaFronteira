package models.Eventos;

public class EventoCriatura extends Evento {

    private String tipoCriatura;
    private int nivelPerigo;
    private String opcoesAcao;

    // Construtor que inicializa os dados específicos do evento de criatura
    public EventoCriatura(String nome, String descricao, double probabilidade, String impacto, String tipoCriatura, int nivelPerigo, String opcoesAcao) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoCriatura = tipoCriatura;
        this.nivelPerigo = nivelPerigo;
        this.opcoesAcao = opcoesAcao;
    }

    // Métodos de Acesso
    public String getTipoCriatura() { return tipoCriatura; }
    public void setTipoCriatura(String tipoCriatura) { this.tipoCriatura = tipoCriatura; }
    public int getNivelPerigo() { return nivelPerigo; }
    public void setNivelPerigo(int nivelPerigo) { this.nivelPerigo = nivelPerigo; }
    public String getOpcoesAcao() { return opcoesAcao; }
    public void setOpcoesAcao(String opcoesAcao) { this.opcoesAcao = opcoesAcao; }

    // Método sobrescrito para executar o evento de encontro com criatura
    @Override
    public void executar() {
        System.out.println("⚠ Encontro com Criatura: " + getTipoCriatura());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Nível de Perigo: " + getNivelPerigo());
        if (getNivelPerigo() > 5) {
            System.out.println("Esta criatura é extremamente perigosa! Fuja ou prepare-se para lutar!");
        }
        System.out.println("Opções disponíveis: " + getOpcoesAcao());
    }
}

