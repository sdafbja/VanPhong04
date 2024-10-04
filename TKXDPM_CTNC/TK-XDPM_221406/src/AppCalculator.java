import buoi2.CalculatorUIConsoleInput;

public class AppCalculator {
    public static void main(String[] args) {
        try {
            CalculatorUIConsoleInput input = new CalculatorUIConsoleInput();
            input.input();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}
