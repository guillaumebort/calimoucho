import java.util.*;

import play.*;
import play.jobs.*;
import play.test.*;
import play.libs.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        Logger.info("");
        Logger.info("Calimoucho ~ Play continuous integration server");
        Logger.info("");
        
        if(Project.count() == 0) {
            Fixtures.load("projects.yml");
            Files.deleteDirectory(Play.getFile("results"));
        }
        
        Logger.info("%s projects:", Project.count());
        
        List<Project> projects = Project.findAll();
        for(Project project : projects) {
            Logger.info("  - %s", project.name);
        }
        
    }
    
}

