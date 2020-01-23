package com.propellerads.util;

public enum Period {

    DAY("За сутки"),
    WEEKS("За 2 недели"),
    MONTH("За месяц");

    public final String text;

    Period(String text) {
        this.text = text;
    }
}
