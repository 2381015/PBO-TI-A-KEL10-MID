import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class MID {
    public static ArrayList<Book> booklist = new ArrayList<>();
    private static final int MAX-BOOKS = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Library App!!");
            System.out.println("1. Lihat daftar buku yang tersedia");
            System.out.println("2. Tambah buku");
            System.out.println("3. Edit buku");
            System.out.println("4. Hapus buku");
            System.out.println("5. Keluar");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBookList();
                    break;
                case 2:
                    addBook(scanner);
                    break;
                case 3:
                    editBook(scanner);
                    break;
                case 4:
                    deleteBook(scanner);
                    break;
                case 5:
                    System.out.println("DADAAAAHHH!!");
                    return;
                default:
                    invalidChoice();
            }
        }
    }

    private static void displayBookList() {
        System.out.println("Daftar buku yang tersedia: ");
        for (Book book : booklist) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

}
