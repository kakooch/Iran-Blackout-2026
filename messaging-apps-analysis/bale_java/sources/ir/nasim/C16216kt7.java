package ir.nasim;

/* renamed from: ir.nasim.kt7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16216kt7 {
    private final EnumC24286yM4 a;
    private long b;

    public /* synthetic */ C16216kt7(EnumC24286yM4 enumC24286yM4, long j, ED1 ed1) {
        this(enumC24286yM4, j);
    }

    private final long b(float f) {
        if (this.a == null) {
            long j = this.b;
            return ZG4.p(this.b, ZG4.r(ZG4.h(j, ZG4.k(j)), f));
        }
        float fD = d(this.b) - (Math.signum(d(this.b)) * f);
        float fC = c(this.b);
        if (this.a == EnumC24286yM4.b) {
            return ZG4.e((Float.floatToRawIntBits(fD) << 32) | (Float.floatToRawIntBits(fC) & 4294967295L));
        }
        return ZG4.e((Float.floatToRawIntBits(fC) << 32) | (Float.floatToRawIntBits(fD) & 4294967295L));
    }

    public final long a(C6616Og5 c6616Og5, float f) {
        long jQ = ZG4.q(this.b, ZG4.p(c6616Og5.h(), c6616Og5.k()));
        this.b = jQ;
        return (this.a == null ? ZG4.k(jQ) : Math.abs(d(jQ))) >= f ? b(f) : ZG4.b.b();
    }

    public final float c(long j) {
        return Float.intBitsToFloat((int) (this.a == EnumC24286yM4.b ? j & 4294967295L : j >> 32));
    }

    public final float d(long j) {
        return Float.intBitsToFloat((int) (this.a == EnumC24286yM4.b ? j >> 32 : j & 4294967295L));
    }

    public final void e() {
        this.b = ZG4.b.c();
    }

    private C16216kt7(EnumC24286yM4 enumC24286yM4, long j) {
        this.a = enumC24286yM4;
        this.b = j;
    }
}
