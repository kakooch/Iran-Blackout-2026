package j$.wrappers;

import j$.util.stream.InterfaceC0152g;
import java.util.Iterator;
import java.util.stream.BaseStream;

/* loaded from: classes2.dex */
public final /* synthetic */ class G0 implements InterfaceC0152g {
    final /* synthetic */ BaseStream a;

    private /* synthetic */ G0(BaseStream baseStream) {
        this.a = baseStream;
    }

    public static /* synthetic */ InterfaceC0152g o0(BaseStream baseStream) {
        if (baseStream == null) {
            return null;
        }
        return baseStream instanceof H0 ? ((H0) baseStream).a : new G0(baseStream);
    }

    @Override // j$.util.stream.InterfaceC0152g, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ InterfaceC0152g onClose(Runnable runnable) {
        return o0(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0152g parallel() {
        return o0(this.a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0152g, j$.util.stream.IntStream
    public /* synthetic */ InterfaceC0152g sequential() {
        return o0(this.a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ j$.util.t spliterator() {
        return C0275g.b(this.a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0152g
    public /* synthetic */ InterfaceC0152g unordered() {
        return o0(this.a.unordered());
    }
}
