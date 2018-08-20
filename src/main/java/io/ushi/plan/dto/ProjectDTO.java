package io.ushi.plan.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class ProjectDTO {

    @NotEmpty(message = "{project.title.empty}")
    String title;

    Date start;

    Date end;

    String description;
}
