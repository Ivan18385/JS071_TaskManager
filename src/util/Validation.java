package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Validation {

    //validate int
    public int validateInteger(String input, int min, int max, String fieldName) {
        try {
            int number = Integer.parseInt(input.trim());
            if (number >= min && number <= max) {
                return number;
            } else {
                throw new IllegalArgumentException(fieldName +" is a number between " + min + " and " + max + ".");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Please enter a number!");
        }
    }

    //validate plan from and plan to
    public double validatePlanValues(String input, double min, double max){
        try {
            double number = Double.parseDouble(input.trim());
            if (number < min || number > max){
                throw new IllegalArgumentException("Plan must be between " + min +  " and " + max);
            }
            if (number % 0.5 == 0) {
                return number;
            } else {
                throw new IllegalArgumentException("Time must be in .0 or .5 increments (e.g., 8.0, 8.5).");
            }
        }catch (NumberFormatException e){
            throw new NumberFormatException("You have enter a double number");
        }
    }

    //validate plan range
    public boolean validatePlanRange(double planFrom, double planTo) {
        if (planTo > planFrom) return true;
        return false;
    }

    //validate Date format
    public Date validateDate(String input){
        input = input.trim();
        if (input.isEmpty()) throw new IllegalArgumentException("Date can not empty");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try{
            return dateFormat.parse(input);
        } catch (ParseException e){
            throw new IllegalArgumentException("Invalid date, enter again!");
        }
    }

    //check string input
    public String checkString(String input) {
        input = input.trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input must not be empty.");
        }
        return input;
    }
}
