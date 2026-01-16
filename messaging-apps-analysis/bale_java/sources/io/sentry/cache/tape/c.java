package io.sentry.cache.tape;

import java.io.Closeable;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class c implements Iterable, Closeable {

    public interface a {
        void a(Object obj, OutputStream outputStream);

        Object b(byte[] bArr);
    }

    public static c S(d dVar, a aVar) {
        return new b(dVar, aVar);
    }

    public static c Z() {
        return new io.sentry.cache.tape.a();
    }

    public List P() {
        return d0(size());
    }

    public void clear() {
        f0(size());
    }

    public List d0(int i) {
        int iMin = Math.min(i, size());
        ArrayList arrayList = new ArrayList(iMin);
        Iterator it = iterator();
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(it.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public abstract void f0(int i);

    public abstract void j(Object obj);

    public abstract int size();
}
