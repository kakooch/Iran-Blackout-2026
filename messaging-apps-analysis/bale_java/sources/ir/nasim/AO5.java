package ir.nasim;

/* loaded from: classes2.dex */
public final class AO5 {
    public static final AO5 b = new AO5(false);
    public final boolean a;

    public AO5(boolean z) {
        this.a = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && AO5.class == obj.getClass() && this.a == ((AO5) obj).a;
    }

    public int hashCode() {
        return !this.a ? 1 : 0;
    }
}
