package BookChapter;

import java.util.*;

public class Book {
    public String bookName;
    public String author;
    public ArrayList<Chapter> chapters= new ArrayList<>();


    public Book(String author,String bookName) throws  IllegalArgumentException{
        if(author ==null||author ==""||bookName ==null||bookName ==""){
            throw  new IllegalArgumentException("Invalid BookName or Author");
        }
        else{
            this.author = author;
            this.bookName = bookName;
        }
    }
    public void addChapterToBook(String chapterName, String chapterNumber) throws IllegalArgumentException
    {
        Chapter chapter = new Chapter(chapterName,chapterNumber);
        for(Chapter c : chapters){
            if(c.equals(chapter)){
                throw new IllegalArgumentException ("Chapter already exists. Can not add!");
            }
        }
        chapters.add(chapter);
    }
    public Set<Chapter> getTableOfContents()
    {
        List<Chapter> clonedList = new ArrayList<>(chapters);
        Collections.sort(clonedList);
        Set<Chapter> clonedSet = new HashSet<>(clonedList);
        return clonedSet;
    }
    public void setChapters(ArrayList<Chapter> chapters)
    {
        this.chapters = chapters;
    }
    public String getBookName()
    {
        return bookName;
    }
    public String getAuthor()
    {
        return author;
    }
    public ArrayList<Chapter> getChapters()
    {
        return chapters;
    }
}
