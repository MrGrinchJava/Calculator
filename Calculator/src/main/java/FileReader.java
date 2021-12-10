import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    private List<String> keywordList = new ArrayList<>();
    private List<Integer> numberList = new ArrayList<>();
    int applyNumber;
    private List<String> readFile() throws IOException {
        Path resourceDirectory = Paths.get("src","main","resources","records.txt");
        return Files.readAllLines(resourceDirectory);
    }
    private List<String> dataInListToCalculate() throws IOException {
        return readFile().stream().filter(y -> (!y.isEmpty() && !y.trim().equals(""))).collect(Collectors.toList());
    }
    public void dataToCalculate() throws IOException {
        for (String a : dataInListToCalculate()) {
            a.trim();
            String[] parts = a.split(" ");
            if (parts[0].equals("apply")) {
                applyNumber = Integer.valueOf(parts[1]);
            } else {
                keywordList.add(parts[0]);
                numberList.add(Integer.valueOf(parts[1]));
            }
        }
        if (keywordList.size() != numberList.size()) {
            try {
                throw new Exception("UNEQUAL NUMBER OF KEYWORDS AND NUMBERS");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getKeywordList() {
        return keywordList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
