package j$.util.stream;

import j$.util.function.Predicate;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes2.dex */
class K1<T> extends O1<T> {
    final /* synthetic */ P1 c;
    final /* synthetic */ Predicate d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    K1(P1 p1, Predicate predicate) {
        super(p1);
        this.c = p1;
        this.d = predicate;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        if (this.a || this.d.test(obj) != this.c.b) {
            return;
        }
        this.a = true;
        this.b = this.c.c;
    }
}
