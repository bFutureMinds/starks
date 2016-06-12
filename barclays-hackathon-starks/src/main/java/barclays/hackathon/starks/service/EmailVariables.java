package barclays.hackathon.starks.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bajrang on 18-12-2015.
 */
public class EmailVariables {
    private Map<Type, Object> map;

    public EmailVariables() {
        map = new HashMap<Type, Object>();
    }

    public void addNew(Type type, Object value) {
        map.put(type, value);
    }

    public static enum Type {
        SUBJECT("subject"),
        USER_NAME("user_name"),
        USER_EMAIL("user_email"),
        USER_ORDER("order"),
        NOTIFICATION_URL("notification_url"),
        BCC_EMAIL("bcc_email");
        private String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public Map<Type, Object> getMap() {
        return map;
    }
}
