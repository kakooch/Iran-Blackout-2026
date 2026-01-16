package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.InterfaceC0109b;

/* loaded from: classes2.dex */
class G2 extends T2 implements S2 {
    final /* synthetic */ Object b;
    final /* synthetic */ BiFunction c;
    final /* synthetic */ InterfaceC0109b d;

    G2(Object obj, BiFunction biFunction, InterfaceC0109b interfaceC0109b) {
        this.b = obj;
        this.c = biFunction;
        this.d = interfaceC0109b;
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
        this.a = this.c.apply(this.a, obj);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.S2
    public void i(S2 s2) {
        this.a = this.d.apply(this.a, ((G2) s2).a);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void n() {
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        this.a = this.b;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ boolean p() {
        return false;
    }
}
