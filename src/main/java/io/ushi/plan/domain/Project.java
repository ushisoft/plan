package io.ushi.plan.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Project {

    @Id
    @SequenceGenerator(name="project_id_seq", sequenceName="project_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="project_id_seq")
    Long id;

    String title;

    Date start;

    Date end;

    String description;

    @CreatedDate
    Date createdTime;

    @CreatedBy
    Long createdBy;

    @LastModifiedDate
    Date lastmodifiedTime;

    @LastModifiedBy
    Long lastmodifiedBy;

    @PrePersist
    public void onPrePersist() {
        System.out.println(this);
    }

    @PreUpdate
    public void onPreUpdate() {

    }

    @PreRemove
    public void onPreRemove() {

    }
}
