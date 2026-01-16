package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.Consumer;

/* JADX INFO: Add missing generic type declarations: [T, U] */
/* renamed from: j$.util.stream.f2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0125f2<T, U> extends AbstractC0196x2<U> implements InterfaceC0192w2<T, U, C0125f2> {
    final /* synthetic */ Object b;
    final /* synthetic */ BiFunction c;
    final /* synthetic */ j$.util.function.p d;

    C0125f2(Object obj, BiFunction biFunction, j$.util.function.p pVar) {
        this.b = obj;
        this.c = biFunction;
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
    public /* synthetic */ void accept(long j) {
        j$.time.a.b(this);
        throw null;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        this.a = this.c.apply(this.a, obj);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0192w2
    public void h(InterfaceC0192w2 interfaceC0192w2) {
        this.a = this.d.apply(this.a, ((C0125f2) interfaceC0192w2).a);
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
