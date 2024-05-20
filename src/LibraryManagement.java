import java.util.*;

class Book{
    String title;
    String author;
    String isbn;

    public Book(String title,String author,String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public String toString()
    {
        return "Title of book is: " + title + ", " + "Author name is: " + author+ ", " + "Isbn number is: " + isbn;
    }
}
public class LibraryManagement{
    Scanner sc = new Scanner(System.in);
    HashMap<String,Book>library = new HashMap<>();

    public void addBooks(){
        System.out.println("Enter the title");
        String title = sc.nextLine();
        System.out.println("Enter the author");
        String author = sc.nextLine();
        System.out.println("Enter the isbn");
        String isbn = sc.nextLine();

        if(library.isEmpty()){
            library.put(isbn,new Book(title,author,isbn));
            System.out.println("Books is added successfully");
        }
        else{
            if(library.containsKey(isbn)){
                System.out.println("The book of this isbn num is already exists");
            }
            else{
                library.put(isbn,new Book(title,author,isbn));
                System.out.println("Books is added successfully");
            }
        }
    }

    public void displayBooks(){
        if(library.isEmpty()){
            System.out.println("library is empty");
        }
        else{
            System.out.println("Books in the library");
            for(Book b:library.values());
            System.out.println(library.toString());
        }
    }

    public void searchBooks(){
        if(library.isEmpty()){
            System.out.println("library is empty");
        }
        System.out.println("Enter the Isbn of book");
        String s = sc.nextLine();

        if(library.containsKey(s)){
            System.out.println(library.get(s) + "\n");
        }
        else{
            System.out.println("Books are not found");
        }
    }

    public void removeBooks(){
        if(library.isEmpty()){
            System.out.println("library is empty");
        }
        System.out.println("Enter the isbn num of book");
        String isbn = sc.nextLine();

        if(library.containsKey(isbn)){
            library.remove(isbn);
            System.out.println("Books removes Successfully");
        }
        else{
            System.out.println("books not found");
        }
    }

    public static void main(String[] args){
        LibraryManagement lm = new LibraryManagement();
        Scanner sc = new Scanner(System.in);
        int choice;


        StringBuilder sb = new StringBuilder("Library System Mangement");
        sb.append("\n--------------\n1.Add a new book \n2.Display all books \n3.Search for a book by title or author\n4.Remove a book");
        System.out.println(sb);

        do{
            System.out.print("Enter your choice:");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    lm.addBooks();
                    break;

                case 2:
                    lm.displayBooks();
                    break;

                case 3:
                    lm.searchBooks();
                    break;

                case 4:
                    lm.removeBooks();
                    break;

                case 5:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("invalid: Enter the num between 1.to 5.");
                    break;
            }
        } while(choice!= 5);

    }
}