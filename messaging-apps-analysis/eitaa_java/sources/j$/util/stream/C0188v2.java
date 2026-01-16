package j$.util.stream;

import j$.util.function.C0099j;
import j$.util.function.Consumer;
import j$.util.stream.C2;

/* renamed from: j$.util.stream.v2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0188v2 implements InterfaceC0192w2<Long, j$.util.q, C0188v2>, C2.g {
    private boolean a;
    private long b;
    final /* synthetic */ j$.util.function.D c;

    C0188v2(j$.util.function.D d) {
        this.c = d;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ void accept(double d) {
        j$.time.a.c(this);
        throw null;
    }

    @Override // j$.util.stream.C2, j$.util.function.y
    public /* synthetic */ void accept(int i) {
        j$.time.a.a(this);
        throw null;
    }

    @Override // j$.util.stream.C2
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

    @Override // j$.util.function.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void accept(Long l) {
        S1.c(this, l);
    }

    @Override // j$.util.function.E
    public j$.util.function.E f(j$.util.function.E e) {
        e.getClass();
        return new C0099j(this, e);
    }

    @Override // j$.util.function.L
    public Object get() {
        return this.a ? j$.util.q.a() : j$.util.q.d(this.b);
    }

    @Override // j$.util.stream.InterfaceC0192w2
    public void h(InterfaceC0192w2 interfaceC0192w2) {
        C0188v2 c0188v2 = (C0188v2) interfaceC0192w2;
        if (c0188v2.a) {
            return;
        }
        accept(c0188v2.b);
    }

    @Override // j$.util.stream.C2
    public void l() {
    }

    @Override // j$.util.stream.C2
    public void m(long j) {
        this.a = true;
        this.b = 0L;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ boolean o() {
        return false;
    }
}
