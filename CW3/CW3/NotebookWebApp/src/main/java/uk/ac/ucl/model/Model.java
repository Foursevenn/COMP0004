package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Model {
  private ArrayList<ItemSet> dataArr;
  private CSVWriter writer;

  public Model() {
    writer = new CSVWriter();
  }

  public void loadFile(File file) throws IOException {
    CSVReader reader = new CSVReader(file);
    reader.readFile();
    this.dataArr = reader.getFileData();

    // institute book/video/list id number in listFolder with real objects after all objects has been initialized
    ListFolder topics = this.getTopics();
    this.substituteWithObject(topics);
    ListFolder listFolder = this.getListFolder();
    this.substituteWithObject(listFolder);
  }

  //the input are ids, this step is to substitute all id with actual objects(e.g. Book)
  private void substituteWithObject(ListFolder listFolder) {
    for (int i = 0; i < listFolder.getSize(); i++) {
      MyList myList = listFolder.get(i);

      for (int j = 0; j < myList.getSize(); j++) {
        if (myList.getByIndex(j) instanceof String) {
          String s = (String) myList.getByIndex(j);

          if (this.isNumeric(s)) {
            int n = Integer.parseInt(s);
            if (n < 11) {
              MyList myList1 = this.getTopics().getById(n);
              myList.editByIndex(j, myList1);
            } else if (n < 101) {
              MyList myList2 = this.getListFolder().getById(n);
              myList.editByIndex(j, myList2);
            } else if (n < 201) {
              Book book = this.getBookFolder().getById(n);
              myList.editByIndex(j, book);
            } else {
              Video video = this.getVideoFolder().getById(n);
              myList.editByIndex(j, video);
            }
          }
        }
      }
    }
  }

  public Item findObject(int id) {
    if (id < 11) {
      ListFolder notebooks = this.getTopics();
      return notebooks.getById(id);
    } else if (id < 101) {
      ListFolder lists = this.getListFolder();
      return lists.getById(id);
    } else if (id <201) {
      BookFolder books = this.getBookFolder();
      return books.getById(id);
    } else {
      VideoFolder videos = this.getVideoFolder();
      return videos.getById(id);
    }
  }

  public void edit(String listId, String oldIndex, String newType, String newValue) throws IOException{
    int id = Integer.parseInt(listId);
    Item itemToChange = this.findObject(id);

    if (newType.equals("object")) {
      Item newItem = this.findObject(Integer.parseInt(newValue));
      itemToChange.editByIndex(Integer.parseInt(oldIndex), newItem);
    } else {
      itemToChange.editByIndex(Integer.parseInt(oldIndex), newValue);
    }

    this.writer.update(this.dataArr);
  }

  public void deleteItem(String listId, String itemIndex) throws IOException{
    int id = Integer.parseInt(listId);
    int index = Integer.parseInt(itemIndex);
    Item itemToDelete = this.findObject(id);
    itemToDelete.deleteByIndex(index);

    this.writer.update(this.dataArr);
  }

  public void deleteList(String listId) throws IOException{
    int id = Integer.parseInt(listId);

    if (id < 11) {
      ListFolder notebooks = this.getTopics();
      notebooks.delete(id);
    } else if (id < 101) {
      ListFolder notebooks = this.getTopics();
      ListFolder lists = this.getListFolder();
      //not only do we need to delete the List itself
      //but also we have to delete all Upper list positions where the list is placed
      this.deleteFromUpperLayer(notebooks, id);
      this.deleteFromUpperLayer(lists, id);
      lists.delete(id);
    } else if (id <201) {
      BookFolder books = this.getBookFolder();
      ListFolder lists = this.getListFolder();
      this.deleteFromUpperLayer(lists, id);
      books.delete(id);
    } else {
      VideoFolder videos = this.getVideoFolder();
      ListFolder lists = this.getListFolder();
      this.deleteFromUpperLayer(lists, id);
      videos.delete(id);
    }

    this.writer.update(this.dataArr);
  }

  private void deleteFromUpperLayer(ListFolder lists, int id) {
    for (int i = 0; i < lists.getSize(); i++) {
      MyList list = lists.get(i);

      for (int j = 0; j < list.getSize(); j++) {
        if (list.getByIndex(j) instanceof Item) {
          if (((Item)list.getByIndex(j)).getId() == id) {
            list.deleteByIndex(j);
          }
        }
      }
    }
  }

  public void addItem(String listId, String newType, String newValue) throws IOException{
    int id = Integer.parseInt(listId);
    MyList itemToChange = (MyList) this.findObject(id);

    if (newType.equals("object")) {
      Item newItem = this.findObject(Integer.parseInt(newValue));
      itemToChange.add(newItem);
    } else {
      itemToChange.add(newValue);
    }

    this.writer.update(this.dataArr);
  }

  public void addList(String newType, String newValue) throws IOException{
    String[] entries = newValue.split(",", -1);
    ArrayList<String> arr = new ArrayList<>();
    for (int i = 0; i < entries.length; i++) {
      arr.add(entries[i]);
    }

    if (newType.equals("notebook")) {
      ListFolder notebooks = this.getTopics();
      notebooks.create(arr);
      this.substituteWithObject(notebooks);
    } else if (newType.equals("list")) {
      ListFolder lists = this.getListFolder();
      lists.create(arr);
      this.substituteWithObject(lists);
    } else if (newType.equals("book")) {
      BookFolder books = this.getBookFolder();
      books.create(arr);
    } else {
      VideoFolder videos = this.getVideoFolder();
      videos.create(arr);
    }

    this.writer.update(this.dataArr);
  }

  public ArrayList<Object> searchFor(String s) {
    ArrayList<Object> arr = new ArrayList<>();

    for (ItemSet set : this.dataArr) {
      for (int i = 0; i < set.getSize(); i++) {
        if (((Item)set.get(i)).search(s)) {
          arr.add(set.get(i));
        }
      }
    }
    return arr;
  }

  public ListFolder getTopics() {
    return (ListFolder) this.dataArr.get(0);
  }

  public ListFolder getListFolder() {
    return (ListFolder) this.dataArr.get(1);
  }

  public BookFolder getBookFolder() {
    return (BookFolder) this.dataArr.get(2);
  }

  public VideoFolder getVideoFolder() {
    return (VideoFolder) this.dataArr.get(3);
  }

  private boolean isNumeric(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }
    return s.chars().allMatch(Character::isDigit);
  }
}
