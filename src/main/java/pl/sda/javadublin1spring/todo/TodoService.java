package pl.sda.javadublin1spring.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    public TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public Todo findById(Long id) {
        if (id == null || id <= 0){
            throw new IllegalArgumentException(id + " is invalid");
        }
        return todoRepository.findById(id).orElseThrow(()-> new TodoNotFoundException(id));
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }


    public List<Todo> findByStatus(TodoStatus status) {
        return todoRepository.findByStatus(status) ;
    }
}
