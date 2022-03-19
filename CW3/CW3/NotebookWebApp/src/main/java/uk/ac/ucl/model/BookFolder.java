package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BookFolder extends ItemSet<Book> {
    private ArrayList<Book> set;
    private int nextIndex;

    public BookFolder() {
        this.set = new ArrayList<>();
        this.nextIndex = 101;
    }

    public void add(int index, ArrayList<String> arr) {
        Book book = new Book(index, arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4));
        this.set.add(book);
        this.nextIndex++;
    }

    public void create(ArrayList<String> arr) {
        Book book = new Book(this.nextIndex, arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4));
        this.set.add(book);
        this.nextIndex++;
    }

    public Book get(int index) {
        return this.set.get(index);
    }

    public Book getById(int id) throws NoSuchElementException {
        for (Book book : this.set) {
            if (book.getId() == id) {
                return book;
            }
        }
        throw new NoSuchElementException();
    }

    public void delete(int id) throws NoSuchElementException {
        Book book = this.getById(id);
        this.set.remove(book);
    }

    public int getIndex(int id) throws NoSuchElementException{
        Book book = this.getById(id);
        return this.set.indexOf(book);
    }

    public void edit(int id, Book newBook) throws NoSuchElementException{
        int index = getIndex(id);
        this.set.set(index, newBook);
    }

    public int getSize() {
        return this.set.size();
    }
}
