package ir.nasim;

/* renamed from: ir.nasim.Lz3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C6057Lz3 implements InterfaceC21654tu2 {
    private final float a;

    public C6057Lz3(float f) {
        this.a = f;
    }

    @Override // ir.nasim.InterfaceC21654tu2
    public float a(float f) {
        return f / this.a;
    }

    @Override // ir.nasim.InterfaceC21654tu2
    public float b(float f) {
        return f * this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C6057Lz3) && Float.compare(this.a, ((C6057Lz3) obj).a) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.a);
    }

    public String toString() {
        return "LinearFontScaleConverter(fontScale=" + this.a + ')';
    }
}
