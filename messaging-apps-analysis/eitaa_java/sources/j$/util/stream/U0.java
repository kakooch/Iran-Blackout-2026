package j$.util.stream;

import j$.util.function.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class U0 implements Predicate {
    public static final /* synthetic */ U0 a = new U0();

    private /* synthetic */ U0() {
    }

    @Override // j$.util.function.Predicate
    public Predicate a(Predicate predicate) {
        predicate.getClass();
        return new j$.util.function.m(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public Predicate b(Predicate predicate) {
        predicate.getClass();
        return new j$.util.function.o(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public Predicate negate() {
        return new j$.util.function.n(this);
    }

    @Override // j$.util.function.Predicate
    public final boolean test(Object obj) {
        return ((j$.util.p) obj).c();
    }
}
