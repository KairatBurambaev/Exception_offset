import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static User fromInputString(String input) throws InvalidUserDataException {
        String[] values = input.trim().split("\\s+");
        if (values.length != 6) {
            throw new InvalidUserDataException("Invalid number of values");
        }
        String lastName = values[0];
        String firstName = values[1];
        String middleName = values[2];
        String birthDate;
        try {
            birthDate = String.valueOf(LocalDate.parse(values[3], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        } catch (Exception e) {
            throw new InvalidUserDataException("Invalid birth date format");
        }
        String phoneNumber;
        try {
            phoneNumber = String.valueOf(Long.parseLong(values[4]));
        } catch (NumberFormatException e) {
            throw new InvalidUserDataException("Invalid phone number format");
        }
        char gender = values[5].toLowerCase().charAt(0);
        if (gender != 'f' && gender != 'm') {
            throw new InvalidUserDataException("Invalid gender value");
        }
        return new User(lastName, firstName, middleName, birthDate, phoneNumber, gender);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner inp = new Scanner(System.in);
        System.out.println("Введите данные формата - Иванова Ивана Иванович 03.02.1995 1234567890 m");
        String input =  inp.nextLine();
//        String input = "Иванова Ивана Иванович 03.02.1995 1234567890 m";
        try {
            User user = fromInputString(input);
            FileWriter writer = new FileWriter(user.getLastName() + ".txt", true);
            writer.write(user.toFileString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        } catch (InvalidUserDataException e) {
            throw new RuntimeException(e);
        }
    }
}


