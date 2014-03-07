package org.company.firestorm.client.shared.qual;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * CDI Qualifier to indicate the qualified bean instance is new (that is, has
 * just been removed from the application's persistence layer).
 */
@Qualifier
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Removed {

}
