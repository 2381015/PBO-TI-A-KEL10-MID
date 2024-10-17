import java.util.ArrayList;
import java.util.Scanner;

public class MID {
    public static ArrayList<Book> booklist = new ArrayList<>();
    private static final int MAX_BOOKS = 7;

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

    private static void addBook(Scanner scanner) {
        if (booklist.size() >= MAX_BOOKS) {
            bookLimitReached();
            return;
        }
        System.out.println("Masukkan Judul Buku: ");
        String title = scanner.next();
        System.out.println("Masukkan Penulis Buku: ");
        String author = scanner.next();

        Book book= new Book (title, author);
        booklist.add(book);
        System.out.println("Buku Berhasil di Tambahkan!");
    }

    private static void editBook(Scanner scanner) {
        System.out.println("Masukkan Judul Buku yang ingin di Edit: ");
        String title = scanner.next();

        for (Book book : booklist) {
            if (book.getTitle().equals(title)) {
                System.out.println("Masukkan Judul Buku yang Baru; ");
                String newTitle = scanner.next();
                System.out.println("Masukkan Penulis Buku yang Baru; ");
                String newAuthor = scanner.next();

                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                System.out.println("Buku Berhasil di Edit!");
                return;
            }
        }

        System.out.println("Buku tidak ditemukan!!");
    }

    private static void deleteBook(Scanner scanner) {
        System.out.println("Masukkan Buku yang ingin di Hapus: ");
        String Title = scanner.next();

        for (Book book : booklist) {
            if (book.getTitle().equals(Title)) {
                booklist.remove(book);
                System.out.println("Buku Berhasil di Hapus!");
            }
        }
        System.out.println("Buku Tidak Ditemukan!!");
    }

    private static void invalidChoice() {
        System.out.println("Pilihan anda salah!");
    }

    private static void bookLimitReached() {
        System.out.println("Penambahan buku telah mencapai batas!");
    }

    private static void clearHistory() {
        booklist.clear();
        System.out.println("Riwayat telah dihapus!");
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
