package models.Itens;

public class FabricaDeItens {

    public static Item criarItem(String nome) {
        switch (nome.toLowerCase()) {
            case "machado":
                // nome, peso, durabilidade, tipo, eficiencia
                return new ItemFerramentas("Machado", 3.5, 100, "Machado", 75);
            case "faca":
                return new ItemFerramentas("Faca", 1.5, 80, "Faca", 60);
            case "madeira":
                // nome, peso, durabilidade, tipo, resistencia
                return new ItemMaterial("Madeira", 1.0, 50, "Madeira", 40);
            case "pedra":
                return new ItemMaterial("Pedra", 2.0, 70, "Pedra", 60);
            case "bandagem":
                // nome, peso, durabilidade, tipo, efeito
                return new ItemRemedios("Bandagem", 0.5, 1, "Bandagem", "Cura ferimentos leves");
            case "antibiotico":
                return new ItemRemedios("Antibiótico", 0.3, 3, "Antibiótico", "Combate infecção");
            // Adicione mais itens conforme necessidade
            default:
                System.out.println("Item desconhecido: " + nome);
                return null;
        }
    }
}