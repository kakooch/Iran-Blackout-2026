package defpackage;

import android.graphics.Path;
import ir.nasim.AbstractC10274bN4;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21611tq;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.ED1;
import ir.nasim.EnumC12613eu3;
import ir.nasim.InterfaceC10031ax6;
import ir.nasim.WH1;
import ir.nasim.ZG4;

/* loaded from: classes.dex */
final class q implements InterfaceC10031ax6 {
    private final float a;
    private final ZG4 b;

    public /* synthetic */ q(float f, ZG4 zg4, ED1 ed1) {
        this(f, zg4);
    }

    private final float b(long j, ZG4 zg4) {
        if (zg4 == null) {
            return (float) Math.hypot(Float.intBitsToFloat((int) (j >> 32)) / 2.0f, Float.intBitsToFloat((int) (j & 4294967295L)) / 2.0f);
        }
        float fHypot = (float) Math.hypot(Float.intBitsToFloat((int) (zg4.t() >> 32)), Float.intBitsToFloat((int) (zg4.t() & 4294967295L)));
        int i = (int) (j >> 32);
        float fHypot2 = (float) Math.hypot(Float.intBitsToFloat(i) - Float.intBitsToFloat((int) (zg4.t() >> 32)), Float.intBitsToFloat((int) (zg4.t() & 4294967295L)));
        int i2 = (int) (j & 4294967295L);
        return AbstractC23053wG5.d(AbstractC23053wG5.d(AbstractC23053wG5.d(fHypot, fHypot2), (float) Math.hypot(Float.intBitsToFloat((int) (zg4.t() >> 32)), Float.intBitsToFloat(i2) - Float.intBitsToFloat((int) (zg4.t() & 4294967295L)))), (float) Math.hypot(Float.intBitsToFloat(i) - Float.intBitsToFloat((int) (zg4.t() >> 32)), Float.intBitsToFloat(i2) - Float.intBitsToFloat((int) (4294967295L & zg4.t()))));
    }

    @Override // ir.nasim.InterfaceC10031ax6
    public AbstractC10274bN4 a(long j, EnumC12613eu3 enumC12613eu3, WH1 wh1) {
        AbstractC13042fc3.i(enumC12613eu3, "layoutDirection");
        AbstractC13042fc3.i(wh1, "density");
        Path path = new Path();
        ZG4 zg4 = this.b;
        float fIntBitsToFloat = zg4 != null ? Float.intBitsToFloat((int) (zg4.t() >> 32)) : Float.intBitsToFloat((int) (j >> 32)) / 2.0f;
        ZG4 zg42 = this.b;
        path.addCircle(fIntBitsToFloat, zg42 != null ? Float.intBitsToFloat((int) (zg42.t() & 4294967295L)) : Float.intBitsToFloat((int) (j & 4294967295L)) / 2.0f, b(j, this.b) * this.a, Path.Direction.CW);
        return new AbstractC10274bN4.a(AbstractC21611tq.c(path));
    }

    private q(float f, ZG4 zg4) {
        this.a = f;
        this.b = zg4;
    }
}
