package ir.nasim;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class YW7 {
    private final B47 a = new B47();
    private final Map b = new LinkedHashMap();
    private final Set c = new LinkedHashSet();
    private volatile boolean d;

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(AutoCloseable autoCloseable) throws Exception {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final void d(AutoCloseable autoCloseable) throws Exception {
        AbstractC13042fc3.i(autoCloseable, "closeable");
        if (this.d) {
            g(autoCloseable);
            return;
        }
        synchronized (this.a) {
            this.c.add(autoCloseable);
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    public final void e(String str, AutoCloseable autoCloseable) throws Exception {
        AutoCloseable autoCloseable2;
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(autoCloseable, "closeable");
        if (this.d) {
            g(autoCloseable);
            return;
        }
        synchronized (this.a) {
            autoCloseable2 = (AutoCloseable) this.b.put(str, autoCloseable);
        }
        g(autoCloseable2);
    }

    public final void f() {
        if (this.d) {
            return;
        }
        this.d = true;
        synchronized (this.a) {
            try {
                Iterator it = this.b.values().iterator();
                while (it.hasNext()) {
                    g((AutoCloseable) it.next());
                }
                Iterator it2 = this.c.iterator();
                while (it2.hasNext()) {
                    g((AutoCloseable) it2.next());
                }
                this.c.clear();
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final AutoCloseable h(String str) {
        AutoCloseable autoCloseable;
        AbstractC13042fc3.i(str, "key");
        synchronized (this.a) {
            autoCloseable = (AutoCloseable) this.b.get(str);
        }
        return autoCloseable;
    }
}
