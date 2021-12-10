import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    private FileReader fileReader;
    @BeforeEach
    void beforeEach() throws IOException {
        fileReader = new FileReader();
        fileReader.dataToCalculate();
    }
    @Test
    void multiplyTest() {
        assertEquals(10, CalculatorOperations.multiply(2,5));
    }

    @Test
    void divideByZeroTest() {
        Exception exception = assertThrows(ArithmeticException.class, () -> CalculatorOperations.divide(2,0));
        String expectedMessage = "DIVIDE BY 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void fileExistsTest() {
        assertTrue(Files.exists(Paths.get("src","main","resources","records.txt")));
    }

    @Test
    public void fileNotEmptyTest() throws Exception {
        assertTrue(!Files.readAllLines(Paths.get("src","main","resources","records.txt")).isEmpty());
    }

    @Test
    public void containsApplyRecordTest() throws IOException {
        assertTrue(Files.readAllLines(Paths.get("src","main","resources","records.txt"))
                .get(Files.readAllLines(Paths.get("src","main","resources","records.txt")).size() - 1).split(" ")[0].equals("apply"));
    }

    @Test
    public void correctnessOfReadingData() {
        assertTrue(fileReader.getKeywordList().size() == fileReader.getNumberList().size());
    }

    @Test
    public void correctnessOfCalculateTest() {
        assertEquals(36, Calculator.calculate());
    }
}
