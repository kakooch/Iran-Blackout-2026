package j$.util.stream;

import j$.util.function.BiConsumer;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* renamed from: j$.util.stream.k2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0145k2<R, T> extends AbstractC0200y2<T, R, C0149l2> {
    final /* synthetic */ BiConsumer b;
    final /* synthetic */ BiConsumer c;
    final /* synthetic */ j$.util.function.L d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0145k2(W2 w2, BiConsumer biConsumer, BiConsumer biConsumer2, j$.util.function.L l) {
        super(w2);
        this.b = biConsumer;
        this.c = biConsumer2;
        this.d = l;
    }

    @Override // j$.util.stream.AbstractC0200y2
    public InterfaceC0192w2 a() {
        return new C0149l2(this.d, this.c, this.b);
    }
}
