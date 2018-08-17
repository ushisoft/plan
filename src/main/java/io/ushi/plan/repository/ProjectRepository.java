package io.ushi.plan.repository;

import io.ushi.plan.domain.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * 项目相关数据库操作
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {

}
