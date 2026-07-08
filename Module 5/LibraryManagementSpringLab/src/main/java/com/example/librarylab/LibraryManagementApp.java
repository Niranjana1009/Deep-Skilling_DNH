package com.example.librarylab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LibraryManagementApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            LibraryService service = context.getBean(LibraryService.class);
            service.addBook("Spring Core Basics");
            service.addBook("Dependency Injection Guide");
            service.addBook("AOP Logging Example");

            System.out.println("Library books:");
            for (String title : service.getBooks()) {
                System.out.println("- " + title);
            }
        }
    }
}
