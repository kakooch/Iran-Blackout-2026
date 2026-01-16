package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.InterfaceC0109b;

/* loaded from: classes2.dex */
class F2 extends T2 implements S2, InterfaceC0174j3 {
    final /* synthetic */ j$.util.function.z b;
    final /* synthetic */ j$.util.function.u c;
    final /* synthetic */ InterfaceC0109b d;

    F2(j$.util.function.z zVar, j$.util.function.u uVar, InterfaceC0109b interfaceC0109b) {
        this.b = zVar;
        this.c = uVar;
        this.d = interfaceC0109b;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Double d) {
        AbstractC0202o1.a(this, d);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void accept(double d) {
        this.c.accept(this.a, d);
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
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.S2
    public void i(S2 s2) {
        this.a = this.d.apply(this.a, ((F2) s2).a);
    }

    @Override // j$.util.function.f
    public j$.util.function.f k(j$.util.function.f fVar) {
        fVar.getClass();
        return new j$.util.function.e(this, fVar);
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
