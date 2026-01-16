package j$.util.stream;

import j$.util.function.C0099j;
import j$.util.function.Consumer;
import j$.util.stream.C2;

/* JADX INFO: Add missing generic type declarations: [R] */
/* loaded from: classes2.dex */
class X1<R> extends AbstractC0196x2<R> implements InterfaceC0192w2<Long, R, X1>, C2.g {
    final /* synthetic */ j$.util.function.L b;
    final /* synthetic */ j$.util.function.K c;
    final /* synthetic */ j$.util.function.p d;

    X1(j$.util.function.L l, j$.util.function.K k, j$.util.function.p pVar) {
        this.b = l;
        this.c = k;
        this.d = pVar;
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
        this.c.accept(this.a, j);
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

    @Override // j$.util.stream.InterfaceC0192w2
    public void h(InterfaceC0192w2 interfaceC0192w2) {
        this.a = this.d.apply(this.a, ((X1) interfaceC0192w2).a);
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
