package bankdb;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "klient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "klient_id")
    private int klientId;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "data_urodzenia")
    private java.sql.Date dataUrodzenia;


    public Klient(String imie, String nazwisko, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }


    public Klient(String imie, String nazwisko, String pesel, java.sql.Date dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
    }
}


