package j$.util.stream;

import j$.util.function.C0098i;
import j$.util.function.Consumer;
import j$.util.stream.C2;

/* JADX INFO: Add missing generic type declarations: [R] */
/* renamed from: j$.util.stream.r2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0172r2<R> extends AbstractC0196x2<R> implements InterfaceC0192w2<Integer, R, C0172r2>, C2.f {
    final /* synthetic */ j$.util.function.L b;
    final /* synthetic */ j$.util.function.J c;
    final /* synthetic */ j$.util.function.p d;

    C0172r2(j$.util.function.L l, j$.util.function.J j, j$.util.function.p pVar) {
        this.b = l;
        this.c = j;
        this.d = pVar;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ void accept(double d) {
        j$.time.a.c(this);
        throw null;
    }

    @Override // j$.util.stream.C2, j$.util.function.y
    public void accept(int i) {
        this.c.accept(this.a, i);
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

    @Override // j$.util.stream.InterfaceC0192w2
    public void h(InterfaceC0192w2 interfaceC0192w2) {
        this.a = this.d.apply(this.a, ((C0172r2) interfaceC0192w2).a);
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
        this.a = this.b.get();
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ boolean o() {
        return false;
    }
}
