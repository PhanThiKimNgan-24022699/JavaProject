public class Book {
    private String title;
    private String author;
    private double price;

    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Override phương thức equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book other = (Book) obj;
        return this.title.equals(other.title) &&
                this.author.equals(other.author) &&
                this.price == other.price;
    }

    public static void main(String[] args) {
        Book b1 = new Book("Lập trình Java", "Nguyễn Văn A", 100.0);
        Book b2 = new Book("Lập trình Java", "Nguyễn Văn A", 100.0);

        // So sánh bằng == và equals
        System.out.println("So sánh bằng ==     : " + (b1 == b2)); 
        System.out.println("So sánh bằng equals : " + b1.equals(b2));
    }
}
