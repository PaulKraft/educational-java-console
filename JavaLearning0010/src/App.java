
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Random random = new Random();

        Scanner scanner = new Scanner(System.in);

        int secretNumber = random.nextInt(100) + 1;

        int userNumber;
        int attempts = 0;

        System.out.println("============================");
        System.out.println("       ГРА: ВГАДАЙ ЧИСЛО    ");
        System.out.println("============================");

        System.out.println("Комп'ютер загадав число від 1 до 100.");
        System.out.println("Спробуйте його вгадати!");

        while (true) {

            System.out.print("\nВведіть ваше число: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Помилка! Введіть ціле число.");
                scanner.next();
                continue;
            }

            userNumber = scanner.nextInt();

            if (userNumber < 1 || userNumber > 100) {
                System.out.println("Число повинно бути від 1 до 100!");
                continue;
            }

            attempts++;

            if (userNumber > secretNumber) {

                System.out.println("Ваше число більше за загадане!");

            } else if (userNumber < secretNumber) {

                System.out.println("Ваше число менше за загадане!");

            } else {

                System.out.println("\nВІТАЄМО! ВИ ВГАДАЛИ!");
                System.out.println("Загадане число: " + secretNumber);
                System.out.println("Кількість спроб: " + attempts);

                // Завершення циклу
                break;
            }
        }

        System.out.println("\nКІНЕЦЬ ГРИ!");

        // Закриття Scanner
        scanner.close();
    }
}
