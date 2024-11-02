import java.util.Scanner;

public class User_Input {
    public static void main(String[] args) 
    {
        Scanner Num = new Scanner (System.in);
        int a = Num.nextInt();
        int b = Num.nextInt();
        int c = Num.nextInt();
        System.out.print(a*b*c);
        
    }
}
