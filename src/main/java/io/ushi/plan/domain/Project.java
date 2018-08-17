package io.ushi.plan.domain;

import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Entity
public class Project {

    @Id
    @SequenceGenerator(name="project_id_seq", sequenceName="project_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="project_id_seq")
    Long id;

    String title;

    Date start;

    Date end;

    String description;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", description='" + description + '\'' +
                '}';
    }
}
