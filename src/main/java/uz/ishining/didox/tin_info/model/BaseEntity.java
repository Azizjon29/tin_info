package uz.ishining.didox.tin_info.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
@EqualsAndHashCode
public class BaseEntity implements Serializable {

    public BaseEntity() {

    }

    @Id
    @SequenceGenerator(name = "pk_pr_sequence", sequenceName = "entity_id_seq_pr", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_pr_sequence")
    @Column(name = "ID")
    protected Long id;

    @Column(name = "CreatedAt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dcreated = new Date();

    @Column(name = "UpdatedAt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dmodified = new Date();

    @Column(name = "DeletedAt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date ddeleted;

}
