package ir.nasim;

import ir.nasim.C4301En7;

/* renamed from: ir.nasim.cW4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10971cW4 {
    private final InterfaceC10355bW4 a;
    private final int b;
    private final int c;
    private int d;
    private int e;
    private float f;
    private float g;

    public C10971cW4(InterfaceC10355bW4 interfaceC10355bW4, int i, int i2, int i3, int i4, float f, float f2) {
        this.a = interfaceC10355bW4;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = f;
        this.g = f2;
    }

    public static /* synthetic */ long l(C10971cW4 c10971cW4, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return c10971cW4.k(j, z);
    }

    public final float a() {
        return this.g;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.e;
    }

    public final int d() {
        return this.c - this.b;
    }

    public final InterfaceC10355bW4 e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10971cW4)) {
            return false;
        }
        C10971cW4 c10971cW4 = (C10971cW4) obj;
        return AbstractC13042fc3.d(this.a, c10971cW4.a) && this.b == c10971cW4.b && this.c == c10971cW4.c && this.d == c10971cW4.d && this.e == c10971cW4.e && Float.compare(this.f, c10971cW4.f) == 0 && Float.compare(this.g, c10971cW4.g) == 0;
    }

    public final int f() {
        return this.b;
    }

    public final int g() {
        return this.d;
    }

    public final float h() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Float.hashCode(this.f)) * 31) + Float.hashCode(this.g);
    }

    public final V05 i(V05 v05) {
        float f = this.f;
        v05.j(ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)));
        return v05;
    }

    public final CK5 j(CK5 ck5) {
        float f = this.f;
        return ck5.s(ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)));
    }

    public final long k(long j, boolean z) {
        if (z) {
            C4301En7.a aVar = C4301En7.b;
            if (C4301En7.g(j, aVar.a())) {
                return aVar.a();
            }
        }
        return AbstractC4535Fn7.b(m(C4301En7.n(j)), m(C4301En7.i(j)));
    }

    public final int m(int i) {
        return i + this.b;
    }

    public final int n(int i) {
        return i + this.d;
    }

    public final float o(float f) {
        return f + this.f;
    }

    public final CK5 p(CK5 ck5) {
        float f = -this.f;
        return ck5.s(ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)));
    }

    public final long q(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - this.f;
        return ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    public final int r(int i) {
        return AbstractC23053wG5.m(i, this.b, this.c) - this.b;
    }

    public final int s(int i) {
        return i - this.d;
    }

    public final float t(float f) {
        return f - this.f;
    }

    public String toString() {
        return "ParagraphInfo(paragraph=" + this.a + ", startIndex=" + this.b + ", endIndex=" + this.c + ", startLineIndex=" + this.d + ", endLineIndex=" + this.e + ", top=" + this.f + ", bottom=" + this.g + ')';
    }
}
