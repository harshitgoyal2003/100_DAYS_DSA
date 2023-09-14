import java.util.*;
public class Remove_Duplicate_String{
    public static String RemoveDuplicate(String str){
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();

        for(char c : str.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
                result.append(c);
            }
        }
        return result.toString();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String input = sc.nextLine();

        String result = RemoveDuplicate(input);
        System.out.println("String after removing duplicates: " + result);
    }
}