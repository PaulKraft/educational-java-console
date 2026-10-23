
import java.util.Random;

public class App {

    public static void main(String[] args) {

        Random random = new Random();

        int dice1;
        int dice2;

        int sum;

        int point;

        System.out.println("================================");
        System.out.println("      ГРА: ГРАЛЬНІ КУБИКИ       ");
        System.out.println("================================");

        dice1 = random.nextInt(6) + 1;
        dice2 = random.nextInt(6) + 1;

        sum = dice1 + dice2;

        System.out.println("\nПерший кидок:");
        System.out.println("Кубик 1: " + dice1);
        System.out.println("Кубик 2: " + dice2);
        System.out.println("Сума: " + sum);

        if (sum == 7 || sum == 11) {
            System.out.println("\nВІТАЄМО! ВИ ВИГРАЛИ!");
            return;
        }

        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("\nНА ЖАЛЬ, ВИ ПРОГРАЛИ!");
            return;
        }

        point = sum;

        System.out.println("\nГра триває!");
        System.out.println("Ваші очки: " + point);
        System.out.println("Потрібно повторно набрати " + point);
        System.out.println("Якщо випаде 7 — програш!");

        while (true) {

            dice1 = random.nextInt(6) + 1;
            dice2 = random.nextInt(6) + 1;

            sum = dice1 + dice2;

            System.out.println("\n--------------------------");
            System.out.println("Новий кидок:");
            System.out.println("Кубик 1: " + dice1);
            System.out.println("Кубик 2: " + dice2);
            System.out.println("Сума: " + sum);

            if (sum == 7) {
                System.out.println("\nВИ ПРОГРАЛИ!");
                System.out.println("Випало число 7.");
                break;
            }

            if (sum == point) {
                System.out.println("\nВІТАЄМО! ВИ ВИГРАЛИ!");
                System.out.println("Ви повторили число " + point);
                break;
            }

            System.out.println("Гра триває...");
        }

        System.out.println("\nКІНЕЦЬ ГРИ!");
    }
}
