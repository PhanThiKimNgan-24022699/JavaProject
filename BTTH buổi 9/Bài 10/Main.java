abstract class MediaItem {
    String id;
    String name;

    public MediaItem(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Book extends MediaItem {
    String author;
    int pages;

    public Book(String id, String name, String author, int pages) {
        super(id, name);
        this.author = author;
        this.pages = pages;
    }

    public String toString() {
        return name + " - " + author + " - " + pages;
    }
}

class DVD extends MediaItem {
    String director;
    int duration;

    public DVD(String id, String name, String director, int duration) {
        super(id, name);
        this.director = director;
        this.duration = duration;
    }

    public String toString() {
        return name + " - " + director + " - " + duration;
    }
}

class LibrarySection<T extends MediaItem> {
    private T[] items;
    private int count = 0;

    public LibrarySection(T[] storage) {
        this.items = storage;
    }

    //thêm tài liệu vào khu vực
    public void addItem(T item) {
        if (count < items.length) {
            items[count] = item;
            count++;
        }
    }

    public void displayItems() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LibrarySection<Book> bookSection = new LibrarySection<>(new Book[10]);
        bookSection.addItem(new Book("M01", "LapTrinhJava", "NguyenVanA", 350));
        bookSection.addItem(new Book("M03", "CauTrucDuLieu", "LeVanB", 280));

        LibrarySection<DVD> dvdSection = new LibrarySection<>(new DVD[10]);
        dvdSection.addItem(new DVD("M02", "Avengers", "Russo", 120));
        dvdSection.addItem(new DVD("M04", "Interstellar", "Nolan", 169));

        System.out.println("Khu vực Sách:");
        bookSection.displayItems();

        System.out.println();

        System.out.println("Khu vực DVD:");
        dvdSection.displayItems();
    }
}
