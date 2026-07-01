public class SearchTest {

    // Linear Search
    public static Product linearSearch(Product[] products, int id) {

        for (Product product : products) {
            if (product.productId == id) {
                return product;
            }
        }

        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int id) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (products[mid].productId == id) {
                return products[mid];
            }

            if (products[mid].productId < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Bag", "Fashion")
        };

        Product result1 = linearSearch(products, 103);

        if (result1 != null)
            System.out.println("Linear Search Found: " + result1.productName);

        Product result2 = binarySearch(products, 104);

        if (result2 != null)
            System.out.println("Binary Search Found: " + result2.productName);

        System.out.println();
        System.out.println("Time Complexity");
        System.out.println("Linear Search : O(n)");
        System.out.println("Binary Search : O(log n)");

    }

}