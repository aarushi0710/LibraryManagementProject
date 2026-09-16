 import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Permanent storage file
    private static final String FILE_NAME = "library_data.txt";

    // List of Book objects
    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        // Load books from file when program starts
        loadData();

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {

            System.out.println("\n===== SIMPLE LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Delete a Book");
            System.out.println("6. Load data from file directly");
            System.out.println("7. Exit");
        

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume Enter key

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();

                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();                    

                    books.add(new Book(bookId, bookTitle));

                    saveData();

                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    displayBooks();
                    
                    break;

                case 3:
                    System.out.print("Enter Book ID to Issue: ");
                    String issueBookId = scanner.nextLine();

                    Book issueBook = findBook(issueBookId);

                    if (issueBook != null && !issueBook.isIssued) {
                        issueBook.isIssued = true;
                        saveData();
                        System.out.println("Book issued successfully!");
                    } else {
                        System.out.println("Book not found or already issued.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to Return: ");
                    String returnBookId = scanner.nextLine();

                    Book returnBook = findBook(returnBookId);

                    if (returnBook != null && returnBook.isIssued) {
                        returnBook.isIssued = false;
                        saveData();
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Book not found or not issued.");
                    }
                    break;
                case 5:
                      System.out.print("Enter Book ID to Delete: ");
                      String deleteBookId = scanner.nextLine();
                       deleteBook(deleteBookId);
                      break;
                case 6:                       
                      System.err.println("Liberary Books as stored in file are ");
                      loadData();
                       break;
                case 7 :
                    System.out.println("Thank you for using Library Management System.");
                    scanner.close();
                    return;
                      
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display all books
    private static void displayBooks() {

        System.out.println("\n===== BOOK LIST =====");

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Find book by ID
    private static Book findBook(String bookId) {

        for (Book book : books) {
            if (book.id.equals(bookId)) {
                return book;
            }
        }

        return null;
    }

    // Save books permanently into library_data.txt
    private static void saveData() {

        try (ObjectOutputStream outputStream =
                new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            outputStream.writeObject(books);

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
     private static void deleteBook(String bookId) {

    Book book = findBook(bookId);

    if (book != null) {
        books.remove(book);
        saveData();   // Update library_data.txt
        System.out.println("Book deleted successfully!");
    } else {
        System.out.println("Book not found.");
    }
}
    // Load books from library_data.txt
    @SuppressWarnings("unchecked")
    private static void loadData() {

        File file = new File(FILE_NAME);
           
        if (!file.exists()) {
            books = new ArrayList<>();
            System.out.println("Reached Here file not exist");
            return;
        }

        try (ObjectInputStream inputStream =
                new ObjectInputStream(new FileInputStream(file))) {

            books = (List<Book>) inputStream.readObject();
            System.out.println(" File READING Started");
            System.out.println(books);

        } catch (Exception e) {
            books = new ArrayList<>();
            System.out.println("Error loading saved data: " + e.getMessage());
        }
    }
}

