package ir.nasim;

import android.view.View;
import android.widget.Magnifier;
import ir.nasim.C16665lf5;

/* renamed from: ir.nasim.mf5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C17256mf5 implements InterfaceC16074kf5 {
    public static final C17256mf5 b = new C17256mf5();
    private static final boolean c = true;

    /* renamed from: ir.nasim.mf5$a */
    public static final class a extends C16665lf5.a {
        public a(Magnifier magnifier) {
            super(magnifier);
        }

        @Override // ir.nasim.C16665lf5.a, ir.nasim.InterfaceC15483jf5
        public void b(long j, long j2, float f) {
            if (!Float.isNaN(f)) {
                d().setZoom(f);
            }
            if ((9223372034707292159L & j2) != 9205357640488583168L) {
                d().show(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)));
            } else {
                d().show(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
            }
        }
    }

    private C17256mf5() {
    }

    @Override // ir.nasim.InterfaceC16074kf5
    public boolean b() {
        return c;
    }

    @Override // ir.nasim.InterfaceC16074kf5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a a(View view, boolean z, long j, float f, float f2, boolean z2, WH1 wh1, float f3) {
        if (z) {
            return new a(new Magnifier(view));
        }
        long jI1 = wh1.I1(j);
        float fW1 = wh1.w1(f);
        float fW12 = wh1.w1(f2);
        Magnifier.Builder builder = new Magnifier.Builder(view);
        if (jI1 != 9205357640488583168L) {
            builder.setSize(AbstractC20723sV3.d(Float.intBitsToFloat((int) (jI1 >> 32))), AbstractC20723sV3.d(Float.intBitsToFloat((int) (jI1 & 4294967295L))));
        }
        if (!Float.isNaN(fW1)) {
            builder.setCornerRadius(fW1);
        }
        if (!Float.isNaN(fW12)) {
            builder.setElevation(fW12);
        }
        if (!Float.isNaN(f3)) {
            builder.setInitialZoom(f3);
        }
        builder.setClippingEnabled(z2);
        return new a(builder.build());
    }
}
