package org.company.firestorm.client.local;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import org.company.firestorm.client.shared.FooList;
import org.company.firestorm.client.shared.Item;
import org.jboss.errai.ui.client.widget.ListWidget;

public class FooListWidget extends ListWidget<Item, FooItemWidget> {

  @Inject
  private FooList model;

  @SuppressWarnings("unused")
  private void onModelChange(@Observes @Any Item gl) {
    /* XXX This is imprecise. We don't even know if the affected item is in the
     * grocery list this widget wraps. This should be finer-grained (different
     * cases for new, updated, removed) or the GroceryList class could do something fancy.
     */
    refresh();
  }

  @PostConstruct
  void refresh() {
    setItems(model.getItems());
  }

  @Override
  public Class<FooItemWidget> getItemWidgetType() {
    return FooItemWidget.class;
  }
}
