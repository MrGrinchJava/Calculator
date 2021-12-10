import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Calculator {
    public static void main(String[] args) {
        System.out.println(calculate());
    }
    public static float calculate() {
        FileReader fileReader = new FileReader();
        try {
            fileReader.dataToCalculate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        float currentValue = fileReader.applyNumber;
        for (String a : fileReader.getKeywordList()) {
            switch(a) {
                case "multiply" :
                   currentValue = CalculatorOperations.multiply(currentValue, fileReader.getNumberList().get(fileReader.getKeywordList().indexOf(a)));
                   break;
                case "add" :
                    currentValue = CalculatorOperations.add(currentValue, fileReader.getNumberList().get(fileReader.getKeywordList().indexOf(a)));
                    break;
                case "subtract" :
                    currentValue = CalculatorOperations.subtract(currentValue, fileReader.getNumberList().get(fileReader.getKeywordList().indexOf(a)));
                    break;
                case "divide" :
                    try {
                        currentValue = CalculatorOperations.divide(currentValue, fileReader.getNumberList().get(fileReader.getKeywordList().indexOf(a)));
                    } catch (ArithmeticException e) {
                        break;
                    }
                    break;
                default:
                    System.out.println("UNKNOWN OPERATION");
                    break;
            }

        }

        return currentValue;
    }
}
