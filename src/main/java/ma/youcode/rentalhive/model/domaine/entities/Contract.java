package ma.youcode.rentalhive.model.domaine.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ma.youcode.rentalhive.model.domaine.enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(exclude = "pictureEquipments")
public class Contract {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Reservation reservation;
    private String terms;
    private String conditions;
    private Float price;
    private LocalDateTime dateContract;
    @Enumerated(EnumType.STRING)
    private Status statusAdmin;
    @OneToMany(mappedBy = "contract")
    private List<PictureEquipment> pictureEquipments;
}
