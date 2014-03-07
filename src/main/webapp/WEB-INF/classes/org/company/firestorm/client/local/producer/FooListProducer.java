package org.company.firestorm.client.local.producer;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.company.firestorm.client.shared.FooList;
import org.company.firestorm.client.shared.User;

@ApplicationScoped
public class FooListProducer {

  @Produces @ApplicationScoped
  private FooList getGroceryList(final EntityManager em, final User user) {
    final TypedQuery<FooList> q = em.createNamedQuery("groceryListsForUser", FooList.class);
    q.setParameter("user", user);
    final List<FooList> groceryLists = q.getResultList();

    final FooList gl;
    if (groceryLists.isEmpty()) {
      gl = new FooList();
      gl.setOwner(user);
      em.persist(gl);
      em.flush();
    }
    else {
      gl = groceryLists.get(0);
    }

    return gl;
  }

}
