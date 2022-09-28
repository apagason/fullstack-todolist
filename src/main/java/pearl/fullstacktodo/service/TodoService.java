package pearl.fullstacktodo.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pearl.fullstacktodo.dto.TodoDTO;
import pearl.fullstacktodo.entity.TodoListEntity;
import pearl.fullstacktodo.model.Todo;
import pearl.fullstacktodo.repository.TodoRepository;
import pearl.fullstacktodo.util.DateTimeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {

    private final DateTimeUtil dateTimeUtil;
    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    public List<TodoDTO> addTodo(@NonNull String newTodo) {

        // Initialize new todo
        TodoListEntity todo = TodoListEntity.builder()
                .todoId(UUID.randomUUID())
                .todo(newTodo)
                .createdDate(dateTimeUtil.currentDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build();

        //save database
        todoRepository.save(todo);

        return getAllTodos();

    }

    public  List<TodoDTO> updateTodo(@NonNull Todo updatedTodo) {

        //Get To do Entity
        TodoListEntity oldTodo = todoRepository.findByTodoId(updatedTodo.getTodoId());

        // Check if todoId exist
        if (oldTodo == null) throw new RuntimeException("Todo doesn't exist.");

        // Update To do
        TodoListEntity newTodo = TodoListEntity.builder()
                .todoId(oldTodo.getTodoId())
                .todo(updatedTodo.getTodo())
                .createdDate(oldTodo.getCreatedDate())
                .modifiedDate(dateTimeUtil.currentDate())
                .build();

        // save to datatbase
        todoRepository.save(newTodo);

        return getAllTodos();

    }

    public List<TodoDTO> deleteTodo(UUID id) {
        // Get To do Entity
        TodoListEntity todo = todoRepository.findByTodoId(id);

        // Check if to do exist
        if(todo == null) throw new RuntimeException("Todo doesn't exist");

        // Delete to do
        todoRepository.deleteByTodoId(id);

        return getAllTodos();
    }

    public List<TodoDTO> getAllTodos() {
        List<TodoListEntity> allTodos = todoRepository.findAll(Sort.by(Sort.Direction.ASC,"createdDate"));
        List<TodoDTO> updatedList = new ArrayList<>();

        allTodos.forEach(data -> {
            updatedList.add(modelMapper.map(data, TodoDTO.class));
        });

        return updatedList;
    }
}
