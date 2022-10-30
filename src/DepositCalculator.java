import java.util.Scanner;

public class DepositCalculator {

  double calculateComplexPercent(double a, double y, int d) {
    double pay = a * Math.pow((1 + y / 12), 12 * d);
    return roundToTheSign(pay, 2);
  }

  double calculateSimplePercent(double doubleAmount, double double_year_rate,
      int deposit_period) {
    return roundToTheSign(doubleAmount + doubleAmount * double_year_rate * deposit_period,
        2);
  }

  double roundToTheSign(double value, int places) {
    double scale = Math.pow(10, places);
    return Math.round(value * scale) / scale;
  }

  void calculateDepositProfit() {
    int period, action;
    double result = 0;
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите сумму вклада в рублях:");
    int amount = scanner.nextInt();
    System.out.println("Введите срок вклада в годах:");
    period = scanner.nextInt();
    System.out.println(
        "Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
    action = scanner.nextInt();
    if (action == 1) {
        result = calculateSimplePercent(amount, 0.06, period);
    } else if (action == 2) {
        result = calculateComplexPercent(amount, 0.06, period);
    }
    System.out.println(
        "Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
  }

  public static void main(String[] args) {
    new DepositCalculator().calculateDepositProfit();
  }


}
