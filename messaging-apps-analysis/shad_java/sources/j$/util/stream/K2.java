package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
class K2 extends T2 implements S2 {
    final /* synthetic */ j$.util.function.z b;
    final /* synthetic */ BiConsumer c;
    final /* synthetic */ BiConsumer d;

    K2(j$.util.function.z zVar, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.b = zVar;
        this.c = biConsumer;
        this.d = biConsumer2;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void accept(double d) {
        AbstractC0202o1.f(this);
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void accept(int i) {
        AbstractC0202o1.d(this);
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0192m3, j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public /* synthetic */ void accept(long j) {
        AbstractC0202o1.e(this);
        throw null;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        this.c.accept(this.a, obj);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.S2
    public void i(S2 s2) {
        this.d.accept(this.a, ((K2) s2).a);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void n() {
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        this.a = this.b.get();
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ boolean p() {
        return false;
    }
}
