import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Accessories"),
                new Product(103, "Keyboard", "Accessories"),
                new Product(104, "Monitor", "Electronics"),
                new Product(105, "Printer", "Office")
        };

        System.out.println("Linear Search Result:");
        Product result1 = linearSearch(products, 104);
        if (result1 != null) {
            System.out.println(result1);
        } else {
            System.out.println("Product not found.");
        }

        Product[] sortedProducts = products.clone();
        sortByProductId(sortedProducts);

        System.out.println("\nBinary Search Result:");
        Product result2 = binarySearch(sortedProducts, 104);
        if (result2 != null) {
            System.out.println(result2);
        } else {
            System.out.println("Product not found.");
        }
    }

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == targetId) {
                return products[mid];
            }

            if (products[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void sortByProductId(Product[] products) {
        Arrays.sort(products, (a, b) -> Integer.compare(a.getProductId(), b.getProductId()));
    }
}
