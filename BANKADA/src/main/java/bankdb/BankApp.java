package bankdb;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;




public class BankApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Dodaj klienta");
            System.out.println("2. Dodaj konto");
            System.out.println("3. Dodaj pożyczkę");
            System.out.println("4. Dodaj pracownika");
            System.out.println("5. Wyjście");

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    addClient(scanner);
                    break;
                case 2:
                    addKonto(scanner);
                    break;
                case 3:
                    addPozyczka(scanner);
                    break;
                case 4:
                    addPracownik(scanner);
                    break;
                case 5:
                    System.out.println("Zamykanie programu...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Nieznana opcja. Spróbuj ponownie.");
            }
        }
    }

    public static void addClient(Scanner scanner) {
        System.out.println("Podaj imię klienta:");
        String imie = scanner.nextLine();
        System.out.println("Podaj nazwisko klienta:");
        String nazwisko = scanner.nextLine();
        System.out.println("Podaj pesel klienta:");
        String pesel = scanner.nextLine();
        System.out.println("Podaj datę urodzenia (yyyy-mm-dd):");
        String dataUrodzeniaStr = scanner.nextLine();
        Date dataUrodzenia = Date.valueOf(dataUrodzeniaStr);

        Klient klient = new Klient(imie, nazwisko, pesel, dataUrodzenia);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(klient);
            transaction.commit();
            System.out.println("Klient dodany pomyślnie!");
        } catch (Exception e) {
            System.out.println("Błąd podczas dodawania klienta: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void addKonto(Scanner scanner) {
        System.out.println("Podaj klienta (ID klienta):");
        int klientId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj saldo:");
        double saldo = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Podaj datę otwarcia (yyyy-mm-dd):");
        String dataOtwarciaStr = scanner.nextLine();
        Date dataOtwarcia = Date.valueOf(dataOtwarciaStr);

        String waluta = "PLN";

        Konto konto = new Konto(klientId, waluta, saldo, dataOtwarcia);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(konto);
            transaction.commit();
            System.out.println("Konto dodane pomyślnie!");
        } catch (Exception e) {
            System.out.println("Błąd podczas dodawania konta: " + e.getMessage());
        }
    }

    public static void addPozyczka(Scanner scanner) {
        System.out.println("Podaj klienta (ID klienta):");
        int klientId = scanner.nextInt();
        System.out.println("Podaj pracownika (ID pracownika):");
        int pracownikId = scanner.nextInt();
        System.out.println("Podaj kwotę pożyczki:");
        double kwota = scanner.nextDouble();
        System.out.println("Podaj okres pożyczki (w miesiącach):");
        int okresMiesiecy = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj datę pożyczki (yyyy-mm-dd):");
        String dataPozyczkiStr = scanner.nextLine();
        LocalDate dataPozyczki = LocalDate.parse(dataPozyczkiStr);

        Pozyczki pozyczka = new Pozyczki();
        pozyczka.setKlientId(klientId);
        pozyczka.setPracownikId(pracownikId);
        pozyczka.setKwota(kwota);
        pozyczka.setOkresMiesiecy(okresMiesiecy);
        pozyczka.setDataPozyczki(dataPozyczki);

        Rata rata = new Rata();
        rata.setKwotaRaty(kwota / okresMiesiecy);
        rata.setDataSplaty(dataPozyczki.plusMonths(1));
        rata.setStatusSplaty("NIESPLACONA");
        rata.setProcent(5);


        List<Rata> ratyList = new ArrayList<>();
        ratyList.add(rata);


        pozyczka.setRaty(ratyList); // Сохраняем первую рату


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(pozyczka);
            transaction.commit();
            System.out.println("Pożyczka z ratą została dodana pomyślnie!");
        } catch (Exception e) {
            System.out.println("Błąd podczas dodawania pożyczki: " + e.getMessage());
            e.printStackTrace();
        }
    }








    public static void addPracownik(Scanner scanner) {
        System.out.println("Podaj imię pracownika:");
        String imie = scanner.nextLine();
        System.out.println("Podaj nazwisko pracownika:");
        String nazwisko = scanner.nextLine();
        System.out.println("Podaj pesel pracownika:");
        String pesel = scanner.nextLine();
        System.out.println("Podaj datę zatrudnienia (yyyy-mm-dd):");
        String dataZatrudnieniaStr = scanner.nextLine();
        Date dataZatrudnienia = Date.valueOf(dataZatrudnieniaStr);

        System.out.println("Podaj ulicę:");
        String ulica = scanner.nextLine();
        System.out.println("Podaj miasto:");
        String miasto = scanner.nextLine();
        System.out.println("Podaj kod pocztowy adresu:");
        String kodPocztowy = scanner.nextLine();
        System.out.println("Podaj kraj:");
        String kraj = scanner.nextLine();

        Adres adres = new Adres();
        adres.setUlica(ulica);
        adres.setMiasto(miasto);
        adres.setKodPocztowy(kodPocztowy);
        adres.setKraj(kraj);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(adres);
            transaction.commit();
            System.out.println("Adres został dodany pomyślnie!");

            int adresId = adres.getAdresId();

            Pracownik pracownik = new Pracownik(imie, nazwisko, pesel, dataZatrudnienia, adresId);

            Transaction transaction2 = session.beginTransaction();
            session.save(pracownik);
            transaction2.commit();
            System.out.println("Pracownik został dodany pomyślnie!");
        } catch (Exception e) {
            System.out.println("Błąd podczas dodawania pracownika lub adresu: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
