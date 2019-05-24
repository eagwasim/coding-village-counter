package de.vermietet.vvecrm.infrastructure.persistence.jpaentities;

import de.vermietet.vvecrm.infrastructure.persistence.enumeration.EntityStatusConstant;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@ToString
@MappedSuperclass
@EnableJpaAuditing
public abstract class AbstractJpaEntity<T extends Serializable> {
    private static final long serialVersionUID = -5554308939380869754L;

    @Id
    private T id;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime dateCreated;
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime dateModified;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EntityStatusConstant status = EntityStatusConstant.ACTIVE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractJpaEntity<?> that = (AbstractJpaEntity<?>) o;

        return Objects.equals(id, that.id);
    }

    @PrePersist
    @PreUpdate
    public void prePersist() {
        if (dateCreated == null) {
            dateCreated = LocalDateTime.now();
        }

        dateModified = LocalDateTime.now();
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

