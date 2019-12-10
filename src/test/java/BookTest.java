import BookChapter.Book;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private String validBookName = "Never Eat alone";
    private String validAuthor = "Keith Ferrazzi";
    private String inValidBookName = "";
    private String inValidAuthor = "";
    @Test(expected = IllegalArgumentException.class)
    public void setInvalidBookNameAndAuthorShouldThrowException(){
        Book b = new Book(inValidAuthor,inValidBookName);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setInvalidBookNameShouldThrowException(){
        Book b = new Book(validAuthor,inValidBookName);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setInvalidAuthorShouldThrowException()
    {
        Book b = new Book(inValidAuthor,validBookName);
    }
    @Test
    public void setValidBookNameAndAuthorShouldBeSuccess(){
        Book b = new Book (validAuthor,validBookName);

        Assert.assertEquals("Valid book is not added with valid BookName",validBookName,b.getBookName());
        Assert.assertEquals("Valid book is not added with valid BookName",validAuthor,b.getAuthor());
    }


}
