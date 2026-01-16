package ir.nasim;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.transition.Transition;

/* loaded from: classes2.dex */
public class KB6 extends HY7 {
    private float b = 3.0f;
    private int c = 80;

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int h(android.view.View r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14) {
        /*
            r5 = this;
            int r0 = r5.c
            r1 = 8388611(0x800003, float:1.1754948E-38)
            r2 = 1
            r3 = 3
            r4 = 5
            if (r0 != r1) goto L14
            int r6 = ir.nasim.AbstractC12990fW7.A(r6)
            if (r6 != r2) goto L12
        L10:
            r0 = r4
            goto L20
        L12:
            r0 = r3
            goto L20
        L14:
            r1 = 8388613(0x800005, float:1.175495E-38)
            if (r0 != r1) goto L20
            int r6 = ir.nasim.AbstractC12990fW7.A(r6)
            if (r6 != r2) goto L10
            goto L12
        L20:
            if (r0 == r3) goto L46
            if (r0 == r4) goto L3e
            r6 = 48
            if (r0 == r6) goto L36
            r6 = 80
            if (r0 == r6) goto L2e
            r6 = 0
            goto L4d
        L2e:
            int r8 = r8 - r12
            int r9 = r9 - r7
            int r6 = java.lang.Math.abs(r9)
            int r6 = r6 + r8
            goto L4d
        L36:
            int r14 = r14 - r8
            int r9 = r9 - r7
            int r6 = java.lang.Math.abs(r9)
            int r6 = r6 + r14
            goto L4d
        L3e:
            int r7 = r7 - r11
            int r10 = r10 - r8
            int r6 = java.lang.Math.abs(r10)
            int r6 = r6 + r7
            goto L4d
        L46:
            int r13 = r13 - r7
            int r10 = r10 - r8
            int r6 = java.lang.Math.abs(r10)
            int r6 = r6 + r13
        L4d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KB6.h(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    private int i(ViewGroup viewGroup) {
        int i = this.c;
        return (i == 3 || i == 5 || i == 8388611 || i == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight();
    }

    @Override // ir.nasim.AbstractC4373Ev7
    public long c(ViewGroup viewGroup, Transition transition, androidx.transition.t tVar, androidx.transition.t tVar2) {
        int i;
        int iCenterX;
        int iCenterY;
        androidx.transition.t tVar3 = tVar;
        if (tVar3 == null && tVar2 == null) {
            return 0L;
        }
        Rect rectU = transition.u();
        if (tVar2 == null || e(tVar3) == 0) {
            i = -1;
        } else {
            tVar3 = tVar2;
            i = 1;
        }
        int iF = f(tVar3);
        int iG = g(tVar3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(viewGroup.getTranslationX());
        int iRound2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = iRound + viewGroup.getWidth();
        int height = iRound2 + viewGroup.getHeight();
        if (rectU != null) {
            iCenterX = rectU.centerX();
            iCenterY = rectU.centerY();
        } else {
            iCenterX = (iRound + width) / 2;
            iCenterY = (iRound2 + height) / 2;
        }
        float fH = h(viewGroup, iF, iG, iCenterX, iCenterY, iRound, iRound2, width, height) / i(viewGroup);
        long jT = transition.t();
        if (jT < 0) {
            jT = 300;
        }
        return Math.round(((jT * i) / this.b) * fH);
    }

    public void j(int i) {
        this.c = i;
    }
}
