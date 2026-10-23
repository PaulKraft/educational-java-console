
import java.util.Random;

public class App {

    public static void main(String[] args) {

        // Генератор випадкових чисел
        Random random = new Random();

        // Змінні для двох кубиків
        int dice1;
        int dice2;

        // Сума кубиків
        int sum;

        // Очки першого кидка
        int point;

        System.out.println("================================");
        System.out.println("      ГРА: ГРАЛЬНІ КУБИКИ       ");
        System.out.println("================================");

        // КРОК 1. Перший кидок двох кубиків
        dice1 = random.nextInt(6) + 1;
        dice2 = random.nextInt(6) + 1;

        // КРОК 2. Обчислення суми
        sum = dice1 + dice2;

        System.out.println("\nПерший кидок:");
        System.out.println("Кубик 1: " + dice1);
        System.out.println("Кубик 2: " + dice2);
        System.out.println("Сума: " + sum);

        // КРОК 3. Перевірка виграшу
        if (sum == 7 || sum == 11) {
            System.out.println("\nВІТАЄМО! ВИ ВИГРАЛИ!");
            return;
        }

        // КРОК 4. Перевірка програшу
        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("\nНА ЖАЛЬ, ВИ ПРОГРАЛИ!");
            return;
        }

        // КРОК 5. Збереження очок першого кидка
        point = sum;

        System.out.println("\nГра триває!");
        System.out.println("Ваші очки: " + point);
        System.out.println("Потрібно повторно набрати " + point);
        System.out.println("Якщо випаде 7 — програш!");

        // КРОК 6. Цикл із невідомою кількістю повторень
        while (true) {

            // КРОК 7. Повторний кидок кубиків
            dice1 = random.nextInt(6) + 1;
            dice2 = random.nextInt(6) + 1;

            sum = dice1 + dice2;

            System.out.println("\n--------------------------");
            System.out.println("Новий кидок:");
            System.out.println("Кубик 1: " + dice1);
            System.out.println("Кубик 2: " + dice2);
            System.out.println("Сума: " + sum);

            // КРОК 8. Програш, якщо випало 7
            if (sum == 7) {
                System.out.println("\nВИ ПРОГРАЛИ!");
                System.out.println("Випало число 7.");
                break;
            }

            // КРОК 9. Виграш, якщо повторили очки
            if (sum == point) {
                System.out.println("\nВІТАЄМО! ВИ ВИГРАЛИ!");
                System.out.println("Ви повторили число " + point);
                break;
            }

            // Якщо жодна умова не виконана
            System.out.println("Гра триває...");
        }

        System.out.println("\nКІНЕЦЬ ГРИ!");
    }
}
