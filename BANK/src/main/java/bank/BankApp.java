
package bank;

public class BankApp {
    public static void main(String[] args) {
 
        Client client = new Client("Jan", "Kowalski");

        Employee employee = new Employee("Santa", "K");

        AccountType accountType = AccountType.SAVINGS; 

        Account account = new Account(accountType, client, employee);


        System.out.println("Klient: " + client.getFirstName() + " " + client.getLastName());
        System.out.println("Typ konta: " + account.getAccountType());
    }
}
