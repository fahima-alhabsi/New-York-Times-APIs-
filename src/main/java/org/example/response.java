package org.example;
import java.util.ArrayList ;
public class response {

    ArrayList<docs> docs = new ArrayList<docs>();
    meta meta =new meta();

    public ArrayList<org.example.docs> getDocs() {
        return docs;
    }

    public void setDocs(ArrayList<org.example.docs> docs) {
        this.docs = docs;
    }

    public org.example.meta getMeta() {
        return meta;
    }

    public void setMeta(org.example.meta meta) {
        this.meta = meta;
    }
}
