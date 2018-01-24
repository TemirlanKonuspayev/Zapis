package com.example.temirlan.zapis.utils;

import com.example.temirlan.zapis.model.Salon;

/**
 * Created by temirlan on 24.01.18.
 */

public class ReformatUtils {

    public static String workTime(Salon salon) {
        String result = "";
        if (salon != null) {
            String start = salon.getWorkStartTime();
            String end = salon.getWorkEndTime();
            result = start.substring(start.length() - 5, start.length()) + " - " + end.substring(start.length() - 5, start.length());
        }
        return result;
    }
}
