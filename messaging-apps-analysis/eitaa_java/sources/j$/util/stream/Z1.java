package j$.util.stream;

import j$.util.function.C0095f;
import j$.util.function.Consumer;
import j$.util.stream.C2;

/* loaded from: classes2.dex */
class Z1 implements InterfaceC0192w2<Double, Double, Z1>, C2.e {
    private double a;
    final /* synthetic */ double b;
    final /* synthetic */ j$.util.function.r c;

    Z1(double d, j$.util.function.r rVar) {
        this.b = d;
        this.c = rVar;
    }

    @Override // j$.util.stream.C2
    public void accept(double d) {
        this.a = this.c.applyAsDouble(this.a, d);
    }

    @Override // j$.util.stream.C2, j$.util.function.y
    public /* synthetic */ void accept(int i) {
        j$.time.a.a(this);
        throw null;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ void accept(long j) {
        j$.time.a.b(this);
        throw null;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Double d) {
        S1.a(this, d);
    }

    @Override // j$.util.function.L
    public Object get() {
        return Double.valueOf(this.a);
    }

    @Override // j$.util.stream.InterfaceC0192w2
    public void h(InterfaceC0192w2 interfaceC0192w2) {
        accept(((Z1) interfaceC0192w2).a);
    }

    @Override // j$.util.function.s
    public j$.util.function.s j(j$.util.function.s sVar) {
        sVar.getClass();
        return new C0095f(this, sVar);
    }

    @Override // j$.util.stream.C2
    public void l() {
    }

    @Override // j$.util.stream.C2
    public void m(long j) {
        this.a = this.b;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ boolean o() {
        return false;
    }
}
