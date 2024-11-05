package bank;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Imie Klienta: ");
        String firstName = scanner.nextLine();


        System.out.print("Nazwisko Klienta: ");
        String lastName = scanner.nextLine();


        Client client = new Client(firstName, lastName);


        Employee employee = new Employee(EmployeeConstants.FIRST_NAME, EmployeeConstants.LAST_NAME);


        AccountType accountType = chooseAccountType(scanner);


        Account account = new Account(accountType, client, employee);


        System.out.println("Klient: " + client.getFirstName() + " " + client.getLastName());
        System.out.println("Typ konta: " + account.getAccountType());
        System.out.println("Pracownik: " + employee.getFirstName() + " " + employee.getLastName());

        scanner.close();
    }

    private static AccountType chooseAccountType(Scanner scanner) {
        int choice;
        do {
            System.out.println("Wybierz typ konta:");
            System.out.println("1 - Oszczędnościowe");
            System.out.println("2 - Osobiste");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    return AccountType.SAVINGS;
                case 2:
                    return AccountType.PERSONAL;
                default:
                    System.out.println("Niepoprawny wybór, spróbuj ponownie.");
            }
        } while (true);
    }
}
