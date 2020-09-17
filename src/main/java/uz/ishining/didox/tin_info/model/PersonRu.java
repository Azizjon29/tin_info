package uz.ishining.didox.tin_info.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PERSON_RU", uniqueConstraints = {
        @UniqueConstraint(columnNames={"tin"})
})
@Data
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PERSON_TYPE",
        discriminatorType = DiscriminatorType.STRING)
public class PersonRu extends BaseEntity{

    protected String tin;

    protected Integer ns10Code;

    protected Integer ns11Code;

    protected String address;


}
