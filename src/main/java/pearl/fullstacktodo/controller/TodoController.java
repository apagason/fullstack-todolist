package pearl.fullstacktodo.controller;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pearl.fullstacktodo.dto.TodoDTO;
import pearl.fullstacktodo.model.Todo;
import pearl.fullstacktodo.service.TodoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PutMapping("/addTodo/{newTodo}")
    public List<TodoDTO> addTodo(@PathVariable @NonNull String newTodo) {
        return todoService.addTodo(newTodo);
    }

    @PostMapping("/updateTodo")
    public List<TodoDTO> updateTodo(@RequestBody @NonNull Todo updatedTodo) {
        return todoService.updateTodo(updatedTodo);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public List<TodoDTO> deleteTodo(@PathVariable UUID id) {
        return todoService.deleteTodo(id);
    }

    @GetMapping("/getAll")
    public List<TodoDTO> getAllTodo() {
        return todoService.getAllTodos();
    }

}
