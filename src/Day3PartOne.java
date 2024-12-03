import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3PartOne {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("input/day3part1.txt"));
             printLines(br.lines().toList());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> sum(String s){
        String regex = "mul\\(\\d+,\\d+\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        List<String> l = new ArrayList<>();
        while (matcher.find()) {
           l.add(matcher.group());
        }
        return l;
    }
    public static void printLines(List<String> lines){
        List<String> l = new ArrayList<>();
        for(String s : lines){
            l.addAll(sum(s))
          ;
        }
        int sum = 0;
        for (String s : l){
            String ss = s.replaceAll("mul\\(" , "").replaceAll("\\)" , "");
            String[] split = ss.split(",");
            sum += Integer.parseInt(split[0])* Integer.parseInt(split[1]);
            System.out.println("split 1 = " +split[0] + " split 2 = " + split[1]);

        }
        System.out.println(sum);
    }
}
