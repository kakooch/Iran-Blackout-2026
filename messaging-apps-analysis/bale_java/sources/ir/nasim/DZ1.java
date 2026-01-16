package ir.nasim;

/* loaded from: classes2.dex */
public abstract class DZ1 {
    public static final long a(C23810xZ1 c23810xZ1) {
        float x = c23810xZ1.a().getX();
        float y = c23810xZ1.a().getY();
        return ZG4.e((Float.floatToRawIntBits(x) << 32) | (Float.floatToRawIntBits(y) & 4294967295L));
    }
}
