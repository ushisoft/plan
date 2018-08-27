package io.ushi.plan.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class ProjectForm {

    @NotEmpty(message = "{Project.title}{NotEmpty}")
    @Length(max = 10) // for test
    String title;

    Date start;

    Date end;

    String description;
}
