package ma.sir.vaccination.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "quartier")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="quartier_seq",sequenceName="quartier_seq",allocationSize=1, initialValue = 1)
public class QuartierHistory extends HistBusinessObject  {


    public QuartierHistory() {
    super();
    }

    public QuartierHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="quartier_seq")
    public Long getId() {
    return id;
    }
}

