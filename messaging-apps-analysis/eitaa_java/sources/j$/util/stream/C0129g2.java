package j$.util.stream;

import j$.util.Optional;

/* JADX INFO: Add missing generic type declarations: [T] */
/* renamed from: j$.util.stream.g2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0129g2<T> extends AbstractC0200y2<T, Optional<T>, C0133h2> {
    final /* synthetic */ j$.util.function.p b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0129g2(W2 w2, j$.util.function.p pVar) {
        super(w2);
        this.b = pVar;
    }

    @Override // j$.util.stream.AbstractC0200y2
    public InterfaceC0192w2 a() {
        return new C0133h2(this.b);
    }
}
