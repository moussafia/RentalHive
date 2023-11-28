package ma.youcode.rentalhive.model.domaine.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user_name;
    @Column(unique = true)
    private String Email;
    private String password;
    @ManyToOne
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Reservation> Reservation;
}
