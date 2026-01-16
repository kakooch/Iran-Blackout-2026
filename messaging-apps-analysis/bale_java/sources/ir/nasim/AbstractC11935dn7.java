package ir.nasim;

import android.graphics.RectF;
import android.text.Layout;
import ir.nasim.C13249fu3;

/* renamed from: ir.nasim.dn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11935dn7 {
    private static final float a(int i, int i2, float[] fArr) {
        return fArr[(i - i2) * 2];
    }

    private static final float b(int i, int i2, float[] fArr) {
        return fArr[((i - i2) * 2) + 1];
    }

    private static final int c(C13249fu3.a aVar, RectF rectF, int i, int i2, int i3, float f, float f2, float[] fArr, InterfaceC24524yl6 interfaceC24524yl6, InterfaceC14603iB2 interfaceC14603iB2) {
        int iB;
        int iC;
        if (!g(rectF, f, f2)) {
            return -1;
        }
        if ((aVar.c() || rectF.right < f2) && (!aVar.c() || rectF.left > f)) {
            iB = aVar.b();
            int iA = aVar.a();
            while (iA - iB > 1) {
                int i4 = (iA + iB) / 2;
                float fA = a(i4, i, fArr);
                if ((aVar.c() || fA <= rectF.right) && (!aVar.c() || fA >= rectF.left)) {
                    iB = i4;
                } else {
                    iA = i4;
                }
            }
            if (aVar.c()) {
                iB = iA;
            }
        } else {
            iB = aVar.a() - 1;
        }
        int iB2 = interfaceC24524yl6.b(iB + 1);
        if (iB2 == -1 || (iC = interfaceC24524yl6.c(iB2)) <= aVar.b()) {
            return -1;
        }
        int iE = AbstractC23053wG5.e(iB2, aVar.b());
        int i5 = AbstractC23053wG5.i(iC, aVar.a());
        RectF rectF2 = new RectF(0.0f, i2, 0.0f, i3);
        while (true) {
            rectF2.left = aVar.c() ? a(i5 - 1, i, fArr) : a(iE, i, fArr);
            rectF2.right = aVar.c() ? b(iE, i, fArr) : b(i5 - 1, i, fArr);
            if (((Boolean) interfaceC14603iB2.invoke(rectF2, rectF)).booleanValue()) {
                return i5;
            }
            i5 = interfaceC24524yl6.d(i5);
            if (i5 == -1 || i5 <= aVar.b()) {
                break;
            }
            iE = AbstractC23053wG5.e(interfaceC24524yl6.b(i5), aVar.b());
        }
        return -1;
    }

    public static final int[] d(C10550bn7 c10550bn7, Layout layout, C13249fu3 c13249fu3, RectF rectF, int i, InterfaceC14603iB2 interfaceC14603iB2) {
        int i2;
        int i3;
        InterfaceC24524yl6 ka8 = i == 1 ? new Ka8(c10550bn7.G(), c10550bn7.I()) : AbstractC25118zl6.a(c10550bn7.G(), c10550bn7.H());
        int lineForVertical = layout.getLineForVertical((int) rectF.top);
        if (rectF.top > c10550bn7.l(lineForVertical) && (lineForVertical = lineForVertical + 1) >= c10550bn7.m()) {
            return null;
        }
        int i4 = lineForVertical;
        int lineForVertical2 = layout.getLineForVertical((int) rectF.bottom);
        if (lineForVertical2 == 0 && rectF.bottom < c10550bn7.w(0)) {
            return null;
        }
        int iF = f(c10550bn7, layout, c13249fu3, i4, rectF, ka8, interfaceC14603iB2, true);
        while (true) {
            i2 = i4;
            i3 = iF;
            if (i3 != -1 || i2 >= lineForVertical2) {
                break;
            }
            i4 = i2 + 1;
            iF = f(c10550bn7, layout, c13249fu3, i4, rectF, ka8, interfaceC14603iB2, true);
        }
        if (i3 == -1) {
            return null;
        }
        int iF2 = f(c10550bn7, layout, c13249fu3, lineForVertical2, rectF, ka8, interfaceC14603iB2, false);
        while (iF2 == -1 && i2 < lineForVertical2) {
            lineForVertical2--;
            iF2 = f(c10550bn7, layout, c13249fu3, lineForVertical2, rectF, ka8, interfaceC14603iB2, false);
        }
        if (iF2 == -1) {
            return null;
        }
        return new int[]{ka8.b(i3 + 1), ka8.c(iF2 - 1)};
    }

    private static final int e(C13249fu3.a aVar, RectF rectF, int i, int i2, int i3, float f, float f2, float[] fArr, InterfaceC24524yl6 interfaceC24524yl6, InterfaceC14603iB2 interfaceC14603iB2) {
        int iB;
        int iB2;
        if (!g(rectF, f, f2)) {
            return -1;
        }
        if ((aVar.c() || rectF.left > f) && (!aVar.c() || rectF.right < f2)) {
            iB = aVar.b();
            int iA = aVar.a();
            while (iA - iB > 1) {
                int i4 = (iA + iB) / 2;
                float fA = a(i4, i, fArr);
                if ((aVar.c() || fA <= rectF.left) && (!aVar.c() || fA >= rectF.right)) {
                    iB = i4;
                } else {
                    iA = i4;
                }
            }
            if (aVar.c()) {
                iB = iA;
            }
        } else {
            iB = aVar.b();
        }
        int iC = interfaceC24524yl6.c(iB);
        if (iC == -1 || (iB2 = interfaceC24524yl6.b(iC)) >= aVar.a()) {
            return -1;
        }
        int iE = AbstractC23053wG5.e(iB2, aVar.b());
        int i5 = AbstractC23053wG5.i(iC, aVar.a());
        RectF rectF2 = new RectF(0.0f, i2, 0.0f, i3);
        while (true) {
            rectF2.left = aVar.c() ? a(i5 - 1, i, fArr) : a(iE, i, fArr);
            rectF2.right = aVar.c() ? b(iE, i, fArr) : b(i5 - 1, i, fArr);
            if (((Boolean) interfaceC14603iB2.invoke(rectF2, rectF)).booleanValue()) {
                return iE;
            }
            iE = interfaceC24524yl6.a(iE);
            if (iE == -1 || iE >= aVar.a()) {
                break;
            }
            i5 = AbstractC23053wG5.i(interfaceC24524yl6.c(iE), aVar.a());
        }
        return -1;
    }

    private static final int f(C10550bn7 c10550bn7, Layout layout, C13249fu3 c13249fu3, int i, RectF rectF, InterfaceC24524yl6 interfaceC24524yl6, InterfaceC14603iB2 interfaceC14603iB2, boolean z) {
        int i2;
        C13249fu3.a[] aVarArr;
        int i3;
        int iC;
        int lineTop = layout.getLineTop(i);
        int lineBottom = layout.getLineBottom(i);
        int lineStart = layout.getLineStart(i);
        int lineEnd = layout.getLineEnd(i);
        if (lineStart == lineEnd) {
            return -1;
        }
        float[] fArr = new float[(lineEnd - lineStart) * 2];
        c10550bn7.b(i, fArr);
        C13249fu3.a[] aVarArrD = c13249fu3.d(i);
        C23231wa3 c23231wa3G0 = z ? AbstractC10242bK.g0(aVarArrD) : AbstractC23053wG5.r(AbstractC10242bK.l0(aVarArrD), 0);
        int iO = c23231wa3G0.o();
        int iT = c23231wa3G0.t();
        int iV = c23231wa3G0.v();
        if ((iV <= 0 || iO > iT) && (iV >= 0 || iT > iO)) {
            return -1;
        }
        int i4 = iO;
        while (true) {
            C13249fu3.a aVar = aVarArrD[i4];
            float fA = aVar.c() ? a(aVar.a() - 1, lineStart, fArr) : a(aVar.b(), lineStart, fArr);
            float fB = aVar.c() ? b(aVar.b(), lineStart, fArr) : b(aVar.a() - 1, lineStart, fArr);
            if (z) {
                i2 = i4;
                aVarArr = aVarArrD;
                i3 = iT;
                iC = e(aVar, rectF, lineStart, lineTop, lineBottom, fA, fB, fArr, interfaceC24524yl6, interfaceC14603iB2);
            } else {
                i2 = i4;
                aVarArr = aVarArrD;
                i3 = iT;
                iC = c(aVar, rectF, lineStart, lineTop, lineBottom, fA, fB, fArr, interfaceC24524yl6, interfaceC14603iB2);
            }
            if (iC >= 0) {
                return iC;
            }
            if (i2 == i3) {
                return -1;
            }
            i4 = i2 + iV;
            iT = i3;
            aVarArrD = aVarArr;
        }
    }

    private static final boolean g(RectF rectF, float f, float f2) {
        return f2 >= rectF.left && f <= rectF.right;
    }
}
