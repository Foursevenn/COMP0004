package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ListFolder extends ItemSet<MyList> {
    private ArrayList<MyList> set;
    private int nextIndex;

    public ListFolder(int start) {
        this.set = new ArrayList<>();
        this.nextIndex = start;
    }

    public void add(int index, ArrayList<String> arr) {
        MyList myList = new MyList(index, arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            myList.add(arr.get(i));
        }
        this.set.add(myList);
        this.nextIndex++;
    }

    public void create(ArrayList<String> arr) {
        MyList myList = new MyList(this.nextIndex, arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            myList.add(arr.get(i));
        }
        this.set.add(myList);
        this.nextIndex++;
    }

    public MyList get(int index) {
        return this.set.get(index);
    }

    public MyList getById(int id) throws NoSuchElementException {
                for (MyList myList : this.set) {
                    if (myList.getId() == id) {
                        return myList;
                    }
                }
                throw new NoSuchElementException();
    }

    public int getIndex(int id) throws NoSuchElementException {
        MyList myList = this.getById(id);
        return this.set.indexOf(myList);
    }

    public void delete(int id) throws NoSuchElementException {
        MyList myList = this.getById(id);
        this.set.remove(myList);
    }

    public void edit(int id, MyList newList) throws NoSuchElementException {
        int index = this.getIndex(id);
        this.set.set(index, newList);
    }

    public int getSize() {
        return this.set.size();
    }

}
