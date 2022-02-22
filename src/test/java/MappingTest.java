import com.blinikar.akvelon.API.projects.ProjectDTO;
import com.blinikar.akvelon.API.tasks.TaskDTO;
import com.blinikar.akvelon.database.projects.Project;
import com.blinikar.akvelon.database.tasks.Task;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MappingTest {

    private final ModelMapper mapper = new ModelMapper();

    @Test
    public void whenMappingsValidatedExpectValid() {
        mapper.createTypeMap(Project.class, ProjectDTO.class);
        mapper.createTypeMap(Task.class, TaskDTO.class);
        assertDoesNotThrow(mapper::validate);
    }

    /*@Test
    public void whenConvertedToDtoExpectValid() {
        List<Task> tasks = new ArrayList<>();
        Date completionDate = new Date();

        Project project = new Project();

        project.setId(10L);
        project.setName("Cool project");
        project.setTasks(tasks);
        project.setCompletionDate(completionDate);

        ProjectDTO dto = mapper.map(project, ProjectDTO.class);

        assertEquals(project.getName(), dto.getName());
        assertEquals(project.getId(), dto.getId());
        assertEquals(project.getCompletionDate(), dto.getCompletionDate());
        assertEquals(project.getTasksIds(), dto.getTasksIds());

        project = mapper.map(dto, Project.class);

        assertEquals(project.getName(), dto.getName());
        assertEquals(project.getId(), dto.getId());
        assertEquals(project.getCompletionDate(), dto.getCompletionDate());
        assertEquals(project.getTasksIds(), dto.getTasksIds());
    }*/

}
