package ir.nasim;

import android.graphics.Matrix;

/* renamed from: ir.nasim.iT, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C14775iT extends AbstractC11476d43 {
    private final C14935ij7 a;
    private final long b;
    private final int c;
    private final Matrix d;

    C14775iT(C14935ij7 c14935ij7, long j, int i, Matrix matrix) {
        if (c14935ij7 == null) {
            throw new NullPointerException("Null tagBundle");
        }
        this.a = c14935ij7;
        this.b = j;
        this.c = i;
        if (matrix == null) {
            throw new NullPointerException("Null sensorToBufferTransformMatrix");
        }
        this.d = matrix;
    }

    @Override // ir.nasim.AbstractC11476d43, ir.nasim.W13
    public C14935ij7 b() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC11476d43
    public int d() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC11476d43
    public Matrix e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC11476d43)) {
            return false;
        }
        AbstractC11476d43 abstractC11476d43 = (AbstractC11476d43) obj;
        return this.a.equals(abstractC11476d43.b()) && this.b == abstractC11476d43.getTimestamp() && this.c == abstractC11476d43.d() && this.d.equals(abstractC11476d43.e());
    }

    @Override // ir.nasim.AbstractC11476d43, ir.nasim.W13
    public long getTimestamp() {
        return this.b;
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        long j = this.b;
        return ((((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.c) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        return "ImmutableImageInfo{tagBundle=" + this.a + ", timestamp=" + this.b + ", rotationDegrees=" + this.c + ", sensorToBufferTransformMatrix=" + this.d + "}";
    }
}
