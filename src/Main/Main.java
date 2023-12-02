package Main;

import Entity.*;
import Methods.*;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("Main Menu");
        while (true) {
            System.out.println("""
                    Select table to perform actions
                    1.books table
                    2.authors table
                    3.customers table
                    4.orders table
                    5.booksinformation table
                    6.ordersinformation table
                    7.Exit from application""");
            int option = sc.nextInt();
            if (option == 1) {
                bookMenu();
            }
            if (option == 2) {
                authorMenu();
            }
            if (option == 3) {
                customerMenu();
            }
            if (option == 4) {
                orderMenu();
            }
            if (option == 5) {
                bookInformationMenu();
            }
            if (option == 6) {
                orderInformationMenu();
            }
            if (option == 7) {
                exitApplication();
            }
        }
    }

    public static void bookMenu() {
        System.out.println("""
                Books table
                1.Insert new book
                2.Retrieve all books
                3.Get book by book_id
                4.Update book
                5.Delete book
                6.Back to choices menu
                            """);
        System.out.print("Choose what to do: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            System.out.print("Book_id: ");
            int book_id = sc.nextInt();
            sc.nextLine();
            System.out.print("Title: ");
            String title = sc.nextLine();
            System.out.print("Genre: ");
            String genre = sc.nextLine();
            System.out.print("Price: ");
            int price = sc.nextInt();
            System.out.print("Stock: ");
            int stock = sc.nextInt();
            Books book = new Books(book_id, title, genre, price, stock);
            BooksMethod.addBooks(book);
            bookMenu();
        }
        if (choice == 2) {
            List<Books> books = BooksMethod.getAllBooks();
            if (books.size() == 0) {
                System.out.println("No record found");
            }
            bookMenu();
        }
        if (choice == 3) {
            System.out.print("Enter the id of the book you want to get: ");
            int book_id = sc.nextInt();
            Books books = BooksMethod.getBookById(book_id);
            bookMenu();
        }
        if (choice == 4) {
            System.out.print("Enter the id of the book you want to update: ");
            int book_id = sc.nextInt();
            sc.nextLine();
            Books book = BooksMethod.getBookById(book_id);
            if (book == null) {
                bookMenu();
            }

            System.out.println("Enter new values to fields you want to update");
            System.out.print("New title: ");
            String title = sc.nextLine();
            System.out.print("New genre: ");
            String genre = sc.nextLine();
            System.out.print("New price: ");
            int price = sc.nextInt();
            System.out.print("New stock: ");
            int stock = sc.nextInt();

            book.setTitle(title);
            book.setGenre(genre);
            book.setPrice(price);
            book.setStock(stock);

            BooksMethod.updateBooks(book);
            bookMenu();
        }
        if (choice == 5) {
            System.out.print("Enter the id of book you want to delete: ");
            int book_id = sc.nextInt();
            Books book = BooksMethod.getBookById(book_id);
            if ( book == null) {
                bookMenu();
            }
            BooksMethod.deleteBooks(book_id);
            bookMenu();
        }

        if (choice == 6) {
            mainMenu();
        }
    }

    public static void authorMenu() {
        System.out.println("""
                Authors table
                1.Insert new author
                2.Retrieve all authors
                3.Get author by author_id
                4.Update author
                5.Delete author
                6.Back to choices menu
                            """);
        System.out.print("Choose what to do: ");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("author_id: ");
            int author_id = sc.nextInt();
            sc.nextLine();
            System.out.print("author_name: ");
            String author_name = sc.nextLine();
            AuthorsMethod.addAuthors(new Authors(author_id, author_name));
            authorMenu();
        }
        if (choice == 2) {
            List<Authors> authors = AuthorsMethod.getAllAuthors();
            if (authors.size() == 0) {
                System.out.println("No record found");
            }
            authorMenu();
        }
        if (choice == 3) {
            System.out.print("Enter the id of the author you want to get: ");
            int author_id = sc.nextInt();
            Authors author = AuthorsMethod.getAuthorById(author_id);
            if(author == null){
                System.out.println("No author found");
            }
            authorMenu();
        }
        if (choice == 4) {
            System.out.print("Enter the id of the author you want to update: ");
            int author_id = sc.nextInt();
            sc.nextLine();
            Authors author = AuthorsMethod.getAuthorById(author_id);
            if (author == null) {
                System.out.println("No author found");
                authorMenu();
            }
            System.out.println("Enter new values to fields you want to update");
            System.out.print("New author_name: ");
            String author_name = sc.nextLine();
            author.setAuthor_name(author_name);
            AuthorsMethod.updateAuthors(author);
            authorMenu();
        }
        if (choice == 5) {
            System.out.print("Enter the id of author you want to delete: ");
            int author_id = sc.nextInt();
            Authors author = AuthorsMethod.getAuthorById(author_id);
            if (author == null) {
                System.out.println("No author found");
                authorMenu();
            }
            AuthorsMethod.deleteAuthors(author_id);
            authorMenu();
        }

        if (choice == 6) {
            mainMenu();
        }
    }

    public static void bookInformationMenu() {
        System.out.println("""
                bookinformation table
                1.Insert new book information
                2.Retrieve all book information
                3.Get all book information by book_id
                4.Update book information
                5.Delete book information
                6.Back to choices menu
                            """);
        System.out.print("Choose what to do: ");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("book_id: ");
            int book_id = sc.nextInt();
            System.out.print("author_id: ");
            int author_id = sc.nextInt();
            BooksInformationMethod.addBooksInformation(new BooksInformation(book_id, author_id));
            bookInformationMenu();
        }
        if (choice == 2) {
            List<BooksInformation> BooksInformation = BooksInformationMethod.getAllBooksInformation();
            if (BooksInformation.size() == 0) {
                System.out.println("No record found");
            }
            bookInformationMenu();
        }
        if (choice == 3) {
            System.out.print("Enter the id of the book you want to get: ");
            int book_id = sc.nextInt();
            List<BooksInformation> booksInformation = BooksInformationMethod.getAllBooksInformationById(book_id);
            if (booksInformation.size() == 0) {
                System.out.println("No book information found");
            }
            bookInformationMenu();
        }
        if (choice == 4) {
            System.out.print("Enter the id of the book you want to update: ");
            int book_id = sc.nextInt();
            System.out.print("Enter the id of the author you want to update: ");
            int author_id = sc.nextInt();
            BooksInformation booksInformation = BooksInformationMethod.getBooksInformationById(book_id, author_id);
            if (booksInformation == null) {
                System.out.println("No book information found");
                bookInformationMenu();
            }
            System.out.println("Enter new values to fields you want to update");
            System.out.print("New author_id: ");
            int update_author_id = sc.nextInt();
            booksInformation.setAuthor_id(update_author_id);
            BooksInformationMethod.updateBooksInformation(booksInformation);
            bookInformationMenu();
        }
        if (choice == 5) {
            System.out.print("Enter the id of book you want to delete: ");
            int book_id = sc.nextInt();
            System.out.print("Enter the id of author you want to delete: ");
            int author_id = sc.nextInt();
            BooksInformation booksInformation = BooksInformationMethod.getBooksInformationById(book_id, author_id);
            if (booksInformation == null) {
                System.out.println("No book information found");
                bookInformationMenu();
            }
            BooksInformationMethod.deleteBooksInformation(book_id, author_id);
            bookInformationMenu();
        }

        if (choice == 6) {
            mainMenu();
        }
    }

    public static void customerMenu() {
        System.out.println("""
                Customers table
                1.Insert new customer
                2.Retrieve all customers
                3.Get customer by customer_id
                4.Update customer
                5.Delete customer
                6.Back to choices menu
                            """);
        System.out.print("Choose what to do: ");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("customer_id: ");
            int customer_id = sc.nextInt();
            sc.nextLine();
            System.out.print("customer_name: ");
            String customer_name = sc.nextLine();
            System.out.print("customer address: ");
            String address = sc.nextLine();
            System.out.print("customer email: ");
            String email = sc.nextLine();
            CustomerMethod.addCustomer(new Customer(customer_id, customer_name, address, email));
            customerMenu();
        }
        if (choice == 2) {
            List<Customer> Customer = CustomerMethod.getAllCustomer();
            if (Customer.size() == 0) {
                System.out.println("No record found");
            }
            customerMenu();
        }
        if (choice == 3) {
            System.out.print("Enter the id of the customer you want to get: ");
            int customer_id = sc.nextInt();
            Customer customer = CustomerMethod.getCustomerById(customer_id);
            if (customer == null) {
                System.out.println("No customer found");
            }
            customerMenu();
        }
        if (choice == 4) {
            System.out.print("Enter the id of the customer you want to update: ");
            int customer_id = sc.nextInt();
            sc.nextLine();
            Customer customer = CustomerMethod.getCustomerById(customer_id);
            if (customer == null) {
                System.out.println("No customer found");
                customerMenu();
            }
            System.out.println("Enter new values to fields you want to update");
            System.out.print("New customer_name: ");
            String customer_name = sc.nextLine();
            System.out.print("New address: ");
            String address = sc.nextLine();
            System.out.print("New email: ");
            String email = sc.nextLine();
            customer.setCustomer_name(customer_name);
            customer.setAddress(address);
            customer.setEmail(email);
            CustomerMethod.updateCustomer(customer);
            customerMenu();
        }
        if (choice == 5) {
            System.out.print("Enter the id of customer you want to delete: ");
            int customer_id = sc.nextInt();
            Customer customer = CustomerMethod.getCustomerById(customer_id);
            if (customer == null) {
                System.out.println("No customer found");
                customerMenu();
            }
            CustomerMethod.deleteCustomer(customer_id);
            customerMenu();
        }

        if (choice == 6) {
            mainMenu();
        }
    }

    public static void orderInformationMenu() {
        System.out.println("""
                orderinformation table
                1.Insert new order information
                2.Retrieve all order information
                3.Get all order information by order_id
                4.Update order information
                5.Delete order information
                6.Back to choices menu
                            """);
        System.out.print("Choose what to do: ");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("order_id: ");
            int order_id = sc.nextInt();
            System.out.print("book_id: ");
            int book_id = sc.nextInt();
            System.out.println("Ordered books: ");
            int ordered_books = sc.nextInt();
            OrderInformationMethod.addOrderInformation(new OrderInformation(order_id, book_id, ordered_books));
            orderInformationMenu();
        }
        if (choice == 2) {
            List<OrderInformation> OrderInformation = OrderInformationMethod.getAllOrderInformation();
            if (OrderInformation.size() == 0) {
                System.out.println("No record found");
            }
            orderInformationMenu();
        }
        if (choice == 3) {
            System.out.print("Enter the id of the order you want to get: ");
            int order_id = sc.nextInt();
            List<OrderInformation> orderInformation = OrderInformationMethod.getAllOrderInformationById(order_id);
            if(orderInformation.size() == 0){
                System.out.println("No order information found");
            }
            orderInformationMenu();
        }
        if (choice == 4) {
            System.out.print("Enter the id of the order you want to update: ");
            int order_id = sc.nextInt();
            System.out.print("Enter the id of the book you want to update: ");
            int book_id = sc.nextInt();
            OrderInformation orderInformation = OrderInformationMethod.getOrderInformationByOrderIdAndBookId(order_id, book_id);
            if (orderInformation == null) {
                System.out.println("No order information found");
                orderInformationMenu();
            }
            System.out.println("Enter new values to fields you want to update");
            System.out.print("New book_id: ");
            int update_book_id = sc.nextInt();
            orderInformation.setBook_id(update_book_id);
            System.out.println("New Ordered books Quantity: ");
            int ordered_books = sc.nextInt();
            orderInformation.setOrderedbooks(ordered_books);
            OrderInformationMethod.updateOrderInformation(orderInformation);
            orderInformationMenu();
        }
        if (choice == 5) {
            System.out.print("Enter the id of order you want to delete: ");
            int order_id = sc.nextInt();
            System.out.print("Enter the id of book you want to delete: ");
            int book_id = sc.nextInt();
            OrderInformation orderInformation = OrderInformationMethod.getOrderInformationByOrderIdAndBookId(order_id, book_id);
            if (orderInformation == null) {
                System.out.println("No order information found");
                orderInformationMenu();
            }
            OrderInformationMethod.deleteOrderInformation(order_id, book_id);
            orderInformationMenu();
        }

        if (choice == 6) {
            mainMenu();
        }
    }

    public static void orderMenu() {
        System.out.println("""
                Orders table
                1.Insert new order
                2.Retrieve all orders
                3.Get order by order_id
                4.Update order
                5.Delete order
                6.Back to choices menu
                            """);
        System.out.print("Choose what to do: ");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("order_id: ");
            int order_id = sc.nextInt();
            System.out.print("customer_id: ");
            int customer_id = sc.nextInt();
            sc.nextLine();
            System.out.print("order date: ");
            String date = sc.nextLine();
            Date dateStr = Date.valueOf(date);
            System.out.print("total cost: ");
            int cost = sc.nextInt();
            OrdersMethod.addOrders(new Orders(order_id, customer_id, dateStr, cost));
            orderMenu();
        }
        if (choice == 2) {
            List<Orders> Orders =  OrdersMethod.getAllOrders();
            if (Orders.size() == 0) {
                System.out.println("No record found");
            }
            orderMenu();
        }
        if (choice == 3) {
            System.out.print("Enter the id of the order you want to get: ");
            int order_id = sc.nextInt();
            Orders order = OrdersMethod.getOrderById(order_id);
            if(order == null){
                System.out.println("No order found");
            }
            orderMenu();
        }
        if (choice == 4) {
            System.out.print("Enter the id of the order you want to update: ");
            int customer_id = sc.nextInt();
            sc.nextLine();
            Orders order = OrdersMethod.getOrderById(customer_id);
            if (order == null) {
                System.out.println("No order found");
                orderMenu();
            }
            System.out.println("Enter new values to fields you want to update");
            System.out.print("New customer_id: ");
            int update_customer_id = sc.nextInt();
            System.out.print("New date: ");
            String date = sc.nextLine();
            Date update_dateStr = Date.valueOf(date);
            System.out.print("New total cost: ");
            int total_cost = sc.nextInt();
            order.setCustomer_id(update_customer_id);
            order.setOrder_date(update_dateStr);
            order.setTotal_cost(total_cost);
            OrdersMethod.updateOrders(order);
            orderMenu();
        }
        if (choice == 5) {
            System.out.print("Enter the id of order you want to delete: ");
            int order_id = sc.nextInt();
            Orders orders = OrdersMethod.getOrderById(order_id);
            if (orders == null) {
                System.out.println("No order found");
                orderMenu();
            }
            OrdersMethod.deleteOrders(order_id);
            orderMenu();
        }

        if (choice == 6) {
            mainMenu();
        }
    }

    public static void exitApplication() {
        System.exit(0);
    }
}

