import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String pattern1 = "^Task(\\d+):\\s*(.*)";
        String text = "There are 123 apples and 456 oranges.";

        Pattern compiledPattern = Pattern.compile(pattern1);
        Matcher matcher = compiledPattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Found a match: " + matcher.group());
        }

        List<String> strings= new ArrayList<>();
         int  x= 0;

        strings.forEach(s -> {
            x++;
        });



    }
}
