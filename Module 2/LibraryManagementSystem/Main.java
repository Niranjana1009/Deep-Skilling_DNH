import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
                new Book(101, "Java Basics", "Alice"),
                new Book(102, "Data Structures", "Bob"),
                new Book(103, "Algorithms", "Charlie"),
                new Book(104, "Operating Systems", "Diana")
        };

        Arrays.sort(books, (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));

        Book result1 = linearSearch(books, "Algorithms");
        System.out.println("Linear Search Result:");
        if (result1 != null) {
            System.out.println(result1);
        } else {
            System.out.println("Book not found.");
        }

        Book result2 = binarySearch(books, "Data Structures");
        System.out.println("\nBinary Search Result:");
        if (result2 != null) {
            System.out.println(result2);
        } else {
            System.out.println("Book not found.");
        }
    }

    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String targetTitle) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return books[mid];
            }

            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}
