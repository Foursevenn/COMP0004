package uk.ac.ucl.model;

//can been seen as type list too
//with fixed items title, author...
public class Video extends Item{
    private int id;
    private String title;
    private String author;
    private String platform;
    private String year;
    private String link;

    public Video(int id, String title, String author, String platform, String year, String link) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.platform = platform;
        this.year = year;
        this.link = link;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getYear() {
        return this.year;
    }

    public String getLink() {
        return this.link;
    }

    public void setTitle(String s) {
        this.title = s;
    }

    public void setAuthor(String s) {
        this.author = s;
    }

    public void setPlatform(String s) {
        this.platform = s;
    }

    public void setYear(String s) {
        this.year = s;
    }

    public void setLink(String s) {
        this.link = s;
    }

    public void editByIndex(int index, Object newValue) {
        String newString = (String)newValue;
        switch (index) {
            case 0 -> this.setTitle(newString);
            case 1 -> this.setAuthor(newString);
            case 2 -> this.setPlatform(newString);
            case 3 -> this.setYear(newString);
            case 4 -> this.setLink(newString);
        }
    }

    public void deleteByIndex(int index) {
        switch (index) {
            case 0 -> this.setTitle("");
            case 1 -> this.setAuthor("");
            case 2 -> this.setPlatform("");
            case 3 -> this.setYear("");
            case 4 -> this.setLink("");
        }
    }

    public boolean search(String s) {
        if (String.valueOf(this.id).equals(s) ||
                this.title.contains(s) ||
                this.author.contains(s) ||
                this.platform.contains(s) ||
                this.year.contains(s)) {
            return true;
        }
        return false;
    }

    public int getSize() {
        return 4;
    }

    public Object getByIndex(int index) {
        switch (index) {
            case 0 -> {
                return this.author;
            }
            case 1 -> {
                return this.platform;
            }
            case 2 -> {
                return this.year;
            }
            case 3 -> {
                return this.link;
            }
        }
        return null;
    }
}
