package j$;

import j$.util.Spliterator;
import j$.util.stream.InterfaceC0164p1;
import java.util.Iterator;
import java.util.stream.BaseStream;

/* loaded from: classes2.dex */
public final /* synthetic */ class H0 implements InterfaceC0164p1 {
    final /* synthetic */ BaseStream a;

    private /* synthetic */ H0(BaseStream baseStream) {
        this.a = baseStream;
    }

    public static /* synthetic */ InterfaceC0164p1 l0(BaseStream baseStream) {
        if (baseStream == null) {
            return null;
        }
        return baseStream instanceof I0 ? ((I0) baseStream).a : new H0(baseStream);
    }

    @Override // j$.util.stream.InterfaceC0164p1, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 onClose(Runnable runnable) {
        return l0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 parallel() {
        return l0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 sequential() {
        return l0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ Spliterator spliterator() {
        return C0064g.a(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0164p1
    public /* synthetic */ InterfaceC0164p1 unordered() {
        return l0(this.a.unordered());
    }
}
