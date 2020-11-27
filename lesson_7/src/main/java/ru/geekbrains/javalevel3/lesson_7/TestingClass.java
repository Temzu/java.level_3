package ru.geekbrains.javalevel3.lesson_7;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestingClass {
    public static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {
        int countAfter = 0;
        int countBefore = 0;
        Method before = null;
        Method after = null;
        Method[] allClassMethods = testClass.getMethods();
        for (Method method : allClassMethods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                before = method;
                if (++countAfter > 2)
                    throw new RuntimeException("Your class has more than one annotations: @AfterSuite");
            }
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                after = method;
                if (++countBefore > 2)
                    throw new RuntimeException("Your class has more than one annotations: @BeforeSuite");
            }
        }
        List<Method> annotatedMethods = findAnnotatedMethods(allClassMethods, Test.class);
        if (before != null) {
            before.invoke(null);
        }
        annotatedMethods.stream()
                .sorted((o1, o2) -> o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority())
                .forEach(method -> {
                    try {
                        method.invoke(null);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
        if (after != null) {
            after.invoke(null);
        }
    }

    public static List<Method> findAnnotatedMethods(Method[] methods, Class<? extends Annotation> annotationClass) {
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationClass)) {
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }

    public static void main(String[] args) {
        try {
            start(SomeClass.class);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
