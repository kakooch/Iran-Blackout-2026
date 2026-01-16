package ir.nasim;

/* renamed from: ir.nasim.Mx1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C6271Mx1 extends AbstractC11317co1 {
    float a = -1.0f;

    @Override // ir.nasim.AbstractC11317co1
    public void a(C24052xx6 c24052xx6, float f, float f2, float f3) {
        c24052xx6.o(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double d = f3;
        double d2 = f2;
        c24052xx6.m((float) (Math.sin(Math.toRadians(f)) * d * d2), (float) (Math.sin(Math.toRadians(90.0f - f)) * d * d2));
    }
}
