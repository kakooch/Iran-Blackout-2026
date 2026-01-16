package j$.util.stream;

import j$.util.function.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class V0 implements Predicate {
    public static final /* synthetic */ V0 a = new V0();

    private /* synthetic */ V0() {
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
        return ((j$.util.o) obj).c();
    }
}
