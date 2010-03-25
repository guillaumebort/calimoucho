package notifiers;

import java.util.*;

import play.*;
import play.mvc.*;

public class Notifier extends Mailer {

    public static void sendResult(int id, String project, String version, boolean passed, String[] to) {
        setSubject("[" + Play.configuration.getProperty("mail.tag", "calimoucho")+"] %s - For %s, %s", (passed ? "PASSED" : "FAILED"), project, version);
        setFrom(Play.configuration.getProperty("mail.from"));
        addRecipient(to);
        send(id);
    }
    
}

