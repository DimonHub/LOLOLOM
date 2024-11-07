package bankdb;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "adresy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Adres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adres_id")
    private int adresId;

    @Column(name = "ulica")
    private String ulica;

    @Column(name = "miasto")
    private String miasto;

    @Column(name = "kod_pocztowy")
    private String kodPocztowy;

    @Column(name = "kraj")
    private String kraj;
}
