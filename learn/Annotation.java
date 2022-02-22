package learn;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
// @Repeatable(Annotations.class)
@Inherited
public @interface Annotation {
    int type() default 0;
    String level() default "info";
    String value() default "";

}

@Target(ElementType.TYPE)
@interface Annotations {
    Report[] value();
}