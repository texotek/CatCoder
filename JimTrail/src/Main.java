import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //System.out.print("Enter the number of tests: ");
        int moves = s.nextInt();
        ArrayList<Jim.MoveAction> actions = new ArrayList<Jim.MoveAction>();
        for (int i = 0; i < moves; i++) {
            String sequence = s.next();
            int times = s.nextInt();
            actions.add(new Jim.MoveAction(times, sequence));
        }
        actions.forEach(action -> {
            System.out.println(action.sequence() + " " + action.times());
        });
        Jim jim = new Jim(actions);
        System.out.println(jim.calculateCircumference() + " " + jim.calculateRectangularArea() + " " + jim.calculateCorrectArea());
    }
}
