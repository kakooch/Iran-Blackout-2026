package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.Consumer;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* renamed from: j$.util.stream.l2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0149l2<R, T> extends AbstractC0196x2<R> implements InterfaceC0192w2<T, R, C0149l2> {
    final /* synthetic */ j$.util.function.L b;
    final /* synthetic */ BiConsumer c;
    final /* synthetic */ BiConsumer d;

    C0149l2(j$.util.function.L l, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.b = l;
        this.c = biConsumer;
        this.d = biConsumer2;
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
        this.d.accept(this.a, ((C0149l2) interfaceC0192w2).a);
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
