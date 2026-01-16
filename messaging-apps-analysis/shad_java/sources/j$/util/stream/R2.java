package j$.util.stream;

import j$.util.C0115l;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
class R2 implements S2, InterfaceC0186l3 {
    private boolean a;
    private long b;
    final /* synthetic */ j$.util.function.o c;

    R2(j$.util.function.o oVar) {
        this.c = oVar;
    }

    @Override // j$.util.function.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Long l) {
        AbstractC0202o1.c(this, l);
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
    public void accept(long j) {
        if (this.a) {
            this.a = false;
        } else {
            j = this.c.applyAsLong(this.b, j);
        }
        this.b = j;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.q
    public j$.util.function.q f(j$.util.function.q qVar) {
        qVar.getClass();
        return new j$.util.function.p(this, qVar);
    }

    @Override // j$.util.function.z
    public Object get() {
        return this.a ? C0115l.a() : C0115l.d(this.b);
    }

    @Override // j$.util.stream.S2
    public void i(S2 s2) {
        R2 r2 = (R2) s2;
        if (r2.a) {
            return;
        }
        accept(r2.b);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void n() {
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        this.a = true;
        this.b = 0L;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ boolean p() {
        return false;
    }
}
