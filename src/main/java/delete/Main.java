package delete;


import delete.entity.Author;
import delete.entity.Book;
import org.jboss.logging.Logger;

import java.util.List;

/**
 * В класс BookHelper пакета ex_004_relations дописать методы удаления книге по id и по автору.
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
        Main.fillTables();
        BookHelper bh = new BookHelper();
// delete by Author
        List<Book> bookListBefore = bh.getAll();
        Author author = new AuthorHelper().getAuthorById(1);
        bh.deleteByAuthor(author);
        List<Book> bookListAfter = bh.getAll();
        System.out.println("Before deletion by Author:");
        for (Book book : bookListBefore) {
            LOG.debug(book.getName());
        }
        System.out.println("After deletion by Author:");
        for (Book book : bookListAfter) {
            LOG.debug(book.getName());
        }
// delete by id
        System.out.println("\nDelete by id:");
        bh.deleteById(8);
        System.out.println("After deletion by Id:");
        List<Book> bookList = bh.getAll();
        for (Book book : bookList) {
            LOG.debug(book.getId() + " " + book.getName());
        }

    }

    public static void fillTables() {
        AuthorHelper ah = new AuthorHelper();
        BookHelper bh = new BookHelper();
        Author author = new Author();
        Book book = new Book();

        // add authors
        author.setName("Lesya");
        author.setLastName("Ukrainka");
        ah.addAuthor(author);
        book.setAuthor(author);
        book.setName("Kaminnyi hospodar");
        bh.addBook(book);
        book.setAuthor(author);
        book.setName("Blue Rose");
        bh.addBook(book);
        book.setAuthor(author);
        book.setName("Pisnia pro kniazia Ihoria");
        bh.addBook(book);

        author.setName("Ivan");
        author.setLastName("Kotlyarevsky");
        ah.addAuthor(author);
        book.setAuthor(author);
        book.setName("Eneida");
        bh.addBook(book);
        book.setAuthor(author);
        book.setName("Sobor. Kniaz Volodymyr");
        bh.addBook(book);

        author.setName("Mykhailo");
        author.setLastName("Kotsiubynsky");
        ah.addAuthor(author);
        book.setAuthor(author);
        book.setName("Tini zabutykh predkiv");
        bh.addBook(book);
        book.setAuthor(author);
        book.setName("Plakhy zholti");
        bh.addBook(book);

        author.setName("Ivan");
        author.setLastName("Franko");
        ah.addAuthor(author);
        book.setAuthor(author);
        book.setName("Zakhar Berkut");
        bh.addBook(book);
        book.setAuthor(author);
        book.setName("Zahar Berkut (adapted for children)");
        bh.addBook(book);

        author.setName("Marko");
        author.setLastName("Vovchok");
        ah.addAuthor(author);
        book.setAuthor(author);
        book.setName("Chorna rada");
        bh.addBook(book);

        author.setName("Panteleymon");
        author.setLastName("Kulish");
        ah.addAuthor(author);
        book.setAuthor(author);
        book.setName("Chorna rada");
        bh.addBook(book);
    }
}
