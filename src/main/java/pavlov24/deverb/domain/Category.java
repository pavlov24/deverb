package pavlov24.deverb.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Table
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CATEGORY_VERB",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "VERB_ID")
    )
    @JsonIgnore
    protected Set<Verb> verbs = new HashSet<>();

    private String name;

    public Category (String name) {
        this.name = name;
        this.id = 0L;
    }
}
