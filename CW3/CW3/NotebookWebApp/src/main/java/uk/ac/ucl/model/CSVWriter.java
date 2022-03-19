package uk.ac.ucl.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWriter {

    public void update(ArrayList<ItemSet> data) throws IOException {
        FileWriter fileWriter = new FileWriter(new File("./src/main/webapp/data/data.csv"));
        fileWriter.write(this.getList(data.get(0))+"\n");
        fileWriter.write(this.getList(data.get(1))+"\n");
        fileWriter.write(this.getList(data.get(2))+"\n");
        fileWriter.write(this.getList(data.get(3)));
        fileWriter.close();
    }

    private String getList(ItemSet itemSet) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < itemSet.getSize(); i++) {
            Item list = (Item) itemSet.get(i);
            sb.append(list.getId()+",");
            sb.append(list.getTitle()+",");

            for (int j = 0; j < list.getSize(); j++) {
                Object item = list.getByIndex(j);

                if (item instanceof Item) {
                    sb.append(((Item) item).getId()+",");
                } else {
                    sb.append((String) item + ",");
                }
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
