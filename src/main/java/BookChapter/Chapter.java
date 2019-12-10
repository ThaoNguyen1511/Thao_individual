package BookChapter;

public class Chapter implements Comparable<Chapter>{
    public String chapterName;
    public String number;

    public Chapter(String chapterName, String chapterNum){
        if (chapterName != "" && chapterName != null && chapterNum.matches("\\d+.\\d+")){
            this.chapterName = chapterName;
            this.number = chapterNum;
        }
        else{
            throw  new IllegalArgumentException("Chapter Name or levels of chapters is invalid ");
        }
    }

    @Override
    public boolean equals(Object o){
       return false;
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
