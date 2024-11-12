package bankdb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pozyczki")
public class Pozyczki {

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
    private LocalDate dataPozyczki;

    @OneToMany(mappedBy = "pozyczka", cascade = CascadeType.ALL)
    private List<Rata> raty;


    public void setRaty(List<Rata> raty) {
        this.raty = raty;
    }
}
