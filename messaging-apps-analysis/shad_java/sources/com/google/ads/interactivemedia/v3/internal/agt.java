package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class agt<T> {
    public final T fromJson(Reader reader) throws IOException {
        return read(new alb(reader));
    }

    public final T fromJsonTree(agj agjVar) {
        try {
            return read(new ais(agjVar));
        } catch (IOException e) {
            throw new agk(e);
        }
    }

    public final agt<T> nullSafe() {
        return new ags(this);
    }

    public abstract T read(alb albVar) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new ald(writer), t);
    }

    public final agj toJsonTree(T t) {
        try {
            aiu aiuVar = new aiu();
            write(aiuVar, t);
            return aiuVar.a();
        } catch (IOException e) {
            throw new agk(e);
        }
    }

    public abstract void write(ald aldVar, T t) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
