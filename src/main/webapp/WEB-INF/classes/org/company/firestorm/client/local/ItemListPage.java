package org.company.firestorm.client.local;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.company.firestorm.client.shared.Item;
import org.jboss.errai.ioc.client.container.IOCBeanManager;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.ui.Composite;

@Dependent
@Templated("#main")
@Page
public class ItemListPage extends Composite {

  @Inject private IOCBeanManager bm;
  @Inject private EntityManager em;

  @Inject private @DataField FooListWidget listWidget;
  @Inject private @DataField ItemForm newItemForm;

  @PostConstruct
  private void initInstance() {

    // clear the item form after an item is saved
    newItemForm.setAfterSaveAction(new Runnable() {
      @Override
      public void run() {
        newItemForm.setItem(new Item());
      }
    });
  }

}
