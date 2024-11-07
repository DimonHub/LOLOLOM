package bankdb;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "konta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Konto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "konto_id")
    private int kontoId;

    @Column(name = "klient_id")
    private int klientId;

    @Column(name = "waluta")
    private String waluta;

    @Column(name = "saldo")
    private double saldo;

    @Column(name = "data_otwarcia")
    private java.sql.Date dataOtwarcia;


    public Konto(int klientId, String waluta, double saldo, java.sql.Date dataOtwarcia) {
        this.klientId = klientId;
        this.waluta = waluta;
        this.saldo = saldo;
        this.dataOtwarcia = dataOtwarcia;
    }
}
