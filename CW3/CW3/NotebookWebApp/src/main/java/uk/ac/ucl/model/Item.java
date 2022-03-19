package uk.ac.ucl.model;

abstract class Item {

    abstract void editByIndex(int index, Object newValue);

    abstract void deleteByIndex(int index);

    abstract boolean search(String s);

    abstract int getId();

    abstract String getTitle();

    abstract int getSize();

    abstract Object getByIndex(int index);
}
