package br.ufsm.csi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Validate {
    String message() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
    @interface NotNull {
    String message() default "Field is null!";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Min {
    long value() default 0;
    String message() default "Value is too small!";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Max {
    long value() default 0;
    String message() default "Value is too big!";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Size {
    long min() default 0;
    long max() default 255;
    String message() default "Size of field is inválid!";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Lenght {
    long min() default 0;
    long max() default 255;
    String message() default "Lenght of field is inválid!";
}

public interface Validatable<T> {
    void validate(T obj) throws ValidationException;
}
