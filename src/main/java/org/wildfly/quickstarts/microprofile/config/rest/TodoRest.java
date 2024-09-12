package org.wildfly.quickstarts.microprofile.config.rest;

import java.util.List;

import org.wildfly.quickstarts.microprofile.config.dto.TodoDto;
import org.wildfly.quickstarts.microprofile.config.ejb.TodoBean;
import org.wildfly.quickstarts.microprofile.config.model.Todo;

import jakarta.ejb.EJB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/todo")
public class TodoRest {

    @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = "primary")
    private EntityManager em;

    @EJB
    private TodoBean todoBean;

    /**
     * Sem EJB
     * 
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getValue() {
        return this.em.createQuery("Select todo From Todo todo", Todo.class).getResultList();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    /**
     * Sem EJB
     * 
     * @param title
     */
    public void save(TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        this.em.persist(todo);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(TodoDto todoDto) {
        this.todoBean.update(todoDto);
    }

}
