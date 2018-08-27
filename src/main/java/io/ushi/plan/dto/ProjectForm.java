package io.ushi.plan.dto;

import io.ushi.validation.group.Create;
import io.ushi.validation.group.Modify;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ProjectForm {

    @NotNull(groups = Modify.class)
    Long id;

    @NotEmpty(message = "{Project.title}{NotEmpty}", groups = Create.class)
    String title;

    Date start;

    Date end;

    String description;
}
