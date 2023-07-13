package oracleexample.oracledatabase.Entity.AbsEntities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createAt;

    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp updateAt;

    @CreatedBy
    @Column(updatable = false)
    private UUID creatBy;

    @LastModifiedBy
    private UUID updateBy;

    public AbsEntity(Integer id) {
        this.id = id;
    }
}
