package j$.util.stream;

import j$.util.function.Predicate;

/* renamed from: j$.util.stream.c1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0112c1 implements Predicate {
    public static final /* synthetic */ C0112c1 a = new C0112c1();

    private /* synthetic */ C0112c1() {
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
        return ((j$.util.q) obj).c();
    }
}
