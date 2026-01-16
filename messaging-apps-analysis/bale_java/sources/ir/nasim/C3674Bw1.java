package ir.nasim;

import android.view.inputmethod.CursorAnchorInfo;

/* renamed from: ir.nasim.Bw1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C3674Bw1 {
    public static final C3674Bw1 a = new C3674Bw1();

    private C3674Bw1() {
    }

    public static final CursorAnchorInfo.Builder a(CursorAnchorInfo.Builder builder, C13774gn7 c13774gn7, CK5 ck5) {
        int iR;
        int iR2;
        if (!ck5.p() && (iR = c13774gn7.r(ck5.l())) <= (iR2 = c13774gn7.r(ck5.e()))) {
            while (true) {
                builder.addVisibleLineBounds(c13774gn7.s(iR), c13774gn7.v(iR), c13774gn7.t(iR), c13774gn7.m(iR));
                if (iR == iR2) {
                    break;
                }
                iR++;
            }
        }
        return builder;
    }
}
