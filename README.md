# 🌍 Última Fronteira — Jogo de Sobrevivência Baseado em Eventos

**Última Fronteira** é um jogo de sobrevivência em Java desenvolvido como projeto final da disciplina **Linguagem de Programação Orientada a Objetos (LPOO)**. O objetivo do jogo é simular, de forma modular e orientada a objetos, a experiência de um sobrevivente enfrentando desafios imprevisíveis em ambientes hostis.

O projeto foi idealizado para exercitar os principais pilares da programação orientada a objetos: **herança**, **polimorfismo**, **encapsulamento** e **composição** — com ênfase em modularidade, reutilização e expansão.

---

## 🎮 Sobre o Jogo

Neste jogo, o jogador assume o papel de um **explorador perdido** em uma terra desconhecida. Para sobreviver, é preciso:

- Gerenciar os **atributos** do personagem: vida, fome, sede, energia e sanidade.
- Usar o **inventário** com inteligência, considerando o peso e durabilidade dos itens.
- Explorar diferentes **ambientes** e lidar com eventos climáticos, criaturas, doenças ou descobertas.
- Tomar decisões estratégicas a cada turno, equilibrando riscos e recursos.

---

## 🧪 Funcionalidades

- ✅ Criação de personagens com atributos e localizações
- ✅ Sistema de turnos com fases (ação, evento, manutenção)
- ✅ Inventário com controle de peso, durabilidade e lista de itens
- ✅ 5 tipos de ambientes com comportamentos distintos
- ✅ Sistema de eventos aleatórios e dinâmicos
- ✅ Herança entre personagens e entre eventos/ambientes
- ✅ Itens interativos: água, alimento, ferramentas, armas, remédios, materiais
- ✅ Habilidades especiais exclusivas por classe de personagem

---

## 👤 Personagens Jogáveis

| Classe            | Habilidade Especial                        |
|-------------------|--------------------------------------------|
| Médico            | Cura com remédios                          |
| Mecânico          | Conserta ferramentas                       |
| Rastreador        | Rastreia água e comida com mais facilidade |
| Sobrevivente Nato | Resiste melhor à fome e à sede             |

---

## 🌎 Ambientes disponíveis

- **Floresta**: vegetação densa, fauna abundante
- **Montanha**: difícil acesso, clima instável
- **Caverna**: pouca luz, criaturas misteriosas
- **Lago/Rio**: água abundante, terreno lamacento
- **Ruínas**: estruturas instáveis, possíveis descobertas

---

## ⚙️ Tecnologias e Conceitos Aplicados

- Java 17
- Paradigma Orientado a Objetos
- Estrutura modular por pacotes
- Git e GitHub para versionamento
- Documentação com Javadoc

---

## 🧱 Estrutura de Diretórios

src/   
├── controller/   
    # Main.java (ponto de entrada)   
├── engine/   
    # Sistema de turnos   
├── models/ │   
    ├── Ambientes/   
        # Floresta, Caverna, etc. │   
    ├── Eventos/   
        # Climáticos, Criaturas, Doenças, Descobertas │   
    ├── Itens/   
        # Alimento, Água, Armas, Remédios, etc. │   
    └── Personagens/   
        # Classes jogáveis  

## 🚀 Como Executar

1. Clone o repositório:

git clone https://github.com/CaioMTRodrigues/ultima-fronteira.git

2. Abra uma IDE (Utilizamos o VSCode)

3. Compile e execute o arquivo:

src/controller/Main.java (Certifique-se de estar usando o Java 17 ou superior)

## 🗂️ Exemplos de Uso

Ao iniciar o jogo:

- O jogador visualiza o status do personagem
- Escolhe uma ação: descansar, usar item, explorar, etc.
- Um evento pode ocorrer e afetar os atributos ou inventário
- O sistema aplica penalidades de fome, sede e sanidade a cada turno

## 📚 Paradigmas de POO Aplicados

- **Herança**: Personagem, Evento e Ambiente como superclasses
- **Polimorfismo**: método `usar()` e `habilidadeEspecial()` com implementações diferentes
- **Encapsulamento**: uso de getters/setters para controle dos atributos
- **Composição**: personagens possuem um Inventário com itens

## 🤝 Contribuições

Contribuições são bem-vindas!

