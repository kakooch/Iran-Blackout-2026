package com.google.ads.interactivemedia.v3.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Queue;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class zv {
    private final BufferedReader a;
    private final Queue<String> b;
    private String c;

    public zv(Queue<String> queue, BufferedReader bufferedReader) {
        this.b = queue;
        this.a = bufferedReader;
    }

    public final boolean a() throws IOException {
        String strTrim;
        if (this.c != null) {
            return true;
        }
        if (!this.b.isEmpty()) {
            String strPoll = this.b.poll();
            ary.t(strPoll);
            this.c = strPoll;
            return true;
        }
        do {
            String line = this.a.readLine();
            this.c = line;
            if (line == null) {
                return false;
            }
            strTrim = line.trim();
            this.c = strTrim;
        } while (strTrim.isEmpty());
        return true;
    }

    public final String b() throws IOException {
        if (!a()) {
            throw new NoSuchElementException();
        }
        String str = this.c;
        this.c = null;
        return str;
    }
}
