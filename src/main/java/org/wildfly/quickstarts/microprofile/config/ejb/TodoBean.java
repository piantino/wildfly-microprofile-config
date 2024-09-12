package org.wildfly.quickstarts.microprofile.config.ejb;

import org.wildfly.quickstarts.microprofile.config.dto.TodoDto;
import org.wildfly.quickstarts.microprofile.config.model.Todo;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class TodoBean {

    @PersistenceContext
    private EntityManager em;

    public void update(TodoDto todoDto) {
        Todo todo = this.em.find(Todo.class, todoDto.getId());
        todo.setTitle(todoDto.getTitle());
        this.em.persist(todo);
    }

}
