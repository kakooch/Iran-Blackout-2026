package ir.nasim;

/* renamed from: ir.nasim.in7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14975in7 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long b(long j, CK5 ck5) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        return ZG4.e((Float.floatToRawIntBits(Float.intBitsToFloat(i) < ck5.i() ? ck5.i() : Float.intBitsToFloat(i) > ck5.j() ? ck5.j() : Float.intBitsToFloat(i)) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat(i2) < ck5.l() ? ck5.l() : Float.intBitsToFloat(i2) > ck5.e() ? ck5.e() : Float.intBitsToFloat(i2)) & 4294967295L));
    }
}
