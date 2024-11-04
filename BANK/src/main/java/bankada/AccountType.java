package bankada;

public enum AccountType {
    OSOBISTE("Osobiste"),
    OSZCZEDNOSCIOWE("Oszczednosciowe");

    private final String displayName;

    AccountType(String displayName) {
        this.displayName = displayName;
    }

    public String toString() {
        return displayName;
    }
}
