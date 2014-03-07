package org.company.firestorm.client.local.convert;

import org.jboss.errai.databinding.client.api.Converter;
import org.company.firestorm.client.shared.User;

public class UsernameConverter implements Converter<User, String>{

  @Override
  public User toModelValue(String widgetValue) {
    throw new UnsupportedOperationException("This converter only supports Model->Widget mappings");
  }

  @Override
  public String toWidgetValue(User modelValue) {
    return modelValue == null ? "" : modelValue.getName();
  }

}