package androidx.compose.ui.viewinterop;

import android.view.View;
import ir.nasim.AbstractC12000du3;
import ir.nasim.AbstractC4559Fq4;
import ir.nasim.C3419Au3;
import ir.nasim.InterfaceC24572yq4;

/* loaded from: classes2.dex */
public abstract class b {
    private static final a a = new a();

    public static final class a implements InterfaceC24572yq4 {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view, C3419Au3 c3419Au3) {
        long jE = AbstractC12000du3.e(c3419Au3.s());
        int iRound = Math.round(Float.intBitsToFloat((int) (jE >> 32)));
        int iRound2 = Math.round(Float.intBitsToFloat((int) (jE & 4294967295L)));
        view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float g(int i) {
        return i * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float h(float f) {
        return f * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(int i) {
        return i == 0 ? AbstractC4559Fq4.a.c() : AbstractC4559Fq4.a.b();
    }
}
