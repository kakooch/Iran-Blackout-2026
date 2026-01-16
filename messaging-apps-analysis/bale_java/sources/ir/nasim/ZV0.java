package ir.nasim;

import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ZV0 implements Closeable {
    private boolean a;
    private final Map b = new LinkedHashMap();

    public final synchronized void a(Closeable closeable) {
        AbstractC13042fc3.i(closeable, "closable");
        if (this.a) {
            closeable.close();
        } else {
            this.b.put(closeable, closeable);
        }
    }

    public final synchronized void b(Object obj, Closeable closeable) {
        AbstractC13042fc3.i(obj, "key");
        AbstractC13042fc3.i(closeable, "closer");
        if (this.a) {
            closeable.close();
        } else {
            this.b.put(obj, closeable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            this.a = true;
            Iterator it = this.b.values().iterator();
            while (it.hasNext()) {
                ((Closeable) it.next()).close();
            }
            this.b.clear();
        } catch (Throwable th) {
            throw th;
        }
    }
}
