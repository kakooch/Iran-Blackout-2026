package ir.nasim;

/* renamed from: ir.nasim.jt7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15625jt7 {
    public static final C20757sZ1 a(float f, float f2, float f3, float f4) {
        return new C20757sZ1(f, f2, f3, f4, true, null);
    }

    public static final long b(int i, int i2, int i3, int i4) {
        if (!(i >= 0 && i < 32768)) {
            M73.a("Start must be in the range of 0 .. 32767");
        }
        if (!(i2 >= 0 && i2 < 32768)) {
            M73.a("Top must be in the range of 0 .. 32767");
        }
        if (!(i3 >= 0 && i3 < 32768)) {
            M73.a("End must be in the range of 0 .. 32767");
        }
        if (!(i4 >= 0 && i4 < 32768)) {
            M73.a("Bottom must be in the range of 0 .. 32767");
        }
        return AbstractC15034it7.d(AbstractC15034it7.a.c(i, i2, i3, i4, true));
    }

    public static /* synthetic */ long c(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return b(i, i2, i3, i4);
    }
}
