package j$.util.stream;

import j$.util.function.C0098i;
import j$.util.function.Consumer;
import j$.util.stream.C2;

/* renamed from: j$.util.stream.p2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0165p2 implements InterfaceC0192w2<Integer, j$.util.p, C0165p2>, C2.f {
    private boolean a;
    private int b;
    final /* synthetic */ j$.util.function.x c;

    C0165p2(j$.util.function.x xVar) {
        this.c = xVar;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ void accept(double d) {
        j$.time.a.c(this);
        throw null;
    }

    @Override // j$.util.stream.C2, j$.util.function.y
    public void accept(int i) {
        if (this.a) {
            this.a = false;
        } else {
            i = this.c.applyAsInt(this.b, i);
        }
        this.b = i;
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
    public /* synthetic */ void accept(Integer num) {
        S1.b(this, num);
    }

    @Override // j$.util.function.L
    public Object get() {
        return this.a ? j$.util.p.a() : j$.util.p.d(this.b);
    }

    @Override // j$.util.stream.InterfaceC0192w2
    public void h(InterfaceC0192w2 interfaceC0192w2) {
        C0165p2 c0165p2 = (C0165p2) interfaceC0192w2;
        if (c0165p2.a) {
            return;
        }
        accept(c0165p2.b);
    }

    @Override // j$.util.function.y
    public j$.util.function.y k(j$.util.function.y yVar) {
        yVar.getClass();
        return new C0098i(this, yVar);
    }

    @Override // j$.util.stream.C2
    public void l() {
    }

    @Override // j$.util.stream.C2
    public void m(long j) {
        this.a = true;
        this.b = 0;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ boolean o() {
        return false;
    }
}
