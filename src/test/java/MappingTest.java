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
    public void mappingValidation() {
        mapper.createTypeMap(Project.class, ProjectDTO.class);
        mapper.createTypeMap(Task.class, TaskDTO.class);
        assertDoesNotThrow(mapper::validate);
    }
}
