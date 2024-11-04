package bankada;

import lombok.Data;

@Data
public class Account {
    private AccountType accountType;
    private Client client;
    private Employee employee;

    public Account() {}

    public Account(AccountType accountType, Client client, Employee employee) {
        this.accountType = accountType;
        this.client = client;
        this.employee = employee;
    }

    public String toString() {
        return "Typ konta: " + accountType + ", wlasciciel: " + client + ", zalozone przez: " + employee;
    }
}
