package ir.nasim;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.transition.Transition;

/* renamed from: ir.nasim.mU0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17147mU0 extends HY7 {
    private float b = 3.0f;

    private static float h(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    @Override // ir.nasim.AbstractC4373Ev7
    public long c(ViewGroup viewGroup, Transition transition, androidx.transition.t tVar, androidx.transition.t tVar2) {
        int i;
        int iRound;
        int iCenterX;
        if (tVar == null && tVar2 == null) {
            return 0L;
        }
        if (tVar2 == null || e(tVar) == 0) {
            i = -1;
        } else {
            tVar = tVar2;
            i = 1;
        }
        int iF = f(tVar);
        int iG = g(tVar);
        Rect rectU = transition.u();
        if (rectU != null) {
            iCenterX = rectU.centerX();
            iRound = rectU.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            int iRound2 = Math.round(r5[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            iRound = Math.round(r5[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            iCenterX = iRound2;
        }
        float fH = h(iF, iG, iCenterX, iRound) / h(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long jT = transition.t();
        if (jT < 0) {
            jT = 300;
        }
        return Math.round(((jT * i) / this.b) * fH);
    }
}
