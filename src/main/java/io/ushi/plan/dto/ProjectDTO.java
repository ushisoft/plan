package io.ushi.plan.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectDTO {

    String title;

    Date start;

    Date end;

    String description;
}
