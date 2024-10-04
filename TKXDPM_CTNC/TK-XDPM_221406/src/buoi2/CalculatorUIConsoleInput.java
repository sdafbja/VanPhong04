package buoi2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CalculatorUIConsoleInput {

    private PrintWriter stdOut = null;
    private BufferedReader stdIn = null;
    private InputBoundary calculatorUseCaseControl = null;

    public CalculatorUIConsoleInput() {
        stdOut = new PrintWriter(new OutputStreamWriter(System.out));
        stdIn = new BufferedReader(new InputStreamReader(System.in));
        CalculatorUseCaseControl control = new CalculatorUseCaseControl();
        SumUIConsoleOutput output = new SumUIConsoleOutput();
        control.setCalculatorUIConsoleOutput(output);
        calculatorUseCaseControl = control;
    }
    

    public void input() throws IOException {
        stdOut.print("Enter the first number: ");
        stdOut.flush();
        String strNumber1 = stdIn.readLine();

        stdOut.print("Enter the second number: ");
        stdOut.flush();
        String strNumber2 = stdIn.readLine();

        stdOut.print("Enter the operation (+, -, *, /): ");
        stdOut.flush();
        String operation = stdIn.readLine();

        RequestData requestData = new RequestData(strNumber1, strNumber2, operation);
        calculatorUseCaseControl.execute(requestData);
    }
}