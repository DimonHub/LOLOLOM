package banksql;

class Client {
    private int id;
    private String firstName;
    private String lastName;

    public Client(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return String.format("ID: %d, Imię: %s, Nazwisko: %s", id, firstName, lastName);
    }

}