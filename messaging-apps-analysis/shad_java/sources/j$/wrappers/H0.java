package j$.wrappers;

import j$.util.stream.InterfaceC0152g;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.BaseStream;

/* loaded from: classes2.dex */
public final /* synthetic */ class H0 implements BaseStream {
    final /* synthetic */ InterfaceC0152g a;

    private /* synthetic */ H0(InterfaceC0152g interfaceC0152g) {
        this.a = interfaceC0152g;
    }

    public static /* synthetic */ BaseStream o0(InterfaceC0152g interfaceC0152g) {
        if (interfaceC0152g == null) {
            return null;
        }
        return interfaceC0152g instanceof G0 ? ((G0) interfaceC0152g).a : new H0(interfaceC0152g);
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
        return o0(this.a.onClose(runnable));
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream parallel() {
        return o0(this.a.parallel());
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream sequential() {
        return o0(this.a.sequential());
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ Spliterator spliterator() {
        return C0277h.a(this.a.spliterator());
    }

    @Override // java.util.stream.BaseStream
    public /* synthetic */ BaseStream unordered() {
        return o0(this.a.unordered());
    }
}
