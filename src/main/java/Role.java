import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    @Column(name = "role")
    private String role;
    @Column(name = "update_date")
    private LocalDateTime dateTimeUpdate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Persons> personsList;

    public Role() {
        this.role = role;
        this.dateTimeUpdate = LocalDateTime.now();
    }

    public String getRole() {
        return this.role = role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getDateTimeUpdate() {
        return dateTimeUpdate;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", role='" + role + '\'' +
                ", dateTimeUpdate=" + dateTimeUpdate +
                ", usersList=" + personsList +
                '}';
    }
}