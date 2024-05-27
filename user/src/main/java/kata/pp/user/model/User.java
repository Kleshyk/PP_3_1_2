package kata.pp.user.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String email;
}
