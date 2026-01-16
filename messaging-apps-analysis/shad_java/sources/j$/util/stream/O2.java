package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.InterfaceC0109b;

/* loaded from: classes2.dex */
class O2 extends T2 implements S2, InterfaceC0180k3 {
    final /* synthetic */ j$.util.function.z b;
    final /* synthetic */ j$.util.function.v c;
    final /* synthetic */ InterfaceC0109b d;

    O2(j$.util.function.z zVar, j$.util.function.v vVar, InterfaceC0109b interfaceC0109b) {
        this.b = zVar;
        this.c = vVar;
        this.d = interfaceC0109b;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Integer num) {
        AbstractC0202o1.b(this, num);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void accept(double d) {
        AbstractC0202o1.f(this);
        throw null;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void accept(int i) {
        this.c.accept(this.a, i);
    }

    @Override // j$.util.stream.InterfaceC0192m3, j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public /* synthetic */ void accept(long j) {
        AbstractC0202o1.e(this);
        throw null;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.S2
    public void i(S2 s2) {
        this.a = this.d.apply(this.a, ((O2) s2).a);
    }

    @Override // j$.util.function.l
    public j$.util.function.l m(j$.util.function.l lVar) {
        lVar.getClass();
        return new j$.util.function.k(this, lVar);
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
