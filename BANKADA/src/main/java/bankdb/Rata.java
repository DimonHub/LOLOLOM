package bankdb;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "raty")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rata_id")
    private int rataId;

    @Column(name = "pozyczka_id")
    private int pozyczkaId;

    @Column(name = "kwota_raty")
    private double kwotaRaty;

    @Column(name = "data_splaty")
    private Date dataSplaty;


    public void setCurrentDateAsDataSplaty() {
        this.dataSplaty = new Date(System.currentTimeMillis());
    }
}
