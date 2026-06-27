public class Main {
    public static void main(String[] args) {
        Order[] orders = {
                new Order(101, "Alice", 2500.50),
                new Order(102, "Bob", 1000.00),
                new Order(103, "Charlie", 4000.75),
                new Order(104, "Diana", 1750.25)
        };

        System.out.println("Orders before Bubble Sort:");
        printOrders(orders);

        bubbleSort(orders);

        System.out.println("\nOrders after Bubble Sort:");
        printOrders(orders);

        Order[] quickSortOrders = {
                new Order(201, "Emma", 3200.00),
                new Order(202, "Farah", 900.50),
                new Order(203, "Grace", 4500.25),
                new Order(204, "Hina", 2100.00)
        };

        System.out.println("\nOrders before Quick Sort:");
        printOrders(quickSortOrders);

        quickSort(quickSortOrders, 0, quickSortOrders.length - 1);

        System.out.println("\nOrders after Quick Sort:");
        printOrders(quickSortOrders);
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
