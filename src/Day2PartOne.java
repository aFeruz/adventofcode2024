import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day2PartOne {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input/day2Part2.txt"));
            List<String> lines = br.lines().toList();
            String text = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9
                """;
            String[] lines2 = text.split("\n");
            part2(lines);
           // System.out.println(dayTwoPartTwo());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static int dayTwoPartTwo(){
        String text = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9
                """;
        String[] lines = text.split("\n");
        int count = 0;
        for (String line : lines) {
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }
            int left = nums[0];
            boolean increasing = nums[0] < nums[1];
            boolean notDangerous = true;
            int countDan = 0;
            for (int i = 1; i < nums.length; i++) {
                int right = nums[i];
                int diff = Math.abs(right - left);

                if (diff < 1 || diff > 3) {

                    notDangerous = false;
                }else  {
                    countDan++;
                }
                if (increasing != (left < right)) {
                    notDangerous = false;
                }
                left = right;
            }
            int length = nums.length -1;
            int sum = length - countDan;
            if ( sum <=1) {
                System.out.println(line + " counted time: " + countDan);
                count++;
            }
        }
        return count;
    }
    public static int dayTwoPartOne2(List<String> lines){
        int count = 0;
        for (String line : lines) {
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }
            int left = nums[0];
            boolean increasing = nums[0] < nums[1];
            boolean notDangerous = true;
            for (int i = 1; i < nums.length; i++) {
                int right = nums[i];
                int diff = Math.abs(right - left);

                if (diff < 1 || diff > 3) {
                    notDangerous = false;
                }
                if (increasing != (left < right)) {
                    notDangerous = false;
                }
                left = right;
            }

            if (notDangerous) {
                count++;
            }
        }
       return count;
    }
    public static int dayTwoPartOne(List<String> lines){
//        String text = """
//                7 6 4 2 1
//                1 2 7 8 9
//                9 7 6 2 1
//                1 3 2 4 5
//                8 6 4 4 1
//                1 3 6 7 9
//                """;
//        String[] lines = text.split("\n");
        int count = 0;
        for (String s : lines){
            String[] parts = s.trim().split("\\s+");
            int left = 0;
            int right = 1;
            System.out.println(s);
            int notDangerousCount = 0;
            boolean increasing = false;
            boolean decreasing = false;
            while(right < parts.length){

                int leftInt = Integer.parseInt(parts[left]);
                int rightInt = Integer.parseInt(parts[right]);
               if ( leftInt> rightInt){
                   decreasing = true;
                   if (leftInt - rightInt < 3 && !increasing){
                       notDangerousCount ++;
                   }
               }else {
                   increasing = true;
                   if (rightInt - leftInt < 3 && !decreasing){
                       notDangerousCount ++;
                   }
               }
                left++;
                right++;
                if (notDangerousCount == 4){
                    System.out.println("not dangerous " + s);
                    count++;
                }
            }
            System.out.println();
        }
        return count;
    }
    public static List<List<Integer>> remove(List<Integer> l) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            List<Integer> perm = new ArrayList<>(l);
            perm.remove(i);
            result.add(perm);
        }

        return result;
    }
    public static void part2(List<String> lines) {
        int count = 0;
        for (String line : lines) {
            String[] str = line.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String num : str) {
                nums.add(Integer.parseInt(num));
            }
            for (List<Integer> p : remove(nums)) {
                int left = p.get(0);
                boolean increasing = p.get(0) < p.get(1);
                boolean isValid = true;

                for (int i = 1; i < p.size(); i++) {
                    int right = p.get(i);
                    int diff = Math.abs(right - left);

                    if (diff < 1 || diff > 3) {
                        isValid = false;
                    }

                    if (increasing != (left < right)) {
                        isValid = false;
                    }

                    left = right;
                }

                if (isValid) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
