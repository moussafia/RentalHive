package ma.youcode.rentalhive.model.domaine.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class PictureEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String picture;
    @ManyToOne
    private Contract contract;

}
