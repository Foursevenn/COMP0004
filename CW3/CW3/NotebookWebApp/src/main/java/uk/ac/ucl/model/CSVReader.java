package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    private ListFolder listFolder;
    private BookFolder bookFolder;
    private VideoFolder videoFolder;
    private ListFolder topics;
    private File file;

    public CSVReader(File file) {
        this.listFolder = new ListFolder(11);
        this.bookFolder = new BookFolder();
        this.videoFolder = new VideoFolder();
        this.topics = new ListFolder(0);
        this.file = file;
    }

    public void readFile() throws IOException{
        Scanner scanner = new Scanner(this.file);
        String[] entries;

        while (scanner.hasNextLine()) {
            entries = scanner.nextLine().split(",", -1);
            int index = Integer.parseInt(entries[0]);

            if (index < 11) {
                this.parseTopic(index, entries);
            } else if (index < 101) {
                this.parseList(index, entries);
            } else if (index < 201) {
                this.parseBook(index, entries);
            } else {
                this.parseVideo(index, entries);
            }
        }
    }

    private void parseTopic(int index, String[] entries) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 1; i < entries.length; i++) {
            arr.add(entries[i]);
        }
        this.topics.add(index, arr);
    }

    private void parseList(int index, String[] entries) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 1; i < entries.length; i++) {
            arr.add(entries[i]);
        }
        this.listFolder.add(index, arr);
    }

    private void parseBook(int index, String[] entries) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 1; i < entries.length; i++) {
            arr.add(entries[i]);
        }
        this.bookFolder.add(index, arr);
    }

    private void parseVideo(int index, String[] entries) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 1; i < entries.length; i++) {
            arr.add(entries[i]);
        }
        this.videoFolder.add(index, arr);
    }

    public ArrayList<ItemSet> getFileData() {
        ArrayList<ItemSet> arr = new ArrayList<>();
        arr.add(this.topics);
        arr.add(this.listFolder);
        arr.add(this.bookFolder);
        arr.add(this.videoFolder);

        return arr;
    }
}
