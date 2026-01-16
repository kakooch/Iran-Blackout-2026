package ir.nasim;

/* renamed from: ir.nasim.gq8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C13805gq8 extends AbstractC15596jq8 {
    static final C13805gq8 a = new C13805gq8();

    private C13805gq8() {
    }

    @Override // ir.nasim.AbstractC15596jq8
    public final Object a() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // ir.nasim.AbstractC15596jq8
    public final boolean b() {
        return false;
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
