// CS210 Assignment #3 "Greetings"
// David Johnson
// Accepts input and prints a formatted greeting

import java.util.*;

public class Greetings {

    public static void main(String[] args) {        
        Scanner s = new Scanner(System.in);
        System.out.println(getGreetings(s));
    }

    private static String getGreetings(Scanner console) {        
        System.out.print("Please enter your first name: ");
        String firstName = console.next();
        String firstInitial = firstName.toUpperCase().substring(0,1) + ".";
        System.out.print("Please enter your last name: ");
        String lastName = console.next();
        lastName = lastName.toUpperCase().substring(0,1) + lastName.substring(1);
        System.out.print("Please enter your year of birth: ");
        int yearBorn = console.nextInt();
        int age = getCurrentYear() - yearBorn;
        return "Greetings, " + firstInitial + " " + lastName + "! You are about " + age + " years old.";
    }
    
    // Get the current year
    //   you may find this method useful when calculating the age -- feel free to use it
    private static int getCurrentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
