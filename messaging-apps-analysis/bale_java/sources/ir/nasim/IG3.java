package ir.nasim;

/* loaded from: classes3.dex */
public final class IG3 {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    public IG3(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
    }

    public final boolean a() {
        return this.c;
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean c() {
        return this.d;
    }

    public final boolean d() {
        return this.a;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IG3)) {
            return false;
        }
        IG3 ig3 = (IG3) obj;
        return this.a == ig3.a && this.b == ig3.b && this.c == ig3.c && this.d == ig3.d && this.e == ig3.e;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "LocalAudioTrackOptions(noiseSuppression=" + this.a + ", echoCancellation=" + this.b + ", autoGainControl=" + this.c + ", highPassFilter=" + this.d + ", typingNoiseDetection=" + this.e + ')';
    }

    public /* synthetic */ IG3(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, ED1 ed1) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4, (i & 16) != 0 ? true : z5);
    }
}
