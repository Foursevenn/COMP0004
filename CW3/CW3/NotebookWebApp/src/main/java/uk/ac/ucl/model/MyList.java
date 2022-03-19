package uk.ac.ucl.model;

import java.util.ArrayList;

//items type can be Book, MyList, Video and other string
public class MyList extends Item{
    private int id;
    private String name;
    private ArrayList<Object> arr;
    private int size;

    public MyList(int id, String name) {
        this.id = id;
        this.name = name;
        this.arr = new ArrayList<>();
        this.size = 0;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public void add(Object item) {
        this.arr.add(item);
        this.size++;
    }

    public Object getByIndex(int index) {
        return this.arr.get(index);
    }

    public int get(String s) throws Exception{
        for (int i = 0; i < this.size; i++) {
            Object item = this.arr.get(i);

            if (item.getClass() == MyList.class) {
                if (((MyList) item).name.equals(s)) {
                    return i;
                }
            } else {
                if (item.equals(s)) {
                    return i;
                }
            }
        }
        throw new Exception();
    }

    public void delete(String s) throws Exception {
        int index = this.get(s);
        this.arr.remove(index);
        this.size--;
    }

    public void editByIndex(int index, Object newObject){
        this.arr.set(index, newObject);
    }

    public void deleteByIndex(int index) {
        this.arr.remove(index);
        this.size--;
    }

    public boolean search(String s) {
        if (String.valueOf(this.id).equals(s) || this.name.equals(s)) {
            return true;
        }

        for (Object o : this.arr) {
            if (o instanceof String && ((String) o).contains(s)) {
                return true;
            }
        }
        return false;
    }
}
