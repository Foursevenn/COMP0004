package uk.ac.ucl.model;

//can been seen as type list too
//with fixed items title, author...
public class Book extends Item{
    private int id;
    private String title;
    private String author;
    private String year;
    private String cover;
    private String link;

    public Book(int index, String title, String author, String year, String cover, String link) {
        this.id = index;
        this.title = title;
        this.author = author;
        this.year = year;
        this.cover = cover;
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

    public String getYear() {
        return this.year;
    }

    public String getCover() {
        return this.cover;
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

    public void setYear(String s) {
        this.year = s;
    }

    public void setCover(String s) {
        this.cover = s;
    }

    public void setLink(String s) {
        this.link = s;
    }

    public void editByIndex(int index, Object newValue) {
        String newString = (String) newValue;

        switch (index) {
            case 0 -> this.setTitle(newString);
            case 1 -> this.setCover(newString);
            case 2 -> this.setAuthor(newString);
            case 3 -> this.setYear(newString);
            case 4 -> this.setLink(newString);
        }
    }

    public void deleteByIndex(int index) {
        switch (index) {
            case 0 -> this.setTitle("");
            case 1 -> this.setCover("");
            case 2 -> this.setAuthor("");
            case 3 -> this.setYear("");
            case 4 -> this.setLink("");
        }
    }

    //cover and link don't need to search
    public boolean search(String s) {
        if (String.valueOf(this.id).equals(s) ||
                this.title.contains(s) ||
                this.author.contains(s) ||
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
                return this.year;
            }
            case 2 -> {
                return this.cover;
            }
            case 3 -> {
                return this.link;
            }
        }

        return null;
    }
}
