package com.product.main;

import java.util.List;
import java.util.Scanner;

import com.product.dao.ProductDao;
import com.product.dao.ProductDaoImpl;
import com.product.dao.ReviewDao;
import com.product.dao.ReviewDaoImpl;
import com.product.model.Product;
import com.product.model.Review;

public class ProductReviewMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDao productDao = new ProductDaoImpl();
        ReviewDao reviewDao = new ReviewDaoImpl();

        System.out.println("Welcome to Product Review Application!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a Product");
            System.out.println("2. View All Products");
            System.out.println("3. Write a Review");
            System.out.println("4. View Product Reviews");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(scanner, productDao);
                    break;
                case 2:
                    viewAllProducts(productDao);
                    break;
                case 3:
                    writeReview(scanner, reviewDao);
                    break;
                case 4:
                    viewProductReviews(scanner, reviewDao);
                    break;
                case 0:
                    System.out.println("Thank you for using Product Review Application!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProduct(Scanner scanner, ProductDao productDao) {
        System.out.println("Enter the product name: ");
        String name = scanner.nextLine();

        System.out.println("Enter the product description: ");
        String description = scanner.nextLine();

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);

        productDao.create(product);
    }

    private static void viewAllProducts(ProductDao productDao) {
        List<Product> products = productDao.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void writeReview(Scanner scanner, ReviewDao reviewDao) {
        System.out.println("Enter the product ID for the review: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your name: ");
        String customerName = scanner.nextLine();

        System.out.println("Enter your rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your comment: ");
        String comment = scanner.nextLine();

        Review review = new Review();
        review.setProductId(productId);
        review.setCustomerName(customerName);
        review.setRating(rating);
        review.setComment(comment);

        reviewDao.create(review);
    }

    private static void viewProductReviews(Scanner scanner, ReviewDao reviewDao) {
        System.out.println("Enter the product ID to view reviews: ");
        int productId = scanner.nextInt();

        List<Review> reviews = reviewDao.getReviewsForProduct(productId);
        for (Review review : reviews) {
            System.out.println(review);
        }
    }
}
