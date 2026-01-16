package ir.nasim;

/* renamed from: ir.nasim.xU, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23763xU {
    public final int a;
    public final float b;

    public C23763xU(int i, float f) {
        this.a = i;
        this.b = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C23763xU.class != obj.getClass()) {
            return false;
        }
        C23763xU c23763xU = (C23763xU) obj;
        return this.a == c23763xU.a && Float.compare(c23763xU.b, this.b) == 0;
    }

    public int hashCode() {
        return ((527 + this.a) * 31) + Float.floatToIntBits(this.b);
    }
}
