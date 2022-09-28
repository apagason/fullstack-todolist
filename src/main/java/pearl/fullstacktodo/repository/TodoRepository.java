package pearl.fullstacktodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pearl.fullstacktodo.entity.TodoListEntity;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public interface TodoRepository extends JpaRepository<TodoListEntity, BigInteger> {

    List<TodoListEntity> findAll();
    TodoListEntity findByTodoId(UUID id);

    @Transactional
    void deleteByTodoId(UUID id);
}
