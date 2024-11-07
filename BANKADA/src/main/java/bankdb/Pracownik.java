package bankdb;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "pracownicy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pracownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pracownik_id")
    private int pracownikId;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "data_zatrudnienia")
    private java.sql.Date dataZatrudnienia;

    @Column(name = "adres_id")
    private int adresId;


    public Pracownik(String imie, String nazwisko, String pesel, java.sql.Date dataZatrudnienia, int adresId) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.dataZatrudnienia = dataZatrudnienia;
        this.adresId = adresId;
    }
}

