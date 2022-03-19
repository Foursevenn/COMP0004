package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.NoSuchElementException;

abstract class ItemSet<E> {

    abstract public void add(int index, ArrayList<String> arr);

    abstract public void create(ArrayList<String> arr);

    abstract public E get(int index);

    abstract public void delete(int id) throws NoSuchElementException;

    abstract public void edit(int id, E newE) throws NoSuchElementException;

    abstract public int getSize();
}
