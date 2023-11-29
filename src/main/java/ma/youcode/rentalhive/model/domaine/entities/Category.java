package ma.youcode.rentalhive.model.domaine.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
@ToString(exclude = "equipment")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Equipment> equipment;

}
