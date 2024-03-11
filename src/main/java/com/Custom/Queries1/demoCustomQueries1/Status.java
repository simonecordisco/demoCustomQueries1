package com.Custom.Queries1.demoCustomQueries1;

import java.util.Iterator;

public enum Status implements ch.qos.logback.core.status.Status {

        ON_TIME,
        DELAYED,
        CANCELLED;

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getEffectiveLevel() {
        return 0;
    }

    @Override
    public Object getOrigin() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public Throwable getThrowable() {
        return null;
    }

    @Override
    public long getTimestamp() {
        return 0;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public void add(ch.qos.logback.core.status.Status status) {

    }

    @Override
    public boolean remove(ch.qos.logback.core.status.Status status) {
        return false;
    }

    @Override
    public Iterator<ch.qos.logback.core.status.Status> iterator() {
        return null;
    }
}

