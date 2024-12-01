import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class PartTwo {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input/day1Part2.txt"));
            List<String> lines = br.lines().toList();
            System.out.println(partTwo(lines));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static int partTwo(List<String> lines){
//        String text = """
//3   4
//4   3
//2   5
//1   3
//3   9
//3   3
//""";
////        String[] lines = text.split("\n");
        int[] leftLines = new int[lines.size()];
        int[] rightLines = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).trim().split("\\s+");
            leftLines[i] = Integer.parseInt(parts[0]);
            rightLines[i] = Integer.parseInt(parts[1]);
        }
        Arrays.sort(leftLines);
        Arrays.sort(rightLines);
        int sum = 0;

        for (int i = 0; i < leftLines.length; i++) {
            int count = 0;
            for (int j = 0; j < rightLines.length; j++) {
                if (leftLines[i]  == rightLines[j]){
                    count++;
                }else {
                    sum += leftLines[i] * count;
                    count = 0;
                }
            }
        }
        return sum;


    }
}
