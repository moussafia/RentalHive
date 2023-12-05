package ma.youcode.rentalhive.model.domaine.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ma.youcode.rentalhive.model.domaine.enums.Status;

import javax.persistence.*;
import java.util.Set;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Location;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;
    private Float price;
    private String currency;
    @Enumerated(EnumType.STRING)
    private Status statusClient;
    @OneToOne(mappedBy = "reservation")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Contract contractClient;
}
