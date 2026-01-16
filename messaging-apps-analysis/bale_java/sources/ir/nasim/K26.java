package ir.nasim;

/* loaded from: classes3.dex */
public final class K26 {
    private final boolean a;
    private final boolean b;
    private final IG3 c;
    private final C23060wH3 d;
    private final C23718xP e;
    private final FV7 f;
    private final C23060wH3 g;
    private final FV7 h;

    public K26(boolean z, boolean z2, B22 b22, IG3 ig3, C23060wH3 c23060wH3, C23718xP c23718xP, FV7 fv7, C23060wH3 c23060wH32, FV7 fv72) {
        this.a = z;
        this.b = z2;
        this.c = ig3;
        this.d = c23060wH3;
        this.e = c23718xP;
        this.f = fv7;
        this.g = c23060wH32;
        this.h = fv72;
    }

    public static /* synthetic */ K26 b(K26 k26, boolean z, boolean z2, B22 b22, IG3 ig3, C23060wH3 c23060wH3, C23718xP c23718xP, FV7 fv7, C23060wH3 c23060wH32, FV7 fv72, int i, Object obj) {
        B22 b222;
        boolean z3 = (i & 1) != 0 ? k26.a : z;
        boolean z4 = (i & 2) != 0 ? k26.b : z2;
        if ((i & 4) != 0) {
            k26.getClass();
            b222 = null;
        } else {
            b222 = b22;
        }
        return k26.a(z3, z4, b222, (i & 8) != 0 ? k26.c : ig3, (i & 16) != 0 ? k26.d : c23060wH3, (i & 32) != 0 ? k26.e : c23718xP, (i & 64) != 0 ? k26.f : fv7, (i & 128) != 0 ? k26.g : c23060wH32, (i & 256) != 0 ? k26.h : fv72);
    }

    public final K26 a(boolean z, boolean z2, B22 b22, IG3 ig3, C23060wH3 c23060wH3, C23718xP c23718xP, FV7 fv7, C23060wH3 c23060wH32, FV7 fv72) {
        return new K26(z, z2, b22, ig3, c23060wH3, c23718xP, fv7, c23060wH32, fv72);
    }

    public final boolean c() {
        return this.a;
    }

    public final IG3 d() {
        return this.c;
    }

    public final C23718xP e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof K26)) {
            return false;
        }
        K26 k26 = (K26) obj;
        return this.a == k26.a && this.b == k26.b && AbstractC13042fc3.d(null, null) && AbstractC13042fc3.d(this.c, k26.c) && AbstractC13042fc3.d(this.d, k26.d) && AbstractC13042fc3.d(this.e, k26.e) && AbstractC13042fc3.d(this.f, k26.f) && AbstractC13042fc3.d(this.g, k26.g) && AbstractC13042fc3.d(this.h, k26.h);
    }

    public final boolean f() {
        return this.b;
    }

    public final B22 g() {
        return null;
    }

    public final C23060wH3 h() {
        return this.g;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 961;
        IG3 ig3 = this.c;
        int iHashCode2 = (iHashCode + (ig3 == null ? 0 : ig3.hashCode())) * 31;
        C23060wH3 c23060wH3 = this.d;
        int iHashCode3 = (iHashCode2 + (c23060wH3 == null ? 0 : c23060wH3.hashCode())) * 31;
        C23718xP c23718xP = this.e;
        int iHashCode4 = (iHashCode3 + (c23718xP == null ? 0 : c23718xP.hashCode())) * 31;
        FV7 fv7 = this.f;
        int iHashCode5 = (iHashCode4 + (fv7 == null ? 0 : fv7.hashCode())) * 31;
        C23060wH3 c23060wH32 = this.g;
        int iHashCode6 = (iHashCode5 + (c23060wH32 == null ? 0 : c23060wH32.hashCode())) * 31;
        FV7 fv72 = this.h;
        return iHashCode6 + (fv72 != null ? fv72.hashCode() : 0);
    }

    public final FV7 i() {
        return this.h;
    }

    public final C23060wH3 j() {
        return this.d;
    }

    public final FV7 k() {
        return this.f;
    }

    public String toString() {
        return "RoomOptions(adaptiveStream=" + this.a + ", dynacast=" + this.b + ", e2eeOptions=" + ((Object) null) + ", audioTrackCaptureDefaults=" + this.c + ", videoTrackCaptureDefaults=" + this.d + ", audioTrackPublishDefaults=" + this.e + ", videoTrackPublishDefaults=" + this.f + ", screenShareTrackCaptureDefaults=" + this.g + ", screenShareTrackPublishDefaults=" + this.h + ')';
    }

    public /* synthetic */ K26(boolean z, boolean z2, B22 b22, IG3 ig3, C23060wH3 c23060wH3, C23718xP c23718xP, FV7 fv7, C23060wH3 c23060wH32, FV7 fv72, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) == 0 ? z2 : false, (i & 4) != 0 ? null : b22, (i & 8) != 0 ? null : ig3, (i & 16) != 0 ? null : c23060wH3, (i & 32) != 0 ? null : c23718xP, (i & 64) != 0 ? null : fv7, (i & 128) != 0 ? null : c23060wH32, (i & 256) == 0 ? fv72 : null);
    }
}
