import BookChapter.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test(expected = IllegalArgumentException.class)
    public void setInvalidBookNameAndAuthorShouldThrowException(){
        Book b = new Book("","");
    }
    @Test
    public void setValidBookNameAndAuthorShouldBeSuccess(){
        String validBookName = "Never Eat Alone";
        String validAuthor = "Keith Ferrazzi";
        Book b = new Book (validAuthor,validBookName);
    }


}
