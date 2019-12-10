package BookChapter;

public class Chapter implements Comparable<Chapter>{
    public String chapterName;
    public String number;

    public Chapter(String chapterName, String chapterNum) throws IllegalArgumentException{
        if (chapterName != "" && chapterName != null && chapterNum.matches("\\d+.\\d+")){
            this.chapterName = chapterName;
            this.number = chapterNum;
        }
        else{
            throw  new IllegalArgumentException("Chapter Name or levels of chapters is invalid ");

        }

    }
    public String getChapterName(){
        return chapterName;
    }
    public String getNumber(){
        return number;
    }

    @Override
    public boolean equals(Object o){
        Chapter c = (Chapter)o;
        return (this.getChapterName().equals(c.getChapterName() )&& this.getNumber().equals(c.getNumber()));
    }
    @Override
    public int hashCode(){
        return 0;
    }

    @Override
    public int compareTo(Chapter chapter) {
        return this.number.compareTo(chapter.number);
    }
}
