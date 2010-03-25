package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Project extends Model {
    
    public String name;
    public String path;
    
    public String framework;
    
    public boolean runInXvfb = false;
    public String updateCommand;
    public String versionCommand;
    public String versionPattern = "%version";
    public String revisionDetailPattern = "";
    
    public String[] notifications;
    
}

