package j$.util.stream;

import j$.util.function.C0098i;
import j$.util.function.Consumer;
import j$.util.stream.C2;

/* renamed from: j$.util.stream.n2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0157n2 implements InterfaceC0192w2<Integer, Integer, C0157n2>, C2.f {
    private int a;
    final /* synthetic */ int b;
    final /* synthetic */ j$.util.function.x c;

    C0157n2(int i, j$.util.function.x xVar) {
        this.b = i;
        this.c = xVar;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ void accept(double d) {
        j$.time.a.c(this);
        throw null;
    }

    @Override // j$.util.stream.C2, j$.util.function.y
    public void accept(int i) {
        this.a = this.c.applyAsInt(this.a, i);
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
        return Integer.valueOf(this.a);
    }

    @Override // j$.util.stream.InterfaceC0192w2
    public void h(InterfaceC0192w2 interfaceC0192w2) {
        accept(((C0157n2) interfaceC0192w2).a);
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
        this.a = this.b;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ boolean o() {
        return false;
    }
}
