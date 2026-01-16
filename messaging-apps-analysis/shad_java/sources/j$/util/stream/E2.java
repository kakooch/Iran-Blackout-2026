package j$.util.stream;

import j$.util.C0113j;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
class E2 implements S2, InterfaceC0174j3 {
    private boolean a;
    private double b;
    final /* synthetic */ j$.util.function.d c;

    E2(j$.util.function.d dVar) {
        this.c = dVar;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Double d) {
        AbstractC0202o1.a(this, d);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void accept(double d) {
        if (this.a) {
            this.a = false;
        } else {
            d = this.c.applyAsDouble(this.b, d);
        }
        this.b = d;
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

    @Override // j$.util.function.z
    public Object get() {
        return this.a ? C0113j.a() : C0113j.d(this.b);
    }

    @Override // j$.util.stream.S2
    public void i(S2 s2) {
        E2 e2 = (E2) s2;
        if (e2.a) {
            return;
        }
        accept(e2.b);
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
        this.a = true;
        this.b = 0.0d;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ boolean p() {
        return false;
    }
}
