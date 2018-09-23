package com.ning.blog.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Common {

    private SimpleDateFormat formatL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat formatS = new SimpleDateFormat("yyyy-MM-dd");

    public String getDateStrL(Date date) {
        return formatL.format(date);
    }

    public String getDateStrS(Date date) {
        return formatS.format(date);
    }

}
