package com.fasterxml.jackson.core.util;

import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class InternCache extends ConcurrentHashMap<String, String> implements ConcurrentMap {
    public static final InternCache instance = new InternCache();
    private final Object lock;

    private InternCache() {
        super(180, 0.8f, 4);
        this.lock = new Object();
    }

    public String intern(String str) {
        String str2 = (String) get(str);
        if (str2 != null) {
            return str2;
        }
        if (size() >= 180) {
            synchronized (this.lock) {
                if (size() >= 180) {
                    clear();
                }
            }
        }
        String strIntern = str.intern();
        put(strIntern, strIntern);
        return strIntern;
    }
}
