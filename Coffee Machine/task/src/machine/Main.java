package machine;

import machine.model.AbstractCoffeeMachine;
import machine.model.CoffeeMachine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){

            final AbstractCoffeeMachine machine =
                    new CoffeeMachine(400, 540, 120, 9, 120, 550);

            machine.powerOn();

            while (AbstractCoffeeMachine.isPowered) {
                machine.displayMenu();
                machine.compute(scanner.nextLine().toLowerCase());
            }
        }
    }
}
