import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PartOne {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("input/day1Part1.txt"));
            List<String> lines = br.lines().toList();
            System.out.println(partOne(lines));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static int partOne( List<String> lines){
//        String text = """
//                3   4
//                4   3
//                2   5
//                1   3
//                3   9
//                3   3
//                """;
//        String[] lines = text.split("\n");
//        int[] left = new int[lines.length];
//        int[] right = new int[lines.length];
//        for (int i = 0; i < lines.length; i++) {
//            String[] parts = lines[i].trim().split("\\s+");
//            left[i] = Integer.parseInt(parts[0]);
//            right[i] = Integer.parseInt(parts[1]);
//        }
        int[] left = new int[lines.size()];
        int[] right = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            System.out.println( "lines 1 " + lines.get(i));
            String[] parts = lines.get(i).trim().split("\\s+");
            left[i] = Integer.parseInt(parts[0]);
            right[i] = Integer.parseInt(parts[1]);
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int sum = 0;
        for (int i = 0; i < left.length; i++) {
//            System.out.println("left " + left[i]);
//            System.out.println("right " +right[i]);
            if (left[i] > right[i]){
                sum +=  left[i] - right[i];
            } else if (left[i] < right[i]) {
                sum +=   right[i] - left[i];

            }else {
                sum +=  left[i] - right[i];
            }
            System.out.println("sum = " + sum   );
        }
        return sum ;

    }
}
