package io.ushi.plan.dto;

import io.ushi.plan.domain.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mappings({
            @Mapping(target = "createdTime", source = "end")
    })
    Project from(ProjectDTO projectDTO);
}
