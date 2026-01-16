package j$.util.function;

/* loaded from: classes2.dex */
public final /* synthetic */ class m implements Predicate {
    public final /* synthetic */ Predicate a;
    public final /* synthetic */ Predicate b;

    public /* synthetic */ m(Predicate predicate, Predicate predicate2) {
        this.a = predicate;
        this.b = predicate2;
    }

    @Override // j$.util.function.Predicate
    public Predicate a(Predicate predicate) {
        predicate.getClass();
        return new m(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public Predicate b(Predicate predicate) {
        predicate.getClass();
        return new o(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public Predicate negate() {
        return new n(this);
    }

    @Override // j$.util.function.Predicate
    public final boolean test(Object obj) {
        return this.a.test(obj) || this.b.test(obj);
    }
}
