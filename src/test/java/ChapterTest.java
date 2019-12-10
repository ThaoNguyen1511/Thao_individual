import BookChapter.Chapter;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChapterTest {
    @Test
    public void testEqualChaptersShouldBeSuccess(){
        String validChapterName = "Introduction";
        String validChapterNumber = "1.1";
        Chapter c = new Chapter(validChapterName,validChapterNumber);
        Chapter c1 = new Chapter(validChapterName,validChapterNumber);

        assertTrue(c.equals(c1));
    }

}
