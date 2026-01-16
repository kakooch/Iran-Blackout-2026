package ir.nasim;

/* renamed from: ir.nasim.pp2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19126pp2 implements InterfaceC13157fl1 {
    private final float b;

    public C19126pp2(float f) {
        this.b = f;
    }

    @Override // ir.nasim.InterfaceC13157fl1
    public long a(long j, long j2) {
        float f = this.b;
        return AbstractC16045kc6.a((Float.floatToRawIntBits(f) << 32) | (4294967295L & Float.floatToRawIntBits(f)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C19126pp2) && Float.compare(this.b, ((C19126pp2) obj).b) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.b);
    }

    public String toString() {
        return "FixedScale(value=" + this.b + ')';
    }
}
