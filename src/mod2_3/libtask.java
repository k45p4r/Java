package mod2_3;
import java.util.ArrayList;
import java.util.Objects;

class Book{
    private String title;
    private String author;
    private Integer year;
    private Double rating = 0.0;
    private final ArrayList<String> reviews = new ArrayList<>();
    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }
    // Task4
    public void setRating(double rating){
        this.rating = rating;
    }
    public void addReview(String review){
        this.reviews.add(review);
    }
    public double getRating(){
        return rating;
    }
    public ArrayList<String> getReviews(){
        return reviews;
    }
}

class Library{
    private final ArrayList<Book> booklist = new ArrayList<>();
    private final ArrayList<User> userlist = new ArrayList<>();
    public void addBook(Book ... a){
        for(Book book : a){
            booklist.add(book);
        }
    }
    public void displayBooks(){
        for (Book book : booklist){
            System.out.printf("%s, %s. (%s) \n", book.getTitle(), book.getAuthor(), book.getYear());
        }
    }
    public void getBookByAuthor(String ... author){
        for (String auth : author){
            for (Book book : booklist){
                if (Objects.equals(book.getAuthor(), auth))
                    System.out.printf("%s, %s. (%s) \n", book.getTitle(), book.getAuthor(), book.getYear());
            }
        }
    }

    public ArrayList<Book> getBooklist() {
        return booklist;
    }

    // Task2
    private final ArrayList<Book> borrowList = new ArrayList<>();
    public void borrowBook(User user, Book ... a){
        for(Book book : a){
            ArrayList<Book> blist = getBooklist();
            ArrayList<Book> rlist = getBorrowList();
            if(blist.contains(book)){
                user.borrowed.add(book);
                rlist.add(book);
                blist.remove(book);
            }
        }
    }
    public void returnBook(User user, Book ... a){
        for(Book book : a){
            if(user.borrowed.contains(book)){
                user.borrowed.remove(book);
                getBooklist().add(book);
                getBorrowList().remove(book);
            }
        }
    }

    public ArrayList<Book> getBorrowList() {
        return borrowList;
    }
    // Task3
    public Boolean isBookAvailable(Book a){
        return getBooklist().contains(a);
    }
    // Task5
    public double getAverageBookRating(){
        double sum = 0.0;
        for(Book book : booklist){
            double rating = book.getRating();
            sum += rating;
        }
        sum /= booklist.size();
        return sum;
    }
    public Book getMostReviewedBook(){
        Book most = null;
        int sum = 0;
        for(Book book : booklist){
            int amount = book.getReviews().size();
            if (amount > sum) most = book;
        }
        return most;
    }
    //  Task6

    public ArrayList<User> getUserList(){
        return this.userlist;
    }
}
class User {
    String name;
    int age;
    ArrayList<Book> borrowed = new ArrayList<>();
    public User(String name, int age, Library library){
        this.name = name;
        this.age = age;
        library.getUserList().add(this);
    }
}

public class libtask {
    public static void main(String[] args) {
        Library lib = new Library();
        User user1 = new User("Kaspar", 26, lib);
        Book b1 = new Book("No Longer Human", "Osamu Dazai", 1948);
        Book b2 = new Book("Fortnite Battle Royale mestaripelaaja", "Kevin Pettman", 2020);
        Book b3 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951);
        Book b4 = new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866);
        Book b5 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1937);
        Book b6 = new Book("Moby-Dick", "Herman Melville", 1851);
        lib.addBook(b1, b2, b3, b4, b5, b6);
        lib.displayBooks();
        lib.getBookByAuthor("Herman Melville", "Osamu Dazai");
        System.out.println();

        //
        lib.borrowBook(user1, b6, b5, b4, b3);
        lib.displayBooks();
        lib.returnBook(user1, b6);
        System.out.println();

        //Task3
        System.out.println(lib.isBookAvailable(b5));
        System.out.println();

        //Task4
        b1.addReview("Misogynia setit");
        b1.setRating(7);
        b2.setRating(2);
        b3.setRating(2);
        b4.setRating(1);
        b5.setRating(6);
        b6.setRating(9);
        b6.addReview("Valas");

        //Task5
        lib.displayBooks();
        System.out.printf("Keskimääräinen kirja-arvosana on: %.1f\n", lib.getAverageBookRating());
        System.out.printf("Eniten arvosteltu kirja on: %s, jonka kirjoitti %s vuonna %d.",
                lib.getMostReviewedBook().getTitle(),
                lib.getMostReviewedBook().getAuthor(),
                lib.getMostReviewedBook().getYear());



    }
}