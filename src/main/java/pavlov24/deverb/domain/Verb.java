package pavlov24.deverb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Verb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;
    private boolean isReflex;
    private VerbType verbType;

    private String participleII; // partizip II
    private String pastTense; // präteritum

    private String translate;
    private String image;

    @ManyToMany(mappedBy = "verbs")
    @ToString.Exclude
    protected Set<Category> categories = new HashSet<>();

    @OneToOne(mappedBy = "verb")
    @ToString.Exclude
    protected Statistics statistics;

    private String children;

    @OneToMany(mappedBy = "verb")
    @ToString.Exclude
    private Set<Example> examples;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinTable(
            name = "CLIENT_VERB",
            inverseJoinColumns = @JoinColumn(name = "CLIENT_ID"),
            joinColumns = @JoinColumn(name = "VERB_ID")
    )
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    protected Set<Client> followers = new HashSet<>();

    public void addFollower(Client client) {
        this.getFollowers().add(client);
        client.getVerbs().add(this);
    }

    public void removeFollower(Client client) {
        this.getFollowers().remove(client);
        client.getVerbs().remove(this);
    }
}
