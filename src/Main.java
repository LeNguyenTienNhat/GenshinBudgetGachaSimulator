import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        RollList roll_list = new RollList();
        do {
            roll_list.addNewRoll(inputInt("Enter number of rolls: "));
            roll_list.printListWithName();
            roll_list.deleteList();           
        }
        while (inputString("Roll?  Y/N").equalsIgnoreCase("y"));       
    }

    public static int inputInt(String message){
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();  
        return x;      
    }

    public static String inputString(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toLowerCase();
    }
}
