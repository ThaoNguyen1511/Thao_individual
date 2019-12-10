import BookChapter.Chapter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChapterTest {
    private String validChapterName = "Introduction";
    private String validChapterNumber = "1.1";
    private String inValidChapterName = "";
    private String inValidChapterNumber = "2.1.1";

    @Test(expected = IllegalArgumentException.class)
    public void setInvalidChapterNumberShouldThrowException() {
        Chapter c = new Chapter(validChapterName, inValidChapterNumber);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setInvalidChapterNameShouldThrowException() {
        Chapter c = new Chapter(inValidChapterName, validChapterNumber);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setInvalidChapterNameAndInvalidNumberShouldThrowException() {
        Chapter c = new Chapter(inValidChapterName, inValidChapterNumber);
    }
    @Test
    public void validChapterShouldBeSetSuccessful() {
        Chapter c = new Chapter(validChapterName,validChapterNumber);

        Assert.assertEquals("Chapter is not set",validChapterName,c.getChapterName());
    }
    @Test
    public void testEqualChaptersShouldBeSuccess(){
        Chapter c = new Chapter(validChapterName,validChapterNumber);
        Chapter c1 = new Chapter(validChapterName,validChapterNumber);

        assertTrue(c.equals(c1));
    }
    @Test
    public void twoDifferentChapterShouldNotBeEqual(){
        Chapter c = new Chapter(validChapterName,validChapterNumber);
        Chapter c1 = new Chapter("Chapter 1","2.2");

        assertFalse(c.equals(c1));
    }
    @Test
    public void testCompareToOfTwoChaptersShouldBeSuccess(){
        Chapter c = new Chapter(validChapterName,validChapterNumber);
        Chapter c1 = new Chapter("Chapter 1","2.2");

        Assert.assertEquals("Failed",-1,c.compareTo(c1));
    }

}
