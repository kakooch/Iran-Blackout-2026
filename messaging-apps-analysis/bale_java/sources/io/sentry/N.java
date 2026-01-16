package io.sentry;

import java.io.Closeable;

/* loaded from: classes3.dex */
public interface N extends Closeable {

    public enum a {
        UNKNOWN,
        CONNECTED,
        DISCONNECTED,
        NO_PERMISSION
    }

    public interface b {
        void b(a aVar);
    }

    void L1(b bVar);

    String W();

    boolean v1(b bVar);

    a w0();
}
