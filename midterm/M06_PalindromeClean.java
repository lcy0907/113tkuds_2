import java.util.*;

public class M06_PalindromeClean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetter(s.charAt(l))) l++;
            while (l < r && !Character.isLetter(s.charAt(r))) r--;
            if (l < r) {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    System.out.println("No");
                    return;
                }
                l++; r--;
            }
        }
        System.out.println("Yes");
    }
}

