package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.InterfaceC0164p1;
import java.util.Iterator;

/* renamed from: j$.util.stream.p1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0164p1<T, S extends InterfaceC0164p1<T, S>> extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    boolean isParallel();

    Iterator iterator();

    InterfaceC0164p1 onClose(Runnable runnable);

    InterfaceC0164p1 parallel();

    InterfaceC0164p1 sequential();

    Spliterator spliterator();

    InterfaceC0164p1 unordered();
}
