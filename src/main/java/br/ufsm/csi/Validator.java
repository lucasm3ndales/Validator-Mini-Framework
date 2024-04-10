package br.ufsm.csi;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator<T> implements Validatable<T>{
    @Override
    public void validate(T obj) throws ValidationException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        List<String> errors = new ArrayList<>();

        for (Field field : fields) {

            if (field.isAnnotationPresent(NotNull.class)) {
                NotNull annotation = field.getAnnotation(NotNull.class);
                field.setAccessible(true);

                try {
                    Object value = field.get(obj);
                    if (value == null || value.toString().isEmpty() || value.toString().isBlank()) {
                        errors.add(annotation.message());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (field.isAnnotationPresent(Min.class)) {
                Min annotation = field.getAnnotation(Min.class);
                field.setAccessible(true);
                long annotationValue = annotation.value();
                try {
                    Object value = field.get(obj);

                    if (value instanceof Long && (Long) value < annotationValue) {
                        errors.add(annotation.message());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (field.isAnnotationPresent(Max.class)) {
                Max annotation = field.getAnnotation(Max.class);
                field.setAccessible(true);
                long annotationValue = annotation.value();

                try {
                    Object value = field.get(obj);
                    if (value instanceof Long && (Long) value > annotationValue) {
                        errors.add(annotation.message());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (field.isAnnotationPresent(Size.class)) {
                Size annotation = field.getAnnotation(Size.class);
                field.setAccessible(true);
                long min = annotation.min();
                long max = annotation.max();


                try {
                    Object value = field.get(obj);
                    if (Array.getLength(value) < min || Array.getLength(value) > max) {
                        errors.add(annotation.message());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (field.isAnnotationPresent(Lenght.class)) {
                Lenght annotation = field.getAnnotation(Lenght.class);
                field.setAccessible(true);
                long min = annotation.min();
                long max = annotation.max();


                try {
                    Object value = field.get(obj);
                    if (value.toString().length() < min || value.toString().length() > max) {
                        errors.add(annotation.message());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (field.isAnnotationPresent(Validate.class)) {
                Validate annotation = field.getAnnotation(Validate.class);
                field.setAccessible(true);

                if (!errors.isEmpty()) {
                    throw new ValidationException(annotation.message() + " " + errors);
                }
            }
        }
    }
}
