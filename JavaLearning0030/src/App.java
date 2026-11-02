
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class App {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        showMainMenu();
    }

    // ============================================
    // ЗАВДАННЯ 3.0
    // Головне графічне меню
    // ============================================

    public static void showMainMenu() {

        String[] options = {
                "3.1 - Високосний рік",
                "3.2 - Геометричні обчислення",
                "Вихід"
        };

        while (true) {

            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Оберіть програму для запуску:",
                    "Головне меню - Завдання 3.0",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[2]);

            switch (choice) {

                case 0:
                    checkLeapYear();
                    break;

                case 1:
                    calculateGeometry();
                    break;

                case 2:
                case JOptionPane.CLOSED_OPTION:
                    JOptionPane.showMessageDialog(
                            null,
                            "Програму завершено!",
                            "Вихід",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;

                default:
                    return;
            }
        }
    }

    // ============================================
    // ЗАВДАННЯ 3.1
    // Перевірка високосного року
    // ============================================

    public static void checkLeapYear() {

        while (true) {

            String input = JOptionPane.showInputDialog(
                    null,
                    "Введіть рік:",
                    "Завдання 3.1 - Високосний рік",
                    JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                return;
            }

            try {

                int year = Integer.parseInt(input.trim());

                if (year <= 0) {
                    showError("Рік повинен бути додатним!");
                    continue;
                }

                boolean isLeapYear = (year % 400 == 0) ||
                        (year % 4 == 0 && year % 100 != 0);

                if (isLeapYear) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Рік " + year + " є високосним!",
                            "Результат",
                            JOptionPane.INFORMATION_MESSAGE);

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Рік " + year + " не є високосним!",
                            "Результат",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                return;

            } catch (NumberFormatException e) {

                showError(
                        "Помилка! Введіть ціле число року.");
            }
        }
    }

    // ============================================
    // ЗАВДАННЯ 3.2
    // Геометричні обчислення
    // ============================================

    public static void calculateGeometry() {

        double radius;

        while (true) {

            String input = JOptionPane.showInputDialog(
                    null,
                    "Введіть радіус R:",
                    "Завдання 3.2 - Радіус",
                    JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                return;
            }

            try {

                radius = Double.parseDouble(
                        input.trim().replace(',', '.'));

                if (!Double.isFinite(radius)
                        || radius <= 0) {

                    showError(
                            "Радіус повинен бути додатним числом!");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {

                showError(
                        "Помилка! Введіть коректний радіус.");
            }
        }

        String menu = "Виберіть, що ви хочете обчислити:\n\n" +
                "1 - Довжину кола\n" +
                "2 - Площу круга\n" +
                "3 - Об'єм кулі\n" +
                "4 - Площу поверхні кулі\n\n" +
                "Радіус R = " + radius;

        while (true) {

            String input = JOptionPane.showInputDialog(
                    null,
                    menu,
                    "Завдання 3.2 - Вибір обчислення",
                    JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                return;
            }

            double result;
            String resultName;
            String formula;

            switch (input.trim()) {

                case "1":

                    result = 2 * Math.PI * radius;

                    resultName = "Довжина кола";
                    formula = "L = 2 * PI * R";
                    break;

                case "2":

                    result = Math.PI * Math.pow(radius, 2);

                    resultName = "Площа круга";
                    formula = "S = PI * R^2";
                    break;

                case "3":

                    result = (4.0 / 3.0) *
                            Math.PI *
                            Math.pow(radius, 3);

                    resultName = "Об'єм кулі";
                    formula = "V = (4/3) * PI * R^3";
                    break;

                case "4":

                    result = 4 *
                            Math.PI *
                            Math.pow(radius, 2);

                    resultName = "Площа поверхні кулі";
                    formula = "S = 4 * PI * R^2";
                    break;

                default:

                    showError(
                            "Неправильний вибір обчислення!\n" +
                                    "Введіть число від 1 до 4.");
                    continue;
            }

            String message = resultName + ":\n\n" +
                    "Радіус: " + radius + "\n" +
                    "Формула: " + formula + "\n\n" +
                    "Результат: " +
                    String.format("%.6f", result);

            JOptionPane.showMessageDialog(
                    null,
                    message,
                    "Результат обчислення",
                    JOptionPane.INFORMATION_MESSAGE);

            return;
        }
    }

    // ============================================
    // Допоміжний метод повідомлення про помилку
    // ============================================

    public static void showError(String message) {

        JOptionPane.showMessageDialog(
                null,
                message,
                "Помилка",
                JOptionPane.ERROR_MESSAGE);
    }
}
