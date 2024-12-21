package com.fitness.tracker.setup;

import java.io.File;
import java.io.IOException;

public class SetupDirectories {

    public static void main(String[] args) {
        String[] directories = {
                "src/main/java/com/fitness/tracker/model",
                "src/main/java/com/fitness/tracker/repository",
                "src/main/java/com/fitness/tracker/service",
                "src/main/java/com/fitness/tracker/controller",
                "src/main/resources",
                "src/test/java",
                "src/test/resources"
        };

        for (String dir : directories) {
            createDirectory(dir);
        }

        String[] files = {
                "src/main/resources/application.properties"
        };

        for (String file : files) {
            createFile(file);
        }

        System.out.println("Directory and file setup complete.");
    }

    private static void createDirectory(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created: " + path);
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }

    private static void createFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + path);
                } else {
                    System.out.println("Failed to create file: " + path);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists: " + path);
        }
    }
}
