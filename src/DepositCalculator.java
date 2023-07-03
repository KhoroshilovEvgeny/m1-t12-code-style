import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod); // Лучше без дополнительных скобок,
        // т.к. снижается читаемость кода
        return roundToScale(pay, 2);
    }

    double calculateSimplePercent(double amount,double yearRate, int depositPeriod) { // Лучше ставить пробел после ,
         return roundToScale(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundToScale(double value, int places) { // Отличный выбор имени функции
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDepositWithPercent() {
        int period; // Лучше определять локальные переменные перед использованием
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double depositWithPercent = 0; // Отличный выбор имени переменной
        if (action == 1) {
            depositWithPercent = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            depositWithPercent = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositWithPercent);
        // Строка не влезыет в требуемый диапазон 80 символов
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositWithPercent();
    }
}
