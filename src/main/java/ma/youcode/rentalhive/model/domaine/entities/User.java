package ma.youcode.rentalhive.model.domaine.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Builder
@ToString(exclude = "Reservation")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user_name;
    @Column(unique = true)
    private String Email;
    private String password;
    @ManyToOne
    @JsonIgnoreProperties("user")
    private Role role;
    @OneToMany(mappedBy = "user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Reservation> reservation;
}
