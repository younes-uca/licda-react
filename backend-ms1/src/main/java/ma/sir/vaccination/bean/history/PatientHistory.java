package ma.sir.vaccination.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.vaccination.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "patient")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="patient_seq",sequenceName="patient_seq",allocationSize=1, initialValue = 1)
public class PatientHistory extends HistBusinessObject  {


    public PatientHistory() {
    super();
    }

    public PatientHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="patient_seq")
    public Long getId() {
    return id;
    }
}

