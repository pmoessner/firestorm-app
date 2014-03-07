package org.company.firestorm.client.shared.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * CDI Qualifier to indicate the qualified bean instance has been updates (that
 * is, it was already persistent but it has just been modified).
 */
@Qualifier
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Updated {

}