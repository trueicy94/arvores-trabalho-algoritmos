import arvoreBinaria.BinaryTreeOfString;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Lista de jogadores (8 nomes)
        String[] players = {
                "Ana", "Bruno", "Carla", "Diego",
                "Eva", "Felipe", "Gabi", "Hugo"
        };

        // Cria a árvore do torneio
        BinaryTreeOfString torneio = new BinaryTreeOfString();
        torneio.buildTournament(players);

        // Registrar vencedores das quartas
        torneio.registerMatchWinner("Ana", "Bruno");
        torneio.registerMatchWinner("Carla", "Diego");
        torneio.registerMatchWinner("Eva", "Felipe");
        torneio.registerMatchWinner("Gabi", "Hugo");

        // Registrar vencedores das semifinais
        torneio.registerMatchWinner("Ana", "Carla");
        torneio.registerMatchWinner("Gabi", "Eva");

        // Registrar vencedor da final
        torneio.registerMatchWinner("Ana", "Gabi");

        // Campeão
        System.out.println("\nCampeão do torneio: " + torneio.getRoot());

        // Caminho até a final
        System.out.println("\nCaminho da Ana até a final:");
        System.out.println(torneio.pathToFinal("Ana"));

        System.out.println("\nCaminho do Bruno até a final:");
        System.out.println(torneio.pathToFinal("Bruno"));

        // Primeira partida possível entre dois jogadores
        System.out.println("\nPrimeira partida possível entre Ana e Gabi:");
        System.out.println(torneio.lcaMatchLabel("Ana", "Gabi"));
    }
}