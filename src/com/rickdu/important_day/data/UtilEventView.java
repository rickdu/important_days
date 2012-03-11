package com.rickdu.important_day.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Rick
 * Date: 3/11/12
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class UtilEventView {

    public static Map<String, String> toMap(EventView ev) {
        Map<String, String> map = new HashMap<String, String>();
        map.put(DatabaseHandler.KEY_ID, String.valueOf(ev.getId()));
        map.put(DatabaseHandler.KEY_TYPE, ev.getType());
        map.put(DatabaseHandler.KEY_NAME, ev.getName());
        map.put(DatabaseHandler.KEY_YEAR, String.valueOf(ev.getYear()));
        map.put(DatabaseHandler.KEY_MONTH, String.valueOf(ev.getMonth()));
        map.put(DatabaseHandler.KEY_DAY, String.valueOf(ev.getDay()));
        map.put(DatabaseHandler.KEY_COMMENT, ev.getComment());
        map.put(DatabaseHandler.KEY_TAG, ev.getTag());
        return map;
    }
}
