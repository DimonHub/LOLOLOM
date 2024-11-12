package bankdb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "raty")
public class Rata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rata_id")
    private int rataId;

    @ManyToOne
    @JoinColumn(name = "pozyczka_id", referencedColumnName = "pozyczka_id", insertable = false, updatable = false)
    private Pozyczki pozyczka;

    @Column(name = "kwota_raty")
    private double kwotaRaty;

    @Column(name = "data_splaty")
    private LocalDate dataSplaty;

    @Column(name = "status_splaty")
    private String statusSplaty;

    @Column(name = "procent")
    private double procent;
}
