package j$.util.stream;

import j$.util.function.C0095f;
import j$.util.function.Consumer;
import j$.util.stream.C2;

/* renamed from: j$.util.stream.b2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0109b2 implements InterfaceC0192w2<Double, j$.util.o, C0109b2>, C2.e {
    private boolean a;
    private double b;
    final /* synthetic */ j$.util.function.r c;

    C0109b2(j$.util.function.r rVar) {
        this.c = rVar;
    }

    @Override // j$.util.stream.C2
    public void accept(double d) {
        if (this.a) {
            this.a = false;
        } else {
            d = this.c.applyAsDouble(this.b, d);
        }
        this.b = d;
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
        return this.a ? j$.util.o.a() : j$.util.o.d(this.b);
    }

    @Override // j$.util.stream.InterfaceC0192w2
    public void h(InterfaceC0192w2 interfaceC0192w2) {
        C0109b2 c0109b2 = (C0109b2) interfaceC0192w2;
        if (c0109b2.a) {
            return;
        }
        accept(c0109b2.b);
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
        this.a = true;
        this.b = 0.0d;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ boolean o() {
        return false;
    }
}
