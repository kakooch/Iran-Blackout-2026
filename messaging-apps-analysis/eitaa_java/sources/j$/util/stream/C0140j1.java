package j$.util.stream;

import j$.util.Optional;
import j$.util.function.Predicate;

/* renamed from: j$.util.stream.j1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0140j1 implements Predicate {
    public static final /* synthetic */ C0140j1 a = new C0140j1();

    private /* synthetic */ C0140j1() {
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
        return ((Optional) obj).isPresent();
    }
}
