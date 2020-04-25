package book;

import book.model.Book;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BookGenerator {

    private static final Faker faker = new Faker();

    public static Book generateBook (){

        Date date = faker.date().past(120000, TimeUnit.DAYS);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Book book = Book.builder()
                .isbn13(faker.code().isbn13())
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.class))
                .publisher(faker.book().publisher())
                .publicationDate(localDate)
                .pages(faker.number().numberBetween(1,2500))
                .available(faker.bool().bool())
                .build();
        return book;
    }
}
