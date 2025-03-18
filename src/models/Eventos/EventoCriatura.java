package models.Eventos;

public class EventoCriatura extends Evento {
    private String tipoCriatura;
    private int nivelPerigo;
    private String opcoesAcao;

    public EventoCriatura(String nome, String descricao, double probabilidade, String impacto, String tipoCriatura, int nivelPerigo, String opcoesAcao) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoCriatura = tipoCriatura;
        this.nivelPerigo = nivelPerigo;
        this.opcoesAcao = opcoesAcao;
    }

    @Override
    public void executar() {
        System.out.println("⚠ Encontro com Criatura: " + tipoCriatura);
        System.out.println("Descrição: " + descricao);
        System.out.println("Nível de Perigo: " + nivelPerigo);
        System.out.println("Opções disponíveis: " + opcoesAcao);
    }
}
