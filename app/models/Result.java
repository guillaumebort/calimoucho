package models;

import java.io.*;
import java.util.*;

import play.*;
import play.libs.*;
import play.db.jpa.*;

import javax.persistence.*;

@Entity
public class Result extends Model {
    
    public String uid;
    public String name;
    public String version;
    public String revisionDetail;
    public boolean passed;
    public long timestamp;
    
    public Result(String uid, String name, String version, String revisionDetail, boolean passed) {
        this.uid = uid;
        this.name = name;
        this.passed = passed;
        this.version = version;
        this.revisionDetail = revisionDetail;
        this.timestamp = System.currentTimeMillis();
    }
    
    public List<String> tests() {
        File f = Play.getFile("results/"+uid);
        List<String> tests = new ArrayList();
        for(File t : f.listFiles()) {
            if(t.getName().matches(".*\\.(passed|failed)\\.html")) {
                tests.add(t.getName());
            }
        }
        return tests;
    }
    
    public String test(String test) {
        File f = Play.getFile("results/"+uid);
        File t = new File(f, test);
        try {
            return IO.readContentAsString(t);
        } catch(Exception e) {
            return null;
        }
    }
    
    // ~~
    
    public static Result findByUID(String uid) {
        return find("uid", uid).first();
    }

    public static List<Result> latests() {
        return find("order by timestamp").fetch(16);
    }
    
}

