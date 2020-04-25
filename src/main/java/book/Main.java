package book;

import book.model.Book;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;

public class Main {

    private static void generateBooks(int n,BookGenerator bookGenerator, BookDao bookDao){

        for (int i = 0;i < n; i++){
            Book book = bookGenerator.generateBook();
            bookDao.persist(book);
        }

    }
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookDao bookDao = injector.getInstance(BookDao.class);
        BookGenerator bookGenerator = new BookGenerator();

        generateBooks(10, bookGenerator, bookDao);

        bookDao.findAll().stream().forEach(System.out::println);

    }
}
