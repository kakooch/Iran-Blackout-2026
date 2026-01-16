package j$;

import j$.util.stream.InterfaceC0164p1;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.BaseStream;

/* loaded from: classes2.dex */
public final /* synthetic */ class I0 implements BaseStream {
    final /* synthetic */ InterfaceC0164p1 a;

    private /* synthetic */ I0(InterfaceC0164p1 interfaceC0164p1) {
        this.a = interfaceC0164p1;
    }

    public static /* synthetic */ BaseStream l0(InterfaceC0164p1 interfaceC0164p1) {
        if (interfaceC0164p1 == null) {
            return null;
        }
        return interfaceC0164p1 instanceof H0 ? ((H0) interfaceC0164p1).a : new I0(interfaceC0164p1);
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream onClose(Runnable runnable) {
        return l0(this.a.onClose(runnable));
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream parallel() {
        return l0(this.a.parallel());
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream sequential() {
        return l0(this.a.sequential());
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ Spliterator spliterator() {
        return C0066h.a(this.a.spliterator());
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream unordered() {
        return l0(this.a.unordered());
    }
}
