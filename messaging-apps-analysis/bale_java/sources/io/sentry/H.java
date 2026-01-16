package io.sentry;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class H {
    private static final H b = new H();
    private final List a = new CopyOnWriteArrayList();

    public interface a {
    }

    private H() {
    }

    public static H a() {
        return b;
    }

    public void b(a aVar) {
        this.a.add(aVar);
    }
}
