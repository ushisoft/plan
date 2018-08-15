package io.ushi.plan.repository;

import io.ushi.plan.domain.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends CrudRepository<Task, Long> {

    /**
     * Query注解示例
     *
     * @param id
     * @return
     */
    @Query("select t from Task t where t.id=:id")
    Task findTask(@Param("id") Long id);
}
