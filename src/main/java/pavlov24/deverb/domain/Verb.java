package pavlov24.deverb.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
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
    protected Set<Category> categories = new HashSet<>();


}
