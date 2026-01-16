package j$.util.stream;

import java.util.Iterator;

/* renamed from: j$.util.stream.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0152g extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    boolean isParallel();

    Iterator iterator();

    InterfaceC0152g onClose(Runnable runnable);

    InterfaceC0152g parallel();

    InterfaceC0152g sequential();

    j$.util.t spliterator();

    InterfaceC0152g unordered();
}
