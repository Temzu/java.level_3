package ru.geekbrains.javalevel3.lesson_7;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class TeacherHelper {
    public static void main(String[] args) {
        try {
            searchClassFiles("E:\\dz");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchClassFiles(String path) throws Exception {
        File file = new File(path);
        String[] files = file.list();
        if (files == null) throw new NullPointerException("В данной папке нет файлов с типом class.");
        List<String> classFiles = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String[] arr = files[i].split("\\.");
            if (arr[1].equals("class")) {
                classFiles.add(arr[0]);
            }
        }

        for (String classFile : classFiles) {
            String className = String.valueOf(classFile);
            ClassLoader classLoader = new URLClassLoader(new URL[]{new File(path).toURL()});
            Class cl = classLoader.loadClass(className);
            Constructor constructor = cl.getConstructor();
            Object con = constructor.newInstance();
            Method method = cl.getDeclaredMethod("isLeapYearOrNot", int.class);
            String string = (String) method.invoke(con, 2020);
            System.out.println(string);

            //and another methods
        }
    }
}
