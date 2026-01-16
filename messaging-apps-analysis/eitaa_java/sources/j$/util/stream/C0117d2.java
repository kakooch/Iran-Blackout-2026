package j$.util.stream;

import j$.util.function.C0095f;
import j$.util.function.Consumer;
import j$.util.stream.C2;

/* JADX INFO: Add missing generic type declarations: [R] */
/* renamed from: j$.util.stream.d2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0117d2<R> extends AbstractC0196x2<R> implements InterfaceC0192w2<Double, R, C0117d2>, C2.e {
    final /* synthetic */ j$.util.function.L b;
    final /* synthetic */ j$.util.function.I c;
    final /* synthetic */ j$.util.function.p d;

    C0117d2(j$.util.function.L l, j$.util.function.I i, j$.util.function.p pVar) {
        this.b = l;
        this.c = i;
        this.d = pVar;
    }

    @Override // j$.util.stream.C2
    public void accept(double d) {
        this.c.accept(this.a, d);
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

    @Override // j$.util.stream.InterfaceC0192w2
    public void h(InterfaceC0192w2 interfaceC0192w2) {
        this.a = this.d.apply(this.a, ((C0117d2) interfaceC0192w2).a);
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
        this.a = this.b.get();
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ boolean o() {
        return false;
    }
}
