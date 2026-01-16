package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.stream.Collector;

/* JADX INFO: Add missing generic type declarations: [T, I] */
/* renamed from: j$.util.stream.i2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0137i2<I, T> extends AbstractC0200y2<T, I, C0141j2> {
    final /* synthetic */ j$.util.function.p b;
    final /* synthetic */ BiConsumer c;
    final /* synthetic */ j$.util.function.L d;
    final /* synthetic */ Collector e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0137i2(W2 w2, j$.util.function.p pVar, BiConsumer biConsumer, j$.util.function.L l, Collector collector) {
        super(w2);
        this.b = pVar;
        this.c = biConsumer;
        this.d = l;
        this.e = collector;
    }

    @Override // j$.util.stream.AbstractC0200y2
    public InterfaceC0192w2 a() {
        return new C0141j2(this.d, this.c, this.b);
    }

    @Override // j$.util.stream.AbstractC0200y2, j$.util.stream.i3
    public int b() {
        if (this.e.characteristics().contains(Collector.a.UNORDERED)) {
            return V2.m;
        }
        return 0;
    }
}
