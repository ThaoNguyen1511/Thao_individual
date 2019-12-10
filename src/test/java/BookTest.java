import BookChapter.Book;
import BookChapter.Chapter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookTest {
    private String validBookName = "Never Eat alone";
    private String validAuthor = "Keith Ferrazzi";
    private String inValidBookName = "";
    private String inValidAuthor = "";
    private ArrayList<Chapter> chapters = new ArrayList<>();

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
    @Test
    public void listOfChaptersShouldBeAddedSuccessfulToBook(){
        Chapter c = new Chapter("Introduction","1.1");
        Chapter c1 = new Chapter("Foreword", "2.1");
        Chapter c2 = new Chapter("About author","2.2");
        chapters.add(c);
        chapters.add(c1);
        chapters.add(c2);

        Book b = new Book(validAuthor,validBookName);
        b.setChapters(chapters);

        Assert.assertEquals("chapter list is not added",chapters,b.getChapters());
    }
    @Test(expected = IllegalArgumentException.class)
    public void addExistChapterToBookShouldThrowException() {
        Book b = new Book(validAuthor,validBookName);
        String chapterName = "Introduction";
        String chapterNumber = "1.1";
        String chapterName1 = "Introduction";
        String chapterNumber1 = "1.1";
        //act
        b.addChapterToBook(chapterName,chapterNumber);
        b.addChapterToBook(chapterName1,chapterNumber1);
    }
    @Test
    public void aNewChapterShouldBeAddedToBookSuccessful() {
        Book b = new Book(validAuthor,validBookName);
        String chapterName = "Introduction";
        String chapterNumber = "1.1";
        String chapterName1 = "Foreword";
        String chapterNumber1 = "2.1";

        b.addChapterToBook(chapterName,chapterNumber);
        b.addChapterToBook(chapterName1,chapterNumber1);
    }


}
