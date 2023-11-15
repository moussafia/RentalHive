package ma.youcode.rentalhive.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adresse;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private Float prix_calculer;
    @ManyToOne
    private User user;
    @OneToOne(mappedBy = "demande")
    private Contract contract;

}
