package j$.util.stream;

import j$.util.C0114k;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
class N2 implements S2, InterfaceC0180k3 {
    private boolean a;
    private int b;
    final /* synthetic */ j$.util.function.j c;

    N2(j$.util.function.j jVar) {
        this.c = jVar;
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
        if (this.a) {
            this.a = false;
        } else {
            i = this.c.applyAsInt(this.b, i);
        }
        this.b = i;
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
        return this.a ? C0114k.a() : C0114k.d(this.b);
    }

    @Override // j$.util.stream.S2
    public void i(S2 s2) {
        N2 n2 = (N2) s2;
        if (n2.a) {
            return;
        }
        accept(n2.b);
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
        this.a = true;
        this.b = 0;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ boolean p() {
        return false;
    }
}
