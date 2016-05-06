package th.system.user_interface;

import java.util.Scanner;

import th.system.user_interface.constant.GlobalFunctionOption;

public class ConsoleInterface {
    
    private Scanner scanner;
    
    public ConsoleInterface() {
        scanner = new Scanner(System.in);
    }
    
    private void displayOption() {
        System.out.println("1. Option 1");
        System.out.println("2. Option 2");
        System.out.println("3. Option 3");
        System.out.println("4. Option 4");
        System.out.println("5. Exit");
        System.out.println("Which option do you want to choose?");
    }
    
    private GlobalFunctionOption getOptionFromConsole() {
        displayOption();
        try {
            return GlobalFunctionOption.getOptionFromInputOpt(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException ex) {
            return GlobalFunctionOption.NOT_SUPPORT;
        }
    }
    
    public void run() {
        while(true) {
            GlobalFunctionOption optionFromConsole = getOptionFromConsole();
            if(optionFromConsole == GlobalFunctionOption.EXIT) {
                break;
            }
            
            optionFromConsole.getCommand().execute();
        }
    }
}