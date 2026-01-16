package ir.nasim;

import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* renamed from: ir.nasim.Bq4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC3623Bq4 {
    private static final float e(float f) {
        return (float) (f >= 0.0f ? Math.ceil(f) : Math.floor(f));
    }

    public static final int f(float f) {
        return ((int) e(f)) * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(long j) {
        int i = Math.abs(Float.intBitsToFloat((int) (j >> 32))) >= 0.5f ? 1 : 0;
        return Math.abs(Float.intBitsToFloat((int) (j & 4294967295L))) >= 0.5f ? i | 2 : i;
    }

    public static final InterfaceC24572yq4 h(View view, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 1) != 0) {
            view = (View) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.k());
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1075877987, i, -1, "androidx.compose.ui.platform.rememberNestedScrollInteropConnection (NestedScrollInteropConnection.android.kt:231)");
        }
        boolean zV = interfaceC22053ub1.V(view);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new C3384Aq4(view);
            interfaceC22053ub1.s(objB);
        }
        C3384Aq4 c3384Aq4 = (C3384Aq4) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c3384Aq4;
    }

    private static final float i(int i) {
        return i * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j(int[] iArr, long j) {
        return ZG4.e((Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32)) >= 0.0f ? AbstractC23053wG5.h(i(iArr[0]), Float.intBitsToFloat(r1)) : AbstractC23053wG5.d(i(iArr[0]), Float.intBitsToFloat(r1))) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) >= 0.0f ? AbstractC23053wG5.h(i(iArr[1]), Float.intBitsToFloat(r7)) : AbstractC23053wG5.d(i(iArr[1]), Float.intBitsToFloat(r7))) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(int i) {
        return !AbstractC4559Fq4.e(i, AbstractC4559Fq4.a.c()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float l(float f) {
        return f * (-1.0f);
    }
}
