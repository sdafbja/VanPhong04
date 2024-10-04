package buoi2;


public class CalculatorUseCaseControl implements InputBoundary {

    private CalculatorEntity calculatorEntity = null;
    private OutputBoundary calculatorUIConsoleOutput = null;

    public CalculatorUseCaseControl() {
        calculatorEntity = new CalculatorEntity();
    }

    public void setCalculatorUIConsoleOutput(OutputBoundary calculatorUIConsoleOutput) {
        this.calculatorUIConsoleOutput = calculatorUIConsoleOutput;
    }

    public void execute(RequestData requestData) {
        String strNumber1 = requestData.strNumber1;
        String strNumber2 = requestData.strNumber2;
        String operation = requestData.operation;

        if (isNumber(strNumber1) && isNumber(strNumber2)) {
            int num1 = Integer.parseInt(strNumber1);
            int num2 = Integer.parseInt(strNumber2);
            calculatorEntity.setNum1(num1);
            calculatorEntity.setNum2(num2);

            ResponseData responseData = new ResponseData();
            try {
                switch (operation) {
                    case "+":
                        responseData.strResult = String.valueOf(calculatorEntity.add());
                        break;
                    case "-":
                        responseData.strResult = String.valueOf(calculatorEntity.subtract());
                        break;
                    case "*":
                        responseData.strResult = String.valueOf(calculatorEntity.multiply());
                        break;
                    case "/":
                        responseData.strResult = String.valueOf(calculatorEntity.divide());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operation");
                }
                calculatorUIConsoleOutput.output(responseData);
            } catch (ArithmeticException e) {
                ResponseEror resError = new ResponseEror();
                resError.error = "ERROR_DIVISION_BY_ZERO";
                calculatorUIConsoleOutput.showError(resError);
            } catch (IllegalArgumentException e) {
                ResponseEror resError = new ResponseEror();
                resError.error = "ERROR_INVALID_OPERATION";
                calculatorUIConsoleOutput.showError(resError);
            }
        } else {
            ResponseEror resError = new ResponseEror();
            resError.error = "ERROR_INVALID_INPUT";
            calculatorUIConsoleOutput.showError(resError);
        }
    }

    private boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}