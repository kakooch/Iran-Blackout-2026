package j$.util.stream;

import j$.util.function.BiFunction;

/* JADX INFO: Add missing generic type declarations: [T, U] */
/* renamed from: j$.util.stream.e2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0121e2<T, U> extends AbstractC0200y2<T, U, C0125f2> {
    final /* synthetic */ j$.util.function.p b;
    final /* synthetic */ BiFunction c;
    final /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0121e2(W2 w2, j$.util.function.p pVar, BiFunction biFunction, Object obj) {
        super(w2);
        this.b = pVar;
        this.c = biFunction;
        this.d = obj;
    }

    @Override // j$.util.stream.AbstractC0200y2
    public InterfaceC0192w2 a() {
        return new C0125f2(this.d, this.c, this.b);
    }
}
