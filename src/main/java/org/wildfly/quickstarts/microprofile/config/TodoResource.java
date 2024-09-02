package org.wildfly.quickstarts.microprofile.config;

import java.util.List;

import org.wildfly.quickstarts.microprofile.config.model.Todo;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/todo")
public class TodoResource {

    @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = "primary")
    private EntityManager em;

    @Inject
    private UserTransaction tx;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getValue() {
        return this.em.createQuery("Select todo From Todo todo", Todo.class).getResultList();
    }

    @POST
    @Transactional
    public void save(String title) {

        Todo todo = new Todo();
        todo.setTitle(title);
        this.em.persist(todo);
    }

}
