package ru.mirea.school.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.mirea.school.models.TeachingProgram;

public interface TeachingProgramRepository extends CrudRepository<TeachingProgram, Long> {

    @Query("SELECT u FROM TeachingProgram u WHERE u.Id = :Id")
    public TeachingProgram getTeachingProgramById(@Param("Id") Long Id);

    @Query("SELECT u FROM TeachingProgram u WHERE u.title = :title")
    public TeachingProgram getTeachingProgramByTitle(@Param("title") String title);
}
