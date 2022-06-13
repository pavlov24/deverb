package pavlov24.deverb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String germany;
    private String russian;

    @ManyToOne
    @JsonIgnore
    protected Verb verb;
}
