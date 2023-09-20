import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int highestScore = Integer.MIN_VALUE;
        int highestScorePlayer = -1;
        double totalScore = 0;

        ArrayList<ArrayList<Integer>> scores = new ArrayList<>();

        while (true) {
            System.out.println("Ange poäng för ny spelare, skriv done när du är klar");
            ArrayList<Integer> score = new ArrayList<>();
            while (true) {
                String input = sc.nextLine();
                try {
                    int point = Integer.parseInt(input);
                    score.add(point);
                } catch (NumberFormatException e) { // cathcar error för sträng input ist för int, omvandlar till done
                    if (input.equals("done")) {
                        break;
                    }
                    System.out.println("ej giltig inmatning, försök igen");
                }
            }
            scores.add(score);
            System.out.println("Vill du ha en till spelate? (ja/nej)");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("nej")) {
                break;
            }
        }
        for (int i = 0; i < scores.size(); i++) {
            ArrayList<Integer> playerScores = scores.get(i);
            for (int score : playerScores) {
                totalScore += score;
                if (score > highestScore) {
                    highestScore = score;
                    highestScorePlayer = i;
                }
            }
        }
        double averageScore = totalScore / scores.size();

        System.out.println("Spelare " + (highestScorePlayer + 1) + " har högsta poängen med " + highestScore + " poäng");
        System.out.println("Genomsnittspoängen för ALLA spelare är: " + averageScore);
    }
}

