package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Consumer;

/* JADX INFO: Add missing generic type declarations: [T, I] */
/* renamed from: j$.util.stream.j2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0141j2<I, T> extends AbstractC0196x2<I> implements InterfaceC0192w2<T, I, C0141j2> {
    final /* synthetic */ j$.util.function.L b;
    final /* synthetic */ BiConsumer c;
    final /* synthetic */ j$.util.function.p d;

    C0141j2(j$.util.function.L l, BiConsumer biConsumer, j$.util.function.p pVar) {
        this.b = l;
        this.c = biConsumer;
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
        this.c.accept(this.a, obj);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.InterfaceC0192w2
    public void h(InterfaceC0192w2 interfaceC0192w2) {
        this.a = this.d.apply(this.a, ((C0141j2) interfaceC0192w2).a);
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
