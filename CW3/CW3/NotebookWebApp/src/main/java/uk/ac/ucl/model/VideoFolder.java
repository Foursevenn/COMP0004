package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class VideoFolder extends ItemSet<Video> {
    private ArrayList<Video> set;
    private int nextIndex;

    public VideoFolder() {
        this.set = new ArrayList<>();
        this.nextIndex = 201;
    }

    public void add(int index, ArrayList<String> arr) {
        Video video = new Video(index, arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4));
        this.set.add(video);
        this.nextIndex++;
    }

    public void create(ArrayList<String> arr) {
        Video video = new Video(this.nextIndex, arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4));
        this.set.add(video);
        this.nextIndex++;
    }

    public Video get(int index) {
        return this.set.get(index);
    }

    public Video getById(int id) throws NoSuchElementException{
        for (Video video : this.set) {
            if (video.getId() == id) {
                return video;
            }
        }
        throw new NoSuchElementException();
    }

    public int getIndex(int id) throws NoSuchElementException {
        Video video = this.getById(id);
        return this.set.indexOf(video);
    }

    public void delete(int id) throws NoSuchElementException {
        Video video = this.getById(id);
        this.set.remove(video);
    }

    public void edit(int id, Video newVideo) throws NoSuchElementException{
        int index = this.getIndex(id);
        this.set.set(index, newVideo);
    }

    public int getSize() {
        return this.set.size();
    }
}
