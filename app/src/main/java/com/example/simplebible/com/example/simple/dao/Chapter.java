package com.example.simplebible.com.example.simple.dao;
import java.util.List;

public class Chapter {
    String type;
    String version;
    String book_name;
    Integer book_nr;
    Integer chapter_nr;
    String direction;
    List<Verse> chapter;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getBook_nr() {
        return book_nr;
    }

    public void setBook_nr(Integer book_nr) {
        this.book_nr = book_nr;
    }

    public Integer getChapter_nr() {
        return chapter_nr;
    }

    public void setChapter_nr(Integer chapter_nr) {
        this.chapter_nr = chapter_nr;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<Verse> getChapter() {
        return chapter;
    }

    public void setChapter(List<Verse> chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        String chapterString="{"+
                "\"type\":"+"\""+type+"\","+
                "\"version\":"+"\""+version+"\","+
                "\"book_name\":"+"\""+book_name+"\","+
                "\"book_nr\":"+book_nr+","+
                "\"chapter_nr\":"+chapter_nr+","+
                "\"direction\":"+"\""+direction+"\","+
                "\"chapter\":{";
        for(Verse verse : chapter){
            chapterString=chapterString+"\""+(chapter.indexOf(verse)+1)+"\": ";
            chapterString=chapterString+verse.toString();
                    if(chapter.indexOf(verse)<(chapter.size()-1)) {
                        chapterString=chapterString+",";
                    }
            }
        chapterString=chapterString+"}}";
        return chapterString;
    }
}
