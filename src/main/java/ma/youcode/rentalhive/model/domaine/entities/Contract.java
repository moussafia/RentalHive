package ma.youcode.rentalhive.model.domaine.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.rentalhive.model.domaine.enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Contract {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
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
