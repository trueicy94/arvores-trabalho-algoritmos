import arvoreBinaria.BinaryTreeOfString;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] players = {"Ana", "Bruno", "Carlos", "Diana", "Eduardo", "Fernanda", "Gustavo", "Helena"};
        BinaryTreeOfString torneio = new BinaryTreeOfString();
        torneio.buildTournament(players);

        System.out.println("Pré-ordem:");
        System.out.println(torneio.positionsPre());

        System.out.println("Pós-ordem:");
        System.out.println(torneio.positionsPost());

        System.out.println("Em largura:");
        System.out.println(torneio.positionsLevel());

        System.out.println("Partida entre Ana e Bruno:");
        System.out.println(torneio.lcaMatchLabel("Ana", "Bruno"));

        System.out.println("Caminho até a final (Ana):");
        System.out.println(torneio.pathToFinal("Ana"));

        torneio.registerMatchWinner("Ana", "Bruno");
        torneio.registerMatchWinner("Carlos", "Diana");
        torneio.registerMatchWinner("Eduardo", "Fernanda");
        torneio.registerMatchWinner("Gustavo", "Helena");

        System.out.println("Após registrar vencedores da primeira rodada:");
        System.out.println(torneio.positionsLevel());

        torneio.registerMatchWinner("Ana", "Carlos");
        torneio.registerMatchWinner("Eduardo", "Gustavo");
        torneio.registerMatchWinner("Ana", "Eduardo"); // Final

        System.out.println("Campeão do torneio:");
        System.out.println(torneio.getRoot());

    }
}