package bankdb;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "pozyczki")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pozyczka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pozyczka_id")
    private int pozyczkaId;

    @Column(name = "klient_id")
    private int klientId;

    @Column(name = "pracownik_id")
    private int pracownikId;

    @Column(name = "kwota")
    private double kwota;

    @Column(name = "okres_miesiecy")
    private int okresMiesiecy;

    @Column(name = "data_pozyczki")
    private java.sql.Date dataPozyczki;

    @Column(name = "rata_id")
    private int rataId;


    public Pozyczka(int klientId, int pracownikId, double kwota, int okresMiesiecy, java.sql.Date dataPozyczki, int rataId) {
        this.klientId = klientId;
        this.pracownikId = pracownikId;
        this.kwota = kwota;
        this.okresMiesiecy = okresMiesiecy;
        this.dataPozyczki = dataPozyczki;
        this.rataId = rataId;
    }
}
