package j$.util.stream;

import j$.util.function.Consumer;
import java.util.List;

/* renamed from: j$.util.stream.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0122b implements j$.util.function.z, j$.util.function.r, Consumer, j$.util.function.c {
    public final /* synthetic */ int a = 2;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0122b(j$.util.t tVar) {
        this.b = tVar;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        switch (this.a) {
            case 3:
                ((InterfaceC0192m3) this.b).accept((InterfaceC0192m3) obj);
                break;
            default:
                ((List) this.b).add(obj);
                break;
        }
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.r
    public Object apply(long j) {
        j$.util.function.m mVar = (j$.util.function.m) this.b;
        int i = H1.k;
        return AbstractC0251x2.d(j, mVar);
    }

    @Override // j$.util.function.z
    public Object get() {
        switch (this.a) {
            case 0:
                return (j$.util.t) this.b;
            default:
                return ((AbstractC0128c) this.b).E0();
        }
    }

    public /* synthetic */ C0122b(AbstractC0128c abstractC0128c) {
        this.b = abstractC0128c;
    }
}
